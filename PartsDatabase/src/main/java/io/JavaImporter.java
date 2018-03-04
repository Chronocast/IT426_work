package io;

import model.CarPart;
import model.PartsModel;
import java.io.*;
import java.util.Collection;

public class JavaImporter implements IImporter
{
    @Override
    public void importParts(PartsModel data) {
        try {
            FileInputStream fileInputStream = new FileInputStream("files/parts.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Collection<CarPart> parts = (Collection<CarPart>) objectInputStream.readObject();
            parts.forEach(X->data.addPart(X));
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
