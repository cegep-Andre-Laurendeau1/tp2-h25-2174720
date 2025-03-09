package ca.cal.tp2.dto;

import ca.cal.tp2.modele.Emprunteur;

public record EmprunteurDTO(int id, String name, String email, String phoneNumber) {
    public static EmprunteurDTO toDTO(Emprunteur emprunteur) {
        return new EmprunteurDTO(emprunteur.getUserID(), emprunteur.getName(),
                emprunteur.getEmail(), emprunteur.getPhoneNumber());
    }
}