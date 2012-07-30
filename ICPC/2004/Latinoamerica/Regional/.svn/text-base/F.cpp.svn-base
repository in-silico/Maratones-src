#include <stdio.h>
#include <string.h>
#include <queue>
#include <list>

using namespace std;

#define MAX 2100

#define min(x,y) ((x) < (y) ? (x) : (y))
#define max(x,y) ((x) > (y) ? (x) : (y))


#define val(x) (((x) >= 0) && ((x) <= MAX))

int island[MAX+1][MAX+1];
char visited[MAX+1][MAX+1];
int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
int w, xmin, xmax, ymin, ymax, visitedmax;

queue<int> Qx;
queue<int> Qy;

int flooded(int x, int y){
  Qx.push(x);
  Qy.push(y);
  visited[x][y] = 1;
  island[x][y] = -1;

  while(!Qx.empty()){
    
    x = Qx.front();
    y = Qy.front();

    Qx.pop();
    Qy.pop();
    
    if(((x-2) >= (xmin-2)) && !visited[x-2][y] && (island[x-1][y]<w)){
      Qx.push(x-2);
      Qy.push(y);
      visited[x-2][y] = 1;
      island[x-2][y] = -1;
    }

    if(((x+2) <= (xmax+2)) && !visited[x+2][y] && (island[x+1][y]<w)){
      Qx.push(x+2);
      Qy.push(y);
      visited[x+2][y] = 1;
      island[x+2][y] = -1;
    }

    if(((y-2) >= (ymin-2)) && !visited[x][y-2] && (island[x][y-1]<w)){
      Qx.push(x);
      Qy.push(y-2);
      visited[x][y-2] = 1;
      island[x][y-2] = -1;
    }

    if(((y+2) <= (ymax+2)) && !visited[x][y+2] && (island[x][y+1]<w)){
      Qx.push(x);
      Qy.push(y+2);
      visited[x][y+2] = 1;
      island[x][y+2] = -1;
    }
  }

  return 0;
}

int main(){
  int n, i, h, x1, x2, y1, y2, x, y, ans;

  while(scanf("%d", &n) && n){
    memset(island, 0, (MAX+1)*(MAX+1)*sizeof(island[0][0]));
    memset(visited, 0, (MAX+1)*(MAX+1)*sizeof(visited[0][0]));

    fflush(stdout);

    xmin = ymin = 4000;
    xmax = xmax = 0;
    
    for(i=0; i < n; i++){
      scanf("%d %d %d %d %d", &x1, &y1, &x2, &y2, &h);

      x1 = (x1 + 510)*2;  x2 = (x2 + 510)*2;
      y1 = (y1 + 510)*2;  y2 = (y2 + 510)*2;

      xmin = x1 < xmin ? x1 : xmin;
      xmin = x2 < xmin ? x2 : xmin;

      ymin = y1 < ymin ? y1 : ymin;
      ymin = y2 < ymin ? y2 : ymin;

      xmax = x1 > xmax ? x1 : xmax;
      xmax = x2 > xmax ? x2 : xmax;

      ymax = y1 > ymax ? y1 : ymax;
      ymax = y2 > ymax ? y2 : ymax;

      if(x1 == x2){
        for(y=min(y1,y2); y <= max(y1,y2); y++){
          island[x1][y] = h;
        }
      } else {
        for(x=min(x1,x2); x <= max(x1,x2); x++){
          island[x][y1] = h;
        }
      }
    }

    scanf("%d", &w);
    ans = 0;

    flooded(xmin-1, ymin-1);

    for(y=ymin-1; y<=ymax; y+=2){
      for(x=xmin-1; x<=xmax; x+=2){
        if(!island[x][y]){
          ans++;
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
