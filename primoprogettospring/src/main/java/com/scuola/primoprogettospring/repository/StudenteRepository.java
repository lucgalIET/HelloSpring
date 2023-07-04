package com.scuola.primoprogettospring.repository;

import com.scuola.primoprogettospring.entities.StudenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudenteRepository extends JpaRepository<StudenteEntity, Long> {


    //SELECT
    //STUDENTI
    //ID DELL'AULA IN STUDENTE = IDAULA (PASSATO IN ARGOMENTO)

    @Query(value = "SELECT * " +
            "FROM studente s " +
            "WHERE s.id_aula_fk = :idAula", nativeQuery = true)
    List<StudenteEntity> getStudentiByAula(@Param("idAula") Integer idAula);


    //QUERY
}
