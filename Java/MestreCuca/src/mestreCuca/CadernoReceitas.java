package mestreCuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadernoReceitas implements LivroReceitas {
	
	private Map<String, Receita> cadernoReceita = new HashMap<>();
	
	private double valorTotalReceitas;
	
	public List<String> listaCompras(List<Receita> receitas){
		
		List<Ingrediente> listaIng = new ArrayList<Ingrediente>();
		List<Ingrediente> listaFinal = new ArrayList<Ingrediente>();
		List<String> listaCompras = new ArrayList<String>();
				
 		for (Receita receita : receitas) {
			
			for(Ingrediente ingrediente : receita.getIngredientes()){
				
				if(listaIng.isEmpty()){
					
					listaIng.add(ingrediente);
					listaFinal.add(ingrediente);
					
				}else{
					for (Ingrediente ing : listaIng) {
						
						if(!ing.getNome().contains(ingrediente.getNome())){
							
							listaFinal.add(ingrediente);
							
						}else{
							if(ing.getUnidade().equals(ingrediente.getUnidade())){
								
								double qtd = ing.getQuantidade() + ingrediente.getQuantidade();
								
								ing.setQuantidade(qtd);
								
								listaFinal.add(ing);
							}
						}
					}
				}
			}
		}
 		
// 		public Map<Ingrediente, Double> geraListaDeCompras(List<Receita> receitas) {
// 			Map<Ingrediente, Double> listaDeCompras = new HashMap<>();
// 			for(Receita receita : receitas){
// 				for(Ingrediente ingrediente : receita.getIngredientes()){
// 					double quantidadeAcumulada = listaDeCompras.getOrDefault(ingrediente, 0.0);
// 					double quantidadeDoIngrediente = ingrediente.getQuantidade();
// 					listaDeCompras.put(ingrediente, quantidadeAcumulada + quantidadeDoIngrediente);
// 				}
// 			}
// 			return listaDeCompras;
// 			
// 		}
 		
 		for (Ingrediente ingrediente : listaIng) {
			listaCompras.add(ingrediente.getQuantidade() + " " + ingrediente.getUnidade() + " de " + ingrediente.getNome() );
		}
 		
 		return listaCompras;
	}
	
	public List<Receita> retornaSemAlergicos(List<Ingrediente> alergicos){
		
		List<Receita> novaLista = new ArrayList<>();
		List<Receita> retornada = new ArrayList<>();
		
		for (Receita receita : cadernoReceita.values()) {
			retornada.add(receita);
			novaLista.add(receita);
		}
		
		for (Ingrediente ingrediente : alergicos) {
			
			for (Receita receita : retornada) {
				
				if(receita.getIngredientePeloNome(ingrediente.getNome())){

					novaLista.remove(receita);
				}
			}
		}
		return novaLista;
	}
	
	public double calculaValorTotalReceitas(List<Receita> lista){
		
		double total = 0;
		
		for (Receita receita : lista) {
			
			total += receita.getValorTotal();
		}
		
		this.valorTotalReceitas = total;
		
		return total;
	}
		
	@Override
	public void inserir(Receita receita) {

		if(receita.isNull()){
			System.out.println("receita invalida!");
		}else{
			cadernoReceita.put(receita.getNome(), receita);
		}
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		
		Receita receita = buscaReceitaPeloNome(nome);
		
		if(receita != null){
			cadernoReceita.put(nome, receitaAtualizada);
		}
	}

	@Override
	public void excluir(String nome) {

		cadernoReceita.remove(buscaReceitaPeloNome(nome));
	}

	@Override
	public List<Receita> getTodasReceitas() {
		
		ArrayList<Receita> lista = new ArrayList<Receita>();
		
		for (Receita receita : cadernoReceita.values()) {
			lista.add(receita);
		}

		return lista;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		
		if(cadernoReceita.containsKey(nome)){
			return cadernoReceita.get(nome);
		}else{
			
			throw new ReceitaNaoEncontradaException();
		}
	}

}
