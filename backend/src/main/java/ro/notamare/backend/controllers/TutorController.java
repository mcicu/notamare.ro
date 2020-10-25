package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.services.TutorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutors")
@AllArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @GetMapping(produces = "application/json")
    public List<TutorDTO> searchTutors(@RequestParam(name = "q", required = false) String query) {
        if (StringUtils.isEmpty(query))
            return tutorService.getTutorList();
        else
            return tutorService.searchTutors(query);
    }

    @GetMapping(path = "/{tutorId}", produces = "application/json")
    public Optional<TutorDTO> getTutor(@PathVariable String tutorId) {
        return tutorService.findTutorById(tutorId);
    }
}
