package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        Rover r = new Rover();
        r.move(1, 5);
        r.turnTo(Direction.EAST);
    }

}