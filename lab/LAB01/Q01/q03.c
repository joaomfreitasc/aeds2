#include <stdio.h>
#include <string.h>

int main()
{
  char string[1000];
  int qt = 0;
  fgets(string, 1000, stdin);
  while (strcmp(string, "FIM\n") != 0)
  {
    qt=0;
    for (int i = 0; i < strlen(string); i++)
    {
      if (string[i] >= 'A' && string[i] <= 'Z')
      {
        qt++;
      }
    }
    printf("%i\n", qt);
    fgets(string, 1000, stdin);
  }

  return 0;
}