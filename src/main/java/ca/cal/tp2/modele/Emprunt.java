package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue
    @Column(name = "borrowID" )
    private int borrowID;
    @Column(name = "dateEmprunt")
    private Date dateEmprunt;
    @Column(name = "status")
    private String status;

    @ManyToOne
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetail> detailsEmprunts;

    public Document getItems(){ return null;}
}
