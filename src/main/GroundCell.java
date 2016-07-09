package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class GroundCell {

    private CellState state = CellState.FREE;
    private int x, y;

    public CellState getState() {
        return state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
