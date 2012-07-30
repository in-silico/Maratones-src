
#include <cstdio>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define MAX 50
#define B 1
#define R 2

int N,K;
char board[MAX+1][MAX+1];

void pb() {
    int i;
    REP(i,N) {
        printf("%s\n",board[i]);
    }
}

void fall(int i, int j) {
    int k=N-1;
    while (k>j && board[i][k]!='.') k--;
    if (k!=j) {
        board[i][k]=board[i][j];
        board[i][j]='.';
    }
}

char* solve() {
    int i,j,k,r;
    int dx[]={1,0,1,1}, dy[]={0,1,1,-1};
    int mask=0;
    REP(i,N) {
        REPB(j,N) {
            if (board[i][j] != '.') fall(i,j);
        }
    }

    REP(i,N) {
        REP(j,N) {
            char c=board[i][j];
            if (c=='.') continue;
            REP(r,4) {
                REP(k,K) {
                    int x=j+k*dx[r], y=i+k*dy[r];
                    if (x<0 || x>=N || y<0 || y>=N) break;
                    if (c != board[y][x]) break;
                }
                if (k==K) mask|=(c=='B')?B:R;
            }
        }
    }
    
    char *ans;
    switch (mask) {
        case (B|R):
            ans = "Both";
            break;
        case B:
            ans = "Blue";
            break;
        case R:
            ans = "Red";
            break;
        case 0:
            ans = "Neither";
            break;
    }
    return ans;
}


int main(int argc, char** argv) {
    int T,i,c;
    scanf("%i",&T);
    REP(c,T) {
        scanf("%i %i",&N,&K);
        REP(i,N) {
            scanf("%s",board[i]);
        }
        printf("Case #%i: %s\n",c+1,solve());
    }
}
