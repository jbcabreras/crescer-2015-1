
/**
 * Write a description of class ItemDoInventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemDoInventario
{
   private String descricao;
   private int quantidade;
   
   public ItemDoInventario(String umaDescricao, int umaQuantidade){
       this.descricao = umaDescricao;
       this.quantidade = umaQuantidade;
    }
    
   public String getDescricao(){
           return this.descricao;
    }
       
   public int getQuantidade(){
           return this.quantidade;
    } 
   
}
