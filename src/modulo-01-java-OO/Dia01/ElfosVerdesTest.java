

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ElfosVerdesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */

public class ElfosVerdesTest {
@Test
public void ElfosVerdesGanhamODobroDeXPAoAtirarUmaFlecha(){

    ElfosVerdes e = new ElfosVerdes("teste");
    
    Orc o = new Orc();
    
    e.atirarFlecha(o);
    
    int xpE = 2;
    
    assertEquals(xpE, e.getExperiencia());
}

@Test
public void ElfosVerdesSoPodemAdicionar2TiposDeItens(){

    ElfosVerdes e = new ElfosVerdes("teste");
    ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
    
    ItemDoInventario i1 = new ItemDoInventario(3, "teste");
    ItemDoInventario i2 = new ItemDoInventario(2, "teste2");
    ItemDoInventario i3 = new ItemDoInventario(3, "Espada de aço valiriano");
    ItemDoInventario i4 = new ItemDoInventario(2, "Arco e Flecha de vidro");
    
    e.adicionarItem(i1);
    e.adicionarItem(i2);
    e.adicionarItem(i3);
    e.adicionarItem(i4);
    
    inventarioEsperado.add(i3);
    inventarioEsperado.add(i4);
    
    assertEquals(inventarioEsperado, e.getItens());
}
}