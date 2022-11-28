package br.com.ufba.biblioteca.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.ufba.biblioteca.entidades.Administrador;
import br.com.ufba.biblioteca.entidades.UF;
import br.com.ufba.biblioteca.repositorios.AdministradorRepositorio;

@Controller
@RequestMapping("/administradores")
public class AdministradorControle {

	@Autowired
	private AdministradorRepositorio administradorRepositorio;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("administrador/home");

		modelAndView.addObject("administradores", administradorRepositorio.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("administrador/detalhes");

		modelAndView.addObject("administrador", administradorRepositorio.getOne(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("administrador/formulario");
		modelAndView.addObject("administrador", new Administrador());
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("administrador/formulario");

		modelAndView.addObject("administrador", administradorRepositorio.getOne(id));
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Administrador administrador) {
		// String senhaEncriptada = SenhaUtils.encode(administrador.getSenha());

		// administrador.setSenha(senhaEncriptada);
		administradorRepositorio.save(administrador);

		return "redirect:/administradores";
	}

	@PostMapping("/{id}/editar")
	public String editar(Administrador administrador, @PathVariable Long id) {
		String senhaAtual = administradorRepositorio.getOne(id).getSenha();
		administrador.setSenha(senhaAtual);

		administradorRepositorio.save(administrador);

		return "redirect:/administradores";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		administradorRepositorio.deleteById(id);

		return "redirect:/administradores";
	}

}
