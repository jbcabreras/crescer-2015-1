package filmator;

import java.util.ArrayList;

public class Filme {
	
	private ArrayList<Ator> elenco = new ArrayList<Ator>();
	private StringBuilder lista = new StringBuilder();
	private StringBuilder procuraAtor = new StringBuilder();
	private Genero genero;
	private String nome;
	
	public Filme(String umNome, Genero umGenero){
		this.nome = umNome;
		this.genero = umGenero;
	}
		
	public Genero getGenero() {
		return genero;
	}
	
	public String getNome() {
		return nome;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void adicionaAtor(Ator umAtor){
		
		elenco.add(umAtor);
	}
	
	public ArrayList<Ator> getElenco() {
		return elenco;
	}
	
	public String toString(){
		StringBuilder listaString = new StringBuilder();
		
		for (Ator ator : elenco) {
			listaString.append(ator.toString()); 
		}
		return listaString.toString();
	}
	
	public StringBuilder listaElenco(){
		
		for (Ator ator : elenco) {
			lista.append(ator.getNome());
			lista.append(" ");
		}
		
		return lista;
	}
	
	public String procuraAtor(String umNome){
		
		for (Ator ator : elenco) {
			
			String nome = ator.getNome().toLowerCase();
			
			if(nome.contains(umNome.toLowerCase()) ){
				procuraAtor.append(ator.getNome());
			}
		}
		
		return procuraAtor.toString();
	}
}
