package io;

import com.google.gson.Gson;
import model.CarPart;
import model.PartsModel;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONImporter implements IImporter
{
    @Override
    public void importParts(PartsModel data)
    {
        Gson gsonImporter = new Gson();
        try
        {
            CarPart carParts = gsonImporter.fromJson(new FileReader("files/parts.json"), CarPart.class);

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
