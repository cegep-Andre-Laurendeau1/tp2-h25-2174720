package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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




    public boolean verifieDisponibilite(EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT d FROM Document d WHERE d.titre LIKE :titre");
        query.setParameter("titre", this.titre);
        int count = query.getResultList().size();
        this.nombreExemplaires = count;
        return false;
    }
}
