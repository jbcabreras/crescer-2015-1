package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.NotaDao;
import filmator.model.Nota;

@Controller
public class NotaController {
	
	@Inject
	private NotaDao notaDao;
		
	@RequestMapping(value = "/template/nota", method = RequestMethod.POST)
	public String votar(Nota nota, Model model) {
		notaDao.insereNota(nota.getPontos(), nota.getIdfilme(), nota.getIdusuario());
		return "template/galeria";
	}
}


