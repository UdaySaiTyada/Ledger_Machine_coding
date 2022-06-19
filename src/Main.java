import model.Command;
import service.FileReaderService;
import service.LoanService;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        FileReaderService fileReaderService = new FileReaderService();
        LoanService loanService = new LoanService();

        List<Command> commands = fileReaderService.readTheInputFileAndGetTheCommands();
        loanService.processLoansAndPayments(commands);
        loanService.runPaymentSimulation();
        loanService.displayBalances(commands);
    }
}