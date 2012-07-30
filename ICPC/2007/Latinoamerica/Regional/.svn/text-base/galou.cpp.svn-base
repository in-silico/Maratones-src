
#include <cstdlib>
#include <cstdio>
#include <algorithm>

using namespace std;

#define MAXV 105
#define rep(i,n) for (int i=0; i<(n); i++)

int R,C;
int delta[6][2] = {{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0}};
char board[MAXV][MAXV];
bool debug=false;

void printBoard() {
	for (int i=0; i<R; i++) {
		printf("%s\n", board[i]);
	}
}

void solve() {
	int M = MAXV*MAXV;
	int tovisit[M][2];
	int hd=0;
	rep(i,R) {
		rep(j,C) {
			if (board[i][j]=='I') {
				tovisit[hd][0]=i; tovisit[hd++][1]=j;
				board[i][j] = '(';
			} else if (board[i][j]=='*') {
				board[i][j]='F';
			}
		}
	}

	char nstate;
	//BFS
	for (int tv = 0; tv < hd; tv++) {
		int i = tovisit[tv%M][0], j = tovisit[tv%M][1];
		if (debug) printBoard();
		switch (board[i][j]) {
		case '(':
			nstate=')';
			break;
		case ')':
			nstate='(';
			break;
		case 'B':
			nstate='B';
			break;
		}

		for (int k=0; k<6; k++) {
			int ni = i + delta[k][0], nj = j + delta[k][1];
			if (ni>=0 && ni<R && nj>=0 && nj<C && board[ni][nj]!='.') {
				if (nstate != board[ni][nj]) {
					board[ni][nj] = (board[ni][nj]=='F') ? nstate : 'B';
					tovisit[hd%M][0]=ni; tovisit[hd%M][1]=nj;
					hd++;
				}
			}
		}
	}

	printf("\n");
	printBoard();
}

int main() {
	while (true) {
		scanf("%d %d", &R, &C);
		if (R==0 && C==0) break;
		for (int i=0; i<R; i++) {
			scanf("%s", board[i]);
		}
		solve();
	}
}
