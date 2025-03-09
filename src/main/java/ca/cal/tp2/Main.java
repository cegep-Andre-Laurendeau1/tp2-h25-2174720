package ca.cal.tp2;

import ca.cal.tp2.dao.EmprunteurDAO;
import ca.cal.tp2.dao.PreposeDAO;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.service.PreposeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2-vincent-lemieux");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create and persist Livre objects
        Livre livre1 = new Livre();
        livre1.setTitre("Title1");
        livre1.setAuteur("Author1");
        livre1.setAnneeParution(2021);
        em.persist(livre1);

        Livre livre2 = new Livre();
        livre2.setTitre("Title2");
        livre2.setAuteur("Author2");
        livre2.setAnneeParution(2022);
        em.persist(livre2);

        Livre livre3 = new Livre();
        livre3.setTitre("Title3");
        livre3.setAuteur("Author3");
        livre3.setAnneeParution(2023);
        em.persist(livre3);

        Livre livre4 = new Livre();
        livre4.setTitre("Title4");
        livre4.setAuteur("Author4");
        livre4.setAnneeParution(2023);
        em.persist(livre4);

        // Create and persist DVD objects
        DVD dvd1 = new DVD();
        dvd1.setTitre("DVD Title1");
        dvd1.setDirector("Director1");
        em.persist(dvd1);

        DVD dvd2 = new DVD();
        dvd2.setTitre("DVD Title2");
        dvd2.setDirector("Director2");
        em.persist(dvd2);

        DVD dvd3 = new DVD();
        dvd3.setTitre("DVD Title3");
        dvd3.setDirector("Director3");
        em.persist(dvd3);

        // Create and persist CD objects
        CD cd1 = new CD();
        cd1.setTitre("CD Title1");
        cd1.setArtiste("Artist1");
        em.persist(cd1);

        CD cd2 = new CD();
        cd2.setTitre("CD Title2");
        cd2.setArtiste("Artist2");
        em.persist(cd2);

        CD cd3 = new CD();
        cd3.setTitre("CD Title3");
        cd3.setArtiste("Artist3");
        em.persist(cd3);

        em.getTransaction().commit();

        // Test the DAO methods
        EmprunteurDAO emprunteurDAO = new EmprunteurDAO();

        // Test findDocumentByTitle for Livre
        System.out.println("Livres by Title:");
        emprunteurDAO.findDocumentByTitle("Title1", Livre.class).forEach(System.out::println);

        // Test findLivreByAuthor
        System.out.println("Livres by Author:");
        emprunteurDAO.findLivreByAuthor("Author2").forEach(System.out::println);

        // Test findLivreByYear
        System.out.println("Livres by Year:");
        emprunteurDAO.findLivreByYear(2023).forEach(System.out::println);

        // Test findDocumentByTitle for CD
        System.out.println("CDs by Title:");
        emprunteurDAO.findDocumentByTitle("CD Title1", CD.class).forEach(System.out::println);

        // Test findCDByArtist
        System.out.println("CDs by Artist:");
        emprunteurDAO.findCDByArtist("Artist2").forEach(System.out::println);

        // Test findDocumentByTitle for DVD
        System.out.println("DVDs by Title:");
        emprunteurDAO.findDocumentByTitle("DVD Title1", DVD.class).forEach(System.out::println);

        // Test findDVDByDirector
        System.out.println("DVDs by Director:");
        emprunteurDAO.findDVDByDirector("Director2").forEach(System.out::println);

        // Test PreposeService and PreposeDAO methods
        PreposeService preposeService = new PreposeService();

        // Create and persist Prepose
        preposeService.createPrepose("John Doe", "john.doe@example.com", "123-456-7890");
        Prepose prepose = preposeService.getPrepose(1);
        System.out.println("Prepose: " + prepose);

        // Create and persist Emprunteur
        preposeService.createEmprunteur("Jane Smith", "jane.smith@example.com", "098-765-4321");

        // Create and persist Document
        Document document = new Livre();
        document.setTitre("New Document");

        // Test entreNouveauDocument method in Prepose
        Prepose preposeEntity = new Prepose("Alice", "alice@example.com", "555-555-5555");
        preposeEntity.entreNouveauDocument(document, preposeService);

        em.close();
        emf.close();

        Thread.currentThread().join();
    }
}