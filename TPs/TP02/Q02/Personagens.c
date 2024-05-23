#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

bool charToBoolean(char c[])
{
    for (int i = 0; i < strlen(c); i++)
        tolower(c[i]);
    char myTrue[] = "true";
    char myFalse[] = "false";
    bool ehTrue = true;

    if (strcmp(myTrue, c))
        return true;

    if (strcmp(myFalse, c))
        return false;
}

typedef struct Personagem
{
    char id[100];
    char name[100];
    char alternate_names[500];
    char house[100];
    char ancestry[100];
    char species[100];
    char patronus[100];
    char hogwartsStaff[100];
    char hogwartsStudent[100];
    char actorName[100];
    char alive[100];
    char DataNascimento[100];
    char anoNascimento[100];
    char eyeColour[100];
    char gender[100];
    char hairColour[100];
    char wizard[100];
} Personagem;

typedef struct array
{
    Personagem vet[700];
    int id;
    int size;

} array;

char *tratandoAlternateNames(char string[])
{
    int count = 0;
    char *newChar = (char *)malloc((strlen(string) + 1) * sizeof(char));
    for (int i = 0; string[i] != '\0'; i++)
    {

        if (string[i] == '\'' || string[i] == '[' || string[i] == ']')
            continue;
        newChar[count++] = string[i];
    }
    newChar[count] = '\0';

    return newChar;
}

void pesquisaPassagem(array Lista)
{

    bool ehIgual;
    bool ehTrue;
    char id[200];
    int tamString;

    ehTrue = false;

    // lê id do teclado

    scanf(" %[^\n\r]", id);
    while (strcmp(id, "FIM\0"))
    {
        tamString = strlen(id);
        for (int j = 0; j < Lista.size; j++)
        {
            ehIgual = true;
            for (int i = 0; i < tamString; i++)
            {
                if (id[i] != Lista.vet[j].id[i])
                {
                    ehIgual = false;
                }
            }
            if (ehIgual)
            {
                printf("[%s ## ", Lista.vet[j].id);
                printf("%s ## ", Lista.vet[j].name);
                printf("{%s} ## ", tratandoAlternateNames(Lista.vet[j].alternate_names));
                printf("%s ## ", Lista.vet[j].house);
                printf("%s ## ", Lista.vet[j].ancestry);
                printf("%s ## ", Lista.vet[j].species);
                printf("%s ## ", Lista.vet[j].patronus);

                if (charToBoolean(Lista.vet[j].hogwartsStaff))
                {
                    printf("false ## ");
                }
                else
                    printf("true ## ");

                if (charToBoolean(Lista.vet[j].hogwartsStudent))
                {
                    printf("false ## ");
                }
                else
                    printf("true ## ");

                printf("%s ## ", Lista.vet[j].actorName);

                if (charToBoolean(Lista.vet[j].alive))
                    printf("true ## ");
                else
                    printf("false ## ");

                printf("%s ## ", Lista.vet[j].DataNascimento);
                printf("%s ## ", Lista.vet[j].anoNascimento);
                printf("%s ## ", Lista.vet[j].eyeColour);
                printf("%s ## ", Lista.vet[j].gender);
                printf("%s ## ", Lista.vet[j].hairColour);
                if (charToBoolean(Lista.vet[j].wizard))
                    printf("true]\n");
                else
                    printf("false]\n");
            }
        }
        scanf(" %[^\n\r]", id);
    }
}

// retorna o tamanho do arquivo
// le arquivo para struct
void importarBd(FILE *arq, array *Lista)
{
    char linha[1024];
    char tmp[100];

    arq = fopen("/tmp/characters.csv", "r");

    if (arq == NULL)
    {
        printf("Arquivo nao encontrado");
        return;
    }

    fgets(linha, sizeof(linha), arq); // Descartar a primeira linha (cabeçalho)
                                      // Remover o \n do final da linha, se existir

    while (!feof(arq))
    {
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].id);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].name);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].alternate_names);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].house);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].ancestry);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].species);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].patronus);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].hogwartsStaff);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].hogwartsStudent);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].actorName);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].alive);
        fgetc(arq);
        fscanf(arq, " %[^;]", tmp);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].DataNascimento);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].anoNascimento);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].eyeColour);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].gender);
        fgetc(arq);
        fscanf(arq, " %[^;]", Lista->vet[Lista->id].hairColour);
        fgetc(arq);
        fscanf(arq, " %[^\n]", Lista->vet[Lista->id].wizard);
        fgetc(arq);
        // Update the list size and id
        Lista->id++;
        Lista->size++;
    }
    fclose(arq);
}

int main()
{
    // objeto da struct array e ponteiro do arquivo
    array Lista;
    FILE *arq;

    // inicializando tamanho da lista de passagens e a qtd de passagens
    Lista.size = 0;
    Lista.id = 0;
    importarBd(arq, &Lista);
    pesquisaPassagem(Lista);

    return 0;
}