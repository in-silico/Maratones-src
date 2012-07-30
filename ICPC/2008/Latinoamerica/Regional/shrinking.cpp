#include <cstdio>
#include <vector>
#include <set>

using namespace std;

vector<int> V(10005);

bool isposible(set<int> &S,int n,int size){
	if(size%n) return false;
	int seg=size/n;
	for(int i=0;i<size && V[i]<seg;i++){
		bool posible=true;
		for(int j=1;j<n;j++){
			if(S.count(seg*j+V[i])==0){
				posible=false;
				break;
			}
		}
		if(posible) return true;
	}
	return false;
}

int main(){
	int n;
	while(scanf("%d",&n) && n){
		int tmp;
		V.clear();
		set<int> S;
		V.push_back(0); S.insert(0);
		for(int i=1;i<=n;i++){
			scanf("%d",&tmp);
			V.push_back(tmp+V[i-1]);
			S.insert(tmp+V[i-1]);
		}
		int k;
		bool posible=false;
		for(k=n;k>=3;k--){
			if(isposible(S,k,V[V.size()-1])){
				posible=true;
				break;
			}
		}
		if(posible) printf("%d\n",n-k);
		else printf("-1\n");
	}
	return 0;
}
