package FilaFlexivel;

public class Fila {

    public static class Celula {
        public int elemento;
        public Celula prox;

        public Celula() {
            this(0);
        }// fim Celula sem atributo

        public Celula(int x) {
            this.elemento = x; // celula simples
            this.prox = null;
        }// fim Celula com atributo
    }// fim Celula simples

    public static class FilaFlexivel {
        private Celula primeiro, ultimo;

        public FilaFlexivel() {
            primeiro = new Celula();
            ultimo = primeiro;
        }// fim construtor

        public void inserirFila(int x) { // Inserir(3)
            ultimo.prox = new Celula(x);
            ultimo = ultimo.prox;
        }// fim inserirFila

        /*
         * public int removerFila() throws Exception{ //remove fisicamente o nó cabeça e
         * faz com que a primeira célula seja o nó cabeça
         * if (primeiro == ultimo) // confere se tem elemento na fila
         * throw new Exception("Erro!"); //passa um erro se a fila entiver vazia
         * Celula tmp = primeiro; //o variavel tmp é igual ao nó cabeça
         * primeiro = primeiro.prox; //a segunda Celula da fila vira a primeira
         * int elemento = primeiro.elemento; //pega o elemento
         * tmp.prox = null;
         * tmp = null;
         * return elemento;
         * }
         */

        public int removerFila() throws Exception { // nao remove fisicamente o nó cabeça e sim o primeiro elemento que
                                                    // contem um numero que contem um numero
            if (primeiro == ultimo) // confere se tem elemento na fila
                throw new Exception("error!"); // passa um erro se a fila entiver vazia
            Celula tmp = primeiro.prox; // a primeira Celula depois do nó cabeça recebe a varivel tmp
            primeiro.prox = primeiro.prox.prox; // a primeira celula (o nó cabeça) vai parar de apontar pra segunda
                                                // celula e apontar para a terceira celula
            int elemento = tmp.elemento; // vai pegar o primeiro elemento da fila (depois do nó cabeça, porque o nó
                                         // cabeça não possui um elemento)
            tmp.prox = null; // a primeira celula da lista que possui um elemento agr n aponta para null
            tmp = null;
            return elemento; // retorna o elemento
        }// fim removerFila

        public void mostrarFila() {
            System.out.print("[ ");
            for (Celula i = primeiro.prox; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.print("] ");
        }// fim mostrarFila

        public void maiorElementoFila() throws Exception {
            if (primeiro == ultimo)
                throw new Exception("Fila vazia!"); // Lança uma exceção se a fila estiver vazia
            int maiorElemento = primeiro.prox.elemento;
            for (Celula i = primeiro.prox.prox; i != null; i = i.prox) {
                if (i.elemento > maiorElemento) {
                    maiorElemento = i.elemento;
                }
            }
            System.out.println("Maior elemento da fila: " + maiorElemento);
        }// fim maiorElementoFila

        public void retornarTerceiroElementoFila() {
            if (primeiro.prox != null && primeiro.prox.prox != null && primeiro.prox.prox.prox != null) {
                System.out.println(primeiro.prox.prox.prox.elemento);
            } else {
                System.out.println("Não há terceiro elemento na fila.");
            }
        }// fim retornarTerceiroElementoFila

    }// fim fila

    public static void main(String[] args) throws Exception {

        FilaFlexivel fila = new FilaFlexivel();
        System.out.println("Fila");
        fila.inserirFila(1);
        fila.inserirFila(2);
        fila.inserirFila(3);
        fila.removerFila();
        fila.mostrarFila();
        System.out.println();
        
    }// fim main
} // fim classe Flexivel

