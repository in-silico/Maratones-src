#include <cstdio>
#include <cmath>

using namespace std;

int f(int n){
  int total = 1;
  for(int i=2;i<=n;i++){
    int c=1;
    while(n%i==0){
      n/=i;
      c*=i;
    }
    total*=c-c/i;
  }
  return total;
}


int main(){
  int n,ncase=1;
  while(scanf("%d",&n) && n){
    printf("Case %d, n = %d, unique stars = %d\n",ncase++,n,f(n)/2-1);
  }
  return 0;
}
