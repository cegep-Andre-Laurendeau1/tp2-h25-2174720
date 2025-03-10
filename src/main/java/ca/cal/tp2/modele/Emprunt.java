package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue
    @Column(name = "borrowID")
    private int borrowID;
    @Column(name = "dateEmprunt")
    private Date dateEmprunt;
    @Column(name = "status")
    private String status;

    @ManyToOne
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetail> detailsEmprunts;

    public List<Document> getItems() {
        List<Document> documents = new ArrayList<>();
        for (EmpruntDetail detail : detailsEmprunts) {
            documents.add(detail.getDocument());
        }
        return documents;
    }
}
