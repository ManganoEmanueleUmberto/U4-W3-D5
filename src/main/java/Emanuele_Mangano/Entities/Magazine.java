package Emanuele_Mangano.Entities;

import Emanuele_Mangano.Enums.Periodicity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("Magazine")
public class Magazine extends Catalog {

    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine( String title, int publicationYear, int numberOfPages, Periodicity periodicity) {
        super( title, publicationYear, numberOfPages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
}
