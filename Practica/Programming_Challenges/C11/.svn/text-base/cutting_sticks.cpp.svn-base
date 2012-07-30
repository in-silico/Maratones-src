
#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define MAX 60


int N;
float P[MAX+2];
float T[MAX+2][MAX+2];

void fill() {
    int i,l,r;
    float cost,minv,len;
    REP(i,N-1) {
        T[i][i] = 0;
        T[i][i+1] = 0;
    }
    T[i][i]=0;
    for (l=N-3; l>=0; l--) {
        for (r=l+2; r<N; r++) {
            minv = 1E8;
            len = P[r] - P[l];
            for (i=l+1; i<r; i++) {
                cost = T[l][i] + T[i][r] + len;
                minv = min(minv, cost);
            }
            T[l][r] = minv;
        }
    }
}

int main(int argc, char** argv) {
    int n;
    float L;
    while (true) {
        scanf("%f",&L);
        if (L==0) break;
        scanf("%i",&n);
        N=n+2;
        P[0]=0; P[N-1]=L;
        for (int i=0; i<n; i++) {
            scanf("%f",&P[i+1]);
        }
        fill();
        printf("The minimum cutting is %i.\n",(int)round(T[0][N-1]));
    }
}

