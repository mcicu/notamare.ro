package ro.notamare.backend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "users")
@Data
public class User {

    @Id
    private String email;
    private String password;
    private String tutorId;
}
