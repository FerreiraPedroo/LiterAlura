package br.com.alura.LiterAlura.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.alura.LiterAlura.interfaces.IAutor;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroDTO {
        @JsonAlias("title") String titulo;
        @JsonAlias("authors") List<IAutor> autores;
        @JsonAlias("summaries") List<String> resumos;
        @JsonAlias("translators") List<String> tradutores;
        @JsonAlias("subjects") List<String> assuntos;
        @JsonAlias("languages") List<String> idiomas;
        @JsonAlias("download_count") int contagem_downloads;

        public String getTitulo() {
                return titulo;
        }
        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }
        public List<IAutor> getAutores() {
                return autores;
        }
        public void setAutores(List<IAutor> autores) {
                this.autores = autores;
        }
        public List<String> getResumos() {
                return resumos;
        }
        public void setResumos(List<String> resumos) {
                this.resumos = resumos;
        }
        public List<String> getTradutores() {
                return tradutores;
        }
        public void setTradutores(List<String> tradutores) {
                this.tradutores = tradutores;
        }
        public List<String> getAssuntos() {
                return assuntos;
        }
        public void setAssuntos(List<String> assuntos) {
                this.assuntos = assuntos;
        }
        public List<String> getIdiomas() {
                return idiomas;
        }
        public void setIdiomas(List<String> idiomas) {
                this.idiomas = idiomas;
        }
        public int getContagem_downloads() {
                return contagem_downloads;
        }
        public void setContagem_downloads(int contagem_downloads) {
                this.contagem_downloads = contagem_downloads;
        }

        
}
