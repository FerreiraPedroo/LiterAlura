package br.com.alura.LiterAlura.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
                @JsonAlias("title") String titulo,
                @JsonAlias("authors") List<AutorDTO> autor,
                @JsonAlias("subjects") List<String> assuntos,
                @JsonAlias("languages") List<String> idiomas,
                @JsonAlias("download_count") int contagem_downloads) {

}
