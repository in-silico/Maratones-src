#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <cmath>
#include <queue>

#define REP(i,N) for(int i=0; i<(N); i++)
#define REPB(i,N) for((i)=(N)-1; (i)>=0; (i)--)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )
#define PREC 1E-6

using namespace std;

int main() {
    int T,n,x;
    scanf("%i", &T);
    REP(tc,T) {
        scanf("%i",&n);
        REP(i,n) {
            scanf("%i",&x);
            if (i == n/2) {
                printf("Case %i: %i\n", tc+1, x);
            }
        }
    }
}
