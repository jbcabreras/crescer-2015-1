

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestesIntegrados.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestesIntegrados
{
  @Test
  public void umElfoAtiraEm2Orcs(){
      Elfo e = new Elfo("joao");
      Orc o1 = new Orc();
      Orc o2 = new Orc();
      
      e.atiraFlechaOrc(o1);
      e.atiraFlechaOrc(o2);
      
      int xpE = 2;
      int flechasE = 40;
      int vidaO1E = 100;
      int vidaO2E = 100;
      
      assertEquals(xpE, e.getXP());
      assertEquals(flechasE, e.getFlechas());
      assertEquals(vidaO1E, o1.getVida());
      assertEquals(vidaO1E, o2.getVida());
  }   
}
