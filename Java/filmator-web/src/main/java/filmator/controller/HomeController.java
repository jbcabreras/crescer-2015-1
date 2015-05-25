package filmator.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {

	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Model model) {
//		FilmeDao dao = new FilmeDao();
//		model.addAttribute("mensagem", "fulano de tal");
//		model.addAttribute("millisegundos", System.currentTimeMillis());
//		model.addAttribute("filmes",  dao.buscaTodosFilmes());
//		return "nomeDoArquivo";
//	}
	
	@Inject
	private FilmeDao filmeDao;
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(Model model) {
		model.addAttribute("todosGeneros", Genero.values());
		return "cadastro";
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Filme filme, Model model) {
		filmeDao.inserir(filme);
		return "redirect:/cadastro";
	}
	
	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String consultar(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaTodosFilmesJava8());
		return "consulta";
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscar(String nome, Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmeNome(nome));
		return "consulta";
	}
}


