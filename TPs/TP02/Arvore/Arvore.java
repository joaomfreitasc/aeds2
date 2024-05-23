package Arvore;

public class Arvore {
    public static class No {

        int elemento;
        No esq;
        No dir;

        No(int elemento) {
            this(elemento, null, null);
        }

        No(int elemento, No esq, No dir) {
            this.elemento = elemento;
            this.esq = esq;
            this.dir = dir;

        }
    }// fim classe no

    public static class ArvoreBinaria {
        No raiz;

        ArvoreBinaria() {
            raiz = null;
        }// fim construtor

        void inserir(int x) throws Exception {
            raiz = inserir(x, raiz);
        }

        No inserir(int x, No i) throws Exception {
            if (i == null) {
                i = new No(x);
            } else if (x < i.elemento) {
                i.esq = inserir(x, i.esq);
            } else if (x > i.elemento) {
                i.dir = inserir(x, i.dir);
            } else {
                throw new Exception("Erro!");
            }
            return i;
        }

        void inserirPai(int x) throws Exception {
            if (raiz == null) {
                raiz = new No(x);
            } else if (x < raiz.elemento) {
                inserirPai(x, raiz.esq, raiz);
            } else if (x > raiz.elemento) {
                inserirPai(x, raiz.dir, raiz);
            } else {
                throw new Exception("Erro!");
            }
        }// fim

        void inserirPai(int x, No i, No pai) throws Exception {
            if (i == null) {
                if (x < pai.elemento) {
                    pai.esq = new No(x);
                } else {
                    pai.dir = new No(x);
                }
            } else if (x < i.elemento) {
                inserirPai(x, i.esq, i);
            } else if (x > i.elemento) {
                inserirPai(x, i.dir, i);
            } else {
                throw new Exception("Erro!");
            }
        }// fim inserir Pai

        void caminharCentral(No i) {
            if (i != null) {
                caminharCentral(i.esq);
                System.out.print(i.elemento + " ");
                caminharCentral(i.dir);
            }
        }

        void caminharPos(No i) {
            if (i != null) {
                caminharPos(i.esq);
                caminharPos(i.dir);
                System.out.print(i.elemento + " ");
            }
        }

        void caminharPre(No i) {
            if (i != null) {
                System.out.print(i.elemento + " ");
                caminharPre(i.esq);
                caminharPre(i.dir);
            }
        }

    }// fim arvore binaria

    public static void main(String[] args) throws Exception {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(5);
        arvore.inserir(6);
        arvore.inserir(2);
        

    }

}// fim classe Arvore
