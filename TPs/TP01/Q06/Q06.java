
import java.util.Scanner;

public class Q06 {

    public static boolean apenasVogais(String vogal) {
        for (int i = 0; i < vogal.length(); i++) {
            char c = Character.toLowerCase(vogal.charAt(i));
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                return false;
            }
        }
        return true;
    }

    public static boolean apenasConsoantes(String vogal) {
        for (int i = 0; i < vogal.length(); i++) {
            char c = Character.toLowerCase(vogal.charAt(i));
            if ((c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g'|| c == 'h' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || c == 'p' || c == 'q' || 
            c == 'r'|| c == 's' || c == 't' || c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'y')){
                return false;
            }
        }
        return true;
    }

    public static boolean ehInteiro(String inteiro) {
        for (int i = 0; i < inteiro.length(); i++) {
            if (!(Character.isDigit(inteiro.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean ehReal(String real) {
        boolean pontoEncontrado = false;
        boolean digitAntesDoPonto = false;

        for (int i = 0; i < real.length(); i++) {
            char c = real.charAt(i);

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
        }
        return pontoEncontrado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str;
    
        while (!(str = sc.nextLine()).equals("FIM")) {
            // vogais // consoantes // int // float    
    
            System.out.print(apenasVogais(str) ? "SIM " : "NAO ");
            System.out.print(apenasConsoantes(str) ? "SIM " : "NAO ");
            System.out.print(ehInteiro(str) ? "SIM " : "NAO ");
            System.out.println(ehReal(str) ? "SIM" : "NAO");
    
        }
    
        sc.close();
    }
}
