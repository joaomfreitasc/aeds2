package Q10;


import java.util.Scanner;

class Q10 {

    public static boolean palindromo(String frase, int i, int j) {
        if (i >= j / 2) {
            return true;
        }

        if (frase.charAt(i) != frase.charAt(j)) {
            return false;
        }

        return palindromo(frase, i + 1, j - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        while (!(frase = sc.nextLine()).equals("FIM")) {
            int tam = frase.length();
            int j = tam - 1;// ultimo caracter
            int i = 0;
            if (palindromo(frase, i, j)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }

        }

        sc.close();

    }
}
