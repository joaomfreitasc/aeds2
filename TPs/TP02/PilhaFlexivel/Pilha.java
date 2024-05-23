package PilhaFlexivel;

public class Pilha {

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

    public static class PilhaFlexivel {
        private Celula topo;

        public PilhaFlexivel() {
            topo = null;
        }// fim construtor

        public void inserirPilha(int x) {
            Celula tmp = new Celula(x);
            tmp.prox = topo;
            topo = tmp;
            tmp = null;
        }// fim inserirPilha

        public int removerPilha() throws Exception {
            if (topo == null)
                throw new Exception("Erro!");
            int elemento = topo.elemento;
            Celula tmp = topo;
            topo = topo.prox;
            tmp.prox = null;
            return elemento;
        }// fim removerPilha

        public void mostrarPilha() {
            System.out.print("[ ");
            for (Celula i = topo; i != null; i = i.prox) {
                System.out.print(i.elemento + " ");
            }
            System.out.println("]");
        }// fim mostrarPilha

        public int somaPilha() {
            int resp = 0;
            for (Celula i = topo; i != null; i = i.prox) {
                resp += i.elemento;
            }
            return resp;
        }// fim somaPilha

        public int somaPilhaRecursiva(Celula celula) {
            if (celula != null) {
                return celula.elemento + somaPilhaRecursiva(celula.prox);
            }
            return 0;
        }// fim somaPilhaRecursiva
    }// fim pilha

    public static void main(String[] args) throws Exception {

        PilhaFlexivel pilha = new PilhaFlexivel();
        System.out.println("Pilha");
        pilha.inserirPilha(1);
        pilha.inserirPilha(2);
        pilha.inserirPilha(3);
        System.out.println("elemento " + pilha.removerPilha() + " removido");
        pilha.mostrarPilha();
        System.out.println("Soma: " + pilha.somaPilha());
        System.out.println("SomaRecursiva: " + pilha.somaPilhaRecursiva(pilha.topo));
        System.out.println();

    }// fim main

} // fim classe Flexivel