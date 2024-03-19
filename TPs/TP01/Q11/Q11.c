#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isPalindromo(char palavra[], int i, int j) {
    if (i >= j) {
        return true;
    }

    if (palavra[i] != palavra[j]) {
        return false;
    }

    return isPalindromo(palavra, i + 1, j - 1);
}

int main() {
    char palavra[1000];
    while (true) {
        scanf(" %[^\n]", palavra);

        if (strcmp(palavra, "FIM") == 0) {
            break;
        }

        int tam = strlen(palavra);
        int i =0;
        if (isPalindromo(palavra, i, tam - 1)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }

    return 0;
}
