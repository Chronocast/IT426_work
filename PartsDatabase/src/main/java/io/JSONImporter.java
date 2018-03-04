package io;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import model.CarPart;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONImporter
{
    public void getGsonImporter() throws FileNotFoundException
    {
        Gson gsonImporter = new Gson();
        CarPart carParts = gsonImporter.fromJson(
                new FileReader("parts.json"), CarPart.class);
    }
}
