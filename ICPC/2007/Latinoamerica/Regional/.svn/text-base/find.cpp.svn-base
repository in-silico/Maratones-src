
#include <cstdlib>
#include <cstdio>
#include <algorithm>

using namespace std;

#define MAXV 350
#define rep(i,n) for (int i=0; i<(n); i++)

int ii[MAXV][MAXV];
char board[MAXV][MAXV];
int R,C,K;
bool debug=false;

void compII() {
	ii[0][0] = (board[0][0]=='.');
	for (int i=1; i<R; i++) ii[i][0] = ii[i-1][0] + (board[i][0]=='.');
	for (int i=1; i<C; i++) ii[0][i] = ii[0][i-1] + (board[0][i]=='.');
	for (int i=1; i<R; i++) {
		for (int j=1; j<C; j++) {
			ii[i][j] = ii[i-1][j] + ii[i][j-1] - ii[i-1][j-1] + (board[i][j]=='.');
		}
	}
	if (debug) {
		rep(i,R) {
			rep(j,C) {
				printf("%d,", ii[i][j]);
			}
			printf("\n");
		}
	}
}

int solve() {
	int area = 0x7fffffff;
	compII();
	int tmp[R+1];
	for (int j1=0; j1<C; j1++) {
		for (int j2=j1; j2<C; j2++) {
			tmp[0]=0;
			for (int i=0; i<R; i++) {
				int subs = (j1==0) ? 0 : ii[i][j1-1];
				tmp[i+1] = (ii[i][j2] - subs);
			}
			int width = j2-j1+1, i1=0, i2=1;
			while (i2 <= R) {
				int freech = tmp[i2]-tmp[i1];
				if (freech >= K) {
					int narea = width * (i2-i1);
					if (debug && narea<area) {
						printf("New best area=%d: [%d,%d]->[%d,%d]\n",narea,i1,j1,i2-1,j2);
					}
					area = min(area, narea);
					i1++;
				} else {
					i2++;
				}
			}
		}
	}
	return area;
}

int main() {
	while (true) {
		scanf("%d %d %d", &R, &C, &K);
		if (R==0 && C==0 && K==0) break;
		rep(i,R) {
			scanf("%s",board[i]);
		}
		int ans=solve();
		printf("%d\n", ans);
	}
}
