
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
#define MAX 500000

using namespace std;

int seq[MAX];
int N;

int NOD(int x) {
    int ans=2, i;
    for (i=2; (i*i)<x; i++) {
        if (x%i == 0)
            ans += 2;
    }
    if (x == i*i) ans++;
    return ans;
}

void fill() {
    seq[0] = 1; seq[1] = 2;
    N=1;
    while (seq[N++]<1000000) {
        seq[N] = seq[N-1] + NOD(seq[N-1]);
    }
}

//retorna índice de x en seq, si no esta retorna el índice del número
//mas cercano por la izquierda(si param=1) o por la derecha(si param=2)
int binSearch(int beg, int end, int x, int param=1) {
    if (beg == end) {
        if (seq[beg] == x) return beg;
        if (param==1)
            return (seq[beg] < x) ? beg : beg-1;
        else
            return (seq[beg] > x) ? beg : beg+1;
    }
    int m = (beg+end)/2;
    if (x == seq[m]) return m;
    if (x < seq[m]) {
        return binSearch(beg, m-1, x, param);
    } else {
        return binSearch(m+1, end, x, param);
    }
}

int main() {
    int T,a,b;
    fill();
    scanf("%i", &T);
    REP(tc,T) {
        scanf("%i %i",&a, &b);
        a = binSearch(0,N-1,a,2);
        b = binSearch(0,N-1,b,1);
        printf("Case %i: %i\n", tc+1, b-a+1);
    }
}
