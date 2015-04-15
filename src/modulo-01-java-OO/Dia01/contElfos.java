
/**
 * Write a description of class contElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class contElfos {
    private static int total = 0;
    
    public static void contar(){
        total++;
    }
    
    public static void zerarCont(){
        total = 0;
    }
    
    public static int getCont(){
        return total;
    }
}
