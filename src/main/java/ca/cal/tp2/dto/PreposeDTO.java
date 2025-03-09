package ca.cal.tp2.dto;

import ca.cal.tp2.modele.Prepose;

public record PreposeDTO(int id, String name, String email, String phoneNumber) {
    public static PreposeDTO toDTO(Prepose prepose) {
        return new PreposeDTO(prepose.getUserID(), prepose.getName(),
                prepose.getEmail(), prepose.getPhoneNumber());
    }
}