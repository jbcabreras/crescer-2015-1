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
    private HashMap<Status, ArrayList<Elfo>> porStatus = new HashMap<>();
    private Status statusExercito = Status.VIVO;
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
    
    public HashMap<Status, ArrayList<Elfo>> getElfosPorStatus(){
        return porStatus;
    }
      
    public void alistarElfo(Elfo umElfo) throws NaoPodeAlistarException {
        if(umElfo instanceof ElfoVerde || umElfo instanceof ElfoNoturno){
            exercito.put(umElfo.getNome(), umElfo);
        }else{
            throw new NaoPodeAlistarException();
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
    
    public void agruparPorStatus(){    
        
        porStatus.clear();
                
        for(Map.Entry<String, Elfo> parChaveValor :exercito.entrySet()){
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            
            if(porStatus.containsKey(status)){
                porStatus.get(status).add(elfo);
            }else{
                porStatus.put(status, new ArrayList<>(
                    Arrays.asList(elfo)
                ));
            }
        }
     }
    
    public HashMap<String, Elfo> retornaElfosComStatusInformado(Status umStatus){
        Elfo umElfo;
        HashMap<String, Elfo> elfosComMesmoStatus = new HashMap<>();
                
        for(String chave : exercito.keySet()){
            umElfo = exercito.get(chave);            
            
            if(umElfo.getStatus() == umStatus){
                elfosComMesmoStatus.put(umElfo.getNome(), umElfo);
            }
        }
        
        return elfosComMesmoStatus; 
    }
    
     
    public ArrayList<Elfo> buscar(Status status) {
        agruparPorStatus();
        return porStatus.get(status);
    }
    
    public void atacarHorda(ArrayList<Orc> orcs) {
        
        ArrayList<Elfo> elfosQueVãoPraPeleia = buscar(Status.VIVO);
        
        estrategia.atacarOrcs(elfosQueVãoPraPeleia, orcs);
    }
}
