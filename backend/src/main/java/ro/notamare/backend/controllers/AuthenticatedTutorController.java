package ro.notamare.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.notamare.backend.configuration.security.UserPrincipal;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.services.TutorService;

import java.net.URI;
import java.text.MessageFormat;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/tutors/current")
@RequiredArgsConstructor
public class AuthenticatedTutorController {

    private final TutorService tutorService;

    @GetMapping(produces = "application/json")
    public TutorDTO getCurrentTutor(@AuthenticationPrincipal UserPrincipal principal) {
        String tutorId = principal.getAuthenticatedUser().getId();

        if (StringUtils.isEmpty(tutorId)) {
            throw new RuntimeException(MessageFormat.format("Null or empty value passed (tutorId = {0}", tutorId));
        }

        return tutorService.findTutorById(tutorId).orElseThrow(() ->
                new RuntimeException(MessageFormat.format("No associated tutor found for {0}", tutorId))
        );
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public TutorDTO updateTutor(@RequestBody TutorDTO tutorDTO, @AuthenticationPrincipal UserPrincipal principal) {
        Tutor tutor = (Tutor) principal.getAuthenticatedUser();
        return tutorService.updateTutor(tutor, tutorDTO);
    }

    @PutMapping(path = "/image", consumes = "multipart/form-data", produces = "text/plain")
    public ResponseEntity<?> updateImage(@RequestParam("file") MultipartFile image, @AuthenticationPrincipal UserPrincipal principal) {
        Tutor tutor = (Tutor) principal.getAuthenticatedUser();
        String imageFilename = tutorService.updateProfileImage(tutor, image);
        URI uri = URI.create(imageFilename);
        return ResponseEntity.created(uri).build();
    }
}
