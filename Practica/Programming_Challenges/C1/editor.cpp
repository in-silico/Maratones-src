#include <iostream>
#include <string>
#include <sstream>


using namespace std;

void llenar(char matriz[][1000], int x1, int y1)
{
	for(int i = 1; i < x1 + 1; i++)
	{
		for(int j = 1; j < y1 + 1; j++)
		{
			matriz[i][j] = 'O';
		}
	}
}

void llenarRegion(char matriz[][1000], int x1, int y1, char nuevo, char actual, int x, int y)
{
	if(x1 <= x && y1 <= y && x1 > 0 && y1 > 0 && matriz[x1][y1] == actual)
	{
		matriz[x1][y1] = nuevo;
		llenarRegion(matriz, x1 + 1, y1, nuevo, actual, x, y);
		llenarRegion(matriz, x1 - 1, y1, nuevo, actual, x, y);
		llenarRegion(matriz, x1, y1 + 1, nuevo, actual, x, y);
		llenarRegion(matriz, x1, y1 - 1, nuevo, actual, x, y);
	}
}


int main()
{
	int x = 250, y = 250;
	char matriz[1000][1000];
	string actual;
	while(true)
	{
		getline(cin, actual);
		istringstream tokens(actual);
		string instruccion;
		tokens >> instruccion;
		if(instruccion == "I")
		{
			tokens >> x;
			tokens >> y;
			llenar(matriz, x, y);
		}
		else if(instruccion == "C")
		{
			llenar(matriz, x, y);
		}
		else if(instruccion == "L")
		{
			int a, b;
			char c;
			tokens >> a >> b >> c;
			matriz[a][b] = c;
		}
		else if(instruccion == "V")
		{
			int a, b, c;
			char d;
			tokens >> a >> b >> c >> d;
			if(b > c)
			{
				int temp = b;
				b = c;
				c = temp;
			}
			for(int i = b; i < c + 1; i++)
			{
				matriz[a][i] = d;
			}
		}
		else if(instruccion == "H")
		{
			int a, b, c;
			char d;
			tokens >> a >> b >> c >> d;
			if(a > b)
			{
				int temp = a;
				a = b;
				b = temp;
			}
			for(int i = a; i < b + 1; i++)
			{
				matriz[i][c] = d;
			}
		}
		else if(instruccion == "K")
		{
			int a, b, c, d;
			char e;
			tokens >> a >> b >> c >> d >> e;
			for(int i = a; i < c + 1; i++)
			{
				for(int j = b; j < d + 1; j++)
				{
					matriz[i][j] = e;
				}
			}
		}
		else if(instruccion == "F")
		{
			int a, b;
			char c;
			tokens >> a >> b >> c;
			char d = matriz[a][b];
			if(d != c)
			{
				llenarRegion(matriz, a, b, c, d, x, y);
			}
		}
		else if(instruccion == "S")
		{
			string archivo;
			tokens >> archivo;
			cout << archivo << endl;
			for(int i = 1; i < y + 1; i++)
			{
				for(int j = 1; j < x + 1; j++)
				{
					cout << matriz[j][i];
				}
				cout << endl;
			}
		}
		else if(instruccion == "X")
			break;
	}
}
