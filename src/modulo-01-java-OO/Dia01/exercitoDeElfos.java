import java.util.*;

/**
 * Write a description of class exercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos
{
    
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private Status statusExercito = Status.VIVO;
      
    public void alistarElfo(Elfo umElfo){
        if(umElfo instanceof ElfoVerde || umElfo instanceof ElfoNoturno){
            exercito.put(umElfo.getNome(), umElfo);
        }
    }
    
    public Elfo buscarElfo(String nomeElfo){
        return exercito.get(nomeElfo);
    }
    
    public boolean taVazi(){
        return exercito.isEmpty();
    }
    
    public int tamanho(){
        return exercito.size();
    }
    
    public Status getStatus(){
        return this.statusExercito;
    }
    
    public ArrayList<Elfo> retornaElfosComStatus(Status umStatus){
        Elfo umElfo;
        ArrayList<Elfo> elfosComMesmoStatus = new ArrayList<>();
                
        for(String chave : exercito.keySet()){
            umElfo = exercito.get(chave);            
            
            if(umElfo.getStatus() == umStatus){
                elfosComMesmoStatus.add(umElfo);
            }
        }
        
        return elfosComMesmoStatus; 
    }
}
