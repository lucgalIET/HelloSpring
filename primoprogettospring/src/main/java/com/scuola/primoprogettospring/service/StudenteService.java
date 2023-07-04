package com.scuola.primoprogettospring.service;

import com.scuola.primoprogettospring.dto.StudenteDTO;
import com.scuola.primoprogettospring.entities.StudenteEntity;
import com.scuola.primoprogettospring.mapper.StudenteMapper;
import com.scuola.primoprogettospring.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    //
    public List<StudenteEntity> getAllStudenti() {
        return studenteRepository.findAll();
    }

    public Optional<StudenteEntity> getStudenteById(Long id) {
        return studenteRepository.findById(id);
    }

    public StudenteEntity saveStudente(StudenteEntity entity) {
        return studenteRepository.save(entity);
    }


//    public StudenteEntity updateStudente(Long id, StudenteEntity studenteNew) {
//        Optional<StudenteEntity> studenteToEdit = getStudenteById(id);
//        if (studenteToEdit.isEmpty()) throw new RuntimeException("Studente non trovato!");
//

//        studenteToEdit.get().setIdStudente(studenteNew.getIdStudente());
//        studenteToEdit.get().setNome(studenteNew.getNome());
//        studenteToEdit.get().setCognome(studenteNew.getCognome());
//        studenteToEdit.get().setGenere(studenteNew.getGenere());
//        studenteToEdit.get().setCitta(studenteNew.getCitta());
//        studenteToEdit.get().setProvincia(studenteNew.getProvincia());
//        studenteToEdit.get().setRegione(studenteNew.getRegione());
//        studenteToEdit.get().setEmail(studenteNew.getEmail());
//        studenteToEdit.get().setDataDiNascita(studenteNew.getDataDiNascita());
//
//        return studenteRepository.save(studenteToEdit.get());
//    }


    public StudenteEntity updateStudente(StudenteEntity studenteNew) {
//        if (studenteNew != null && studenteNew.getIdStudente( ) != null) throw new NullPointerException("Compilare tutti i campi!");

        Optional<StudenteEntity> studenteEntity = getStudenteById(studenteNew.getIdStudente());
        if(studenteEntity.isEmpty()) throw new NullPointerException();


        return studenteRepository.save(studenteNew);
    }

    public String deleteStudente(Long id) {

        Optional<StudenteEntity> studenteEntity = getStudenteById(id);
        if (studenteEntity.isPresent()) {
        studenteRepository.deleteById(id);
        return "Record cancellato con successo!";
        } else {
            return "Record con id: " + id + ", non trovato!";
        }

    }

    public List<StudenteEntity> getAllByAula(Long idAula) {
        return studenteRepository.getStudentiByAula(Math.toIntExact(idAula));
    }

    public StudenteEntity createStudente(StudenteDTO studenteDTO) {
        StudenteEntity studenteNew = StudenteMapper.STUDENTE_MAPPER.dtoToEntity(studenteDTO);
        return studenteRepository.save(studenteNew);
    }
}
