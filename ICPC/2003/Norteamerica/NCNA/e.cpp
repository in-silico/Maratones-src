#include <cstdio>
#include <algorithm>

#define valid(x,y) (((x)>=0)&&((x)<10)&&((y)>=0)&&((y)<10))

using namespace std;

int squares;
int dx[]={1,2,2,1,-1,-2,-2,-1};
int dy[]={-2,-1,1,2,2,1,-1,-2};
bool board[10][10];

int clear(){
  for(int i=0;i<9;i++)
    for(int j=0;j<9;j++)
      board[i][j]=false;
}

int f(bool board[10][10],int i,int j,int nivel){
  if(!valid(i,j) || !board[i][j])
    return 0;
  squares=max(squares,nivel);
  board[i][j]=false;
  for(int k=0;k<8;k++){
    f(board,i+dx[k],j+dy[k],nivel+1);
  }
  board[i][j]=true;
}

int main(){
  int n,x,l,col,t,ncase=1;
  while(scanf("%d",&n)!=EOF && n){
    clear();
    t=0;
    for(int i=0;i<n;i++){
      scanf("%d %d",&x,&l);
      t+=l;
      if(i==0)
	col=x;
      for(int k=0;k<l;k++){
	board[i][x+k]=true;
      }
    }
    squares = 0;
    f(board,0,col,1);
    printf("Case %d, %d %s can not be reached.\n",ncase++,t-squares,(t-squares)==1?"square":"squares");
  }
  return 0;
}
