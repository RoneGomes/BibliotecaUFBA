package br.com.ufba.biblioteca.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ufba.biblioteca.entidades.Emprestimo;

public interface EmprestimoRepositorio extends JpaRepository<Emprestimo, Long> {

	@EntityGraph(attributePaths = { "cliente", "livro" })
	List<Emprestimo> findAll();

}
