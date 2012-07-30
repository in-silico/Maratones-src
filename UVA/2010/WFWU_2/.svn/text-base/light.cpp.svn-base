
#include <iostream>
#include <list>

#define MAX 20005
#define LOOP 0x20000
#define DEL 0x10000

using namespace std;

list<int> hijos[MAX];
list<int> padres[MAX];
int numPadres[MAX];
int group[MAX];
int N, cgroup;

void init() {
	for (int i=0; i<N; i++) {
		hijos[i].clear(); padres[i].clear();
		numPadres[i]=0;
		group[i]=0;
	}
	cgroup=0;
}

//Creates a tree with the given root
void newtree(int root) {
	group[root] = cgroup;
	list<int> *act = &hijos[root];
	if (act->empty()) return;
	list<int>::iterator it;
	for (it=act->begin(); it != act->end(); it++) {
		if ((group[*it] & 0x1FFFF) == 0) newtree(*it);
	}
}

//Removes the loop given the original node that belongs to the loop
//and return the number of fathers of the new node
int remLoop(int orgNode) {
	int node=orgNode,father,nump=0;
	padres[N].clear(); hijos[N].clear();
	do {
		father = group[node] & 0xFFFF;
		group[node] = DEL | LOOP;
		list<int>::iterator it;
		list<int> *act = &padres[node];
		for (it=act->begin(); it != act->end(); it++) {
			//If node *it isn't in Loop add as father to new node 
			if ((group[*it] & LOOP) == 0) {
				 padres[N].push_back(*it);
				 hijos[*it].push_back(N);
				 nump++;
			}
		}
		act = &hijos[node];
		for (it=act->begin(); it != act->end(); it++) {
			//If node *it isn't in Loop add as son to new node 
			if ((group[*it] & LOOP) == 0) {
				hijos[N].push_back(*it);
				padres[*it].push_back(N);
			}
		}
		node = father;
	} while (node != orgNode);
	group[N]=0;
	N++;
	return nump;
}

int subtrees() {
	for (int i=0; i<N; i++) {
		if (numPadres[i]==0) {
			cgroup++;
			newtree(i);
		}
	}
	for (int i=0; i<N; i++) {
		while (group[i] == 0) {
			int node, father;
			node=i;
			while ((group[node] & LOOP) == 0) {
				while (true) {
					father = padres[node].front();
					if ((group[father] & DEL) == 0) break;
					padres[node].pop_front();
				}
				group[node] = LOOP | father;
				node = father;
			}
			//Loop found, remove from look other nodes
			int rnode=i;
			while (rnode != node) {
				father = group[rnode] & 0xFFFF;
				group[rnode]=0;
				rnode = father;
			}				
			if (remLoop(node) == 0) {
				//Now, N-1 is the root
				cgroup++;
				newtree(N-1);
			}
		}
	}
	return cgroup;
}

int main() {
	int T,M;
	int a,b; //Connection from a to b
	cin >> T;
	for (int c=1; c<=T; c++) {
		cin >> N >> M;
		init();
		for (int i=0; i<M; i++) {
			cin >> a >> b;
			a--; b--;
			hijos[a].push_back(b);
			padres[b].push_back(a);
			numPadres[b]++;
		}
		cout << "Case " << c << ": " << subtrees() << endl;
	}
	//cout << endl;
}
