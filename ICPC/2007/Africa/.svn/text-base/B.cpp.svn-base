#include <cstdio>
#include <cstring>


char digitos[1000009];
char solucion[1000009];

void solucionar(int tam)
{
    int cuenta = tam - 3;
    solucion[cuenta + 1] = '\0';
    solucion[cuenta--] = digitos[tam - 1];
    char actual = digitos[tam - 1];
    for(int i = tam - 2; i >= 2; i--)
    {
        if(digitos[i] - actual < 0)
        {
            int j;
            for(j = i - 1; digitos[j] == '0' && j >= 0; j--);
            digitos[j]--;
            j++;
            for(; j != i; j++)
                digitos[j] = '9';
            char act = digitos[i];
            solucion[cuenta--] = 10 + digitos[i] - actual + '0';
            actual = solucion[cuenta + 1];
        }
        else
        {
            solucion[cuenta--] = actual = digitos[i] - actual + '0';
        }
    }
}
int main()
{
    int iteracion = 1;
    while(true)
    {
        digitos[0] = '1';
        digitos[1] = '0';
        scanf("%s", digitos + 2);
        int tam = strlen(digitos);
        if(tam == 3 && digitos[2] == '0')
            return 0;
        solucionar(tam);
        if(solucion[0] == '0')
            printf("%i. IMPOSSIBLE\n", iteracion++);
        else
            printf("%i. %s\n", iteracion++, solucion);
    }
}

