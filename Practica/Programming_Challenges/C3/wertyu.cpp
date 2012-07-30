#include <iostream>
#include <string>

using namespace std;

string teclado = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

int main()
{
	string actual;
	while(getline(cin, actual))
	{
		for(unsigned int i = 0; i < actual.length(); i++)
		{
			if(actual[i] == ' ')
				continue;
			for(unsigned int j = 0; j < teclado.length(); j++)
			{
				if(teclado[j] == actual[i])
				{
					actual[i] = teclado[j - 1];
					break;
				}
			}
		}
		cout << actual << endl;
	}
}
