package main;

/**
 * Created by Alexey on 09.07.2016.
 */
public class LoggingCommand implements RoverCommand {

    private RoverCommand command;

    public LoggingCommand (RoverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
        System.out.println(command);
    }

}
