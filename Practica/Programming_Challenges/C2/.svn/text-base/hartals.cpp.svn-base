#include <iostream>
#include <string>

using namespace std;

int main()
{
	int ncasos = 0;
	cin >> ncasos;
	for(int i = 1; i <= ncasos; i++)
	{
		int n;
		cin >> n;
		int calendario[n + 1];
		memset(calendario, 0, sizeof(int) * n + 1);
		int p;
		cin >> p;
		for(int j = 0; j < p; j++)
		{
			int pn;
			cin >> pn;
			for(int k = pn; k <= n; k += pn)
			{
				calendario[k]++;
			}
		}
		int ndias = 0;
		for(int j = 1; j <= n; j++)
		{
			if(calendario[j] && ((j - 6) % 7) && (j % 7))
			{
				ndias++;
			}
		}
		cout << ndias << endl;
	}
}
