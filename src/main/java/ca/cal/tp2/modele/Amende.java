package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Amende {
    @Id
    @GeneratedValue
    @Column(name = "fineID")
    private int fineID;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;

    @ManyToOne
    private Emprunteur emprunteur;

    public double calculMontant(){ return 0;}
    public void updateStatus(){}
}
