package br.com.alura.LiterAlura.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.LiterAlura.models.LivroModel;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long>{
    @Query("SELECT l FROM LivroModel l WhERE l.titulo = :titulo")
    Optional<LivroModel> buscarLivroPorTitulo(String titulo);


}
