import java.util.Scanner;

public class Q15 {

    public static boolean vogais(String palavra, int len) {
        if (len < 0) {
            return true;
        }
        char c = Character.toLowerCase(palavra.charAt(len));
        if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
            return false;
        } else {
            return vogais(palavra, len - 1);
        }
    }

    public static boolean consoantes(String palavra, int tam) {
        if (tam < 0) {
            return true;
        }
        char c = Character.toLowerCase(palavra.charAt(tam));
        if (!(c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g'|| c == 'h' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || c == 'p' || c == 'q' || 
            c == 'r'|| c == 's' || c == 't' || c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z')){
                return false;
        } else {
            return consoantes(palavra, tam - 1);
        }
    }

    public static boolean inteiro(String numero, int tam) {
        if (tam < 0) {
            return true;
        }
        if (!(Character.isDigit(numero.charAt(tam)))) {
            return false;
        } else {
            return inteiro(numero, tam - 1);
        }
    }
    
    public static boolean Real(String real, int tam) {
        return ehRealAux(real, tam, 0, false, false);
    }
    
    private static boolean ehRealAux(String real, int tam, int index, boolean pontoEncontrado, boolean digitAntesDoPonto) {
        if (index >= tam) {
            return pontoEncontrado;
        }
    
        char c = real.charAt(index);
    
        if (c == '.') {
            if (!digitAntesDoPonto) {
                return false;
            }
            pontoEncontrado = true;
        } else if (!Character.isDigit(c)) {
            return false;
        } else {
            digitAntesDoPonto = true;
        }
    
        return ehRealAux(real, tam, index + 1, pontoEncontrado, digitAntesDoPonto);
    }
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra;

        while (!(palavra = sc.nextLine()).equals("FIM")) {
            int tam = palavra.length() - 1;
            System.out.print(vogais(palavra, tam) ? "SIM " : "NAO ");
            System.out.print(consoantes(palavra, tam) ? "SIM " : "NAO ");
            System.out.print(inteiro(palavra, tam) ? "SIM " : "NAO ");
            System.out.println(Real(palavra, tam) ? "SIM" : "NAO");
        }
    }
}
