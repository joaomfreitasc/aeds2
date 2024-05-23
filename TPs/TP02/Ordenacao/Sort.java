package Ordenacao;
import java.util.Random;

public class Sort {

    public static void preencher(int[] array) { //preenche um vetor com numeros aleatorios de 1 até 100
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(10);
        }
    }

    public static void swap(int[] array, int a, int b) { // Troca os elementos nos índices a e b do array
        int tmp = array[a]; 
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void printaDesordenado(int[] array){
        System.out.println("Vetor desordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); // printa o array ordenado
        }
        System.out.println();
    }

    /*
     * 
     */
    public static void printaOrdenado(int[] array){
        System.out.println("Vetor ordenado");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); // printa o array ordenado
        }
        System.out.println();
    }

    /*
     * metodo inserção de ordenação
     */
    public static void insercao(int[] array) {
        preencher(array);
        printaDesordenado(array); 
        for (int i = 1; i < array.length; i++) { // percorre o vetor todo
            int temp = array[i]; // coloca o valor na posição i em temp, para nao sobreescrever ele
            int j = i - 1; // cria a variavez j que vai ser sempre um a menos que o i
            while ((j >= 0) && (array[j] > temp)) { // se for maior ou igual a 0 e o valor de j for mais q tempo
                                                    // continua a comparação
                array[j + 1] = array[j]; // joga o j pra direita pra achar a casa certa
                j--; // decramenta o j
            }
            array[j + 1] = temp; // coloca o valor temp na casa correta
        }
        printaOrdenado(array);
    }/*
      * comparações
      * melhor caso = vetor ordenado de forma crescente = 1
      * pior caso = vetor ordenado de forma decrecente = i-1
      * movimentações
      * melhor e pior caso = n - 1 + 2 = n + 1
      */


    /*
     * metódo quickSort de ordenação
     */
    public static void quickSort(int[] array, int esq, int dir){ //divide o vetor na metade, menores que o pivo a esquerda, maiores que o pivo na direita, repete o precesso até ficar 1 elemento
        int i=esq;
        int j=dir;
        int pivo=array[(dir+esq)/2]; //divide no meio
        while(i<=j){
            while(array[i]<pivo){ //enquanto o i for menor que o pivo, incrementa o i.  para achar o valor que esta do lado errado 
                i++;
            }
             while(array[j]>pivo){ //enquanto  o j  for maior que o pivo, decrementa o j.  para achar o valor que esta do lado errado 
                j--; 
            }
            if(i<=j){  //a posição do i é menor igual a j?
                swap(array,i,j); //se for verdade, troca
                i++;       //incrementa o i
                j--;       //decrementa o j
            }
            //a parte divida ja tem na esquerda os numeros menores que o pivo e na direito os numeros maiores que o pivo
            if(esq<j){
                quickSort(array,esq,j);//chama a função de novo, limitando a direita, deixando só a esquerda
            }
            if(dir>i){
                quickSort(array,i,dir);//chama a função de novo, limitando a esquerda, deixando só a direita
            }
        }
    }/* Comparações
    melhor caso = Sistematicamente, cada partição divide o arquivo em duas partes igual
    n * lg n
    pior caso = Sistematicamente, o pivô é menor ou o maior elemento do vetor, eliminando um elemento em cada chamada do algoritmo
    O(n²)
    movimentações
    no pior caso = dividido ao meio e os elementos maiores estão a esquerda e os menores a direita
    3 * n/2 movimentações
    */


    public static void main(String[] args) {
        int[] vetorDeInteiros = new int[10];    
        insercao(vetorDeInteiros);

        preencher(vetorDeInteiros);
        printaDesordenado(vetorDeInteiros);   
        quickSort(vetorDeInteiros, 0, vetorDeInteiros.length - 1);
        printaOrdenado(vetorDeInteiros);
        

    }
}