#include <cstdio>
#include <complex>
#include <cmath>

using namespace std;

#define Point complex<double>
#define MAX 1005
#define EPSILON 1E-6
#define PITT(X,Y) ( sqrt((X)*(X) + (Y)*(Y)) )
#define SQ(X) ((X)*(X))

typedef struct {
        Point p;
        double r;
} Disk;

Disk tower[MAX];
int n;

bool feasible(int k) {
     Disk act = tower[k];
     for (int i=k-1; i>=0; i--) {
         double dist = abs(act.p - tower[i].p);
         double diff = tower[i].r - dist;
         if ( fabs(diff)>EPSILON && diff>0 ) {
              double d = SQ(tower[i].r) + SQ(act.r);
              act.p = (tower[i].p*SQ(tower[i].r) + act.p*SQ(act.r))*(1/d);
              act.r = PITT(act.r, tower[i].r);
         } else {
                return false;
         }
     }
     return true;
}

int main() {
    while (true) {
          scanf("%i", &n);
          if (n==0) break;
          for (int i=0; i<n; i++) {
              int x,y,r;
              scanf("%i %i %i", &x, &y, &r);
              tower[i].p = Point(x,y);
              tower[i].r = r;
          }
          int stage=-1;
          for (int i=1; i<n; i++) {
              if (!feasible(i)) {
                  stage=i;
                  break;
              }
          }
          if (stage != -1)
              printf("Unfeasible %i\n",stage); 
          else
              printf("Feasible\n"); 
    }
}                              
