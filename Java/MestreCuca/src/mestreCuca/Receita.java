package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	private String nome;
	private List<Ingrediente> ingredientes = new ArrayList<>();
	private List<Instrucao> instrucoes = new ArrayList<>();
	
	public Receita(String nome){
		
		this.nome = nome;
	}
	
	public boolean isNull(){
		
		boolean x = false;
		
		if(ingredientes == null || instrucoes == null)
			x = true;
			
		return x;
	}
	
	public void setIngredientes(Ingrediente ingrediente) {

		ingredientes.add(ingrediente);
	}
	
	public void setInstrucoes(Instrucao instrucao) {

		instrucoes.add(instrucao);
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public List<Instrucao> getInstrucoes() {
		return instrucoes;
	}
}
