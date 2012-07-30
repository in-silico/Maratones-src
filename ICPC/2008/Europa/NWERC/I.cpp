#include <cstdio>

#define REP(i,N) for((i)=0;(i)<(N);(i)++)
#define MAX 100001

int s,n;
int seq[MAX];
int P[MAX];
char C[MAX];

void union(int from, int to) {
       int i;
       for(i=from; i<=to; i++)
               c[i%s]='X';
}

void solve() {
       int i,diff,len;
       REP(i, s) {
               c[i]=' ';
               p[i]=-1;
       }
       REP(i,n) {
               if(P[seq[i]-1] == -1) P[seq[i]-1]=i;
               else {
                       diff=i-P[seq[i]-1];
                       P[seq[i]-1]=i;
                       len=s-diff;
                       union(i,i+len-1);
               }
       }
       int count=0;
       REP(i,s)
               if(c[i]==' ') count++;
       printf("%i\n",count);
}

int main() {
       int TC,tc,i;
       scanf("%i",&TC);
       REP(tc,TC) {
               scanf("%i %i",&s,&n);
               REP(i,n) {
                       scanf("%i",&seq[i]);
               }
               solve();
       }
}

