

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ContElfosTest
{
@Test
public void TestaContadorDeElfosCriando1Elfo(){

    Elfo e = new Elfo("teste");
    
    int esperado = 1;
    
    assertEquals(esperado, contElfos.getCont());
}

@Test
public void TestaContadorDeElfosCriando5Elfos(){
    contElfos.zerarCont();
    
    Elfo e1 = new Elfo("teste");
    Elfo e2 = new Elfo("teste");
    Elfo e3 = new Elfo("teste");
    Elfo e4 = new Elfo("teste");
    Elfo e5 = new Elfo("teste");
    
    int esperado = 5;      
    
    assertEquals(esperado, contElfos.getCont());
}

@Test
public void TestaContadorDeElfosCriandoNenhumElfo(){
    contElfos.zerarCont();
       
    int esperado = 0;
    
    assertEquals(esperado, contElfos.getCont());
}


@Test
public void TestaContadorDeElfosCriando5ElfosDeTiposDiferentes(){
    contElfos.zerarCont();
    
    Elfo e1 = new Elfo("teste");
    ElfoVerde e2 = new ElfoVerde("teste");
    ElfoVerde e3 = new ElfoVerde("teste");
    ElfoNoturno e4 = new ElfoNoturno("teste");
    ElfoNoturno e5 = new ElfoNoturno("teste");
    
    int esperado = 5;      
    
    assertEquals(esperado, contElfos.getCont());
}
}
