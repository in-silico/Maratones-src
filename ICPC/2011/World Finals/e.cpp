#include <cstdio>
#include <cstring>
#include <climits>
#include <algorithm>


#define MAX 1005

using namespace std;

int board[MAX+MAX][MAX+MAX];

int calc(int x,int y,int qi,int dx,int dy){
  int minx=max(x-qi-1,0), miny=max(y-qi-1,0);
  int maxx=min(dx+dy-1,x+qi), maxy=min(dx+dy-1,y+qi);
  int ans = board[maxx][maxy];
  ans += board[minx][miny];
  ans -= board[maxx][miny];
  ans -= board[minx][maxy];
  return ans;
}


int main(){
  int dx,dy,n,q;
  int ncase=1;
  while(scanf("%d %d %d %d",&dx,&dy,&n,&q)){
    if(!dx && !dy && !n && !q) break;

    for(int i=0;i<MAX+MAX;i++)
      for(int j=0;j<MAX+MAX;j++)
        board[i][j]=0;

    for(int c=1;c<=n;c++){
      int i,j;
      scanf("%d %d",&i,&j);
      board[dy+i-j][i+j-1]+=1;
    }


    for(int i=1;i<dx+dy;i++){
      for(int j=1;j<dx+dy;j++){
        board[i][j]+=board[i-1][j]+board[i][j-1]-board[i-1][j-1];
      }
    }


    printf("Case %d:\n",ncase++);
    for(int nq=0;nq<q;nq++){
      int m;
      scanf("%d",&m);
      int total=0;
      int ansi=1,ansj=1;
      for(int j=1;j<=dy;j++){
        for(int i=1;i<=dx;i++){
          int x=dy+i-j;
          int y=i+j-1;
          int sum=calc(x,y,m,dx,dy);
          if(sum>total){
            total=sum;
            ansi=i; ansj=j;
          }
        }
      }
      printf("%d (%d,%d)\n",total,ansi,ansj);
    }
  }
  return 0;
}
