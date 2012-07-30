#define DP dp[desde][hasta]
#include <cstdio>
#include <map>
#include <cstring>

using namespace std;


map<char,int> mapa;
map<int,char> mapa2;

int matrizR[26][26];
int matrizT[26][26];
int *dp[200][200];
int este[220];
int k;

int *solucionar(int desde, int hasta)
{
    if(DP != NULL)
        return DP;
    if(desde == hasta)
    {
        int *resultado = new int[k];
        for(int i = 0; i < k; i++)
            resultado[i] = -1;
        resultado[este[desde]] = 0;
        return DP = resultado;
    }
    else
    {
        int *resultado = new int[k];
        for(int i = 0; i < k; i++)
            resultado[i] = -1;
        for(int i = desde; i < hasta; i++)
        {
            int *parteA = solucionar(desde, i);
            int *parteB = solucionar(i + 1, hasta);
            for(int i = 0; i < k; i++)
            {
                if(parteA[i] == -1)
                    continue;
                for(int j = 0; j < k; j++)
                {
                    if(parteB[j] == -1)
                        continue;
                    int donde = matrizR[i][j];
                    int cuanto = matrizT[i][j] + parteA[i] + parteB[j];
                    if(resultado[donde] == -1)
                        resultado[donde] = cuanto;
                    else if(resultado[donde] > cuanto)
                        resultado[donde] = cuanto;
                }
            }
        }
        return DP = resultado;
    }
}

int main()
{
    char *lec = new char[3];
    int empezo = 0;
    for(int i = 0; i < 200; i++)
        for(int j = 0; j < 200; j++)
            dp[i][j] = NULL;
    while(true)
    {
        int n;
        scanf("%i", &n);
        if(n == 0)
            break;
        if(empezo++)
            printf("\n");
        k = n;
        mapa.clear();
        mapa2.clear();
        for(int i = 0; i < n; i++)
        {
            scanf("%s", lec);
            mapa[lec[0]] = i;
            mapa2[i] = lec[0];
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int t;
                char r;
                scanf("%i-%s", &t, lec);
                matrizR[i][j] = mapa[lec[0]];
                matrizT[i][j] = t;
            }
        }
        for(int i = 0; i < 200; i++)
            for(int j = 0; j < 200; j++)
            {
                if(dp[i][j] != NULL)
                {
                    delete[] dp[i][j];
                }
                dp[i][j] = NULL;
            }
        scanf("%i", &n);
        char lectura[220];
        for(int i = 0; i < n; i++)
        {
            scanf("%s", lectura);
            int tam = strlen(lectura);
            for(int i = 0; i < tam; i++)
                este[i] = mapa[lectura[i]];
            for(int i = 0; i < tam; i++)
                for(int j = 0; j < tam; j++)
                {
                    if(dp[i][j] != NULL)
                    {
                        delete[] dp[i][j];
                    }
                    dp[i][j] = NULL;
                }
            int *respuesta = solucionar(0, tam - 1);
            int posMejor = 0;
            int valMejor = 1 << 30;
            for(int i = 0; i < k; i++)
                if(respuesta[i] == -1)
                    continue;
                else
                    if(respuesta[i] < valMejor)
                    {
                        valMejor = respuesta[i];
                        posMejor = i;
                    }
             printf("%i-%c\n", valMejor, mapa2[posMejor]);
        }
    }
}