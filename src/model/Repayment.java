package model;

import enums.RepaymentType;

public class Repayment extends RepaymentDBObject
{
    long amount;
    RepaymentType repaymentType;
    long remainingAmount;
    long emiNo;
    long noOfEmisRemaining;

    public long getNoOfEmisRemaining() {
        return noOfEmisRemaining;
    }

    public void setNoOfEmisRemaining(long noOfEmisRemaining) {
        this.noOfEmisRemaining = noOfEmisRemaining;
    }

    public long getEmiNo() {
        return emiNo;
    }

    public void setEmiNo(long emiNo) {
        this.emiNo = emiNo;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public RepaymentType getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(RepaymentType repaymentType) {
        this.repaymentType = repaymentType;
    }

    public long getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(long remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Repayment(long amount, RepaymentType repaymentType, long remainingAmount, long emiNo, long noOfEmisRemaining) {
        this.amount = amount;
        this.repaymentType = repaymentType;
        this.remainingAmount = remainingAmount;
        this.emiNo = emiNo;
        this.noOfEmisRemaining = noOfEmisRemaining;
    }
}
