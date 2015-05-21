package test;

import static org.junit.Assert.assertEquals;
import mestreCuca.Ingrediente;
import mestreCuca.Receita;
import mestreCuca.UnidadeMedida;

import org.junit.Test;


public class ReceitaTest {

	@Test
	public void valorTotalReceitaDeveSerSomaDoValorDosIngredientes() throws Exception {
		Receita receita = new Receita("Feijoada");
		receita.adicionarIngrediente(new Ingrediente("Feijão", UnidadeMedida.KG, 0.5, 5));
		receita.adicionarIngrediente(new Ingrediente("Sal", UnidadeMedida.COLHER_SOPA, 1, 1));
		
		double resultado = receita.calcularValorTotal();
		assertEquals(6, resultado, 0.0005);
	}
	

}