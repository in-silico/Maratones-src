#include <vector>
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main()
{
	int ncasos;
	cin >> ncasos;
	for(int i = 0; i < ncasos; i++)
	{
		int ncandidatos;
		cin >> ncandidatos;
		string candidatos[ncandidatos];
		string linea;
		getline(cin, linea);
		for(int j = 0; j < ncandidatos; j++)
		{
			getline(cin, linea);
			candidatos[j] = linea;
		}
		vector < vector <int> > votantes(0);
		while(getline(cin, linea) && linea != "")
		{
			istringstream tokens(linea);
			vector <int> actual(0);
			for(int j = 0; j < ncandidatos; j++)
			{
				int a;
				tokens >> a;
				actual.push_back(a);
			}
			votantes.push_back(actual);
		}
		int votos[ncandidatos];
		vector <int> peores(0);
		vector <int> lcandidatos(0);
		for(int j = 1; j < ncandidatos + 1; j++)
		{
			lcandidatos.push_back(j);
		}
		while(true)
		{
			for(int j = 0; j < ncandidatos; j++)
			{
				votos[j] = 0;
			}
			for(unsigned int j = 0; j < votantes.size(); j++)
			{
				int pos = find(lcandidatos.begin(), lcandidatos.end(), votantes[j][0]) - lcandidatos.begin();
				votos[pos]++;
			}
			int mayor = 0;
			int posMayor = 0;
			int menor = INT_MAX;
			peores.erase(peores.begin(), peores.end());
			for(int j = 0; j < ncandidatos; j++)
			{
				if(votos[j] > mayor)
				{
					mayor = votos[j];
					posMayor = j;
				}
				if(votos[j] < menor)
				{
					menor = votos[j];
					peores.erase(peores.begin(), peores.end());
					peores.push_back(j);
				}
				else if(votos[j] == menor)
				{
					peores.push_back(j);
				}
			}
			if((unsigned int) mayor > votantes.size() / 2)
			{
				cout << candidatos[lcandidatos[posMayor] - 1] << endl;
				if(i != ncasos - 1)
				{
					cout << endl;
				}
				break;
			}
			else if(peores.size() == (unsigned int) ncandidatos)
			{
				for(unsigned int j = 0; j < peores.size(); j++)
				{
					cout << candidatos[lcandidatos[peores[j]] - 1] << endl;
				}
				if(i != ncasos - 1)
				{
					cout << endl;
				}
				break;
			}
			else
			{
				for(unsigned int j = 0; j < votantes.size(); j++)
				{
					vector <int> actual = votantes[j];
					for(unsigned int k = 0; k < peores.size(); k++)
					{
						int aborrar = peores[k];
						for(unsigned int l = 0; l < actual.size(); l++)
						{
							if(actual[l] == lcandidatos[aborrar])
							{
								actual[l] = 0;
							}
						}
					}
					for(unsigned int k = 0; k < actual.size(); k++)
					{
						if(actual[k] == 0)
						{
							actual.erase(actual.begin() + k);
							k--;
						}
					}
					votantes[j] = actual;
				}
				for(unsigned int j = 0; j < peores.size(); j++)
				{
					int peorAct = peores[j];
					lcandidatos[peorAct] = 0;
				}
				for(unsigned int j = 0; j < lcandidatos.size(); j++)
				{
					if(lcandidatos[j] == 0)
					{
						lcandidatos.erase(lcandidatos.begin() + j);
						j--;
					}
				}
				ncandidatos = lcandidatos.size();
			}
		}
	}
}
