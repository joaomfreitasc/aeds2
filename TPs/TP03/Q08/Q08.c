#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

// Define auxiliares para strings, arrays, structs e atributos
#define linhaMax 1000
#define auxStringTam 200
#define auxArrayTam 200
#define listaStruct 500
#define atributos 18

// Struct para fazer um "split" enquanto lê o CSV
typedef struct{
    char stringSeparada[atributos][auxStringTam];
} Splitter;

// Struct para a Data
typedef struct{
    int dia;
    int mes;
    int ano;
} Date;

// Struct principal
typedef struct{
    char id[auxStringTam];
    char nome[auxStringTam];
    char nomesAlternativos[auxArrayTam];
    char casa[auxStringTam];
    char ascendencia[auxStringTam];
    char especie[auxStringTam];
    char patrono[auxStringTam];
    char staffHogwarts[auxStringTam];
    char estudanteHogwarts[auxStringTam];
    char nomeAtor[auxStringTam];
    char vivo[auxStringTam];
    char atoresAlternativos[auxStringTam];
    Date dataNascimento;
    int anoNascimento;
    char corOlhos[auxStringTam];
    char genero[auxStringTam];
    char corCabelo[auxStringTam];
    char bruxo[auxStringTam];
} Character;

// Declaração das funções

// Funções auxiliares para Character
void imprimirCharacter(const Character character, int x);

// Funções auxiliares específicas
void formatarStringBoolean(char* aux);
Date formatarStringDate(char* aux);
void removerCharString(char* aux, char c);

// Funções de leitura de arquivo
void lerCsv(Character characters[], char* arquivoParaLer);

// Funções de busca
int buscaLinearId(const Character characters[], char* id);

// Funções de lista dupla encadeada
typedef struct Node Node;
typedef struct LinkedList LinkedList;

struct Node{
    Character character;
    Node* prox;
    Node* ant;
};

struct LinkedList{
    Node* primeiro;
    Node* ultimo;
};

void iniciarLinkedList(LinkedList* lista);
void inserirFimLinkedList(LinkedList* lista, Character character);
void ordenarLinkedListPorNome(LinkedList* lista);
int compararCasa(Character x, Character y);
int compararNome(Character x, Character y);
void trocar(Node* a, Node* b);
Node* particionar(Node* baixo, Node* alto);
void quicksort(Node* baixo, Node* alto);
void mostrarLinkedList(LinkedList* lista);

int main(){
    Character characters[listaStruct];
    char entrada[auxStringTam];

    lerCsv(characters, "characters.csv");

    LinkedList usando;
    iniciarLinkedList(&usando);

    char id[auxStringTam];
    scanf(" %s", id);

    while(strcmp(id, "FIM")){
        int i = buscaLinearId(characters, id);

        if (i != -1) {
            inserirFimLinkedList(&usando, characters[i]);
        } else {
            printf("Personagem %s não encontrado\n", id);
        }

        scanf(" %s", id);
    }

    ordenarLinkedListPorNome(&usando);
    mostrarLinkedList(&usando);

    return 0;
}

// Função para imprimir todos os atributos de um personagem específico
void imprimirCharacter(const Character character, int x) {
    printf("[%s ## %s ## {%s} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %02d-%02d-%02d ## %d ## %s ## %s ## %s ## %s]\n",
        character.id,
        character.nome,
        character.nomesAlternativos,
        character.casa,
        character.ascendencia,
        character.especie,
        character.patrono,
        character.staffHogwarts,
        character.estudanteHogwarts,
        character.nomeAtor,
        character.vivo,
        character.dataNascimento.dia,
        character.dataNascimento.mes,
        character.dataNascimento.ano,
        character.anoNascimento,
        character.corOlhos,
        character.genero,
        character.corCabelo,
        character.bruxo);
}

// Funções auxiliares para formatar uma string específica

// Mudar de VERDADEIRO ou FALSO para true or false
void formatarStringBoolean(char* aux){
    aux[0] == 'V' ? strcpy(aux, "true") : strcpy(aux, "false");
}

// Passar uma string para Date
Date formatarStringDate(char* aux){
    Date formatada;
    sscanf(aux, "%d-%d-%d", &formatada.dia, &formatada.mes, &formatada.ano);
    return formatada;
}

// Remover o char 'c' da string
void removerCharString(char* aux, char c){
    int i = 0;
    int j = 0;
    while (aux[i] != '\0') {
        if (aux[i] != c) aux[j++] = aux[i];
        i++;
    }
    aux[j] = '\0';
}

// Função para ler o CSV e armazenar na struct principal
void lerCsv(Character characters[], char* arquivoParaLer){
    char aux[linhaMax];
    Splitter splitter;

    FILE* arq; 
    arq = fopen(arquivoParaLer, "r");
    if (arq == NULL) {
        printf("Erro ao abrir arquivo");
        return;
    }

    fgets(aux, sizeof(aux), arq);

    int k = 0;
    while (!(feof(arq))){
        for (int i = 0; i < atributos; i++) {
            fscanf(arq, "%[^;\n]", splitter.stringSeparada[i]);
            fgetc(arq);
        }

        strcpy(characters[k].id, splitter.stringSeparada[0]);
        strcpy(characters[k].nome, splitter.stringSeparada[1]);
        removerCharString(splitter.stringSeparada[2], '[');
        removerCharString(splitter.stringSeparada[2], ']');
        removerCharString(splitter.stringSeparada[2], '\'');
        strcpy(characters[k].nomesAlternativos, splitter.stringSeparada[2]);
        strcpy(characters[k].casa, splitter.stringSeparada[3]);
        strcpy(characters[k].ascendencia, splitter.stringSeparada[4]);
        strcpy(characters[k].especie, splitter.stringSeparada[5]);
        strcpy(characters[k].patrono, splitter.stringSeparada[6]);
        formatarStringBoolean(splitter.stringSeparada[7]);
        strcpy(characters[k].staffHogwarts, splitter.stringSeparada[7]);
        formatarStringBoolean(splitter.stringSeparada[8]);
        strcpy(characters[k].estudanteHogwarts, splitter.stringSeparada[8]);
        strcpy(characters[k].nomeAtor, splitter.stringSeparada[9]);
        formatarStringBoolean(splitter.stringSeparada[10]);
        strcpy(characters[k].vivo, splitter.stringSeparada[10]);
        strcpy(characters[k].atoresAlternativos, splitter.stringSeparada[11]);
        characters[k].dataNascimento = formatarStringDate(splitter.stringSeparada[12]);
        characters[k].anoNascimento = atoi(splitter.stringSeparada[13]);
        strcpy(characters[k].corOlhos, splitter.stringSeparada[14]);
        strcpy(characters[k].genero, splitter.stringSeparada[15]);
        strcpy(characters[k].corCabelo, splitter.stringSeparada[16]);
        formatarStringBoolean(splitter.stringSeparada[17]);
        strcpy(characters[k].bruxo, splitter.stringSeparada[17]);

        for (int i = 0; i < atributos; i++) splitter.stringSeparada[i][0] = 0;
        k++;
    }

    characters[k].id[0] = '\0';
    fclose(arq);
}

// Função para busca linear por ID
int buscaLinearId(const Character characters[], char* id){
    int index = -1;
    int max = 0;

    while (characters[max].id[0] != '\0') max++;

    for (int i = 0; i < max; i++){
        if (strcmp(characters[i].id, id) == 0){
            index = i;
            break;
        }
    }

    return index;
}

// Inicializar a LinkedList
void iniciarLinkedList(LinkedList* lista){
    Node* aux = (Node*)malloc(1 * sizeof(Node));
    aux->prox = NULL;
    aux->ant = NULL;
    lista->primeiro = aux;
    lista->ultimo = aux;
}

// Inserir no final da LinkedList
void inserirFimLinkedList(LinkedList* lista, Character character){
    lista->ultimo->prox = (Node*)malloc(1 * sizeof(Node));
    lista->ultimo->prox->ant = lista->ultimo;
    lista->ultimo = lista->ultimo->prox;
    lista->ultimo->character = character;
    lista->ultimo->prox = NULL;
}

// Comparar por casa
int compararCasa(Character x, Character y){
    if (strlen(x.casa) == 0) return 0;
    if (strlen(y.casa) == 0) return 1;
    return strcmp(x.casa, y.casa) > 0;
}

// Comparar por nome
int compararNome(Character x, Character y){
    return strcmp(x.nome, y.nome) > 0;
}

// Trocar células
void trocar(Node* a, Node* b){
    Character tmp = a->character;
    a->character = b->character;
    b->character = tmp;
}

// Particionar a lista para o Quicksort
Node* particionar(Node* baixo, Node* alto){
    Character x = alto->character;
    Node* i = baixo->ant;

    for (Node* j = baixo; j != alto; j = j->prox){
        if (compararCasa(j->character, x) || (strcmp(j->character.casa, x.casa) == 0 && compararNome(j->character, x))){
            i = (i == NULL) ? baixo : i->prox;
            trocar(i, j);
        }
    }

    i = (i == NULL) ? baixo : i->prox;
    trocar(i, alto);
    return i;
}

// Quicksort para a lista
void quicksort(Node* baixo, Node* alto){
    if (alto != NULL && baixo != alto && baixo != alto->prox){
        Node* p = particionar(baixo, alto);
        quicksort(baixo, p->ant);
        quicksort(p->prox, alto);
    }
}

// Ordenar a lista por nome
void ordenarLinkedListPorNome(LinkedList* lista){
    quicksort(lista->primeiro->prox, lista->ultimo);
}

// Mostrar a lista de personagens
void mostrarLinkedList(LinkedList* lista){
    Node* aux = lista->ultimo;
    while (aux != lista->primeiro){
        imprimirCharacter(aux->character, 0);
        aux = aux->ant;
    }
}