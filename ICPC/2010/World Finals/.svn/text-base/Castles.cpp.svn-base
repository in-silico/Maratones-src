#include<cstdlib>
#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

struct Castillo;

Castillo *castillos[101];

struct Respuesta
{
    int numero;
    int sobrantes;

    Respuesta()
    {
        numero = -1;
        sobrantes = -1;
    }

    Respuesta(int n, int s)
    {
        numero = n;
        sobrantes = s;
    }

    bool operator<(const Respuesta & otra) const
    {
        return sobrantes > otra.sobrantes;
    }
};

struct Castillo
{
    int n;
    int a, m, g;

    vector<int> adjacentes;
    Respuesta dp[101];

    Castillo(int nn)
    {
        n = nn;
    }

    void reiniciar(int aa, int mm, int gg)
    {
        adjacentes.clear();
        for(int i = 0; i < 101; i++)
        {
            dp[i].numero = -1;
        }
        a = aa;
        m = mm;
        g = gg;

    }

    Respuesta visitar(int anterior)
    {
        if(dp[anterior].numero != -1)
            return dp[anterior];
        vector<Respuesta> respuestasHijos(adjacentes.size());
        for(int i = 0; i < adjacentes.size(); i++)
        {
            if(adjacentes[i] != anterior)
                respuestasHijos.push_back(castillos[adjacentes[i]]->visitar(n));
        }
        sort(respuestasHijos.begin(), respuestasHijos.end());
        int numeroUsados = max(a, m + g);
        int numeroSobrantes = max(0, a - (m + g));
        for(int i = 0; i < respuestasHijos.size(); i++)
        {
            Respuesta & actual = respuestasHijos[i];
            if(numeroSobrantes >= actual.numero)
            {
                numeroSobrantes -= actual.numero;
                numeroSobrantes += actual.sobrantes;
            }
            else
            {
                numeroUsados += actual.numero - numeroSobrantes;
                numeroSobrantes = actual.sobrantes;
            }
        }
        return dp[anterior] = Respuesta(numeroUsados, numeroSobrantes);
    }
};

int main()
{
    for(int i = 1; i < 101; i++)
        castillos[i] = new Castillo(i);
    int n;
    int caso = 1;
    while(true)
    {
        cin >> n;
        if(!n)
            break;
        for(int i = 1; i <= n; i++)
        {
            int a, m, g;
            cin >> a >> m >> g;
            castillos[i]->reiniciar(a, m, g);
        }
        for(int i = 0; i < n - 1; i++)
        {
            int a, b;
            cin >> a >> b;
            castillos[a]->adjacentes.push_back(b);
            castillos[b]->adjacentes.push_back(a);
        }
        int minimo = 1000000000;
        for(int i = 1; i <= n; i++)
        {
            minimo = min(minimo, castillos[i]->visitar(0).numero);
        }
        cout << "Case " << caso++ << ": " << minimo << endl;
    }
}
