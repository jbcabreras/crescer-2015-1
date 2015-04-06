
/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Orc
{
    private int vida = 110;
    
    public void perdeVida(){
        this.vida -= 10;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public String toString(){
        return "";
    }
}
