
/*
 * Solución del problema F: Simulación geométrica, determinación del mínimo con la derivada y
 * máquina de estados para contar la cantidad de situaciones problema.
 */

#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <algorithm>

using namespace std;

#define DIMS 3
#define rep(i,n) for(int i=0; i<(n); i++)
#define eq(X,Y) (fabs((X)-(Y)) < 1E-10)
#define leq(X,Y) ( (X)<(Y) || eq(X,Y) )

bool debug=false;
double zerovec[3] = {0.0, 0.0, 0.0};

double dot(double *x, double *y) {
    double ans=0;
    rep(i,DIMS) {
       ans += x[i]*y[i];
    }
    return ans;
}
    
double norm(double *x) {
    return sqrt(dot(x,x));
}

void addv(double *ans, double *x, double *y) {
    rep(i,DIMS)
        ans[i] = x[i] + y[i];
}

void subs(double *ans, double *x, double *y) {
    rep(i,DIMS)
        ans[i] = x[i] - y[i];
}

void multscal(double *ans, double scalar, double *x) {
    rep(i,DIMS)
        ans[i] = scalar * x[i];
}

double dist(double *a, double *b) {
    double tmp[3];
    subs(tmp, a, b);
    return norm(tmp);
}

void printVec(double *x) {
    rep(i,DIMS) printf("%lf; ", x[i]);
}

void copyvec(double *ans, double *x) {
    rep(i,DIMS) ans[i] = x[i];
}

typedef struct {
    int k;
    double r,s;
    double route[101][DIMS];
    double pos[DIMS];
} Aircraft;

Aircraft p,q;
int hits=0, state=0;

void newPos(double *ans, double *x0, double *v, double t) {
    double tmp[3];
    multscal(tmp, t, v);
    addv(ans, tmp, x0);
}
    
void updateHits(double *p1, double *q1) {
    double vp[DIMS],vq[DIMS],vdiff[DIMS], xdiff[DIMS];
    double tmp[DIMS], tmp1[DIMS], np[DIMS], nq[DIMS];
    subs(tmp, p1, p.pos); multscal(vp, p.s/norm(tmp), tmp);
    double tp = norm(tmp)/p.s;
    subs(tmp, q1, q.pos); multscal(vq, q.s/norm(tmp), tmp);
    double tq = norm(tmp)/q.s;
    subs(vdiff, vp, vq); subs(xdiff, p.pos, q.pos);
    double tmin = - dot(xdiff,vdiff) / dot(vdiff,vdiff);
    double t = min(tp,tq);
    newPos(np, p.pos, vp, t); newPos(nq, q.pos, vq, t);
    if (debug) {
        printf("\nPosP: "); printVec(p.pos);
        printf("\nPosQ: "); printVec(q.pos);
        printf("\nVelP: "); printVec(vp);
        printf("\nVelQ: "); printVec(vq);
        printf("\nVelDiff: "); printVec(vdiff);
        printf("\nt-min: %lf, t-p:%lf, t-q:%lf, t=%lf\n", tmin, tp, tq, t);
        printf("newP: "); printVec(np); printf("\nnewQ: "); printVec(nq);
    }
    
    if (state==0) {
        //No active
        if ( leq( dist(np,nq), p.r+q.r ) ) {
            state=1; hits++;
        } else {
            if (tmin>0 && tmin<t) {
                newPos(tmp, p.pos, vp, tmin); newPos(tmp1, q.pos, vq, tmin);
                if ( leq( dist(tmp,tmp1), p.r+q.r ) ) {
                    hits++;
                }
            }
        }
    } else {
        //Active
        if ( !leq( dist(np,nq), p.r+q.r ) ) {
            state=0;
        }
    }
    if (debug) printf("state=%d, hits=%d\n", state, hits);
    copyvec(p.pos, np); copyvec(q.pos, nq);    
}
    
    
void solve() {
    int cp=0, cq=0;
    copyvec(p.pos, p.route[0]); copyvec(q.pos, q.route[0]);
    if ( leq( dist(p.pos, q.pos), p.r+q.r ) ) {
        state=1;
        hits=1;
    } else {
        state=0;
        hits=0;
    }
    while ( cp < p.k && cq < q.k ) {
        if (debug) getchar();
        updateHits(p.route[cp+1], q.route[cq+1]);
        if ( eq(dist(p.pos, p.route[cp+1]), 0.0) ) cp++;
        if ( eq(dist(q.pos, q.route[cq+1]), 0.0) ) cq++;        
    }
}

int main() {
    int N;
    scanf("%d", &N);
    rep(tc,N) {
        scanf("%lf %lf %d", &(p.r), &(p.s), &(p.k));
        rep(i,p.k) {
            scanf( "%lf %lf %lf", &(p.route[i][0]), &(p.route[i][1]), &(p.route[i][2]) );
        }
        copyvec(p.route[p.k],zerovec);
        scanf("%lf %lf %d", &(q.r), &(q.s), &(q.k));
        rep(i,q.k) {
            scanf( "%lf %lf %lf", &(q.route[i][0]), &(q.route[i][1]), &(q.route[i][2]) );
        }
        copyvec(q.route[q.k],zerovec);
        solve();
        printf("%d\n",hits);
    }
}
