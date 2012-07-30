#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int jolly()
{
	string linea;
	if(getline(cin, linea))
	{

		istringstream tokens(linea);
		int numero;
		tokens >> numero;
		int numeros[numero];
		memset(numeros, 0, sizeof(int) * numero);
		int anterior;
		tokens >> anterior;
		for(int i = 1; i < numero; i++)
		{
			int actual;
			tokens >> actual;
			int diferencia = abs(anterior - actual);
			if(0 < diferencia < numero)
			{
				if(numeros[diferencia]++)
				{
					return 2;
				}

			}
			else
			{
				return 2;
			}
			anterior = actual;
		}
		if(numero == 1)
		{
			return 1;
		}
		else
		{
			for(int i = 1; i < numero; i++)
			{
				if(numeros[i] != 1)
				{
					return 2;
				}
			}
			return 1;
		}
	}
	return 0;
}

int main()
{
	while(true)
	{
		int r = jolly();
		if(!r)
		{
			return 0;
		}
		else if(r == 1)
		{
			cout << "Jolly" << endl;
		}
		else
		{
			cout << "Not jolly" << endl;
		}
	}
}
