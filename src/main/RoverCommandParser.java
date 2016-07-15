package main;

/**
 * Created by Alexey on 15.07.2016.
 */
public interface RoverCommandParser {

    RoverCommand readNextCommand() throws Exception;

}
