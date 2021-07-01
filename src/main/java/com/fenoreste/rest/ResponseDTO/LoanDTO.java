/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

import com.fenoreste.rest.entidades.Amortizaciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elliot
 */
public class LoanDTO {

    private String AccountBankIdentifier;
    private Double CurrentBalance;
    private Double CurrentRate;
    private int FeesDue;
    private FeesDueData FeesDueData;
    private int LoanStatusId;
    private LoanFee NextFee;
    private Double OriginalAmount;
    private int OverdueDays;
    private int PaidFees;
    private Double PayoffBalance;
    private Double PrepaymentAmount;
    private String ProductBankIdentifier;
    private int term;
    private boolean showPrincipalInformation;
    private List<LoanFee> loanFeesResult;
    private List<LoanRate> loanRateResult;
    private List<LoanPayment> loanPaymentsResult;

    public LoanDTO() {
    }

    public LoanDTO(String AccountBankIdentifier, Double CurrentBalance, Double CurrentRate, int FeesDue, FeesDueData FeesDueData, int LoanStatusId, LoanFee NextFee, Double OriginalAmount, int OverdueDays, int PaidFees, Double PayoffBalance, Double PrepaymentAmount, String ProductBankIdentifier, int term, boolean showPrincipalInformation, List<LoanFee> loanFeesResult, List<LoanRate> loanRateResult, List<LoanPayment> loanPaymentsResult) {
        this.AccountBankIdentifier = AccountBankIdentifier;
        this.CurrentBalance = CurrentBalance;
        this.CurrentRate = CurrentRate;
        this.FeesDue = FeesDue;
        this.FeesDueData = FeesDueData;
        this.LoanStatusId = LoanStatusId;
        this.NextFee = NextFee;
        this.OriginalAmount = OriginalAmount;
        this.OverdueDays = OverdueDays;
        this.PaidFees = PaidFees;
        this.PayoffBalance = PayoffBalance;
        this.PrepaymentAmount = PrepaymentAmount;
        this.ProductBankIdentifier = ProductBankIdentifier;
        this.term = term;
        this.showPrincipalInformation = showPrincipalInformation;
        this.loanFeesResult = loanFeesResult;
        this.loanRateResult = loanRateResult;
        this.loanPaymentsResult = loanPaymentsResult;
    }

    public String getAccountBankIdentifier() {
        return AccountBankIdentifier;
    }

    public void setAccountBankIdentifier(String AccountBankIdentifier) {
        this.AccountBankIdentifier = AccountBankIdentifier;
    }

    public Double getCurrentBalance() {
        return CurrentBalance;
    }

    public void setCurrentBalance(Double CurrentBalance) {
        this.CurrentBalance = CurrentBalance;
    }

    public Double getCurrentRate() {
        return CurrentRate;
    }

    public void setCurrentRate(Double CurrentRate) {
        this.CurrentRate = CurrentRate;
    }

    public int getFeesDue() {
        return FeesDue;
    }

    public void setFeesDue(int FeesDue) {
        this.FeesDue = FeesDue;
    }

    public FeesDueData getFeesDueData() {
        return FeesDueData;
    }

    public void setFeesDueData(FeesDueData FeesDueData) {
        this.FeesDueData = FeesDueData;
    }

    public int getLoanStatusId() {
        return LoanStatusId;
    }

    public void setLoanStatusId(int LoanStatusId) {
        this.LoanStatusId = LoanStatusId;
    }

    public LoanFee getNextFee() {
        return NextFee;
    }

    public void setNextFee(LoanFee NextFee) {
        this.NextFee = NextFee;
    }

    public Double getOriginalAmount() {
        return OriginalAmount;
    }

    public void setOriginalAmount(Double OriginalAmount) {
        this.OriginalAmount = OriginalAmount;
    }

    public int getOverdueDays() {
        return OverdueDays;
    }

    public void setOverdueDays(int OverdueDays) {
        this.OverdueDays = OverdueDays;
    }

    public int getPaidFees() {
        return PaidFees;
    }

    public void setPaidFees(int PaidFees) {
        this.PaidFees = PaidFees;
    }

    public Double getPayoffBalance() {
        return PayoffBalance;
    }

    public void setPayoffBalance(Double PayoffBalance) {
        this.PayoffBalance = PayoffBalance;
    }

    public Double getPrepaymentAmount() {
        return PrepaymentAmount;
    }

    public void setPrepaymentAmount(Double PrepaymentAmount) {
        this.PrepaymentAmount = PrepaymentAmount;
    }

    public String getProductBankIdentifier() {
        return ProductBankIdentifier;
    }

    public void setProductBankIdentifier(String ProductBankIdentifier) {
        this.ProductBankIdentifier = ProductBankIdentifier;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public boolean isShowPrincipalInformation() {
        return showPrincipalInformation;
    }

    public void setShowPrincipalInformation(boolean showPrincipalInformation) {
        this.showPrincipalInformation = showPrincipalInformation;
    }

    public List<LoanFee> getLoanFeesResult() {
        return loanFeesResult;
    }

    public void setLoanFeesResult(List<LoanFee> loanFeesResult) {
        this.loanFeesResult = loanFeesResult;
    }

    public List<LoanRate> getLoanRateResult() {
        return loanRateResult;
    }

    public void setLoanRateResult(List<LoanRate> loanRateResult) {
        this.loanRateResult = loanRateResult;
    }

    public List<LoanPayment> getLoanPaymentsResult() {
        return loanPaymentsResult;
    }

    public void setLoanPaymentsResult(List<LoanPayment> loanPaymentsResult) {
        this.loanPaymentsResult = loanPaymentsResult;
    }

    @Override
    public String toString() {
        return "LoanDTO{" + "AccountBankIdentifier=" + AccountBankIdentifier + ", CurrentBalance=" + CurrentBalance + ", CurrentRate=" + CurrentRate + ", FeesDue=" + FeesDue + ", FeesDueData=" + FeesDueData + ", LoanStatusId=" + LoanStatusId + ", NextFee=" + NextFee + ", OriginalAmount=" + OriginalAmount + ", OverdueDays=" + OverdueDays + ", PaidFees=" + PaidFees + ", PayoffBalance=" + PayoffBalance + ", PrepaymentAmount=" + PrepaymentAmount + ", ProductBankIdentifier=" + ProductBankIdentifier + ", term=" + term + ", showPrincipalInformation=" + showPrincipalInformation + ", loanFeesResult=" + loanFeesResult + ", loanRateResult=" + loanRateResult + ", loanPaymentsResult=" + loanPaymentsResult + '}';
    }

}
