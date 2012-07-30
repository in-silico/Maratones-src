#include <iostream>
#include <map>
#include <cstdlib>

using namespace std;

char land[1010][1010];
int cols[1010][1010];
int mejor[1010][1010];
map <int, int> mapa;
map <int, int> mapaFila;
int ultimoSwamp;
int n,  m;

int solucionar(int fila, int columna)
{
	if(land[fila][columna] == '#')
	{
		mapaFila.clear();
		ultimoSwamp = columna + 1;
		return 0;
	}
	int filaActual = cols[fila][columna];
	if(!mapaFila.empty())
		mapaFila.erase(mapaFila.lower_bound(0), mapaFila.lower_bound(filaActual));
	mapaFila[filaActual] = columna;
	if(columna == 0)
		return mejor[fila][columna] = ((fila - filaActual + 1) << 1) + 2;
	int columnaAnterior = mapaFila.upper_bound(filaActual) == mapaFila.end() ? -1 : (*mapaFila.upper_bound(filaActual)).second;
	if(columnaAnterior == -1)
		return mejor[fila][columna] = ((fila - filaActual + 1) << 1) + ((columna - ultimoSwamp + 1) << 1);
	int posible = ((fila - filaActual + 1) << 1) + ((columna - columnaAnterior) << 1);
	int anterior = mejor[fila][columnaAnterior] + ((columna - columnaAnterior) << 1);
	return mejor[fila][columna] = max(posible, anterior);
}

int main()
{
	int ntc;
	cin >> ntc;
	for(int aa = 0; aa < ntc; aa++)
	{
		mapa.clear();
		cin >> n >> m;
		cin.getline(land[0], 1000);
		for(int i = 0; i < n; i++)
			cin.getline(land[i], 1001);
		for(int i = 0; i < m; i++)
		{
			int anterior = 0;
			for(int j = 0; j < n; j++)
			{
				if(land[j][i] == '#')
				{
					anterior = j + 1;
					cols[j][i] = j;
				}
				else
					cols[j][i] = anterior;
			}
		}
		for(int i = 0; i < n; i++)
		{
			mapaFila.clear();
			ultimoSwamp = 0;
			for(int j = 0; j < m; j++)
				mapa[solucionar(i, j)]++;
		}
		for(map<int, int>::iterator it = mapa.begin(); it != mapa.end(); it++)
		{
			if((*it).first != 0)
				cout << (*it).second << " x " << (*it).first << endl;
		}
	}
}

