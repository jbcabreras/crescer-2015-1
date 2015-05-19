package mestreCuca;

public class Ingrediente {
	
	private String nome;
	private double quantidade, preco;

	UnidadeMedida  unidade;
	
	public Ingrediente(String nome, double quantidade, UnidadeMedida unidade, double preco ){
		
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidade = unidade;
		
		
		this.preco = ((int) preco * 100) / 100;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public String getUnidade() {
		return unidade.nome;
	}

}
