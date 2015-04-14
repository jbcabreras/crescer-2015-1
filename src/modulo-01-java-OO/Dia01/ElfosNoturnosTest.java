

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfosNoturnosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfosNoturnosTest
{
    
    @Test
public void ElfosNoturnosGanhamOTriploDeXPAoAtirarUmaFlecha(){

    ElfosNoturnos e = new ElfosNoturnos("teste");
    
    Orc o = new Orc();
    
    e.atirarFlecha(o);
    
    int xpE = 3;
    
    assertEquals(xpE, e.getExperiencia());
}

    @Test
public void ElfosNoturnosPerdem5PorCentoDeVidaAoAtirarUmaFlecha(){

    ElfosNoturnos e = new ElfosNoturnos("teste");
    
    Orc o = new Orc();
    
    e.atirarFlecha(o);
    
    int vidaE = 95;
    
    assertEquals(vidaE, e.getVida());
}
}
