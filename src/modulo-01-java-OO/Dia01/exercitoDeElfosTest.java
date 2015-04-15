

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class exercitoDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoDeElfosTest
{
    @Test
    public void AlistaElfoNoExercitoComNenhumElfo(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
        
        assertEquals(eEsperado.isEmpty(), eObtido.taVazi());        
    }
    
     @Test
    public void AlistaElfoNoExercitoComUmElfoGenerico(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        Elfo e = new Elfo("teste");
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
        eObtido.alistarElfo(e);
        
        assertEquals(eEsperado.isEmpty(), eObtido.taVazi());        
    }
    
    
     @Test
    public void AlistaElfoNoExercitoComUmElfoNoturno(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        ElfoNoturno en = new ElfoNoturno("teste");
        
        eEsperado.put("teste", en);
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
        eObtido.alistarElfo(en);
        
        assertEquals(eEsperado.get("teste"), eObtido.buscarElfo("teste"));        
    }
    
    @Test
    public void AlistaElfoNoExercitoComUmElfoVerde(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        ElfoVerde ev = new ElfoVerde("teste");
        
        eEsperado.put("teste", ev);
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
        eObtido.alistarElfo(ev);
        
        assertEquals(eEsperado.get("teste"), eObtido.buscarElfo("teste"));        
    }
    
        @Test
    public void AlistaElfoNoExercitoCom5ElfosSortidos(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        ElfoVerde ev1 = new ElfoVerde("teste1");
        ElfoVerde ev2 = new ElfoVerde("teste2");
        ElfoNoturno en1 = new ElfoNoturno("teste3");
        ElfoNoturno en2 = new ElfoNoturno("teste4");
        Elfo e = new Elfo("e");
        
        eEsperado.put("teste1", ev1);
        eEsperado.put("teste2", ev2);
        eEsperado.put("teste3", en1);
        eEsperado.put("teste4", en2);
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
        eObtido.alistarElfo(ev1);
        eObtido.alistarElfo(ev2);
        eObtido.alistarElfo(en1);
        eObtido.alistarElfo(en2);
        eObtido.alistarElfo(e);
        
        assertEquals(eEsperado.size(), eObtido.tamanho());        
    }
    
    @Test
    public void RetornaElfosComMesmoStatus(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        ElfoVerde ev1 = new ElfoVerde("teste1");
        ElfoVerde ev2 = new ElfoVerde("teste2");
        ElfoNoturno en1 = new ElfoNoturno("teste3");
        ElfoNoturno en2 = new ElfoNoturno("teste4");
        Elfo e = new Elfo("e");
        
        eEsperado.put("teste1", ev1);
        eEsperado.put("teste2", ev2);
        eEsperado.put("teste3", en1);
        eEsperado.put("teste4", en2);
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
        eObtido.alistarElfo(ev1);
        eObtido.alistarElfo(ev2);
        eObtido.alistarElfo(en1);
        eObtido.alistarElfo(en2);
        eObtido.alistarElfo(e);
        
        assertEquals(eEsperado.values(), eObtido.retornaElfosComStatus(Status.VIVO));        
    }
}
