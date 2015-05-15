package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Netflox {

	private HashMap<String, Filme> listaFilmes = new HashMap<>();
	private StringBuilder relatorio = new StringBuilder();
	private int acao = 0, comedia = 0, drama = 0;
		
	public void adicionaFilme(String umNome, Filme umFilme){
		
		if(listaFilmes.containsKey(umNome) == false)
			listaFilmes.put(umNome, umFilme);
	}
	
	public Set<String> getKeySet(){
		return listaFilmes.keySet();
	}
	
	public boolean localizaFilme(String nome){
		
		return listaFilmes.containsKey(nome);
	}
	
	public boolean reproduzirFilme(Filme umFilme){
		boolean reproduz = false;
		
		if(listaFilmes.containsKey(umFilme.getNome())){
			
			reproduz = true;
			
			switch(umFilme.getGenero()){
				
				case ACAO:	
					acao++;
					break;
				case COMEDIA:
					comedia++;
					break;
				case DRAMA:
					drama++;
					break;
				default:
					System.out.println("Este genero nao existe!");
			}
			
		}
		
		return reproduz;
	}
	
	public String gerarRelatorio(){
		
		relatorio.append("acao = ");
		relatorio.append(acao);
		relatorio.append("comedia = ");
		relatorio.append(comedia);
		relatorio.append("drama = ");
		relatorio.append(drama);
		
		return relatorio.toString();
	}
}
