package ro.notamare.backend.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.entities.Tutor;
import ro.notamare.backend.mappers.TutorMapper;
import ro.notamare.backend.repositories.TutorRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class TutorService {

    private final TutorRepository tutorRepository;

    public List<TutorDTO> getTutorList() {
        return tutorRepository.findAllByVisible(true).stream()
                .map(TutorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<TutorDTO> findTutorById(String tutorId) {
        Optional<TutorDTO> optionalTutorDTO = tutorRepository.findById(tutorId).map(TutorMapper::toDTO);
        if (optionalTutorDTO.isEmpty())
            log.error("No tutor found for tutorId = {}", tutorId);
        return optionalTutorDTO;
    }

    public TutorDTO updateTutor(Tutor tutor, TutorDTO tutorDTO) {
        String tutorId = tutor.getId();
        TutorMapper.updateEntity(tutor, tutorDTO);
        tutor.setId(tutorId);
        tutorRepository.save(tutor);
        return TutorMapper.toDTO(tutor);
    }

    public String updateProfileImage(Tutor tutor, MultipartFile image) {
        String filename = uploadProfileImage(tutor.getId(), image);

        TutorDTO tutorDTO = TutorMapper.toDTO(tutor);
        tutorDTO.setImage(filename);
        updateTutor(tutor, tutorDTO);

        return filename;
    }

    private String uploadProfileImage(String tutorId, MultipartFile image) {
        String thumbnailFilename = MessageFormat.format("thumb-{0}.jpg", tutorId);
        String thumbnailLocation = MessageFormat.format("src/main/resources/static/{0}", thumbnailFilename);

        try (
                InputStream imageInputStream = image.getInputStream();
                OutputStream thumbnailOutputStream = new FileOutputStream(thumbnailLocation, false)
        ) {
            Thumbnails.of(imageInputStream)
                    .size(200, 200)
                    .outputFormat("jpg")
                    .keepAspectRatio(true)
                    .crop(Positions.CENTER)
                    .toOutputStream(thumbnailOutputStream);
        } catch (IOException exception) {
            log.error("Failed to create thumbnail", exception);
            throw new RuntimeException("Failed to create thumbnail");
        }

        return thumbnailFilename;
    }

    //TODO score result items
    public List<TutorDTO> searchTutors(String query) {
        QueryBuilder searchQuery = QueryBuilders.multiMatchQuery(query, "description", "location", "sessionPreferences.subjects")
                .fuzziness(Fuzziness.AUTO);
        Iterable<Tutor> resultIterable = tutorRepository.search(searchQuery);

        return StreamSupport.stream(resultIterable.spliterator(), false)
                .map(TutorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
