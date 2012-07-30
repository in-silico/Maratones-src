
#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define MAX 1005
#define MFIB 20
#define INF 1E10

int fib[MFIB];
int aprox[MAX];
double e[MAX];

int fibix(int n) {
    int i;
    REP(i,MFIB) {
        if (fib[i] > n) break;
    }
    return i-1;
}

void fill() {
    fib[0]=0; fib[1]=1;
    for (int i=2; i<MFIB; i++) fib[i] = fib[i-1] + fib[i-2];

    double naprox, ne, real;
    int ix;
    aprox[0]=0; aprox[1]=2;
    e[0]=0; e[1]=0.4;
    for (int n=2; n<MAX; n++) {
        ix = fibix(n);
        real = n*1.6;
        e[n] = INF;
        for (int i=1; i<=ix; i++) {
            naprox = fib[i+1] + aprox[ n - fib[i] ];
            ne = fabs(naprox-real);
            if (ne < e[n]) {
                aprox[n] = naprox;
                e[n] = ne;
            }
        }
    }
}

int main(int argc, char** argv) {
    int N;
    fill();
    while (true) {
        scanf("%i", &N);
        if (N==0) break;
        double ans = e[N];
        printf("%.2lf\n", ans);
    }
}

