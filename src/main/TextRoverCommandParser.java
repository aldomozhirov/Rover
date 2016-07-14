package main;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Alexey on 14.07.2016.
 */
public class TextRoverCommandParser {

    private Rover rover;
    private Scanner scanner;

    public TextRoverCommandParser(Rover rover, Scanner scanner) {
        this.rover = rover;
        this.scanner = scanner;
    }

    RoverCommand readNextCommand() throws Exception {
        if (scanner.hasNextLine()) {
            switch (scanner.next()) {
                case "move":
                    return new MoveCommand(rover, scanner.nextInt(), scanner.nextInt());
                case "turn":
                    return new TurnCommand(rover, Direction.valueOf(scanner.next()));
                case "import":
                    Scanner file = new Scanner(new File(scanner.next()));
                    TextRoverCommandParser nestedParser = new TextRoverCommandParser(rover, file);
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
