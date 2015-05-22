package filmator;

public enum Genero {
	
	ACAO("A��o"),
	COMEDIA("Com�dia"),
	DRAMA("Drama");
	
	String nome;
	
	private Genero(String nome){
		
		this.nome = nome;
	}
}
