
#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define MAX 8
#define MOD 100003

int g[MAX][MAX];

int fac(int x) {
    int r=1;
    for (int i=2; i<=x; i++) {
        r *= i;
    }
    return r;
}

int f(int n, int i) {
    int res = 0;
    int last = n-2;
    for (int x=i; x<=last; x++)
        res = res + g[n][x];
    return res;
}

void fill() {
    for (int n=0; n<MAX; n++) {
        for (int i = ((n==0) ? 0 : (n-1)); i<MAX; i++) {
            g[n][i] = 0;
        }
    }
    g[2][0]=1;
    for (int n=3; n<MAX; n++) {
        for (int i=0; i<(n-1); i++) {
            int res=1;
            int last = n-i-1;
            int elems = i;
            for (int elims=1; elims<=i; elims++) {
                int k=fac(elems)/(fac(elems-elims)*fac(elims));
                int r_eli = i - elims;
                res += k*f(last,r_eli);
            }
            g[n][i] = res;
        }
    }
}

int main(int argc, char** argv) {
    fill();
    int T,tc,n;
    scanf("%i", &T);
    REP(tc,T) {
        n = scanf("%i",&n);
        printf("Case #%i: %i\n", tc+1, f(n,0));
    }
}
