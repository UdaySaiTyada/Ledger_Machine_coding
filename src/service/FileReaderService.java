package service;

import constants.FileConstants;
import constants.RegexConstants;
import enums.CommandType;
import model.Command;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderService
{
    public List<Command> readTheInputFileAndGetTheCommands()
    {
        List<Command> commands = new ArrayList<>();
        try
        {
            //the file to be opened for reading
            FileInputStream fis=new FileInputStream(FileConstants.INPUT_FILE_NAME);
            Scanner sc=new Scanner(fis);    //file to be scanned

            //returns true if there is another line to read
            while(sc.hasNextLine())
            {
                String commandString = sc.nextLine();
                CommandType commandType = CommandType.valueOf(commandString.split(RegexConstants.SPACE)[0]);
                Command command;
                switch(commandType)
                {
                    case LOAN:
                    {
                        command = new Command(          commandType,                                            //command
                                                        commandString.split(RegexConstants.SPACE)[1],                      // Bank name
                                                        commandString.split(RegexConstants.SPACE)[2],                      // User Name
                                                        Long.parseLong(commandString.split(RegexConstants.SPACE)[3]),      // Principal amount
                                                        Long.parseLong(commandString.split(RegexConstants.SPACE)[5]),      // rateOfInterest
                                                        Long.parseLong(commandString.split(RegexConstants.SPACE)[4])       // No of years
                                        );
                        commands.add(command);
                        break;
                    }
                    case PAYMENT:
                    {
                        command = new Command(          commandType,                                            //command
                                                        commandString.split(RegexConstants.SPACE)[1],                      // Bank name
                                                        commandString.split(RegexConstants.SPACE)[2],                      // User Name
                                                        Long.parseLong(commandString.split(RegexConstants.SPACE)[3]),      // Principal amount
                                                        Long.parseLong(commandString.split(RegexConstants.SPACE)[4])       // EMI no
                        );
                        commands.add(command);
                        break;
                    }
                    case BALANCE:
                    {
                        command = new Command(          commandType,                                            //command
                                                        commandString.split(RegexConstants.SPACE)[1],                      // Bank name
                                                        commandString.split(RegexConstants.SPACE)[2],                      // User Name
                                                        Long.parseLong(commandString.split(RegexConstants.SPACE)[3])       // EMI no
                        );
                        commands.add(command);
                        break;
                    }
                }
            }
            sc.close();     //closes the scanner
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return commands;
    }
}
