package com.scuola.primoprogettospring.repository;

import com.scuola.primoprogettospring.entities.AulaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<AulaEntity, Long> {

    //QUERY
}
