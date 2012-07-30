#include <iostream>
#include <cstring>
#include <vector>

using namespace std;


struct SString
{
	SString *anterior;
	char ultima;
	int hash;

	SString(SString *a, char u) : anterior(a), ultima(u) 
	{
		if(a == NULL)
			hash = 0;
		else
		{
			hash = a->hash * 31 + (u - 'A' + 1);
		}
	}

	bool operator==(const SString &otro) const
	{
		return anterior == otro.anterior && ultima == otro.ultima;
	}
};

int hash(SString *a)
{
	return a->hash;
}

template<class K, class V> struct HashMap {
    vector<pair<K, V> > tab;
    vector<char> used;
    HashMap(int maxsize) : tab(maxsize), used(maxsize, 0) {}
    V *lookup(const K &key, bool insert) {
        for (int i = hash(key) % tab.size();;) {
            if (used[i]) {
                if (*tab[i].first == *key) return &tab[i].second;
            } else {
                if (!insert) return NULL;
                used[i] = 1;
                tab[i].first = key;
                return &tab[i].second;
            }
            if (++i == tab.size()) i = 0;
        }
    }
	K *lookupKey(const K &key) {
        for (int i = hash(key) % tab.size();;) {
            if (used[i]) {
                if (*tab[i].first == *key) return &tab[i].first;
            } else {
                return NULL;
            }
            if (++i == tab.size()) i = 0;
        }
    }
    V &operator[](const K &key) { return *lookup(key, true); }
    bool contains(const K &key) { return lookup(key, false) != NULL; }
    void clear() { for(int i = 0; i < used.size(); i++) if(used[i]) { used[i] = 0; } }
};

HashMap <SString*, int> tabla(1000007);
char lectura[1010];
char lecturaSE[1010];
int tams[1010];

int main()
{
	SString *inicial = new SString(NULL, '\0');
	while(true)
	{
		cin.getline(lectura, 1010);
		int tam = strlen(lectura);
		int act = 0;
		for(int i = 0; i < tam + 1; i++)
		{
			if(lectura[i] != ' ')
			{
				tams[act] = 0;
				lecturaSE[act++] = lectura[i];
			}
		}
		tam = strlen(lecturaSE);
		if(tam == 0)
			return 0;
		tabla.clear();
		for(int i = 0; i < tam; i++)
		{
			SString *anterior = inicial;
			for(int j = i; j < tam; j++)
			{
				SString nuevo(anterior, lecturaSE[j]);
				SString **enTabla = tabla.lookupKey(&nuevo);
				if(enTabla == NULL)
				{
					SString *nuevaEntrada = new SString(nuevo.anterior, nuevo.ultima);
					tabla[nuevaEntrada] = 1;
					anterior = nuevaEntrada; 
				}
				else
				{
					int nuevoV = ++tabla[*enTabla];
					anterior = *enTabla;
					if(nuevoV > tams[j - i + 1])
						tams[j - i + 1] = nuevoV;
				}
			}
		}
		for(int i = 0; i < tam; i++)
		{
			if(tams[i] > 1)
				cout << tams[i] << endl;
		}
		cout << endl;
	}	
}
