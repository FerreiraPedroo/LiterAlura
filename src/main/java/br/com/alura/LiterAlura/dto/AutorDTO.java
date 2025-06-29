package br.com.alura.LiterAlura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") int data_nascimento,
        @JsonAlias("death_year") int data_falecimento) {

}
