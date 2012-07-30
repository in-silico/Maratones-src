
#include <cstdio>
#include <map>
#include <string>

#define PI 3.141592654

#define REP(i,N) for(int i=0; i<(N); i++)
#define MAX 1001
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )

using namespace std;

double m,n,t,c;
double A1,A2,A3,A4;

void solve() {
    double r=c/2.0;
    double l1 = t-c;
    double a1 = l1*l1;
    double a2 = l1*r;
    double a4 = PI*r*r/4;
    double a3 = r*r - a4;

    double gi,gl,ge;
    if (m*n == 1) {
        A1=1; A2=A3=A4=0;
        return;
    } else if (n==1 || m==1) {
        if (n==1) {
            int t=m;
            m=n;
            n=t;
        }
        A1 = n*(a1+2*a2) + 2*(a2+2*r*r);
        A2 = 2*(n-1)*(a2+2*r*r);
        A3 = 0;
        A4 = 0;
    } else {
        gi=(m-2)*(n-2); gl = 2*(m-2) + 2*(n-2); ge=4;
        A1=m*n*a1 + gl*a2 + ge*(2*a2 + r*r);
        A2=gi*4*a2 + 2*r*r*gl + 3*a2*gl + ge*(2*r*r + 2*a2);
        A3=gi*4*a3 + 2*a3*gl + ge*a3;
        A4=gi*4*a4 + 2*a4*gl + ge*a4;
    }
    double at = m*n*t*t;
    A1/=at; A2/=at; A3/=at; A4/=at;
}

int main(int argc, char **argv) {
    int N;
    scanf("%i",&N);
    REP(i,N) {
        scanf("%lf %lf %lf %lf", &m,&n,&t,&c);
        solve();
        printf("Case %i:\n",i+1);
        printf("Probability of covering 1 tile  = %.4lf%%\n", A1*100);
        printf("Probability of covering 2 tiles = %.4lf%%\n", A2*100);
        printf("Probability of covering 3 tiles = %.4lf%%\n", A3*100);
        printf("Probability of covering 4 tiles = %.4lf%%\n", A4*100);
        printf("\n");
    }
}
