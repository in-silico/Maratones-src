#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <cmath>

#define INF 1E8
#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )
#define PREC 1E-6

int compareTo(const void *a, const void *b) {
    return (*(int*)a) - (*(int*)b);
}

int gcd(int a, int b) {
    int t;
    while (b!=0) {
        t=b;
        b=a % b;
        a=t;
    }
    return a;
}

int main() {
    int num[3];
    int div,i;
    while (true) {
        scanf("%i %i %i", &num[0], &num[1], &num[2]);
        if (num[0] == 0 && num[1]==0 && num[2]==0) break;
        qsort(num, 3, sizeof(int), compareTo);
        div = gcd( gcd(num[0],num[1]), num[2]);
        REP(i,3) num[i]/=div;
        if (num[2]*num[2] == num[1]*num[1] + num[0]*num[0])
            printf("right\n");
        else
            printf("wrong\n");
    }
}

