package br.com.alura.LiterAlura.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDTO(
                @JsonAlias("results") List<LivroDTO> resultados) {

}
