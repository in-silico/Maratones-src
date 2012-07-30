#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstring>

using namespace std;


char buffer[54];

int posLectura = 0;
int posEscritura = 0;

void leer(int cuantos, bool imprimir)
{
    int leidos = 0;
    while(buffer[posLectura] != '\0' && (posLectura != posEscritura || leidos == 0) && leidos < cuantos)
    {
        ++leidos;
        if(imprimir)
            cout << buffer[posLectura];
        buffer[posLectura++] = '\0';
        if(posLectura > 53)
            posLectura %= 54;
    }
    if(imprimir)
        cout << "\r\n";
}

int disponible()
{
    int posET = posEscritura;
    int cuantos = 0;
    int siguiente = posET + 1;
    if(siguiente > 53)
        siguiente %= 54;
    while(buffer[posET] == '\0' && (posET != posLectura || !cuantos))
    {
        cuantos++;
        posET++;
        if(posET > 53)
            posET %= 54;
        siguiente = posET + 1;
        if(siguiente > 53)
            siguiente %= 54;
    }
    return cuantos;
}

void escribir(char *buff, int tam)
{
    int d = disponible();
    if(d < tam)
        return;
    for(int i = 0; i < tam; i++)
    {
        buffer[posEscritura] = buff[i];
        posEscritura++;
        if(posEscritura > 53)
            posEscritura %= 54;
    }
}

int main()
{
    for(int i = 0; i < 54; i++)
        buffer[i] = '\0';
    char lectura[10000];
    while(true)
    {
        cin.getline(lectura, 10000);
        int tam = strlen(lectura) - 1;
        if(tam == 0 && lectura[0] == '0')
            break;
        if(lectura[0] == 'R')
        {
            int numero = atoi(lectura + 1);
            leer(numero, false);
        }
        else
        {
            escribir(lectura + 1, tam);
        }
        int d = disponible();
        cout << posEscritura << ", " << d << "\r\n";
    }
    leer(100, true);
}