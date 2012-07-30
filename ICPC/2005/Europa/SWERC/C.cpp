#include <cstdio>
#include <iostream>
#include <sstream>

#include <cstring>

using namespace std;

#define S 0
#define R 1
#define L 2
#define C 4

int n;
int V[305];

int EMPTY(int begin,int end,int cur){
  for(int i=begin;i<=end;i++){
    int index=i%n;
    if(index==cur) return 0;
    if(V[index]!=S) return 0;
  }
  return 1;
}

int freed(int k){
  printf("%d is freed.\n",k);
}

int find_next_space(int cur,int k){
  int sum=0,band=0;
  for(int i=1;i<2*n;i++){
    int index=(i+cur)%n;
    if(index==cur) band=1;
    if(V[index]==S){
      sum++;
      if(sum==k) return (n+index-k)%n;
    }
    else{
      sum = 0;
      if(band) return -1;
    }
  }
  return -1;
}


int mark(int begin,int end,int c){
  for(int i=begin;i<=end;i++){
    V[i%n]=c;
  }
}

int put(int begin,int end){
  printf("The launderer gives ticket %d.\n",begin);
  V[begin] |= R;
  mark(begin+1,end,C);
  V[(end+1)%n] |= L;
  return end+1;
}

int give(int cur,int k){
  printf("The launderer gives back batch %d.\n",k);
  V[k]&=~R;
  if(V[k]==S) freed(k);
  for(int i=k+1;;i++){
    int index = i%n;
    if(V[index]==C){
      V[i%n]=S;
      freed(index);
    }else{
      V[index]&=~L;
      if(V[index]==S) freed(index);
      return k;
    }
  }
}


int deposit(int cur,int k){
  if(EMPTY(cur+1,cur+k,cur)){
    return put(cur,cur+k);
  }else{
    int index = find_next_space(cur,k);
    if(index == -1){
      printf("No space left, please come back later.\n");
      return cur;
    }else{
      return put(index,index+k);
    }
  }
}


int main(){
  int l,cur,k,ncase,first=1;;
  char c;
  cin >> ncase;
  while(ncase--){
    cin >> n;
    cin >> l;
    cur = 0;
    memset(V,0,305*sizeof(V[0]));
    if(first) first=0;
    else printf("\n");
    for(int i=0;i<l;i++){
      string line;
      cin >> c >> k;
      switch(c){
      case 'D': cur=deposit(cur,k); break;
      case 'W': cur=give(cur,k); break;
      default: break;
      }
    }
  }
  return 0;
}
