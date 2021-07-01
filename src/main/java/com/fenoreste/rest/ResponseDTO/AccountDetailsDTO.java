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
public class AccountDetailsDTO {

    private String AccountBankIdentifier;
    private String AccountOfficerName;
    private Double AccountCountableBalance;
    private Double AccountAvailableBalance;
    private Double AccountBalance24Hrs;
    private Double AccountBalance48Hrs;
    private Double AccountBalance48MoreHrs;
    private Double MonthlyAverageBalance;
    private int PendingChecks;
    private int ChecksToReleaseToday;
    private int ChecksToReleaseTomorrow;
    private int CancelledChecks;
    private int CertifiedChecks;
    private int RejectedChecks;
    private int BlockedAmount;
    private double MovementsOfTheMonth;
    private int ChecksDrawn;
    private Double Overdrafts;
    private String ProductBranchName;
    private String ProductOwnerName;
    private Boolean ShowCurrentAccountChecksInformation;

    public AccountDetailsDTO() {
    }

    public AccountDetailsDTO(String AccountBankIdentifier, String AccountOfficerName, Double AccountCountableBalance, Double AccountAvailableBalance, Double AccountBalance24Hrs, Double AccountBalance48Hrs, Double AccountBalance48MoreHrs, Double MonthlyAverageBalance, int PendingChecks, int ChecksToReleaseToday, int ChecksToReleaseTomorrow, int CancelledChecks, int CertifiedChecks, int RejectedChecks, int BlockedAmount, double MovementsOfTheMonth, int ChecksDrawn, Double Overdrafts, String ProductBranchName, String ProductOwnerName, Boolean ShowCurrentAccountChecksInformation) {
        this.AccountBankIdentifier = AccountBankIdentifier;
        this.AccountOfficerName = AccountOfficerName;
        this.AccountCountableBalance = AccountCountableBalance;
        this.AccountAvailableBalance = AccountAvailableBalance;
        this.AccountBalance24Hrs = AccountBalance24Hrs;
        this.AccountBalance48Hrs = AccountBalance48Hrs;
        this.AccountBalance48MoreHrs = AccountBalance48MoreHrs;
        this.MonthlyAverageBalance = MonthlyAverageBalance;
        this.PendingChecks = PendingChecks;
        this.ChecksToReleaseToday = ChecksToReleaseToday;
        this.ChecksToReleaseTomorrow = ChecksToReleaseTomorrow;
        this.CancelledChecks = CancelledChecks;
        this.CertifiedChecks = CertifiedChecks;
        this.RejectedChecks = RejectedChecks;
        this.BlockedAmount = BlockedAmount;
        this.MovementsOfTheMonth = MovementsOfTheMonth;
        this.ChecksDrawn = ChecksDrawn;
        this.Overdrafts = Overdrafts;
        this.ProductBranchName = ProductBranchName;
        this.ProductOwnerName = ProductOwnerName;
        this.ShowCurrentAccountChecksInformation = ShowCurrentAccountChecksInformation;
    }

    public String getAccountBankIdentifier() {
        return AccountBankIdentifier;
    }

    public void setAccountBankIdentifier(String AccountBankIdentifier) {
        this.AccountBankIdentifier = AccountBankIdentifier;
    }

    public String getAccountOfficerName() {
        return AccountOfficerName;
    }

    public void setAccountOfficerName(String AccountOfficerName) {
        this.AccountOfficerName = AccountOfficerName;
    }

    public Double getAccountCountableBalance() {
        return AccountCountableBalance;
    }

    public void setAccountCountableBalance(Double AccountCountableBalance) {
        this.AccountCountableBalance = AccountCountableBalance;
    }

    public Double getAccountAvailableBalance() {
        return AccountAvailableBalance;
    }

    public void setAccountAvailableBalance(Double AccountAvailableBalance) {
        this.AccountAvailableBalance = AccountAvailableBalance;
    }

    public Double getAccountBalance24Hrs() {
        return AccountBalance24Hrs;
    }

    public void setAccountBalance24Hrs(Double AccountBalance24Hrs) {
        this.AccountBalance24Hrs = AccountBalance24Hrs;
    }

    public Double getAccountBalance48Hrs() {
        return AccountBalance48Hrs;
    }

    public void setAccountBalance48Hrs(Double AccountBalance48Hrs) {
        this.AccountBalance48Hrs = AccountBalance48Hrs;
    }

    public Double getAccountBalance48MoreHrs() {
        return AccountBalance48MoreHrs;
    }

    public void setAccountBalance48MoreHrs(Double AccountBalance48MoreHrs) {
        this.AccountBalance48MoreHrs = AccountBalance48MoreHrs;
    }

    public Double getMonthlyAverageBalance() {
        return MonthlyAverageBalance;
    }

    public void setMonthlyAverageBalance(Double MonthlyAverageBalance) {
        this.MonthlyAverageBalance = MonthlyAverageBalance;
    }

    public int getPendingChecks() {
        return PendingChecks;
    }

    public void setPendingChecks(int PendingChecks) {
        this.PendingChecks = PendingChecks;
    }

    public int getChecksToReleaseToday() {
        return ChecksToReleaseToday;
    }

    public void setChecksToReleaseToday(int ChecksToReleaseToday) {
        this.ChecksToReleaseToday = ChecksToReleaseToday;
    }

    public int getChecksToReleaseTomorrow() {
        return ChecksToReleaseTomorrow;
    }

    public void setChecksToReleaseTomorrow(int ChecksToReleaseTomorrow) {
        this.ChecksToReleaseTomorrow = ChecksToReleaseTomorrow;
    }

    public int getCancelledChecks() {
        return CancelledChecks;
    }

    public void setCancelledChecks(int CancelledChecks) {
        this.CancelledChecks = CancelledChecks;
    }

    public int getCertifiedChecks() {
        return CertifiedChecks;
    }

    public void setCertifiedChecks(int CertifiedChecks) {
        this.CertifiedChecks = CertifiedChecks;
    }

    public int getRejectedChecks() {
        return RejectedChecks;
    }

    public void setRejectedChecks(int RejectedChecks) {
        this.RejectedChecks = RejectedChecks;
    }

    public int getBlockedAmount() {
        return BlockedAmount;
    }

    public void setBlockedAmount(int BlockedAmount) {
        this.BlockedAmount = BlockedAmount;
    }

    public double getMovementsOfTheMonth() {
        return MovementsOfTheMonth;
    }

    public void setMovementsOfTheMonth(double MovementsOfTheMonth) {
        this.MovementsOfTheMonth = MovementsOfTheMonth;
    }

    public int getChecksDrawn() {
        return ChecksDrawn;
    }

    public void setChecksDrawn(int ChecksDrawn) {
        this.ChecksDrawn = ChecksDrawn;
    }

    public Double getOverdrafts() {
        return Overdrafts;
    }

    public void setOverdrafts(Double Overdrafts) {
        this.Overdrafts = Overdrafts;
    }

    public String getProductBranchName() {
        return ProductBranchName;
    }

    public void setProductBranchName(String ProductBranchName) {
        this.ProductBranchName = ProductBranchName;
    }

    public String getProductOwnerName() {
        return ProductOwnerName;
    }

    public void setProductOwnerName(String ProductOwnerName) {
        this.ProductOwnerName = ProductOwnerName;
    }

    public Boolean getShowCurrentAccountChecksInformation() {
        return ShowCurrentAccountChecksInformation;
    }

    public void setShowCurrentAccountChecksInformation(Boolean ShowCurrentAccountChecksInformation) {
        this.ShowCurrentAccountChecksInformation = ShowCurrentAccountChecksInformation;
    }

    @Override
    public String toString() {
        return "GetAccountDetailsDTO{" + "AccountBankIdentifier=" + AccountBankIdentifier + ", AccountOfficerName=" + AccountOfficerName + ", AccountCountableBalance=" + AccountCountableBalance + ", AccountAvailableBalance=" + AccountAvailableBalance + ", AccountBalance24Hrs=" + AccountBalance24Hrs + ", AccountBalance48Hrs=" + AccountBalance48Hrs + ", AccountBalance48MoreHrs=" + AccountBalance48MoreHrs + ", MonthlyAverageBalance=" + MonthlyAverageBalance + ", PendingChecks=" + PendingChecks + ", ChecksToReleaseToday=" + ChecksToReleaseToday + ", ChecksToReleaseTomorrow=" + ChecksToReleaseTomorrow + ", CancelledChecks=" + CancelledChecks + ", CertifiedChecks=" + CertifiedChecks + ", RejectedChecks=" + RejectedChecks + ", BlockedAmount=" + BlockedAmount + ", MovementsOfTheMonth=" + MovementsOfTheMonth + ", ChecksDrawn=" + ChecksDrawn + ", Overdrafts=" + Overdrafts + ", ProductBranchName=" + ProductBranchName + ", ProductOwnerName=" + ProductOwnerName + ", ShowCurrentAccountChecksInformation=" + ShowCurrentAccountChecksInformation + '}';
    }
    
    
    
}
