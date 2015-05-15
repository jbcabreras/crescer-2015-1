package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class Testes {
	
	@Test
	public void indexOfTest() throws Exception {
		
		String teste = "teste";
		
		int esperado = 2;
		
		assertEquals(esperado, teste.indexOf('s'));
	}
	
	@Test
	public void replaceTest() throws Exception {
		
		String teste = "teste";
		
		String esperado = "te2te";
		
		assertEquals(esperado, teste.replace('s', '2'));
		
	}
	
	@Test
	public void splitTest() throws Exception {
		
		String teste[] = {"t", "e", "s", "t", "e"};
		
		String palavra = "teste";
		
		String esperado[] = palavra.split("");
		
		assertEquals(esperado[2], teste[2]);
		
	}
	
	@Test
	public void getTest() throws Exception {
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("um");
		al.add("dois");
		al.add("tres");
		
		String esperado = "tres";
		
		assertEquals(esperado, al.get(2));
		
	}
	
	@Test
	public void setTest() throws Exception {
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("um");
		al.add("dois");
		al.add("tres");
		
		String esperado = "3";
		
		al.set(2, "3");
		
		assertEquals(esperado, al.get(2));		
	}
	
	@Test
	public void indexOfListTest() throws Exception {
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("um");
		al.add("dois");
		al.add("tres");
		
		int esperado = 0;
		
		assertEquals(esperado, al.indexOf("um"));		
	}
	
	@Test
	public void getMapTest() throws Exception {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("um", 1);
		hm.put("dois", 2);
		hm.put("tres", 3);
		
		Integer esperado = 2;
		
		assertEquals(esperado, hm.get("dois"));	
	}
	
	@Test
	public void putMapTest() throws Exception {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("um", 1);
				
		int esperado = 1;
		
		assertEquals(esperado, hm.size());	
	}
	
	@Test
	public void containsKeyMapTest() throws Exception {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("um", 1);
		hm.put("dois", 2);
		hm.put("tres", 3);
		
		boolean esperado = true;
		
		assertEquals(esperado, hm.containsKey("tres"));	
	}
	
	@Test
	public void containsValueMapTest() throws Exception {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("um", 1);
		hm.put("dois", 2);
		hm.put("tres", 3);
		
		boolean esperado = true;
		
		assertEquals(esperado, hm.containsValue(3));	
	}	
}
