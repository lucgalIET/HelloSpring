package com.scuola.primoprogettospring.controller;

import com.scuola.primoprogettospring.dto.StudenteDTO;
import com.scuola.primoprogettospring.entities.StudenteEntity;
import com.scuola.primoprogettospring.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studente")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    //CRUD

    // Create
    @PostMapping("/salva-studente")
    public StudenteEntity saveStudente(@RequestBody StudenteEntity entity) {
        return studenteService.saveStudente(entity);
    }
    // -->

    // Read
    @GetMapping("/studenti")
    public List<StudenteEntity> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    @GetMapping("/{id}")
    public Optional<StudenteEntity> getStudenteById(@PathVariable Long id) {
        return studenteService.getStudenteById(id);
    }
    //-->

    //Update
    @PutMapping("modifica-studente/")
    public StudenteEntity updateStudente(@RequestBody StudenteEntity entity) {
        return studenteService.updateStudente(entity);
    }
    //-->

    //Delete
    @DeleteMapping("/{id}")
    public String deleteStudente(@PathVariable Long id) {
        return studenteService.deleteStudente(id);
    }


    @GetMapping("/studenti-aula/{idAula}")
    public List<StudenteEntity> getAllByAula(@PathVariable Long idAula) {
        return studenteService.getAllByAula(idAula);
    }


    @PostMapping("/save-studentedto")
    public StudenteEntity saveStudenteDto(@RequestBody StudenteDTO studenteDTO) {
        return studenteService.createStudente(studenteDTO);
    }

    //Get Mapping con Spring MVC
//    @GetMapping("/studenti")
//    public String getStudenti(Model model) {
//        List<StudenteEntity> studenti = studenteService.getAllStudenti();
//        model.addAttribute("studenti", studenti);
//        return "studenti";
//    }
}
