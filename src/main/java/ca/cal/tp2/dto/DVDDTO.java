package ca.cal.tp2.dto;

import ca.cal.tp2.modele.DVD;

public record DVDDTO(int id, String titre, int nombreExemplaires, String director, int duree, String rating) {
    public static DVDDTO toDTO(DVD dvd) {
        return new DVDDTO(dvd.getDocumentID(), dvd.getTitre(), dvd.getNombreExemplaires(),
                dvd.getDirector(), dvd.getDuree(), dvd.getRating());
    }
}
