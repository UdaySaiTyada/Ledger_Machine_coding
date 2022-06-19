package service;

import enums.CommandType;
import enums.RepaymentType;
import kotlin.Pair;
import model.Command;
import model.Loan;
import model.Repayment;
import utilities.EmiUtilities;
import utilities.LoanUtilities;
import utilities.MapUtilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanService
{
    Map<Pair<String, String>, List<Repayment>> repaymentData = new HashMap<>();
    Map<Pair<String, String>, Loan> loanData = new HashMap<>();
    Map<Pair<String, String>, Map<Long, Long>> lumpSumPayments = new HashMap<>();

    public void processCommands(List<Command> commands)
    {
        for(Command command: commands)
        {
            switch(command.getCommandType())
            {
                case LOAN:
                {
                    processLoan(command);
                    break;
                }
                case PAYMENT:
                {
                    processLumpSumPayment(command);
                    break;
                }
                case BALANCE:
                {
//                    displayBalance(command);
                    break;
                }
            }
        }
    }

    public Loan createLoanEntity(Command command)
    {
        Loan loan = new Loan(   command.getBankName(),
                                command.getUserName(),
                                command.getAmount(),
                                EmiUtilities.getNoOfMonths(command.getNoOfYears()),
                                command.getRateOfInterest(),
                                LoanUtilities.getInterest(command.getAmount(), command.getRateOfInterest(), command.getNoOfYears()),
                                LoanUtilities.getAmount(command.getAmount(), command.getRateOfInterest(), command.getNoOfYears()),
                                EmiUtilities.getEmi(LoanUtilities.getAmount(command.getAmount(), command.getRateOfInterest(), command.getNoOfYears()),
                                                    command.getNoOfYears()
                                )
                                );
        Pair<String, String> key = MapUtilities.getKey(command.getBankName(), command.getUserName());
        loanData.put(key, loan);

        lumpSumPayments.put(key, new HashMap<>());
        return loan;
    }

    public void processLoan(Command command)
    {
        // Create a Loan Entity
        Loan loan = createLoanEntity(command);

        // Create an empty record in repayments map
        Pair<String, String> key = MapUtilities.getKey(command.getBankName(), command.getUserName());
        List<Repayment> repayments = new ArrayList<>();
        Repayment repayment = new Repayment(0, RepaymentType.EMI, loan.getAmount(), 0);
        repayments.add(repayment);
        repaymentData.put(key, repayments);
    }

    public void processLumpSumPayment(Command command)
    {
        Pair<String, String> key = MapUtilities.getKey(command.getBankName(), command.getUserName());
        Map<Long, Long> repayment = lumpSumPayments.getOrDefault(key, new HashMap<>());
        repayment.put(command.getEmiNo(), command.getAmount());
        lumpSumPayments.put(key, repayment);
    }

    public void runPaymentSimulation()
    {
        for(Pair<String, String> key : loanData.keySet())
        {
            Loan loan = loanData.get(key);
            for (long emiNo = 0; emiNo <= loan.getTotalNumberOfMonths();)
            {
                List<Repayment> repayments = repaymentData.get(key);
                if(lumpSumPayments.get(key).containsKey(emiNo))
                {

                    Repayment repayment = repayments.get(repayments.size() - 1);
                    if(repayment.getRemainingAmount() == 0) break;
                    long newRemainingAmount = repayment.getRemainingAmount() - lumpSumPayments.get(key).get(emiNo);
                    Repayment newRepayment = new Repayment(lumpSumPayments.get(key).get(emiNo), RepaymentType.LUMP_SUM_PAYMENT, newRemainingAmount, emiNo);
                    repayments.add(newRepayment);
                    repaymentData.put(key, repayments);
                }
                if(emiNo == loan.getTotalNumberOfMonths()) break;
                emiNo++;
                Repayment repayment = repayments.get(repayments.size() - 1);
                if(repayment.getRemainingAmount() == 0) break;
                long amountToPay = EmiUtilities.getRemainingEmi(repayment.getRemainingAmount(), loan.getEmiAmount());
                long newRemainingAmount = repayment.getRemainingAmount() - amountToPay;
                Repayment newRepayment = new Repayment(amountToPay, RepaymentType.EMI, newRemainingAmount, emiNo);
                repayments.add(newRepayment);
                repaymentData.put(key, repayments);
            }
        }
    }

    public void displayBalances(List<Command> commands)
    {
        for(Command command : commands)
        {
            if(command.getCommandType() == CommandType.BALANCE)
                displayBalance(command);
        }
    }

    public void displayBalance(Command command)
    {
        long totalAmountPaid = 0;
        long noOfEmisRemaining = 0;
        long lumpSumPayments = 0;


        Pair<String, String> key = MapUtilities.getKey(command.getBankName(), command.getUserName());
        List<Repayment> repayments = repaymentData.get(key);
        Loan loan = loanData.get(key);
        for (Repayment repayment: repayments)
        {
            if(repayment.getRepaymentType() == RepaymentType.LUMP_SUM_PAYMENT)
                lumpSumPayments++;
            if(repayment.getEmiNo() == command.getEmiNo())
                totalAmountPaid = loan.getAmount() - repayment.getRemainingAmount();
            if(repayment.getEmiNo() > command.getEmiNo() && repayment.getRepaymentType() == RepaymentType.EMI)
                noOfEmisRemaining ++;
        }
        // Write the logic here

        System.out.print(command.getBankName() + " " + command.getUserName() + " " + totalAmountPaid + " " + noOfEmisRemaining + "\n");

    }

    public void display (String bankName, String userName)
    {
        Pair<String, String> key = new Pair<>(bankName, userName);
        Loan loan = loanData.get(key);
        List<Repayment> repayments = repaymentData.get(key);
        for(Repayment repayment: repayments)
        {
            System.out.println(repayment.getRepaymentType() + " " + repayment.getAmount() + " " + (loan.getAmount() - repayment.getRemainingAmount())+ " " + repayment.getEmiNo());
        }
    }
}
