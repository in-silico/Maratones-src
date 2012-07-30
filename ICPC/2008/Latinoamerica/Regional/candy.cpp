#include <iostream>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))

using namespace std;

int mejor[100001][2];


int solucionar(int posibles[], int tamano)
{
	mejor[0][0] = posibles[0];
	mejor[0][1] = 0;
	for(int i = 1; i < tamano; i++)
	{
		mejor[i][0] = posibles[i] + mejor[i - 1][1];
		mejor[i][1] = MAX(mejor[i - 1][0], mejor[i - 1][1]);
	}
	return MAX(mejor[tamano - 1][0], mejor[tamano - 1][1]);
}


int entrada[100001];
int columnas[100001];

int main()
{
	int m, n;
	while(true)
	{
		cin >> m >> n;
		if(m == 0 && n == 0)
			break;
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				cin >> entrada[j];
			}
			columnas[i] = solucionar(entrada, n);
		}
		cout << solucionar(columnas, m) << endl;
	}
}
