package model;

import enums.CommandType;

public class Command
{
    CommandType commandType;
    String bankName;
    String userName;
    long amount;
    long rateOfInterest;
    long noOfYears;
    long emiNo;

    // Use this constructor when commandType = LOAN
    public Command(CommandType commandType, String bankName, String userName, long amount, long rateOfInterest, long noOfYears) {
        this.commandType = commandType;
        this.bankName = bankName;
        this.userName = userName;
        this.amount = amount;
        this.rateOfInterest = rateOfInterest;
        this.noOfYears = noOfYears;
    }

    // Use this constructor when commandType = PAYMENT
    public Command(CommandType commandType, String bankName, String userName, long amount, long emiNo) {
        this.commandType = commandType;
        this.bankName = bankName;
        this.userName = userName;
        this.amount = amount;
        this.emiNo = emiNo;
    }

    // Use this constructor when commandType = BALANCE
    public Command(CommandType commandType, String bankName, String userName, long emiNo) {
        this.commandType = commandType;
        this.bankName = bankName;
        this.userName = userName;
        this.emiNo = emiNo;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(long rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public long getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(long noOfYears) {
        this.noOfYears = noOfYears;
    }

    public long getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(long emiNo) {
        this.emiNo = emiNo;
    }
}
