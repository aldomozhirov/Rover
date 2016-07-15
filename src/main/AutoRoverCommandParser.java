package main;

/**
 * Created by Alexey on 15.07.2016.
 */
public class AutoRoverCommandParser implements RoverCommandParser {

    private RoverCommandParser parser;

    AutoRoverCommandParser(Rover rover, String fileName) {
        switch (fileName.substring(fileName.indexOf(".") + 1)) {
            case "xml":
                parser = new XmlRoverCommandParser(rover, fileName);
                break;
            default:
                parser = new TextRoverCommandParser(rover, fileName);
                break;
        }
    }

    @Override
    public RoverCommand readNextCommand() throws Exception {
        return parser.readNextCommand();
    }
}
