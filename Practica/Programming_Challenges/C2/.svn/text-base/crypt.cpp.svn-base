#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector <string> diccionario[17];

char* desconocido()
{
	char *s = new char[26];
	for(int i = 0; i < 26; i++)
	{
		s[i] = '*';
	}
	return s;
}

bool esDesconocido(char *siguiente)
{
	for(int i = 0; i < 26; i++)
	{
		if(siguiente[i] != '*')
			return false;
	}
	return true;
}

char* copia(char *anterior)
{
	char *nuevo = new char[26];
	for(int i = 0; i < 26; i++)
	{
		nuevo[i] = anterior[i];
	}
	return nuevo;
}

bool contiene(char *actual, char c)
{
	for(int i = 0; i < 26; i++)
	{
		if(actual[i] == c)
			return true;
	}
	return false;
}

char* buscar(string *palabras, char *anterior)
{
	if(*palabras == "")
		return anterior;
	string palabraActual = *palabras;
	for(unsigned int i = 0; i < diccionario[palabraActual.length()].size(); i++)
	{
		char *actual = copia(anterior);
		bool termino = true;
		for(unsigned int j = 0; j < diccionario[palabraActual.length()][i].length(); j++)
		{
			if(actual[palabraActual[j] - 'a'] == '*')
			{
				if(!contiene(actual, diccionario[palabraActual.length()][i][j]))
				{
					actual[palabraActual[j] - 'a'] = diccionario[palabraActual.length()][i][j];
				}
				else
				{
					termino = false;
					break;
				}
			}
			else if(!(actual[palabraActual[j] - 'a'] == diccionario[palabraActual.length()][i][j]))
			{
				termino = false;
				break;
			}
		}
		if(termino == true)
		{
			char *siguiente = buscar(palabras + 1, actual);
			if(esDesconocido(siguiente))
				continue;
			else
				return siguiente;
		}
	}
	return desconocido();
}

string reemplazar(string linea, char* resultado)
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
	int n;
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		string palabra;
		cin >> palabra;
		diccionario[palabra.length()].push_back(palabra);
	}
	string linea;
	getline(cin, linea);
	while(getline(cin, linea))
	{
		if(linea == "")
		{
			cout << endl;
			continue;
		}
		string *palabras = new string[80];
		for(int i = 0; i < 80; i++)
		{
			palabras[i] = "";
		}
		istringstream tokens(linea);
		string *actual = palabras;
		while(tokens >> *actual++);
		char *resultado = buscar(palabras, desconocido());
		cout << reemplazar(linea, resultado) << endl;
	}

}
