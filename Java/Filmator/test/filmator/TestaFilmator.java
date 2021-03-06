package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

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
		
		Filme f = new Filme("Teste", Genero.ACAO);
		
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
		
		Filme filme = new Filme("Mais um Teste", Genero.COMEDIA);
		
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
						
		Filme filme = new Filme("outro teste", Genero.DRAMA);
		
		filme.adicionaAtor(a1);
		filme.adicionaAtor(a2);
		filme.adicionaAtor(a3);
		
		assertEquals(esperado, filme.procuraAtor("rodrigo"));
	}
	
	@Test
	public void testaListaFilmes() throws Exception {
		
		Filme f1 = new Filme("apenas mais um Filme", Genero.DRAMA);
		Filme f2 = new Filme("um Filme", Genero.DRAMA);
		Filme f3 = new Filme("mais um filme", Genero.DRAMA);
		Filme f4 = new Filme("outro filme", Genero.DRAMA);
		
		HashMap<String, Filme> esperado = new HashMap<String, Filme>();
		
		esperado.put("apenas mais um Filme", f1);
		esperado.put("outro filme", f4);
		esperado.put("um Filme", f2);
		esperado.put("mais um filme", f3);
		
		Netflox nf = new Netflox();
		
		nf.adicionaFilme("apenas mais um Filme", f1);
		nf.adicionaFilme("mais um filme", f3);
		nf.adicionaFilme("um Filme", f2);
		nf.adicionaFilme("outro filme", f4);
		
		assertEquals(esperado.keySet(), nf.getKeySet());
	}
	
	@Test
	public void testaReproduzirFilmeQueNaoEstaNoCatalogo() throws Exception {
		
		Filme f1 = new Filme("apenas mais um Filme", Genero.DRAMA);
		Filme f2 = new Filme("um Filme", Genero.DRAMA);
		Filme f3 = new Filme("mais um filme", Genero.DRAMA);
		Filme f4 = new Filme("outro filme", Genero.DRAMA);
		
		boolean esperado = false;
		
		Netflox nf = new Netflox();
		
		nf.adicionaFilme("apenas mais um Filme", f1);
		nf.adicionaFilme("mais um filme", f3);
		nf.adicionaFilme("um Filme", f2);
		
		assertEquals(esperado, nf.reproduzirFilme(f4));
	}
	
	@Test
	public void testaReproduzirFilmeQueEstaNoCatalogo() throws Exception {
		
		Filme f1 = new Filme("apenas mais um Filme", Genero.DRAMA);
		Filme f2 = new Filme("um Filme", Genero.DRAMA);
		Filme f3 = new Filme("mais um filme", Genero.DRAMA);
		Filme f4 = new Filme("outro filme", Genero.DRAMA);
		
		boolean esperado = true;
		
		Netflox nf = new Netflox();
		
		nf.adicionaFilme("apenas mais um Filme", f1);
		nf.adicionaFilme("mais um filme", f3);
		nf.adicionaFilme("um Filme", f2);
		
		assertEquals(esperado, nf.reproduzirFilme(f2));
	}
	
	@Test
	public void testaGerarRelatorioComNenumaReproducao() throws Exception {
		
		HashMap<Genero, Integer> esperado = new HashMap<Genero, Integer>();
		
		esperado.put(Genero.ACAO, 0);
		esperado.put(Genero.COMEDIA, 0);
		esperado.put(Genero.DRAMA, 0);
		
		
		Netflox nf = new Netflox();
		
		assertEquals(esperado.entrySet(), nf.gerarRelatorio());
	}
	
	@Test
	public void testaGerarRelatorioComUmaReproducaoDeCada() throws Exception {
		
		Filme f1 = new Filme("apenas mais um Filme", Genero.ACAO);
		Filme f2 = new Filme("um Filme", Genero.COMEDIA);
		Filme f3 = new Filme("mais um filme", Genero.DRAMA);
		
		HashMap<Genero, Integer> esperado = new HashMap<Genero, Integer>();
		
		esperado.put(Genero.ACAO, 1);
		esperado.put(Genero.COMEDIA, 1);
		esperado.put(Genero.DRAMA, 1);
		
		
		Netflox nf = new Netflox();
		
		nf.adicionaFilme("apenas mais um Filme", f1);
		nf.adicionaFilme("mais um filme", f3);
		nf.adicionaFilme("um Filme", f2);
		
		nf.reproduzirFilme(f2);
		nf.reproduzirFilme(f1);
		nf.reproduzirFilme(f3);
		
		assertEquals(esperado.entrySet(), nf.gerarRelatorio());
	}
	
	@Test
	public void testaGerarRelatorioCom5ReproducoesDeCada() throws Exception {
		
		Filme f1 = new Filme("apenas mais um Filme", Genero.ACAO);
		Filme f2 = new Filme("um Filme", Genero.COMEDIA);
		Filme f3 = new Filme("mais um filme", Genero.DRAMA);
		
		HashMap<Genero, Integer> esperado = new HashMap<Genero, Integer>();
		
		esperado.put(Genero.ACAO, 5);
		esperado.put(Genero.COMEDIA, 5);
		esperado.put(Genero.DRAMA, 5);
		
		Netflox nf = new Netflox();
		
		nf.adicionaFilme("apenas mais um Filme", f1);
		nf.adicionaFilme("mais um filme", f3);
		nf.adicionaFilme("um Filme", f2);
		
		nf.reproduzirFilme(f2);
		nf.reproduzirFilme(f2);
		nf.reproduzirFilme(f2);
		nf.reproduzirFilme(f2);
		nf.reproduzirFilme(f2);
		
		nf.reproduzirFilme(f1);
		nf.reproduzirFilme(f1);
		nf.reproduzirFilme(f1);
		nf.reproduzirFilme(f1);
		nf.reproduzirFilme(f1);
		
		nf.reproduzirFilme(f3);
		nf.reproduzirFilme(f3);
		nf.reproduzirFilme(f3);
		nf.reproduzirFilme(f3);
		nf.reproduzirFilme(f3);
		
		assertEquals(esperado.entrySet(), nf.gerarRelatorio());
	}
	
}
