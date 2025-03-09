package ca.cal.tp2.dao;

import ca.cal.tp2.modele.*;

import java.sql.SQLException;
import java.util.List;

public interface UtilisateurDAO {
    <T extends Document> List<T> findDocumentByTitle(String title, Class<T> documentClass) throws SQLException;

    List<Livre> findLivreByAuthor(String author) throws SQLException;
    List<Livre> findLivreByYear(int year) throws SQLException;

    List<DVD> findDVDByDirector(String director) throws SQLException;

    List<CD> findCDByArtist(String artist) throws SQLException;

    void addEmprunt(Emprunt emprunt, int emprunteurID);
}
