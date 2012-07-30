
#include <cstdlib>
#include <cstdio>
#include <iostream>

#define MAXN 2001
#define INF 10000
#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define REPB(i,N) for((i)=(N)-1; (i)>=0; (i)--)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )

using namespace std;

int P[MAXN][MAXN];
int N;

void init() {
    int i, j;
    REP(i,N) {
        REP(j,N) {
            if (i != j)  P[i][j] = INF;
            else P[i][j] = 0;
        }
    }
}

void floyd() {
    int i,j,k;
    REP(k,N) {
        REP(i,N) {
            REP(j,N) {
                P[i][j] = min(P[i][j], P[i][k] + P[k][j]);
            }
        }
    }
}

bool check() {
    int i,j;
    REP(i,N) {
        REP(j,N) {
            if (P[i][j] == INF) return false;
        }
    }
    return true;
}

/*
 * 
 */
int main(int argc, char** argv) {
    int i,M,f,t,d;
    while (true) {
        scanf("%i %i", &N,&M);
        if (N==0 && M==0) break;
        init();
        REP(i,M) {
            scanf("%i %i %i", &f, &t, &d);
            P[f-1][t-1]=1;
            if (d==2) P[t-1][f-1]=1;
        }
        floyd();
        if (check())
            printf("1\n");
        else
            printf("0\n");
    }
}


