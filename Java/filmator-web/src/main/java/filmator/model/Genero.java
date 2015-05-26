package filmator.model;

public enum Genero {
	
	ACAO("Ação"),
	AVENTURA("Aventura"),
	COMEDIA("Comédia"),
	DRAMA("Drama"),
	FICCAO("Ficção"),
	SUSPENSE("Suspense"),
	TERROR("Terror");
	
	
	String nomeGenero;
	
	private Genero(String nome){
		
		this.nomeGenero = nome;
	}
	
	public String getNomeGenero() {
		return nomeGenero;
	}
}
