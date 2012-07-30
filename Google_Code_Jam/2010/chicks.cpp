
#include <cstdio>

#define MAX 100
#define REP(i,n) for((i)=0;(i)<(n);(i)++)

int N,K,B,T;
int x[MAX];
int v[MAX];

bool canArrive(int chick) {
	return (x[chick] + T*v[chick]) >= B; 
}

int solve() {
	int i,chicks,cost,disturb;
	scanf("%i %i %i %i",&N,&K,&B,&T);
	if (K > N) return -1;
	REP (i,N) scanf("%i",&(x[i]));
	REP (i,N) scanf("%i",&(v[i]));
	chicks=cost=disturb=0;
	for (i=N-1; i>=0; i--) {
		if (canArrive(i)) {
			chicks++;
			cost += disturb;
			if (chicks == K) return cost;
		} else {
			disturb++;
		}
	}
	if (chicks < K) return -1;
	return cost;
}

int main() {
	int c, TC;
	scanf("%i",&TC);
	REP(c,TC) {
		int s=solve();
		printf("Case #%i: ", (c+1));
		if (s==-1) printf("IMPOSSIBLE\n");
		else printf("%i\n",s);
	}
}
