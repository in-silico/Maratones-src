
#include <iostream>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define MAXM 100
#define MAXN 10

using namespace std;

int N,M;
int cc[MAXN][MAXM]; //cell cost
int pc[MAXN][MAXM]; //minumum path cost from col j, cell i
int next[MAXN][MAXM]; //next cell in the path (-1 if end of path)

int deltay[] = {-1,0,1};
int ndelta = 3;
#define IIX(I) (((I)+N)%N)

void fill() {
    int i,j,k;
    int minv, minix, tmpv, tmpix;
    REP(i,N) {
        next[i][M-1] = -1;
        pc[i][M-1] = cc[i][M-1];
    }
    REPB(j,M-1) {
        REP(i,N) {
            minv = 0x3fffffff;
            REP(k,ndelta) {
                tmpix = IIX(i+deltay[k]);
                tmpv = pc[tmpix][j+1];
                if (tmpv<minv || (tmpv==minv && tmpix<minix)) {
                    minix = tmpix;
                    minv = tmpv;
                }
            }
            pc[i][j] = minv + cc[i][j];
            next[i][j] = minix;
        }
    }
}

void printsol() {
    int first=-1, minv=0x3fffffff;
    int i,j;
    REP(i,N) {
        if (pc[i][0] < minv) {
            first=i;
            minv=pc[i][0];
        }
    }
    cout << (first+1);
    REP(j,M-1) {
        first = next[first][j];
        cout << " " << (first+1);
    }
    cout << endl << minv << endl;
}

int main(int argc, char** argv) {
    int i,j;
    while (cin >> N >> M) {
        REP(i,N) {
            REP (j,M) {
                cin >> cc[i][j];
            }
        }
        fill();
        printsol();
    }
}

