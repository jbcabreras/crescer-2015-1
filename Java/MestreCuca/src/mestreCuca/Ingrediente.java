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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantidade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		if (Double.doubleToLongBits(quantidade) != Double
				.doubleToLongBits(other.quantidade))
			return false;
		if (unidade != other.unidade)
			return false;
		return true;
	}
	
	

}
