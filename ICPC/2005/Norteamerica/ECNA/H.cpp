#include <cstdlib>
#include <iostream>
#include <cstring>

using namespace std;


bool tablero[1000][1000];
bool estorbo[1000][1000];
int n, m;

inline bool visitar(int i, int j)
{
    if(i >= n || i < 0 || j >= m || j < 0 || estorbo[i][j])
        return true;
    tablero[i][j] = true;
    return false;
}

struct Punto
{
    int x, y;
};

Punto reinas[100];
Punto caballos[100];

int main()
{
    int caso = 1;
    while(true)
    {
        cin >> n >> m;
        if(n == 0 && m == 0)
            break;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
            {
                tablero[i][j] = false;
                estorbo[i][j] = false;
            }
        int q;
        cin >> q;
        for(int i = 0; i < q; i++)
        {
            cin >> reinas[i].x >> reinas[i].y;
            reinas[i].x--;
            reinas[i].y--;
            visitar(reinas[i].x, reinas[i].y);
            estorbo[reinas[i].x][reinas[i].y] = true;
        }
        int k;
        cin >> k;
        for(int i = 0; i < k; i++)
        {
            cin >> caballos[i].x >> caballos[i].y;
            caballos[i].x--;
            caballos[i].y--;
            visitar(caballos[i].x, caballos[i].y);
            estorbo[caballos[i].x][caballos[i].y] = true;
        }
        int p;
        cin >> p;
        for(int i = 0; i < p; i++)
        {
            int x, y;
            cin >> x >> y;
            x--;
            y--;
            visitar(x, y);
            estorbo[x][y] = true;
        }
        for(int i = 0; i < q; i++)
        {
            Punto & actual = reinas[i];
            for(int i = actual.x + 1; true; i++)
            {
                if(visitar(i, actual.y))
                    break;
            }
            for(int i = actual.x - 1; true; i--)
            {
                if(visitar(i, actual.y))
                    break;
            }
            for(int i = actual.y - 1; true; i--)
            {
                if(visitar(actual.x, i))
                    break;
            }
            for(int i = actual.y + 1; true; i++)
            {
                if(visitar(actual.x, i))
                    break;
            }
            int a = actual.x;
            int b = actual.y;
            while(true)
            {
                a++;
                b++;
                if(visitar(a, b))
                    break;
            }
            a = actual.x;
            b = actual.y;
            while(true)
            {
                a++;
                b--;
                if(visitar(a, b))
                    break;
            }
            a = actual.x;
            b = actual.y;
            while(true)
            {
                a--;
                b++;
                if(visitar(a, b))
                    break;
            }
            a = actual.x;
            b = actual.y;
            while(true)
            {
                a--;
                b--;
                if(visitar(a, b))
                    break;
            }
        }
        for(int i = 0; i < k; i++)
        {
            Punto & actual = caballos[i];
            visitar(actual.x + 1, actual.y + 2);
            visitar(actual.x - 1, actual.y + 2);
            visitar(actual.x + 1, actual.y - 2);
            visitar(actual.x - 1, actual.y - 2);
            visitar(actual.x + 2, actual.y + 1);
            visitar(actual.x - 2, actual.y + 1);
            visitar(actual.x + 2, actual.y - 1);
            visitar(actual.x - 2, actual.y - 1);
        }
        int cuenta = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(!tablero[i][j])
                {
                    cuenta++;
                }
            }
        }

        cout << "Board " << caso++ << " has " << cuenta << " safe squares." << endl;
    }
}