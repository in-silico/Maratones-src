#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <set>

using namespace std;

struct autor
{
	string nombre;
	int erdos;
};

void leer(char *linea, vector <autor> &paper)
{
	paper.reserve(20);
	int cuenta = 0;
	while(*linea != ':')
	{
		string nombre = "";
		cuenta = 0;
		while((*linea != ',' && *linea != ':') || (*linea != ':' && cuenta++ != 1))
		{
			nombre += *linea;
			linea++;
		}
		if(*linea != ':')
		{
			linea += 2;
		}
		autor actual;
		actual.nombre = nombre;
		actual.erdos = -1;
		paper.push_back(actual);
	}
}

bool lessA(autor a, autor b)
{
	return a.nombre < b.nombre;
}

int main()
{
	int ncasos;
	string linea;
	getline(cin, linea);
	istringstream tokens(linea);
	tokens >> ncasos;
	for(int i = 1; i <= ncasos; i++)
	{
		getline(cin, linea);
		if(linea == "")
		{
			i--;
			continue;
		}
		istringstream tokens(linea);
		int p, n;
		tokens >> p >> n;
		vector <autor> *papers = new vector <autor> [p];
		for(int j = 0; j < p; j++)
		{
			getline(cin, linea);
			if(linea == "")
			{
				j--;
				continue;
			}
			char *lineaC = new char[linea.length() + 1];
			strcpy(lineaC, linea.c_str());
			leer(lineaC, papers[j]);
		}
		set <autor, bool(*)(autor, autor)> visitados(lessA);
		set <autor, bool(*)(autor, autor)> actual(lessA);
		set <autor, bool(*)(autor, autor)> *actuales = &actual;
		autor paul;
		paul.nombre = "Erdos, P.";
		paul.erdos = 0;
		visitados.insert(paul);
		for(int j = 0; j < p; j++)
		{
			bool contiene = false;
			for(unsigned int k = 0; k < papers[j].size(); k++)
			{
				if(papers[j][k].nombre == "Erdos, P.")
				{
					contiene = true;
					break;
				}
			}
			if(contiene)
			{
				for(unsigned int k = 0; k < papers[j].size(); k++)
				{
					if(papers[j][k].nombre != "Erdos, P.")
					{
						autor nuevo;
						nuevo.nombre = papers[j][k].nombre;
						nuevo.erdos = 1;
						visitados.insert(nuevo);
						(*actuales).insert(nuevo);
					}
				}
			}
		}
		bool termino = false;
		int t = p;
		while(!termino)
		{
			termino = true;
			set <autor, bool(*)(autor, autor)> *nuevosActuales;
			nuevosActuales = new set <autor, bool(*)(autor, autor)> (lessA);
			vector <autor> *papersNuevos;
			papersNuevos = new vector <autor> [t];
			int tNuevo = 0;
			for(int j = 0; j < t; j++)
			{
				bool loTiene = false;
				for(set <autor, bool(*)(autor, autor)>::iterator actual = (*actuales).begin(); actual != (*actuales).end(); actual++)
				{
					autor aActual = *actual;
					for(unsigned int k = 0; k < papers[j].size(); k++)
					{
						if(papers[j][k].nombre == aActual.nombre)
						{
							loTiene = true;
							break;
						}
					}
					if(loTiene)
					{
						for(unsigned int k = 0; k < papers[j].size(); k++)
						{
							if(papers[j][k].nombre != aActual.nombre)
							{
								set <autor, bool(*)(autor, autor)>::iterator contiene = visitados.find(papers[j][k]);
								if(contiene == visitados.end())
								{
									autor nuevo;
									nuevo.nombre = papers[j][k].nombre;
									nuevo.erdos = aActual.erdos + 1;
									visitados.insert(nuevo);
									(*nuevosActuales).insert(nuevo);
									termino = false;
								}
							}
						}
						break;
					}
				}
				if(!loTiene)
				{
					papersNuevos[tNuevo].reserve(papers[j].size());
					for(unsigned int k = 0; k < papers[j].size(); k++)
					{
						papersNuevos[tNuevo].push_back(papers[j][k]);
					}
					tNuevo++;
				}
			}
			actuales = nuevosActuales;
			papers = papersNuevos;
			t = tNuevo;
		}
		cout << "Scenario " << i << endl;
		for(int j = 0; j < n; j++)
		{
			getline(cin, linea);
			if(linea == "")
			{
				j--;
				continue;
			}
			cout << linea << " ";
			autor buscado;
			buscado.nombre = linea;
			set <autor, bool(*)(autor, autor)>::iterator contiene = visitados.find(buscado);
			if(contiene != visitados.end())
			{
				autor contenido = *contiene;
				cout << contenido.erdos << endl;
			}
			else
			{
				cout << "infinity" << endl;
			}
		}
	}

}
