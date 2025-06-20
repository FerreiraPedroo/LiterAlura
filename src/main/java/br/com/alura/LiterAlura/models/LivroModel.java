package br.com.alura.LiterAlura.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorModel autor;

    private String[] resumos;
    private String[] assuntos;
    private String[] idiomas;
    private int contagem_downloads;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getResumos() {
        return resumos;
    }

    public void setResumos(String[] resumos) {
        this.resumos = resumos;
    }

    public String[] getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(String[] assuntos) {
        this.assuntos = assuntos;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public int getContagem_downloads() {
        return contagem_downloads;
    }

    public void setContagem_downloads(int contagem_downloads) {
        this.contagem_downloads = contagem_downloads;
    }

    public AutorModel getAutor() {
        return autor;
    }

    public void setAutor(AutorModel autor) {
        this.autor = autor;
    }

}
