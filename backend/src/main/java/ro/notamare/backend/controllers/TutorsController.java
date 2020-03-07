package ro.notamare.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.repositories.TutorRepository;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorsController {

    @Autowired
    TutorRepository tutorRepository;

    @RequestMapping()
    private List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{tutorId}")
    private Tutor getTutor(@PathVariable("tutorId") String tutorId) {
        return tutorRepository.findById(tutorId).get();
    }


}
