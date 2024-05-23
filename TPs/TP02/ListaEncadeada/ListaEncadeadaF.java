package ListaEncadeada;

public class ListaEncadeadaF {

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

    public static class CelulaDupla {
        public int elemento;
        public CelulaDupla prox, ant;

        public CelulaDupla() { // celula dupla
            this(0);
        }// fim construtor sem atributo

        public CelulaDupla(int x) {
            this.elemento = x;
            this.prox = this.ant = null;
        }// fim construtor com atributo
    }// fim CelulaDupla

    public static class ListaEncadeada {
        private CelulaDupla primeiro, ultimo;

        public ListaEncadeada() {
            primeiro = new CelulaDupla();
            ultimo = primeiro;
        }// fim construtor ListaEncadeada

        public int tamanhoEncadeada() {
            int tamanho = 0;
            for (CelulaDupla i = primeiro; i != ultimo; i = i.prox) {
                tamanho++;
            }
            return tamanho;
        }// fim tamanho

        public void inserirInicioListaEncadeada(int x) {
            CelulaDupla tmp = new CelulaDupla(x); // crio uma celula dupla
            tmp.ant = primeiro; // a celula dupla tmp aponta o ant para o nó cabeça
            tmp.prox = primeiro.prox; // tmp aponta para a primeira celula que tem na lista ou para nada, caso a lista
                                      // esteja vazia
            primeiro.prox = tmp; // o nó cabeça apontam para a celula dupla tmp
            if (primeiro == ultimo) { // se a lista estiver vazia
                ultimo = tmp; // a celula q eu acabei de criar vira a ultima
            } else {
                tmp.prox.ant = tmp; // a celula que estava na primeira posição e esta indo para a segunda aponta o
                                    // ant para tmp
            }
            tmp = null;
        }// fim inserirInicioListaEncadeada

        public void inserirFimListaEncadeada(int x) {
            ultimo.prox = new CelulaDupla(x);// cria uma nova Celula dupla, e ultima vai ta apontada pra ela
            ultimo.prox.ant = ultimo; // a nova celula criada vai ta apontando o ant para a ultima
            ultimo = ultimo.prox; // a nova celula agr é a ultima celula
        }// fim inserirFimListaEncadeada

        public void inserirListaEncadeada(int x, int pos) throws Exception {
            int tamanho = tamanhoEncadeada();// pega o tamanho da lista
            if (pos < 0 || pos > tamanho) {// se o lugar q eu vou inserir for maior menor que 0 ou maior que o tamanho
                                           // da lista da erro
                throw new Exception("Posição menor que 0 ou maior que a lista");
            } else if (pos == 0) {// se o lugar q eu vou inserir for igual a 0 é mesma coisa de inserir no inicio
                inserirInicioListaEncadeada(x);// chama a função inserirInicioListaEncadeada
            } else if (pos == tamanho) {// se o lugar q eu vou inserir for igual ao tamanho da lista é mesma coisa de
                                        // inserir no final
                inserirFimListaEncadeada(x);// chamo o inserirFimListaEncadeada
            } else {
                CelulaDupla i = primeiro;
                for (int j = 0; j < pos; j++, i = i.prox)
                    ;// faz o for até o i ficar um casa antes onde vai colocar a Celula
                CelulaDupla tmp = new CelulaDupla(x);// cria a celula dupla
                tmp.ant = i;// tmp aponta o ant para i, que é uma celula antes
                tmp.prox = i.prox;// tmp aponta o prox para uma celula na frente do i
                tmp.ant.prox = tmp;// o prox do i apontar para a nova celula
                tmp.prox.ant = tmp;// a celula que estava na frente do i agr aponta o ant para a nova celula
                tmp = i = null;
            }
        }// fim do inserirListaEncadeada

        public int removerInicioListaEncadeada() throws Exception {
            if (primeiro == ultimo)
                throw new Exception("Erro!");
            CelulaDupla tmp = primeiro;
            primeiro = primeiro.prox;
            int elemento = primeiro.elemento;
            tmp.prox = primeiro.ant = null;
            tmp = null;
            return elemento;
        }// fim removerInicioListaEncadeada

        public int removerFimListaEncadeada() throws Exception {
            if (primeiro == ultimo)
                throw new Exception("Lista vazia");
            int elemento = ultimo.elemento;
            ultimo = ultimo.ant;
            ultimo.prox.ant = null;
            ultimo.prox = null;
            return elemento;
        }

        public int removerListaEncadeada(int pos) throws Exception {
            int elemento, tamanho = tamanhoEncadeada();
            if (primeiro == ultimo) {
                throw new Exception("Erro!");
            } else if (pos < 0 || pos >= tamanho) {
                throw new Exception("Erro!");
            } else if (pos == 0) {
                elemento = removerInicioListaEncadeada();
            } else if (pos == tamanho - 1) {
                elemento = removerFimListaEncadeada();
            } else {
                CelulaDupla i = primeiro.prox; // cria uma Celula i que recebe a primeira celula com elemento da lista a
                                               // primeiro.prox
                for (int j = 0; j < pos; j++, i = i.prox)
                    ;// faz um for até a celula q vai ser removida
                i.ant.prox = i.prox;// a celula anterior a celula i (q vai ser removida), aponta para a celula na
                                    // frente da i
                i.prox.ant = i.ant;// a celula na frente da i, aponta o ant para a celula atras da i
                elemento = i.elemento;// pega o elemento da i
                i.prox = i.ant = null;// i não aponta pra lugar nenhum
                i = null;
            }
            return elemento;// retorna o elemento da i
        }// fim removerListaEncadeada

        public void inverterElementosListaEncadeada() {
            CelulaDupla i = primeiro.prox;
            CelulaDupla j = ultimo;
            while (i != j && j.prox != i) {
                int tmp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = tmp;
                i = i.prox;
                j = j.ant;
            }
        }// fim inverterElementosListaEncadeada

        public void mostrarListaEncadeada() {
            System.out.print("[ ");
            for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) { // igual ao da pilha/fila
                System.out.print(i.elemento + " ");
            }
            System.out.print("] ");
        }// fim mostrarListaEncadeada

    }// fim Lista dupla

    public static void main(String[] args) throws Exception {

        
        ListaEncadeada ListaEncadeada = new ListaEncadeada();
        ListaEncadeada.inserirFimListaEncadeada(3);
        ListaEncadeada.inserirFimListaEncadeada(5);
        ListaEncadeada.inserirFimListaEncadeada(7);
        System.out.println(ListaEncadeada.removerInicioListaEncadeada());
        ListaEncadeada.removerListaEncadeada(1);
        ListaEncadeada.mostrarListaEncadeada();   

    }// fim main
} // fim classe Flexivel