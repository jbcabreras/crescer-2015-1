package testes;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import desafio.Desafio;

public class test {
	
	@Test
	public void testaRestornaIndice() throws Exception {
		
		
		ArrayList<Integer> esperado = new ArrayList<Integer>();
		
		esperado.add(0);
		esperado.add(4);
		
		assertEquals(esperado, Desafio.maiusculas("TestE"));
	}

}
