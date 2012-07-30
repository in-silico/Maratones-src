#include <iostream>
#include <string>
#include <cstring>
#include <queue>

using namespace std;

struct Entrada
{
      int i, j, maximo, pasos;
      
      Entrada(int ii, int jj, int maximoi, int pasosi)
      {
            i = ii;
            j = jj;
            maximo = maximoi;
            pasos = pasosi;
      }
};


int diff[] = {1, 0, -1, 0, 0, 1, 0, -1};

int main()
{
      string trampas;
      while(cin >> trampas)
      {
            int h, w;
            cin >> w >> h;
            int mapa[h][w];
            for(int i = 0; i < h; i++)
                  for(int j = 0; j < w; j++)
                  {
                        char e;
                        cin >> e;
                        if(e == 'o')
                            mapa[i][j] = 0;
                        else if(e == 'x')
                            mapa[i][j] = -1;
                        else
                            mapa[i][j] = trampas.find(e) + 1;
                  }
            int  ci, fi, cf, ff;
            cin >> ci >> fi;
            cin >> cf >> ff;
            int maximoi = -1;
            if (mapa[fi][ci] != -1) 
                maximoi = mapa[fi][ci];
            bool visitados[h][w][28];
            for(int i = 0; i < h; i++)
                  for(int j = 0; j < w; j++)
                        for(int k = 0; k < 28; k++)
                              visitados[i][j][k] = false; 
            bool termino = false;
            queue <Entrada> cola;
            if(maximoi != -1)
            {
                visitados[fi][ci][maximoi] = true;
                cola.push(Entrada(fi, ci, maximoi, 0));
            }
            while(!cola.empty())
            {
                  Entrada actual = cola.front();
                  cola.pop();
                  if (actual.i == ff && actual.j == cf)
                  {
                        cout << actual.pasos << endl;
                        termino = true;
                        break;
                  }
                  for(int k = 0; k < 4; k++)
                  {
                        int in = actual.i + diff[k * 2 + 0];
                        int jn = actual.j + diff[k * 2 + 1];
                        if(in < 0 || jn < 0 || in >= h || jn >= w || mapa[in][jn] == -1 || (mapa[in][jn] != 0 && mapa[in][jn] <= actual.maximo))
                            continue;
                        int maximon = actual.maximo;
                        if(maximon < mapa[in][jn])
                            maximon = mapa[in][jn];
                        if(!visitados[in][jn][maximon])
                        {
                            visitados[in][jn][maximon] = true;  
                            cola.push(Entrada(in, jn, maximon, actual.pasos + 1));
                        }
                  }
            }
            if(!termino)
                cout << "IMPOSSIBLE" << endl;
      }
      return 0;
}
