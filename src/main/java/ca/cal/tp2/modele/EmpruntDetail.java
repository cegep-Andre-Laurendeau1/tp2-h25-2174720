package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.Date;
@Entity

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
