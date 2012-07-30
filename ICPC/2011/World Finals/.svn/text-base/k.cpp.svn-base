#include <iostream>
#include <cstdio>
#include <cmath>
#include <cfloat>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;


bool comp(const pair<int,int> &p1, const pair<int,int> &p2)
{
    if(p1.second < p2.second) return true;
    if(p1.second > p2.second) return false;
    if(p1.first < p2.first) return true;
    return true;
}

double cross(pair<int,int> p1, pair<int,int> p2, pair<int,int> p3)
{
    return (p2.first-p1.first)*(p3.second-p1.second) - (p2.second-p1.second)*(p3.first-p1.first);
}

int convex_hull(int n, vector <pair<int,int> > &p1, vector <pair<int,int> > &p2){
    int i, j;
    int	top = 0;
    pair <int,int> tmp;

    //sort(p1.begin(), p1.end(), comp);
    for(i=0; i < n-1; i++){
    	for(j=i+1; j < n; j++){
    		if(p1[i].second > p1[j].second) continue;
    		if((p1[i].second < p1[j].second) || (p1[i].first < p1[j].first)){
    			tmp = p1[i];
    			p1[i] = p1[j];
    			p1[j] = tmp;
    		}
    	}
    }
    p2[top++] = p1[0];
    p2[top++] = p1[1];
    for (i = 2; i < n; i++)
    {
        while (top >= 2 && cross(p2[top - 2], p2[top - 1], p1[i]) <= 0)
            --top;
        p2[top++] = p1[i];
    }
    int r = top;
    for (i = n - 2; i >= 0; i--)
    {
        while (top > r && cross(p2[top - 2], p2[top - 1], p1[i]) <= 0)
            --top;
        if (i != 0)
            p2[top++] = p1[i];
    }
    return top;
}


int solve(int n, vector<pair<int, int> > &V, int t){
	int i, j, m;
	vector<pair<int,int> > V2(V.begin(), V.end());

	if(n > 3){
		m = convex_hull(n, V2, V);
	}
	else{
		m = 3;
	}

/*	for(i=0; i < m; i++)
		printf("%d,%d\n", V[i].first, V[i].second);*/

	V[m] = V[0];
	float a, b, dist, w, min;
	min = FLT_MAX;
	for(i=1; i <= m; i++){
		w = 0;
		for(j=1; j <= m; j++){
			if((j == i) || (j == i-1)) continue;
			if((i == 1) && (j == m)) continue;

			if(V[i-1].first == V[i].first){
				a = 0.0;
				b = 0.0;
				dist = abs(V[i].first - V[j].first);
			}else{
				a = V[i].second - V[i-1].second;
				a /= (V[i].first - V[i-1].first);
               	b = -a * V[i-1].first + V[i-1].second;
				dist = fabs((float)(a*V[j].first - V[j].second + b));
				dist /= sqrt(a*a +1);
			}
			if(dist > w) w = dist;
		}
		if(w < min) min = w;
	}
	printf("Case %d: %.2f\n", t, ceil(min*100)/100);
}

int main(){
	int n, i, x, y, t;
	t = 1;
	vector < pair<int,int> > V(105);

	float a;
	a = 0;
	a /= 5;

	while(scanf("%d", &n) && n){
		V.clear();
		for(i=1; i <= n; i++){
			scanf("%d %d", &x, &y);
			V.insert(V.end(), make_pair(x, y));
		}
		solve(n, V, t++);
	}

	return 0;
}
