// bibliotecas
import java.util.*;
import java.io.*;
import java.text.*;

// classe Personagem
class Personagem {

    // Atributos
    private String id;
    private String name;
    private List <String> alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private String hogwartsStudent;
    private String actorName;
    private boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizard;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // construtor primario
    Personagem( ) {
        id = "";
        name = "";
        alternate_names = null;
        house = "";
        ancestry = "";
        species = "";
        patronus = "";
        hogwartsStaff = false;
        hogwartsStudent = "";
        actorName = "";
        alive = false;
        dateOfBirth = new Date( );
        yearOfBirth = 0;
        eyeColour = "";
        gender = "";
        hairColour = "";
        wizard = false;
    }

    // construtor secundario
    Personagem( String id ) {
        this.id = id;
        name = "";
        alternate_names = null;
        house = "";
        ancestry = "";
        species = "";
        patronus = "";
        hogwartsStaff = false;
        hogwartsStudent = "";
        actorName = "";
        alive = false;
        dateOfBirth = new Date( );
        yearOfBirth = 0;
        eyeColour = "";
        gender = "";
        hairColour = "";
        wizard = false;
    }

    /*
        Metodos Set e Get
        set -> definir valor ao atributo
        get -> retornar valor que o atributo contem
    */
    public void setId( String id ) {
        this.id = id;
    }

    public String getId( ) {
        return this.id;
    }
    
    public void setName( String name ) {
        this.name = name;
    }

    public String getName( ) {
        return this.name;
    }

    public void setAlternate_names( List <String> alternate_names ) {
        this.alternate_names = alternate_names;
    }

    public List <String> getAlternate_names( ) {
        return this.alternate_names;
    }

    public void setHouse( String house ) {
        this.house = house;
    }

    public String getHouse( ) {
        return this.house;
    }

    public void setAncestry( String ancestry ) {
        this.ancestry = ancestry;
    }

    public String getAncestry( ) {
        return this.ancestry;
    }

    public void setSpecies( String species ) {
        this.species = species;
    }

    public String getSpecies( ) {
        return this.species;
    }

    public void setPatronus( String patronus ) {
        this.patronus = patronus;
    }

    public String getPatronus( ) {
        return this.patronus;
    }

    public void setHogwartsStaff( boolean hogwartsStaff ) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public boolean getHogwartsStaff( ) {
        return this.hogwartsStaff;
    }

    public void setHogwartsStudent( String hogwartsStudent ) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public String getHogwartsStudent( ) {
        return this.hogwartsStudent;
    }
    
    public void setActorName( String actorName ) {
        this.actorName = actorName;
    }

    public String getActorName( ) {
        return this.actorName;
    }

    public void setAlive( boolean alive ) {
        this.alive = alive;
    }

    public boolean getAlive( ) {
        return this.alive;
    }

    public void setDateOfBirth( Date dateOfBirth ) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth( ) {
        return this.dateOfBirth;
    }

    public void setYearOfBirth( int yearOfBirth ) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth( ) {
        return this.yearOfBirth;
    }

    public void setEyeColour( String eyeColour ) {
        this.eyeColour = eyeColour;
    }

    public String getEyeColour( ) {
        return this.eyeColour;
    }

    public void setGender( String gender ) {
        this.gender = gender;
    }

    public String getGender( ) {
        return this.gender;
    }

    public void setHairColour( String hairColour ) {
        this.hairColour = hairColour;
    }

    public String getHairColour( ) {
        return this.hairColour;
    }

    public void setWizard( boolean wizard ) {
        this.wizard = wizard;
    }

    public boolean getWizard( ) {
        return this.wizard;
    }
    
    /*
        imprimir( ) - Funcao para mostrar na tela os atributos da classe
    */
    public void imprimir( ) {
        String alternateNamesString = "";
        if ( alternate_names != null ) {
            alternateNamesString = alternate_names.toString()
                                        .replace("'", "")
                                        .replace("[[", "{")
                                        .replace("]]", "}")
                                        .replace("  ", " ");
        }

        // mostrar na tela
        System.out.print( id + " ## " + name + " ## " + alternateNamesString + " ## " + house + " ## " + ancestry
        + " ## " + species + " ## " + patronus + " ## " + hogwartsStaff + " ## " + hogwartsStudent + " ## "
        + actorName + " ## " + alive + " ## " + dateFormat.format(dateOfBirth) + " ## " + yearOfBirth + " ## " + eyeColour + " ## "
        + gender + " ## " + hairColour + " ## " + wizard );
    }

    /*
        clone( ) - copiar atributos de uma variavel para outra
        @return - retorna uma variavel do tipo da classe para atribuir seus valores em uma variavel que deve ser igual a outra
    */
    public Personagem clone( ) {
        // definir dados
        Personagem clone = new Personagem( );

        // atribuir valores
        clone.setId(this.getId());
        clone.setName(this.getName());
        clone.setAlternate_names(this.getAlternate_names());
        clone.setHouse(this.getHouse());
        clone.setAncestry(this.getAncestry());
        clone.setSpecies(this.getSpecies());
        clone.setPatronus(this.getPatronus());
        clone.setHogwartsStaff(this.getHogwartsStaff());
        clone.setHogwartsStudent(this.getHogwartsStudent());
        clone.setActorName(this.getActorName());
        clone.setAlive(this.getAlive());
        clone.setDateOfBirth(this.getDateOfBirth());
        clone.setYearOfBirth(this.getYearOfBirth());
        clone.setEyeColour(this.getEyeColour());
        clone.setGender(this.getGender());
        clone.setHairColour(this.getHairColour());
        clone.setWizard(this.getWizard());

        // retornar valor
        return clone;
    }

    /*
        leitor( ) - funcao para ler base de dados e armazenar nos atriibutos da classe
    */
    public void leitor( String s ) throws ParseException {
        // definir dados
        String[] array = s.split(";");
        String mago;
        String vivo;
        String equipe;
        String estudante;

        // armazenar valores nos atributos
        id = array[0];
        name = array[1];
        alternate_names = Arrays.asList(array[2].split(",")); 
        house = array[3];
        ancestry = array[4];
        species = array[5];
        patronus = array[6];

        equipe = array[7];
        if(equipe.equals("VERDADEIRO")) {
            hogwartsStaff = true;
        } else {
            hogwartsStaff = false;
        }

        estudante = array[8];
        if(estudante.equals("VERDADEIRO")) {
            hogwartsStudent = "true";
        } else {
            hogwartsStudent = "false";
        }

        actorName = array[9];

        vivo = array[10];
        if(vivo.equals("VERDADEIRO")) {
            alive = true;
        } else {
            alive = false;
        }

        dateOfBirth = dateFormat.parse(array[12]);
        yearOfBirth = Integer.parseInt(array[13]);
        eyeColour = array[14];
        gender = array[15];
        hairColour = array[16];

        mago = array[17];

        if(mago.equals("VERDADEIRO")) {
            wizard = true;
        } else {
            wizard = false;
        }

    }
}

class Celula {

    public Personagem elemento;
    public Celula prox;

    public Celula() {
        this(null);
    }

    public Celula(Personagem x) {
        this.elemento = x;
        this.prox = null;
    }

}

class Lista {

    private Celula primeiro, ultimo;

    public Lista() {

        ultimo = primeiro = new Celula();
    
    }

    public int tamanho() {
        int resp = 0;
        for(Celula i = primeiro.prox; i != null; i = i.prox) {
            resp = resp + 1;
        }
        return resp;
    }

    public void inserir_Inicio(Personagem x) {

        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
    
    }

    public void inserir_Fim(Personagem x) {

        Celula tmp = new Celula(x);
        ultimo.prox = tmp;
        ultimo = ultimo.prox;

    }

    public void inserir(Personagem x, int pos) throws Exception { 
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            
            throw new Exception("Erro!");
        
        } else if (pos == 0) {
            
            inserir_Inicio(x);

        } else if (pos == tamanho) {
            
            inserir_Fim(x);

        } else {

            Celula i = primeiro;

            for(int j = 0; j < pos; j++, i = i.prox);

            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;

        } 

    }

    public Personagem remover_Inicio() throws Exception {

        if(primeiro == ultimo) {
            throw new Exception("Erro ao remover: lista vazia!");
        }

        Celula tmp = primeiro.prox;
        primeiro.prox = primeiro.prox.prox;
        Personagem resp = tmp.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;

    }

    public Personagem remover_Fim() throws Exception {

        if(primeiro == ultimo) {
            throw new Exception("Erro ao remover: lista vazia!");
        }

        Celula i;

        for(i = primeiro; i.prox != ultimo; i = i.prox);

        Personagem resp = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;
        return resp;

    } 

    public Personagem remover(int pos ) throws Exception {
        int tamanho = tamanho();
        Personagem resp;

        if (primeiro == ultimo || pos < 0 || pos >= tamanho) { 
            
            throw new Exception("Erro!");
        
        } else if (pos == 0) {
            
            resp = remover_Inicio();
        
        } else if (pos == tamanho - 1) { 
            
            resp = remover_Fim();
        
        } else {

            Celula i = primeiro;
            
            for(int j = 0; j < pos; j++, i = i.prox);
            
            Celula tmp = i.prox;
            resp = tmp.elemento; i.prox = tmp.prox;
            tmp.prox = null; i = tmp = null;

        }
       
        return resp;
    }


    public void mostrar() {

        int contador = 0;

        for(Celula i = primeiro.prox; i != null; i = i.prox) {

            System.out.print("[" + contador + " ## ");
            i.elemento.imprimir();
            System.out.println("]");
            contador = contador + 1;
            
        }

    }

}

class Q05 {
    public static void main( String args[] ) throws Exception {
        RandomAccessFile raf = new RandomAccessFile( "/tmp/characters.csv", "r" );
        String str = raf.readLine();
        Personagem[] personagens = new Personagem[500];
        for (int i = 0; i < personagens.length; i++) {
            personagens[i] = new Personagem();
        }

        int t = 0;
        String entrada;
        Scanner sc = new Scanner(System.in);

        while(!EOF(raf)) {
            str = raf.readLine();

            personagens[t].leitor( str );

            t = t + 1;
        }

        Lista lista = new Lista();
        Personagem[] removidos = new Personagem[10];
        int m = 0;

        do {
            entrada = sc.nextLine();

            if( !entrada.equals("FIM") ) {

                for( int i = 0; i < personagens.length; i = i + 1 ) {

                    if( personagens[i].getId().equals( entrada ) ) {

                        lista.inserir_Fim(personagens[i]);

                    }
                }

            }

        } while( !entrada.equals("FIM") );

        int qtdOperacoes = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < qtdOperacoes; i++) {

            entrada = sc.nextLine();
            String[] aux = entrada.split(" ");
            String operacaoPrincipal = aux[0];

            if(operacaoPrincipal.charAt(0) == 'I' && operacaoPrincipal.charAt(1) == 'I') {
                
                String id_Operacao1 = aux[1];
                for( int j = 0; j < personagens.length; j = j + 1 ) {

                    if( personagens[j].getId().equals( id_Operacao1 ) ) {

                        lista.inserir_Inicio(personagens[j]);

                    }
                }
                
            } else if(operacaoPrincipal.charAt(0) == 'I' && operacaoPrincipal.charAt(1) == 'F') {

                String id_Operacao2 = aux[1];
                for( int j = 0; j < personagens.length; j = j + 1 ) {

                    if( personagens[j].getId().equals( id_Operacao2 ) ) {

                        lista.inserir_Fim(personagens[j]);

                    }
                }


            } else if(operacaoPrincipal.charAt(0) == 'R' && operacaoPrincipal.charAt(1) == 'I') {
                
                removidos[m] = lista.remover_Inicio();
                m = m + 1;

            } else if(operacaoPrincipal.charAt(0) == 'R' && operacaoPrincipal.charAt(1) == 'F') {

                removidos[m] = lista.remover_Fim();
                m = m + 1;

            } else if(operacaoPrincipal.charAt(0) == 'I' && operacaoPrincipal.charAt(1) == '*') {

                String posicao1 = aux[1];
                int pos1 = Integer.parseInt(posicao1);
                String id_Operacao3 = aux[2];

                for( int j = 0; j < personagens.length; j = j + 1 ) {

                    if( personagens[j].getId().equals( id_Operacao3 ) ) {

                        lista.inserir(personagens[j], pos1);

                    }
                }

            } else if(operacaoPrincipal.charAt(0) == 'R' && operacaoPrincipal.charAt(1) == '*') {

                String posicao2 = aux[1];
                int pos2 = Integer.parseInt(posicao2);
                removidos[m] = lista.remover(pos2);
                m = m + 1;

            }

        }

        for(int i = 0; i < 10; i++) {

            System.out.println("(R) " + removidos[i].getName());

        }

        lista.mostrar();

        sc.close();

    }

    public static boolean EOF( RandomAccessFile raf ) throws Exception {
        return( raf.getFilePointer() == raf.length() );
    }
}