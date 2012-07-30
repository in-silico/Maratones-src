#include <cstdio>
#include <cmath>
#include <list>

using namespace std;

#define PI_180 (M_PI/180)

list <pair<int,int> > L,LL;
list <pair<int,int> > ::iterator it, it2;

int init(){
  L.clear();
  for(int i=400;i<600;i++)
    for(int j=i+1;j<=600;j++)
      L.insert(L.end(),make_pair(i,j));
}

int f(double signal,int t,int N){
  for(it=L.begin();it!=L.end();){
    int i=(*it).first;
    int j=(*it).second;
    float ans=sin(PI_180*i*t/(double)N);
    ans+=sin(PI_180*j*t/(double)N);
    ans-=signal;
    ans=fabs(ans);
    it2=it++;
    if(ans>10E-6){
      L.erase(it2);
    }
  }
}


int main(){
  int n,ncase=1;
  double signal;
  double ans1=sin(3.141592/2);
  double ans2=sin(5);

  while(scanf("%d",&n)!=EOF && n){
    init();
    for(int i=1;i<=n;i++){
      scanf("%lf",&signal);
      f(signal,i,n);
    }
    it = L.begin();
    printf("Case %d, f1 = %d, f2 = %d\n",ncase++,(*it).first,(*it).second);
  }
  return 0;
}
