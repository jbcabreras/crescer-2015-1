package main;

import java.util.ArrayList;
import java.util.List;

import mestreCuca.CadernoReceitas;
import mestreCuca.Ingrediente;
import mestreCuca.Instrucao;
import mestreCuca.LivroReceitasJson;
import mestreCuca.Receita;
import mestreCuca.UnidadeMedida;

public class Main {

	public static void main(String[] args) {

		Ingrediente banana = new Ingrediente("banana", 2, UnidadeMedida.UNIDADE, 2.5);
		Ingrediente acucar = new Ingrediente("acucar", 5, UnidadeMedida.XICARA, 3);
		Ingrediente farinha = new Ingrediente("farinha", 2.70, UnidadeMedida.GRAMA, 5);
		Ingrediente pao = new Ingrediente("pao", 5, UnidadeMedida.UNIDADE, 1);
		Ingrediente leite = new Ingrediente("leite", 7.9, UnidadeMedida.UNIDADE, 2);
		Ingrediente ovo = new Ingrediente("ovo", 2, UnidadeMedida.UNIDADE, 5);
		
		Receita rec1 = new Receita("rec1");
		Receita rec2 = new Receita("rec2");
		Receita rec3 = new Receita("rec3");
		Receita rec4 = new Receita("rec4");
		Receita rec5 = new Receita("rec5");
		Receita rec6 = new Receita("rec6");
		
		Instrucao inst1 = new Instrucao("instrucao 1");
		Instrucao inst2 = new Instrucao("instrucao 2");
		Instrucao inst3 = new Instrucao("instrucao 3");
		Instrucao inst4 = new Instrucao("instrucao 4");
		
		rec1.setIngredientes(banana);
		rec1.setIngredientes(ovo);
		rec1.setIngredientes(acucar);
		
		rec2.setIngredientes(farinha);
		rec2.setIngredientes(acucar);
		
		rec3.setIngredientes(pao);
		rec3.setIngredientes(leite);
		rec3.setIngredientes(banana);
		
		rec4.setIngredientes(pao);
		rec4.setIngredientes(leite);
		rec4.setIngredientes(banana);
		
		rec5.setIngredientes(pao);
		rec5.setIngredientes(leite);
		rec5.setIngredientes(banana);
		
		rec6.setIngredientes(pao);
		rec6.setIngredientes(leite);
		rec6.setIngredientes(banana);
		
		rec1.setInstrucoes(inst1);
		rec1.setInstrucoes(inst2);
		
		rec2.setInstrucoes(inst1);
		rec2.setInstrucoes(inst2);
		rec2.setInstrucoes(inst3);
		
		rec3.setInstrucoes(inst2);
		rec3.setInstrucoes(inst3);
		rec3.setInstrucoes(inst4);
		
		List<Receita> listaRec = new ArrayList<Receita>();
		listaRec.add(rec1);
		listaRec.add(rec2);
		listaRec.add(rec3);
		listaRec.add(rec4);
		listaRec.add(rec5);
		listaRec.add(rec6);
		
		CadernoReceitas caderno = new CadernoReceitas();
		caderno.inserir(rec1);
		caderno.inserir(rec2);
		caderno.inserir(rec3);
		
		List<Ingrediente> alergicos = new ArrayList<>();
		alergicos.add(ovo);
		alergicos.add(banana);
		
//		
//		System.out.println(caderno.getTodasReceitas());		
//		System.out.println(caderno.buscaReceitaPeloNome("rec1"));
//		System.out.println(rec1.getValorTotal());
//		System.out.println(caderno.calculaValorTotalReceitas(caderno.getTodasReceitas()));
//		System.out.println(caderno.retornaSemAlergicos(alergicos));
//		
//		for (String linha : caderno.listaCompras(listaRec)) {
//			System.out.println(linha);
//		}
		
//		List<String> umaLista = new ArrayList<String>();
//		
//		umaLista = caderno.listaCompras(listaRec);
//		
//		for (String string : umaLista) {
//			
//			System.out.println(string);
//			
//		}
		
		String caminho = "d:\\temp\\";
		
		LivroReceitasJson livro = new LivroReceitasJson(caminho);
		
		livro.inserir(rec1);
		livro.inserir(rec2);
		livro.inserir(rec3);
		
		
	}

}
