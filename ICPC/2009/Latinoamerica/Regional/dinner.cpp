#include <iostream>
#include <algorithm>

using namespace std;

struct Entrada
{
	int h, m, s;
	char e;
	int act;
	bool iniciada;
	bool operator<(const Entrada &o) const
	{
		if(h == o.h)
		{
			if(m == o.m)
			{
				return s < o.s;
			}
			return m < o.m;
		}
		return h < o.h;
	}
};

Entrada entradas[65000];
int n;

int numeroFinal()
{
	for(int i = 1; i < n; i++)
	{
		if(!entradas[i].iniciada)
		{
			entradas[i].e = 'E';
		}
		if(entradas[i].e == 'E')
		{
			entradas[i].act = entradas[i - 1].act + 1;
		}
		else
		{
			entradas[i].act = entradas[i - 1].act - 1;
		}
	}
	return entradas[n - 1].act;
}

void arreglar(int final)
{
	if(final % 2 != 0)
	{
		while(final++)
		{
			cout << "perdi";
			if(final == 10000)
				final = 1;
		}
	}
	for(int i = n - 1; i >= 0; i--)
	{
		if(final <= 0)
			break;
		if(entradas[i].iniciada == true)
			continue;
		entradas[i].e = 'X';
		final -= 2;
	}
}

int simular()
{
	int maximoNumero = 1;
	for(int i = 1; i < n; i++)
	{
		if(entradas[i].e == 'X')
		{
			entradas[i].act = entradas[i - 1].act - 1;
		}
		else
		{
			entradas[i].act = entradas[i - 1].act + 1;
		}
		if(entradas[i].act > maximoNumero)
			maximoNumero = entradas[i].act;
	}
	return maximoNumero;
}
char hms[20];

int main()
{

	cin >> n;
	while(n)
	{
		for(int i = 0; i < n; i++)
		{
			Entrada a;
			cin >> hms;
			a.h = hms[1] - '0';
			a.h += 10 * (hms[0] - '0');
			a.m = hms[4] - '0';
			a.m += 10 * (hms[3] - '0');
			a.s = hms[7] - '0';
			a.s += 10 * (hms[6] - '0');
			cin >> a.e;
			a.iniciada = a.e != '?';
			entradas[i] = a;
		}
		sort(entradas, entradas + n);
		entradas[0].act = 1;
		entradas[0].e = 'E';
		entradas[0].iniciada = true;
		entradas[n - 1].e = 'X';
		entradas[n - 1].iniciada = true;
		int final = numeroFinal();
		arreglar(final);
		cout << simular() << endl;
		cin >> n;
	}

}
