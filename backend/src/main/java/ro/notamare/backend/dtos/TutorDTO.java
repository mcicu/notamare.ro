package ro.notamare.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import ro.notamare.backend.enums.SessionDuration;
import ro.notamare.backend.enums.SessionPlace;
import ro.notamare.backend.enums.StudentLevel;

@Getter
@Setter
public class TutorDTO {

    private String id;
    private String name;
    private String image;
    private String phoneNumber;
    private String description;
    private String location;
    private SessionPreferencesDTO sessionPreferences;

    @Getter
    @Setter
    public static class SessionPreferencesDTO {
        private Double price;
        private SessionDuration duration;
        private String[] subjects;
        private StudentLevel[] studentLevels;
        private SessionPlace[] places;
    }
}
