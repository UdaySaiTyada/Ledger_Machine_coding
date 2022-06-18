package service;

import kotlin.Pair;
import model.Command;
import model.Loan;
import model.Repayment;
import utilities.EmiUtilities;
import utilities.LoanUtilities;

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
                    displayBalance(command);
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
        Pair<String, String> key = new Pair<String, String>(command.getBankName(), command.getUserName());
        loanData.put(key, loan);
        return loan;
    }

    public void processLoan(Command command)
    {
        // Create a Loan Entity
        Loan loan = createLoanEntity(command);
    }

    public void processLumpSumPayment(Command command)
    {
        Pair<String, String> key = new Pair<String, String>(command.getBankName(), command.getUserName());
        Map<Long, Long> repayment = lumpSumPayments.getOrDefault(key, new HashMap<>());
        repayment.put(command.getEmiNo(), command.getAmount());
        lumpSumPayments.put(key, repayment);
    }

    public void displayBalance(Command command)
    {
        long totalAmountPaid = 0;
        long noOfEmisRemaining = 0;

        // Write the logic here

        System.out.print(command.getBankName() + " " + command.getUserName() + " " + totalAmountPaid + " " + noOfEmisRemaining + "\n");

    }
}
