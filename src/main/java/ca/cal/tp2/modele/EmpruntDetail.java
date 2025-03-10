package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmpruntDetail {
    @Id
    @GeneratedValue
    private int lineItemID;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;


    @ManyToOne
    private Emprunt emprunt;

    @ManyToOne
    private Document document;



    public boolean isEnRetard(){
        return dateRetourActuelle.isAfter(dateRetourPrevue);
    }
    public double calculAmende(){return 0;}
    public void UpdateStatus(){}
}
