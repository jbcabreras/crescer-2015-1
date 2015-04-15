

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
        
        try{
            eObtido.alistarElfo(e);
        }catch (NaoPodeAlistarException error){      
            System.out.println(error);
        }finally{
            System.out.println("Finalmente ultimo dia de BlueJ!");
        }
        
        assertEquals(eEsperado.isEmpty(), eObtido.taVazi());        
    }
    
    
     @Test
    public void AlistaElfoNoExercitoComUmElfoNoturno(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        ElfoNoturno en = new ElfoNoturno("teste");
        
        eEsperado.put("teste", en);
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
        
        try{
            eObtido.alistarElfo(en);
        }catch (NaoPodeAlistarException error){      
            System.out.println(error);
        }finally{
            System.out.println("Finalmente ultimo dia de BlueJ!");
        }
        
        assertEquals(eEsperado.get("teste"), eObtido.buscarElfo("teste"));        
    }
    
    @Test
    public void AlistaElfoNoExercitoComUmElfoVerde(){
        HashMap<String, Elfo> eEsperado = new HashMap<>();
        ElfoVerde ev = new ElfoVerde("teste");
        
        eEsperado.put("teste", ev);
        
        ExercitoDeElfos eObtido = new ExercitoDeElfos();
       
        try{
            eObtido.alistarElfo(ev);
        }catch (NaoPodeAlistarException error){      
            System.out.println(error);
        }finally{
            System.out.println("Finalmente ultimo dia de BlueJ!");
        }
        
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
        
        try{
            eObtido.alistarElfo(ev1);
            eObtido.alistarElfo(ev2);
            eObtido.alistarElfo(en1);
            eObtido.alistarElfo(en2);
            eObtido.alistarElfo(e);
        }catch (NaoPodeAlistarException error){      
            System.out.println(error);
        }finally{
            System.out.println("Finalmente ultimo dia de BlueJ!");
        }
        
        
        assertEquals(eEsperado.size(), eObtido.tamanho());        
    }
    
    @Test
    public void AgruparVariosElfosPorStatus(){
        Elfo eVivo1 = new ElfoVerde("teste1");
        Elfo eVivo2 = new ElfoNoturno("teste2");
        Elfo eVivo3 = new ElfoVerde("teste3");
        Elfo eAtac1 = new ElfoVerde("teste4");
        Elfo eAtac2 = new ElfoVerde("teste5");
        
        eAtac1.atirarFlecha(new Orc());
        eAtac2.atirarFlecha(new Orc());
        
        HashMap<Status, ArrayList<Elfo>> esperado = new HashMap<>();
        
        esperado.put(Status.ATACANDO, new ArrayList<>(
            Arrays.asList(eAtac2, eAtac1)
        ));
        esperado.put(Status.VIVO, new ArrayList<>(
            Arrays.asList(eVivo3, eVivo1, eVivo2)
        ));
        
        ExercitoDeElfos obtido = new ExercitoDeElfos();
        
        try{
            obtido.alistarElfo(eAtac1);
            obtido.alistarElfo(eAtac2);
            obtido.alistarElfo(eVivo1);
            obtido.alistarElfo(eVivo2);
            obtido.alistarElfo(eVivo3);
        }catch (NaoPodeAlistarException error){      
            System.out.println(error);
        }finally{
            System.out.println("Finalmente ultimo dia de BlueJ!");
        }
        
        
        obtido.agruparPorStatus();
        
        assertEquals(esperado, obtido.getElfosPorStatus());
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
        
         try{
              eObtido.alistarElfo(ev1);
              eObtido.alistarElfo(ev2);
              eObtido.alistarElfo(en1);
              eObtido.alistarElfo(en2);
              eObtido.alistarElfo(e);
        
        }catch (NaoPodeAlistarException error){      
            System.out.println(error);
        }finally{
            System.out.println("Finalmente ultimo dia de BlueJ!");
        }
      
        assertEquals(eEsperado, eObtido.retornaElfosComStatusInformado(Status.VIVO));        
    }
}
