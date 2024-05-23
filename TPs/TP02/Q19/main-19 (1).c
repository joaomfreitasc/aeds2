#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool parseBool(char cadeia[]) 
{
    for(int i = 0; i < strlen(cadeia);i++)
    {
        tolower(cadeia[i]);
    }

    char V[] = "true";
    bool isTrue = true;

    if(strcmp(V,cadeia))
    {
        return true;
    }    
    else
    {
        return false;
    }
}

typedef struct Personagem {
    char pos[100];
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

typedef struct Personagens {
    Personagem personagens[500];
    int pos;
    int tam;
} Personagens;

char *exception_alternate_names(char string[])
{
    int count = 0;
    char* newChar = (char*) malloc((strlen(string) + 1) * sizeof(char));
    for(int i = 0; string[i] != '\0'; i++) 
    {
        if(string[i] == '\'' || string[i] == '[' || string[i] == ']') continue;
        newChar[count++] = string[i];
    }
    newChar[count] = '\0';
    
    return newChar;
}

void imprimir(Personagens list) 
{
    bool isEqual;
    bool isTrue;
    char pos[200];
    int tamString;

    isTrue = false;
         
    scanf(" %[^\n\r]",pos);

    while(strcmp(pos,"FIM\0"))
    {
        tamString = strlen(pos);
        for(int j = 0; j < list.tam; j++) 
        {
            isEqual = true;
            for (int i = 0; i < tamString; i++) 
            {
                if (pos[i] != list.personagens[j].pos[i]) 
                {
                    isEqual = false;
                }
            }
            
            if(isEqual) 
            {
                printf("[%s ## ",list.personagens[j].pos);
                printf("%s ## ",list.personagens[j].name);
                printf("{%s} ## ",exception_alternate_names(list.personagens[j].alternate_names));
                printf("%s ## ",list.personagens[j].house);
                printf("%s ## ",list.personagens[j].ancestry);
                printf("%s ## ",list.personagens[j].species);
                printf("%s ## ",list.personagens[j].patronus);
                  
                if(parseBool( list.personagens[j].hogwartsStaff))
                {
                    printf("false ## ");
                }
                else
                {
                    printf("true ## ");
                }
                if(parseBool( list.personagens[j].hogwartsStudent))
                {
                    printf("false ## ");
                }
                else
                {
                    printf("true ## ");                 
                }  

                printf("%s ## ",list.personagens[j].actorName);

                if(parseBool(list.personagens[j].alive))
                {
                    printf("true ## ");
                }
                else
                {
                    printf("false ## ");
                }
                  
                printf("%s ## ",list.personagens[j].DataNascimento);
                printf("%s ## ",list.personagens[j].anoNascimento);
                printf("%s ## ",list.personagens[j].eyeColour);
                printf("%s ## ",list.personagens[j].gender);
                printf("%s ## ",list.personagens[j].hairColour);

                if(parseBool(list.personagens[j].wizard))
                {
                    printf("true]\n");
                }
                else
                {
                    printf("false]\n");
                }
            }
        }
        scanf(" %[^\n\r]",pos);
    }
}

void leitorCSV(FILE *arquivo, Personagens *list) 
{
    char linha[1024];
    char tmp[100];
    arquivo = fopen("/tmp/characters.csv", "r");

    if (arquivo == NULL) 
    {
        printf("arquivo nao encontrado");
        return;
    }

    fgets(linha, sizeof(linha), arquivo);

    while (!feof(arquivo)) 
    {
        fscanf(arquivo," %[^;]",list->personagens[list->pos].pos);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].name);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].alternate_names);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].house);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].ancestry);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].species);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].patronus);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].hogwartsStaff);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].hogwartsStudent);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].actorName);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].alive);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",tmp);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].DataNascimento);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].anoNascimento);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].eyeColour);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].gender);
        fgetc(arquivo);
        fscanf(arquivo," %[^;]",list->personagens[list->pos].hairColour);
        fgetc(arquivo);
        fscanf(arquivo," %[^\n]",list->personagens[list->pos].wizard);
        fgetc(arquivo);

        list->pos++;
        list->tam++;
    }
    fclose(arquivo);
}

int main() 
{
    Personagens list;
    FILE *arquivo;

    list.tam = 0;
    list.pos = 0;
    leitorCSV(arquivo, &list);
    imprimir(list);

    return 0;
}