package Emanuele_Mangano.Entities;

import jakarta.persistence.*;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "catalog_type")
public abstract class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn;

    private String title;
    private int publicationYear;
    private int numberOfPages;

    public Catalog() {
    }

    public Catalog( String title, int publicationYear, int numberOfPages) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    public long getIsbn() {
        return isbn;
    }


    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
