package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alexey on 14.07.2016.
 */
public class TextRoverCommandParser implements RoverCommandParser{

    private Rover rover;
    private Scanner scanner;

    public TextRoverCommandParser(Rover rover, String fileName) {
        try {
            this.rover = rover;
            this.scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RoverCommand readNextCommand() throws Exception {
        if (scanner.hasNextLine()) {
            switch (scanner.next()) {
                case "move":
                    return new MoveCommand(rover, scanner.nextInt(), scanner.nextInt());
                case "turn":
                    return new TurnCommand(rover, Direction.valueOf(scanner.next()));
                case "import":
                    RoverCommandParser nestedParser = new AutoRoverCommandParser(rover, scanner.next());
                    ImportCommand importCommand = new ImportCommand();
                    RoverCommand command;
                    while ((command = nestedParser.readNextCommand()) != null) {
                        importCommand.add(command);
                    }
                    return importCommand;
                default:
                    throw new Exception();
            }
        }
        else {
            return null;
        }
    }

}
