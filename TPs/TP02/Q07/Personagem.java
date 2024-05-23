
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Personagem { // Declaração dos atributos da classe
    private String id;
    private String name;
    private String alternate_name;
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

    // Gets e sets
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

    public String getAlternate_name() {
        return alternate_name;
    }

    public void setAlternate_name(String alternate_name) {
        this.alternate_name = alternate_name;
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

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public Boolean getWizard() {
        return wizard;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }

    // Clone
    public Personagem clone() {
        return (new Personagem(this.id, this.name, this.alternate_name, this.house, this.ancestry, this.species,
                this.patronus,
                this.hogwartsStaff, this.hogwartsStudent, this.actorName, this.alive, this.dateOfBirth,
                this.yearOfBirth, this.eyeColour,
                this.gender, this.hairColour, this.wizard));
    }

    // Mudar o formato do Date para xx/yy/zzzz
    public static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Primeiro construtor
    Personagem() {
    }

    // Segundo construtor
    Personagem(String id, String name, String alternate_name, String house, String ancestry, String species,
            String patronus, Boolean hogwartsStaff,
            Boolean hogwartsStudent, String actorName, Boolean alive, Date dateOfBirth, int yearOfBirth,
            String eyeColour, String gender, String hairColour, Boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternate_name = alternate_name;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;

    }

    // Main
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader arq = new BufferedReader(new FileReader("/tmp/characters.csv")); // Declaração do arquivo
        arq.readLine();

        List<Personagem> personagens = new ArrayList<>();
        String lerLinha;
        while ((lerLinha = arq.readLine()) != null) { // Leitura do arquivo
            String[] valor = lerLinha.split(";", -1);
            setValor(valor, personagens); // Setar o valor do personagem
        }
        arq.close();
        Personagem array[] = new Personagem[50]; // Declaração do array do tipo Personagem
        int i = 0; // Declaração do contador de elementos no array
        String entrada;
        do {
            entrada = sc.nextLine();
            if (!entrada.equals("FIM")) {
                array[i] = searchPersonagem(entrada, personagens); // Leitura do Personagem ate a entrada ser "FIM"
                i++;
            }
        } while (!entrada.equals("FIM"));

        insertionSort(array, i); // Chamada do Selection sort

        for (int j = 0; j < i; j++) {
            imprimir(array[j]); // Impressão do vetor ja ordenado
        }
        sc.close();
    }

    // Impressão de vetor
    public static void imprimir(Personagem array) {
        String novoAlternateName = "";
        if (array.alternate_name.length() > 4) {
            StringBuilder sb = new StringBuilder(array.alternate_name.substring(2, array.alternate_name.length() - 1)); // Remove
                                                                                                                        // o
                                                                                                                        // primeiro,
                                                                                                                        // penúltimo
                                                                                                                        // e
                                                                                                                        // último
                                                                                                                        // caracteres
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ',' && i > 0 && i < sb.length() - 2) {
                    sb.deleteCharAt(i - 1); // Remove o caractere anterior à vírgula
                    sb.deleteCharAt(i); // Remove a vírgula
                    sb.deleteCharAt(i); // Remove o caractere depois da vírgula
                    sb.insert(i, " ");
                }
            }
            novoAlternateName = sb.toString();
        }

        if (novoAlternateName.length() > 1) { // Atribuição do novoAlternateName após as mudanças
            novoAlternateName = novoAlternateName.substring(0, novoAlternateName.length() - 1);
        } else {
            novoAlternateName = "";
        }

        String resp = "[" + array.id + " ## " + array.name + " ## " + "{" + novoAlternateName + "} ## " + array.house
                + " ## " + array.ancestry + " ## " +
                array.species + " ## " + array.patronus + " ## " + array.hogwartsStaff + " ## " + array.hogwartsStudent
                + " ## " + array.actorName + " ## " + array.alive + " ## "
                + dateFormat.format(array.dateOfBirth) + " ## " + array.yearOfBirth + " ## " + array.eyeColour + " ## "
                + array.gender + " ## " + array.hairColour + " ## "
                + array.wizard + "]"; // Armazenar a resposta em uma string e depois Imprimi-la
        System.out.println(resp);
    }

    // Algoritimo de ordenação por seleção
    public static void insertionSort(Personagem[] array, int n) {
        for (int i = 1; i < n; i++) {
            Personagem tmp = array[i];
            int j = i - 1;
            while ((j >= 0) && (array[j].dateOfBirth.compareTo(tmp.dateOfBirth) > 0 ||
                    (array[j].dateOfBirth.compareTo(tmp.dateOfBirth) == 0 && array[j].name.compareTo(tmp.name) > 0))) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }

    // Procura de personagem e validação do mesmo
    public static Personagem searchPersonagem(String entrada, List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getId().equals(entrada)) {

                return personagem;
            }
        }
        System.out.println("Personagem não encontrado.");
        return null;
    }

    // Outra mudança de formato da data para xx/yy/zzzz
    public static Date changeDate(String data) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.parse(data);
    }

    // Setar o os valores de cada atributo no personagem
public static void setValor(String[] valor, List<Personagem> listaPersonagem) throws Exception {
    Personagem personagem = new Personagem();

    personagem.setId(valor[0]);
    personagem.setName(valor[1]);
    // Corrigindo a atribuição de alternate_name para lidar com a lista de nomes alternativos
    String[] alternateNames = valor[2].replaceAll("\\[|\\]", "").split(", ");
    StringBuilder alternateNameBuilder = new StringBuilder();
    for (String name : alternateNames) {
        alternateNameBuilder.append(name).append(", ");
    }
    String alternateName = alternateNameBuilder.toString();
    if (alternateName.length() > 0) {
        alternateName = alternateName.substring(0, alternateName.length() - 2); // Remover a última vírgula e espaço
    }
    personagem.setAlternate_name(alternateName);
    personagem.setHouse(valor[3]);
    personagem.setAncestry(valor[4]);
    personagem.setSpecies(valor[5]);
    personagem.setPatronus(valor[6]);
    personagem.setHogwartsStaff(Boolean.parseBoolean(valor[7]));
    personagem.setHogwartsStudent(Boolean.parseBoolean(valor[8]));
    personagem.setActorName(valor[9]);
    personagem.setAlive(Boolean.parseBoolean(valor[10]));
    personagem.setDateOfBirth(changeDate(valor[12]));
    personagem.setYearOfBirth(Integer.parseInt(valor[13]));
    personagem.setEyeColour(valor[14]);
    personagem.setGender(valor[15]);
    personagem.setHairColour(valor[16]);
    personagem.setWizard(Boolean.parseBoolean(valor[17]));

    listaPersonagem.add(personagem);    

    }
}