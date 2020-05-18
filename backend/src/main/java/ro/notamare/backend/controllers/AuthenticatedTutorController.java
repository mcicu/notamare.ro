package ro.notamare.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.notamare.backend._security.UserPrincipal;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.services.TutorService;

import java.text.MessageFormat;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/tutors/current")
@AllArgsConstructor
public class AuthenticatedTutorController {

    private final TutorService tutorService;

    @GetMapping
    public Tutor getCurrentTutor(@AuthenticationPrincipal UserPrincipal principal) {
        String tutorId = principal.getAuthenticatedUser().getTutorId();

        if (StringUtils.isEmpty(tutorId)) {
            throw new RuntimeException(MessageFormat.format("Null or empty value passed (tutorId = {0}", tutorId));
        }

        return tutorService.findTutorById(tutorId).orElseThrow(() ->
                new RuntimeException(MessageFormat.format("No associated tutor found for {0}", tutorId))
        );
    }
}
