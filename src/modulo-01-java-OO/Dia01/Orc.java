import java.util.*;

/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int experiencia, vida = 110;
    private String nome;
    private Status status = Status.VIVO;
    private ArrayList<ItemDoInventario> itens = new ArrayList<ItemDoInventario>();
    private final int NUMERO_SORTE = 3481;

    {
        //vida = 110;
    }
    
    /**
     * Construtor para objetos da classe Orc
     */ 
    public Orc(String nome)
    {
        //vida = 110;
        this.nome = nome;
    }
    
    public Orc() {
    }
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        
        double numeroGerado = gerarNumero();
        
        if (numeroGerado < 0) {
            this.experiencia += 2;
            return;
        } else if (numeroGerado >= 0 && numeroGerado <= 100) {
            return;
        } else {
                    
            int danoVida = 10;
            
            if (this.vida >= danoVida) {
                this.vida -= danoVida;
                // this.vida = this.vida - 10;
                this.status = Status.FERIDO;
            } 
            
            if (this.vida == 0) {
                this.status = Status.MORTO;
            }
        }

    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
    }
    
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    public ArrayList<ItemDoInventario> getItens() {
        return this.itens;
    }
    
    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado.
     */
    public void adicionarItem(ItemDoInventario item) {
        this.itens.add(item);
    }

    /**
     * Remove o item do inventário do orc.
     * 
     * @param item Item a ser perdido do inventário.
     */
    public void perderItem(ItemDoInventario item) {
        this.itens.remove(item);
    }    
   
    public String getDescricoesItens(){
        StringBuilder listaItens = new StringBuilder();
        for(int i = 0; i < itens.size(); i++){
            listaItens.append( (i < itens.size() - 1) ? itens.get(i).toString() + "," : itens.get(i).toString());
        }
        return listaItens.toString();
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
    
    /**
     * Concatena as descrições dos itens, separados por vírgula.
     * 
     * SEM ESPAÇO ENTRE AS VÍRGULAS E SEM PONTO FINAL
     * 
     * @return Descrições. Ex:
     * 
     * "Adaga,Escudo,Bracelete”
     */
    public String getDescricoesItens() {
        StringBuilder builder = new StringBuilder();
        
        /*
         * Utilizando for tradicional         
        int numeroDeItens = this.itens.size();

        for (int i = 0; i < numeroDeItens; i++) {
            ItemDoInventario itemAtual = this.itens.get(i);
            
            boolean éÚltimoÍndice = i == numeroDeItens - 1;
                        
            builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
        }
        */
       
       // C#
       //foreach (ItemDoInventario item in this.itens) { }
       
       /*
        * Utilizando FOREACH!!
       for (ItemDoInventario itemAtual : this.itens) {
           int i = this.itens.indexOf(itemAtual);
           int numeroDeItens = this.itens.size();
           boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
           builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
       }
       */
      
      /*
       * JavaScript
      for (var i = 0, numeroDeItens = this.itens.size(); i < numeroDeItens; i++) {
      }
      */
      
     /*
      * WHILE (ENQUANTO)
      int i = 0;
      int numeroDeItens = this.itens.size();    

      while (i < numeroDeItens) {
          ItemDoInventario itemAtual = this.itens.get(i);
          boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
          builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
          );
          //
          i++;
      }
      */
     
     int i = 0;
     int numeroDeItens = this.itens.size();
     do {
         if (numeroDeItens > 0) {
             ItemDoInventario itemAtual = this.itens.get(i);
              boolean éÚltimoÍndice = i == numeroDeItens - 1;
               
              builder.append(
                    éÚltimoÍndice ?
                    itemAtual.getDescricao() :
                    itemAtual.getDescricao() + ","
              );
         }
         i++;
     } while(i < numeroDeItens);
     
       return builder.toString();
    }
    
    /**
     * Caso o Orc tenha sorte, adiciona 1000 quantidades para cada item do inventário.
     */
    public void tentarSorte() {
        
        double numeroGerado = gerarNumero();
        
        if (numeroGerado == NUMERO_SORTE) {
            for (ItemDoInventario item : this.itens) {
                int novaQuantidadeItem = item.getQuantidade() + 1000;
                item.setQuantidade(novaQuantidadeItem);
            }
        }
        
    }
    
    private double gerarNumero() {
        
        double numeroGerado = 0.0;
        
        // A. Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número. Caso contrário, subtraia 60.
        boolean possuiNome = this.nome != null && this.nome.length() > 5;
        
        if (possuiNome && this.nome.length() > 5) {
            numeroGerado += 65;
        } else {
            numeroGerado -= 60;
        }
        
        // B. Se o orc possuir vida entre 30 e 60, multiple o número por dois,
        // senão se a vida for menor que 20 multiplique por 3.
        boolean possuiVidaEntre30e60 = this.vida >= 30 && this.vida <= 60;
        
        if (possuiVidaEntre30e60) {
            numeroGerado *= 2;
        } else if (this.vida < 20) {
            numeroGerado *= 3;
        }
        
        // C. Se o orc estiver fugindo, divida o número por 2. Senão se o orc estiver caçando ou dormindo adicione 1 ao número.
        if (this.status == Status.FUGINDO) {
            numeroGerado /= 2;
        } else if (this.status == Status.CAÇANDO || this.status == Status.DORMINDO) { 
            numeroGerado += 1;
        }
        
        // D. Se a experiência do orc for par, eleve o número ao cubo. 
        // Se for ímpar e o orc tiver mais que 2 de experiência, eleve o número ao quadrado.
        boolean experienciaÉPar = this.experiencia % 2 == 0;
        if (experienciaÉPar) {
            numeroGerado = numeroGerado * numeroGerado * numeroGerado;
        } else if (this.experiencia > 2) {
            numeroGerado = numeroGerado * numeroGerado;
        }
                
        return numeroGerado;
    }
}
