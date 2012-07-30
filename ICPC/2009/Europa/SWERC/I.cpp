#include <cstdio>

using namespace std;

struct call{
    int source;
    int dest;
    int st;
    int dur;
}call[10005];

bool IN(int st,int end,int x,int y){
    if(x>=st && x<end)
        return true;
    if(y>st && y<=end)
        return true;
    if(x<st && y>end)
        return true;
    return false;
}

int main(){
    int n, m, source,dest,st,dur;
    while(scanf("%d %d",&n,&m) && (n || m)){
        for(int i=0;i<n;i++){
            scanf("%d %d %d %d",&source,&dest,&st,&dur);
            call[i].source=source;
            call[i].dest=dest;
            call[i].st=st;
            call[i].dur=dur;
        }
        for(int j=0;j<m;j++){
            scanf("%d %d",&st,&dur);
            int ans=0;
            for(int i=0;i<n;i++){
                if(IN(st,st+dur,call[i].st,call[i].st+call[i].dur)){
                    ans++;
                }
            }
            printf("%d\n",ans);
        }
    }
    return 0;
}

