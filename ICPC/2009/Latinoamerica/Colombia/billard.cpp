//col 2009

#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <cmath>

#define MAX 1001
#define DIM 2
#define INF 1E8
#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define PREC 1E-6

int A[4][DIM];
int *C, *P, *V;
int ent[8];
int dv[4][2] = {{1,1},{1,-1},{-1,-1},{-1,1}};
char tablero[2*MAX][2*MAX];

void diff(int *c, int *a, int *b) {
    int i;
    REP(i,DIM)  c[i]=a[i]-b[i];
}

int dotP(int *a, int *b, int n) {
    int ans = 0, i;
    REP(i,n) ans += a[i]*b[i];
    return ans;
}

bool vecEq(int *a, int *b) {
    int i;
    REP(i,DIM) {
        if (a[i]!=b[i]) return false;
    }
    return true;
}

double norm(int *a, int n) {
    return sqrt( dotP(a,a,n) );
}

int gcd(int a, int b) {
    int t;
    while (b != 0) {
        t = b;
        b = a % b;
        a = t;
    }
    return a;
}

bool solve() {
    int i;
    do {
        REP(i,4) {
            if (vecEq(A[i],P))
                return true;
        }
        if ( tablero[P[0]][P[1]]==1 )
            return false;
        tablero[P[0]][P[1]] = 1;
        REP(i,DIM) {
            P[i] = (P[i]+V[i]+MAX*2*C[i]) % (2*C[i]);
        }
    } while (true);
}

int main() {
    int i,j,mcd;
    int D[DIM];
    C=ent; P=ent+2; V=ent+6;
    while (true) {
        REP(i,8) scanf("%i", &ent[i]);
        if ( ((int)norm(ent,8)) == 0 ) break;
        diff(D,ent+4,C);
        mcd = gcd(V[0],V[1]);
        REP(i,DIM) V[i] /= mcd; //simplify
        REP(j,4) {
            REP(i,DIM) {
                A[j][i] = C[i] + dv[j][i]*D[i];
            }
        }
        if ( solve() )
            printf("HIT\n");
        else
            printf("MISS\n");
        memset(tablero, 0, sizeof(tablero));
    }
}

