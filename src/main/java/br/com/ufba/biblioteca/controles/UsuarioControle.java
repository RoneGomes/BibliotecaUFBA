package br.com.ufba.biblioteca.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioControle {

	@Autowired
	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}

}
