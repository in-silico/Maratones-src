#include <iostream>
#include <list>
#include <algorithm>
#include <cstring>

using namespace std;

int diferencia(char a)
{
    int porArriba = a - 'A';
    int porAbajo = 'Z' - a + 1;
    return min(porArriba, porAbajo);
}

int hallarMejor(char *palabra)
{
    int tam = strlen(palabra);
    int total = 0;
    for(int i = 0; i < tam; i++)
    {
        total += diferencia(palabra[i]);
    }
    int mejorActual = tam - 1;
    for(int i = 0; i < tam; i++)
    {
        if(palabra[i] == 'A')
        {
            int inicio = i;
            while(palabra[i] == 'A')
                i++;
            if(inicio == 0)
                inicio = 1;
            mejorActual = min(mejorActual, 2 * (inicio - 1) + 1 + (tam - 1) - i);
            mejorActual = min(mejorActual, (inicio - 1) + 1 + 2 * (tam - 1 - i) + (inicio > 1 ? 1 : 0));
            if(i == tam)
                mejorActual = min(mejorActual, inicio - 1);
        }
    }
//    cout << mejorActual << "<-mejor ";
    if(mejorActual < 0)
        mejorActual = 0;
    return total + mejorActual;
}

char palabra[1010];
int main()
{
    int n;
    cin >> n;
    for(int i = 0; i < n; i++)
    {
        cin >> palabra;
        cout << hallarMejor(palabra) << endl;
    }
}
