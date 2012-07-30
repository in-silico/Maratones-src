#include <iostream>
#include <string>
#include <sstream>

using namespace std;

void imprimir(int carta)
{
	int valor = (carta % 13) + 1;
	int pinta = (carta - 1) / 13;
	if(1 < valor && valor < 11)
	{
		cout << valor << " of ";
	}
	else
	{
		if(valor == 11)
		{
			cout << "Jack of ";
		}
		else if(valor == 12)
		{
			cout << "Queen of ";
		}
		else if(valor == 13)
		{
			cout << "King of ";
		}
		else if(valor == 1)
		{
			cout << "Ace of ";
		}
	}
	if(pinta == 0)
	{
		cout << "Clubs";
	}
	else if(pinta == 1)
	{
		cout << "Diamonds";
	}
	else if(pinta == 2)
	{
		cout << "Hearts";
	}
	else if(pinta == 3)
	{
		cout << "Spades";
	}
	cout << endl;
}

int main()
{
	int ncasos;
	cin >> ncasos;
	string linea;
	getline(cin, linea);
	getline(cin, linea);
	for(int k = 0; k < ncasos; k++)
	{
		getline(cin, linea);
		istringstream tokens(linea);
		int n;
		tokens >> n;
		int shuffles[n + 1][53];
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j < 53; j++)
			{
				cin >> shuffles[i][j];
			}
		}
		getline(cin, linea);
		int *baraja = new int[53];
		for(int i = 1; i < 53; i++)
		{
			baraja[i] = i;
		}
		while(getline(cin, linea) && linea != "")
		{
			int *barajaNueva = new int[53];
			istringstream tokens(linea);
			int actual;
			tokens >> actual;
			for(int i = 1; i < 53; i++)
			{
				barajaNueva[i] = baraja[shuffles[actual][i]];
			}
			baraja = barajaNueva;
		}
		for(int i = 1; i < 53; i++)
		{
			imprimir(baraja[i]);
		}
		if(k != ncasos - 1)
		{
			cout << endl;
		}
	}
}
