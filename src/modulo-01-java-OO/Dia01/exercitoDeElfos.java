import java.util.*;

/**
 * Write a description of class exercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    
    public void alistarElfo(Elfo umElfo){
        if(umElfo instanceof ElfoVerde || umElfo instanceof ElfoNoturno){
            exercito.put(umElfo.getNome(), umElfo);
        }
    }
    
    public Elfo buscarElfo(String nomeElfo){
        return exercito.get(nomeElfo);
    }
}
