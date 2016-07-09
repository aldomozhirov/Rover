package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class MoveCommand implements RoverCommand{

    private Moveable moveable;
    private int x, y;

    public MoveCommand(Moveable moveable, int x, int y) {
        this.moveable = moveable;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.moveable.move(this.x, this.y);
    }

}
