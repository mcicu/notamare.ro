package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.services.TutorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutors")
@AllArgsConstructor
public class TutorsController {

    private final TutorService tutorService;

    @RequestMapping()
    private List<TutorDTO> getAllTutors() {
        return tutorService.getTutors();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{tutorId}")
    private Optional<TutorDTO> getTutor(@PathVariable("tutorId") String tutorId) {
        return tutorService.getTutor(tutorId);
    }
}
