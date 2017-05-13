package converter;

import data.Athlete;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class XMLExporter {

    private static final String STYLE_FILE_NAME = "style.xsl";

    public void convertMapToXML(List<Athlete> source, String xmlFileName, Map<String, String> places) throws TransformerException, ParserConfigurationException {
        try {
            Document doc = createXMLHeader();
            Element rootElement = doc.createElement("competition");
            doc.appendChild(rootElement);

            Element participants = doc.createElement("participants");
            rootElement.appendChild(participants);

            fillXMLWithParticipantsInfo(source, places, doc, rootElement, participants);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(xmlFileName));

            transformer.transform(domSource, result);
        } catch (ParserConfigurationException pce) {
            throw new ParserConfigurationException("Failed to parse configuration for xml export to file " + xmlFileName);
        } catch (TransformerException tfe) {
            throw new TransformerException("Failed to write data file " + xmlFileName);
        }
    }

    private void fillXMLWithParticipantsInfo(List<Athlete> source, Map<String, String> places, Document doc, Element rootElement, Element participants) {
        for (Map.Entry<String, String> participant : places.entrySet()) {
            Element entry = doc.createElement("entry");
            rootElement.appendChild(participants);
            Element participantName = createTextNode(doc, "name", participant.getKey());
            entry.appendChild(participantName);
            Element place = createTextNode(doc, "place", participant.getValue());
            entry.appendChild(place);
            Optional<Athlete> winnerAthlete = source.stream().filter(athlete -> athlete.getName()
                    .equals(participant.getKey())).findFirst();
            if (winnerAthlete.isPresent()) {
                Element participantTotalPoints = createTextNode(doc, "total_points", winnerAthlete.get().getTotalPoints().toString());
                entry.appendChild(participantTotalPoints);
                entry.appendChild(addEventsResults(winnerAthlete.get(), doc));
                participants.appendChild(entry);
            }
        }
    }

    private Element addEventsResults(Athlete winnerAthlete, Document doc) {
        Element events = doc.createElement("events");
        winnerAthlete.getEvents()
                .forEach((key, value) -> events.appendChild(createTextNode(doc, key, value)));
        return events;
    }

    private Document createXMLHeader() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        ProcessingInstruction newPI = doc.createProcessingInstruction(
                "xml-stylesheet", "type=\"text/xsl\" href=\""+STYLE_FILE_NAME+"\"");
        doc.insertBefore(newPI, doc.getDocumentElement());
        return doc;
    }

    private Element createTextNode(Document doc, String key, String value) {
        Element element = doc.createElement(key);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

}
