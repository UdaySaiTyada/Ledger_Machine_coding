package service;

import model.Command;

import java.util.List;

public class LoanService
{
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

    public void processLoan(Command command)
    {
    }

    public void processLumpSumPayment(Command command)
    {
    }

    public void displayBalance(Command command)
    {
        long totalAmountPaid = 0;
        long noOfEmisRemaining = 0;

        // Write the logic here

        System.out.print(command.getBankName() + " " + command.getUserName() + " " + totalAmountPaid + " " + noOfEmisRemaining + "\n");

    }
}
