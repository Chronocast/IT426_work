package io;

import model.CarPart;
import model.PartsModel;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class XMLImporter implements IImporter
{
    private Collection<CarPart> carParts;
    private PartsModel partsModel;

    @Override
    public void importParts(PartsModel data) {
        partsModel = data;
        try {
            File fXmlFile = new File("files/parts.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("part");

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    String id = element.getElementsByTagName("id").item(0).getTextContent();
                    String manufacturer = element.getElementsByTagName("manufacturer").item(0).getTextContent();
                    Double listPrice = Double.parseDouble(element.getElementsByTagName("listPrice").item(0).getTextContent());
                    data.addPart(new CarPart(id, manufacturer, listPrice));
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
