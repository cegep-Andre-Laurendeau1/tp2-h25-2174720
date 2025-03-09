package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

//Apparemment il faut utiliser @Value ici selon la document que j'ai trouvé
@Entity
@DiscriminatorValue("CD")
@Getter
@Setter
@NoArgsConstructor
public class CD extends Document {
    String artiste;
    int duree;
    String genre;

    @Override
    public String toString() {
        return "DVD{" +
                "titre='" + getTitre() + '\'' +
                ", artiste='" + artiste + '\'' +
                ", duree=" + duree +
                ", genre='" + genre + '\'' +
                '}';
    }

}
