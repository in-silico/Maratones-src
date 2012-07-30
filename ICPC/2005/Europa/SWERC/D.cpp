#include <cstdio>
#include <climits>
#include <vector>
#include <list>
#include <utility>

using namespace std;

int n;
int parent[1005],Q[10];
vector<pair<int,int> > C(1005);
vector<list<int> > N(1005);
list<pair<int,pair<int,int> > > route;

int clear_cities(){
  for(int i=0;i<=n;i++)
    parent[i]=i;
  return 0;
}

int find_parent(int a){
  if(parent[a]==a)
    return a;
  return parent[a]=find_parent(parent[a]);
}

int join(int a,int b){
  parent[find_parent(b)]=find_parent(a);
}

int add_network(int k){
  list<int> ::iterator it;
  it=N[k].begin();
  int a=*it;
  it++;
  for(;it!=N[k].end();it++){
    int b=*it;
    join(a,b);
  }
  return Q[k];
}

int connections(){
  int size=C.size();
  for(int i=0;i<size-1;i++){
    pair<int,int> A;
    A=C[i];
    int xa=A.first;
    int ya=A.second;
    for(int j=i+1;j<size;j++){
      pair<int,int> B;
      B=C[j];
      int xb=B.first;
      int yb=B.second;
      int d=(xa-xb)*(xa-xb);
      d+=(ya-yb)*(ya-yb);
      route.insert(route.end(),make_pair(d,make_pair(i,j)));
    }
  }
  route.sort();
}

int MST(int i){
  int ans=0;
  list<pair<int,pair<int,int> > > ::iterator it,it2;
  for(it=route.begin();it!=route.end();){
    int d=(*it).first;
    pair<int,int> P=(*it).second;
    int a=P.first;
    int b=P.second;
    it2=it++;
    if(find_parent(a)!=find_parent(b)){
      join(a,b);
      ans+=d;
    }else{
      if(i==0) route.erase(it2);
    }
  }
  return ans;
}


int solve(int q){
  connections();
  int nn = 1<<q;
  int ans=INT_MAX;
  for(int i=0;i<nn;i++){
    clear_cities();
    int tmp=0;
    for(int k=0;k<8;k++){
      int mask=1<<k;
      if(i&mask){
        tmp+=add_network(k);
      }
    }
    int cost=MST(i)+tmp;
    ans=min(ans,cost);
  }
  return ans;
}


int clear(){
  for(int i=0;i<1005;i++) N[i].clear();
  C.clear();
  route.clear();
}

int main(){
  int q,nq,c,ncase,first=1;
  scanf("%d",&ncase);
  while(ncase--){
    scanf("%d %d",&n,&q);
    if(n==0 && q==0) break;
    clear();
    for(int i=0;i<q;i++){
      scanf("%d %d",&nq,&Q[i]);
      for(int j=0;j<nq;j++){
        scanf("%d",&c);
        N[i].insert(N[i].end(),c-1);
      }
    }
    int x,y;
    for(int i=0;i<n;i++){
      scanf("%d %d",&x,&y);
      C.insert(C.end(),make_pair(x,y));
    }
    if(first) first=0;
    else printf("\n");
    printf("%d\n",solve(q));
    fflush(stdout);
  }
  return 0;
}
