package com.fenoreste.rest.dao;

import com.fenoreste.rest.ResponseDTO.FeesDueData;
import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.ResponseDTO.AccountDetailsDTO;
import com.fenoreste.rest.ResponseDTO.LoanDTO;
import com.fenoreste.rest.ResponseDTO.LoanFee;
import com.fenoreste.rest.ResponseDTO.LoanPayment;
import com.fenoreste.rest.ResponseDTO.LoanRate;
import com.fenoreste.rest.entidades.Amortizaciones;
import com.fenoreste.rest.entidades.AuxiliaresPK;
import com.fenoreste.rest.entidades.Auxiliares;
import com.fenoreste.rest.entidades.AuxiliaresD;
import com.fenoreste.rest.entidades.Catalog_Status_Bankingly;
import com.fenoreste.rest.entidades.LoanRates;
import com.fenoreste.rest.entidades.Loan_Fee_Status;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public abstract class FacadeLoan<T> {

    Calendar calendar = Calendar.getInstance();
    Date hoy = calendar.getTime();
    private static EntityManagerFactory emf;

    public FacadeLoan(Class<T> entityClass) {
        emf = AbstractFacade.conexion();
    }
    EntityManager em = null;

    public LoanDTO Loan(String productBankIdentifier) {
        em = emf.createEntityManager();
        int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
        int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
        int a = Integer.parseInt(productBankIdentifier.substring(11, 19));

        AccountDetailsDTO cuenta = null;
        System.out.println("O:" + o + ",P:" + p + ",A:" + a);
        LoanDTO dto = null;
        try {
            AuxiliaresPK auxpk = new AuxiliaresPK(o, p, a);
            Auxiliares aux = em.find(Auxiliares.class, auxpk);
            if (aux.getEstatus() == 2) {
                Catalog_Status_Bankingly sts = em.find(Catalog_Status_Bankingly.class, Integer.parseInt(aux.getEstatus().toString()));
                Double currentBalance = Double.parseDouble(aux.getSaldo().toString());
                Double currentRate = Double.parseDouble(aux.getTasaio().toString()) + Double.parseDouble(aux.getTasaim().toString()) + Double.parseDouble(aux.getTasaiod().toString());
                int loanStatusId = sts.getProductstatusid();

                Query query = em.createNativeQuery("SELECT count(*) FROM amortizaciones WHERE idorigenp=" + o
                        + " AND idproducto=" + p
                        + " AND idauxiliar=" + a
                        + " AND todopag=true");
                int amPag = Integer.parseInt(String.valueOf(query.getSingleResult()));

                Query query1 = em.createNativeQuery("SELECT count(*) FROM amortizaciones WHERE idorigenp=" + o
                        + " AND idproducto=" + p
                        + " AND idauxiliar=" + a);
                int tam = Integer.parseInt(String.valueOf(query1.getSingleResult()));
                System.out.println("Amortizaciones Pagadas:" + amPag);
                dto = new LoanDTO(
                        productBankIdentifier,
                        currentBalance,
                        currentRate,
                        RSFeesDue(o, p, a),
                        RSFeesDueData(o, p, a),//Campo FeesDueData
                        loanStatusId,
                        RSLoanFee(o, p, a),
                        Double.parseDouble(aux.getMontoprestado().toString()),
                        RSOverdueDays(o, p, a),
                        amPag,
                        0.0,
                        0.0,
                        productBankIdentifier,
                        tam,
                        true,
                        null,
                        null,
                        null);
                System.out.println("LoanPre:" + dto);
            }
        } catch (Exception e) {
            em.clear();
            em.close();
            System.out.println("Error en GetAccountDetails:" + e.getMessage());
        }
        em.close();
        return dto;//cuenta;

    }

    public LoanFee LoanFee(String productBankIdentifier, int feeNumber) {
        EntityManager em = emf.createEntityManager();
        LoanFee loanFee = null;
        int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
        int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
        int a = Integer.parseInt(productBankIdentifier.substring(11, 19));

        try {
            AuxiliaresPK pk = new AuxiliaresPK(o, p, a);
            Auxiliares aux = em.find(Auxiliares.class, pk);
            //Obtengo informacion con el sai_auxiliar hasta la fecha actual, si hay dudas checar el catalogo o atributos que devuelve la funcion
            String sai_auxiliar = "SELECT * FROM sai_auxiliar(" + o + "," + p + "," + a + ",(SELECT date(fechatrabajo) FROM origenes limit 1))";
            Query RsSai = em.createNativeQuery(sai_auxiliar);
            String sai = RsSai.getSingleResult().toString();
            String[] parts = sai.split("\\|");
            List list = Arrays.asList(parts);
            //Obtengo la amortizacion que se vence
            String consultaA = "SELECT * FROM amortizaciones WHERE idorigenp=" + o
                    + " AND idproducto=" + p
                    + " AND idauxiliar=" + a
                    + " AND idorigenp+idproducto+idauxiliar+idamortizacion=" + feeNumber;
            System.out.println("La consulta es:" + consultaA);
            Query queryA = em.createNativeQuery(consultaA, Amortizaciones.class);
            Amortizaciones amm = (Amortizaciones) queryA.getSingleResult();
            Double iovencido = Double.parseDouble(list.get(6).toString()) + Double.parseDouble(list.get(17).toString());
            Double imvencido = Double.parseDouble(list.get(15).toString()) + Double.parseDouble(list.get(18).toString());

            int loanfeests = 0;
            if (Double.parseDouble(amm.getAbono().toString()) == Double.parseDouble(amm.getAbonopag().toString())) {
                loanfeests = 3;
            } else if (Double.parseDouble(amm.getAbono().toString()) > Double.parseDouble(amm.getAbonopag().toString())
                    && amm.getTodopag() == false) {
                loanfeests = 1;
            } else if (!list.get(14).toString().equals("C")) {
                loanfeests = 2;
            }

            Loan_Fee_Status loanf = em.find(Loan_Fee_Status.class, loanfeests);

            Double abonoT = Double.parseDouble(amm.getAbono().toString()) + iovencido + imvencido;
            Date d = amm.getVence();
            loanFee = new LoanFee(
                    Double.parseDouble(aux.getSaldo().toString()),//Saldo o balance del prestamo principal
                    amm.getAmortizacionesPK().getIdorigenp() + amm.getAmortizacionesPK().getIdproducto() + amm.getAmortizacionesPK().getIdauxiliar() + amm.getAmortizacionesPK().getIdamortizacion(),
                    Double.parseDouble(amm.getAbono().toString()),
                    amm.getVence().toString(),
                    iovencido,
                    imvencido,
                    loanf.getId(),
                    Double.parseDouble(amm.getAbono().toString()),
                    abonoT);
        } catch (Exception e) {
            System.out.println("Error en LoanFee:" + e.getMessage());
        }

        return loanFee;
    }

    public List<LoanFee> LoanFees(String productBankIdentifier, int feesStatus, int pageSize, int pageStartIndex,String order) {
        EntityManager em = emf.createEntityManager();
        LoanFee loanFee = null;
        System.out.println("entro y paso");
        int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
        int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
        int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
        System.out.println("opa:"+o+","+p+","+a);
        List<Amortizaciones> ListaAmortizaciones = new ArrayList<>();
        System.out.println("paso");
        System.out.println(o+",p:"+p+",a:"+a);
        List<LoanFee> listaFees = new ArrayList<>();
        try {
            System.out.println("dento de try");
            
            AuxiliaresPK pk = new AuxiliaresPK(o, p, a);
            Auxiliares aux = em.find(Auxiliares.class, pk);
                System.out.println("todavia:");
            //Obtengo informacion con el sai_auxiliar hasta la fecha actual, si hay dudas checar el catalogo o atributos que devuelve la funcion
            String sai_auxiliar = "SELECT * FROM sai_auxiliar(" + o + "," + p + "," + a + ",(SELECT date(fechatrabajo) FROM origenes limit 1))";
            Query RsSai = em.createNativeQuery(sai_auxiliar);
            String sai = RsSai.getSingleResult().toString();
                System.out.println("sai:"+sai);
            String[] parts = sai.split("\\|");
            List list = Arrays.asList(parts);
            String complemento = "";
            
            if (feesStatus == 0 && order.equalsIgnoreCase("feenumber")) {
                complemento="ORDER BY (idorigenp+idproducto+idauxiliar+idamortizacion) ASC";
            } else if (feesStatus == 1 && order.equalsIgnoreCase("feenumber")) {
                complemento = "AND todopag=true ORDER BY (idorigenp+idproducto+idauxiliar+idamortizacion) ASC";
            } else if(feesStatus==1 && order.equals("")){
              complemento="AND todopag=true";
            }else if (feesStatus == 2 && order.equalsIgnoreCase("feenumber")) {
                complemento = "AND todopag=false ORDER BY (idorigenp+idproducto+idauxiliar+idamortizacion) ASC";

            }else if(feesStatus==2 && order.equals("")){
                complemento="AND todopag=false";
            }
            System.out.println("complemento:"+complemento);
            //Obtengo la amortizacion que se vence
            String consultaA = "SELECT * FROM amortizaciones WHERE idorigenp=" + o
                    + " AND idproducto=" + p
                    + " AND idauxiliar=" + a +" "+ complemento;
            System.out.println("La consulta es:" + consultaA);
            int inicioB = 0;
            /*
            if (pageStartIndex == 1 || pageStartIndex == 0) {
                inicioB = 0;
            } else if (pageStartIndex > 1) {
                inicioB = ((pageStartIndex -1) * pageSize);
                               
            }*/               
             inicioB = ((pageStartIndex * pageSize) - pageSize);
            if(inicioB<0){
                inicioB=0;
            }
            Query queryA = em.createNativeQuery(consultaA, Amortizaciones.class);
            queryA.setFirstResult(pageStartIndex);
            queryA.setMaxResults(pageSize);
            ListaAmortizaciones = queryA.getResultList();
            Double iovencido = Double.parseDouble(list.get(6).toString()) + Double.parseDouble(list.get(17).toString());
            Double imvencido = Double.parseDouble(list.get(15).toString()) + Double.parseDouble(list.get(18).toString());

            for (int x = 0; x < ListaAmortizaciones.size(); x++) {
                Amortizaciones amm = ListaAmortizaciones.get(x);
                int loanfeests = 0;
                if (Double.parseDouble(amm.getAbono().toString()) == Double.parseDouble(amm.getAbonopag().toString())) {
                    loanfeests = 3;
                } else if (Double.parseDouble(amm.getAbono().toString()) > Double.parseDouble(amm.getAbonopag().toString())
                        && amm.getTodopag() == false) {
                    loanfeests = 1;
                } else if (!list.get(14).toString().equals("C")) {
                    loanfeests = 2;
                }
                Loan_Fee_Status loanf = em.find(Loan_Fee_Status.class, loanfeests);

                Double abonoT = Double.parseDouble(amm.getAbono().toString()) + iovencido + imvencido;
                Date d = amm.getVence();
                loanFee = new LoanFee(
                        Double.parseDouble(aux.getSaldo().toString()),//Saldo o balance del prestamo principal
                        amm.getAmortizacionesPK().getIdorigenp() + amm.getAmortizacionesPK().getIdproducto() + amm.getAmortizacionesPK().getIdauxiliar() + amm.getAmortizacionesPK().getIdamortizacion(),
                        Double.parseDouble(amm.getAbono().toString()),
                        amm.getVence().toString(),
                        iovencido,
                        imvencido,
                        loanf.getId(),
                        Double.parseDouble(amm.getAbono().toString()),
                        abonoT);
                listaFees.add(loanFee);
            }
            
        } catch (Exception e) {
            System.out.println("Error en LoanFee:" + e.getMessage());
        }
        System.out.println("ListaFees:" + listaFees);
        return listaFees;
    }

    public List<LoanRate> LoanRates(String productBankIdentifier, int pageSize, int pageStartIndex) {
        EntityManager em = emf.createEntityManager();
        LoanRate loanRate = null;
        int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
        int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
        int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
        List<LoanRate> listaRates = new ArrayList<>();
        List<LoanRate>loanr=new ArrayList<LoanRate>();
        try {
            String consulta = "SELECT fechaactivacion,tasaio,tasaim,tasaiod FROM auxiliares WHERE"
                    + " idorigenp=" + o + " AND"
                    + " idproducto=" + p + " AND"
                    + " idauxiliar=" + a;
            System.out.println("Consulta:" + consulta);
            
            Query queryA = em.createNativeQuery(consulta);
            List<Object[]> MiLista = queryA.getResultList();
            
            try{
             EntityTransaction tr1=em.getTransaction();
             tr1.begin();
             em.createNativeQuery("DELETE FROM loanrates WHERE opa='"+o+"-"+p+"-"+a+"'").executeUpdate();
             if(tr1.isActive()){
                 tr1.commit();
             }
            }catch(Exception e){
                System.out.println("Error en eliminar:"+e.getMessage());
            }
            for (Object[] lista : MiLista) {
                
                for (int x = 0; x < lista.length; x++) {
                    System.out.println("Obj:"+lista[x]);
                    if (x > 0) {                       
                        try{
                            System.out.println("Listax:"+lista[x]);
                        double xc=Double.parseDouble(lista[x].toString());
                            
                        EntityTransaction tr=em.getTransaction();
                        LoanRates lor=new LoanRates();
                        tr.begin();
                        lor.setOpa(o+"-"+p+"-"+a);
                        lor.setInitialdate(lista[0].toString());
                        lor.setRate(xc);
                        em.persist(lor);
                        if(tr.isActive()){
                            tr.commit();
                            em.clear();
                        }                        
                        }catch(Exception e){
                            System.out.println("Error:"+e.getMessage());
                        }
                    }
                }
            }
            
            try{
            String c="SELECT * FROM loanrates WHERE opa='"+o+"-"+p+"-"+a+"'";
            Query queryLoan=em.createNativeQuery(c,LoanRates.class);
            queryLoan.setFirstResult(pageStartIndex);
            queryLoan.setMaxResults(pageSize);
            List<LoanRates>listaRatess=queryLoan.getResultList();
            for(int j=0;j<listaRatess.size();j++){
                LoanRates loanrtt=listaRatess.get(j);
                loanRate=new LoanRate(loanrtt.getInitialdate(),loanrtt.getRate());
                System.out.println("LoanRattt:"+loanrtt);
                listaRates.add(loanRate);
            }
                System.out.println("ListaRte:"+listaRates);
            }catch(Exception e){
                System.out.println("Error en obtener loanRates:"+e.getMessage());
            }
            /*Map<Integer, String> map = IntStream
                    .range(pageStartIndex, listaRates.size())
                    .boxed()
                    .collect(groupingBy(
                            i -> i / pageSize,
                            mapping(i -> listaRates.get((int) i).toString(), joining(","))
                    ));
            
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<String> list = new ArrayList<String>(map.values());
            
            String[]arreglo=map.get(pageStartIndex).split("},");
            System.out.println("listaReal:"+arreglo);
            for(int j=0;j<arreglo.length;j++){
                String[]jk=arreglo[j].split(",");
                String initialDates=jk[0];
                String rates=jk[1];
                String[]rate=rates.split("=");
                String[] initialDate=initialDates.split("=");
                String initialDateR=initialDate[1];
                Double rateR=Double.parseDouble(rate[1].replace("}",""));
                LoanRate loanrr=new LoanRate(initialDateR,rateR);
                loanr.add(loanrr);
                
            }
         */
      
        } catch (Exception e) {
            System.out.println("Error en LoanFee:" + e.getMessage());
        }
        em.close();

        return listaRates;
    }

    public List<LoanPayment>loanPayments(String productBankIdentifier,int pageSize,int startPageIndex){
        EntityManager em=emf.createEntityManager();
        int o = Integer.parseInt(productBankIdentifier.substring(0, 6));
        int p = Integer.parseInt(productBankIdentifier.substring(6, 11));
        int a = Integer.parseInt(productBankIdentifier.substring(11, 19));
        
        List<LoanPayment>listPayment=new ArrayList<LoanPayment>();
        LoanPayment loanp=null;
        
        try{
            AuxiliaresPK auxpk=new AuxiliaresPK(o,p,a);
            Auxiliares auxiliares=em.find(Auxiliares.class,auxpk);
            String con="SELECT * FROM auxiliares_d WHERE idorigenp="+o+" AND idproducto="+p+" AND idauxiliar="+a+" AND cargoabono=1";
            System.out.println("CON:"+con);
            Query query=em.createNativeQuery(con,AuxiliaresD.class);
            query.setFirstResult(startPageIndex);
            query.setMaxResults(pageSize);
            List<AuxiliaresD>MiLista=query.getResultList();
            for(int i=0;i<MiLista.size();i++){
                AuxiliaresD io=MiLista.get(i);
                System.out.println("io:"+io);
            }
            
        String sai_auxiliar = "SELECT * FROM sai_auxiliar(" + o + "," + p + "," + a + ",(SELECT date(fechatrabajo) FROM origenes limit 1))";
        Double montoVencido = 0.0;
        int feeNumber=0;
        try {
            Query RsSai = em.createNativeQuery(sai_auxiliar);
            String sai = RsSai.getSingleResult().toString();
            String[] parts = sai.split("\\|");
            List list = Arrays.asList(parts);
            montoVencido= Double.parseDouble(list.get(4).toString());
            
            String fechaNumber="";
            if(!list.get(8).toString().equals("")){
                fechaNumber=list.get(8).toString();
                String c=("SELECT idamortizacion FROM amortizaciones WHERE "
                                                + "(idorigenp,idproducto,idauxiliar)=("+o+","+p+","+a+") AND vence='"+fechaNumber+"'");
                
                System.out.println("FechaNumber:"+fechaNumber);
                Query queryfe=em.createNativeQuery(c);
                feeNumber=Integer.parseInt(String.valueOf(queryfe.getSingleResult()));
                System.out.println("Consulta e:"+c);
            }else {
             String c1=("SELECT idamortizacion FROM amortizaciones WHERE "
                                                + "(idorigenp,idproducto,idauxiliar)="+(o+","+p+","+a)+"ORDER BY vence ASC limit 1");
             Query queryfecha=em.createNativeQuery(c1);
             feeNumber=Integer.parseInt(String.valueOf(queryfecha.getSingleResult()));
                System.out.println("Consulta e1:"+c1);
            }
        } catch (Exception e) {
            System.out.println("Error al correr SAI:" + e.getMessage());
            
        }
        int payEstatus=0;
        for(int i=0;i<MiLista.size();i++){
            System.out.println("aun");
                AuxiliaresD auxd=MiLista.get(i);
                if(Double.parseDouble(auxd.getSaldoec().toString())==0){
                    payEstatus=1;
                }else{
                    payEstatus=2;
                }
                loanp=new LoanPayment(  Double.parseDouble(auxiliares.getSaldo().toString()),
                                        0,
                                        payEstatus,
                                        Double.parseDouble(auxd.getMontoio().toString()),
                                        Double.parseDouble(auxd.getMontoiva().toString()),
                                        Double.parseDouble(auxd.getMontoim().toString()),
                                        String.valueOf(auxd.getAuxiliaresDPK().getFecha()),
                                        Double.parseDouble(auxd.getMonto().toString()),
                                        Double.parseDouble(auxd.getMonto().toString()) +  Double.parseDouble(auxd.getMontoio().toString()) +  Double.parseDouble(auxd.getMontoim().toString()));
                  
                        System.out.println("LoanP:"+loanp);    
            listPayment.add(loanp);
        }
            System.out.println("listaPayments:"+listPayment);
        
        }catch(Exception e){
            System.out.println("Error al buscar auxiliares d:"+e.getMessage());
        
        }
        return listPayment;
    }
    //Obetner cuota vencida
    public FeesDueData RSFeesDueData(int o, int p, int a) {
        EntityManager em = emf.createEntityManager();
        String sai_auxiliar = "SELECT * FROM sai_auxiliar(" + o + "," + p + "," + a + ",(SELECT date(fechatrabajo) FROM origenes limit 1))";
        FeesDueData FeesDueDataRS = null;
        try {
            Query RsSai = em.createNativeQuery(sai_auxiliar);
            String sai = RsSai.getSingleResult().toString();
            String[] parts = sai.split("\\|");
            List list = Arrays.asList(parts);

            Double iovencido = Double.parseDouble(list.get(6).toString()) + Double.parseDouble(list.get(17).toString());
            Double imvencido = Double.parseDouble(list.get(15).toString()) + Double.parseDouble(list.get(18).toString());
            Double montovencido = Double.parseDouble(list.get(4).toString());
            Double mnttotalcv = iovencido + imvencido + montovencido;
            System.out.println("Iovencido:" + iovencido + ", imvencido:" + imvencido + ",montovencido:" + montovencido + "Total vencido:" + mnttotalcv);

            FeesDueDataRS = new FeesDueData(
                    iovencido,
                    Double.parseDouble(list.get(6).toString()),
                    imvencido,
                    montovencido,
                    mnttotalcv);
            System.out.println("FeesDueData:" + FeesDueDataRS);
        } catch (Exception e) {
            System.out.println("Error en FeesDueData:" + e.getMessage());
            cerrar();
        }
        System.out.println("FeesDueData:" + FeesDueDataRS);
        return FeesDueDataRS;
    }

    //Metodo para devolver abonos vencidos
    public int RSFeesDue(int o, int p, int a) {
        EntityManager em = emf.createEntityManager();
        String sai_auxiliar = "SELECT * FROM sai_auxiliar(" + o + "," + p + "," + a + ",(SELECT date(fechatrabajo) FROM origenes limit 1))";
        int abonosVencidos = 0;
        try {
            Query RsSai = em.createNativeQuery(sai_auxiliar);
            String sai = RsSai.getSingleResult().toString();
            String[] parts = sai.split("\\|");
            List list = Arrays.asList(parts);
            abonosVencidos = Integer.parseInt(list.get(3).toString());
            System.out.println("Abonos Vencidos:" + abonosVencidos);
        } catch (Exception e) {
            System.out.println("Error en FeesDueData:" + e.getMessage());
            cerrar();
        }
        return abonosVencidos;
    }

    //Devuelve LoanFee para apoyo en GetLoanPrincipal para obtener la proxima amortizacion
    public LoanFee RSLoanFee(int o, int p, int a) {
        EntityManager em = emf.createEntityManager();
        LoanFee loanFee = null;

        try {
            AuxiliaresPK pk = new AuxiliaresPK(o, p, a);
            Auxiliares aux = em.find(Auxiliares.class, pk);
            //Obtengo informacion con el sai_auxiliar hasta la fecha actual, si hay dudas checar el catalogo o atributos que devuelve la funcion
            String sai_auxiliar = "SELECT * FROM sai_auxiliar(" + o + "," + p + "," + a + ",(SELECT date(fechatrabajo) FROM origenes limit 1))";
            Query RsSai = em.createNativeQuery(sai_auxiliar);
            String sai = RsSai.getSingleResult().toString();
            String[] parts = sai.split("\\|");
            List list = Arrays.asList(parts);
            //Obtengo la amortizacion que se vence
            String consultaA = "SELECT * FROM amortizaciones WHERE idorigenp=" + o
                    + " AND idproducto=" + p
                    + " AND idauxiliar=" + a
                    + " AND vence='" + list.get(8) + "'";//en la pocision 8 esta la fecha de vencimiento
            Query queryA = em.createNativeQuery(consultaA, Amortizaciones.class);
            Amortizaciones amm = (Amortizaciones) queryA.getSingleResult();
            Double iovencido = Double.parseDouble(list.get(6).toString()) + Double.parseDouble(list.get(17).toString());
            Double imvencido = Double.parseDouble(list.get(15).toString()) + Double.parseDouble(list.get(18).toString());
            Double montovencido = Double.parseDouble(list.get(4).toString());

            int loanfeests = 0;
            if (Double.parseDouble(amm.getAbono().toString()) == Double.parseDouble(amm.getAbonopag().toString())) {
                loanfeests = 3;
            } else if (Double.parseDouble(amm.getAbono().toString()) > Double.parseDouble(amm.getAbonopag().toString())
                    && amm.getTodopag() == false) {
                loanfeests = 1;
            } else if (!list.get(14).toString().equals("C")) {
                loanfeests = 2;
            }

            Loan_Fee_Status loanf = em.find(Loan_Fee_Status.class, loanfeests);

            Double abonoT = Double.parseDouble(amm.getAbono().toString()) + iovencido + imvencido;
            loanFee = new LoanFee(
                    Double.parseDouble(aux.getSaldo().toString()),//Saldo o balance del prestamo principal
                    amm.getAmortizacionesPK().getIdorigenp() + amm.getAmortizacionesPK().getIdproducto() + amm.getAmortizacionesPK().getIdauxiliar() + amm.getAmortizacionesPK().getIdamortizacion(),
                    Double.parseDouble(amm.getAbono().toString()),
                    amm.getVence().toString(),
                    iovencido,
                    imvencido,
                    loanf.getId(),
                    Double.parseDouble(amm.getAbono().toString()),
                    abonoT);
        } catch (Exception e) {
            System.out.println("Error en LoanFee:" + e.getMessage());
        }

        return loanFee;
    }

    //Metodo para devolver dias vencidos
    public int RSOverdueDays(int o, int p, int a) {
        EntityManager em = emf.createEntityManager();
        String sai_auxiliar = "SELECT * FROM sai_auxiliar(" + o + "," + p + "," + a + ",(SELECT date(fechatrabajo) FROM origenes limit 1))";
        int diasVencidos = 0;
        try {
            Query RsSai = em.createNativeQuery(sai_auxiliar);
            String sai = RsSai.getSingleResult().toString();
            String[] parts = sai.split("\\|");
            List list = Arrays.asList(parts);
            diasVencidos = Integer.parseInt(list.get(3).toString());
        } catch (Exception e) {
            System.out.println("Error en FeesDueData:" + e.getMessage());
            em.close();
        }
        
        return diasVencidos;
    }

     
    public int tipoproducto(int idproducto){
        EntityManager em=emf.createEntityManager();
        int tipoproducto=0;
        try {
            String consulta="SELECT tipoproducto FROM productos WHERE idproducto="+idproducto;
            Query query=em.createNativeQuery(consulta);
            tipoproducto=Integer.parseInt(String.valueOf(query.getSingleResult()));
        } catch (Exception e) {
            em.close();
            System.out.println("Error en buscar tipoproducto:"+e.getMessage());
        }
        em.close();
        return tipoproducto;
    }
    public static Date stringTodate(String fecha) {
        Date date = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            date = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println("Error al convertir fecha:" + ex.getMessage());
        }
        System.out.println("date:" + date);
        return date;
    }
    
    public int contadorGeneral(String productBankIdentifier,int identificador,int feesstatus){
        EntityManager em=emf.createEntityManager();
        int cont=0;
        try{
            String consulta="";
            if(identificador==1){
                if(feesstatus==1){
                consulta="SELECT count(*) FROM amortizaciones WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='"+productBankIdentifier+"' AND todopag=true";    
                }else if(feesstatus==2){
                consulta="SELECT count(*) FROM amortizaciones WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='"+productBankIdentifier+"' AND todopag=false";    
                }else if(feesstatus==0){
                consulta="SELECT count(*) FROM amortizaciones WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='"+productBankIdentifier+"'";    
                }
          
            }else if(identificador==2){
                consulta="SELECT count(*) FROM auxiliares_d WHERE replace(to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999'),' ','')='"+productBankIdentifier+"' AND cargoabono=1";
            }
            Query query=em.createNativeQuery(consulta);
            cont=Integer.parseInt(String.valueOf(query.getSingleResult()));
            System.out.println("cont:"+cont);
        }catch(Exception e){
            System.out.println("Error al obtener contador general:"+e.getMessage());
        }
        return cont;
    }
    public String dateToString(Date cadena) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String cadenaStr = sdf.format(cadena);
        return cadenaStr;
    }

    /**
     * *********************************Cerrando conexiones  * ***********************************
     */
    
    
    public void cerrar() {
        emf.close();
    }

}
