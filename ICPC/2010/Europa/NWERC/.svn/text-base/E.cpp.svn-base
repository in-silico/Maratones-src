#include <iostream>
#include <list>
#include <algorithm>
#include <cstring>

using namespace std;

struct Equipo
{
    int numero;
    int posicionOriginal;
    int posicionFinal;
    bool SMP[501];

    void reiniciar(int n)
    {
        for(int i = 0; i < 501; i++)
        {
            SMP[i] = false;
        }
        numero = n;
    }
};

list <Equipo*> este;
Equipo equipos[501];
int pares[25001][2];

int main()
{
    int tc;
    cin >> tc;
    for(int i = 0; i < tc; i++)
    {
        int n;
        cin >> n;
        for(int j = 1; j <= n; j++)
        {
            int este;
            cin >> este;
            equipos[este].reiniciar(este);
            equipos[este].posicionOriginal = j;
        }
        int m;
        cin >> m;
        for(int j = 0; j < m; j++)
        {
            int a, b;
            cin >> a >> b;
            pares[j][0] = a;
            pares[j][1] = b;
            equipos[a].SMP[b] = true;
            equipos[b].SMP[a] = true;
        }
        este.clear();
        este.push_back(&equipos[1]);
        bool paila = false;
        for(int j = 2; j <= n; j++)
        {
            Equipo *actual = &equipos[j];
            bool seInserto = false;
            for(list<Equipo*>::iterator it = este.begin(); it != este.end(); it++)
            {
                if((actual->posicionOriginal < (*it)->posicionOriginal && !actual->SMP[(*it)->numero]) || (actual->posicionOriginal > (*it)->posicionOriginal && actual->SMP[(*it)->numero]))
                {
                    este.insert(it, actual);
                    seInserto = true;
                    break;
                }
            }
            if(!seInserto)
            {
                if((este.back()->posicionOriginal > actual->posicionOriginal && actual->SMP[este.back()->numero]) || (este.back()->posicionOriginal < actual->posicionOriginal && !actual->SMP[este.back()->numero]))
                {
                    este.push_back(actual);
                }
                else
                {
                    paila = true;
                }
            }
        }
        int j = 1;
        for(list<Equipo*>::iterator it = este.begin(); it != este.end(); it++)
        {
            (*it)->posicionFinal = j++;
        }
        for(list<Equipo*>::iterator it = este.begin(); it != este.end(); it++)
        {
            for(list<Equipo*>::iterator it2 = it; it2 != este.end(); it2++)
            {
                if((*it)->numero == (*it2)->numero)
                    continue;
                if((*it)->posicionOriginal < (*it2)->posicionOriginal && (*it)->SMP[(*it2)->numero])
                    paila = true;
                if((*it)->posicionOriginal > (*it2)->posicionOriginal && !(*it)->SMP[(*it2)->numero])
                    paila = true;
            }
        }
        for(list<Equipo*>::reverse_iterator it = este.rbegin(); it != este.rend(); it++)
        {
            for(list<Equipo*>::reverse_iterator it2 = it; it2 != este.rend(); it2++)
            {
                if((*it)->numero == (*it2)->numero)
                    continue;
                if((*it)->posicionOriginal < (*it2)->posicionOriginal && !(*it)->SMP[(*it2)->numero])
                    paila = true;
                if((*it)->posicionOriginal > (*it2)->posicionOriginal && (*it)->SMP[(*it2)->numero])
                    paila = true;
            }
        }
        if(paila)
        {
            cout << "IMPOSSIBLE" << endl;
            continue;
        }
        int inicio = 0;
        for(list<Equipo*>::iterator it = este.begin(); it != este.end(); it++)
        {
            if(inicio++)
                cout << " ";
            cout << (*it)->numero;
        }
        cout << endl;
    }
}
