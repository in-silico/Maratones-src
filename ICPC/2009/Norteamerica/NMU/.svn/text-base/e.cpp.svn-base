#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <cstring>

using namespace std;

char matriz[500][500];

bool imprimir(int col)
{
    int ultimo = -1;
    for(int i = 499; i >= 0; i--)
        if(matriz[col][i] != ' ')
        {
            ultimo = i;
            break;
        }
    if(ultimo == -1)
        return false;
    for(int i = 0; i <= ultimo; i++)
        cout << matriz[col][i];
    cout << "\r\n";
    return true;
}

int main()
{
    int n;
    while(cin >> n && n)
    {
        for(int i = 0; i < 500; i++)
        {
            for(int j = 0; j < 500; j++)
            {
                matriz[i][j] = ' ';
            }
        }
        int iActual = 0;
        int jActual = -1;
        for(int i = 0; i < 2 * n; i++)
        {
            matriz[iActual][++jActual] = '-';
        }
        for(int i = 0; i < n; i++)
        {
            matriz[++iActual][jActual] = '|';
        }
        iActual++;
        jActual++;
        for(int i = 0; i < 2 * n; i++)
        {
            matriz[iActual][--jActual] = '-';
        }
        for(int i = 0; i < n; i++)
        {
            matriz[++iActual][jActual] = '|';
        }
        iActual++;
        jActual--;
        for(int i = 0; i < 2 * n; i++)
        {
            matriz[iActual][++jActual] = '-';
        }
        iActual = 0; jActual = 4 * n;
        for(int i = 0; i < n; i++)
        {
            matriz[++iActual][jActual] = '|';
        }
        iActual++;
        jActual--;
        for(int i = 0; i < 2 * n; i++)
        {
            matriz[iActual][++jActual] = '-';
        }
        for(int i = 0; i < n; i++)
        {
            matriz[--iActual][jActual] = '|';
        }
        for(int i = 0; i < n; i++)
        {
            ++iActual;
        }
        for(int i = 0; i < n; i++)
        {
            matriz[++iActual][jActual] = '|';
        }
        for(int i = 0; i < 500; i++)
        {
            if(!imprimir(i))
                break;
        }
        cout << "\r\n";
    }
}