package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alexey on 09.07.2016.
 */
public class Rover implements Turnable, Moveable, ProgramFileAware {

    private GroundVisor visor;
    private Direction direction;
    private int x, y;

    public Rover() {
        visor = new GroundVisor();
    }

    @Override
    public void move(int x, int y) {
        if (!visor.hasObstacles(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println("Moved to x = " + x + ", y = " + y);
        }
        else {
            System.out.println("Cannot move to x = " + x + "y = " + y + "! Obstacle is here!");
        }
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
            TextRoverCommandParser parser = new TextRoverCommandParser(this, scanner);
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

    public GroundVisor getVisor() {
        return visor;
    }

}
