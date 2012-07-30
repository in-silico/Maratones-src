#include <iostream>
#include <list>

using namespace std;

struct Amigo
{
    int dinero;
    int posicion;
    int pago;

    Amigo(int d, int p) : dinero(d), posicion(p), pago(0) { };
};

Amigo *amigos[101];
list <Amigo*> actuales;

bool menor(const Amigo *a, const Amigo *b)
{
    if(a->dinero == b->dinero)
    {
        return b->posicion < a->posicion;
    }
    return a->dinero < b->dinero;
}

int main()
{
    int tc;
    cin >> tc;
    for(int i = 0; i < tc; i++)
    {
        actuales.clear();
        int p, n;
        cin >> p >> n;
        int cuentaActual = 0;
        for(int j = 0; j < n; j++)
        {
            int d;
            cin >> d;
            cuentaActual += d;
            amigos[j] = new Amigo(d, j);
            actuales.push_back(amigos[j]);
        }
        actuales.sort(menor);
        if(cuentaActual < p)
        {
            cout << "IMPOSSIBLE" << endl;
            continue;
        }
        while(true)
        {
            int numeroActuales = actuales.size();
            int aPagar = p / numeroActuales;
            if(aPagar > actuales.front()->dinero)
            {
                Amigo *afuera = actuales.front();
                afuera->pago = afuera->dinero;
                p -= afuera->dinero;
                actuales.pop_front();
                continue;
            }
            for(list<Amigo*>::iterator it = actuales.begin(); it != actuales.end(); it++)
            {
                (*it)->pago += aPagar;
                p -= aPagar;
            }
            for(list<Amigo*>::reverse_iterator it = actuales.rbegin(); p != 0 && it != actuales.rend(); it++)
            {
                (*it)->pago++;
                p--;
            }
            break;
        }
        for(int j = 0; j < n; j++)
        {
            if(j)
                cout << " ";
            cout << amigos[j]->pago;
        }
        cout << endl;
    }
}
