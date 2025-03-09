package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("Livre")
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Livre extends Document{
   String ISBN;
   String auteur;
   String editeur;
   int nombrePages;
   int anneeParution;
}
