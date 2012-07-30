/* 
 * File:   main.cpp
 * Author: seb
 *
 * Created on 22 de mayo de 2010, 04:43 PM
 */

#include <cstdio>
#include <cmath>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)
#define PI 3.141592654


#define ABS(X) ((X)>0 ? (X) : (-X))

int main(int argc, char** argv) {
    float A,B,C;
    double t,x,y,vx,vy;
    double alfa=18.4036909;
    while(true) {
        scanf("%f %f %f",&A,&B,&C);
        if (A==0 && B==0 && C==0) break;
        if (ABS(A) > alfa) {
            printf("out\n");
            continue;
        }
        A = A*PI/180;
        B = B*PI/180;
        vx=C*cos(B);
        vy=C*sin(B);
        t = 11/(vx*cos(A));
        y = vy*t - 0.5*9.81*t*t + 0.11;
        if (y >= 2.44) {
            printf("out\n");
            continue;
        }
        if (y <= 0.11) {
            printf("bounce\n");
        } else {
            printf("goal\n");
        }
    }
}

