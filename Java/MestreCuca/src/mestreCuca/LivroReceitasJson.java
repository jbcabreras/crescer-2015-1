package mestreCuca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroReceitasJson implements LivroReceitas {
	
	private String caminho;
	
	public LivroReceitasJson(String caminho) {
		
		this.caminho = caminho;
	}

	@Override
	public void inserir(Receita receita) {
		
		if(receita.isNull()){
			System.out.println("receita invalida!");
		}else{
			
			List<Receita> lista = new ArrayList<Receita>();
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				
				lista.add(receita);
				mapper.writeValue(new File("d:\\receitas.json"), lista);
				 
//				lista = mapper.readValue(new File("d:\\receitas.json"), ArrayList.class);
//				
//				if(lista.isEmpty() || !lista.contains(receita)){
//					
//					lista.add(receita);
//					
//					// convert user object to json string, and save to a file
//					mapper.writeValue(new File("d:\\receitas.json"), lista);
//			 
//					// display to console
//					System.out.println(mapper.writeValueAsString(lista));
//					
//					
//				}else{
//					
//					System.out.println("receita ja existe!");
//					
//				}
				
		 
			} catch (JsonGenerationException e) {
		 
				e.printStackTrace();
		 
			} catch (JsonMappingException e) {
		 
				e.printStackTrace();
		 
			} catch (IOException e) {
		 
				e.printStackTrace();
		 
			}
		}
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		
		
	}

	@Override
	public void excluir(String nome) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Receita> getTodasReceitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
