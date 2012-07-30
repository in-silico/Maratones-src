#include <cstdio>
#include <climits>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

vector <map<int,int> > M(30);
map<int,int > ::iterator it;
int W[30];


int dp(int n,int hiring,int salary,int severance){
  int ans = INT_MAX;
  M[1][W[1]]=W[1]*(hiring+salary);
  
  for(int month=2;month<=n;month++){
    for(it=M[month-1].begin();it!=M[month-1].end();it++){
      int w=(*it).first;
      int c=(*it).second;
      if(w<W[month]){
	c+=hiring*(W[month]-w)+salary*(W[month]);
	if(!M[month][W[month]] || M[month][W[month]]>c)
	  M[month][W[month]]=c;
      }else if(w==W[month]){
	c+=salary*(w);
	if(!M[month][w] || M[month][w]>c)
	  M[month][w]=c;
      }else{
	for(int wi=W[month];wi<=w;wi++){
	  int ci=c+salary*wi+severance*(w-wi);
	  if(!M[month][wi] || M[month][wi]>ci)
	  M[month][wi]=ci;
  	}
      }
    }
  }
  for(it=M[n].begin();it!=M[n].end();it++){
    ans=min(ans,(*it).second);
  }
  
  return ans;
}

int main(){
  int n,hiring,salary,severance,ncase=1;
  while(scanf("%d",&n)!=EOF && n){
    for(int i=0;i<30;i++) M[i].clear();
    scanf("%d %d %d",&hiring,&salary,&severance);
    for(int i=1;i<=n;i++)
      scanf("%d",&W[i]);
    printf("Case %d, cost = $%d\n",ncase++,dp(n,hiring,salary,severance));
  }
  return 0;
}
