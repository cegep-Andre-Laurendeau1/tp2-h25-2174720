package ca.cal.tp2.modele;

import ca.cal.tp2.service.PreposeService;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("PREPOSE")
@Getter
@Setter
@NoArgsConstructor
public class Prepose extends Utilisateur {

    public Prepose(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
    }

    public void entreNouveauDocument(Document doc, PreposeService preposeService){
        preposeService.addDocument(doc);
    }

    public void collecteAmende(Emprunteur emprunteur, double montant){}
    public void rapportAmendes(){}
    public void rapportEmprunts(){}

    @Override
    public String toString() {
        return "Prepose{" +
                "userID=" + getUserID() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}