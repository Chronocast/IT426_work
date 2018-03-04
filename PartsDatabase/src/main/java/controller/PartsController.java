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
        CarPart thisPart = new CarPart(id, manufacturer, listPrice);
        model.addPart(thisPart);
    }

    public Collection<CarPart> getParts()
    {
        return model.getParts();
    }

    public void importParts(String strategy)
    {
        //TODO: import parts according to the strategy given
        //model.loadParts(strategy);
    }

    public void exportParts(String strategy)
    {
        //TODO: export parts according to the strategy given
        model.saveParts();
    }
}
