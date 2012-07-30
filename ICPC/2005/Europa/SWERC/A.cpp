#include <cstdio>
#include <utility>
#include <vector>
#include <queue>
#include <list>
#include <map>


using namespace std;

vector<list<int> > V(100005);

int clear(){
  for(int i=0;i<=100000;i++)
    V[i].clear();
  return 0;
}

int f(int a,int b){
  int c,l;
  queue<pair<int,int> > Q;
  map<int,bool> M;
  list<int> ::iterator it;
  Q.push(make_pair(a,0));
  M[a]=true;
  bool band=true;
  while(band){
    pair<int,int> P=Q.front();
    c=P.first;
    l=P.second;
    Q.pop();
    for(it=V[c].begin();it!=V[c].end();it++){
      int q=*it;
      if(!M[q]){
        if(q==b){ band=false; break;}
        Q.push(make_pair(q,l+1));
      }
    }
  }
  return l;
}


int main(){
  int n,nc,c,p,a,b,ncase,first=1;
  scanf("%d",&ncase);
  while(ncase--){
    clear();
    scanf("%d",&n);
    for(int k=0;k<n;k++){
      scanf("%d %d",&c,&nc);
      for(int i=0;i<nc;i++){
        scanf("%d",&p);
        V[c].insert(V[c].end(),p);
      }
    }
    scanf("%d %d",&a,&b);
    if(first)
      first=0;
    else
      printf("\n");
    printf("%d %d %d\n",a,b,f(a,b));
  }
  return 0;
}
