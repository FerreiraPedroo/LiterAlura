package br.com.alura.LiterAlura.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.LiterAlura.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
    @Query("SELECT a FROM Autor a WHERE a.nome = :autorNome")
    Optional<Autor> buscarAutorPorNome(String autorNome); 
}
