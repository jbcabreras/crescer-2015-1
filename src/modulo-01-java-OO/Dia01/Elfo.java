
/**
 * 
 * @author CWI Software
 */
public class Elfo
{
    // Versão correção do tema!!
    
    private String nome;
    private int flechas, experiencia;

    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos Elfo !teste commit!
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        // this.nome = nome;
        this.flechas = flechas;
    }
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
   
//     public void atirarFlecha() {
//         //flechas = flechas - 1;
//         flechas--;
//         experiencia++;
//     }
     /**
     * Atira uma flecha e perde uma unidade.
     * @param umOrc Nome do orc que vai receber a flechada
     */
    
    public void atiraFlechaOrc(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        
        umOrc.perdeVida();
    }
    
    public int getFlechas(){
        return this.flechas;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getXP(){
        return this.experiencia;
    }
    
//     public void setNome(String novoNome) {
//         nome = novoNome;
//     }
   
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    
    
    
    
    
}
