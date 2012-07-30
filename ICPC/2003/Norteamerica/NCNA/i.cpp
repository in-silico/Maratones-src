#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

int main(){
  int a,b,ncase=1,out[10];
  while(scanf("%d",&a)!=EOF && a){
    scanf("%d",&b);
    memset(out,0,10*sizeof(out[0]));
    if(a>b) swap(a,b);
    for(int i=a;i<=b;i++){
      int n=i;
      while(n){
        out[n%10]++;
        n/=10;
      }
    }
    printf("Case %d: ",ncase++);
    for(int i=0;i<10;i++)
      printf("%d:%d ",i,out[i]);
    printf("\n");
  }
  return 0;
}
