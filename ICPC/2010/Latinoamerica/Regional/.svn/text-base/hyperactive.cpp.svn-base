#include <iostream>
#include <algorithm>
#define MOD 100000000
#include<map>

using namespace std;

struct Actividad
{
	int inicio;
	int fin;
	map<int, int> matches;

        void reset()
        {
            matches.clear();
            cin >> inicio >> fin;
            if(inicio == 0)
                matches[0]++;
        }

        void agregar(int *cuenta)
        {
            for(map<int,int>::iterator it = matches.begin(); it != matches.end(); it++)
            {
                *cuenta += it->second;
                *cuenta %= MOD;
            }
        }
        bool match(Actividad & otra)
        {
            return otra.fin >= inicio && otra.fin < fin && inicio > otra.inicio;
        }

        void agregarMatch(Actividad & otra)
        {
            for(map<int,int>::iterator it = matches.begin(); it != matches.end(); it++)
            {
                if(it->first >= otra.inicio)
                    break;
                otra.matches[fin] += it->second;
                otra.matches[fin] %= MOD;
            }
        }

        bool operator<(const Actividad & otra) const
        {
            if(fin == otra.fin)
                return inicio < otra.inicio;
            return fin < otra.fin;
        }
};

int main()
{
    Actividad actividades[100];
    int m, n;
    while(true)
    {
        cin >> m >> n;
        if(m == 0 && n == 0)
            break;
        for(int i = 0; i < n; i++)
        {
            actividades[i].reset();
        }
        sort(actividades, actividades + n);
        int cuenta = 0;
        for(int i = 0; i < n; i++)
        {
            Actividad & actual = actividades[i];
            for(int j = 0; j < i; j++)
            {
                Actividad & posible = actividades[j];
                if(actual.match(posible))
                    posible.agregarMatch(actual);
            }
            if(actual.fin == m)
            {
                actual.agregar(&cuenta);
            }
        }
        cout << cuenta << endl;
    }
}