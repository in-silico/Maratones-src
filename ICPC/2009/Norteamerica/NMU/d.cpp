#include <map>
#include <utility>
#include <iostream>
#include <list>

using namespace std;

map< pair<int, int>, int > visitados;
list < pair<int, int> > bfs;
map< char, pair<int, int> > destinos;
char laberinto[21][21];

void agregar(int i, int j, int turno)
{
    pair<int, int> posible = make_pair(i, j);
    if(visitados[posible] == 0)
    {
        visitados[posible] = turno;
        bfs.push_back(posible);
    }
}

int main()
{
    int r, c;
    int caso = 1;
    while(cin >> r >> c && r && c)
    {
        cin.getline(laberinto[0], 1000);
        for(int i = 0; i < r; i++)
        {
            cin.getline(laberinto[i], 21);
        }
        visitados.clear();
        bfs.clear();
        destinos.clear();
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(laberinto[i][j] >= 'a' && laberinto[i][j] <= 'z')
                {
                    destinos[laberinto[i][j]] = make_pair(i, j);
                }

            }
        }
        bfs.push_back(make_pair(0, 0));
        visitados[make_pair(0, 0)] = 1;
        while(!bfs.empty())
        {
            pair <int, int> nuevo = bfs.front();
            bfs.pop_front();
            if(nuevo.first == r - 1 && nuevo.second == c - 1)
                break;
            if(laberinto[nuevo.first][nuevo.second] == '*')
                continue;
            int turno = visitados[nuevo] + 1;
            if(laberinto[nuevo.first][nuevo.second] >= 'A' && laberinto[nuevo.first][nuevo.second] <= 'Z')
            {
                agregar(destinos['a' + (laberinto[nuevo.first][nuevo.second] - 'A')].first, destinos['a' + (laberinto[nuevo.first][nuevo.second] - 'A')].second, turno);
            }
            if(nuevo.first > 0)
            {
                agregar(nuevo.first - 1, nuevo.second, turno);
            }
            if(nuevo.first < r - 1)
            {
                 agregar(nuevo.first + 1, nuevo.second, turno);
            }
            if(nuevo.second > 0)
            {
                agregar(nuevo.first, nuevo.second - 1, turno);
            }
            if(nuevo.second < c - 1)
            {
                agregar(nuevo.first, nuevo.second + 1, turno);
            }
        }
        cout << "Case " << caso++ << ": The maze can be solved in " << visitados[make_pair(r - 1, c - 1)] - 1 << " move(s).\r\n";
    }
}