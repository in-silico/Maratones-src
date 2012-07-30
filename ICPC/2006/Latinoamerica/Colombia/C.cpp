#include <stdio.h>
#include <stdlib.h>

int main(){
    unsigned long long int a, b, c, d;
    while(scanf("%llu %llu %llu", &a, &b, &c)){
      if ((a==0) && (b==0) && (c==0))
         return 0;
      d = abs(a-c);                
      if((d%b) == 0)
        printf("%d\n", ((d/b) +2)/3);
      else
        printf("No accounting tablet\n");
    }
    
    
 return 0;   
}
