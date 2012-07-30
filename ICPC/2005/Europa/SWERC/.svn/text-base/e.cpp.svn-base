#include <ext/hash_map>
#include <cstdio>

using namespace __gnu_cxx;

hash_map <int,int> mapa;
int a[4001], b[4001], c[4001], d[4001];

int main()
{
    int casos;
    scanf("%d", &casos);
    bool empezo = false;
    for(int caso = 0; caso < casos; caso++)
    {
        if(empezo)
            printf("\n");
        empezo = true;
        int n;
        scanf("%d", &n);
        for(int i = 0; i < n; i++)
            scanf("%d %d %d %d", &a[i], &b[i], &c[i], &d[i]);
        for(int i = 0; i < n; i++)
		    for(int j = 0; j < n; j++)
			    mapa[a[i] + b[j]]++;
		long long cuenta = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				cuenta += mapa[-(c[i] + d[j])];
		printf("%lld\n", cuenta);
        mapa.clear();
    }
}

