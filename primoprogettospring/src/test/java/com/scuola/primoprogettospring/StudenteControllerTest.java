package com.scuola.primoprogettospring;

import com.scuola.primoprogettospring.controller.StudenteController;
import com.scuola.primoprogettospring.entities.AulaEntity;
import com.scuola.primoprogettospring.entities.StudenteEntity;
import com.scuola.primoprogettospring.service.StudenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudenteControllerTest {

    @Mock
    private StudenteService service;

    @InjectMocks
    private StudenteController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAllStudenti() {
        List<StudenteEntity> studenteEntityList = new ArrayList<>();
        studenteEntityList.add(new StudenteEntity(1L, "Gino", "Paoli", "m","Via della liberta'", "Libery","LB", "USA","gino@mail.it", "1980-01-01",new AulaEntity()));
        studenteEntityList.add(new StudenteEntity(2L, "Paolo", "Pino", "f","Via della reclusione'", "Un-Libery","NO", "USAMI","Pino@mail.it", "1999-01-01",new AulaEntity()));

        // when: e' un metodo statico della classe Mockito
        // viene utilizzato per impostare il comportamento di un mock
        // in questo caso lo abbiamo utilizzato per stabilire cosa deve restituire il mock quando viene chiamato un metodo
        when(service.getAllStudenti()).thenReturn(studenteEntityList);

        //chiamo il metodo del controller
        List<StudenteEntity> risultato = controller.getAllStudenti();

        //verifico che i risultati siano uguali
        assertEquals(studenteEntityList, risultato);
    }

    @Test
    void saveStudente() {
        StudenteEntity studente = new StudenteEntity(1L, "Gino", "Paoli", "m","Via della liberta'", "Libery","LB", "USA","gino@mail.it", "1980-01-01",new AulaEntity());

        when(service.saveStudente((any(StudenteEntity.class)))).thenReturn(studente);

        StudenteEntity risultato = controller.saveStudente(studente);

        assertEquals(studente, risultato);
    }

    @Test
    void findById(){
        StudenteEntity studente = new StudenteEntity(1L, "Gino", "Paoli", "m","via bella","brutta","così così","accettabile","gino@mail.it","1900-05-05", new AulaEntity());
        when(service.getStudenteById(1L)).thenReturn(Optional.of(studente));

        Optional<StudenteEntity> result = controller.getStudenteById(1L);

        assertEquals(Optional.of(studente), result);
    }

    @Test
    void delete() {
        List<StudenteEntity> studenteEntityList = new ArrayList<>();
        studenteEntityList.add(new StudenteEntity(1L, "Gino", "Paoli", "m", "via bella", "brutta", "così così", "accettabile", "gino@mail.it", "1900-05-05", new AulaEntity()));
        studenteEntityList.add(new StudenteEntity(2L, "Gina", "Paola", "f", "via brutta", "brutta", "così così", "accettabile", "gina@mail.it", "1900-05-05", new AulaEntity()));
        controller.deleteStudente(1L);
        studenteEntityList.remove(0);
        verify(service, times(1)).deleteStudente(1L);
        assertEquals(studenteEntityList.get(0).getIdStudente(), 2L);
    }
}
