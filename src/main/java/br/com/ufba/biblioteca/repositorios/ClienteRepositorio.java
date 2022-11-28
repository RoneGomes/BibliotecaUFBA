package br.com.ufba.biblioteca.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufba.biblioteca.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	@EntityGraph(attributePaths = "nome")
	List<Cliente> findAll();

}
