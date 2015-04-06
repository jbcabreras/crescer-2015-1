

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrcTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrcTest
{
   @Test
   public void orcNasceCom110Vida(){
       //Arrange = montagem dos dados de teste
       Orc umOrc;
       //Act = execucao da acao de testes
       umOrc = new Orc();
       //Assert = verificacao se o resultado é o esperado
       int esperado = 110;
       int obtido = umOrc.getVida();
       
       assertEquals(esperado, obtido);
    }
    
    @Test
    public void perde10Vida(){
        Orc umOrc = new Orc();
        
        int esperado = 100; 
        umOrc.perdeVida();
        
        int obtido = umOrc.getVida();
        
        assertEquals(esperado, obtido);
    }
    
       @Test
    public void perde20Vida(){
        Orc umOrc = new Orc();
        
        int esperado = 90; 
        umOrc.perdeVida();
        umOrc.perdeVida();
        
        int obtido = umOrc.getVida();
        
        assertEquals(esperado, obtido);
    }
    
       @Test
    public void perde50Vida(){
        Orc umOrc = new Orc();
        
        int esperado = 60; 
        umOrc.perdeVida();
        umOrc.perdeVida();
        umOrc.perdeVida();
        umOrc.perdeVida();
        umOrc.perdeVida();
        
        int obtido = umOrc.getVida();
        
        assertEquals(esperado, obtido);
    }
   
}
