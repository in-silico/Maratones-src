#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

string base = "the quick brown fox jumps over the lazy dog";

char* desconocido()
{
	char *s = new char[26];
	for(int i = 0; i < 26; i++)
	{
		s[i] = '*';
	}
	return s;
}

string reemplazar(string linea, char *resultado)
{
	string nueva = "";
	for(unsigned int i = 0; i < linea.length(); i++)
	{
		if(linea[i] == ' ')
			nueva += ' ';
		else
			nueva += resultado[linea[i] - 'a'];
	}
	return nueva;
}

int main()
{
	string linea;
	int ncasos;
	cin >> ncasos;
	getline(cin, linea);
	getline(cin, linea);
	for(int i = 0; i < ncasos; i++)
	{
		string lineas[100];
		char *conversion = desconocido();
		int n = 0;
		while(getline(cin, linea) && linea != "")
		{
			lineas[n++] = linea;
		}
		if(n == 0)
		{
			getline(cin, linea);
			cout << "No solution." << endl << endl;
			continue;
		}
		bool logro = false;
		for(int j = 0; j < n; j++)
		{
			if(lineas[j].length() == base.length())
			{
				for(unsigned int k = 0; k < lineas[j].length(); k++)
				{
					if(lineas[j][k] == ' ')
					{
						if(base[k] == lineas[j][k])
							continue;
						break;
					}
					if(conversion[lineas[j][k] - 'a'] == '*' || conversion[lineas[j][k] - 'a'] == base[k])
					{
						conversion[lineas[j][k] - 'a'] = base[k];
						if(k == lineas[j].length() - 1)
						{
							logro = true;
						}
						continue;
					}
					break;
				}
			}
			if(logro)
				break;
			else
			{
				conversion = desconocido();
			}
		}
		if(logro)
		{
			for(int j = 0; j < n; j++)
			{
				cout << reemplazar(lineas[j], conversion) << endl;
			}
		}
		else
		{
			cout << "No solution." << endl;
		}
		if(i != ncasos - 1)
		{
			cout << endl;
		}
	}
}


