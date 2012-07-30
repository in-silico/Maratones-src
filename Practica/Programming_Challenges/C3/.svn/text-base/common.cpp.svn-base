#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int min(int a, int b)
{
	if(a > b)
		return b;
	return a;
}
int main()
{
	string linea1;
	string linea2;
	while(getline(cin, linea1) && getline(cin, linea2))
	{
		if(linea1.length() == 0 || linea2.length() == 0)
		{
			cout << endl;
			continue;
		}
		for(unsigned int i = 0; i < linea1.length(); i++)
		{
			if(linea1[i] >= 'A' && linea1[i] <= 'Z')
				linea1[i] -= 'A' - 'a';
		}
		for(unsigned int i = 0; i < linea2.length(); i++)
		{
			if(linea2[i] >= 'A' && linea2[i] <= 'Z')
				linea2[i] -= 'A' - 'a';
		}
		int frecuencia1[26];
		int frecuencia2[26];
		for(int i = 0; i < 26; i++)
		{
			frecuencia1[i] = 0;
			frecuencia2[i] = 0;
		}
		for(unsigned int i = 0; i < linea1.length(); i++)
		{
			frecuencia1[linea1[i] - 'a']++;
		}
		for(unsigned int i = 0; i < linea2.length(); i++)
		{
			frecuencia2[linea2[i] - 'a']++;
		}
		for(unsigned int i = 0; i < 26; i++)
		{
			int menor = min(frecuencia1[i], frecuencia2[i]);
			for(int j = 0; j < menor; j++)
				cout << (char)('a' + i);
		}
		cout << endl;
	}
}
