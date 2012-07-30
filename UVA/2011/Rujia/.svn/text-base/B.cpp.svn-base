#include <cstdio>
#include <list>
#include <cstdlib>
#include <cstring>

using namespace std;

char linea[100010];


struct Entrada
{
	int inicio;
	int fin;

	Entrada(int i, int f)
	{
		inicio = i;
		fin = f;
	}

	void imprimir()
	{
		if(fin <= inicio)
			return;
		char temp = linea[fin];
		linea[fin] = '\0';
		printf("%s", linea + inicio);
		linea[fin] = temp;
	}
};

list <Entrada> entradas;
bool inicio;

int main()
{
	while(scanf("%s\n", linea) != EOF)
	{
		entradas.clear();
		inicio = true;
		int ultimoCar = -1;
		int inicioAnterior = 0;
		int len = strlen(linea);
		for(int i = 0; i <= len; i++)
		{
			if(linea[i] == '[' || linea[i] == ']' || linea[i] == '\0')
			{
				Entrada e(inicioAnterior, ultimoCar + 1);
				if(inicio)
					entradas.push_front(e);
				else
					entradas.push_back(e);
				inicioAnterior = i + 1;
				if(linea[i] == '[')
					inicio = true;
				else
					inicio = false;
			}
			else
				ultimoCar = i;
		}
		for(list<Entrada>::iterator it = entradas.begin(); it != entradas.end(); it++)
			(*it).imprimir();
		printf("\n");
	}
}
