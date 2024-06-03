#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

#define MAX_LENGTH 100
#define MAX_TAM 6

typedef struct {
    char id[MAX_LENGTH];
    char nome[MAX_LENGTH];
    char alternate_names[MAX_LENGTH];
    char house[MAX_LENGTH];
    char ancestry[MAX_LENGTH];
    char species[MAX_LENGTH];
    char patronus[MAX_LENGTH];
    bool hogwartsStaff;
    bool hogwartsStudent;
    char actorName[MAX_LENGTH];
    bool alive;
    char dateOfBirth[10];
    int yearOfBirth;
    char eyeColour[MAX_LENGTH];
    char gender[MAX_LENGTH];
    char hairColour[MAX_LENGTH];
    bool wizard;
} Personagem;

typedef struct Celula
{
    Personagem elemento;
    struct Celula *prox;
} Celula;

Celula *novaCelula(Personagem elemento)
{
    Celula *nova = (Celula *)malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;
    return nova;
}

Celula *primeiro;
Celula *ultimo;
int qt = 0;

Personagem array[MAX_TAM];

int mediaAno() {
    int somaAno = 0;
    int i = 0;
    Celula* j;

    for (j = primeiro->prox; j != NULL; j = j->prox) {
       somaAno += j->elemento.yearOfBirth;
       i++;
    }


    int media = somaAno / i;
    int mediaArredondada = round(media);

    return mediaArredondada;
}

Personagem remover() {   
    if (primeiro == ultimo)
    {
        printf("Erro ao remover!\n");
        exit(1);
    }
    Celula *tmp = primeiro;
    primeiro = primeiro->prox;
    Personagem resp = primeiro->elemento;
    tmp->prox = NULL;
    free(tmp);
    tmp = NULL;
    qt--;
    return resp;
}

void inserir(Personagem x)
{
    if(qt == 5){
        remover();
    }
    ultimo->prox = novaCelula(x);
    ultimo = ultimo->prox;
    qt++;
    int media = mediaAno();

    printf(">> Year Birthday Average: %i\n", media);
}

void imprimir(Personagem *personagem, int x) {
    int len = strlen(personagem->alternate_names);
    for (int i = 0; i < len; i++) {
        if (personagem->alternate_names[i] == '[') {
            personagem->alternate_names[i] = '{';
        } else if (personagem->alternate_names[i] == ']') {
            personagem->alternate_names[i] = '}';
        } else if (personagem->alternate_names[i] == '\'') {
            memmove(&personagem->alternate_names[i], &personagem->alternate_names[i + 1], strlen(personagem->alternate_names) - i);
            i--;
        }
    }



    printf("[%d ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",
        x,  
        strcmp(personagem->id, "-1") != 0 ? personagem->id : "", 
        strcmp(personagem->nome, "-1") != 0 ? personagem->nome : "", 
        strcmp(personagem->alternate_names, "-1") != 0 ? personagem->alternate_names : "", 
        strcmp(personagem->house, "-1") != 0 ? personagem->house : "",
        strcmp(personagem->ancestry, "-1") != 0 ? personagem->ancestry : "", 
        strcmp(personagem->species, "-1") != 0 ? personagem->species : "", 
        strcmp(personagem->patronus, "-1") != 0 ? personagem->patronus : "",
        personagem->hogwartsStaff ? "true" : "false", 
        personagem->hogwartsStudent ? "true" : "false",
        strcmp(personagem->actorName, "-1") != 0 ? personagem->actorName : "", 
        personagem->alive ? "true" : "false", 
        strcmp(personagem->dateOfBirth, "-1") != 0 ? personagem->dateOfBirth : "",
        personagem->yearOfBirth, 
        strcmp(personagem->eyeColour, "-1") != 0 ? personagem->eyeColour : "", 
        strcmp(personagem->gender, "-1") != 0 ? personagem->gender : "", 
        strcmp(personagem->hairColour, "-1") != 0 ? personagem->hairColour : "",
        personagem->wizard ? "true" : "true");
}

void replaceDoubleViruglas(char *str) {
    int tamanho = strlen(str);
    char tmp[3 * tamanho];
    int j = 0; 

    for (int i = 0; i < tamanho; i++) {
        if (str[i] == ';' && str[i+1] == ';') {
            tmp[j++] = ';'; 
            tmp[j++] = '-';
            tmp[j++] = '1';
            tmp[j++] = ';';
            
            i++;
        } else {
            tmp[j++] = str[i];
        }
        
    }
    tmp[j] = '\0';
    strcpy(str, tmp);
}

void ler(Personagem *personagem, char *str) {
    replaceDoubleViruglas(str);
    char *token = strtok(str, ";");
    int fieldIndex = 0;

    while (token != NULL) {
        switch (fieldIndex) {
            case 0: strcpy(personagem->id, token); break;
            case 1: strcpy(personagem->nome, token); break;
            case 2: strcpy(personagem->alternate_names, token); break;
            case 3: strcpy(personagem->house, token); break;
            case 4: strcpy(personagem->ancestry, token); break;
            case 5: strcpy(personagem->species, token); break;
            case 6: strcpy(personagem->patronus, token); break;
            case 7: personagem->hogwartsStaff = (strcmp(token, "VERDADEIRO") == 0); break;
            case 8: personagem->hogwartsStudent = (strcmp(token, "VERDADEIRO") == 0); break;
            case 9: strcpy(personagem->actorName, token); break;
            case 10: personagem->alive = (strcmp(token, "VERDADEIRO") == 0); break;
            case 12: strcpy(personagem->dateOfBirth, token); break;
            case 13: personagem->yearOfBirth = atoi(token); break;
            case 14: strcpy(personagem->eyeColour, token); break;
            case 15: strcpy(personagem->gender, token); break;
            case 16: strcpy(personagem->hairColour, token); break;
            case 17: personagem->wizard = (strcmp(token, "VERDADEIRO") == 0); break;
            default: break;
        }
        fieldIndex++;
        token = strtok(NULL, ";");
    }
}

void mostrar(){
    Celula *i;
    int count = 0;
    printf(" [ Head ]\n");
    for (i = primeiro->prox; i != NULL; i = i->prox, count++) {
        imprimir(&i->elemento, count);
    }
    printf(" [ Tail ]");
}

int main() {
    Personagem characters[406];
    char n[50];

    FILE *arq = fopen("/tmp/characters.csv", "r");

    primeiro = novaCelula(characters[0]);
    ultimo = primeiro;

    if (arq == NULL) {
        printf("Impossivel abrir arquivo\n");
        return 0;
    }

    char str[300];
    fgets(str, sizeof(str), arq);
    int i = 0;
    while (fgets(str, sizeof(str), arq)) {
        ler(&characters[i], str);
        i++;
    }

    scanf(" %[^\r\n]s", n);
    int cont = 0;

    while(strcmp(n, "FIM") != 0){
        for (int i = 0; i < 406; i++) {
            if (strcmp(characters[i].id, n) == 0) {
                inserir(characters[i]);
                break;
            }
        }
        scanf(" %[^\r\n]s", n);
    }


    scanf(" %[^\r\n]s", n);
    int qtd = atoi(n);

    for(int i = 0; i < qtd; i++){
        getchar();
        scanf(" %[^\r\n]s", n);
        char str[MAX_LENGTH][MAX_LENGTH];
        char* token;
        token = strtok(n, " ");

        for(int i = 0; token != NULL; i++) {
            strcpy(str[i], token);
            token = strtok(NULL, " ");
        }

        if(strcmp(str[0], "I") == 0){
            for (int i = 0; i < 406; i++) {
                if (strcmp(characters[i].id, str[1]) == 0) {
                    inserir(characters[i]);
                    break;
                }
            }
        }
        else if(strcmp(str[0], "R") == 0){
            Personagem jogador = remover(atoi(str[1]));
            printf("(R) %s\n", jogador.nome);
        }
    }
    mostrar();  

    fclose(arq);

    return 0;
}
