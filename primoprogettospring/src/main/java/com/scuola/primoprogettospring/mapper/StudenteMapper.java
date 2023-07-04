package com.scuola.primoprogettospring.mapper;

import com.scuola.primoprogettospring.dto.StudenteDTO;
import com.scuola.primoprogettospring.entities.StudenteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudenteMapper {

    StudenteMapper STUDENTE_MAPPER = Mappers.getMapper(StudenteMapper.class);

    @Mapping(source = "idStudente", target = "id")
    @Mapping(source = "nomeStudente", target = "nome")
    @Mapping(source = "cognome", target = "cognome")
    @Mapping(source = "email", target = "email")
    StudenteDTO entityToDto(StudenteEntity studenteEntity);


    @Mapping(source = "id", target = "idStudente")
    @Mapping(source = "nome", target = "nomeStudente")
    @Mapping(source = "cognome", target = "cognome")
    @Mapping(source = "email", target = "email")
    StudenteEntity dtoToEntity(StudenteDTO studenteDTO);
}