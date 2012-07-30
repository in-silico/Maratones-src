
#include <cstdio>
#include <cstdlib>

#define REP(i,N) for(int i=0; i<(N); i++)
#define MAX 1001
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

char B[MAX][MAX];
int m;
int R,C;
int d[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};

int possible(int i, int j) {
    if (i>=0 && i<R) {
        if (j>=0 && j<C)
            return B[i][j]=='.';
    }
    return false;
}

//inverted sort
int compareTo(const void*a, const void *b) {
    return *((int*)b) - *((int*)a);
}

int maxLab(int i, int j) {
    int sons[4];
    B[i][j]='*';
    int k=0;
    REP(x, 4) {
        int ni = i+d[x][0], nj = j+d[x][1];
        if (possible(ni, nj))
            sons[k++] = maxLab(ni, nj);
    }
    if (k==0) return 0;
    qsort(sons, k, sizeof(int), compareTo);
    if (k>=2)
        m=max(m, sons[0]+sons[1]+2);
    return sons[0]+1;
}

int main() {
    int T;
    scanf("%i", &T);
    REP(tc, T) {
        scanf("%i %i", &C, &R);
        m=0;
        REP(i,R) {
            scanf("%s", B[i]);
        }
        REP(i,R) {
            REP(j, C) {
                if (B[i][j]=='.') {
                    int tmp = maxLab(i,j);
                    m=max(m,tmp);
                }
            }
        }
        printf("Maximum rope length is %i.\n",m);
    }
}
