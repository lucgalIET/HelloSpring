package com.scuola.primoprogettospring.service;

import com.scuola.primoprogettospring.entities.AulaEntity;
import com.scuola.primoprogettospring.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    public List<AulaEntity> getAllAule() {
        return aulaRepository.findAll();
    }

    public AulaEntity getAulaById(Long id) {
        return aulaRepository.findById(id).orElse(null);
    }

    public AulaEntity saveAula(AulaEntity aula) {
        return aulaRepository.save(aula);
    }

    public void deleteAula(Long id) {
        aulaRepository.deleteById(id);
    }
}
