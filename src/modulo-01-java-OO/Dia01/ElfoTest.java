

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
}
