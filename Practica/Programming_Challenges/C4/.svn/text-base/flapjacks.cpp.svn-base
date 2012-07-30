#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

int tam = 0;
int actual = 0;

/* qsort int comparison function */
int int_cmp(const void *a, const void *b)
{
    const int *ia = (const int *)a; // casting pointer types
    const int *ib = (const int *)b;
    return *ia  - *ib;
	/* integer comparison: returns negative if b > a
	and positive if a > b */
}

int termino(int *pila)
{
	while(*pila != -1)
	{
		if(*pila <= *(++pila))
		{
			return false;
		}
	}
	return true;
}

int buscar(int mayor, int *pila)
{
	if(*pila == mayor)
		return 0;
	int *pilafinal = pila;
	while(*(++pilafinal) != -1);
	int *ultimo = pilafinal - 1;
	int *ultimot = ultimo;
	while(*(--pilafinal) != mayor);
	if(*(pilafinal + 1) == -1)
	{
		while(pila < ultimot)
		{
			int temp = *pila;
			*pila++ = *ultimot;
			*ultimot-- = temp;
		}
		cout << 1 + actual << " ";
		return 1;
	}
	else
	{
		cout << pilafinal - pila + 1 + actual << " ";
		while(pilafinal < ultimo)
		{
			int temp = *pilafinal;
			*pilafinal++ = *ultimo;
			*ultimo-- = temp;
		}
		while(pila < ultimot)
		{
			int temp = *pila;
			*pila++ = *ultimot;
			*ultimot-- = temp;
		}
		cout << 1 + actual << " ";
		return 2;
	}
}

void copiar(int *pila, int *pila2)
{
	while(*pila != -1)
	{
		*pila2++ = *pila++;
	}
	*pila2 = -1;
}


int main()
{
	string linea;
	while(getline(cin, linea))
	{
		istringstream tokens(linea);
		int *pila = new int[31];
		int n = 30;
		pila[30] = -1;
		for(int i = 0; i < 30; i++)
			pila[i] = 0;
		while(tokens >> pila[--n]);
		tam = 29 - n;
		int *pilaordenada;
		pilaordenada = new int[31];
		copiar(pila, pilaordenada);
		pila += n;
		pilaordenada += n;
		qsort(pilaordenada, 30 - n, sizeof(int), int_cmp);
		pilaordenada++;
		pila++;
		while(*(++pilaordenada) != -1);
		actual = 0;
		int *pilap = pila;
		while(*(++pilap) != -1);
		int a = 0;
		--pilap;
		while(*pilap != 0)
		{
			if(a++)
				cout << " ";
			cout << *(pilap--);
		}
		cout << endl;
		while(!termino(pila))
		{
		    buscar(*(--pilaordenada), pila);
			actual++;
			pila++;
		}
		cout << "0" << endl;
	}
}
