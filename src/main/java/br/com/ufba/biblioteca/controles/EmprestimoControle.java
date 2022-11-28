package br.com.ufba.biblioteca.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufba.biblioteca.repositorios.LivroRepositorio;
import br.com.ufba.biblioteca.entidades.Emprestimo;
import br.com.ufba.biblioteca.repositorios.ClienteRepositorio;
import br.com.ufba.biblioteca.repositorios.EmprestimoRepositorio;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoControle {

	@Autowired
	private EmprestimoRepositorio emprestimoRepositorio;

	@Autowired
	private LivroRepositorio livroRepositorio;
	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("emprestimo/home");

		modelAndView.addObject("emprestimos", emprestimoRepositorio.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("emprestimo/detalhes");

		modelAndView.addObject("emprestimo", emprestimoRepositorio.getOne(id));

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("emprestimo/formulario");

		modelAndView.addObject("emprestimo", new Emprestimo());
		modelAndView.addObject("clientes", clienteRepositorio.findAll());
		modelAndView.addObject("livros", livroRepositorio.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("emprestimo/formulario");

		modelAndView.addObject("emprestimo", emprestimoRepositorio.getOne(id));
		modelAndView.addObject("clientes", clienteRepositorio.findAll());
		modelAndView.addObject("livros", livroRepositorio.findAll());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Emprestimo emprestimo) {
		emprestimoRepositorio.save(emprestimo);

		return "redirect:/emprestimos";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		emprestimoRepositorio.deleteById(id);

		return "redirect:/emprestimos";
	}

}
