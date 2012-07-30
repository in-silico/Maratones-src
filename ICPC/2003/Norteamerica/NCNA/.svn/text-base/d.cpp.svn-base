#include <cstdio>

using namespace std;

int main(){
  int p,c,t,ncase=1;
  double P,I,i,T;
  while(scanf("%lf %lf %d",&P,&I,&c)!=EOF){
    if(P==0.0 && I==0.0 && c==0) break;
    p=P*100;
    i=(I*100)/c;
    T=P*100;
    for(int month=1;month<=c;month++){
      t =(T*i)/10000;
      if(t)
	T+=t;
    }
    printf("Case %d. $%.2lf at %.2lf%% APR compounded %d times yields $%.2lf\n",ncase++,P,I,c,T/100);
  }
  return 0;
}
