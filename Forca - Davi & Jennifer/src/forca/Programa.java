package forca;


import java.util.Scanner;
/**
 * @author davi
 * @author jennifer
 */
public class Programa {
    public static void main(String[] args) {
        
        Scanner leitura = new Scanner(System.in);

        Jogo forca = new Jogo();

        int c;
        System.out.println(forca.toString());
        
        while (!forca.fimDeJogo()) {
            System.out.print("Letra(s): ");
            String palavra = leitura.nextLine();
            char letras[];
            letras = palavra.toCharArray();
            for (c = 0; c < palavra.length(); c++) {
                forca.adivinha(letras[c]);
                
            }
            System.out.println(forca.toString());
        }

    }

}