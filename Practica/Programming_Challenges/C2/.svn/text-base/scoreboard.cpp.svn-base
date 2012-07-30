#include <iostream>
#include <string>
#include <sstream>

using namespace std;

struct equipo
{
	int tiempo;
	int numero;
	int nequipo;
};

int comparar(const void *a1, const void *b1)
	{
		equipo *a2 = (equipo*) a1;
		equipo *b2 = (equipo*) b1;
		equipo a = *a2;
		equipo b = *b2;
		if(a.numero == b.numero)
		{
			if(a.tiempo == b.tiempo)
				return b.nequipo - a.nequipo;
			return b.tiempo - a.tiempo;
		}
		return a.numero - b.numero;
	}

int main()
{
	int ncasos;
	string linea;
	cin >> ncasos;
	getline(cin, linea);
	getline(cin, linea);
	for(int i = 1; i <= ncasos; i++)
	{
		int equipos[101][2];
		int problemas[101][10];
		for(int j = 0; j < 101; j++)
		{
			for(int k = 0; k < 2; k++)
			{
				equipos[j][k] = 0;
			}
		}
		for(int j = 0; j < 101; j++)
		{
			for(int k = 0; k < 10; k++)
			{
				problemas[j][k] = 0;
			}
		}
		while(getline(cin, linea))
		{
			istringstream tokens(linea);
			int a, b, c;
			char d;
			if(!(tokens >> a >> b >> c >> d))
				break;
			if(d != 'I' && d != 'C')
			{
				equipos[a][0] = 1;
				continue;
			}
			if(problemas[a][b] == 1)
			{
				continue;
			}
			if(d == 'I')
			{
				problemas[a][b]--;
				equipos[a][0] = 1;
			}
			else
			{
				equipos[a][1] -= (problemas[a][b] * 20) - c;
				problemas[a][b] = 1;
				equipos[a][0] = 1;
			}
		}
		equipo respuesta[101];
		for(int j = 0; j < 101; j++)
		{
			if(equipos[j][0])
			{

				int acum = 0;
				for(int k = 1; k < 10; k++)
				{
					if(problemas[j][k] == 1)
						acum++;
				}
				respuesta[j].numero = acum;
				respuesta[j].tiempo = equipos[j][1];
				respuesta[j].nequipo = j;
			}
			else
			{
				respuesta[j].numero = INT_MIN + 10;
				respuesta[j].tiempo = INT_MIN + 10;
				respuesta[j].nequipo = INT_MIN;
			}
		}
		qsort(respuesta, sizeof(respuesta) / sizeof(equipo), sizeof(equipo), comparar);
		for(int j = 100; j > -1; j--)
		{
			if(respuesta[j].nequipo != INT_MIN)
			{
				cout << respuesta[j].nequipo << " " << respuesta[j].numero << " " << respuesta[j].tiempo << endl;
			}
		}
		if(i != ncasos)
		{
			cout << endl;
		}
	}
}
