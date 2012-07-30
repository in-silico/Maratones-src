#include <stdio.h>

#define min(x,y) ((x) < (y) ? (x) : (y))


int main(){
    int n, i, odd1, odd2, even1, even2, number;
    
    while(scanf("%d", &n) && n){
        odd1 = odd2 = 0;
        for(i=0; i < n; i++){
            scanf("%d", &number);
            if(number%2){
                odd1++;
            }
        }
        even1 = n - odd1;

        for(i=0; i < n; i++){
            scanf("%d", &number);
            if(number%2){
                odd2++;
            }
        }
        even2 = n - odd2;
        printf("%d\n", n - min(odd1, even2) - min(odd2, even1));
    }


}

