
#include <cstdio>
#include <complex>
#include <cmath>

#define Punto complex<long long int>

using namespace std;

typedef struct Node1 {
	long long key;
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
	Node **data;

	HashTable(int N, int bufsize=1000) {
		this->N = N;
		data = new Node*[N];
		for (int i=0; i<N; i++) data[i]=0;
		buffer = new Node[bufsize];
		currNode=0;
	}

	~HashTable() {
		clear();
		delete [] data;
	}

	void clear() {
		for (int i=0; i<N; i++) {
			/*Node *x=data[i];
			while (x != 0) {
				Node *next = x->next;
				delete x;
				x = next;
			}*/
			currNode=0;
			data[i]=0;
		}
	}

	int& operator[](long long key) {
		int slot = (int)(key%N);
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

int N;
Punto P[1005];
HashTable T(998);

int solve() {
	int ans=0;
	for (int i=0; i<N; i++) {
		for (int j=0; j<N; j++) {
			if (i!=j) {
				Punto p = P[i]-P[j];
				long long dist = norm(p);
				T[ dist ]++;
			}
		}
		for (int j=0; j<T.N; j++) {
			Node *x = T.data[j];
			while (x != 0) {
				int y = x->val;
				ans += (y*(y-1))/2;
				x = x->next;
			}
		}
		T.clear();
	}
	return ans;
}

int main() {
	while (true) {
		scanf("%i",&N);
		if (N==0) break;
		for (int i=0; i<N; i++) {
			int x,y;
			scanf("%i %i", &x, &y);
			P[i] = Punto(x,y);
		}
		int x=solve();
		printf("%i\n", x);
	}
	return 0;
}

