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
import filmator.model.Usuario;

@Controller
public class HomeController {
	
	@Inject
	private FilmeDao filmeDao;

		
	//----------------------------------------- TEMPLATE ---------------------------------------------------------
	
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
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/acaoModal", method = RequestMethod.GET)
	public String acaot(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("acao"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/aventuraModal", method = RequestMethod.GET)
	public String aventurat(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("aventura"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/comediaModal", method = RequestMethod.GET)
	public String comediat(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("comedia"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/dramaModal", method = RequestMethod.GET)
	public String dramat(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("drama"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/ficcaoModal", method = RequestMethod.GET)
	public String ficcaot(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("ficcao"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/suspenseModal", method = RequestMethod.GET)
	public String suspenset(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("suspense"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/policialModal", method = RequestMethod.GET)
	public String policialt(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("policial"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/terrorModal", method = RequestMethod.GET)
	public String terrort(Model model) {
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero("terror"));
		return "template/galeria";
	}
	
	@RequestMapping(value = "/template/cadastrar", method = RequestMethod.GET)
	public String cadastrart(Model model) {
		model.addAttribute("todosGeneros", Genero.values());
		return "template/cadastrar";
	}
	
	@RequestMapping(value = "/template/inserir", method = RequestMethod.POST)
	public String inserirt(Filme filme, Model model) {
		
		if( filme.getIdFilme() == null){
			filmeDao.inserir(filme);
			return "template/cadastrar";
		}else{
			filmeDao.atualizar(filme);
			model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero(filme.getGenero().name()));
			return "template/galeria";
		}
	}

	@RequestMapping(value = "/template/editar", method = RequestMethod.GET)
	public String editart(String id, Model model) {
		model.addAttribute("editarFilme", filmeDao.buscaFilmeId(id));
		model.addAttribute("todosGeneros", Genero.values());
		return "template/cadastrar";
	}
	
	@RequestMapping(value = "/template/excluir", method = RequestMethod.GET)
	public String excluirt(String id, String gen, Model model) {
		filmeDao.excluir(id);
		model.addAttribute("buscaFilmes", filmeDao.buscaFilmesGenero(gen));
		return "template/galeria";
	}
}


