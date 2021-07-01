/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name = "transferencias_bankingly")
public class Transfers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_transfers_bankingly")
    @SequenceGenerator(name = "sec_transfers_bankingly", sequenceName = "sec_transfers_bankingly")
    private int idtransaction;
    private Integer subtransactiontypeid;
    private String currencyid;
    private Date valuedate;
    private Integer transactiontypeid;
    private Integer transactionstatusid;
    private String clientbankidentifier;
    private String debitproductbankidentifier;
    private Integer debitproducttypeid;
    private String debitcurrencyid;
    private String creditproductbankidentifier;
    private Integer creditproducttypeid;
    private String creditcurrencyid;
    private Double amount;
    private String notifyto;
    private Integer notificationchannelid;
    private Integer transactionid;
    private String destinationname;
    private String destinationbank;
    private String description;
    private String bankroutingnumber;
    private String sourcename;
    private String sourcebank;
    private boolean regulationamountexceeded;
    private String sourcefunds;
    private String destinationfunds;
    private Double transactioncost;
    private String transactioncostcurrencyid;
    private Double exchangerate;
    private Date fechaejecucion;

    public Transfers() {
    }

    public Transfers(int idtransaction, Integer subtransactiontypeid, String currencyid, Date valuedate, Integer transactiontypeid, Integer transactionstatusid, String clientbankidentifier, String debitproductbankidentifier, Integer debitproducttypeid, String debitcurrencyid, String creditproductbankidentifier, Integer creditproducttypeid, String creditcurrencyid, Double amount, String notifyto, Integer notificationchannelid, Integer transactionid, String destinationname, String destinationbank, String description, String bankroutingnumber, String sourcename, String sourcebank, boolean regulationamountexceeded, String sourcefunds, String destinationfunds, Double transactioncost, String transactioncostcurrencyid, Double exchangerate, Date fechaejecucion) {
        this.idtransaction = idtransaction;
        this.subtransactiontypeid = subtransactiontypeid;
        this.currencyid = currencyid;
        this.valuedate = valuedate;
        this.transactiontypeid = transactiontypeid;
        this.transactionstatusid = transactionstatusid;
        this.clientbankidentifier = clientbankidentifier;
        this.debitproductbankidentifier = debitproductbankidentifier;
        this.debitproducttypeid = debitproducttypeid;
        this.debitcurrencyid = debitcurrencyid;
        this.creditproductbankidentifier = creditproductbankidentifier;
        this.creditproducttypeid = creditproducttypeid;
        this.creditcurrencyid = creditcurrencyid;
        this.amount = amount;
        this.notifyto = notifyto;
        this.notificationchannelid = notificationchannelid;
        this.transactionid = transactionid;
        this.destinationname = destinationname;
        this.destinationbank = destinationbank;
        this.description = description;
        this.bankroutingnumber = bankroutingnumber;
        this.sourcename = sourcename;
        this.sourcebank = sourcebank;
        this.regulationamountexceeded = regulationamountexceeded;
        this.sourcefunds = sourcefunds;
        this.destinationfunds = destinationfunds;
        this.transactioncost = transactioncost;
        this.transactioncostcurrencyid = transactioncostcurrencyid;
        this.exchangerate = exchangerate;
        this.fechaejecucion = fechaejecucion;
    }

    public int getIdtransaction() {
        return idtransaction;
    }

    public void setIdtransaction(int idtransaction) {
        this.idtransaction = idtransaction;
    }

    public Integer getSubtransactiontypeid() {
        return subtransactiontypeid;
    }

    public void setSubtransactiontypeid(Integer subtransactiontypeid) {
        this.subtransactiontypeid = subtransactiontypeid;
    }

    public String getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(String currencyid) {
        this.currencyid = currencyid;
    }

    public Date getValuedate() {
        return valuedate;
    }

    public void setValuedate(Date valuedate) {
        this.valuedate = valuedate;
    }

    public Integer getTransactiontypeid() {
        return transactiontypeid;
    }

    public void setTransactiontypeid(Integer transactiontypeid) {
        this.transactiontypeid = transactiontypeid;
    }

    public Integer getTransactionstatusid() {
        return transactionstatusid;
    }

    public void setTransactionstatusid(Integer transactionstatusid) {
        this.transactionstatusid = transactionstatusid;
    }

    public String getClientbankidentifier() {
        return clientbankidentifier;
    }

    public void setClientbankidentifier(String clientbankidentifier) {
        this.clientbankidentifier = clientbankidentifier;
    }

    public String getDebitproductbankidentifier() {
        return debitproductbankidentifier;
    }

    public void setDebitproductbankidentifier(String debitproductbankidentifier) {
        this.debitproductbankidentifier = debitproductbankidentifier;
    }

    public Integer getDebitproducttypeid() {
        return debitproducttypeid;
    }

    public void setDebitproducttypeid(Integer debitproducttypeid) {
        this.debitproducttypeid = debitproducttypeid;
    }

    public String getDebitcurrencyid() {
        return debitcurrencyid;
    }

    public void setDebitcurrencyid(String debitcurrencyid) {
        this.debitcurrencyid = debitcurrencyid;
    }

    public String getCreditproductbankidentifier() {
        return creditproductbankidentifier;
    }

    public void setCreditproductbankidentifier(String creditproductbankidentifier) {
        this.creditproductbankidentifier = creditproductbankidentifier;
    }

    public Integer getCreditproducttypeid() {
        return creditproducttypeid;
    }

    public void setCreditproducttypeid(Integer creditproducttypeid) {
        this.creditproducttypeid = creditproducttypeid;
    }

    public String getCreditcurrencyid() {
        return creditcurrencyid;
    }

    public void setCreditcurrencyid(String creditcurrencyid) {
        this.creditcurrencyid = creditcurrencyid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNotifyto() {
        return notifyto;
    }

    public void setNotifyto(String notifyto) {
        this.notifyto = notifyto;
    }

    public Integer getNotificationchannelid() {
        return notificationchannelid;
    }

    public void setNotificationchannelid(Integer notificationchannelid) {
        this.notificationchannelid = notificationchannelid;
    }

    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    public String getDestinationname() {
        return destinationname;
    }

    public void setDestinationname(String destinationname) {
        this.destinationname = destinationname;
    }

    public String getDestinationbank() {
        return destinationbank;
    }

    public void setDestinationbank(String destinationbank) {
        this.destinationbank = destinationbank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBankroutingnumber() {
        return bankroutingnumber;
    }

    public void setBankroutingnumber(String bankroutingnumber) {
        this.bankroutingnumber = bankroutingnumber;
    }

    public String getSourcename() {
        return sourcename;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename;
    }

    public String getSourcebank() {
        return sourcebank;
    }

    public void setSourcebank(String sourcebank) {
        this.sourcebank = sourcebank;
    }

    public boolean isRegulationamountexceeded() {
        return regulationamountexceeded;
    }

    public void setRegulationamountexceeded(boolean regulationamountexceeded) {
        this.regulationamountexceeded = regulationamountexceeded;
    }

    public String getSourcefunds() {
        return sourcefunds;
    }

    public void setSourcefunds(String sourcefunds) {
        this.sourcefunds = sourcefunds;
    }

    public String getDestinationfunds() {
        return destinationfunds;
    }

    public void setDestinationfunds(String destinationfunds) {
        this.destinationfunds = destinationfunds;
    }

    public Double getTransactioncost() {
        return transactioncost;
    }

    public void setTransactioncost(Double transactioncost) {
        this.transactioncost = transactioncost;
    }

    public String getTransactioncostcurrencyid() {
        return transactioncostcurrencyid;
    }

    public void setTransactioncostcurrencyid(String transactioncostcurrencyid) {
        this.transactioncostcurrencyid = transactioncostcurrencyid;
    }

    public Double getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }

    public Date getFechaejecucion() {
        return fechaejecucion;
    }

    public void setFechaejecucion(Date fechaejecucion) {
        this.fechaejecucion = fechaejecucion;
    }

    @Override
    public String toString() {
        return "Transfers{" + "idtransaction=" + idtransaction + ", subtransactiontypeid=" + subtransactiontypeid + ", currencyid=" + currencyid + ", valuedate=" + valuedate + ", transactiontypeid=" + transactiontypeid + ", transactionstatusid=" + transactionstatusid + ", clientbankidentifier=" + clientbankidentifier + ", debitproductbankidentifier=" + debitproductbankidentifier + ", debitproducttypeid=" + debitproducttypeid + ", debitcurrencyid=" + debitcurrencyid + ", creditproductbankidentifier=" + creditproductbankidentifier + ", creditproducttypeid=" + creditproducttypeid + ", creditcurrencyid=" + creditcurrencyid + ", amount=" + amount + ", notifyto=" + notifyto + ", notificationchannelid=" + notificationchannelid + ", transactionid=" + transactionid + ", destinationname=" + destinationname + ", destinationbank=" + destinationbank + ", description=" + description + ", bankroutingnumber=" + bankroutingnumber + ", sourcename=" + sourcename + ", sourcebank=" + sourcebank + ", regulationamountexceeded=" + regulationamountexceeded + ", sourcefunds=" + sourcefunds + ", destinationfunds=" + destinationfunds + ", transactioncost=" + transactioncost + ", transactioncostcurrencyid=" + transactioncostcurrencyid + ", exchangerate=" + exchangerate + ", fechaejecucion=" + fechaejecucion + '}';
    }
     
    
    
}
