
/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc
{
    private String nome;
    private int vida;
    
    public Orc(String umNome){
        this.nome = umNome;
        this.vida = 110;
    }
    
    public void perdeVida(){
        this.vida -= 10;
    }
}
