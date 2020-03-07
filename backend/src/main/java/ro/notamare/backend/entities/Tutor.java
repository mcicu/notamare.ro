package ro.notamare.backend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutors")
@Getter
@Setter
public class Tutor {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String location;
    private String description;
}
