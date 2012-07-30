
#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define MAX 205
#define MAXL 10000

#define NCOMP 0
#define PORT 1
#define STAR 2
#define NNUL 3

class Node {
public:
    int cars; //amount of cars can be loaded
    char choice; //{0,1} choice taken
    Node *next;
};

int N; //Number of cars in queue
int lf; //lenght of ferry
int lenghts[MAX];
Node T[MAX][MAXL+1];


Node* ferry(int c, int l1, int l2) {

    Node *ans = &T[c][l1];
    if (ans->choice != NCOMP) return ans;
    
    ans->cars=c; ans->next=0; ans->choice=NNUL;
    if (c >= N) {
        return ans;
    }

    int lact = lenghts[c];
    Node *r1=0, *r2=0;

    if ((lf-l1) >= lact) {
        r1 = ferry(c+1,l1+lact,l2);
    }
    if (l1 == l2) {
        if (r1!=0) {
            ans->cars = r1->cars;
            ans->next = r1;
            ans->choice=PORT;
        }
        return ans;
    }
    if ((lf-l2) >= lact) {
        r2 = ferry(c+1,l1,l2+lact);
    }

    if (r1==0 && r2==0) {
        return ans;
    }

    Node *r;
    if (r1!=0 && r2!=0) {
        if (r1->cars > r2->cars) {
            ans->choice=PORT;
            r = r1; //delete r2;
        } else {
            ans->choice=STAR;
            r = r2; //delete r1;
        }
    } else if (r1==0) {
        r = r2;
        ans->choice=STAR;
    } else {
        r = r1;
        ans->choice=PORT;
    }

    ans->cars = r->cars;
    ans->next = r;
    return ans;
}

int main(int argc, char** argv) {
    int TC, tc, lcar, sums, i, j;
    scanf("%i",&TC);
    REP(tc, TC) {
        scanf("%i",&lf);
        lf *= 100; //To centimeters
        N=0; sums=0;
        while (true) {
            scanf("%i",&lcar);
            if (lcar == 0) break;
            lenghts[N++]=lcar;
            sums += lcar;
            if (sums > (2*lf)) {
                do {
                    scanf("%i",&lcar);
                } while (lcar != 0);
                break;
            }
        }
        REP(i,N+1) {
            REP(j,MAXL+1) {
                T[i][j].choice=NCOMP;
            }
        }
        Node *ans = ferry(0,0,0);
        printf("%i\n", ans->cars);
        REP(i,ans->cars) {
            const char *cad = (ans->choice==PORT) ? "port" : "starboard";
            printf("%s\n", cad);
            ans = ans->next;
        }
        if (TC-tc != 1) printf("\n");
    }
}

