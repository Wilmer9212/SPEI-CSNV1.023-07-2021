package com.fenoreste.rest.dao;

import com.fenoreste.rest.Util.AbstractFacade;
import com.fenoreste.rest.ResponseDTO.AccountLast5MovementsDTO;
import com.fenoreste.rest.ResponseDTO.AccountDetailsDTO;
import com.fenoreste.rest.ResponseDTO.AccountMovementsDTO;
import com.fenoreste.rest.entidades.AuxiliaresPK;
import com.fenoreste.rest.entidades.Productos;
import com.fenoreste.rest.entidades.Auxiliares;
import java.math.BigInteger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public abstract class FacadeAccounts<T> {

    Calendar calendar = Calendar.getInstance();
    Date hoy = calendar.getTime();
    private static EntityManagerFactory emf;

    public FacadeAccounts(Class<T> entityClass) {
        emf = AbstractFacade.conexion();
    }
    EntityManager em = null;

    public AccountDetailsDTO GetAccountDetails(String accountId) {
        //0302823264400006853 opa con mivimientos 29/11/2020 24 Hrs
        //0302163404400000226 opa con movimientos 28/11/2020 48 Hrs
        //0302203666400000037 opa sin movimientos durante 48 Hrs
        //
        em = emf.createEntityManager();
        int o = Integer.parseInt(accountId.substring(0, 6));
        int p = Integer.parseInt(accountId.substring(6, 11));
        int a = Integer.parseInt(accountId.substring(11, 19));

        AccountDetailsDTO cuenta = null;
        System.out.println("O:" + o + ",P:" + p + ",A:" + a);
        try {
            AuxiliaresPK auxpk = new AuxiliaresPK(o, p, a);
            System.out.println("Paso");
            Auxiliares aux = em.find(Auxiliares.class, auxpk);
            System.out.println("Pasooo");
            System.out.println("Saldo de la cuenta:" + aux.getSaldo());
            Productos prod = em.find(Productos.class, aux.getAuxiliaresPK().getIdproducto());
            System.out.println("Producto Nombre:" + prod.getNombre());
            String S24H = DateFormat.getDateInstance().format(substractDate(1));
            String S48H = DateFormat.getDateInstance().format(substractDate(2));
            String IntervalM = DateFormat.getDateInstance().format(subtractIntervalMonth());

            //Obtenemos saldo segun las horas pasadada 
            //Saldo 24 horas
            double saldosF[] = getSaldoAuxiliaresD(o, p, a, S24H, S48H);
            double saldo24 = 0.0, saldo48 = 0.0, saldo = 0.0;
            saldo24 = saldosF[0];
            saldo48 = saldosF[1];
            saldo = saldosF[2];

            if (saldo24 > 0) {
                saldo24 = saldo24;
                if (saldo48 > 0) {
                    saldo48 = saldo48;
                    saldo = saldo48;
                } else {
                    saldo48 = saldo;
                }
            } else {
                if (saldo48 > 0) {
                    saldo24 = saldo48;
                } else {
                    saldo24 = saldo;
                    saldo48 = saldo;
                }
            }

            System.out.println("Saldo 24H:" + saldo24 + ",Saldo48:" + saldo48 + ",saldo:" + saldo);
            Double saldoPromedioMensual = 0.0;
            String consultaP = "SELECT replace(sai_calcula_saldo_promedio_diario("
                    + aux.getAuxiliaresPK().getIdorigenp() + ","
                    + aux.getAuxiliaresPK().getIdproducto() + ","
                    + aux.getAuxiliaresPK().getIdauxiliar() + ",'" + IntervalM + "','" + "30/12/2020" + "',0),',','')";
            System.out.println("Consulta:" + consultaP);
            Query saldoPM = em.createNativeQuery(consultaP);
            saldoPromedioMensual = Double.parseDouble(saldoPM.getSingleResult().toString());
            System.out.println("Saldo promedio:" + saldoPromedioMensual);
            //replace(sai_calcula_saldo_promedio_diario(aux.idorigenp,aux.idproducto,aux.idauxiliar,fecha_inicial,fecha_final,0),',','')::numeric as "Promedio Diario" 
            //System.out.println("ad:"+adpk);
            cuenta = new AccountDetailsDTO(
                    accountId,
                    prod.getNombre(),
                    Double.parseDouble(aux.getMontoautorizado().toString()),
                    Double.parseDouble(aux.getSaldo().toString()),
                    saldo24,
                    saldo48,
                    saldo,
                    saldoPromedioMensual,
                    p,
                    a,
                    a,
                    a,
                    a,
                    a,
                    a,
                    o,
                    a,
                    0.0,
                    accountId,
                    accountId,
                    Boolean.TRUE);
        } catch (Exception e) {
            System.out.println("Error en GetAccountDetails:" + e.getMessage());
        }

        return cuenta;//cuenta;

    }

    public List<AccountLast5MovementsDTO> getAccountLast5Movements(String accountId) {
       
        AccountLast5MovementsDTO cuenta;
        boolean isDC = false;
        String Description = "";
        List<AccountLast5MovementsDTO> ListaDTO = new ArrayList<AccountLast5MovementsDTO>();
        try {
            em = emf.createEntityManager();
            String consulta = " SELECT m.* "
                    + "         FROM auxiliares_d m"
                    + "         WHERE replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')= ? ORDER BY fecha DESC LIMIT 5";
            Query k = em.createNativeQuery(consulta);
            k.setParameter(1, accountId);
            int movementTypeId=0;
            List<Object[]> milista = k.getResultList();
            for (int i = 0; i < milista.size(); i++) {
                Object[] as = milista.get(i);
                if (Integer.parseInt(as[4].toString()) == 1) {
                    Description = "Abono";
                    movementTypeId=2;
                    isDC=false;
                } else if (Integer.parseInt(as[4].toString()) == 0) {
                    Description = "Cargo";
                    movementTypeId=3;
                    isDC=true;
                }
                
                
                
                Productos productos = em.find(Productos.class, Integer.parseInt(as[1].toString()));
               
                cuenta = new AccountLast5MovementsDTO(
                        Integer.parseInt(as[12].toString()),
                        accountId,
                        as[3].toString(),
                        Description,
                        Double.parseDouble(as[5].toString()),
                        isDC,
                        Double.parseDouble(as[14].toString()),
                        movementTypeId,
                        Description,
                        as[12].toString(),
                        as[20].toString());

                ListaDTO.add(cuenta);
            }
            System.out.println("ListaDTO:" + ListaDTO);
           
        } catch (Exception e) {
            em.close();
            System.out.println("Error en GetAccountLast5Movements:" + e.getMessage());
        }finally{
            em.close();
        }
        return ListaDTO;
    }

    public List<AccountMovementsDTO> getAccountMovements(String productBankIdentifier, String dateFromFilter, String dateToFilter, int pageSize, int pageStartIndex,String orderBy) {
        AccountMovementsDTO cuenta;
        boolean isDC = false;
        String Description = "";
        List<AccountMovementsDTO> ListaDTO = new ArrayList<AccountMovementsDTO>();
        String complemento="";
         try{
        System.out.println("orderB:"+orderBy);
        switch(orderBy.toUpperCase()){
            
            case "MOVEMENTDATE ASC":
                complemento="ORDER BY fecha ASC";
            break;
            case "MOVEMENTDATE DESC":
                complemento="ORDER BY fecha DESC";
            break;
            case "MOVEMENTDATE":
                complemento="ORDER BY fecha";
            break;  
            case "ID ASC":
                complemento="ORDER BY idpoliza ASC";
            break;
            case "ID DESC":
                complemento="ORDER BY idpoliza DESC";
            break;
            case "ID":
                complemento="ORDER BY idpoliza";
            break;  
            case "DESCRIPTION ASC":
                complemento="ORDER BY cargoabono ASC";
            break;
            case "DESCRIPTION DESC":
                complemento="ORDER BY cargoabono DESC";
            break;
            case "DESCRIPTION":
                complemento="ORDER BY cargoabono";
            break; 
             case "AMOUNT ASC":
                complemento="ORDER BY monto ASC";
            break;
            case "AMOUNT DESC":
                complemento="ORDER BY monto DESC";
            break;
            case "AMOUNT":
                complemento="ORDER BY monto";
            break; 
             case "BALANCE ASC":
                complemento="ORDER BY saldoec ASC";
            break;
            case "BALANCE DESC":
                complemento="ORDER BY saldoec DESC";
            break;
            case "BALANCE":
                complemento="ORDER BY saldoec";
            break; 
            case "":
            break;
            
            
        }
        EntityManager em = emf.createEntityManager();
        int pageNumber = pageStartIndex;
        int pageSizes = pageSize;
        int inicioB = 0;

        //Query query = em.createNativeQuery("SELECT * FROM personas order by idsocio ASC",Persona.class);
        String consulta = "";
        if (!dateFromFilter.equals("") && !dateToFilter.equals("")) {
            consulta = " SELECT *"
                    + "         FROM auxiliares_d"
                    + "         WHERE date(fecha) between '" + dateFromFilter + "'"
                    + "         AND '" + dateToFilter + "' AND replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "' "+complemento;
        } else if (!dateFromFilter.equals("") && dateToFilter.equals("")) {
            consulta = " SELECT *"
                    + "         FROM auxiliares_d"
                    + "         WHERE date(fecha) > '" + dateFromFilter + "' AND replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "' "+complemento;

        } else if (dateFromFilter.equals("") && !dateToFilter.equals("")) {
            consulta = " SELECT *"
                    + "         FROM auxiliares_d"
                    + "         WHERE date(fecha) < '" + dateToFilter + "' AND replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "' "+complemento;

        } else {
            consulta = " SELECT *"
                    + "         FROM auxiliares_d"
                    + "         WHERE replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "' "+complemento;

        }

        System.out.println("Consulta:" + consulta);

        /*if (pageNumber == 1 || pageNumber == 0) {
            inicioB = 0;
        } else if (pageNumber > 1) {
            inicioB = ((pageNumber * pageSizes) - pageSizes);
        }*/
        
        inicioB = ((pageNumber * pageSizes) - pageSizes);
        if(inicioB<0){
            inicioB=0;
        }
        try {
            Query queryE = em.createNativeQuery(consulta);
            queryE.setFirstResult(pageStartIndex);
            queryE.setMaxResults(pageSizes);
            List<Object[]> MiLista = queryE.getResultList();
            int movementTypeId=0;
            for(Object[] ListaO:MiLista) {
            if (Integer.parseInt(ListaO[4].toString()) == 1) {
                    Description = "Abono";
                    movementTypeId=2;
                    isDC=false;
                } else if (Integer.parseInt(ListaO[4].toString()) == 0) {
                    Description = "Cargo";
                    movementTypeId=3;
                    isDC=true;
                }
                Productos productos = em.find(Productos.class, Integer.parseInt(ListaO[1].toString()));
               
                AccountMovementsDTO dto = new AccountMovementsDTO(
                        Integer.parseInt(ListaO[12].toString()),
                        productBankIdentifier,
                        ListaO[3].toString(),
                        Description,
                        Double.parseDouble(ListaO[5].toString()),
                        isDC,
                        Double.parseDouble(ListaO[14].toString()),
                        movementTypeId,
                        Description,
                        ListaO[11].toString(),
                        ListaO[11].toString());   
                ListaDTO.add(dto);    
            }
        } catch (Exception e) {
            em.close();
            System.out.println("Error:" + e.getMessage());
        }
        em.close();
             System.out.println("salio y ListaDTO:"+ListaDTO);
         }catch(Exception e){
             em.close();
             System.out.println("Error en account:"+e.getMessage());
         }
        return ListaDTO;
    }

    public static Date substractDate(int numeroDias) {
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();

        //Si vamos a usar la fecha en tiempo real date=fechaActual
        //date = fechaActual;
        try {
            date = d.parse("31/12/2020");
        } catch (ParseException ex) {
            Logger.getLogger(FacadeAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -numeroDias);
        return cal.getTime();
    }

    public static Date subtractDay24H() {
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();

        //Si vamos a usar la fecha en tiempo real date=fechaActual
        try {
            date = d.parse("'31/11/2021'");
        } catch (ParseException ex) {
            Logger.getLogger(FacadeAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    public static Date subtractIntervalMonth() {
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        Date fecha24H = calendar.getTime();
        try {
            date = d.parse("31/12/2020");
        } catch (ParseException ex) {
            Logger.getLogger(FacadeAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    //Metodo que no ayuda a obtener saldo por rango de fechas, se utilizo en el metodo de getAccountDetails
    public double[] getSaldoAuxiliaresD(int o, int p, int a, String fecha, String fecha2) {
        double saldo1 = 0.0;
        double saldo2 = 0.0;
        double saldo3 = 0.0;
        double saldos[] = new double[3];
        if (!fecha.equals("") && !fecha2.equals("")) {
            String consulta = "SELECT case when saldoec >0 then saldoec else 0.0 end FROM auxiliares_d WHERE " + "idorigenp=" + o
                    + " AND idproducto=" + p
                    + " AND idauxiliar=" + a
                    + " AND date(fecha) ='" + fecha + "'";
            System.out.println("Consulta 1:" + consulta);
            Query query = em.createNativeQuery(consulta);

            String consulta2 = "SELECT case when saldoec >0 then saldoec else 0.0 end FROM auxiliares_d WHERE " + "idorigenp=" + o
                    + " AND idproducto=" + p
                    + " AND idauxiliar=" + a
                    + " AND date(fecha) ='" + fecha2 + "'";
            Query query2 = em.createNativeQuery(consulta2);

            String consulta3 = "SELECT case when saldoec > 0 then saldoec else 0.0 end FROM auxiliares_d WHERE " + "idorigenp=" + o
                    + " AND idproducto=" + p
                    + " AND idauxiliar=" + a + " ORDER BY fecha DESC limit 1";
            Query query3 = em.createNativeQuery(consulta3);

            try {
                saldo1 = Double.parseDouble(String.valueOf(query.getSingleResult()));
            } catch (Exception e) {
            };
            try {
                saldo2 = Double.parseDouble(String.valueOf(query2.getSingleResult()));
            } catch (Exception e) {
            };
            try {
                saldo3 = Double.parseDouble(String.valueOf(query3.getSingleResult()));
            } catch (Exception e) {
            };

            System.out.println("saldo 3:" + saldo3);
            System.out.println("Saliendo");
            saldos[0] = saldo1;
            saldos[1] = saldo2;
            saldos[2] = saldo3;
            System.out.println("Salio con bien");

        } else {
            System.out.println("Defina fechas por favor");
        }
        System.out.println("saldos:" + saldo1 + "," + saldo2 + "," + saldo3);
        return saldos;
    }

    public int contadorAuxD(String productBankIdentifier, String dateFromFilter, String dateToFilter) {
        String consulta = "";
        int count=0;
        EntityManager em=emf.createEntityManager();
        try{
        if (!dateFromFilter.equals("") && !dateToFilter.equals("")) {
            consulta = " SELECT count(*)"
                    + "         FROM auxiliares_d"
                    + "         WHERE date(fecha) between '" + dateFromFilter + "'"
                    + "         AND '" + dateToFilter + "' AND replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "'";
        } else if (!dateFromFilter.equals("") && dateToFilter.equals("")) {
            consulta = " SELECT count(*)"
                    + "         FROM auxiliares_d"
                    + "         WHERE date(fecha) > '" + dateFromFilter + "' AND replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "'";

        } else if (dateFromFilter.equals("") && !dateToFilter.equals("")) {
            consulta = " SELECT count(*)"
                    + "         FROM auxiliares_d"
                    + "         WHERE date(fecha) < '" + dateToFilter + "' AND replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "'";

        } else {
            consulta = " SELECT count(*)"
                    + "         FROM auxiliares_d"
                    + "         WHERE replace((to_char(idorigenp,'099999')||to_char(idproducto,'09999')||to_char(idauxiliar,'09999999')),' ','')='" + productBankIdentifier + "'";

        }
        System.out.println("Consulta conta:"+consulta);
        Query query = em.createNativeQuery(consulta);
            System.out.println("paso");
        BigInteger b1;
            System.out.println("oasi1");
        b1 = new BigInteger(query.getSingleResult().toString());
            System.out.println("pasoss");
        count = Integer.parseInt(b1.toString());
        }catch(Exception e){
        System.out.println("Error al contar registros:"+e.getMessage());
        }
        em.close();
        return count;
    }

    /**
     * *********************************Cerrando conexiones
     * ***********************************
     */
    public void cerrar() {
        emf.close();
    }

}
