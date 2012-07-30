#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstring>

using namespace std;


char buffer[54];

int posLectura = 0;
int posEscritura = 0;

int lis(char entrada[1000][20], int numero)
{
    int valores[numero];
    for(int i = 0; i < numero; i++)
        valores[i] = 0;
    int mejorM = 0;
    for(int i = 0; i < numero; i++)
    {
        int mejor = 0;
        for(int j = 0; j < i; j++)
        {
            if(strcmp(entrada[j], entrada[i]) <= 0)
                mejor = max(mejor, valores[j]);
        }
        valores[i] = mejor + 1;
        mejorM = max(mejorM, valores[i]);
    }
    return numero - mejorM;
}

int main()
{
    char entrada[1000][20];
    int n = 0;
    int caso = 1;
    while(cin >> n && n)
    {
        for(int i = 0; i < n; i++)
            cin >> entrada[i];
        cout << "Case " << caso++ << ": You only need to remove " << lis(entrada, n) << " word(s)!" << endl;
    }
}