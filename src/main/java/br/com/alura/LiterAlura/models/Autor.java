package br.com.alura.LiterAlura.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int data_nascimento;
    private int data_falecimento;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    // public AutorModel(String nome, int data_nascimento, int data_falecimento) {
    //     this.nome = nome;
    //     this.data_nascimento = data_nascimento;
    //     this.data_falecimento = data_falecimento;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(int data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getData_falecimento() {
        return data_falecimento;
    }

    public void setData_falecimento(int data_falecimento) {
        this.data_falecimento = data_falecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
