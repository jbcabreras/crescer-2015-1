package listator;

import java.io.File;

import javax.swing.JOptionPane;

public class Listar {

	public static void main(String[] args) {
		
		String caminho = JOptionPane.showInputDialog("digite o diretorio a ser listado");  
        StringBuilder sb = new StringBuilder();  
          
        File raiz = new File(caminho);  
          
        for(File f: raiz.listFiles()) {  
            if(f.isFile()) {  
                System.out.println(f.getName());  
                sb.append(f.getName());  
                sb.append("\n");  
            }  
        }  
        javax.swing.JOptionPane.showMessageDialog(null, sb.toString());  
    }  

}
