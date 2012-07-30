
#include <cstdio>

#define MAX 1000

using namespace std;

long g[MAX+1]; //Cantidad de personas en cada grupo
long q[MAX+1]; //Cola q[i] primero en el turno i
long e[MAX+1]; //Euros en el turno i

int R; //Numero de turnos
int k; //Capacidad del coaster
int N; //Número de grupos
int T; //Num of test cases
long turn; //Current turn
int a,b; //Repeated range
long u; //Utility
long totPeople;

void init() {
	turn=0;
	totPeople=0;
	for (int i=0;i<N; i++){
		q[i]=-1;
		e[i]=0;
		totPeople += g[i];
	}
    q[0]=0;
    u=0;
}

int find_q(int val) {
	for (int i=0; i<N; i++) {
		if (q[i] == val) return i;
	}
	return -1;
}

bool doTurn() {
	int i=q[turn];
	int u_turn=0; //utilidad del turno
	while (u_turn <= k) {
		u_turn += g[i];
		if ((++i) == N) i=0;
	}
        i--;
        if (i<0) i+=N;
	u_turn -= g[i];	
	e[turn] = u_turn;
	u += u_turn;
	if ((a=find_q(i)) != -1) {
		b=turn;
        turn++;
		return true;
	}
	q[turn+1] = i;
	turn++;
	return false;
}

int main() {
	long numPerson;
	scanf("%i",&T);
	for (int caso=1; caso <= T; caso++) {
		printf("Case #%i: ", caso);
		scanf("%i %i %i",&R,&k,&N);
		for (int j=0;j<N;j++) {
			scanf("%li",&(g[j]));
		}
		init();
		if (totPeople <= k) {
			printf("%li\n",totPeople*R);
			continue;
		}
		while (!doTurn() && turn<R);
		if (turn == R) {
			printf("%li\n",u);
		} else {
			long ut_cycle=0;
			int periodo=(b-a+1);
			for (int i=a; i<=b; i++) {
				ut_cycle += e[i];
			}
			R -= turn;
			u += ut_cycle*(R/periodo);
			for (int i=0; i<(R%periodo); i++) {
				u += e[a+i];
			}
			printf("%li\n",u);
		}
	}
}

