package ca.cal.tp2.dto;

import ca.cal.tp2.modele.Livre;

public record LivreDTO(int id, String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages, int anneeParution) {
    public static LivreDTO toDTO(Livre livre) {
        return new LivreDTO(livre.getDocumentID(), livre.getTitre(), livre.getNombreExemplaires(), livre.getISBN(),
                livre.getAuteur(), livre.getEditeur(), livre.getNombrePages(), livre.getAnneeParution());
    }
}