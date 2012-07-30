#include <iostream>
#include <string>

using namespace std;

int dos[13];
const int DOS16 = 2 << 16;

void generarSiguientes(int *actuales, int *nuevos)
{
	int vecinoAct = 0;
	while(vecinoAct = *actuales++)
	{
		int vecino = vecinoAct;
		int ultimoUno = 0;
		for(int i = 0; i < 13; i++)
		{
			if((vecino % 2))
			{
				ultimoUno = i;
			}
			vecino /= 2;
		}
		vecino = vecinoAct;
		for(int i = ultimoUno + 1; i < 13; i++)
		{
			*nuevos++ = vecinoAct + dos[i];
		}
	}
	*nuevos = 0;
}

void generarPadres(int actual, int *padres)
{
	int actualT = actual;
	for(int i = 0; i < 13; i++)
	{
		if((actualT % 2))
		{
			*padres++ = actual - dos[i] + (i * (DOS16));
		}
		actualT /= 2;
	}
	*padres = 0;
}

int yah(int numeros[5])
{
	int a = numeros[0];
	for(int i = 1; i < 5; i++)
	{
		if(numeros[i] != a)
		{
			return 0;
		}
	}
	return 50;
}

int chance(int numeros[5])
{
	int ac = 0;
	for(int i = 0; i < 5; i++)
	{
		ac += numeros[i];
	}
	return ac;
}

int uno(int numeros[5], int n)
{
	int ac = 0;
	for(int i = 0; i < 5; i++)
	{
		if(numeros[i] == n)
			ac += numeros[i];
	}
	return ac;
}

int tok(int numeros[5])
{
	for(int i = 0; i < 5; i++)
	{
		int actual = numeros[i];
		int cuenta = 0;
		for(int j = 0; j < 5; j++)
		{
			if(j != i)
			{
				if(numeros[j] == actual)
				{
					cuenta++;
					if(cuenta == 2)
					{
						return chance(numeros);
					}
				}
			}
		}
	}
	return 0;
}

int fok(int numeros[5])
{
	for(int i = 0; i < 5; i++)
	{
		int actual = numeros[i];
		int cuenta = 0;
		for(int j = 0; j < 5; j++)
		{
			if(j != i)
			{
				if(numeros[j] == actual)
				{
					cuenta++;
					if(cuenta == 3)
					{
						return chance(numeros);
					}
				}
			}
		}
	}
	return 0;
}

int fh(int numeros[5])
{
	bool tok = false;
	int tokN = 0;
	for(int i = 0; i < 5; i++)
	{
		int actual = numeros[i];
		int cuenta = 0;
		for(int j = 0; j < 5; j++)
		{
			if(j != i)
			{
				if(numeros[j] == actual)
				{
					cuenta++;
					if(cuenta == 2)
					{
						tok = true;
						tokN = numeros[j];
					}
				}
			}
		}
	}
	if(tok)
	{
		for(int i = 0; i < 5; i++)
		{
			int actual = numeros[i];
			if(actual != tokN)
			{
				int cuenta = 0;
				for(int j = 0; j < 5; j++)
				{
					if(j != i)
					{
						if(numeros[j] == actual)
						{
							cuenta++;
							if(cuenta == 1)
							{
								return 40;
							}
						}
					}
				}
			}
		}
		return (yah(numeros) > 0) ? 40 : 0;
	}
	return 0;
}

int ss(int numeros[5])
{
	bool tiene[7];
	for(int i = 0; i < 7; i++)
		tiene[i] = false;
	for(int i = 0; i < 5; i++)
		tiene[numeros[i]] = true;
	if(tiene[3] && tiene[4] && ((((tiene[1] || tiene[5]) && tiene[2])) || (tiene[5] && tiene[6])))
		return 25;
	return 0;
}

int ls(int numeros[5])
{
	bool tiene[7];
	for(int i = 0; i < 7; i++)
		tiene[i] = false;
	for(int i = 0; i < 5; i++)
		tiene[numeros[i]] = true;
	if(tiene[2] && tiene[3] && tiene[4] && tiene[5] && (tiene[1] || tiene[6]))
		return 35;
	return 0;
}


int main()
{
	while(true)
	{
		int numeros[13][5];
		for(int i = 0; i < 13; i++)
		{
			if(!(cin >> numeros[i][0] >> numeros[i][1] >> numeros[i][2] >> numeros[i][3] >> numeros[i][4]))
			{
				return 0;
			}
		}
		dos[0] = 1;
		for(int i = 1; i < 13; i++)
		{
			  dos[i] = dos[i - 1] << 1;
		}
		int memoization[13][13];
		for(int i = 0; i < 13; i++)
		{
			memoization[0][i] = uno(numeros[i], 1);
			memoization[1][i] = uno(numeros[i], 2);
			memoization[2][i] = uno(numeros[i], 3);
			memoization[3][i] = uno(numeros[i], 4);
			memoization[4][i] = uno(numeros[i], 5);
			memoization[5][i] = uno(numeros[i], 6);
			memoization[6][i] = chance(numeros[i]);
			memoization[7][i] = tok(numeros[i]);
			memoization[8][i] = fok(numeros[i]);
			memoization[9][i] = yah(numeros[i]);
			memoization[10][i] = ss(numeros[i]);
			memoization[11][i] = ls(numeros[i]);
			memoization[12][i] = fh(numeros[i]);
		}
		int dp[14][8192];
		for(int i = 0; i < 13; i++)
		{
			dp[1][dos[i]] = memoization[0][i] + (i * (DOS16));
		}
		int *actuales = new int[8192];
		generarSiguientes(dos, actuales);
		for(int i = 2; i < 14; i++)
		{
			int *actualesI = actuales;
			while(*actuales)
			{
				int *padres = new int[14];
				generarPadres(*actuales, padres);
				int mejor = INT_MIN;
				int mejorPadre = 0;
				while(*padres)
				{
					if(dp[i - 1][*padres % DOS16] % DOS16 + memoization[i - 1][*padres / DOS16] > mejor)
					{
						mejor = dp[i - 1][*padres % DOS16] % DOS16 + memoization[i - 1][*padres / DOS16];
						mejorPadre = *padres;
					}
					padres++;
				}
				if(i == 6 && mejor >= 63)
				{
					mejor += 35;
				}
				dp[i][*(actuales++)] = mejor + ((mejorPadre / DOS16) * (DOS16));
			}
			int *nuevos = new int[8192];
			generarSiguientes(actualesI, nuevos);
			actuales = nuevos;
		}
		int nActual = 8191;
		int resultado[15];
		resultado[14] = dp[13][nActual] % DOS16;
		for(int k = 13; k > 0; k--)
		{
			int actual = dp[k][nActual];
			int anterior = actual / DOS16;
			nActual -= dos[anterior];
			resultado[k - 1] = memoization[k - 1][anterior];
		}
		int acum = 0;
		for(int i = 0; i < 6; i++)
		{
			acum += resultado[i];
		}
		if(acum >= 63)
		{
			resultado[13] = 35;
		}
		else
		{
			resultado[13] = 0;
		}
		for(int i = 0; i < 14; i++)
		{
			cout << resultado[i] << " ";
		}
		cout << resultado[14] << endl;
	}
}

