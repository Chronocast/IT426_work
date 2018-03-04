package io;

import model.CarPart;
import model.PartsModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Collection;

public class XMLExporter implements IExporter {

    @Override
    public void exportParts(PartsModel data)
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;

        try {
            docBuilder = docFactory.newDocumentBuilder();

            // root element parts
            Document doc = docBuilder.newDocument();
            Element root = doc.createElement("company");
            doc.appendChild(root);

            Collection<CarPart> parts = data.getParts();

            for (CarPart aPart : parts)
            {
                //part element
                Element part = doc.createElement("part");
                root.appendChild(part);

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(String.valueOf(aPart.getId())));
                part.appendChild(id);

                Element manufacturer = doc.createElement("manufacturer");
                manufacturer.appendChild(doc.createTextNode(String.valueOf(aPart.getManufacturer())));
                part.appendChild(manufacturer);

                Element listPrice = doc.createElement("listPrice");
                listPrice.appendChild(doc.createTextNode(String.valueOf(aPart.getListPrice())));
                part.appendChild(listPrice);
            }
            
            //write
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("files/parts.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
