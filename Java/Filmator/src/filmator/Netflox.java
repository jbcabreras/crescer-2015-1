package filmator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Netflox {

	private HashMap<String, Filme> listaFilmes = new HashMap<>();
	private GeraRelatorio relatorio = new GeraRelatorio();
	
	public Netflox(){
		
		relatorio.populaContador();
	}
	
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
			
			relatorio.iteraContador(umFilme.getGenero());		
				
		}
		
		return reproduz;
	}
	
	public Set<Entry<Genero, Integer>> gerarRelatorio(){
		
		return relatorio.getRelatorio();
	}
}
