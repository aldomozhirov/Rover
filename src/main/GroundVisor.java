package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class GroundVisor {

    private Ground ground;

    public boolean hasObstacles(int x, int y) throws GroundVisorException {
        if (x < 0 || x > ground.getLength() || y < 0 || y > ground.getWidth())
            throw new GroundVisorException();
        else
            return ground.getLandscape()[x][y].getState() == CellState.OCCUPIED;
    }

}
