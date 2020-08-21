package ro.notamare.backend.dtos;

import lombok.Data;
import ro.notamare.backend.enums.SessionDuration;
import ro.notamare.backend.enums.SessionPlace;
import ro.notamare.backend.enums.StudentLevel;

import java.util.List;

@Data
public class TutorDTO {
    private String id;
    private String name;
    private String image;
    private String phoneNumber;
    private String description;
    private String location;
    private Boolean visible;
    private SessionPreferences sessionPreferences;

    @Data
    public static class SessionPreferences {
        private Double price;
        private SessionDuration duration;
        private List<String> subjects;
        private List<StudentLevel> studentLevels;
        private List<SessionPlace> places;
    }
}
