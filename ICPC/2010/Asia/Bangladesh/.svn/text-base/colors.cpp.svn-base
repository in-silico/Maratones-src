
#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define MAXK 51
#define MOD 1000000007
#define MAXM 205

int m,n,k;
int perms[MAXM][MAXK][MAXK];

int mypow(int b, int exp) {
    if (exp == 0) return 1;

    long ans = mypow(b,exp/2);
    ans = (ans*ans) % MOD;
    if (exp%2 == 1) ans = (ans*b) % MOD;
    return (int)ans;
}

void fill() {
    int slots,nuc,K;
    long k1,k2;
    for (K=1; K<MAXK; K++) {
        perms[0][0][K] = 1;
        for (nuc=1; nuc<=K; nuc++) perms[0][nuc][K]=0;
        for (slots=1; slots<MAXM; slots++)
            perms[slots][0][K]=mypow(K,slots);
    }
    for (K=1; K<MAXK; K++) {
        for (slots=1; slots<MAXM; slots++) {
            for (nuc=1; nuc<=K; nuc++) {
                k1= ((long)(K-nuc)) * perms[slots-1][nuc][K];
                k2 = ((long)nuc) * perms[slots-1][nuc-1][K];
                perms[slots][nuc][K] = (int)((k1+k2) % MOD);                
            }
        }
    }
}

int solve() {
    if (n*m == 1) return k;

    int a2 = m*n/2;
    int a1 = m*n - a2;
    long res=0, coef=1, term;
    int i;
    for (i=1; i<k; i++) {
        coef = (k-i+1)*coef/i;
        term = ( ((long)perms[a1][i][i]) * mypow(k-i,a2) ) % MOD;
        res += ((coef % MOD)*term) % MOD;        
    }
    return (int)(res % MOD);
}

int main(int argc, char** argv) {
    fill();
    int T,tc=0;
    scanf("%i",&T);
    REP(tc,T) {
        scanf("%i %i %i",&m,&n,&k);
        m++; n++;        
        printf("Case %i: %i\n",tc+1, solve());
    }
}


