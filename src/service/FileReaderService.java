package service;

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
            FileInputStream fis=new FileInputStream("input.txt");
            Scanner sc=new Scanner(fis);    //file to be scanned

            //returns true if there is another line to read
            while(sc.hasNextLine())
            {
                String commandString = sc.nextLine();
                CommandType commandType = CommandType.valueOf(commandString.split(" ")[0]);
                Command command;
                switch(commandType)
                {
                    case LOAN:
                    {
                        command = new Command(          commandType,                                            //command
                                                        commandString.split(" ")[1],                      // Bank name
                                                        commandString.split(" ")[2],                      // User Name
                                                        Long.parseLong(commandString.split(" ")[3]),      // Principal amount
                                                        Long.parseLong(commandString.split(" ")[5]),      // rateOfInterest
                                                        Long.parseLong(commandString.split(" ")[4])       // No of years
                                        );
                        commands.add(command);
                        break;
                    }
                    case PAYMENT:
                    {
                        command = new Command(          commandType,                                            //command
                                                        commandString.split(" ")[1],                      // Bank name
                                                        commandString.split(" ")[2],                      // User Name
                                                        Long.parseLong(commandString.split(" ")[3]),      // Principal amount
                                                        Long.parseLong(commandString.split(" ")[4])       // EMI no
                        );
                        commands.add(command);
                        break;
                    }
                    case BALANCE:
                    {
                        command = new Command(          commandType,                                            //command
                                                        commandString.split(" ")[1],                      // Bank name
                                                        commandString.split(" ")[2],                      // User Name
                                                        Long.parseLong(commandString.split(" ")[3])       // EMI no
                        );
                        commands.add(command);
                        break;
                    }
                }
//                System.out.println(commandString);
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
