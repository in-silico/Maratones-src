#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 1000

#define max(x, y) ((x) > (y) ? (x) : (y))


char X[MAX+5], Y[MAX+5];
int dp[MAX+1][MAX+1], a[MAX+1][MAX+1], c[MAX+1][MAX+1];
int k, m, n, i, j, i2, j2, band, count;

int lcs(){
  m = strlen(X+1);
  n = strlen(Y+1);

  for(i=1; i <= m; i++){
    for(j=1; j <= n; j++){

      if(X[i] == Y[j])
        dp[i][j] = dp[i-1][j-1] + 1;
      else
        dp[i][j] = 0;
      
      a[i][j] = max(a[i-1][j], a[i][j-1]);
      
      for(count=k; count <= dp[i][j]; count++)
        a[i][j] = max(a[i][j], a[i-count][j-count] + count);
    }
  }

  return a[m][n];
}


int main(){
  for(i=1; i <= MAX; i++)
    for(j=1; j <= MAX; j++)
      dp[i][j] = a[i][j] = 0;

  while(scanf("%d", &k) && k){
    scanf("%s", &X[1]);
    scanf("%s", &Y[1]);

    printf("%d\n", lcs());
  }
  return 0;
}
