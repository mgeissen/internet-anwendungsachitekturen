package de.nordakademie.iaa.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {

    public static void main(String[] args) {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(SerialisationExample.FILE_LOCATION))) {
            Book book = (Book) inputStream.readObject();
            System.out.println(book.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
