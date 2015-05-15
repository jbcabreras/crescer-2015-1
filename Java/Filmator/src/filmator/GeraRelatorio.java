package filmator;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class GeraRelatorio {

	private HashMap<Genero, Integer> contador = new HashMap<Genero, Integer>();

	
	public void populaContador(){
		
		for (Genero gen : Genero.values()) {
			
			contador.put(gen, 0);			
		}		
	}
	
	public Set<Entry<Genero, Integer>> gerarRelatorio(){
		
		return contador.entrySet();
	}
	
	public void iteraContador(Genero gen){
		
		int valor = contador.get(gen) + 1;
		
		contador.put(gen, valor);
	}
	
	public Set<Entry<Genero, Integer>> getRelatorio(){
		
		return contador.entrySet();
	}
	
}
