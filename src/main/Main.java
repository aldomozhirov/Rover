package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        Rover r = new Rover();
        r.getVisor().setGround(new Ground(20, 20));
        r.executeProgramFile("xmlcommands.xml");
    }

}
