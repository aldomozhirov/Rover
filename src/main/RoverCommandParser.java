package main;

import java.util.Scanner;

/**
 * Created by Alexey on 09.07.2016.
 */
public class RoverCommandParser {

    private Rover rover;
    private Scanner scanner;

    public RoverCommandParser(Rover rover, Scanner scanner) {
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
                default:
                    throw new Exception();
            }
        }
        else {
            return null;
        }
    }

}
