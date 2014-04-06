package forca;

/**
 *@author davi
 * @author jennifer
 */
public class Jogo {
    
    int i = 0,ac = 0,us = 0;
    /* ac = acertos ; us = usados.*/
    
    char palavraForca[] = {'I','N','G','R','E','S','S','O'};
    
    char palavraErrada[] = {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' '};
    
    char palavraUsada[] = new char[palavraForca.length + palavraErrada.length + 1];
    
    
    int letrasTotal()
    {
        int c = 0; /*c = contador*/
        
        while(c < palavraForca.length)
        {
            c++;
        }
        
        return c;
    }
    
     int letrasCertas()
    {
        int c = 0; /*c = contador*/
        while(palavraUsada[c]!= '|' && palavraUsada[c] == palavraForca[c])
        {
           c++;
        }
        return c;
    }
     
    int letrasErradas()
    {
        int c = 0; /*c = contador*/
        i = 0;
       
        while( i < palavraUsada.length)
        {
            if(palavraErrada[c] == palavraUsada[i])
            {
                c ++;                           
            }
            
            else
            {
               i ++;
            }  
        }
        
        return c; 
    
    }
    
    boolean fimDeJogo()
    {
        if(jogadorGanhou())
        {
            return true;
        }
        
        else
        {
            return jogadorPerdeu();
        }
        
    }
    
    boolean jogadorGanhou()
    {
        if(letrasCertas() == letrasTotal())
        {
            System.out.println("Fim de jogo! Você ganhou! :-)");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    boolean jogadorPerdeu()
    {
        if(letrasErradas() >= 6 )
        {
           System.out.println("Fim de jogo! Você perdeu! :-(");
           return true;
           
        }
        else
        {
            return false;
        }
    }
    
    boolean letraUsada(char l)
    {
        palavraUsada[palavraForca.length] = '|';
         
         for(i=0; i < palavraUsada.length; i++)
         {
             if(palavraUsada[i] == l)
             {
                 System.out.println("Essa letra " + l + " já foi utilizada!");
                 
                 return true;
             }
         }
        return false;
        
    }    
    
    boolean letraCerta(char l)
    {
       ac = 0;
       
       i = 0;
       
       while( i < palavraForca.length)
       {
           
           if(palavraForca[i] == l)
           {
               ac ++;
               palavraUsada[i] = l;
               us ++;
               
           }
           i++;
       }
       
       
       if (ac > 0)
       {
           System.out.println("Você acertou as seguintes letras: "  + l);
           return true;
       }
       else
       {
           return false;
       }       
        
    }
    
    boolean letraErrada(char l)
    {
        System.out.println("Essa letra não está na palavra secreta: "  + l);
        palavraErrada[letrasErradas()] = l;
        palavraUsada[letrasErradas() + (palavraForca.length + 1)] = l;
        
        return true;
    
    }
    int adivinha (char l) /*l = letra - é utilizado na função para especificar a letra utilizada*/
    {
        if(letraUsada(l))
        {
            return -1;
        }
        else if(letraCerta(l))
        {
            return letrasCertas();
        }
        else if(letraErrada(l))
        {
            return 0;
        }
        else if(fimDeJogo())
        {
            return -2;
        }             
        return 0;
    }
    
    @Override
    public String toString()
    {
        palavraUsada[palavraForca.length] = '|';
        String usadas = new String(palavraUsada);
        String erros = new String(palavraErrada);
        String acertos = usadas.replaceAll(erros, "");
        return usadas;
    }
      
    
}
