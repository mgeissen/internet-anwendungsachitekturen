package de.nordakademie.iaa.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class SerialisationExample {

    public static final String FILE_LOCATION = "book.object";

    public static void main(String[] args) {
        // create a book
        Book book = Book.Builder.aBook()
                .withAuthor("Matze")
                .withDatePublished(LocalDate.of(1997, 7, 3))
                .withIsbn("123-123-123-123")
                .withName("Nicer Dicer")
                .build();

        // save the book
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_LOCATION))) {
            outputStream.writeObject(book);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
