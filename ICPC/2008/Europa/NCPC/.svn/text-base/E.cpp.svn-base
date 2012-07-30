
#include <cstdio>
#include <cstdlib>

#define MAX 20
#define INF 2000000
#define REP(I,N) for(int I=0; I<(N); I++)
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y)  )

typedef struct {
    int price;
    int beds[MAX];
    int mbeds;
} Hostel;

int N,B,H,W;
Hostel host[MAX];

int compHost(const void *a, const void *b) {
    return ((const Hostel*)a)->price - ((const Hostel*)b)->price;
}

int solve() {
    REP(i,H) {
        if (N < host[i].mbeds)
            return host[i].price*N;
    }
    return INF;
}

int main () {
    int ans;
    while (scanf("%i %i %i %i", &N,&B,&H,&W) != EOF) {
        REP(i,H) {
            scanf("%i", &(host[i].price));
            host[i].mbeds=0;
            REP(j, W) {
                scanf("%i", &(host[i].beds[j]));
                host[i].mbeds = max(host[i].mbeds, host[i].beds[j]);
            }           
        }
        qsort(host,H,sizeof(Hostel),compHost);
        if ((ans=solve()) <= B) {
            printf("%i\n", ans);
        } else {
            printf("stay home\n");
        }
    }
}

