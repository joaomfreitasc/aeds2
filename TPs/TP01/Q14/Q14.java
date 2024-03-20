
public class Q14 {
    public static int qtd_Linhas = 200;

    public static boolean Bool(String str){
        boolean resposta = false;
        int qtValor = (int) str.charAt(0) - 48;
        String troca = "";
        String valores = "";
        // System.out.println(qtValor);
        int inicio = 2 * qtValor + 2;

        for (int i = 2; i < inicio; i++) {
            if (str.charAt(i) != ' ')
                valores += str.charAt(i);
        }

        // mudando os A B C pelos valores recebidos
        for (int i = inicio; i < str.length(); i++) {
            if (str.charAt(i) == 'A' || str.charAt(i) == 'B' || str.charAt(i) == 'C') {
                if (str.charAt(i) == 'A')
                    troca += valores.charAt(0);
                else if (str.charAt(i) == 'B')
                    troca += valores.charAt(1);
                else if (str.charAt(i) == 'C')
                    troca += valores.charAt(2);
            } else
                troca += str.charAt(i);
        }

        String test = "";

        for (int i = 0; i < troca.length(); i++) {
            if (troca.contains("),")) {
                if (troca.charAt(i) == ',' && troca.charAt(i - 1) == ')') {
                    test += " ,";
                } else
                    test += troca.charAt(i);
            } else
                test += troca.charAt(i);
        }

        troca = "";
        troca += test;
        int tam = troca.length();
        return Bool(troca, tam);
    }

    public static boolean Bool(String troca, int tam) {
        String not = "";
        String and = "";
        String or = "";
        boolean resposta;
        

        if(tam <= 2){
            if(troca.equals("1") || troca.equals("1 "))
                resposta = true;
            else    
                resposta = false;
        return resposta;
        }else{
            // operacao de negacao
            if (troca.contains("not")) {
                for (int i = 0; i < troca.length(); i++) {
                    if (troca.charAt(i) == 'n' && troca.charAt(i + 1) == 'o'
                            && (troca.charAt(i + 4) == '1' || troca.charAt(i + 4) == '0')) {
                        if (troca.charAt(i + 4) == '1') {
                            not += '0';
                            i += 5;
                        } else if (troca.charAt(i + 4) == '0') {
                            not += '1';
                            i += 5;
                        }
                    } else
                        not += troca.charAt(i);
                }
            } else {
                not += troca;
            }

            //System.out.println("trocaNot " + not);
            // operacao and
            if (not.contains("and")) {
                for (int i = 0; i < not.length(); i++) {
                    if (not.charAt(i) == 'a' && not.charAt(i + 1) == 'n'
                            && (not.charAt(i + 4) == '1' || not.charAt(i + 4) == '0')
                            && (not.charAt(i + 8) == '1' || not.charAt(i + 8) == '0')) {
                        if (i < not.length() - 10 && not.charAt(i + 10) == ','
                                && not.charAt(i + 9) == ' ') {
                            if (not.charAt(i + 4) == '0') {
                                and += "and(0 ";
                                i += 9;
                            } else if (not.charAt(i + 4) == '1') {
                                i += 8;
                                and += "and(" + not.charAt(i);
                            }
                        } else if (not.charAt(i + 9) == ')') {
                            if (not.charAt(i + 4) == '0') {
                                and += "0";
                                i += 9;
                            } else if (not.charAt(i + 4) == '1') {
                                i += 8;
                                and += not.charAt(i);
                                i++;
                            }
                        }
                    } else
                        and += not.charAt(i);
                }
            } else {
                and += not;
            }

            //System.out.println("trocaAnd " + and);

            // operacao or
            for (int i = 0; i < and.length(); i++) {
                if (and.charAt(i) == 'o' && and.charAt(i + 1) == 'r'
                        && (and.charAt(i + 3) == '1' || and.charAt(i + 3) == '0')
                        && (and.charAt(i + 7) == '1' || and.charAt(i + 7) == '0')) {
                    if (i < and.length() - 9 && and.charAt(i + 9) == ','
                            && and.charAt(i + 8) == ' ') {
                        //System.out.println("cheguei aqui aaa");
                        if (and.charAt(i + 3) == '1') {
                            or += "or(1 ";
                            i += 8;
                        } else if (and.charAt(i + 3) == '0') {
                            //System.out.println("cheguei aqui bbb");
                            i += 7;
                            or += "or(" + and.charAt(i) + " ";
                            i++;
                        }
                    } else if (and.charAt(i + 8) == ')') {
                        //System.out.println(or);
                        if (and.charAt(i + 3) == '1') {
                            or += "1";
                            i += 8;
                        } else if (and.charAt(i + 7) == '1') {
                            //System.out.println("cheguei aqui ccc");
                            i += 7;
                            or += '1';
                            i++;
                        }else{
                                i += 7;
                                or += '0';
                                i++;
                            }
                    }
                } else
                    or += and.charAt(i);
            }

            //System.out.println("trocaOr " + or);

            troca = "";
            not = "";
            and = "";
            troca += or;
            or = "";

            return Bool(troca, troca.length());
        }
        
    }

    public static void main(String[] args) {
        String[] entrada = new String[qtd_Linhas];
        int numEntrada = 0;
        entrada[numEntrada] = MyIO.readLine();
        while (entrada[numEntrada].charAt(0) != '0') {
            numEntrada++;
            entrada[numEntrada] = MyIO.readLine();
        }

        for (int i = 0; i < numEntrada; i++) {
            if (Bool(entrada[i]) == true)
                MyIO.println(1);
            else
                MyIO.println(0);
        }
    }
}