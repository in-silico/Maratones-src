#include <stdio.h>
#include <stdlib.h>
#include <limits.h> 

/*
 * 
 */

int array[105];



int main() {



    int N,C,K;
    int i,j;
    int number;
    while(scanf("%d %d %d",&N,&C,&K))
    {
        if ((N==0)&&(C==0)&&(K==0))
            break;
        for(i=0;i<105;i++){
            array[i]=0;
        }
        for(i=0;i<N;i++)
        {
            for(j=0;j<C;j++)
            {
                scanf("%d",&number);
                array[number]=array[number]+1;
            }
        }
        int MIN=INT_MAX;
        for(i=1;i<=K;i++)
        {
            if (array[i]<MIN)
            {
                MIN=array[i];
            }
        }
		i=1;
		while(1)
		{
			if (array[i]==MIN)
			{
				printf("%d",i);
				i=i+1;
				break;
			}
			i=i+1;
		}

        for(;i<=K;i++)
        {
            if (array[i]==MIN)
            {
                printf(" %d",i);
            }
        }
        printf("\n");


    }

    return 0;
}
