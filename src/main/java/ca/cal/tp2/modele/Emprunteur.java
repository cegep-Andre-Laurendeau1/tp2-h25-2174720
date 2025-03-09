package ca.cal.tp2.modele;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("EMPRUNTEUR")
@Getter
@Setter
@NoArgsConstructor
public class Emprunteur extends Utilisateur{
    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunt = new ArrayList<>();

    @OneToMany(mappedBy = "emprunteur")
    private List<Amende> amendes = new ArrayList<>();


    public Emprunteur(String name, String email, String phoneNumber, List<Emprunt> emprunteur, List<Amende> amendes) {
        super(name, email, phoneNumber);
        this.amendes = amendes;
        this.emprunt = emprunteur;
    }

    public String toString() {
        return "Emprunteur{" +
                "userID=" + getUserID() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", emprunt=" + emprunt +
                ", amendes=" + amendes +
                '}';
    }

}
