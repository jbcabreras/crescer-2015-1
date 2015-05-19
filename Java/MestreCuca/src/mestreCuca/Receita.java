package mestreCuca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Receita {

	private String nome;
	private List<Ingrediente> ingredientes = new ArrayList<>();
	private List<Instrucao> instrucoes = new ArrayList<>();
	private double valorTotal;
	
	public Receita(String nome){
		
		this.nome = nome;
		
	}
	
//	public double calculaValorTotal(){
//		
//		double total = 0;
//		
//		for (Ingrediente ingrediente : ingredientes) {
//			total += ingrediente.getPreco();
//		}
//		
//		this.valorTotal = total;
//		
//		return total;
//	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public boolean isNull(){
		
		boolean x = false;
		
		if(ingredientes == null || instrucoes == null)
			x = true;
			
		return x;
	}
	
	public void setIngredientes(Ingrediente ingrediente) {

		ingredientes.add(ingrediente);
		valorTotal += ingrediente.getPreco();
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
	
	public boolean getIngredientePeloNome(String umNome){
		
		boolean retorno = false;
		
		for (Ingrediente ingrediente : ingredientes) {
			
			if(ingrediente.getNome() == umNome){
				retorno = true;
			}
		}
		
		return retorno;
	}
	
	public List<Instrucao> getInstrucoes() {
		return instrucoes;
	}
}
