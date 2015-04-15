
/**
 * Write a description of class ElfosNoturnos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo{
    
    public ElfoNoturno(String nome){
        super(nome);
    } 
    public void atirarFlecha(Orc umOrc) {
        super.atirarFlecha(umOrc);
        experiencia += 2; 
        double vidaAPerder = this.vida * 0.05;
        this.vida = (int)(this.vida - vidaAPerder);
        
        if(this.vida <= 0){
            this.status = status.MORTO;
        }
    }
    
}
