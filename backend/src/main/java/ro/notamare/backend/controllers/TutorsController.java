package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.services.TutorService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutors")
@AllArgsConstructor
public class TutorsController {

    private final TutorService tutorService;

    @GetMapping
    private List<TutorDTO> getAllTutors() {
        return tutorService.getTutors();
    }

    @GetMapping(path = "/{tutorId}")
    private Optional<TutorDTO> getTutor(@PathVariable("tutorId") String tutorId) {
        return tutorService.getTutor(tutorId);
    }

    @PostMapping
    private ResponseEntity<?> addTutor(@RequestBody TutorDTO tutorDTO) {
        String tutorId = tutorService.createTutor(tutorDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .pathSegment("{tutorId}")
                .buildAndExpand(tutorId).toUri();
        return ResponseEntity.created(location).build();
    }


}
