package filmator;

public class App {

	public static void main(String[] args) {
		
		Ator a1 = new Ator("Rodrigo Frohlich");
		Ator a2 = new Ator("Rodrigo teste");
		Ator a3 = new Ator("Rodrigo fera");
		Ator a4 = new Ator("Rodrigo gato");
		Ator a5 = new Ator("Cassiano");
		
		Filme f = new Filme();
		
		f.adicionaAtor(a1);
		f.adicionaAtor(a2);
		f.adicionaAtor(a3);
		f.adicionaAtor(a4);
		f.adicionaAtor(a5);
		
		System.out.println(f.listaElenco());
		
		System.out.println(f.procuraAtor("Rodrigo"));		
		
	}

}
