package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "DOCUMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@DiscriminatorColumn(name = "TYPE_DOCUMENT", discriminatorType = DiscriminatorType.STRING)
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int documentID;
    private String titre;
    private int nombreExemplaires;

    @OneToMany(mappedBy = "document")
    List<EmpruntDetail> empruntDetailList;



    public boolean verifieDisponibilite() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
        EntityManager em = emf.createEntityManager();
        Query queryCount = em.createQuery("SELECT d FROM Document d WHERE d.titre LIKE :titre");
        queryCount.setParameter("titre", this.titre);
        int count = queryCount.getResultList().size();
        this.nombreExemplaires = count;

        Query queryCountTaken = em.createQuery("SELECT ed FROM EmpruntDetail ed WHERE ed.document.documentID = :documentID");
        queryCountTaken.setParameter("documentID", this.documentID);
        int countTaken = queryCountTaken.getResultList().size();

        emf.close();
        em.close();
        return (this.nombreExemplaires > countTaken);
    }
}
