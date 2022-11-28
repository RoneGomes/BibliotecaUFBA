package br.com.ufba.biblioteca.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufba.biblioteca.entidades.Livro;
import br.com.ufba.biblioteca.repositorios.LivroRepositorio;

@Controller
@RequestMapping("/livros")
public class LivroControle {

	@Autowired
	private LivroRepositorio livroRepositorio;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("livro/home");

		modelAndView.addObject("livros", livroRepositorio.findAll());

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("livro/formulario");

		modelAndView.addObject("livro", new Livro());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("livro/formulario");

		modelAndView.addObject("livro", livroRepositorio.getOne(id));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Livro livro) {
		livroRepositorio.save(livro);

		return "redirect:/livros";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		livroRepositorio.deleteById(id);

		return "redirect:/livros";
	}

}
