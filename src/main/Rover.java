package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alexey on 09.07.2016.
 */
public class Rover implements Turnable, Moveable, ProgramFileAware {

    private Direction direction;
    private int x, y;

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Moved to x = " + x + ", y = " + y);
    }

    @Override
    public void turnTo(Direction direction) {
        this.direction = direction;
        System.out.println("Turned to " + direction);
    }

    @Override
    public void executeProgramFile(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            RoverCommandParser parser = new RoverCommandParser(this, scanner);
            RoverCommand command;
            while ((command = parser.readNextCommand()) != null) {
                command.execute();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
