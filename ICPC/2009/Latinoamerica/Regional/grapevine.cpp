#include <algorithm>
#include <cstdio>

using namespace std;


int mundo[500][500];
int columnas[1000][501];
int mundoColumnas[500][500];


int buscar(int arreglo[], int l, int u)
{
	int tam = arreglo[0];
	int *menor;
	if(*(arreglo + 1) >= l)
		menor = arreglo + 1;
	else
		menor = lower_bound(arreglo + 1, arreglo + 1 + tam, l);
	int *mayor;
	if(*(arreglo + tam) <= u)
		mayor = arreglo + tam;
	else
		mayor = upper_bound(arreglo + 1, arreglo + tam, u);
	if(menor == arreglo + 1 + tam)
		return 0;
	else
		return *mayor <= u ? mayor - menor + 1 : mayor - menor;
}

int main()
{
	while(true)
	{
		int n, m;
		scanf("%i %i", &n, &m);
		if(n == 0 && m == 0)
			return 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
				scanf("%i", &mundo[i][j]);
		}	
		mundoColumnas[0][0] = 0;
		for(int i = 1; i < m; i++)
		{
			mundoColumnas[0][i] = i;
		}
		for(int i = 1; i < n; i++)
		{
			mundoColumnas[i][0] = i + (m - 1);
		}
		for(int i = 1; i < n; i++)
			for(int j = 1; j < m; j++)
				mundoColumnas[i][j] = mundoColumnas[i - 1][j - 1]; 
		for(int i = 0; i < 1000; i++)
		{
			columnas[i][0] = 0;
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				columnas[mundoColumnas[i][j]][columnas[mundoColumnas[i][j]][0] + 1] = mundo[i][j];
				columnas[mundoColumnas[i][j]][0]++;
			}
		}
		int q;
		scanf("%i", &q);
		while(q--)
		{
			int l, u;
			scanf("%i %i", &l, &u);
			int max = 0;
			for(int i = 0; i < n + m; i++)
			{
				if(i != 0 && i != m && ((columnas[i][1] > l && columnas[i - 1][1] > l) || (columnas[i][0] < max)))
				{
					if(i <= m - 1)
					{
						i = m - 1;
						continue;
					}
					else
					{
						break;
					}
				}
				int actual = buscar(columnas[i], l, u);	
				if(actual > max)
				{
					max = actual;
				}			
			}
			printf("%i\n", max);
		}
		printf("-\n");
	}
}
