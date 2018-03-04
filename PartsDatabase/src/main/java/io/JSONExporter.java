package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CarPart;

import java.io.*;

public class JSONExporter
{
    public JSONExporter(CarPart[] parts) throws IOException
    {
        Writer writer = new OutputStreamWriter(new FileOutputStream("parts.json") , "UTF-8");

        Gson gsonExporter = new GsonBuilder().setPrettyPrinting().create();

        gsonExporter.toJson("Hello", writer);
    }
}
