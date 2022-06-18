package model;

public class Loan extends LoanDBObject
{
    String bankName;
    String userName;
    long principalAmount;
    long totalNumberOfMonths;
    long rateOfInterest;
    long interest;
    long amount;
    long emiAmount;

    public Loan(String bankName, String userName, long principalAmount, long totalNumberOfMonths, long rateOfInterest, long interest, long amount, long emiAmount) {
        this.bankName = bankName;
        this.userName = userName;
        this.principalAmount = principalAmount;
        this.totalNumberOfMonths = totalNumberOfMonths;
        this.rateOfInterest = rateOfInterest;
        this.interest = interest;
        this.amount = amount;
        this.emiAmount = emiAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(long principalAmount) {
        this.principalAmount = principalAmount;
    }

    public long getTotalNumberOfMonths() {
        return totalNumberOfMonths;
    }

    public void setTotalNumberOfMonths(long totalNumberOfMonths) {
        this.totalNumberOfMonths = totalNumberOfMonths;
    }

    public long getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(long rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public long getInterest() {
        return interest;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(long emiAmount) {
        this.emiAmount = emiAmount;
    }
}
