package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.services.TutorService;

import java.util.List;

@RestController
@RequestMapping("/tutors")
@AllArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @GetMapping(produces = "application/json")
    public List<TutorDTO> getTutors() {
        return tutorService.getTutorList();
    }

    @PutMapping(path = "/{tutorId}", consumes = "application/json", produces = "application/json")
    public TutorDTO updateTutor(@PathVariable("tutorId") String tutorId, @RequestBody TutorDTO tutorDTO) {
        return tutorService.updateTutor(tutorId, tutorDTO);
    }
}
