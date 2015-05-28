package filmator.model;

public class Filme {
	
	private Integer idFilme;
	private String nome;
	private Genero genero;
	private String ano;
	private String sinopse;
	private String url;
	
	
	public Filme(){}
	
	public Filme(String nome, Genero genero, String ano, String sinopse, String url){
		this.nome = nome;
	}
	
	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
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

	public void setGenero(String genero) {
		this.genero = Genero.valueOf(genero);
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
