#include <algorithm>
#include <vector>

using namespace std;

class PointErasingTwo{
	public:
	int inside(vector<int> y,int a,int b){
		int ans=0,size=y.size();
		int y1=y[a],y2=y[b];
		if(y1>y2) swap(y1,y2);
		for(int i=0;i<size;i++){
			if(i==a || i==b) continue;
			if(i>a && i<b && y[i]>y1 && y[i]<y2) ans++;
		}
		return ans;
	}
	int getMaximum(vector<int> y){
		int ans=0;
		int size = y.size();
		for(int a=0;a<size;a++){
			for(int b=a+1;b<size;b++){
				int tmp=inside(y,a,b);
				ans=max(ans,tmp);
			}
		}
		return ans;
	}
};
