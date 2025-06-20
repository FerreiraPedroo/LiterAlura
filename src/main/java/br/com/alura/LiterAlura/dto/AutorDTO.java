package br.com.alura.LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorDTO {
    @JsonAlias("name") String nome;
    @JsonAlias("birth_year") int data_nascimento;
    @JsonAlias("death_year") int data_falecimento;
    
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
    
    


}
