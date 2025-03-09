package ca.cal.tp2.dto;

import ca.cal.tp2.modele.CD;

public record CDDTO(int id, String titre, int nombreExemplaires, String artiste, int duree, String genre) {
    public static CDDTO toDTO(CD cd) {
        return new CDDTO(cd.getDocumentID(), cd.getTitre(), cd.getNombreExemplaires(),
                cd.getArtiste(), cd.getDuree(), cd.getGenre());
    }
}