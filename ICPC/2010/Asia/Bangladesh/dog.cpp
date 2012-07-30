/* 
 * File:   main.cpp
 * Author: seb
 *
 * Created on 22 de mayo de 2010, 04:43 PM
 */

#include <cstdio>
#include <cstring>
#include <cmath>
#include <cstdlib>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

#define SIZE 50
#define DIMS 2
#define PI 3.141592
#define PREC 10E6
#define EQ(X,Y) ( ((int)round(PREC*X)) == ((int)round(PREC*Y)) )
#define LT(X,Y) ( ((int)round(PREC*X)) < ((int)round(PREC*Y)) )
#define GT(X,Y) ( ((int)round(PREC*X)) > ((int)round(PREC*Y)) )

int dims=DIMS;

void diff(double *r, double *a, double *b) {
    int i;
    REP(i,dims) {
        r[i] = a[i]-b[i];
    }
}

void sumv(double *r, double *a, double *b) {
    int i;
    REP(i,dims) {
        r[i]=a[i]+b[i];
    }
}

double norm(double *a) {
    double r=0;
    int i;
    REP(i,dims) {
        r += a[i]*a[i];
    }
    return sqrt(r);
}

double dotp(double *a, double *b) {
    double r=0;
    int i;
    REP(i,dims) {
        r += a[i]*b[i];
    }
    return r;
}

void multv(double *res, double *v, double scalar) {
    int i;
    REP(i,dims) {
        res[i] = v[i]*scalar;
    }
}

double vect_ang(double *a, double *b) {
    double r = acos( dotp(a,b)/(norm(a),norm(b)) );
    r = r*180/PI;
    r = round(100*r)/100.0;
    if (r < 0) r+=180;
    return r;
}

double dist(double *a, double *b) {
    double d[DIMS];
    diff(d,b,a);
    return norm(d);
}

void cp_v(double *dest, double *org) {
    int i;
    REP(i,dims) {
        dest[i] = org[i];
    }
}

int na,nb;
double pa[DIMS*SIZE], pb[DIMS*SIZE];

double pathSize(double *path, int points) {
    double ans=0;
    double *prev=path, *act;
    for (int i=1; i<points; i++) {
        act = prev+2;
        ans += dist(prev,act);
        prev=act;
    }
    return ans;
}

double tmax_comp(double *va, double *vb, double *a, double *b) {
    double dvel[DIMS], dpos[DIMS];
    double dvel_norm, ans;
    diff(dvel,va,vb);
    diff(dpos,a,b);
    dvel_norm = norm(dvel);
    ans = -(dotp(dvel,dpos))/(dvel_norm*dvel_norm);
    return ans;
}

int solve() {
    double t, ti, ta, tb, tm, sa, sb;
    double mind, maxd, d1, d2, dt, dtpi;;
    double a[DIMS], b[DIMS], va[DIMS], vb[DIMS], xa[DIMS], xb[DIMS];
    double nexta[DIMS], nextb[DIMS];
    t=0;
    sa = pathSize(pa,na); sb = pathSize(pb,nb);
    cp_v(a,pa); cp_v(b,pb);
    int fa=2, fb=2; //first index of PA and PB
    mind=10E8; maxd=0;
    while ( LT(t,1.0) ) {
        diff(xa,pa+fa,a); diff(xb,pb+fb,b);
        ta = norm(xa)/sa; tb = norm(xb)/sb;
        ti = min(ta,tb);
        multv(va,xa,1/ta); multv(vb,xb,1/tb);

        //X=V*t+X0 -> Next position calc
        multv(nexta,va,ti); sumv(nexta,nexta,a);
        multv(nextb,vb,ti); sumv(nextb,nextb,b);

        dt = dist(a,b); //D(t)
        dtpi = dist(nexta, nextb); //D(t+ti)

        d1 = min(dt,dtpi); d2 = max(dt, dtpi);
        tm = tmax_comp(va,vb,a,b);

        if (tm>0 && tm<ti) {
            double ma[DIMS], mb[DIMS];
            multv(ma,va,tm); sumv(ma,ma,a);
            multv(mb,vb,tm); sumv(mb,mb,b);
            double dtm = dist(ma,mb);
            d1 = min(d1,dtm); d2 = max(d2,dtm);
        }

        cp_v(a,nexta); cp_v(b,nextb);

        if (EQ(ta,tb)) {
            fa += 2; fb += 2;
        } else if (LT(ta,tb)) {
            fa += 2;
        } else {
            fb += 2;
        }

        mind = min(mind,d1); maxd = max(maxd,d2);
        t += ti;
    }
    return round(maxd-mind);
}

int main(int argc, char** argv) {
    int I,tc,i;
    scanf("%i",&I);
    REP(tc,I) {
        scanf("%i %i",&na,&nb);
        REP(i,na) {
            scanf("%lf %lf",&pa[2*i],&pa[2*i+1]);
        }
        REP(i,nb) {
            scanf("%lf %lf",&pb[2*i],&pb[2*i+1]);
        }
        int ans = solve();
        printf("Case %i: %i\n",tc+1,ans);
    }
}

