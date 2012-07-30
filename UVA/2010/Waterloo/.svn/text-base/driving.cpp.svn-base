
#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <cmath>

#define MAX 1000001
#define INF 1E8
#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )
#define PREC 1E-6

typedef struct {
    int from;
    int to;
    long cost;
} Edge;

int N,M;
int parent[MAX];
Edge edges[MAX];

int compareEdges(const void *a, const void *b) {
    return ((Edge*)a)->cost - ((Edge*)b)->cost;
}

int findset(int x) {
    if (parent[x] == x)
        return x;
    parent[x]=findset(parent[x]);
    return parent[x];
}

void unionset(int x, int y) {
    parent[findset(x)] = findset(y);
}

//Kruskal que retorna arista de costo maximo
int kruskal() {
    int i;
    long maxcost;
    REP(i,N) parent[i]=i;
    qsort(edges, M, sizeof(Edge), compareEdges);

    maxcost=0;
    REP(i,M) {
        if (findset(edges[i].from) != findset(edges[i].to)) {
            maxcost = max(maxcost, edges[i].cost);
            unionset(edges[i].from, edges[i].to);
        }
    }

    return maxcost;
}

bool isPossible() {
    int i, myset;
    myset = findset(0);
    REP(i,N) {
        if (findset(i) != myset) return false;
    }
    return true;
}

int main() {
    int i, ans;
    while (true) {
        scanf("%i %i", &N, &M);
        if (N==0 && M==0) break;
        REP(i,M) {
            scanf("%i %i %li", &(edges[i].from), &(edges[i].to), &(edges[i].cost));
        }
        ans = kruskal();
        if (isPossible())
            printf("%d\n", ans);
        else
            printf("IMPOSSIBLE\n");
    }
}

