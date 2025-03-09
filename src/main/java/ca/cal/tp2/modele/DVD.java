package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("DVD")
@Getter
@Setter
@NoArgsConstructor
public class DVD extends Document {
    private String director;
    private int duree;
    private String rating;

    @Override
    public String toString() {
        return "DVD{" +
                "titre='" + getTitre() + '\'' +
                ", director='" + director + '\'' +
                ", duree=" + duree +
                ", rating='" + rating + '\'' +
                '}';
    }
}