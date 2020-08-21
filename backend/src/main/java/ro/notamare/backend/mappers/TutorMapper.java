package ro.notamare.backend.mappers;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.entities.Tutor;

public class TutorMapper {

    private static final BoundMapperFacade<Tutor, TutorDTO> facade;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(TutorDTO.SessionPreferences.class, Tutor.SessionPreferences.class)
                .byDefault().register();
        facade = mapperFactory.getMapperFacade(Tutor.class, TutorDTO.class);
    }

    public static TutorDTO toDTO(Tutor entity) {
        return facade.map(entity);
    }

    public static Tutor toEntity(TutorDTO dto) {
        return facade.mapReverse(dto);
    }
}
