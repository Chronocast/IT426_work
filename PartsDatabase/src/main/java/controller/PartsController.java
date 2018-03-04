package controller;

import io.*;
import model.CarPart;
import model.PartsModel;

import java.util.Collection;

public class PartsController
{
    private PartsModel model;

    public PartsController()
    {
        model = new PartsModel();
    }

    public void addPart(String id, String manufacturer, double listPrice)
    {
        CarPart thisPart = new CarPart(id, manufacturer, listPrice);
        model.addPart(thisPart);
    }

    public Collection<CarPart> getParts()
    {
        return model.getParts();
    }

    public void importParts(String strategy)
    {
        IImporter importer = null;
        switch(strategy)
        {
            case "JSON":
                importer = new JSONImporter();
                break;
            case "Java":
                //importer = new JavaImporter();
                break;
            case "XML":
                //importer = new XMLImporter();
                break;
            default:
                System.out.println("Input not recognized");
                return;
        }
        model.loadParts(importer);
    }

    public void exportParts(String strategy)
    {
        IExporter exporter = null;
        switch(strategy)
        {
            case "JSON":
                exporter = new JSONExporter();
                break;
            case "Java":
                //exporter = new JavaExporter();
                break;
            case "XML":
                //exporter = new XMLExporter();
                break;
            default:
                System.out.println("Input not recognized");
                return;
        }
        model.saveParts(exporter);
    }
}