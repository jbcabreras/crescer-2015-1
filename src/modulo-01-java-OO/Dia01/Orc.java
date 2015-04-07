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
    double nr = 0.0;

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
            double umNR = this.gerarNumero() < 0 ? this.setXP(2) :
                (!(this.getNR() > 0 && this.getNR() < 100) ? this.vida -= 10 : this.getNR());           
            
            if(this.vida == 0){
                status = status.morto;
            }
        }
        // this.vida = this.vida - 10;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public double gerarNumero(){
        this.nr = this.getNome().length() > 5 ? (this.nr + 65) : (this.nr - 60);
        this.nr = this.getVida() < 30 && this.getVida() < 60 ? this.nr * 2 : (this.getVida() < 20 ? this.nr * 3 : this.nr);
        this.nr = this.getStatus() == status.fugindo ? this.nr / 2 : 
            (this.getStatus() == status.cacando || this.getStatus() == status.dormindo ? this.nr + 1 : this.nr);
        this.nr = this.getXP() % 2 == 0 ? Math.pow(this.nr, 3) :
            (this.nr > 2 ? Math.pow(this.nr, 2) : this.nr);        
        return this.nr;
    }
    
    public double getNR(){
        return this.nr;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getXP(){
        return this.xp;
    }
    
    public int setXP(int umaXP){
        return this.xp += umaXP;
    }

    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
}
