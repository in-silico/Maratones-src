#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  int n,l,li,ncase,first=1;
  vector<int> L(100005);

  scanf("%d",&ncase);
  while(ncase--){
    scanf("%d",&n);
    scanf("%d",&l);
    L.clear();
    for(int i=0;i<n;i++){
      scanf("%d",&li);
      L.insert(L.end(),li);
    }
    sort(L.begin(),L.end());
    int q=0;
    int front=0; int back=n-1;
    while(front<back){
      int a=L[front];
      int b=L[back];
      if((a+b)<=l)
        front++;
      back--;
      q++;
    }
    if(front==back){
      q++;
    }
    if(first)
      first=0;
    else
      printf("\n");
    printf("%d\n",q);
  }
  return 0;
}
