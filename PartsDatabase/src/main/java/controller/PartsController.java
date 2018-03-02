package controller;

import io.IExporter;
import io.IImporter;
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
        //TODO: add a new part to the PartsModel
    }

    public Collection<CarPart> getParts()
    {
        //TODO: retrieve all parts from the PartsModel
    }

    public void importParts(String strategy)
    {
        //TODO: import parts according to the strategy given
    }

    public void exportParts(String strategy)
    {
        //TODO: export parts according to the strategy given
    }
}
