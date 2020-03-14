package ro.notamare.backend.services;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ro.notamare.backend.dtos.TutorDTO;
import ro.notamare.backend.entities.Tutor;

public class TutorMapper {

    private static MapperFacade mapper;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Tutor.class, TutorDTO.class).byDefault();
        mapper = mapperFactory.getMapperFacade();
    }

    public static TutorDTO toDTO(Tutor entity) {
        return mapper.map(entity, TutorDTO.class);
    }

    public static Tutor toEntity(TutorDTO dto) {
        return mapper.map(dto, Tutor.class);
    }
}
