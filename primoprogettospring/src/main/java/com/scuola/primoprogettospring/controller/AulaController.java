package com.scuola.primoprogettospring.controller;

import com.scuola.primoprogettospring.entities.AulaEntity;
import com.scuola.primoprogettospring.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;


    @GetMapping("/aule")
    public List<AulaEntity> getAllAule() {
        return aulaService.getAllAule();
    }

    @GetMapping("/{id}")
    public AulaEntity getAulaById(@PathVariable Long id) {
        return aulaService.getAulaById(id);
    }

    @PostMapping("/salva-aula")
    public AulaEntity saveAula(@RequestBody AulaEntity aula) {
        return aulaService.saveAula(aula);
    }

    @PutMapping("/modifica-aula/{id}")
    public AulaEntity updateAula(@RequestBody AulaEntity aula) {
        return aulaService.saveAula(aula);
    }

    @DeleteMapping("/{id}")
    public void deleteAula(@PathVariable Long id) {
        aulaService.deleteAula(id);
    }
    }
