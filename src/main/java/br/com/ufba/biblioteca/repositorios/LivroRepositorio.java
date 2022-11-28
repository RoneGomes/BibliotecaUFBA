package br.com.ufba.biblioteca.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufba.biblioteca.entidades.Livro;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {
	@EntityGraph(attributePaths = "nome")
	List<Livro> findAll();
}
