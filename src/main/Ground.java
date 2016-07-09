package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class Ground {

    private GroundCell[][] landscape;
    private int length, width;

    public Ground (int length, int width) {
        this.landscape = new GroundCell[length][width];
        this.length = length;
        this.width = width;
    }

    public GroundCell[][] getLandscape() {
        return landscape;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

}
