

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
    @Test    
    public void nasceComNome(){
        Elfo umElfo = new Elfo("Teste");
        
        String nomeE = "Teste"; 
        int flechasE = 42;
        
        String nomeO = umElfo.getNome();  
        int flechasO = umElfo.getFlechas();
        
        assertEquals(nomeE, nomeO);
        assertEquals(flechasE, flechasO);
    }
   
    @Test
      public void nasceComNomeFlechas(){
        Elfo umElfo = new Elfo("Teste", 10);
        
        String nomeE = "Teste"; 
        int flechasE = 10;
        
        String nomeO = umElfo.getNome();  
        int flechasO = umElfo.getFlechas();
        
        assertEquals(nomeE, nomeO);
        assertEquals(flechasE, flechasO);
    }
    
    @Test
      public void atira1Flecha(){
        Elfo umElfo = new Elfo("Teste", 10);
        Orc umOrc = new Orc();
        int flechasE = 9;
        
        umElfo.atiraFlechaOrc(umOrc);
        
        int flechasO = umElfo.getFlechas();
        
        assertEquals(flechasE, flechasO);
    }
}
