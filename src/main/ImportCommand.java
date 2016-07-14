package main;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexey on 09.07.2016.
 */
public class ImportCommand implements RoverCommand {

    private List<RoverCommand> list = new LinkedList<>();


    @Override
    public void execute() {
        for (RoverCommand command : list) {
            command.execute();
        }
    }

    public void add(RoverCommand command) {
        list.add(command);
    }

    public void remove(RoverCommand command) {
        list.remove(command);
    }

}
