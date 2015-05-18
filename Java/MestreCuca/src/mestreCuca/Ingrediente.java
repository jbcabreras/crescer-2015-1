package mestreCuca;

public class Ingrediente {
	
	private String nome;
	private double quantidade;

	UnidadeMedida  unidade;
	
	public Ingrediente(String nome, Double quantidade, UnidadeMedida unidade){
		
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidade = unidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public UnidadeMedida getUnidade() {
		return unidade;
	}

}
