package br.com.ufba.biblioteca.repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ufba.biblioteca.entidades.Administrador;

//inteface q faz conexao e operaçoes crud no banco de dados
public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {

	Optional<Administrador> findByEmail(String email);

}
