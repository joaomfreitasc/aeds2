#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

/*
    struct Personagem - definicao do tipo Personagem
*/
typedef struct Personagem {
    // atributos
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
    char dateOfBirth[100];
    char yearOfBirth[100];
    char eyeColour[100];
    char gender[100];
    char hairColour[100];
    char wizard[100];  
} Personagem;

void clone( Personagem* p1, Personagem* p2 )
{
    strcpy( p1->id, p2->id );
    strcpy( p1->name, p2->name );
    strcpy( p1->alternate_names, p2->alternate_names );
    strcpy( p1->house, p2->house );
    strcpy( p1->ancestry, p2->ancestry );
    strcpy( p1->species, p2->species );
    strcpy( p1->patronus, p2->patronus );
    strcpy( p1->hogwartsStaff, p2->hogwartsStaff );
    strcpy( p1->hogwartsStudent, p2->hogwartsStudent );
    strcpy( p1->actorName, p2->actorName );
    strcpy( p1->alive, p2->alive );
    strcpy( p1->dateOfBirth, p2->dateOfBirth );
    strcpy( p1->yearOfBirth, p2->yearOfBirth );
    strcpy( p1->eyeColour, p2->eyeColour );
    strcpy( p1->gender, p2->gender );
    strcpy( p1->hairColour, p2->hairColour );
    strcpy( p1->wizard, p2->wizard );
}

/**
    substituiCaracteres( ) - funcao para substituir colchetes por chaves
    @param frase - frase que tera os colchetes substituidos
    @return - nova frase com as devidas substituicoes
*/
char* substituiColchetes( char* frase )
{
    char* novaFrase = frase;
    for( int i = 0; i < strlen(novaFrase); i = i + 1 )
    {
        if( novaFrase[i] == '[' ) 
        {
            novaFrase[i] = '{';
        }
        else if( novaFrase[i] == ']' ) 
        {
            novaFrase[i] = '}';
        }
    }
    return novaFrase;
}

int procuraVirgulasDobradas( char linha[] )
{
    int resultado = 0;
    for( int i = 0; i < strlen( linha ); i = i + 1 )
    {
        if( linha[i] == ';' && linha[i+1] == ';')
        {
            resultado = resultado + 1;
        }
    }

    return resultado;
}

/**
    leitor( ) - funcao para armazenar na variavel do tipo Personagem, seus devidos atributos de acordo com a linha do CSV
    @param p - endereco de memoria do personagem que recebera os valores
    @param linha - linha do CSV que contem os dados a serem armazenados
*/
void leitor( Personagem* p, char linha[] )
{
    // definir dados
    char* token;
    char* aux;
    char linhaAUX[strlen(linha)];
    strcpy(linhaAUX, linha);

    token = strtok( linhaAUX, ";");
    strcpy( p->id, token );
    token = strtok( NULL, ";" );
    strcpy( p->name, token );
    token = strtok( NULL, ";" );
    aux = token;
    aux = substituiColchetes( aux );
    strcpy( p->alternate_names, aux );
    token = strtok( NULL, ";" );
    strcpy( p->house, token );
    token = strtok( NULL, ";" );
    strcpy( p->ancestry, token );
    token = strtok( NULL, ";" );
    strcpy( p->species, token );
    token = strtok( NULL, ";" );
    strcpy( p->patronus, token );
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->hogwartsStaff, "true" );
    }
    else
    {
        strcpy( p->hogwartsStaff, "false" );
    }
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->hogwartsStudent, "true" );
    }
    else
    {
        strcpy( p->hogwartsStudent, "false" );
    }
    token = strtok( NULL, ";" );
    strcpy( p->actorName, token );
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->alive, "true" );
    }
    else
    {
        strcpy( p->alive, "false" );
    }
    token = strtok( NULL, ";" );
    token = strtok( NULL, ";" );
    strcpy( p->dateOfBirth, token );
    token = strtok( NULL, ";" );
    strcpy( p->yearOfBirth, token );
    token = strtok( NULL, ";" );
    strcpy( p->eyeColour, token );
    token = strtok( NULL, ";" );
    strcpy( p->gender, token );
    token = strtok( NULL, ";" );
    strcpy( p->hairColour, token );
    token = strtok( NULL, "\n" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->wizard, "true" );
    }
    else
    {
        strcpy( p->wizard, "false" );
    }
} // end leitor( )

void leitor2( Personagem* p, char linha[] )
{
    // definir dados
    char* token;
    char* aux;
    char linhaAUX[strlen(linha)];
    strcpy(linhaAUX, linha);

    token = strtok( linhaAUX, ";");
    strcpy( p->id, token );
    token = strtok( NULL, ";" );
    strcpy( p->name, token );
    token = strtok( NULL, ";" );
    aux = token;
    aux = substituiColchetes( aux );
    strcpy( p->alternate_names, aux );
    token = strtok( NULL, ";" );
    strcpy( p->house, token );
    token = strtok( NULL, ";" );
    strcpy( p->ancestry, token );
    token = strtok( NULL, ";" );
    strcpy( p->species, token );
    strcpy( p->patronus, " " );
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->hogwartsStaff, "true" );
    }
    else
    {
        strcpy( p->hogwartsStaff, "false" );
    }
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->hogwartsStudent, "true" );
    }
    else
    {
        strcpy( p->hogwartsStudent, "false" );
    }
    token = strtok( NULL, ";" );
    strcpy( p->actorName, token );
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->alive, "true" );
    }
    else
    {
        strcpy( p->alive, "false" );
    }
    token = strtok( NULL, ";" );
    token = strtok( NULL, ";" );
    strcpy( p->dateOfBirth, token );
    token = strtok( NULL, ";" );
    strcpy( p->yearOfBirth, token );
    token = strtok( NULL, ";" );
    strcpy( p->eyeColour, token );
    token = strtok( NULL, ";" );
    strcpy( p->gender, token );
    token = strtok( NULL, ";" );
    strcpy( p->hairColour, token );
    token = strtok( NULL, "\n" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->wizard, "true" );
    }
    else
    {
        strcpy( p->wizard, "false" );
    }
}

void leitor3( Personagem* p, char linha[] )
{
    // definir dados
    char* token;
    char* aux;
    char linhaAUX[strlen(linha)];
    strcpy(linhaAUX, linha);

    token = strtok( linhaAUX, ";");
    strcpy( p->id, token );
    token = strtok( NULL, ";" );
    strcpy( p->name, token );
    token = strtok( NULL, ";" );
    aux = token;
    aux = substituiColchetes( aux );
    strcpy( p->alternate_names, aux );
    token = strtok( NULL, ";" );
    strcpy( p->house, token );
    token = strtok( NULL, ";" );
    strcpy( p->ancestry, token );
    token = strtok( NULL, ";" );
    strcpy( p->species, token );
    strcpy( p->patronus, " " );
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->hogwartsStaff, "true" );
    }
    else
    {
        strcpy( p->hogwartsStaff, "false" );
    }
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->hogwartsStudent, "true" );
    }
    else
    {
        strcpy( p->hogwartsStudent, "false" );
    }
    strcpy( p->patronus, " " );
    token = strtok( NULL, ";" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->alive, "true" );
    }
    else
    {
        strcpy( p->alive, "false" );
    }
    token = strtok( NULL, ";" );
    token = strtok( NULL, ";" );
    strcpy( p->dateOfBirth, token );
    token = strtok( NULL, ";" );
    strcpy( p->yearOfBirth, token );
    token = strtok( NULL, ";" );
    strcpy( p->eyeColour, token );
    token = strtok( NULL, ";" );
    strcpy( p->gender, token );
    token = strtok( NULL, ";" );
    strcpy( p->hairColour, token );
    token = strtok( NULL, "\n" );
    if( strcmp(token, "VERDADEIRO") == 0 )
    {
        strcpy( p->wizard, "true" );
    }
    else
    {
        strcpy( p->wizard, "false" );
    }
}

/**
    imprimir( ) - funcao para mostrar na tela os atributos de um personagem
    @param p - personagem que sera mostrado
*/
void imprimir( Personagem* p )
{
    // saida
    printf("%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n", p->id, p->name,
         p->alternate_names, p->house, p->ancestry, p->species, p->patronus, p->hogwartsStaff, p->hogwartsStudent, p->actorName, p->alive, 
         p->dateOfBirth, p->yearOfBirth,p->eyeColour, p->gender, p->hairColour, p->wizard );
} // end imprimir( )

#define MAXTAM 100

Personagem array[MAXTAM];
int n;

void start(){
    n = 0;
}

void inserirInicio(Personagem x) {
    if (n >= MAXTAM)
    exit(1);
    //levar elementos para o fim do array
    for (int i = n; i > 0; i--){
    array[i] = array[i-1];
    }
    array[0] = x;
    n++;
}

void inserirFim(Personagem x) {
    if (n >= MAXTAM)
    exit(1);
    array[n] = x;
    n++;
}

void inserir(Personagem x, int pos) {
    if (n >= MAXTAM || pos < 0 || pos > n)
    exit(1);
    //levar elementos para o fim do array
    for (int i = n; i > pos; i--){
    array[i] = array[i-1];
    }
    array[pos] = x;
    n++;
}

Personagem removerInicio() {
    if (n == 0)
    exit(1);
    Personagem resp = array[0];
    n--;
    for (int i = 0; i < n; i++){
    array[i] = array[i+1];
    }
    return resp;
}

Personagem removerFim() {
    if (n == 0)
    exit(1);

    return array[--n];
}

Personagem remover(int pos) {
    if (n == 0 || pos < 0 || pos >= n)
    exit(1);
    Personagem resp = array[pos];
    n--;
    for (int i = pos; i < n; i++){
    array[i] = array[i+1];
    }
    return resp;
}

void mostrar(){
    for (int i = 0; i < n; i++){
        printf("[%d ## ", i);
        imprimir(&array[i]);
    }
}

/*
    main( )
*/
int main( int argc, char* argv[] )
{
    // definir dados
    FILE* csv;
    Personagem personagens[500];
    int pos = 0;
    char linhaCSV[300];
    int linha = 0;
    char* entrada = ( char* )malloc( 100 * sizeof(char) );
    bool resultado;

    // abrir arquivo
    csv = fopen( "/tmp/characters.csv", "rt" );

    // verificacao de arquivo aberto
    if( csv == NULL ) 
    {
        perror("Erro");
    } // end if
    else 
    {
        // repeticao para percorrer todo o arquivo
        while( !feof( csv ) )
        {
            // ler linha do arquivo ate o \n
            fscanf( csv, "%[^\n]", linhaCSV );
            // ler o \n
            fgetc( csv );
            // contador da linha que esta sendo lida no CSV
            linha = linha + 1;

            // ignorar primeira e ultima linha do CSV
            if( 1 < linha && linha < 406 )
            {
                // verificar qual leitor usar
                if( procuraVirgulasDobradas( linhaCSV ) == 0 )
                {
                    // armazenar dados no array personagens
                    leitor( &personagens[pos], linhaCSV );
                    // ir para proxima posicao do array
                    pos = pos + 1;
                }
                else if( procuraVirgulasDobradas( linhaCSV ) == 1 )
                {
                    // armazenar dados no array personagens
                    leitor2( &personagens[pos], linhaCSV );
                    // ir para proxima posicao do array
                    pos = pos + 1;
                }
                else if( procuraVirgulasDobradas( linhaCSV ) == 2 )
                {
                    // armazenar dados no array personagens
                    leitor3( &personagens[pos], linhaCSV );
                    // ir para proxima posicao do array
                    pos = pos + 1;
                }
            }
        }
        
        // repeticao para controlar entradas
        do
        {
            // entrada
            scanf( "%s", entrada );
            entrada[strcspn(entrada, "\r")] = '\0';

            // verificar se entrada diferente de fim
            if( strcmp( entrada, "FIM") != 0 )
            {
                for( int i = 0; i < pos; i = i + 1 )
                {
                    if( strcmp( personagens[i].id, entrada ) == 0 )
                    {
                        inserirFim(personagens[i]);
                    }
                }
            }
        } while( strcmp( entrada, "FIM" ) != 0 );

        // ler quantidade de operacoes
        int qtdOperacoes = 0;
        scanf("%d", &qtdOperacoes);
        getchar();

        // array dos removidos
        Personagem removidos[10];
        int posRemovidos = 0;

        // controlar as operacoes
        for(int i = 0; i <= qtdOperacoes; i++) {

            scanf("%[^\n]", entrada);
            getchar();
            entrada[strcspn(entrada, "\r")] = '\0';

            // verificar qual operacao deve ser realizada
            if(entrada[0] == 'I' && entrada[1] == 'I') {

                strtok(entrada, " ");
                char* tok = strtok(NULL, "\n");
                
                for( int i = 0; i < pos; i = i + 1 )
                {
                    if( strcmp( personagens[i].id, tok ) == 0 )
                    {
                        inserirInicio(personagens[i]);
                    }
                }

            } else if(entrada[0] == 'I' && entrada[1] == 'F') {

                strtok(entrada, " ");
                char* tok = strtok(NULL, "\n");
                
                for( int i = 0; i < pos; i = i + 1 )
                {
                    if( strcmp( personagens[i].id, tok ) == 0 )
                    {
                        inserirFim(personagens[i]);
                    }
                }

            } else if(entrada[0] == 'I' && entrada[1] == '*') {

                strtok(entrada, " ");
                char* tok1 = strtok(NULL, " ");
                char* tok2 = strtok(NULL, "\n");
                int posicao = atoi(tok1);
                
                for( int i = 0; i < pos; i = i + 1 )
                {
                    if( strcmp( personagens[i].id, tok2 ) == 0 )
                    {
                        inserir(personagens[i], posicao);
                    }
                }

            } else if(entrada[0] == 'R' && entrada[1] == 'I') {

                removidos[posRemovidos] = removerInicio();
                posRemovidos = posRemovidos + 1;
            } else if(entrada[0] == 'R' && entrada[1] == 'F') {

                removidos[posRemovidos] = removerFim();
                posRemovidos = posRemovidos + 1;
            } else if(entrada[0] == 'R' && entrada[1] == '*') {

                strtok(entrada, " ");
                char* tok = strtok(NULL, "\n");
                int posicao = atoi(tok);
                removidos[posRemovidos] = remover(posicao);
                posRemovidos = posRemovidos + 1;
            }

        }

        for(int i = 0; i < posRemovidos; i++) {
            printf("(R) %s\n", removidos[i].name);
        }

        mostrar();

    }
    return 0;
}