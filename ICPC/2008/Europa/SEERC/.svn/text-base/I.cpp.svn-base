#include <cstdio>
#include <cmath>
#include <algorithm>

using namespace std;


int main(){
    int n,c;
    while(scanf("%d %d",&n,&c)!=EOF){
        if(!n || !c) printf("0\n");
        else{
            int t1=floor((float)c/(2*(float)n));
            int t2=ceil((float)c/(2*(float)n));
            int ans1=t1*c-t1*t1*n;
            int ans2=t2*c-t2*t2*n;
            printf("%d\n",ans2>ans1?t2:t1);
        }
    }
    return 0;
}
