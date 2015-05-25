package filmator.model;

public class Filme {

	private String nome;
	private Genero genero;
	private String ano;
	private String sinopse;
	private String url;
	
	
	public Filme(){}
	
	public Filme(String nome, Genero genero, String ano, String sinopse, String url){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public String getAno() {
		return ano;
	}
	
	public String getSinopse() {
		return sinopse;
	}
	
	public String getUrl() {
		return url;
	}
}
