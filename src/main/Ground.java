package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class Ground {

    private GroundCell[][] landscape;
    private int length, width;

    public Ground (int length, int width) {
        this.landscape = new GroundCell[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                this.landscape[i][j] = new GroundCell();
            }
        }

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
