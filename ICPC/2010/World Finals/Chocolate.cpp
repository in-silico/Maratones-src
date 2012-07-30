#include<iostream>
#include<map>

using namespace std;

struct Pos;

Pos *todos[1 << 16];
short sumas[1 << 16];
int valor[15];

struct Pos
{
    unsigned short id;
    unsigned short numeroUnos;
    unsigned short unos[15];
    unsigned short suma;
    map<short, bool> dp;

    Pos(int i)
    {
        id = i;
        numeroUnos = 0;
        for(int j = 0; j < 16; j++)
        {
            if((i & 1) == 1)
            {
                unos[numeroUnos++] = j;
            }
            i >>= 1;
        }
    }

    bool intentar(unsigned short a, unsigned short b)
    {
        if(a > b)
            return intentar(b, a);
        if(suma != a * b)
            return false;
        if(numeroUnos == 1)
            return sumas[id] == a * b;
        unsigned short clave = a << 8 | b;
        if(dp.find(clave) != dp.end())
            return dp[clave];
        int tam = (1 << numeroUnos) - 1;
        for(unsigned short i = 1; i < tam; i++)
        {
            unsigned short temp = i;
            unsigned short hijoA = 0;
            for(int i = 0; i < numeroUnos; i++)
            {
                if((temp & 1) == 1)
                {
                    hijoA |= 1 << unos[i];
                }
                temp >>= 1;
            }
            unsigned short hijoB = (~hijoA) & id;
            int tamHijoA = sumas[hijoA];
            if(tamHijoA % a == 0)
            {
                if(todos[hijoA]->intentar(a, tamHijoA / a) && todos[hijoB]->intentar(a, b - (tamHijoA / a)))
                {
                    return dp[clave] = true;
                }
            }
            if(tamHijoA % b == 0)
            {
                if(todos[hijoA]->intentar(tamHijoA / b, b) && todos[hijoB]->intentar(a - (tamHijoA / b), b))
                {
                    return dp[clave] = true;
                }
            }
        }
        return dp[clave] = false;
    }

    void calcularSuma()
    {
        suma = 0;
        for(int i = 0; i < numeroUnos; i++)
        {
            suma += valor[unos[i]];
        }
        dp.clear();
    }

};

int main()
{
    int tam = 1 << 16;
    for(int i = 1; i < tam; i++)
        todos[i] = new Pos(i);
    int n, a, b;
    int caso = 1;
    while(true)
    {
        cin >> n;
        if(n == 0)
            break;
        cin >> a >> b;
        bool tieneCero = false;
        int suma = 0;
        for(int i = 0; i < n; i++)
        {
            cin >> valor[i];
            if(valor[i] == 0)
                tieneCero = true;
            suma += valor[i];
        }
        bool pudo;
        if(tieneCero || suma != a * b)
        {
            pudo = false;
        }
        else
        {
            int limite = 1 << n;
            for(int i = 1; i < limite; i++)
            {
                todos[i]->calcularSuma();
                sumas[i] = todos[i]->suma;
            }
            pudo = todos[(1 << n) - 1]->intentar(a, b);
        }
        cout << "Case " << caso++ << ": ";
        if(pudo)
            cout << "Yes" << endl;
        else
            cout << "No" << endl;
    }
}
