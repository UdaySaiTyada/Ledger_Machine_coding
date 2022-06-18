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
        loanService.processCommands(commands);
        loanService.runPaymentSimulation();
        loanService.display("IDIDI", "Dale");
    }
}