
#include <iostream>
#include <string>

using namespace std;

void llenar(string allenar[], int desde, int hasta, int ncerosi, int ncar, char car, int ncerosf)
{
	for(int i = desde; i <= hasta; i++)
	{
		for(int j = 0; j < ncerosi; j++)
		{
			allenar[i] += ' ';
		}
		for(int j = 0; j < ncar; j++)
		{
			allenar[i] += car;
		}
		for(int j = 0; j < ncerosf; j++)
		{
			allenar[i] += ' ';
		}
	}
}

void llenar1(string allenar[], int desde, int hasta, int ncari, char car, int ncarf,  int nceros)
{
	for(int i = desde; i <= hasta; i++)
	{
		for(int j = 0; j < ncari; j++)
		{
			allenar[i] += car;
		}
		for(int j = 0; j < nceros; j++)
		{
			allenar[i] += ' ';
		}
		for(int j = 0; j < ncarf; j++)
		{
			allenar[i] += car;
		}
	}
}

int main()
{
	while(true)
	{
		int s;
		char* numero = new char[15];
		cin >> s >> numero;
		if(s == 0)
			break;
		string salida[100];
		int tam = strlen(numero);
		for(int a = 0; a < tam; a++)
		{
			if(a != 0)
			{
				llenar(salida, 0, 2 * s + 2, 1, 0, ' ', 0);
			}
			if(*numero == '1')
			{
				llenar(salida, 0, 0, s + 2, 0, ' ', 0);
				llenar(salida, 1, s, s + 1, 1, '|', 0);
				llenar(salida, s + 1, s + 1, s + 2, 0, ' ', 0);
				llenar(salida, s + 2, 2 * s + 1, s + 1, 1, '|', 0);
				llenar(salida, 2 * s + 2, 2 * s + 2, s + 2, 0, ' ', 0);
			}
			else if(*numero == '2')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar(salida, 1, s, s + 1, 1, '|', 0);
				llenar(salida, s + 1, s + 1, 1, s, '-', 1);
				llenar(salida, s + 2, 2 * s + 1, 0, 1, '|', s + 1);
				llenar(salida, 2 * s + 2, 2 * s + 2, 1, s, '-', 1);
			}
			else if(*numero == '3')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar(salida, 1, s, s + 1, 1, '|', 0);
				llenar(salida, s + 1, s + 1, 1, s, '-', 1);
				llenar(salida, s + 2, 2 * s + 1, s + 1, 1, '|', 0);
				llenar(salida, 2 * s + 2, 2 * s + 2, 1, s, '-', 1);
			}
			else if(*numero == '4')
			{
				llenar(salida, 0, 0, s + 2, 0, ' ', 0);
				llenar1(salida, 1, s, 1, '|', 1, s);
				llenar(salida, s + 1, s + 1, 1, s, '-', 1);
				llenar(salida, s + 2, 2 * s + 1, s + 1, 1, '|', 0);
				llenar(salida, 2 * s + 2, 2 * s + 2, s + 2, 0, ' ', 0);
			}
			else if(*numero == '5')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar(salida, 1, s, 0, 1, '|', s + 1);
				llenar(salida, s + 1, s + 1, 1, s, '-', 1);
				llenar(salida, s + 2, 2 * s + 1, s + 1, 1, '|', 0);
				llenar(salida, 2 * s + 2, 2 * s + 2, 1, s, '-', 1);
			}
			else if(*numero == '6')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar(salida, 1, s, 0, 1, '|', s + 1);
				llenar(salida, s + 1, s + 1, 1, s, '-', 1);
				llenar1(salida, s + 2, 2 * s + 1, 1, '|', 1, s);
				llenar(salida, 2 * s + 2, 2 * s + 2, 1, s, '-', 1);
			}
			if(*numero == '7')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar(salida, 1, s, s + 1, 1, '|', 0);
				llenar(salida, s + 1, s + 1, s + 2, 0, ' ', 0);
				llenar(salida, s + 2, 2 * s + 1, s + 1, 1, '|', 0);
				llenar(salida, 2 * s + 2, 2 * s + 2, s + 2, 0, ' ', 0);
			}
			else if(*numero == '8')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar1(salida, 1, s, 1, '|', 1, s);
				llenar(salida, s + 1, s + 1, 1, s, '-', 1);
				llenar1(salida, s + 2, 2 * s + 1, 1, '|', 1, s);
				llenar(salida, 2 * s + 2, 2 * s + 2, 1, s, '-', 1);
			}
			else if(*numero == '9')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar1(salida, 1, s, 1, '|', 1, s);
				llenar(salida, s + 1, s + 1, 1, s, '-', 1);
				llenar(salida, s + 2, 2 * s + 1, s + 1, 1, '|', 0);
				llenar(salida, 2 * s + 2, 2 * s + 2, 1, s, '-', 1);
			}
			else if(*numero == '0')
			{
				llenar(salida, 0, 0, 1, s, '-', 1);
				llenar1(salida, 1, s, 1, '|', 1, s);
				llenar(salida, s + 1, s + 1, s + 2, 0, ' ', 0);
				llenar1(salida, s + 2, 2 * s + 1, 1, '|', 1, s);
				llenar(salida, 2 * s + 2, 2 * s + 2, 1, s, '-', 1);
			}
			numero++;
		}
		for(int i = 0; i < 2 * s + 3; i++)
		{
			cout << salida[i] << endl;
		}
		cout << endl;
	}
}

