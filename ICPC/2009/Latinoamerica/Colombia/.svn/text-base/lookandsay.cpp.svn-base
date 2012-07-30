
#include <cstdio>

#define MAX 2000

using namespace std;

char term[2*MAX + 2];
char *act, *sig;

char solve(int I, int J) {
	act=term; sig=&term[MAX+1];
	char c;
	char *tmp;
	int pact, psig, rep;
	for (int i=1; i<I; i++) {
		pact=0; psig=0;
		do {
			c = act[pact];
			rep=1;
			while (act[++pact] == c) rep++;
			sig[psig++] = rep+0x30;
			sig[psig++] = c;
		} while ( (psig-2)<MAX && act[pact]!='\0');
		sig[psig]='\0';
		tmp = act; act=sig; sig=tmp; //SWAP act,sig
	}
	return act[J-1];
}

int main() {
	int x1, i, j;
	while (true) {
		scanf("%i %i %i",&x1,&i,&j);
		if (x1==0 && i==0 && j==0) break;
		sprintf(term, "%i", x1);
		printf("%c\n", solve(i,j));
	}
}

