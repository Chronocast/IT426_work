package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CarPart;
import model.PartsModel;
import java.io.*;
import java.util.Collection;
import java.util.Collections;

public class JSONExporter implements IExporter
{
    @Override
    public void exportParts(PartsModel data)
    {
        try
        {
            Collection<CarPart> parts = data.getParts();
            Gson gsonExporter = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter("files/parts.json");
            gsonExporter.toJson(parts, writer);
            writer.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
