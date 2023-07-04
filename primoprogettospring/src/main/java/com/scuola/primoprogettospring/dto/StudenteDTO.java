package com.scuola.primoprogettospring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudenteDTO {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
}