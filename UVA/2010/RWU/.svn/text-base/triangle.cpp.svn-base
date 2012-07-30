
#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <cmath>

#define REP(i,N) for(int i=0; i<(N); i++)
#define REPB(i,N) for((i)=(N)-1; (i)>=0; (i)--)
#define min(X,Y) ( ((X)<(Y)) ? (X) : (Y) )
#define max(X,Y) ( ((X)>(Y)) ? (X) : (Y) )
#define PREC 1E-6

#define f1(X) ( ((X)>0) ? (X) : 0 )
#define f2(X) f1(  ( (X)*((X)+1) ) / 2  )
#define f3(A,B) ( ((A)<=(B)) ? (f2(B)-f2(A-1)) : 0 )
#define f4(X) f1( ( (X)*((X)+1)*(2*(X)+1) ) / 6 )
#define f5(A,B) ( ((A)<=(B)) ? (f4(B)-f4(A-1)) : 0 )

bool test=false;

long mysum(long *vec, int dim) {
    long ans=0;
    REP(i,dim) {
        ans += vec[i];
    }
    return ans;
}

long triang(long a, long b) {
    long count[10] = {0,0,0,0,0,0,0,0,0,0};
    long tmp[10] = {0,0,0,0,0,0,0,0,0,0};
    long m=(b+1)/2;
    if (test) {
        for (int i=a; i<=b; i++) {
            tmp[0] += i*f1(b-2*i+1);
            //j=max(b-i+1,i);
            //tmp[1] += (b+1)*(b-j+1);
            if (i<=m) {
                tmp[1] += (b+1)*i;
                tmp[3] += f2(b-i);
            } else {
                tmp[2] += (b+1)*(b-i+1);
                tmp[4] += f2(i-1);
            }
            tmp[5] += -f2(b);
        }
    }
    long lim = max(a,m+1);
    //sum i*f1(b-2*i+1)
    count[0] = (b+1)*f3(a,m) - 2*f5(a,m);
    //sum (b+1)*(b-j+1)
    count[1] = (b+1)*f3(a,m);
    count[2] = (b+1)*( (b+1)*(b-lim+1) - f3(lim,b) );
    //sum f2(j-1)-f2(b)
    count[3] = f2(b)*f1(m-a+1) + (f5(a,m) - (2*b + 1)*f3(a,m))/2;
    count[4] =  (f5(lim,b)-f3(lim,b))/2;
    count[5] -= f2(b)*f1(b-a+1);

    if (test) printf("test: %i\n", mysum(tmp,10));
    return mysum(count,10);
}

void swap(int *a, int *b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

int main() {
    int T,a,b;
    scanf("%i", &T);
    REP(i,T) {
        scanf("%i %i", &a, &b);
        if (a > b) swap(&a,&b);
        printf("%li\n", triang(a,b));
    }
}
