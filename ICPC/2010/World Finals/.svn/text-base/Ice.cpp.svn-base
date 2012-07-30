#include<cstdlib>
#include<iostream>
#include<map>

using namespace std;

struct Cuadro;

Cuadro *cuadros[8][8];
int iTam, jTam;
int especiales[4];
int especialesIJ[4][2];

struct Cuadro
{
    int i, j, id;
    bool especial;
    int numEspecial;
    Cuadro *vecinos[4];
    int numeroVecinos;
    int grado;
    map<unsigned long long, long long> dp;

    Cuadro(int ii, int jj)
    {
        i = ii;
        j = jj;
    }

    long long visitar(int turno, unsigned long long actuales)
    {
        if(especial && (numEspecial != turno))
            return 0;
        for(int k = 0; k < 4; k++)
        {
            if((turno == especiales[k]) && !especial)
                return 0;
        }
        if(i == 1 && j == 0)
        {
                return 1;
        }
        if(dp.find(actuales) != dp.end())
            return dp[actuales];
        int especialSiguiente = 0;
        for(int k = 0; k < 4; k++)
        {
            if(especiales[k] > turno)
            {
                especialSiguiente = k;
                break;
            }
        }
        if(abs(especialesIJ[especialSiguiente][0] - i) + abs(especialesIJ[especialSiguiente][1] - j) > especiales[especialSiguiente] - turno)
            return dp[actuales] = 0;
        unsigned long long uno = 1;
        long long total = 0;
        int veces = 0;
        Cuadro *vecinoUnico = NULL;
        for(int a = 0; a < numeroVecinos; a++)
        {
            Cuadro *vecino = vecinos[a];
            if(((actuales >> vecino->id) & 1) != 1)
            {
                if(vecino->grado == 0)
                    return dp[actuales] = 0;
                if(vecino->grado == 1)
                {
                    veces++;
                    vecinoUnico = vecino;
                }
            }
        }
        if(veces == 1)
        {
            vecinoUnico->visitando(-1);
            total += vecinoUnico->visitar(turno + 1, (actuales) | (uno << vecinoUnico->id));
            vecinoUnico->visitando(1);
            if(dp.size() > 20000)
            {
                dp.erase(dp.begin());
                dp.erase(dp.begin());
            }
            return dp[actuales] = total;
        }
        if(veces > 1)
        {
            return dp[actuales] = 0;
        }
        for(int a = 0; a < numeroVecinos; a++)
        {
            Cuadro *vecino = vecinos[a];
            if(((actuales >> vecino->id) & 1) != 1)
            {
               vecino->visitando(-1);
               total += vecino->visitar(turno + 1, (actuales) | (uno << vecino->id));
               vecino->visitando(1);
            }
        }
        if(dp.size() > 20000)
        {
            dp.erase(dp.begin());
            dp.erase(dp.begin());
        }
        return dp[actuales] = total;
    }

    void generarVecinos()
    {
        id = i * jTam + j;
        numeroVecinos = 0;
        especial = false;
        numEspecial = 0;
        dp.clear();
        if(j + 1 < jTam)
            vecinos[numeroVecinos++] = cuadros[i][j + 1];
        if(i + 1 < iTam)
            vecinos[numeroVecinos++] = cuadros[i + 1][j];
        if(j - 1 >= 0)
            vecinos[numeroVecinos++] = cuadros[i][j - 1];
        if(i - 1 >= 0)
            vecinos[numeroVecinos++] = cuadros[i - 1][j];
        visitando(1);
    }

    void visitando(int diff)
    {
        for(int k = 0; k < numeroVecinos; k++)
        {
            vecinos[k]->grado += diff;
        }
    }
};

int main()
{
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            cuadros[i][j] = new Cuadro(i, j);
        }
    }
    int caso = 1;
    while(true)
    {
        cin >> jTam >> iTam;
        if(jTam == 0 && iTam == 0)
            break;
        for(int i = 0; i < iTam; i++)
        {
            for(int j = 0; j < jTam; j++)
            {
                cuadros[i][j]->grado = 0;
            }
        }
        for(int i = 0; i < iTam; i++)
        {
            for(int j = 0; j < jTam; j++)
            {
                cuadros[i][j]->generarVecinos();
            }
        }
        for(int i = 1; i < 4; i++)
        {
            int r, c;
            cin >> r >> c;
            int tiempo = (i * jTam * iTam) / 4;
            cuadros[c][r]->especial = true;
            cuadros[c][r]->numEspecial = tiempo;
            especiales[i - 1] = tiempo;
            especialesIJ[i - 1][0] = c;
            especialesIJ[i - 1][1] = r;
        }
        especiales[3] = iTam * jTam;
        especialesIJ[3][0] = 1;
        especialesIJ[3][1] = 0;
        cuadros[1][0]->especial = true;
        cuadros[1][0]->numEspecial = especiales[3];
        cuadros[1][0]->grado++;
        cuadros[0][0]->visitando(-1);
        cout << "Case " << caso++ << ": " << cuadros[0][0]->visitar(1, 1) << endl;
    }
}
