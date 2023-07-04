package com.scuola.primoprogettospring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "studente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_studente", nullable = false)
    private Long idStudente;

    @Column(name = "nome_studente")
    private String nomeStudente;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "genere")
    private String genere;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "citta")
    private String citta;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "regione")
    private String regione;

    @Column(name = "email")
    private String email;

    @Column(name = "data_nascita")
    private String dataDiNascita;

    @ManyToOne
    @JoinColumn(name = "id_aula_fk")
    @JsonBackReference
    private AulaEntity aulaEntity;
}
