/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private Status status = Status.vivo;
    private String nome;
    private int xp = 0;

    {
        //vida = 110;
        Status status = Status.vivo;
    }
    
   // Construtor para objetos da classe Orc
    public Orc(String umNome){
        this.nome = umNome;
    }
    
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        if(this.vida <= 0){
            status = status.morto;

        }else{
            this.vida -= 10;
            if(this.vida == 0){
                status = status.morto;
            }
        }
        // this.vida = this.vida - 10;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus(){              
        return status;
    }
}
