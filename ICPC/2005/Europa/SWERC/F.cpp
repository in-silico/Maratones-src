#include <cstdio>
#include <queue>
#include <list>

using namespace std;

int main(){
  int n,q,d,ncase,first=1;
  priority_queue<int> Q;
  list<pair<int,int> > L;
  list<pair<int,int> > ::iterator it;

  scanf("%d",&ncase);
  while(ncase--){
    scanf("%d",&n);
    L.clear();
    for(int i=0;i<n;i++){
      scanf("%d %d",&q,&d);
      L.insert(L.end(),make_pair(d,q));
    }
    L.sort();
    Q = priority_queue <int>();
    int sum=0;
    for(it=L.begin();it!=L.end();it++){
      q=(*it).second;
      d=(*it).first;
      Q.push(q);
      sum+=q;
      while(sum>d){
        sum-=Q.top();
        Q.pop();
      }
    }
    if(first) first=0;
    else printf("\n");
    printf("%d\n",Q.size());
  }
  return 0;
}
