package Emanuele_Mangano.Entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Catalog {
    private String author;
    private String genre;

    public Book() {
    }

    public Book( String title, int publicationYear, int numberOfPages, String author, String genre) {
        super( title, publicationYear, numberOfPages);
        this.author = author;
        this.genre = genre;
    }

    // Getters and setters
}