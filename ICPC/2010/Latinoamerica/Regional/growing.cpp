#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
using namespace std;

int limite = 'a' - 1;

struct Palabra
{
     char *s;
     int tam;

     bool operator<(const Palabra & otra) const
     {
         return tam > otra.tam;
     }
};

struct PMA;

PMA* guardadas[1000000];
int numeroGuardadas;
int numeroEntregadas;

struct Node
{
    Node *sig;
    int este;
    bool unido;

    Node(int valor)
    {
        este = valor;
        sig = NULL;
        unido = false;
    }

    void borrar()
    {
        if(sig == NULL || unido == true)
            return;
        sig->borrar();
        delete sig;
    }
};


struct List
{
    Node *inicio;
    Node *fin;

    List()
    {
        inicio = NULL;
        fin = NULL;
    }

    void push_back(int nuevo)
    {
        if(inicio == NULL)
        {
            inicio = new Node(nuevo);
            fin = inicio;
            return;
        }
        fin->sig = new Node(nuevo);
        fin = fin->sig;
    }

    void clear()
    {
        if(inicio == NULL)
            return;
        inicio->borrar();
        delete inicio;
        inicio = NULL;
        fin = NULL;
    }

    void merge(List & otra)
    {
        if(otra.inicio == NULL)
        {
            return;
        }
        else if(inicio == NULL)
        {
            inicio = new Node(otra.inicio->este);
            inicio->sig = otra.inicio->sig;
            inicio->unido = true;
            fin = otra.fin;
        }
        else
        {
            fin->sig = otra.inicio;
            fin->unido = true;
            fin = otra.fin;
        }
    }
};
struct PMA
{
    int num;
    int next[27];
    List accept;

    PMA(int n)
    {
        num = n;
        for(int i = 0; i < 27; i++)
            next[i] = 0;
    }

    void terminar()
    {
       for(int i = 0; i < 27; i++)
           next[i] = 0;
       accept.clear();
       accept.fin = accept.inicio = NULL;
    }

    PMA* dar(char c)
    {
       if(c != 0)
           c -= limite;
       if(next[c] == 0)
           return NULL;
       return guardadas[next[c]];
    }

    void agregar(char c, PMA* a)
    {
       if(c != 0)
           c -= limite;
       next[c] = a->num;
    }
};

 struct AhoCorasick
 {
     PMA *v;

     PMA *darSiguiente()
     {
         if(numeroGuardadas == numeroEntregadas)
         {
             numeroGuardadas++;
             numeroEntregadas++;
             return guardadas[numeroGuardadas - 1] = new PMA(numeroGuardadas - 1);
         }
         return guardadas[numeroEntregadas++];
     }

     AhoCorasick(Palabra p[], int size) {
       queue<PMA*> Q;
       PMA *root = darSiguiente();
       for ( int i = 0 ; i < size; ++i) { // make trie
         PMA *t = root;
         for ( int j = 0 ; p[i].s[j]; ++j) {
           char c = p[i].s[j];
           if (t->dar(c) == NULL ) { t->agregar(c, darSiguiente()); }
           t = t->dar(c);
         }
         t->accept.push_back(i);
       }
        // make failure link using bfs
       for ( int c = 'a'; c <= 'z'; ++c) {
         if (root->dar(c)) {
           root->dar(c)->agregar(0, root);
           Q.push(root->dar(c));
         } else root->agregar(c, root);
       }
       while (!Q.empty()) {
         PMA *t = Q.front(); Q.pop();
         for(int i = 'a'; i <= 'z'; i++) {
             if(t->dar(i)){
                 if(t->dar(i) == NULL)
                     cout << "error";
                 Q.push(t->dar(i));
                 PMA *r = t->dar(0);
                 while (!r->dar(i)) {
                     r = r->dar(0);
                 }
                 t->dar(i)->agregar(0, r->dar(i));
                 t->dar(i)->accept.merge(r->dar(i)->accept);
             }
         }
       }
       v = root;
     }

     void terminar()
     {
         for(int i = 1; i < numeroEntregadas; i++)
         {
             guardadas[i]->terminar();
         }
     }

     int match(char *t, int dp[], int diff, int nuevo) {
       PMA *temp = v;
       PMA *v = temp;
       int n = strlen(t) + diff;
       for ( int i = 0 ; i < n; ++i) {
         char c = t[i];
         while (!v->dar(c)) v = v->dar(0);
         v = v->dar(c);
         Node *actual = v->accept.inicio;
         while(actual != NULL)
         {
             dp[actual->este] = MAX(dp[actual->este], nuevo);
             actual = actual->sig;
         }
       }
     }
 };

int main()
{
    int dp[10100];
    int n;
    Palabra *palabras = new Palabra[10100];
    char lectura[1010];
    numeroGuardadas = 1;
    while (true)
    {
        numeroEntregadas = 1;
        cin >> n;
        if(n == 0)
            break;
        for (int i = 0; i < n; i++)
        {
            cin >> lectura;
            palabras[i].tam = strlen(lectura);
            palabras[i].s = new char[palabras[i].tam + 1];
            strcpy(palabras[i].s, lectura);
            dp[i] = 1;
        }
        sort(palabras, palabras + n);
        AhoCorasick *ac = new AhoCorasick(palabras, n);
        int mejor = 0;
        for(int i = 0; i < n; i++)
        {
            int dpSig = dp[i] + 1;
            ac->match(palabras[i].s + 1, dp, 0, dpSig);
            ac->match(palabras[i].s, dp, -1, dpSig);
            mejor = MAX(mejor, dp[i]);
        }
        cout << mejor << endl;
        ac->terminar();
        delete ac;
        for(int i = 0; i < n; i++)
        {
            delete [] palabras[i].s;
        }
    }
}
