package br.com.ufba.biblioteca.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ufba.biblioteca.entidades.Administrador;
import br.com.ufba.biblioteca.entidades.UserDetailsImpl;
import br.com.ufba.biblioteca.repositorios.AdministradorRepositorio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdministradorRepositorio administradorRepositorio;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Administrador administrador = administradorRepositorio.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

		return new UserDetailsImpl(administrador);
	}

}
