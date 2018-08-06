package de.nordakademie.iaa.serialization;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

    private String name;
    private String author;
    private LocalDate datePublished;
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }


    public static final class Builder {
        private String name;
        private String author;
        private LocalDate datePublished;
        private String isbn;

        private Builder() {
        }

        public static Builder aBook() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder withDatePublished(LocalDate datePublished) {
            this.datePublished = datePublished;
            return this;
        }

        public Builder withIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setDatePublished(datePublished);
            book.setIsbn(isbn);
            return book;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", datePublished=" + datePublished +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
