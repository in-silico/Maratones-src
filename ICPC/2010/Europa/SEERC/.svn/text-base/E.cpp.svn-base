#include <cstdio>
#include <cmath>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;

int main(){
    int n;
    double p;
    vector<double> V;
    while(scanf("%d",&n)!=0){
        V.clear();
        for(int i=0;i<n;i++){
            scanf("%lf",&p);
            V.push_back(p);
        }
        sort(V.begin(),V.end());
        list<double> L;
        for(int i = 0; i < n; i++){
            L.push_back(V[i]);
        }
        //L.sort();
        int ans=0;
        while(!L.empty()){
            double tmp=L.front();
            while(!L.empty() && (L.front()-tmp)<=0.999999999999){
                L.pop_front();
            }
            ans++;
        }
        printf("%d\n",ans);
    }
    return 0;
}
