package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDao;
import filmator.model.Usuario;

@Controller
public class IndexController {
	
	@Inject
	private UsuarioDao userDao;
	
	@RequestMapping(value = "/template/", method = RequestMethod.GET)
	public String raizt(Model model) {
		return "template/index";
	}
	
	@RequestMapping(value = "/template/index", method = RequestMethod.GET)
	public String indext(Model model) {
		return "template/index";
	}
	
	@RequestMapping(value = "/template/registrar", method = RequestMethod.GET)
	public String registrart(Model model) {
		return "template/registrar";
	}
	
	@RequestMapping(value = "/template/registrar", method = RequestMethod.POST)
	public String regUsuariot(Model model, Usuario user) {
		userDao.inserir(user);
		return "template/sucesso";
	}
	
	@RequestMapping(value = "/template/logar", method = RequestMethod.POST)
	public String logart(Model model, Usuario user, HttpSession session) {
		
		Usuario existe = userDao.consultaUsuario(user);
		
		if(existe != null){
			
			session.setAttribute("usuarioLogado", existe);
			return "redirect:/template/home";
		}else{
			return "template/erro";
		}
	}
	
	@RequestMapping(value = "/template/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session ) {
		session.invalidate();
		return "redirect:/template/index";
	}
	
	
}