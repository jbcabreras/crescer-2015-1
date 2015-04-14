
/**
 * Write a description of class ElfosVerdes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfosVerdes extends Elfo{
    
    public ElfosVerdes(String nome){
        super(nome);
    } 
    public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha(umOrc);
        experiencia ++;        
    }
    
    public void adicionarItem(ItemDoInventario item){
        if(item.getDescricao().equals("Espada de aço valiriano") ||
            item.getDescricao().equals("Arco e Flecha de vidro")){
            
                this.itens.add(item);
            }
    }
}
