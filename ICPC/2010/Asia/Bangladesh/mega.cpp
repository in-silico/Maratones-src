/* 
 * File:   main.cpp
 * Author: seb
 *
 * Created on 22 de mayo de 2010, 04:43 PM
 */

#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define MAX 17

long T[1<<MAX];
int N,U;
int kill[MAX];

long perms(int K) {
    int P=0, i, nk, mask;
    long res=0;

    REP(i,N+1) {
        if (K & (1<<i)) P |= kill[i];
    }
    P = ( (P<<1)|1 ) - K;

    if (P==0) {
        T[K]=0;
        return 0;
    }

    REP(i,N+1) {
        mask = (1<<i);
        if (P & mask) {
            nk = K | mask;
            if (T[nk] != -1)
                res += T[nk];
            else
                res += perms(nk);
        }
    }

    T[K] = res;
    return res;
}

long fill() {
    int i;
    U=(1<<N+1)-1;
    REP(i,U) {
        T[i] = -1;
    }
    T[U] = 1;
    return perms(1);
}

int main(int argc, char** argv) {
    int TC, tc;
    int flag;
    char cad[MAX+1];
    scanf("%i", &TC);
    REP(tc,TC) {
        scanf("%i", &N);
        int i,j;
        REP(i,N+1) {
            kill[i]=0;
            scanf("%s", cad);
            REP(j,N) {
                flag = cad[j]-0x30;
                kill[i] |= (flag << j);
            }
        }
        printf("Case %i: %li\n",tc+1,fill());
    }
}

