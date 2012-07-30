/*
 * File:   test.cpp
 * Author: santiago
 *
 * Created on October 13, 2010, 4:13 PM
 */

#include <cstdio>
#include <cmath>

#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define abs(X) ( ((X)>0) ? (X) : -(X) )
#define MDIM 3
#define DIM 2
#define MAX 105
#define INF 1E10

double matriz[MDIM][MDIM];
double vecx[DIM]={1,0};

double I[MAX][DIM];
double O[MAX][DIM];

void mult(double mat[MDIM][MDIM]) {
    int i,j,k;
    double tmp[MDIM][MDIM];
    REP(i,MDIM) {
        REP(j, MDIM) {
            tmp[i][j]=0;
            REP(k,MDIM) {
                tmp[i][j] += matriz[i][k]*mat[k][j];
            }
        }
    }
    REP(i,MDIM) {
        REP(j,MDIM) {
            matriz[i][j] = tmp[i][j];
        }
    }
}

void subMat(double *vec) {
    double mat[MDIM][MDIM] = { {1, 0, -vec[0]},
        {0,1,-vec[1]},
        {0,0,1}
    };
    mult(mat);
}

void rotz(double theta) {
    double mat[MDIM][MDIM] = { {cos(theta), -sin(theta), 0},
        {sin(theta),cos(theta),0},
        {0,0,1}
    };
    mult(mat);
}

void initMat() {
    int i,j;
    REP(i,MDIM) {
        REP(j,MDIM) {
            matriz[i][j] = ( (i==j) ? 1 : 0 );
        }
    }
}

double dotP(double *a, double *b, int dim=DIM) {
    double ans=0; int i;
    REP(i,dim) {
        ans += a[i]*b[i];
    }
    return ans;
}

double norm(double *a, int dim=DIM) {
    return sqrt(dotP(a,a,dim));
}

double angVec(double *a, double *b) {
    return acos( dotP(a,b) / (norm(a)*norm(b)) );
}

void subvec(double *ans, double *a, double *b) {
    int i;
    REP(i,DIM) {
        ans[i] = a[i] - b[i];
    }
}

void trans(double *ans, double *P) {
    int i;
    REP(i,MDIM) {
        ans[i] = dotP(P, matriz[i], MDIM);
    }
}

double distPointLine(double *P, double *A1, double *A2) {
    double V1[DIM], tmp[MDIM], pcopy[MDIM];
    subvec(V1,A2,A1);
    double theta = angVec(V1,vecx);
    if (V1[1]<0) theta*=-1;
    rotz(-theta);
    subMat(A1);
    pcopy[0]=P[0]; pcopy[1]=P[1]; pcopy[2]=1;
    trans(tmp, pcopy);
    initMat();
    if (tmp[0]>0 && tmp[0]<norm(V1))
        return abs(tmp[1]);
    else {
        double d[2][DIM];
        subvec(d[0], P, A1); subvec(d[1], P, A2);
        return min( norm(d[0]), norm(d[1]) );
    }
}

double ptSegDist(double x1, double y1,
				     double x2, double y2,
				     double px, double py)
    {
	// Adjust vectors relative to x1,y1
	// x2,y2 becomes relative vector from x1,y1 to end of segment
	x2 -= x1;
	y2 -= y1;
	// px,py becomes relative vector from x1,y1 to test point
	px -= x1;
	py -= y1;
	double dotprod = px * x2 + py * y2;
	double projlenSq;
	if (dotprod <= 0.0) {
	    // px,py is on the side of x1,y1 away from x2,y2
	    // distance to segment is length of px,py vector
	    // "length of its (clipped) projection" is now 0.0
	    projlenSq = 0.0;
	} else {
	    // switch to backwards vectors relative to x2,y2
	    // x2,y2 are already the negative of x1,y1=>x2,y2
	    // to get px,py to be the negative of px,py=>x2,y2
	    // the dot product of two negated vectors is the same
	    // as the dot product of the two normal vectors
	    px = x2 - px;
	    py = y2 - py;
	    dotprod = px * x2 + py * y2;
	    if (dotprod <= 0.0) {
		// px,py is on the side of x2,y2 away from x1,y1
		// distance to segment is length of (backwards) px,py vector
		// "length of its (clipped) projection" is now 0.0
		projlenSq = 0.0;
	    } else {
		// px,py is between x1,y1 and x2,y2
		// dotprod is the length of the px,py vector
		// projected on the x2,y2=>x1,y1 vector times the
		// length of the x2,y2=>x1,y1 vector
		projlenSq = dotprod * dotprod / (x2 * x2 + y2 * y2);
	    }
	}
	// Distance to line is now the length of the relative point
	// vector minus the length of its projection onto the line
	// (which is zero if the projection falls outside the range
	//  of the line segment).
	double lenSq = px * px + py * py - projlenSq;
	if (lenSq < 0) {
	    lenSq = 0;
	}
	return sqrt(lenSq);
    }

int main() {
    int TC,tc,i,j,ni,no;
    scanf("%i", &TC);
    initMat();
    REP(tc,TC) {
        scanf("%i", &ni);
        REP(i,ni) {
            scanf("%lf %lf", &I[i][0], &I[i][1]);
        }
        scanf("%i", &no);
        REP(i,no) {
            scanf("%lf %lf", &O[i][0], &O[i][1]);
        }

        double m=INF;
        REP(i,ni) {
            REP(j,no) {
                m = min( m, ptSegDist(O[j][0],O[j][1],O[(j+1)%no][0],O[(j+1)%no][1],I[i][0],I[i][1]) );
            }
        }
        m/=2.0;
        printf("%.10lf\n", m);
    }
}

