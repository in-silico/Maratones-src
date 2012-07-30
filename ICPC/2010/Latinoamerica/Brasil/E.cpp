/* 
 * File:   main.cpp
 * Author: santiago
 *
 * Created on September 26, 2010, 11:50 AM
 */

#include <cstdlib>
#include <cstdio>
#include <iostream>
#include <cmath>

#define DIM 2
#define INF 10000
#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define REPB(i,N) for((i)=(N)-1; (i)>=0; (i)--)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )

using namespace std;

int L,C,r1,r2;
int P1[DIM], P2[DIM];

bool checkRect(int *p) {
    if (p[0]<0 || p[1] < 0) return false;
    if (p[0]>L || p[1]>C) return false;
    return true;
}

void diff(int *c, int *a, int *b) {
    int i;
    REP(i,DIM) c[i] = a[i]-b[i];
}

double dotp(int *a, int *b) {
    double c=0;
    int i;
    REP(i,DIM) c += a[i]*b[i];
    return c;
}

double norm(int *a) {
    return sqrt( dotp(a,a) );
}

bool solve() {
    P1[0] = P1[1] = r1;
    P2[0] = L-r2; P2[1]=C-r2;
    if (2*r1 > min(L,C) || 2*r2 > min(L,C)) return false;
    diff(P1,P1,P2);
    if (norm(P1) >= r1+r2)
        return true;
    else
        return false;
}

/*
 * 
 */
int main(int argc, char** argv) {
    while (true) {
        scanf("%i %i %i %i", &L,&C, &r1, &r2);
        if (L==0 && C==0 && r1==0 && r2==0) break;
        if (solve())
            printf("S\n");
        else
            printf("N\n");
    }
}

