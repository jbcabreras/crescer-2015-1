package mestreCuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadernoReceitas implements LivroReceitas {
	
	Map<String, Receita> cadernoReceita = new HashMap<>();
	
		
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

		return (List<Receita>) cadernoReceita.values();
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
