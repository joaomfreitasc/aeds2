
import java.io.File;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Personagem {
    private String id;
    private String name;
    private List<String> alternateNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private boolean hogwartsStudent;
    private String actorName;
    private boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizard;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Construtor
    public Personagem(String[] leitura) throws ParseException {
        this.id = leitura[0];
        this.name = leitura[1];
        leitura[2].replace("[", "").replace("]", "").replace("'", "").replace(" ", "");
        alternateNames = Arrays.asList(leitura[2].split(","));
        this.house = leitura[3];
        this.ancestry = leitura[4];
        this.species = leitura[5];
        this.patronus = leitura[6];
        this.hogwartsStaff = leitura[7].equals("VERDADEIRO") ? true : false;
        this.hogwartsStudent = leitura[8].equals("VERDADEIRO") ? true : false;
        this.actorName = leitura[9];
        this.alive = leitura[10].equals("VERDADEIRO") ? true : false;
        // O atributo alternateActors = leitura[11] foi desconsiderado
        this.dateOfBirth = dateFormat.parse(leitura[12]);
        this.yearOfBirth = Integer.parseInt(leitura[13]);
        this.eyeColour = leitura[14];
        this.gender = leitura[15];
        this.hairColour = leitura[16];
        this.wizard = leitura[17].equals("VERDADEIRO") ? true : false;
    }

    // Getters e Setters
    public String getId() {return id;}
    public void setId(String id) { this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<String> getAlternateNames() {return alternateNames;}
    public void setAlternateNames(List<String> alternateNames) {this.alternateNames = alternateNames;}
    public String getHouse() {return house;}
    public void setHouse(String house) {this.house = house;}
    public String getAncestry() {return ancestry;}
    public void setAncestry(String ancestry) { this.ancestry = ancestry;}
    public String getSpecies() {return species;}
    public void setSpecies(String species) { this.species = species;}
    public String getPatronus() {return patronus;}
    public void setPatronus(String patronus) {this.patronus = patronus;}
    public boolean isHogwartsStaff() { return hogwartsStaff;}
    public void setHogwartsStaff(boolean hogwartsStaff) {  this.hogwartsStaff = hogwartsStaff;}
    public boolean isHogwartsStudent() { return hogwartsStudent;}
    public void setHogwartsStudent(boolean hogwartsStudent) {this.hogwartsStudent = hogwartsStudent;}
    public String getActorName() {return actorName;}
    public void setActorName(String actorName) {this.actorName = actorName;}
    public boolean isAlive() { return alive;}
    public void setAlive(boolean alive) {this.alive = alive;}
    public Date getDateOfBirth() { return dateOfBirth;}
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth; }
    public int getYearOfBirth() {return yearOfBirth;}
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth;}
    public String getEyeColour() { return eyeColour;}
    public void setEyeColour(String eyeColour) {this.eyeColour = eyeColour; }
    public String getGender() {return gender;}
    public void setGender(String gender) { this.gender = gender;}
    public String getHairColour() {return hairColour; }
    public void setHairColour(String hairColour) {this.hairColour = hairColour;}
    public boolean isWizard() { return wizard;}
    public void setWizard(boolean wizard) {this.wizard = wizard;}

    // Implementação do método clone()
    @Override
    public Personagem clone() {
        try {
            Personagem cloned = (Personagem) super.clone();
            cloned.alternateNames = Arrays.asList(this.alternateNames.toArray(new String[0]));
            cloned.dateOfBirth = (Date) this.dateOfBirth.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            // Nunca será lançado, pois Personagem implementa Cloneable
            throw new AssertionError();
        }
    }

    // Leitura do arquivo csv armazenando os personagens em um ArrayList de
    // personagens
    static void readCSV(ArrayList<Personagem> listaPersonagens) {
        try {
        File arquivo = new File("/tmp/characters.csv");
            Scanner scan = new Scanner(arquivo);
            String[] leitura = scan.nextLine().split(";");
            while (scan.hasNextLine()) {
                leitura = scan.nextLine().split(";");
                listaPersonagens.add(new Personagem(leitura));
            }

            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Utilizando o método toString() podemos sobrecarregar o método e imprimir da
    // maneira como pede o enunciado
    @Override
    public String toString() {
        String frase = "[";
        frase += id + " ## ";
        frase += name + " ## {";
        for (int i = 0; i < alternateNames.size(); i++) {
            frase += alternateNames.get(i);
            if (i < alternateNames.size() - 1) {
                frase += "; ";
            }
        }
        frase += "} ## ";
        frase += house + " ## ";
        frase += ancestry + " ## ";
        frase += species + " ## ";
        frase += patronus + " ## ";
        frase += hogwartsStaff + " ## ";
        frase += hogwartsStudent + " ## ";
        frase += actorName + " ## ";
        frase += alive + " ## ";
        frase += dateFormat.format(dateOfBirth) + " ## ";
        frase += yearOfBirth + " ## ";
        frase += eyeColour + " ## ";
        frase += gender + " ## ";
        frase += hairColour + " ## ";
        frase += wizard + "]";
        return frase;
    }

    // O método pesquisaPorId faz uma pesquisa sequencial pelo id e retorna um
    // personagem ou null
    static Personagem pesquisaPorId(String idBusca, ArrayList<Personagem> listaPersonagens) {
        for (int i = 0; i < listaPersonagens.size(); i++) {
            if (listaPersonagens.get(i).id.equals(idBusca)) {
                return listaPersonagens.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Personagem> listaPersonagems = new ArrayList<>();
        readCSV(listaPersonagems);
        Scanner scan = new Scanner(System.in);
        String idBusca = scan.nextLine();
        while (!idBusca.equals("FIM")) {
            Personagem achou = pesquisaPorId(idBusca, listaPersonagems);
            System.out.println(achou);
            idBusca = scan.nextLine();
        }

        scan.close();
    }
}