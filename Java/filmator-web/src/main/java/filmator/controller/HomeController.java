package filmator.controller;

import java.sql.SQLException;

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
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(Model model) {
		FilmeDao dao = new FilmeDao();
		model.addAttribute("todosGeneros", Genero.values());
		return "cadastro";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		FilmeDao dao = new FilmeDao();
		try {
			dao.incluir(filme);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cadastro";
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String consultar(Model model) {
		FilmeDao dao = new FilmeDao();
		
		return "consulta";
	}
}

