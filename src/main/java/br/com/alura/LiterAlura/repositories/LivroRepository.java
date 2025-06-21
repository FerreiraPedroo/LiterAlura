package br.com.alura.LiterAlura.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.LiterAlura.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    @Query("SELECT l FROM Livro l WhERE l.titulo = :titulo")
    Optional<Livro> buscarLivroPorTitulo(String titulo);


}
