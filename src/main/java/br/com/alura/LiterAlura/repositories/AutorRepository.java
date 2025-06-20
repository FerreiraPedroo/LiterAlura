package br.com.alura.LiterAlura.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.LiterAlura.models.AutorModel;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long>{
    @Query("SELECT a FROM AutorModel a WHERE a.nome = :autorNome")
    Optional<AutorModel> buscarAutorPorNome(String autorNome); 
}
