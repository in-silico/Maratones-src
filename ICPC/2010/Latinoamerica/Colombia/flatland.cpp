/* flatland.in

6
2
20 23
1 1 0 0 BOB
3 3 3 0 ALICE
3
20 23
2 2 4 0 ALICE
4 2 2 0 BOB
1 3 0 3 CHARLES
3
20 20
2 2 4 0 A
4 2 2 0 B
1 3 0 3 C
4
20 20
2 3 2 0 A
1 2 20 2 B
3 2 0 2 C
4 3 4 0 D
2
20 20
1 2 20 2 A
2 3 2 0 B
3
20 20
1 3 20 3 A
2 4 2 0 B
3 3 0 3 C

*/

#include <cstdlib>
#include <cstring>
#include <fstream>
#include <iostream>
#include <cmath>

#define MAX 200
#define DIM 2
#define INF 1E8
#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define PREC 1E-6

using namespace std;

typedef struct {
    int i;
    int j;
    double t;
} Intersect;

char* name[MAX];
double P[MAX][DIM];
double V[MAX][DIM];
double D[MAX][DIM];
double TD[MAX];
double RTD[MAX];
int B,H;
int N;
Intersect cruces[101*101];

void subs(double *c, double *a, double *b) {
    int i;
    REP(i,DIM) {
        c[i] = a[i]-b[i];
    }
}

double dotp(double *a, double *b) {
    int i; double ans=0;
    REP(i,DIM) {
        ans += a[i]*b[i];
    }
    return ans;
}

double norm(double *a) {
    return sqrt(dotp(a,a));
}

void multEsc(double* ans, double *a, double esc) {
    int i;
    REP(i,DIM) {
        ans[i] = a[i]*esc;
    }
}

void div_vec(double *c, double* a, double *b) {
    int i;
    bool always=false;
    double tmp;
    REP(i,DIM) {
        if (abs(b[i])<PREC) c[i] = INF;
        if (abs(b[i])<PREC && abs(a[i])<PREC) always=true;
        else c[i]=a[i]/b[i];
    }
    if (always) {
        c[0] = c[1] = min(c[0],c[1]);
    }
}

double timeInt(int i, int j) {
    double dV[DIM], dP[DIM], t[DIM];
    subs(dV,V[i],V[j]);
    subs(dP,P[j],P[i]);
    div_vec(t, dP, dV);
    if (t[0]>0 && t[0]<INF && abs(t[0]-t[1])<PREC) {
        return t[0];
    }
    return INF;
}

int max() {
    double m=-1;
    int ix=-1; int i;
    REP(i, N) {
        if ( (m<RTD[i] && abs(m-RTD[i])>PREC) || ( abs(m-RTD[i])<PREC && strcmp(name[i],name[ix])>0 ) ) {
            m=RTD[i];
            ix=i;
        }
    }
    return ix;
}

int comparar(const void *a, const void *b) {
    if ( ((const Intersect*)a)->t - ((const Intersect*)b)->t > 0)
        return 1;
    else
        return -1;
}

void solve() {
    int i,j,k,ix;
    double t;
    k=0;
    REP(i,N) {
        for (int j=i+1; j<N; j++) {
            t = timeInt(i,j);
            if ( t<min(TD[i],TD[j]) ) {
                cruces[k].i=i;
                cruces[k].j=j;
                cruces[k].t=t;
                k++;
            }
        }
    }
    if (k > 0)
        qsort( cruces, k, sizeof(Intersect), comparar );

    //REP(i,k) cout << cruces[i].i << "," << cruces[i].j << "," << cruces[i].t << endl;
    REP(i,N) RTD[i]=INF;
    REP(ix, k) {
        Intersect x = cruces[ix];
        if (RTD[x.i]!=INF || RTD[x.j]!=INF)
            continue;
        int ix2 = ix+1;
        while (ix2 < k) {
            Intersect x2 = cruces[ix2];
            if (abs(x.t - x2.t) > PREC) break;
            if (x.i==x2.i || x.i==x2.j || x.j==x2.i || x.j==x2.j) {
                RTD[x.i]=x.t; RTD[x.j]=x.t; RTD[x2.i]=x.t; RTD[x2.j]=x.t;
            }
            ix2++;
        }
        if (RTD[x.i]==INF && RTD[x.j]==INF) {
            char *tmp = name[cruces[ix].i];
            name[cruces[ix].i] = name[cruces[ix].j] ;
            name[cruces[ix].j] = tmp;
        }
    }
    REP(i,N) RTD[i] = min(RTD[i],TD[i]);
    ix = max();
    cout << name[ix] << endl;
}

void printvec(double *a) {
    int i;
    REP(i,DIM) {
        cout << a[i] << ",";
    }
    cout << "\t";
}

int main() {
    int NC, tc, i;
    //ifstream in("flatland.in");
    cin >> NC;
    REP(i,MAX) {
        name[i] = new char[MAX];
    }
    REP(tc,NC) {
        cin >> N;
        cin >> B >> H;
        REP(i,N) {
            cin >> P[i][0] >> P[i][1] >> D[i][0] >> D[i][1] >> name[i];
            subs(V[i],D[i],P[i]);
            TD[i] = norm(V[i]);
            multEsc( V[i],V[i],1/norm(V[i]) );
            //printvec(V[i]);
        }
        solve();
    }
}

