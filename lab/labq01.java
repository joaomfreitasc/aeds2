import java.util.Scanner;

public class labq01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase;
        int contador;

        while (!(frase = sc.nextLine()).equals("FIM")) {
            contador = 0;
            int len = frase.length();
            for (int i = 0; i < len; i++) {
                if (Character.isUpperCase(frase.charAt(i))) {
                    contador++;
                }
            }
            System.out.println(contador);
        }
        sc.close();
    }
}
