
#include <cstdio>
#include <cstring>
#include <cstdlib>

#define ANY 0x7fffffff
#define MAX 400

#define max(x,y) ( ((x)>(y)) ? (x) : (y) )
#define min(x,y) ( ((x)<(y)) ? (x) : (y) )

using namespace std;

typedef struct {
	int x;
	int y;
} Punto;

int X1,Y1,X2,Y2;
int N;
Punto puntos[MAX];
Punto sx[MAX];
Punto sy[MAX];

int sortX(const void *a, const void *b) {
	int x = ((const Punto*)a)->x - ((const Punto*)b)->x;
}

int sortY(const void *a, const void *b) {
	return ((const Punto*)a)->y - ((const Punto*)b)->y;
}

void solve() {
	int a=0,b=0;
	for (int i=0; i<=N; i++) {
		int x1 = sx[i].x;
		int j=0;
		while ( j<=N && (sy[j].y < sx[i].y) ) {
			int y1 = sy[j].y;
			int maxy=Y2;
			for (int k=i+1; k<N+2; k++) {
				int y2 = sx[k].y;
				if (y2 > y1 && (y2<maxy || y2==ANY)) {
					int x2 = sx[k].x;
					int l1=maxy-y1, l2=x2-x1;
					maxy = sx[k].y;
					int la=min(l1,l2), lb=max(l1,l2);
					if (la>a || (la==a && lb>b)) {
						a = la; b=lb;
					}
				}
			}
			j++;
		}
	}
	printf("%i %i\n", a, b);
}

int main() {
	while (true){
		scanf("%i %i %i %i", &X1, &Y1, &X2, &Y2);
		if (X1==0 && Y1==0 && X2==0 && Y2==0) break;
		scanf("%i", &N);
		for (int i=0; i<N; i++) {
			scanf( "%i %i", &(puntos[i].x), &(puntos[i].y) );
		}
		memcpy(sx+1, puntos, N*sizeof(Punto));
		memcpy(sy+1, puntos, N*sizeof(Punto));
		sx[0].x = X1; sx[0].y=ANY; //left side
		sx[N+1].x = X2; sx[N+1].y=ANY; //right side
		sy[0].x = ANY; sy[0].y=Y1; //top side
		sy[N+1].x = ANY; sy[N+1].y=Y2; //buttom side
		qsort(sx+1,N,sizeof(Punto),sortX);
		qsort(sy+1,N,sizeof(Punto),sortY);

		solve();
	}
}

