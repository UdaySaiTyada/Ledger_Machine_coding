import exception.GenericException;
import model.Command;
import service.FileReaderService;
import service.LoanService;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws GenericException {
        FileReaderService fileReaderService = new FileReaderService();
        LoanService loanService = new LoanService();

        // Converting the Input from file to Command objects
        List<Command> commands = fileReaderService.readTheInputFileAndGetTheCommands();

        // Processing loans and its payments
        loanService.processLoansAndPayments(commands);

        // Running a simulation of payment of loans by EMIs and lumpsum payment
        loanService.runPaymentSimulation();

        // Displaying balances according to commands
        loanService.displayBalances(commands);
    }
}