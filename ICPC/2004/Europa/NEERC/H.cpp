#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int exch(int n,vector<int> &heap){
	swap(heap[1],heap[n]);
	int up=heap[1];
	int index=n-1;
	int tmp=heap[index];
	while(index>1){
		index/=2;
		swap(tmp,heap[index]);
	}
	heap[n-1]=up;
}

int f(int n){
	vector<int> ans(n+1);
	vector<int> heap(n+1);
	for(int i=1;i<=n;i++){
		heap[i]=i;
	}
	for(int i=n;i;i--){
		ans[heap[1]]=i;
		exch(i,heap);
	}
	for(int i=1;i<=n;i++)
		printf("%d%c",ans[i],i==n?'\n':' ');

	return 0;
}


int main(){
	int n;
	while(scanf("%d",&n)!=EOF && n){
		f(n);
	}
	return 0;
}
