#include <cstdio>
#include <map>
#include <vector>
#include <cstdlib>

using namespace std;

map <int, vector<int> > mapa;

int main()
{
	int n, m;
	while(scanf("%i %i", &n, &m) != EOF)
	{
		mapa.clear();
		for(int i = 1; i <= n; i++)
		{
			int num;
			scanf("%i", &num);
			mapa[num].push_back(i);
		}
		for(int i = 0; i < m; i++)
		{
			int k, v;
			scanf("%i %i", &k, &v);
			if(mapa[v].size() < k)
				printf("0\n");
			else
				printf("%i\n", mapa[v][k - 1]);
		}
	}
}
