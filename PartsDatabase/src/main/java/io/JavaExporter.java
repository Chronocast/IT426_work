package io;

import model.CarPart;
import model.PartsModel;
import java.io.*;
import java.util.Collection;

public class JavaExporter implements IExporter {
    @Override
    public void exportParts(PartsModel data) {
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("files/parts.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Collection<CarPart> parts = data.getParts();
            objectOutputStream.writeObject(parts);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
