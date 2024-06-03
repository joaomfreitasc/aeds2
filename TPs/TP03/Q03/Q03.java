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

class Pilha {
    public Personagem[] array;
    private int n;

    public Pilha() {
        this(100);
    }

    public Pilha(int tamanho) {
        array = new Personagem[tamanho];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Personagem();
        }
        n = 0;
    }

    public void inserir(Personagem x) throws Exception {
        if(n == array.length) {
            throw new Exception("Erro ao inserir!");
        }
        for(int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = x;
        n = n + 1;   
    }

    public Personagem remover() throws Exception {
        if(n == 0) {
            throw new Exception("Erro ao remover");
        }

        Personagem resp = array[0];
        n = n - 1;

        for (int i = 0; i < n; i++){
            array[i] = array[i+1];
        }

        return resp;
    }

    public void mostrar() {

        System.out.println("[ top ]");

        for(int i = 0; i < n; i++) {
            System.out.print("[" + i + " ## ");
            array[i].imprimir();
            System.out.println("]");
        }

        System.out.println("[ bottom ]");

    }
}

class Q03 {
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

        Pilha pilha = new Pilha();
        Personagem[] removidos = new Personagem[10];
        int m = 0;

        do {
            entrada = sc.nextLine();

            if( !entrada.equals("FIM") ) {

                for( int i = 0; i < personagens.length; i = i + 1 ) {

                    if( personagens[i].getId().equals( entrada ) ) {

                        pilha.inserir(personagens[i]);

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

            if(operacaoPrincipal.charAt(0) == 'I') {

                String id_Operacao = aux[1];

                for( int j = 0; j < personagens.length; j = j + 1 ) {

                    if( personagens[j].getId().equals( id_Operacao ) ) {
                        
                        pilha.inserir(personagens[j]);

                    }

                } 
            } else if(operacaoPrincipal.charAt(0) == 'R') {

                removidos[m] = pilha.remover();
                m = m + 1;

            } 
        }

        for(int i = 0; i < 10; i++) {
            System.out.println("(R) " + removidos[i].getName());
        }

        pilha.mostrar();

        sc.close();

    }

    public static boolean EOF( RandomAccessFile raf ) throws Exception {
        return( raf.getFilePointer() == raf.length() );
    }
}