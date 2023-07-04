package com.scuola.primoprogettospring;

import com.scuola.primoprogettospring.entities.StudenteEntity;
import com.scuola.primoprogettospring.repository.StudenteRepository;
import com.scuola.primoprogettospring.service.StudenteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudenteTest {

    @Autowired
    private StudenteService service;

    @MockBean
    private StudenteRepository repository;


    @Test
    public void studentiFindAll() {
        //creare un record/dati di esempio

        StudenteEntity studente1 = new StudenteEntity();
        studente1.setIdStudente(1L);
        studente1.setNomeStudente("Franco");
        studente1.setCognome("Gino");
        studente1.setGenere("m");
        studente1.setIndirizzo("Via vittoria");
        studente1.setCitta("Roma");
        studente1.setProvincia("RM");
        studente1.setRegione("Lazio");
        studente1.setEmail("tizio@mail.it");
        studente1.setDataDiNascita("2000-01-01");
//        studente1.setAulaEntity(new AulaEntity(1L,"nome", 10));

        StudenteEntity studente2 = new StudenteEntity();
        studente2.setIdStudente(2L);
        studente2.setNomeStudente("Ciccio");
        studente2.setCognome("Peppe");
        studente2.setGenere("f");
        studente2.setIndirizzo("Via sconfitta");


        List<StudenteEntity> studenteEntitiesList = Arrays.asList(studente1,studente2);

        // chiama il repository -> simula il comportamento del repository
        when(repository.findAll()).thenReturn(studenteEntitiesList);

        //chiama il metodo del service
        List<StudenteEntity> result = service.getAllStudenti();

        //verifichiamo i risultati del metodo getAllStudenti();
        assertEquals(2, result.size());
        assertEquals("tizio@mail.it", result.get(0).getEmail());
        assertEquals("Ciccio", result.get(1).getNomeStudente());
    }
}
