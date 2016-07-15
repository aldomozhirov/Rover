package main;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 14.07.2016.
 */
public class XmlRoverCommandParser implements RoverCommandParser {

    private Rover rover;
    private Document document;
    private Node root;
    private int i = 1;

    XmlRoverCommandParser(Rover rover, String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.parse(fileName);
            this.rover = rover;
            this.root = document.getFirstChild();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RoverCommand readNextCommand() throws Exception {

        RoverCommand command = null;
        Node curNode = root.getChildNodes().item(i);

        if (curNode != null) {
            NamedNodeMap curAttr = curNode.getAttributes();

            switch (curNode.getNodeName()) {
                case "move":
                    Attr x = (Attr) curAttr.getNamedItem("x");
                    Attr y = (Attr) curAttr.getNamedItem("y");
                    command = new MoveCommand(rover, Integer.parseInt(x.getValue()), Integer.parseInt(y.getValue()));
                    break;
                case "turn":
                    Attr direction = (Attr) curAttr.getNamedItem("direction");
                    command = new TurnCommand(rover, Direction.valueOf(direction.getValue()));
                    break;
                case "import":
                    Attr filename = (Attr) curAttr.getNamedItem("filename");
                    RoverCommandParser nestedParser = new AutoRoverCommandParser(rover, filename.getValue());
                    ImportCommand importCommand = new ImportCommand();
                    RoverCommand nestedCommand;
                    while ((nestedCommand = nestedParser.readNextCommand()) != null) {
                        importCommand.add(nestedCommand);
                    }
                    command = importCommand;
                    break;
                default:
                    throw new Exception();
            }

            i += 2;
        }

        return command;

    }

}
