package ca.cal.tp2.dao;

import ca.cal.tp2.modele.*;

import jakarta.persistence.*;
import java.sql.SQLException;
import java.util.List;



public class EmprunteurDAO implements UtilisateurDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2-vincent-lemieux");

    @Override
    public <T extends Document> List<T> findDocumentByTitle(String title, Class<T> documentClass) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<T> query = em.createQuery("SELECT d FROM " + documentClass.getSimpleName() + " d WHERE LOWER(d.titre) LIKE :title", documentClass);
        query.setParameter("title", "%" + title.toLowerCase() + "%");
        List<T> resultList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public List<Livre> findLivreByAuthor(String author) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE LOWER(l.auteur) LIKE :author", Livre.class);
        query.setParameter("author", "%" + author.toLowerCase() + "%");
        List<Livre> resultList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public List<Livre> findLivreByYear(int year) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.anneeParution = :year", Livre.class);
        query.setParameter("year", year);
        List<Livre> resultList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public List<DVD> findDVDByDirector(String director) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<DVD> query = em.createQuery("SELECT d FROM DVD d WHERE LOWER(d.director) LIKE :director", DVD.class);
        query.setParameter("director", "%" + director.toLowerCase() + "%");
        List<DVD> resultList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }


    @Override
    public List<CD> findCDByArtist(String artist) throws SQLException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c WHERE LOWER(c.artiste) LIKE :artist", CD.class);
        query.setParameter("artist", "%" + artist.toLowerCase() + "%");
        List<CD> resultList = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    @Override
    public void addEmprunt(Emprunt emprunt, int emprunteurID) {
        // Implement the logic to add an Emprunt
    }

    public void addEmprunteur(Emprunteur emprunteur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(emprunteur);
        em.getTransaction().commit();
        em.close();
    }
}