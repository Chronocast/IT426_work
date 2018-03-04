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
        IImporter importer = new JSONImporter();
//        IImporter importer = null;
//        switch(strategy)
//        {
//            case "JSON":
//                importer = new JSONImporter();
//                break;
//            case "Java":
//                //importer = new JavaImporter();
//                break;
//            case "XML":
//                //importer = new XMLImporter();
//                break;
//            default:
//                System.out.println("Input not recognized");
//                return;
//        }
        model.loadParts(importer);
        //importer.importParts(model);
    }

    public void exportParts(String strategy)
    {
        IExporter exporter = new JSONExporter();
//        IExporter exporter = null;
//        switch(strategy)
//        {
//            case "Java":
//                //exporter = new JavaExporter();
//                break;
//            case "JSON":
//                new JSONExporter();
//
//                break;
//            case "XML":
//                //exporter = new XMLExporter();
//                break;
//            default:
//                System.out.println("Input not recognized");
//                return;
//        }
        model.saveParts(exporter);
    }
}