package ro.notamare.backend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import ro.notamare.backend.enums.SessionDuration;
import ro.notamare.backend.enums.SessionPlace;
import ro.notamare.backend.enums.StudentLevel;

import java.util.LinkedList;
import java.util.List;

@Document(indexName = "tutors")
@Data
public class Tutor {

    @Id
    private String id;
    private String name;
    private String image;
    private String phoneNumber;
    private String description;
    private String location;
    private Boolean visible = false;
    private SessionPreferences sessionPreferences = new SessionPreferences();

    @Data
    public static class SessionPreferences {
        private Double price = 100d;
        private SessionDuration duration = SessionDuration.TWO_HOURS;
        private List<String> subjects = new LinkedList<>();
        private List<StudentLevel> studentLevels = new LinkedList<>();
        private List<SessionPlace> places = new LinkedList<>();
    }
}
