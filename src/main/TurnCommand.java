package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class TurnCommand implements RoverCommand {

    private Turnable turnable;
    private Direction direction;

    public TurnCommand(Turnable turnable, Direction direction) {
        this.turnable = turnable;
        this.direction = direction;
    }

    @Override
    public void execute() {
        this.turnable.turnTo(this.direction);
    }

    @Override
    public String toString() {
        return "turn " + direction;
    }

}
