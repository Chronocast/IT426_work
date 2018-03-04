package io;

import com.google.gson.Gson;
import model.CarPart;
import model.PartsModel;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collection;

public class JSONImporter implements IImporter
{
    @Override
    public void importParts(PartsModel data)
    {
        Gson gsonImporter = new Gson();
        try
        {
            //Collection<CarPart> parts = data.getParts();
            Reader reader = new FileReader("files/parts.json");
            CarPart carParts = gsonImporter.fromJson(reader, CarPart.class);
            //reader.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
