

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class inventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class inventarioTest
{
   @Test
   public void itemComDescricaoEQuantidade(){
       ItemDoInventario i = new ItemDoInventario(2, "uma descricao");
       
       String descricaoE = "uma descricao";
       int quantidadeE = 2;
       
       assertEquals(descricaoE, i.getDescricao());
       assertEquals(quantidadeE, i.getQuantidade());
    }
}
