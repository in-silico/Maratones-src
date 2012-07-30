#include <stdio.h>
#include <stdlib.h>

int main(){
  int c, i, n, N[300], temp[300];
  int a, b, A, B;
    
  while(scanf("%d", &n) && n){
    for(i=1; i <= n; i++)
      scanf("%d", &N[i]);

  for(c=2; c <= n; c *=2){
    i = 1;
    for(a=1, b = c/2 +1; b <= c; a++, b++){
      A = N[a]; B = N[b];
      temp[i++] = (A+B)/2;
      temp[i++] = (A-B)/2;
    }
    for(--i;i; i--)
      N[i] = temp[i];
  }
  for(i=1; i <= n; i++)
   printf("%d%c", N[i], i == n? '\n' : ' ');
 }
 return 0;
}
