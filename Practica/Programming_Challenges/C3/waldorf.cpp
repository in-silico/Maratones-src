#include <iostream>
#include <string>
#include <sstream>

using namespace std;

char sopa[51][51];
int m, n;

bool buscarHorizontal(string palabra, int i, int j)
{
	 unsigned int p = 0;
	 int jtemp = j + 1;
	 while(palabra[++p] == sopa[i][jtemp] && ((++jtemp <= n) || (!p++)));
	 if(p == palabra.length())
		 return true;
	 jtemp = j - 1;
	 p = 0;
	 while(palabra[++p] == sopa[i][jtemp] && ((--jtemp > 0) || (!p++)));
	 if(p == palabra.length())
		 return true;
	 return false;
}

bool buscarVertical(string palabra, int i, int j)
{
	 unsigned int p = 0;
	 int itemp = i + 1;
	 while(palabra[++p] == sopa[itemp][j] && ((++itemp <= m) || (!p++)));
	 if(p == palabra.length())
		 return true;
	 itemp = i - 1;
	 p = 0;
	 while(palabra[++p] == sopa[itemp][j] && ((--itemp > 0) || (!p++)));
	 if(p == palabra.length())
		 return true;
	 return false;
}

bool buscarDiagonal1(string palabra, int i, int j)
{
	 unsigned int p = 0;
	 int itemp = i + 1;
	 int jtemp = j + 1;
	 while(palabra[++p] == sopa[itemp][jtemp] && ((++itemp <= m && ++jtemp <= n) || (!p++)));
	 if(p == palabra.length())
		 return true;
	 itemp = i - 1;
	 jtemp = j - 1;
	 p = 0;
	 while(palabra[++p] == sopa[itemp][jtemp] && ((--itemp > 0 && --jtemp > 0) || (!p++)));
	 if(p == palabra.length())
		 return true;
	 return false;
}

bool buscarDiagonal2(string palabra, int i, int j)
{
	 unsigned int p = 0;
	 int itemp = i + 1;
	 int jtemp = j - 1;
	 while(palabra[++p] == sopa[itemp][jtemp] && ((++itemp <= m && --jtemp > 0) || (!p++)));
	 if(p == palabra.length())
		 return true;
	 itemp = i - 1;
	 jtemp = j + 1;
	 p = 0;
	 while(palabra[++p] == sopa[itemp][jtemp] && ((--itemp > 0 && ++jtemp <= n) || (!p++)));
		 if(p == palabra.length())
			 return true;
	 return false;
}


int main()
{
	string linea;
	getline(cin, linea);
	istringstream tokens(linea);
	int ncasos;
	tokens >> ncasos;
	for(int k = 0; k < ncasos; k++)
	{
		getline(cin, linea);
		getline(cin, linea);
		istringstream tokens1(linea);
		tokens1 >> m >> n;
		for(int i = 1; i <= m; i++)
		{
			getline(cin, linea);
			istringstream tokens(linea);
			for(int j = 1; j <= n; j++)
			{
				char actual;
				tokens >> actual;
				if(actual >= 'A' && actual <= 'Z')
				{
					actual -= 'A' - 'a';
				}
				sopa[i][j] = actual;
			}
		}
		int npalabras;
		getline(cin, linea);
		istringstream tokens2(linea);
		tokens2 >> npalabras;
		string palabras[npalabras];
		for(int i = 0; i < npalabras; i++)
		{
			getline(cin, linea);
			istringstream tokens(linea);
			string actual;
			tokens >> actual;
			for(unsigned int j = 0; j < actual.length(); j++)
				if(actual[j] >= 'A' && actual[j] <= 'Z')
				{
					actual[j] -= 'A' - 'a';
				}
			palabras[i] = actual;
		}
		for(int l = 0; l < npalabras; l++)
		{
			bool termino = false;
			int it = 0, jt = 0;
			string palabra = palabras[l];
			char inicial = palabra[0];
			for(int i = 1; i <= m; i++)
			{
				for(int j = 1; j <= n; j++)
				{
					if(sopa[i][j] == inicial)
					{
						if(buscarHorizontal(palabra, i, j) || buscarVertical(palabra, i, j) || buscarDiagonal1(palabra, i, j) || buscarDiagonal2(palabra, i, j))
						{
							termino = true;
							it = i;
							jt = j;
							break;
						}
					}
				}
				if(termino)
				{
					cout << it << " " << jt << endl;
					break;
				}
			}
		}
		if(k != ncasos - 1)
			cout << endl;
	}
}
