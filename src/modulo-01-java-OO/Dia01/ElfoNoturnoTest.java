

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
public class ElfoNoturnoTest
{
    private final double DELTA = 0.005;
    
    @Test
public void ElfosNoturnosGanhamOTriploDeXPAoAtirarUmaFlecha(){

    ElfoNoturno e = new ElfoNoturno("teste");
    
    Orc o = new Orc();
    
    e.atirarFlecha(o);
    
    int xpE = 3;
    
    assertEquals(xpE, e.getExperiencia());
}

    @Test
public void ElfosNoturnosPerdem5PorCentoDeVidaAoAtirarUmaFlecha(){

    ElfoNoturno e = new ElfoNoturno("teste");
    
    Orc o = new Orc();
    
    e.atirarFlecha(o);
    
    double vidaE = 95.0;
    
    assertEquals(vidaE, e.getVida(), DELTA);
}
}
