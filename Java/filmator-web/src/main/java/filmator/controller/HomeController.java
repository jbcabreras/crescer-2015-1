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
	
	@Inject
	private FilmeDao filmeDao;

	//----------------------------------------- ORIGINAL ---------------------------------------------------------

	
	@RequestMapping(value = "/original/", method = RequestMethod.GET)
	public String index(Model model) {
		return "original/index";
	}
	
	@RequestMapping(value = "/original/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("buscaCapas", filmeDao.buscaCapasGenero());
		return "original/home";
	}
	
	@RequestMapping(value = "/original/cadastro", method = RequestMethod.GET)
	public String cadastro(Model model) {
		model.addAttribute("todosGeneros", Genero.values());
		return "original/cadastro";
	}
	
	@RequestMapping(value = "/original/inserir", method = RequestMethod.POST)
	public String inserir(Filme filme, Model model) {
		filmeDao.inserir(filme);
		return "redirect:original/cadastro";
	}
	
	@RequestMapping(value = "/original/consulta", method = RequestMethod.GET)
	public String consultar(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaTodosFilmesJava8());
		return "original/consulta";
	}
	
	@RequestMapping(value = "/original/buscar", method = RequestMethod.POST)
	public String buscar(String nome, Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmeNome(nome));
		return "original/consulta";
	}
	
	@RequestMapping(value = "/original/editar", method = RequestMethod.POST)
	public String editar(String nome, Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmeNome(nome));
		return "original/consulta";
	}
	
	@RequestMapping(value = "/original/excluir", method = RequestMethod.POST)
	public String excluir(String nome, Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmeNome(nome));
		return "original/consulta";
	}
	
	
	//----------------------------------------- TEMPLATE ---------------------------------------------------------
	
	@RequestMapping(value = "/template/", method = RequestMethod.GET)
	public String raizt(Model model) {
		return "template/index";
	}
	
	@RequestMapping(value = "/template/index", method = RequestMethod.GET)
	public String indext(Model model) {
		return "template/index";
	}
	
	@RequestMapping(value = "/template/home", method = RequestMethod.GET)
	public String homet(Model model) {
		return "template/home";
	}
	
	@RequestMapping(value = "/template/genero", method = RequestMethod.GET)
	public String generot(Model model) {
		return "template/genero";
	}
	
	@RequestMapping(value = "/template/buscar", method = RequestMethod.GET)
	public String buscart(Model model) {
		return "template/buscar";
	}
	
	@RequestMapping(value = "/template/buscar", method = RequestMethod.POST)
	public String buscart(String nome, Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmeNome(nome));
		return "redirect:/template/galeria";
	}
	
	@RequestMapping(value = "/template/acaoModal", method = RequestMethod.GET)
	public String acaot(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("acao"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/aventuraModal", method = RequestMethod.GET)
	public String aventurat(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("aventura"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/comediaModal", method = RequestMethod.GET)
	public String comediat(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("comedia"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/dramaModal", method = RequestMethod.GET)
	public String dramat(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("drama"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/ficcaoModal", method = RequestMethod.GET)
	public String ficcaot(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("ficcao"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/suspenseModal", method = RequestMethod.GET)
	public String suspenset(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("suspense"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/policialModal", method = RequestMethod.GET)
	public String policialt(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("policial"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/terrorModal", method = RequestMethod.GET)
	public String terrort(Model model) {
		model.addAttribute("buscaFilmesGen", filmeDao.buscaFilmesGenero("terror"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/cadastrar", method = RequestMethod.GET)
	public String cadastrart(Model model) {
		model.addAttribute("todosGeneros", Genero.values());
		return "template/cadastrar";
	}
	
	@RequestMapping(value = "/template/inserir", method = RequestMethod.POST)
	public String inserirt(Filme filme, Model model) {
		filmeDao.inserir(filme);
		return "redirect:/template/cadastrar";
	}

	@RequestMapping(value = "/template/registrar", method = RequestMethod.GET)
	public String registrart(Model model) {
		return "template/registrar";
	}
	
	@RequestMapping(value = "/template/consulta", method = RequestMethod.GET)
	public String consultat(Model model) {
		return "template/consulta";
	}
	
	@RequestMapping(value = "/template/cadastro", method = RequestMethod.GET)
	public String cadastrot(Model model) {
		model.addAttribute("todosGeneros", Genero.values());
		return "template/cadastro";
	}
	
	@RequestMapping(value = "/template/editar", method = RequestMethod.POST)
	public String editart(String nome, Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmeNome(nome));
		return "template/consulta";
	}
	
	@RequestMapping(value = "/template/excluir", method = RequestMethod.POST)
	public String excluirt(String nome, Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmeNome(nome));
		return "template/consulta";
	}
}


