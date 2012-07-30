
#include <cstdio>
#include <complex>
#include <cmath>

#define Punto complex<long long int>

using namespace std;

typedef struct Node1 {
	int key;
	int val;
	struct Node1 *next;
} Node;

class HashTable {
	Node *buffer;
	int currNode;

	Node *getNewNode() {
		return &(buffer[currNode++]);
	}
public:
	int N;
	int N1;
	Node **data;

	HashTable(int N, int bufsize) {
		this->N = N;
		this->N1 = N - 1;
		data = new Node*[N];
		for (int i=0; i<N; i++) data[i]=0;
		buffer = new Node[bufsize];
		currNode=0;
	}

	void clear() {
	    currNode=0;
		for (int i=0; i<N; i++) {
			data[i]=0;
		}
	}

	int& operator[](int key) {
		int slot = (int)(key&(N1));
		Node *x=data[slot];
		while (x != 0) {
			if (x->key == key) return x->val;
			x = x->next;
		}
		x=getNewNode();
		x->key=key; x->val=0; x->next=data[slot];
		data[slot] = x;
		return x->val;
	}
};

HashTable mapa(1024 * 1024 * 16, 1024 * 1024 * 16);
int a[4001], b[4001], c[4001], d[4001];

int main()
{
    int casos;
    scanf("%d", &casos);
    bool empezo = false;
    for(int caso = 0; caso < casos; caso++)
    {
        if(empezo)
            printf("\n");
        empezo = true;
        int n;
        scanf("%d", &n);
        for(int i = 0; i < n; i++)
            scanf("%d %d %d %d", &a[i], &b[i], &c[i], &d[i]);
        for(int i = 0; i < n; i++)
		    for(int j = 0; j < n; j++)
			    mapa[a[i] + b[j]]++;
		long long cuenta = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				cuenta += mapa[-(c[i] + d[j])];
		printf("%lld\n", cuenta);
        mapa.clear();
    }
}
