#include <iostream>
#include <algorithm>

using namespace std;

struct Equipo
{
	int juegos;
	int puntos;
	int numeroJugados[41];
	int puntosPosibles;
	int numero;

	bool operator<(const Equipo &a) const
	{
		return puntosPosibles < a.puntosPosibles;
	}
};

Equipo equipos[41];

int main()
{
	int n, m, g;
	while(true)
	{
		cin >> n >> m >> g;
		if(n == 0 && m == 0 && g == 0)
			return 0;
		int juegosTotales = (n - 1) * m;
		for(int i = 0; i < n; i++)
		{
			Equipo a;
			a.numero = i;
			a.juegos = 0;
			a.puntos = 0;
			for(int j = 0; j < 41; j++)
			{
				a.numeroJugados[j] = 0;
			}
			equipos[i] = a;
		}
		for(int i = 0; i < g; i++)
		{
			int i, j;
			char c;
			cin >> i >> c >> j;
			if(c == '=')
			{
				equipos[i].puntos += 1;	
				equipos[j].puntos += 1;
			}
			else
			{
				equipos[j].puntos += 2;
			}
			equipos[i].juegos += 1;	
			equipos[j].juegos += 1;
			equipos[i].numeroJugados[j]++;
			equipos[j].numeroJugados[i]++;
		}
		for(int i = 1; i < n; i++)
		{
			while(equipos[0].numeroJugados[i] != m)
			{
				equipos[0].puntos += 2;
				equipos[0].numeroJugados[i]++;
				equipos[i].juegos++;
			}
		}
		int puntosMio = equipos[0].puntos;
		for(int i = 0; i < n - 1; i++)
		{
			equipos[i] = equipos[i + 1];
		}
		bool perdio = false;
		n = n - 1;
		while(true)
		{
			for(int j = 0; j < n; j++)
			{
				equipos[j].puntosPosibles = equipos[j].puntos + (juegosTotales - equipos[j].juegos);
			}
			sort(equipos, equipos + n);
			Equipo *mayor = &equipos[n - 1];
			Equipo *menor = &equipos[0];
			int numMenor = menor->numero;
			int posMenor = 0;
			if(mayor->puntos >= puntosMio)
			{
				perdio = true;
				break;
			}
			if(mayor->puntosPosibles < puntosMio)
			{
				break;
			}
			while(posMenor < n && mayor->numeroJugados[numMenor] == m && menor->numeroJugados[mayor->numero] == m)
			{
				if(posMenor == n - 1)
				{
					posMenor++;
					break;
				}
				menor = &equipos[++posMenor];
				numMenor = menor->numero;
			}
			if(posMenor == n)
			{
				perdio = true;
				break;
			}
			menor->puntos += 2;
			menor->numeroJugados[mayor->numero]++;
			mayor->numeroJugados[menor->numero]++;
			menor->juegos++;
			mayor->juegos++;
		}
		if(perdio)
			cout << "N" << endl;
		else
			cout << "Y" << endl;
	}
}
