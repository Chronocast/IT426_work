package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CarPart;
import model.PartsModel;

import java.io.*;
import java.util.Collection;

public class JSONExporter implements IExporter
{
    @Override
    public void exportParts(PartsModel data)
    {
        Collection<CarPart> parts = data.getParts();

        Gson gsonExporter = new GsonBuilder().setPrettyPrinting().create();
        try
        {
            gsonExporter.toJson(parts, new FileWriter("files/parts.json"));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
