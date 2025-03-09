package ca.cal.tp2.service;

import ca.cal.tp2.dao.PreposeDAO;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Prepose;

public class PreposeService {
    private final PreposeDAO dao;

    public PreposeService() {
        this.dao = new PreposeDAO();
    }

    public void createPrepose(String name, String email, String phoneNumber) {
        Prepose prepose = new Prepose(name, email, phoneNumber);
        dao.addPrepose(prepose);
    }

    public void createEmprunteur(String name, String email, String phoneNumber) {
        Emprunteur emprunteur = new Emprunteur(name, email, phoneNumber, null, null);
        dao.addEmprunteur(emprunteur);
    }

    public Prepose getPrepose(int id) {
        return dao.getPrepose(id);
    }

    public void addDocument(Document document) {
        dao.addDocument(document);
    }
}