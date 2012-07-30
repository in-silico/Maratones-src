#include <cstdio>
#include <iostream>
#include <vector>
#include <list>
#include <map>
#include <queue>
#include <set>

#define B 0
#define R 1
#define T 2
#define L 3

using namespace std;

pair<int,int> ori(int base1,int c,int c2){
  //printf("%d %d %d\n",base1,c,c2);
  int direction=(4+c-base1)%4;
  int base2;
  switch(direction){
    case 0: base2=c2+2; break;
    case 1: base2=c2+1; break;
    case 2: base2=c2; break;
    case 3: base2=c2+3; break;
  }
  return make_pair(direction,base2%4);
}

int main(){
  int n,k,n0,n1,c0,c1;
  int ncase=1;

  set<int> S;
  vector<pair<int,pair<int,int> > > V(501);
  map<pair<int,int>, int> M;
  map<pair<int,int>, int> ::iterator Mi;
  map<pair<int,int>,pair<int,int> > connect;

  while(scanf("%d",&n) && n){
	  connect.clear();
	  M.clear();
	  V.clear();

    scanf("%d",&k);
    for(int i=0;i<k;i++){
      scanf("%d %d %d %d",&n0,&c0,&n1,&c1);
      connect[make_pair(n0,c0)] = make_pair(n1,c1);
      connect[make_pair(n1,c1)] = make_pair(n0,c0);
    }

    M[make_pair(500,500)]=0;
    V[0] = make_pair(0,make_pair(500,500));

    queue<int> Q;
    set <int> S;
    Q.push(0); S.insert(0);
    while(!Q.empty()){
      int n=Q.front(); Q.pop();
      //printf("saca: %d\n",n); fflush(stdout);
      for(int c=0;c<4;c++){
        if(connect.count(make_pair(n,c))==0) continue;
        pair<int,int> m = connect[make_pair(n,c)]; // coneccion de n en la cara c
        int n2=m.first; int c2=m.second;
        if(S.count(n2)!=0) continue;
        Q.push(n2); S.insert(n2);
        pair<int,int> d = ori(V[n].first,c,c2); // hacia donde esta el vecino y cual es su base
        int i=V[n].second.first;
        int j=V[n].second.second;

        //printf("base:%d n2:%d base2:%d (%d,%d)\n",V[n].first,n2,c2,d.first,d.second); fflush(stdout);
        if(d.first==B){ M[make_pair(i+1,j)]=n2; V[n2]=make_pair(d.second,make_pair(i+1,j)); }
        if(d.first==R){ M[make_pair(i,j+1)]=n2; V[n2]=make_pair(d.second,make_pair(i,j+1)); }
        if(d.first==T){ M[make_pair(i-1,j)]=n2; V[n2]=make_pair(d.second,make_pair(i-1,j)); }
        if(d.first==L){ M[make_pair(i,j-1)]=n2; V[n2]=make_pair(d.second,make_pair(i,j-1)); }
      }
    }
    //printf("mapa:\n"); fflush(stdout);
    printf("Instance %d:\n",ncase++);
    int i=(*M.begin()).first.first;
    int j=(*M.begin()).first.second;
    for(Mi=M.begin();Mi!=M.end();Mi++){
    	printf("%5d%5d %5d %d\n",(*Mi).first.first-i,(*Mi).first.second-j,(*Mi).second,V[(*Mi).second].first);
    }
    	//;

    //getchar(); getchar();
  }
  return 0;
}
