/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;



/**
 *
 * @author wilmer
 */
public class AccountLast5MovementsDTO {

    private int MovementId;
    private String AccountBankIdentifier;
    private String MovementDate;
    private String Description;
    private Double Amount;
    private boolean isDebit;
    private Double Balance;
    private int MovementTypeId;
    private String TypeDescription;
    private String CheckId;
    private String VoucherId;

    public AccountLast5MovementsDTO() {
    }

    public AccountLast5MovementsDTO(int MovementId, String AccountBankIdentifier, String MovementDate, String Description, Double Amount, boolean isDebit, Double Balance, int MovementTypeId, String TypeDescription, String CheckId, String VoucherId) {
        this.MovementId = MovementId;
        this.AccountBankIdentifier = AccountBankIdentifier;
        this.MovementDate = MovementDate;
        this.Description = Description;
        this.Amount = Amount;
        this.isDebit = isDebit;
        this.Balance = Balance;
        this.MovementTypeId = MovementTypeId;
        this.TypeDescription = TypeDescription;
        this.CheckId = CheckId;
        this.VoucherId = VoucherId;
    }

    public int getMovementId() {
        return MovementId;
    }

    public void setMovementId(int MovementId) {
        this.MovementId = MovementId;
    }

    public String getAccountBankIdentifier() {
        return AccountBankIdentifier;
    }

    public void setAccountBankIdentifier(String AccountBankIdentifier) {
        this.AccountBankIdentifier = AccountBankIdentifier;
    }

    public String getMovementDate() {
        return MovementDate;
    }

    public void setMovementDate(String MovementDate) {
        this.MovementDate = MovementDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public boolean isIsDebit() {
        return isDebit;
    }

    public void setIsDebit(boolean isDebit) {
        this.isDebit = isDebit;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double Balance) {
        this.Balance = Balance;
    }

    public int getMovementTypeId() {
        return MovementTypeId;
    }

    public void setMovementTypeId(int MovementTypeId) {
        this.MovementTypeId = MovementTypeId;
    }

    public String getTypeDescription() {
        return TypeDescription;
    }

    public void setTypeDescription(String TypeDescription) {
        this.TypeDescription = TypeDescription;
    }

    public String getCheckId() {
        return CheckId;
    }

    public void setCheckId(String CheckId) {
        this.CheckId = CheckId;
    }

    public String getVoucherId() {
        return VoucherId;
    }

    public void setVoucherId(String VoucherId) {
        this.VoucherId = VoucherId;
    }

    @Override
    public String toString() {
        return "GetAccountLast5MovementsDTO{" + "MovementId=" + MovementId + ", AccountBankIdentifier=" + AccountBankIdentifier + ", MovementDate=" + MovementDate + ", Description=" + Description + ", Amount=" + Amount + ", isDebit=" + isDebit + ", Balance=" + Balance + ", MovementTypeId=" + MovementTypeId + ", TypeDescription=" + TypeDescription + ", CheckId=" + CheckId + ", VoucherId=" + VoucherId + '}';
    }
    
    
}
