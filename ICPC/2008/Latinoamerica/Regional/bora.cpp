#include <complex>
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <list>

using namespace std;

struct carta
{
    int pinta;
    int valor;
    int peso;

    carta(char p, int v)
    {
        valor = v;
        if(p == 'C')
            pinta = 0;
        else if(p == 'D')
            pinta = 1;
        else if(p == 'H')
            pinta = 2;
        else
            pinta = 3;
        peso = valor * 10 + pinta;
    }

    carta* duplicar()
    {
         carta *nueva = new carta('C', 1);
         nueva->peso = peso;
         nueva->pinta = pinta;
         nueva->valor = valor;
         return nueva;
    }
};

int main()
{
    int p, m, n;
    while(cin >> p >> m >> n)
    {
         if(!p && !m && !n)
             return 0;
         list <carta*> pila;
         for(int i = 0; i < n; i++)
         {
             int valor;
             char pinta;
             cin >> valor >> pinta;
             pila.push_back(new carta(pinta, valor));
         }
         vector <list <carta*>* > jugadores;
         for(int i = 0; i < p; i++)
         {
             list <carta*> *actual = new list <carta*>;
             for(int j = 0; j < m; j++)
             {
                 carta *nueva = pila.front()->duplicar();
                 actual->push_back(nueva);
                 pila.pop_front();
             }
             jugadores.push_back(actual);
         }
         carta *actual = pila.front()->duplicar();
         pila.pop_front();
         bool direccion = actual->valor != 12;
         int jugadorActual = 0;
         bool noVale = actual->valor == 12;
         while(true)
         {
             if(!noVale && actual->valor == 1)
             {
                carta *nueva = pila.front()->duplicar();
                jugadores[jugadorActual]->push_back(nueva);
                pila.pop_front();
                noVale = true;
             }
             else if(!noVale && actual->valor == 7)
             {
                carta *nueva = pila.front()->duplicar();
                jugadores[jugadorActual]->push_back(nueva);
                pila.pop_front();
                carta *nueva1 = pila.front()->duplicar();
                jugadores[jugadorActual]->push_back(nueva1);
                pila.pop_front();
                noVale = true;
             }
             else if(!noVale && actual->valor == 11)
             {
                 noVale = true;
             }
             else
             {
                 int mayor = -1;
                 int posMayor = -1;
                 int i = 0;
                 for(list <carta*>::iterator p = jugadores[jugadorActual]->begin(); p != jugadores[jugadorActual]->end(); p++)
                 {
                     carta *cartaActual = *p;
                     if(cartaActual->pinta == actual->pinta || cartaActual->valor == actual->valor)
                     {
                         if(cartaActual->peso > mayor)
                         {
                             mayor = cartaActual->peso;
                             posMayor = i;
                         }
                     }
                     i++;
                 }
                 if(mayor == -1)
                 {
                    carta *nueva = pila.front()->duplicar();
                    pila.pop_front();
                    if(nueva->pinta == actual->pinta || nueva->valor == actual->valor)
                    {
                        delete actual;
                        actual = nueva;
                        noVale = false;
                    }
                    else
                    {
                        jugadores[jugadorActual]->push_back(nueva);
                        noVale = true;
                    }
                 }
                 else
                 {
                     list <carta*>::iterator p = jugadores[jugadorActual]->begin();
                     int i = 0;
                     while(p != jugadores[jugadorActual]->end())
                     {
                        if(i == posMayor)
                        {
                            delete actual;
                            actual = (*p)->duplicar();
                            noVale = false;
                            jugadores[jugadorActual]->erase(p);
                            break;
                        }
                        p++;
                        i++;
                     }
                     if(jugadores[jugadorActual]->size() == 0)
                     {
                         cout << ++jugadorActual << endl;
                         break;
                     }
                 }
             }
             if(!noVale && actual->valor == 12)
             {
                direccion = !direccion;
                noVale = true;
             }
             if(direccion)
             {
                 jugadorActual++;
                 if(jugadorActual == p)
                 {
                     jugadorActual = 0;
                 }
             }
             else
             {
                 jugadorActual--;
                 if(jugadorActual == -1)
                 {
                     jugadorActual = p - 1;
                 }
             }
         }
    }
}

