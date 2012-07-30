/* 
 * File:   main.cpp
 * Author: seb
 *
 * Created on 22 de mayo de 2010, 04:43 PM
 */

#include <cstdio>
#include <cstring>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define MAX 5
#define KMAX 30

int lists[MAX][KMAX];

int nombre(char *name) {
    if (strcmp(name,"Ja") == 0) return 0;
    if (strcmp(name,"Sam") == 0) return 1;
    if (strcmp(name,"Sha") == 0) return 2;
    if (strcmp(name,"Sid") == 0) return 3;
    else return 4;
}

int main(int argc, char** argv) {
    int T,N,M,act,t,tc,i,j,n;
    char name[5];
    int times[MAX];
    int indices[MAX];
    int sizes[MAX];
    scanf("%i",&T);
    REP(tc,T) {
        scanf("%i %i %s", &M, &N, name);
        act = nombre(name);
        REP(i,MAX) {
            times[i]=0; indices[i]=0;
            scanf("%i",&n);
            REP(j,n) {
                scanf("%s",name);
                lists[i][j]=nombre(name);
            }
            sizes[i]=n;
        }

        t=0;
        while (t<=N) {
            if (t <= (N-M)) {
                t += M;
                times[act] += M;
            } else {
                times[act] += N-t;
                t = N;
            }
            t += 2;
            act = lists[act][ (indices[act]++) % sizes[act] ];
        }

        printf("Case %d:\n", tc+1);
        printf("Ja %d\n", times[0]);
        printf("Sam %d\n", times[1]);
        printf("Sha %d\n", times[2]);
        printf("Sid %d\n", times[3]);
        printf("Tan %d\n", times[4]);
    }
}
