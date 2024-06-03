#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


// Define auxiliares para strings, arrays, structs e atributos
#define lineMax 1000
#define auxStringTam 200
#define auxArrayTam 200
#define structList 500
#define attributes 18


// Struct para fazer um "split" enquanto lee o CSV
typedef struct{
    char stringSplited[attributes][auxStringTam];
} Split;


// Struct para o LocalDate
typedef struct{
    int day;
    int month;
    int year;
} LocalDate;


// Struct principal
typedef struct{
    char id[auxStringTam];
    char name[auxStringTam];
    char alternateNames[auxArrayTam];
    char house[auxStringTam];
    char ancestry[auxStringTam];
    char species[auxStringTam];
    char patronus[auxStringTam];
    char hogwartsStaff[auxStringTam];
    char hogwartsStudent[auxStringTam];
    char actorName[auxStringTam];
    char alive[auxStringTam];
    char alternateActors[auxStringTam];
    LocalDate dateOfBirth;
    int yearOfBirth;
    char eyeColor[auxStringTam];
    char gender[auxStringTam];
    char hairColor[auxStringTam];
    char wizard[auxStringTam];
} Personagem;



// -------------------------------------------------------------------------------------------------------------------------

                            // Declaração das funções criadas

// Leitura de arquivo
void readCsv(Personagem personagens[], char* fileToRead);

// Busca
int linearIdSearch(const Personagem personagem[], char* id);
int binaryNameSearch(Personagem personagens[], int begin, int end, char *resp);
void nameVerifierBinarySearch(Personagem personagens[]);

// Auxiliares
void stringBooleanFormat(char* aux);
int stringIntFormat(const char* aux);
void removeStringChar(char* aux, char c);

// Expecificas de Personagem
void printPersonagem(const Personagem personagem, int x);
void printAllPersonagens(Personagem personagens[]);
Personagem* mySubList(const Personagem personagens[]);
Personagem* createNewSubList(const Personagem personagens[], int max);
LocalDate stringDateFormat(char* aux);
int endOfList(Personagem personagem);
int lengthOfList(const Personagem personagens[]);

// Funções para o exercicio
void exercicio(const Personagem personagens[], Personagem using[]);
void realizar(const Personagem personagens[], Personagem using[], char* input);
void mediaYear(Personagem using[]);


// Variavel global para saber o tamanho da lista mais facil
int tam = 0;

// Variavel global para inicio e fim da lista circular
int inicio = 0;
int fim = 0;

// -------------------------------------------------------------------------------------------------------------------------

                            // Main

int main(){
    Personagem personagens[structList];
    char input[auxStringTam];

    readCsv(personagens, "/tmp/characters.csv");

    Personagem* using = NULL;
    using = mySubList(personagens);

    exercicio(personagens, using);
    int index = inicio;
    int aux = 0;
    printf("[ Head ]\n");
    while ( index != fim ){
        printPersonagem(using[index], aux++);
        index = (index + 1) % 6;
    }
    printf("[ Tail ]");
    
    // printAllPersonagens(using);

    free(using);
    
    return 0;
}

// Exercicio
void exercicio(const Personagem personagens[], Personagem using[]){
    int max = 0;
    scanf(" %d", &max);

    char input[auxStringTam];
    for ( int i = 0; i < max; i++ ){
        scanf(" %[^\n\r]", input);

        realizar(personagens, using, input);
    }

}

// Casos
void realizar(const Personagem personagens[], Personagem using[], char* input){
    int aux = 0;
    int index = 0;
    int posi = 0;

    char* token;
    token = strtok(input, " ");

    if (strcmp(token, "I") == 0){
        token = strtok(NULL, " \n\r");

        aux = linearIdSearch(personagens, token);

        if ( inicio != ((fim + 1) % 6)){
                using[fim] = personagens[aux];
                fim = (fim + 1) % 6;
            } 
            else {
                inicio = (inicio + 1) % 6;
                using[fim] = personagens[aux];
                fim = (fim + 1) % 6;
            }

            mediaYear(using);
    }
    else if (strcmp(token, "R") == 0){
        printf("(R) %s\n", using[inicio].name);

        inicio = (inicio + 1) % 6;
    }
    else{
        printf("Erro, caso invalido");
    }

    token[0] = '\0';
}


// -------------------------------------------------------------------------------------------------------------------------

                            // Funções auxiliares expecifica para Personagem


// Função para printar todos os atributos de um personagem expecifico
void printPersonagem(const Personagem personagem, int x) { //                             LocalDate
    printf("[%d ## %s ## %s ## {%s} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %02d-%02d-%02d ## %d ## %s ## %s ## %s ## %s]\n",
            x,
            personagem.id,
            personagem.name,
            personagem.alternateNames,
            personagem.house,
            personagem.ancestry,
            personagem.species,
            personagem.patronus,
            personagem.hogwartsStaff,
            personagem.hogwartsStudent,
            personagem.actorName,
            personagem.alive,
            personagem.dateOfBirth.day,
            personagem.dateOfBirth.month,
            personagem.dateOfBirth.year,
            personagem.yearOfBirth,
            personagem.eyeColor,
            personagem.gender,
            personagem.hairColor,
            personagem.wizard);
}

// Printar todos os personagens da lista
void printAllPersonagens(Personagem personagens[]){
    Personagem* aux = &personagens[0];
    int index = 0;

    // while ( !endOfList(*aux) ){
    //     printPersonagem(*aux, index++);
    //     aux++;
    // }

    while ( index < tam ){
        printPersonagem(*aux, index++);
        aux++;
    }
}

// Retorna uma subLista de personagens, contendo apenas os pesquisados
Personagem* mySubList(const Personagem personagens[]){
    Personagem* aux = (Personagem*)malloc(6 * sizeof(Personagem));
    for ( int i = 0; i < 6; i++ ) aux[i].yearOfBirth = 0;

    // int length = 0;

    char id[auxStringTam];
    scanf(" %s", id);

    while(strcmp(id, "FIM")){
        int i = linearIdSearch(personagens, id);

        if ( i != -1 ) {
            // aux[length++] = personagens[i];
            if ( inicio != ((fim + 1) % 6)){
                aux[fim] = personagens[i];
                fim = (fim + 1) % 6;
            } 
            else {
                inicio = (inicio + 1) % 6;
                aux[fim] = personagens[i];
                fim = (fim + 1) % 6;
            }
            mediaYear(aux);
        }
        else printf("Personagem %s nao encontrado\n", id);

        scanf(" %s", id);
    }

    // aux[length++].id[0] = '\0';
    // tam = length - 1;

    return aux;
}

// Printar media dos anos
void mediaYear(Personagem using[]){
    int media = 0;
    int index = inicio;
    int loop = 0;
    while ( index != fim ){
        media = media + using[index].yearOfBirth;
        loop++;
        index = (index + 1) % 6;
    }

    printf(">> Year Birthday Average: %d\n", media/loop);
}

// Cria uma subLista com os N primeiros elementos de outra lista
Personagem* createNewSubList(const Personagem personagens[], int max){
    Personagem* aux = (Personagem*)malloc((max + 1) * sizeof(Personagem));

    for ( int i = 0; i < max; i++ ){
        aux[i] = personagens[i];
    }

    aux[max].id[0] = '\0';

    return aux;
}

// Verificar se chegou no ultimo elemento do array preenchido
int endOfList(Personagem personagem){
    return personagem.id[0] == '\0';
}

// Retornar o tamanho do array
int lengthOfList(const Personagem personagens[]){
    int length = 0;

    while (!endOfList(personagens[length])) length++;

    return length;
}



// -------------------------------------------------------------------------------------------------------------------------

                            // Funções para busca de personagem


// Função para busca linear por ID
int linearIdSearch(const Personagem personagens[], char* id){
    int index = -1;
    int max = lengthOfList(personagens);

    for ( int i = 0; i < max; i++){
        if ( strcmp(personagens[i].id, id) == 0 ){
            index = i;
            break;
        }
    }

    return index;
}

// Função para busca Binaria por Name
int binaryNameSearch(Personagem personagens[], int begin, int end, char *resp){
    if (begin <= end) {
        int middle = ((begin + end) / 2);

        if (strcmp(personagens[middle].name, resp) == 0) return middle;
        else if (strcmp(personagens[middle].name, resp) < 0) return binaryNameSearch(personagens, middle + 1, end, resp);
        else return binaryNameSearch(personagens, begin, middle - 1, resp);
    }

    return -1;
}

// Verificar se o nome esta presente em um array ordenado
void nameVerifierBinarySearch(Personagem personagens[]){
    char input[auxStringTam];

    scanf(" %[^\r]", input);
    while ( (strcmp(input, "FIM") != 0) ){

        int index = binaryNameSearch(personagens, 0, lengthOfList(personagens), input);

        if ( index != -1 ) printf("SIM\n");
        else printf("NAO\n");

        scanf(" %[^\r]", input);
    }
}


// -------------------------------------------------------------------------------------------------------------------------

                       // Função para ler o CSV e armazenar na struct principal


void readCsv(Personagem personagens[], char* fileToRead){
    char aux[lineMax];
    Split split;

    FILE* arq; 
    arq = fopen(fileToRead, "r");
    if ( arq == NULL ) {
        printf("Erro ao abrir arquivo");
        return;
    }

    fgets(aux, sizeof(aux), arq);

    // Ler uma linha do CSV separando os atributos em cada posição do split, e depois ir setando na struct pricipal, formatando quando necessário
    int k = 0;
    while ( !(feof(arq)) ){
        for ( int i = 0; i < attributes; i++ ) {
            fscanf(arq, "%[^;\n]", split.stringSplited[i]);
            fgetc(arq);
        }

        strcpy(personagens[k].id, split.stringSplited[0]);

        strcpy(personagens[k].name, split.stringSplited[1]);

            removeStringChar(split.stringSplited[2], '[');
            removeStringChar(split.stringSplited[2], ']');
            removeStringChar(split.stringSplited[2], '\'');
        strcpy(personagens[k].alternateNames, split.stringSplited[2]);

        strcpy(personagens[k].house, split.stringSplited[3]);

        strcpy(personagens[k].ancestry, split.stringSplited[4]);

        strcpy(personagens[k].species, split.stringSplited[5]);

        strcpy(personagens[k].patronus, split.stringSplited[6]);

        stringBooleanFormat(split.stringSplited[7]);
        strcpy(personagens[k].hogwartsStaff, split.stringSplited[7]);

        stringBooleanFormat(split.stringSplited[8]);
        strcpy(personagens[k].hogwartsStudent, split.stringSplited[8]);

        strcpy(personagens[k].actorName, split.stringSplited[9]);

        stringBooleanFormat(split.stringSplited[10]);
        strcpy(personagens[k].alive, split.stringSplited[10]);

        strcpy(personagens[k].alternateActors, split.stringSplited[11]);

        personagens[k].dateOfBirth = stringDateFormat(split.stringSplited[12]);

        personagens[k].yearOfBirth = atoi(split.stringSplited[13]);

        strcpy(personagens[k].eyeColor, split.stringSplited[14]);

        strcpy(personagens[k].gender, split.stringSplited[15]);

        strcpy(personagens[k].hairColor, split.stringSplited[16]);

        stringBooleanFormat(split.stringSplited[17]);
        strcpy(personagens[k].wizard, split.stringSplited[17]);

        for ( int i = 0; i < attributes; i++ ) split.stringSplited[i][0] = 0;

        k++;
    }

    personagens[k].id[0] = '\0';

    fclose(arq);
}



// -------------------------------------------------------------------------------------------------------------------------

                        // Funções auxiliares para formatar uma string expecifica


// Mudar de VERDADEIRO ou FALSO para true or false
void stringBooleanFormat(char* aux){
    aux[0] == 'V' ? strcpy(aux, "true") : strcpy(aux, "false");
}

// Passar uma string para int
int stringIntFormat(const char* aux){
    return atoi(aux);
}

// Passar uma string para LocalDate
LocalDate stringDateFormat(char* aux){
    LocalDate formated;

    sscanf(aux, "%d-%d-%d", &formated.day, &formated.month, &formated.year);
    
    return formated;
}

// Remover o char 'c' da string
void removeStringChar(char* aux, char c){
    int i = 0;
    int j = 0;
    while (aux[i] != '\0') {
        if (aux[i] != c) aux[j++] = aux[i];
        i++;
    }
    aux[j] = '\0';
}



// -------------------------------------------------------------------------------------------------------------------------