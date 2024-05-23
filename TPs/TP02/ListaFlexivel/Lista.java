package ListaFlexivel;

public class Lista {

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

    public static class ListaFlexivel {
        private Celula primeiro, ultimo;

        public ListaFlexivel() {
            primeiro = new Celula();
            ultimo = primeiro;
        }// fim construtor

        public void inserirInicioLista(int x) {
            Celula tmp = new Celula(x);
            tmp.prox = primeiro.prox;
            primeiro.prox = tmp;
            if (primeiro == ultimo) {
                ultimo = tmp;
            }
            tmp = null;
        }// fim inserirInicioLista

        public void inserirFimLista(int x) {
            ultimo.prox = new Celula(x); // igual ao da fila
            ultimo = ultimo.prox;
        }// fim inserirFimLista

        public int removerInicioLista() throws Exception {
            if (primeiro == ultimo)
                throw new Exception("error!");
            Celula tmp = primeiro.prox;
            primeiro.prox = primeiro.prox.prox; // igual ao da fila
            int elemento = tmp.elemento;
            tmp.prox = null;
            tmp = null;
            return elemento;
        }// fim removerInicioLista

        public int removerFimLista() throws Exception {
            if (primeiro == ultimo)
                throw new Exception("Erro: Lista vazia!"); // Lança uma exceção se a lista estiver vazia
            Celula i;
            for (i = primeiro; i.prox != ultimo; i = i.prox)
                ; // Encontra o penúltimo nó da lista
            int elemento = ultimo.elemento; // Guarda o elemento do último nó
            ultimo = i; // Atualiza o último nó para o penúltimo nó
            i = ultimo.prox = null; // Remove a referência para o último nó
            return elemento; // Retorna o elemento removido
        }// fim removerFimLista

        public int tamanho() {
            int tamanho = 0;
            for (Celula i = primeiro; i != ultimo; i = i.prox) {
                tamanho++;
            }
            return tamanho;
        }// fim tamanho

        public void inserirLista(int x, int pos) throws Exception {
            int tamanho = tamanho();
            if (pos < 0 || pos > tamanho) {
                throw new Exception("Erro!");
            } else if (pos == 0) {
                inserirInicioLista(x);
            } else if (pos == tamanho) {
                inserirFimLista(x);
            } else {
                Celula i = primeiro;
                for (int j = 0; j < pos; j++, i = i.prox)
                    ;
                Celula tmp = new Celula(x);
                tmp.prox = i.prox;
                i.prox = tmp;
                tmp = i = null;
            }
        }// fim inserirLista

        public int removerLista(int pos) throws Exception {
            int elemento, tamanho = tamanho();
            if (primeiro == ultimo || pos < 0 || pos >= tamanho) {
                throw new Exception("Erro!");
            } else if (pos == 0) {
                elemento = removerInicioLista();
            } else if (pos == tamanho - 1) {
                elemento = removerFimLista();
            } else {
                Celula i = primeiro;
                for (int j = 0; j < pos; j++, i = i.prox)
                    ;
                Celula tmp = i.prox;
                elemento = tmp.elemento;
                i.prox = tmp.prox;
                tmp.prox = null;
                i = tmp = null;
            }
            return elemento;
        }// fim removerLista

        public void inverteLista() {
            Celula i = primeiro.prox;
            Celula j = ultimo;
            Celula k;
            while (i != j && j.prox != i) {
                int tmp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = tmp;
                i = i.prox;
                for (k = primeiro; k.prox != j; k = k.prox)
                    ;
                j = k;
            }
        }// fim inverteLista

        public void mostrarLista() {
            System.out.print("[ ");
            for (Celula i = primeiro.prox; i != null; i = i.prox) { // igual ao da pilha/fila
                System.out.print(i.elemento + " ");
            }
            System.out.print("] ");
        }// fim mostrarLista
    }// fim lista

    public static void main(String[] args) throws Exception {

        ListaFlexivel lista = new ListaFlexivel();
        System.out.println("Lista Simples");
        lista.inserirInicioLista(1);
        lista.inserirInicioLista(2);
        lista.inserirInicioLista(3);
        lista.inserirLista(50, 2);
        lista.mostrarLista();

    }// fim main
} // fim classe Flexivel
