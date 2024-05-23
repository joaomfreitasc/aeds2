import java.io.RandomAccessFile;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

public class Sequencial {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        final String nomeArquivo = "/tmp/characters.csv";
        RandomAccessFile arq = new RandomAccessFile(nomeArquivo, "r");
        long tamArquivo = arq.length();
        arq.readLine();// Leitura do cabeçalho

        List<Personagem> personagens = new ArrayList<>();

        lerArquivo(arq, personagens, tamArquivo);

        String idLido;
        List<Personagem> personagensPUBIN = new ArrayList<>();

        while (!(idLido = sc.nextLine()).equals("FIM")) {
            addPesonagem(personagensPUBIN, idLido, personagens);
        }
        personagensPUBIN.sort(Comparator.comparing(Personagem::getName));
        personagensPUBIN.sort(Comparator.comparing(Personagem::getActorName));
        personagensPUBIN.forEach(Personagem::imprimir);
        /*
         * String nomeLido;
         * while(!(nomeLido = sc.nextLine()).equals("FIM")){
         * System.out.println(checkNome(nomeLido,nomePersonagem)?"SIM":"NAO");
         * }
         */
    }

    public static void addPesonagem(List<Personagem> personagensPUBIN, String idLido, List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getId().equals(idLido)) {
                personagensPUBIN.add(personagem);
            }
        }
    }

    public static void lerArquivo(RandomAccessFile arq, List<Personagem> personagens, long tamArquivo)
            throws Exception {
        while (arq.getFilePointer() < tamArquivo) {
            String lerLinha = arq.readLine();
            String[] atributos = lerLinha.split(";", -1);
            atribuicao(atributos, personagens);
        }
    }

    // @org.jetbrains.annotations.Contract(pure = true)
    public static boolean checkNome(String nome, List<String> nomePersonagem) {
        for (String nomes : nomePersonagem) {
            if (nomes.equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public static String procurarNomePersonagem(String idLido, List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getId().equals(idLido)) {
                return personagem.getName();
            }
        }
        return null;
    }

    public static void atribuicao(String[] atributos, List<Personagem> listaPersonagem) throws Exception {

        Personagem personagem = new Personagem();

        personagem.setId(atributos[0]);
        personagem.setName(atributos[1]);

        // atributos[2].replace("[", "").replace("]", "").replace("'", "").replace(" ",
        // "");
        // List<String> aux = Arrays.asList(atributos[2].split(","));
        // var aux2 = new ArrayList<String>();
        // aux.forEach((a)-> aux2.add(a));
        // personagem.setAlternate_names(aux2);

        personagem.setAlternate_names(Arrays.asList(atributos[2].split(",")));

        personagem.setHouse(atributos[3]);
        personagem.setAncestry(atributos[4]);
        personagem.setSpecies(atributos[5]);
        personagem.setPatronus(atributos[6]);
        personagem.setHogwartsStaff(checkBool(atributos[7]));
        personagem.setHogwartsStudent(checkBool(atributos[8]));
        personagem.setActorName(atributos[9]);
        personagem.setAlive(checkBool(atributos[10]));
        personagem.setDateOfBirth(tratarDate(atributos[12]));
        personagem.setYearOfBirth(Integer.parseInt(atributos[13]));
        personagem.setEyeColour(atributos[14]);
        personagem.setGender(atributos[15]);
        personagem.sethairColour(atributos[16]);
        personagem.setWizard(checkBool(atributos[17]));

        listaPersonagem.add(personagem);
    }

    public static boolean checkBool(String string) {
        if (string.equals("FALSO")) {
            return false;
        }
        return true;
    }

    public static Date tratarDate(String data) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formato.parse(data);
        return date;
    }

}

class Personagem {

    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private Boolean hogwartsStaff;
    private Boolean hogwartsStudent;
    private String actorName;
    private Boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    Personagem() {
        id = "";
        name = "";
        alternate_names = new ArrayList<>();
        house = "";
        ancestry = "";
        species = "";
        patronus = "";
        hogwartsStaff = false;
        hogwartsStudent = false;
        actorName = "";
        alive = false;
        dateOfBirth = new Date();
        ;
        yearOfBirth = 0;
        eyeColour = "";
        gender = "";
        hairColour = "";
        wizard = false;

    }

    Personagem(String id) {
        id = "";
        name = "";
        alternate_names = new ArrayList<>();
        house = "";
        ancestry = "";
        species = "";
        patronus = "";
        hogwartsStaff = false;
        hogwartsStudent = false;
        actorName = "";
        alive = false;
        dateOfBirth = new Date();
        ;
        yearOfBirth = 0;
        eyeColour = "";
        gender = "";
        hairColour = "";
        wizard = false;

    }

    public Personagem clone() {
        return (new Personagem());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(List<String> alternate_names) {
        this.alternate_names = alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String gethairColour() {
        return hairColour;
    }

    public void sethairColour(String ghairColour) {
        this.hairColour = ghairColour;
    }

    public Boolean getWizard() {
        return wizard;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }

    public void imprimirAlternate() {
        System.out.print("{");
        boolean isFirst = true;
        for (String nome : alternate_names) {
            if (!isFirst) {
                System.out.print(",");
            }
            isFirst = false;
            System.out.print(nome.replace("[", "").replace("]", "").replace("'", ""));
        }
        System.out.print("}");
    }

    public void imprimir() {
        System.out.print("[" + id + " ## " + name + " ## ");
        imprimirAlternate();
        System.out.print(" ## " + house + " ## " + ancestry
                + " ## " + species + " ## " + patronus + " ## " + hogwartsStaff + " ## " + hogwartsStudent + " ## "
                + actorName + " ## " + alive + " ## " + dateFormat.format(dateOfBirth) + " ## " + yearOfBirth + " ## "
                + eyeColour + " ## " + gender + " ## " + hairColour + " ## " + wizard + "]\n");
    }

}
