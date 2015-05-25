package filmator.model;

public enum Genero {
	
	ACAO("Ação"),
	COMEDIA("Comédia"),
	DRAMA("Drama");
	
	String nomeGenero;
	
	private Genero(String nome){
		
		this.nomeGenero = nome;
	}
	
	public String getNomeGenero() {
		return nomeGenero;
	}
}
