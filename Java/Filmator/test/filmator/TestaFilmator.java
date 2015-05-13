package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import filmator.Ator;

public class TestaFilmator {
	
	@Test
	public void testaToStringAtor() throws Exception {
		
		Ator a1 = new Ator("Rodrigo");
		
		String esperado = "Rodrigo";
		
		assertEquals(esperado, a1.toString());
	}
	
	@Test
	public void testaToStringFilme() throws Exception {
		
		Ator a1 = new Ator("Rodrigo Frohlich");
		Ator a2 = new Ator("Rodrigo teste");
		Ator a3 = new Ator("Cassiano");
		
		String esperado = "Rodrigo FrohlichRodrigo testeCassiano";
		
		Filme f = new Filme();
		
		f.adicionaAtor(a1);
		f.adicionaAtor(a2);
		f.adicionaAtor(a3);
		
		assertEquals(esperado, f.toString());
	}
	
	@Test
	public void insereAtorEmFilme() throws Exception {
		
		Ator a1 = new Ator("Rodrigo Frohlich");
		Ator a2 = new Ator("Rodrigo teste");
		Ator a3 = new Ator("Cassiano");
		
		ArrayList<Ator> esperado = new ArrayList<Ator>();
		esperado.add(a1);
		esperado.add(a2);
		esperado.add(a3);
		
		Filme filme = new Filme();
		
		filme.adicionaAtor(a1);
		filme.adicionaAtor(a2);
		filme.adicionaAtor(a3);
		
		assertEquals(esperado, filme.getElenco());
	}
	
	@Test
	public void procuraAtoresPorUmaString() throws Exception {
		
		String esperado = "Rodrigo FrohlichRodrigo teste";
		
		Ator a1 = new Ator("Rodrigo Frohlich");
		Ator a2 = new Ator("Rodrigo teste");
		Ator a3 = new Ator("Cassiano");
						
		Filme filme = new Filme();
		
		filme.adicionaAtor(a1);
		filme.adicionaAtor(a2);
		filme.adicionaAtor(a3);
		
		assertEquals(esperado, filme.procuraAtor("rodrigo"));
	}
}
