package io;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import model.CarPart;
import model.PartsModel;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collection;

public class JSONImporter implements IImporter
{
    @Override
    public void importParts(PartsModel data)
    {
        try
        {
            Reader reader = new FileReader("files/parts.json");
            Gson gsonImporter = new Gson();
//            PartsModel carParts = gsonImporter.fromJson(reader, PartsModel.class);
//
//            reader.close();

            JsonElement json = gsonImporter.fromJson(reader, JsonElement.class);
            String jsonString = gsonImporter.toJson(json);
            Collection<CarPart> parts = gsonImporter.fromJson(jsonString, new TypeToken<Collection<CarPart>>(){}.getType());
            parts.forEach(X -> data.addPart(X));

        } catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
    }
}
