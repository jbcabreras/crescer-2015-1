package desafio;

import java.util.ArrayList;

public class Desafio {

	static ArrayList<Integer> indice = new ArrayList<>();

		public static ArrayList maiusculas(String palavra){						
			
		    for (int i = 0; i < palavra.length(); i++){
		        if (Character.isUpperCase(palavra.charAt(i))==true){
		        	
		        	indice.add(i);
		            
		        }
		    }  
		    
		    return indice;
		}   
		
		
		public static void main(String[] args) {
			
			System.out.println(maiusculas("TestE"));
		}
	}




