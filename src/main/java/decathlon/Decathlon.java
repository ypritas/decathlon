package decathlon;

import calculation.PlaceCalculator;
import converter.XMLExporter;
import data.Athlete;
import fileutils.CSVReader;
import parser.AthletesParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Decathlon {

    public static void main(String[] args) throws IOException {
        if (args[0] == null && args[1] == null) {
            System.out.println("You have not entered input and output data filename.");
            System.out.println("Decathlon command line parameters is input and output data files.");
            return;
        }
        if (args[0] == null) {
            System.out.println("You have not entered input data filename.");
            return;
        }
        if (args[1] == null) {
            System.out.println("You have not entered output filename.");
            return;
        }

        try {
            File inputDataFile = new File(args[0]);
            List<List<String>> result = new CSVReader().loadFile(inputDataFile.getAbsolutePath());
            List<Athlete> calculatedData = new AthletesParser().parseAthletes(result);
            new XMLExporter().convertMapToXML(calculatedData, args[1], PlaceCalculator.getPlaces(calculatedData));
        } catch (IOException|TransformerException|ParserConfigurationException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}
