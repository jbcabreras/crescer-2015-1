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
		List<String> listaCompras = new ArrayList<String>();
				
 		for (Receita receita : receitas) {
			
			for(Ingrediente ingrediente : receita.getIngredientes()){
				
				
				if(){
					
				}else{
					for (Ingrediente ing : listaIng) {
						
						if(!ing.getNome().equals(ingrediente.getNome())){
							
							listaIng.add(ing);
						}else{
							if(ing.getUnidade().equals(ingrediente.getUnidade())){
								
								double qtd = ing.getQuantidade() + ingrediente.getQuantidade();
								
								ing.setQuantidade(qtd);
							}
						}
					}
				}
				
			}
		}
 		
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
