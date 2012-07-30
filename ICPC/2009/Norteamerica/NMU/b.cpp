#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <cstring>

#define ARRIBA 1000
#define ABAJO 1001
#define ESPACIO 1002
#define LEFT 0
#define RIGHT 1
#define UP 2
#define DOWN 3

using namespace std;

int matriz[22][22];
bool visitados[22][22];


void visitar(int i, int j, int dir)
{
    int idiff = 0, jdiff = 0;
    if(dir == LEFT)
        jdiff--;
    else if(dir == RIGHT)
        jdiff++;
    else if(dir == UP)
        idiff--;
    else if(dir == DOWN)
        idiff++;
    if(matriz[i][j] == ESPACIO)
    {
        visitar(i + idiff, j + jdiff, dir);
        return;
    }
    else if(matriz[i][j] == ARRIBA)
    {
        if(dir == LEFT)
            dir = DOWN;
        else if(dir == RIGHT)
            dir = UP;
        else if(dir == UP)
            dir = RIGHT;
        else if(dir == DOWN)
            dir = LEFT;
    }
    else if(matriz[i][j] == ABAJO)
    {
        if(dir == LEFT)
            dir = UP;
        else if(dir == RIGHT)
            dir = DOWN;
        else if(dir == UP)
            dir = LEFT;
        else if(dir == DOWN)
            dir = RIGHT;
    }
    else
    {
        visitados[i][j] = true;
        cout << matriz[i][j] << "\r\n";
        return;
    }
    idiff = 0, jdiff = 0;
    if(dir == LEFT)
        jdiff--;
    else if(dir == RIGHT)
        jdiff++;
    else if(dir == UP)
        idiff--;
    else if(dir == DOWN)
        idiff++;
    visitar(i + idiff, j + jdiff, dir);
        return;

}

int main()
{
    int r, c;
    int nCaso = 1;
    while ((cin >> r >> c) && r && c)
    {
        cout << "Case " << nCaso++ << "\r\n";
        char ini[10];
        cin.getline(ini, 10, '\n');
        int cuenta = 1;
        for(int i = 1; i < c + 1; i++)
        {
            matriz[0][i] = cuenta++;
        }
        for(int i = 1; i < r + 1; i++)
        {
            matriz[i][c + 1] = cuenta++;
        }
        for(int i = c; i >= 1; i--)
        {
            matriz[r + 1][i] = cuenta++;
        }
        for(int i = r; i >= 1; i--)
        {
            matriz[i][0] = cuenta++;
        }
        for(int i = 0; i < 22; i++)
            for(int j = 0; j < 22; j++)
                visitados[i][j] = false;
        for(int i = 1; i < r + 1; i++)
        {
            char entrada[50];
            cin.getline(entrada + 1, 50, '\n');
            for(int j = 1; j < c + 1; j++)
            {
                if(entrada[j] == ' ')
                    matriz[i][j] = ESPACIO;
                else if(entrada[j] == '/')
                    matriz[i][j] = ARRIBA;
                else
                    matriz[i][j] = ABAJO;
            }
        }
//        for(int i = 0; i < r + 2; i++)
//        {
//            for(int j = 0; j < c + 2; j++)
//            {
//                if(matriz[i][j] == ESPACIO)
//                    cout << " ";
//                else if(matriz[i][j] == ARRIBA)
//                    cout << "/";
//                else if(matriz[i][j] == ABAJO)
//                    cout << "\\";
//                else
//                    cout << matriz[i][j] << " ";
//            }
//            cout << endl;
//        }
        for(int i = 1; i < c + 1; i++)
        {
            if(!visitados[0][i])
            {
                visitados[0][i] = true;
                cout << matriz[0][i] << "<-->";
                visitar(1, i, DOWN);
            }
        }
        for(int i = 1; i < r + 1; i++)
        {
            if(!visitados[i][c + 1])
            {
                visitados[i][c + 1] = true;
                cout << matriz[i][c + 1] << "<-->";
                visitar(i, c, LEFT);
            }
        }
        for(int i = c; i >= 1; i--)
        {
            if(!visitados[r + 1][i])
            {
                visitados[r + 1][i] = true;
                 cout << matriz[r + 1][i] << "<-->";
                visitar(r, i, UP);
            }
            matriz[r + 1][i] = cuenta++;
        }
        for(int i = r; i >= 1; i--)
        {
            if(!visitados[i][0])
            {
                visitados[i][0] = true;
                cout << matriz[i][0] << "<-->";
                visitar(i, 1, RIGHT);
            }
        }
        cout << "\r\n";
    }
}
