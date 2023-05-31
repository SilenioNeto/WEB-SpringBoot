package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.model.Livro;
import web.repository.LivroRepository;

@Controller
public class LivroController {
	@Autowired
	private LivroRepository lr;

	@RequestMapping(value = "/cadastrarLivros", method = RequestMethod.GET)
	public String form() {
		return "livros/formLivros";
	}

	@RequestMapping(value = "/cadastrarLivros", method = RequestMethod.POST)
	public String form(Livro livro) {
		lr.save(livro);
		return "redirect:/cadastrarLivros";
	}

	@RequestMapping("/listarLivros")
	public ModelAndView listaLivros() {
		ModelAndView mv = new ModelAndView("livros/listarLivros");

		Iterable<Livro> livros = lr.findAll();

		mv.addObject("livros", livros);

		return mv;
	}
}
