package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class Rover implements Turnable, Moveable {

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

}
