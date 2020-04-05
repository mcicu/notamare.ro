package ro.notamare.backend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.notamare.backend.enums.SessionDuration;
import ro.notamare.backend.enums.SessionPlace;
import ro.notamare.backend.enums.StudentLevel;

import java.util.List;

@Document(collection = "tutors")
@Data
public class Tutor {

    @Id
    private String id;
    private String name;
    private String image;
    private String phoneNumber;
    private String description;
    private String location;
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
