import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Personagem {  //Declaração dos atributos da classe
    private String id;
    private String name;
    private String alternate_name;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private String hogwartsStaff;
    private String hogwartsStudent;
    private String actorName;
    private String alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private String wizard;

    //Gets e sets
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

    public String getHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(String hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public String getHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(String hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getAlive() {
        return alive;
    }

    public void setAlive(String alive) {
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

    public String getWizard() {
        return wizard;
    }

    public void setWizard(String wizard) {
        this.wizard = wizard;
    }

    //Clone
    public Personagem clone(){
        return(new Personagem(this.id, this.name, this.alternate_name, this.house,this.ancestry,this.species, this.patronus,
         this.hogwartsStaff, this.hogwartsStudent, this.actorName, this.alive, this.dateOfBirth, this.yearOfBirth, this.eyeColour,
          this.gender, this.hairColour, this.wizard ));
    }

    //Mudar o formato do Date para xx/yy/zzzz
    public static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //Primeiro construtor
    Personagem(){
    }
    //Segundo construtor
    Personagem(String id, String name, String alternate_name, String house, String ancestry, String species, String patronus, String hogwartsStaff, 
    String hogwartsStudent, String actorName, String alive, Date dateOfBirth, int yearOfBirth, String eyeColour, String gender, String hairColour, String wizard){
        this.id =id;
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
 
    //Main
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedReader arq = new BufferedReader(new FileReader("/tmp/characters.csv")); //Declaração do arquivo
        arq.readLine(); 
    
        List<Personagem> personagens = new ArrayList<>();
        String lerLinha;
        while ((lerLinha = arq.readLine()) != null) {   //Leitura do arquivo
            String[] valor = lerLinha.split(";", -1);
            setValor(valor, personagens);   //Setar o valor do personagem
        }
        arq.close();
        Personagem array[] = new Personagem[50];    //Declaração do array do tipo Personagem
        int i =0;   //Declaração do contador de elementos no array
        String entrada;
        do {
            entrada = sc.nextLine();
            if (!entrada.equals("FIM")) {
                array[i] = searchPersonagem(entrada, personagens);  //Leitura do Personagem ate a entrada ser "FIM"
                i++;
            }
        } while (!entrada.equals("FIM"));

        countingsort(array, i);    //Chamada do counting
        for (int j = 0; j < i; j++) {
            imprimir(array[j]); //Impressão do vetor ja ordenado
        }
        sc.close();
    }

    //Impressão de vetor
    public static void imprimir(Personagem array) {
        if (array == null) {
            return;
        }
        String novoAlternateName = "";
        if (array.alternate_name.length() > 4) {
            StringBuilder sb = new StringBuilder(array.alternate_name.substring(2, array.alternate_name.length() - 1)); // Remove o primeiro, penúltimo e último caracteres
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
    
        if (novoAlternateName.length() > 1) { //Atribuição do novoAlternateName após as mudanças
            novoAlternateName = novoAlternateName.substring(0, novoAlternateName.length() - 1);
        } else {
            novoAlternateName = ""; 
        }
        if(array.hogwartsStaff.equals("VERDADEIRO")){
            array.hogwartsStaff = "true";
        }else{
            array.hogwartsStaff = "false";
        }
        if(array.hogwartsStudent.equals("VERDADEIRO")){
            array.hogwartsStudent = "true";
        }else{
            array.hogwartsStudent = "false";
        }
        if(array.alive.equals("VERDADEIRO")){
            array.alive = "true";
        }else{
            array.alive = "false";
        }
        if(array.wizard.equals("VERDADEIRO")){
            array.wizard = "true";
        }else{
            array.wizard = "false";
        }

        String resp = "[" + array.id + " ## "+ array.name + " ## "+"{" + novoAlternateName + "} ## "+ array.house + " ## "+array.ancestry + " ## "+
        array.species + " ## "+array.patronus + " ## "+array.hogwartsStaff + " ## "+array.hogwartsStudent + " ## "+array.actorName + " ## "+array.alive + " ## "
        +dateFormat.format(array.dateOfBirth) + " ## "+ array.yearOfBirth + " ## "+ array.eyeColour + " ## "+array.gender + " ## "+array.hairColour + " ## "
        +array.wizard + "]";    //Armazenar a resposta em uma string e depois Imprimi-la
        System.out.println(resp);
    }
    public static void countingsort(Personagem[] array, int n) {
        // Encontrar o maior e o menor ano de nascimento
        int maxYearOfBirth = Integer.MIN_VALUE;
        int minYearOfBirth = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (array[i].yearOfBirth > maxYearOfBirth) {
                maxYearOfBirth = array[i].yearOfBirth;
            }
            if (array[i].yearOfBirth < minYearOfBirth) {
                minYearOfBirth = array[i].yearOfBirth;
            }
        }
    
        // Calcular o tamanho do array de contagem
        int range = maxYearOfBirth - minYearOfBirth + 1;
        int[] count = new int[range];
    
        // Contar o número de ocorrências de cada ano de nascimento
        for (int i = 0; i < n; i++) {
            count[array[i].yearOfBirth - minYearOfBirth]++;
        }
    
        // Atualizar o array de contagem para conter a posição correta de cada elemento
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
    
        // Criar um array auxiliar para armazenar os elementos ordenados
        Personagem[] sortedArray = new Personagem[n];
    
        // Preencher o array auxiliar com os elementos ordenados pelo ano de nascimento e nome
        for (int i = n - 1; i >= 0; i--) {
            int index = count[array[i].yearOfBirth - minYearOfBirth] - 1;
            sortedArray[index] = array[i];
            count[array[i].yearOfBirth - minYearOfBirth]--;
        }
    
        // Copiar os elementos ordenados de volta para o array original
        System.arraycopy(sortedArray, 0, array, 0, n);
    }
    
    

    
    
    

    

    //Procura de personagem e validação do mesmo
    public static Personagem searchPersonagem(String entrada, List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getId().equals(entrada)) {
                
                return personagem;
            }
        }
        System.out.println("Personagem não encontrado.");//Caso o ID seja inválido, retorna null e imprime mensagem na tela
        return null;
        }
    
    //Outra mudança de formato da data para xx/yy/zzzz
    public static Date changeDate(String data) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.parse(data);
    }

    //Setar o os valores de cada atributo no personagem
    public static void setValor(String[] valor, List<Personagem> listaPersonagem) throws Exception {
        Personagem personagem = new Personagem();

        personagem.setId(valor[0]);
        personagem.setName(valor[1]);
        personagem.setAlternate_name(valor[2]);
        personagem.setHouse(valor[3]);
        personagem.setAncestry(valor[4]);
        personagem.setSpecies(valor[5]);
        personagem.setPatronus(valor[6]);
        personagem.setHogwartsStaff(valor[7]);
        personagem.setHogwartsStudent(valor[8]);
        personagem.setActorName(valor[9]);
        personagem.setAlive(valor[10]);
        personagem.setDateOfBirth(changeDate(valor[12]));
        personagem.setYearOfBirth(Integer.parseInt(valor[13]));
        personagem.setEyeColour(valor[14]);
        personagem.setGender(valor[15]);
        personagem.setHairColour(valor[16]);
        personagem.setWizard(valor[17]);

        listaPersonagem.add(personagem);
    }
}
