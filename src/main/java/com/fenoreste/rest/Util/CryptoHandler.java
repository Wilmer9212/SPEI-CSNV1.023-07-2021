package com.fenoreste.rest.Util;

import com.fenorest.rest.DTO.OrdenPagoWS;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.util.Base64;
import java.util.Base64.Encoder;

public class CryptoHandler {
     
    //Prueba en local
    //String fileName = "/home/wilmer/respaldo/ProyectosJavaPruebas/CA/feno.jks";
    //Prueba en csn
    String fileName = "/home/solvetic/Certificados/speiTest/feno.jks";    
    String password = "f3n0r3st3";
    String alias = "fenoresteca";

    public String firmar(OrdenPagoWS oPW) throws Exception {
        String firma;
        System.out.println("Fimando");
        try {
            firma = sign(cadenaOriginal(oPW));
        } catch (Exception e) {
            throw new Exception("Exception" + e.getMessage(), e.getCause());
        }
        return firma;
    }

    public String cadenaOriginal(OrdenPagoWS oPW) {
        StringBuilder sB = new StringBuilder();
        sB.append("||");
        sB.append(oPW.getInstitucionContraparte()).append("|");
        sB.append(oPW.getEmpresa()).append("|");
        sB.append(oPW.getFechaOperacion() == null ? "" : oPW.getFechaOperacion()).append("|");
        sB.append(oPW.getFolioOrigen() == null ? "" : oPW.getFolioOrigen()).append("|");
        sB.append(oPW.getClaveRastreo() == null ? "" : oPW.getClaveRastreo()).append("|");
        sB.append(oPW.getInstitucionOperante() == null ? "" : oPW.getInstitucionOperante()).append("|");
        sB.append(oPW.getMonto() == null ? "" : oPW.getMonto()).append("|");
        sB.append(oPW.getTipoPago() == null ? "" : oPW.getTipoPago()).append("|");
        sB.append(oPW.getTipoCuentaOrdenante() == null ? "" : oPW.getTipoCuentaOrdenante()).append("|");
        sB.append(oPW.getNombreOrdenante() == null ? "" : oPW.getNombreOrdenante()).append("|");
        sB.append(oPW.getCuentaOrdenante() == null ? "" : oPW.getCuentaOrdenante()).append("|");
        sB.append(oPW.getRfcCurpOrdenante() == null ? "" : oPW.getRfcCurpOrdenante()).append("|");
        sB.append(oPW.getTipoCuentaBeneficiario() == null ? "" : oPW.getTipoCuentaBeneficiario()).append("|");
        sB.append(oPW.getNombreBeneficiario() == null ? "" : oPW.getNombreBeneficiario()).append("|");
        sB.append(oPW.getCuentaBeneficiario() == null ? "" : oPW.getCuentaBeneficiario()).append("|");
        sB.append(oPW.getRfcCurpBeneficiario() == null ? "" : oPW.getRfcCurpBeneficiario()).append("|");
        sB.append(oPW.getEmailBeneficiario() == null ? "" : oPW.getEmailBeneficiario()).append("|");
        sB.append(oPW.getTipoCuentaBeneficiario2() == null ? "" : oPW.getTipoCuentaBeneficiario2()).append("|");
        sB.append(oPW.getNombreBeneficiario2() == null ? "" : oPW.getNombreBeneficiario2()).append("|");
        sB.append(oPW.getCuentaBeneficiario2() == null ? "" : oPW.getCuentaBeneficiario2()).append("|");
        sB.append(oPW.getRfcCurpBeneficiario2() == null ? "" : oPW.getRfcCurpBeneficiario2()).append("|");
        sB.append(oPW.getConceptoPago() == null ? "" : oPW.getConceptoPago()).append("|");
        sB.append(oPW.getConceptoPago2() == null ? "" : oPW.getConceptoPago2()).append("|");
        sB.append(oPW.getClaveCatUsuario1() == null ? "" : oPW.getClaveCatUsuario1()).append("|");
        sB.append(oPW.getClaveCatUsuario2() == null ? "" : oPW.getClaveCatUsuario2()).append("|");
        sB.append(oPW.getClavePago() == null ? "" : oPW.getClavePago()).append("|");
        sB.append(oPW.getReferenciaCobranza() == null ? "" : oPW.getReferenciaCobranza()).append("|");
        sB.append(oPW.getReferenciaNumerica() == null ? "" : oPW.getReferenciaNumerica()).append("|");
        sB.append(oPW.getTipoOperacion() == null ? "" : oPW.getTipoOperacion()).append("|");
        sB.append(oPW.getTopologia() == null ? "" : oPW.getTopologia()).append("|");
        sB.append(oPW.getUsuario() == null ? "" : oPW.getUsuario()).append("|");
        sB.append(oPW.getMedioEntrega() == null ? "" : oPW.getMedioEntrega()).append("|");
        sB.append(oPW.getPrioridad() == null ? "" : oPW.getPrioridad()).append("|");
        sB.append(oPW.getIva() == null ? "" : oPW.getIva()).append("||");
        String cadena = sB.toString();
        System.out.println("Cadena original: " + cadena);
        return cadena;
    }

    public String sign(String cadena) throws Exception {
        String firmaCod;
        try {
            String data = cadena;
            Signature firma = Signature.getInstance("SHA256withRSA");
            RSAPrivateKey llavePrivada = getCertified(fileName, password, alias);
            firma.initSign(llavePrivada);
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            firma.update(bytes, 0, bytes.length);
            Encoder encoder = Base64.getEncoder();
            firmaCod=encoder.encodeToString(firma.sign());
            System.out.println("Firma: " + firmaCod);
            } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
            throw new Exception("Exceptions" + e.getMessage(), e.getCause());
        }
        return firmaCod;
    }

    private RSAPrivateKey getCertified(String keystoreFilename, String password, String alias) throws Exception {
        RSAPrivateKey privateKey;
        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(keystoreFilename), password.toCharArray());
            privateKey = (RSAPrivateKey) keystore.getKey(alias, password.toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | IOException | CertificateException ex) {
            throw new Exception("Exception" + ex.getMessage(), ex.getCause());
        }
        return privateKey;
    }
}
