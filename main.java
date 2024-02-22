import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos Elementos quer ter no array: ");
        int x;
        x = sc.nextInt();
        int array[] =  new int[x];
        for(int i=0; i<x;i++){
            System.out.println("Digite os valores no array: ");
            array[i]= sc.nextInt();
        }
        System.out.println("Digite o valor que quer ser verificado no array: ");
        int valorverificar;
        valorverificar = sc.nextInt();
        boolean verificar = false;
        for(int i=0; i<x;i++){
            if(array[i]== valorverificar){
                verificar = true;
            }else{
                verificar = false;
            }
        }
        if(verificar=true){
        System.out.println("Valor esta no array");
         }else{
                System.out.println("Valor nao esta no array");
    sc.close();
        }
    }
}