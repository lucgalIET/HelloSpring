package com.scuola.primoprogettospring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aula")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AulaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long idAula;

    @Column(name = "nome")
    private String nomeAula;

    @Column(name = "capacita")
    private int capacitaAula;

    @OneToMany(
            mappedBy = "aulaEntity",
            cascade = {CascadeType.ALL}
    )
    @JsonManagedReference
    private List<StudenteEntity> studentiList = new ArrayList<>();
}