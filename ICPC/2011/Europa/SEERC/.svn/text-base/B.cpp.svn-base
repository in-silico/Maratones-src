#include<cstdio>
#include<climits>
#include<cmath>
#include<cstring>
#include<string>
#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
#define INF  2147483647


const int maxINDX=102;
int flow[maxINDX][maxINDX],cap[maxINDX][maxINDX];
int path[maxINDX];
int src,dest;

int BFS(int node) {
	int i,item,cf;
	queue<int> q;
	for(i=1;i<=node;i++)
		path[i]=-2;
	q.push(src);
	path[src]=-1;
	while(!q.empty()) {
		item=q.front();
		q.pop();
		if(item==dest) {
			i=dest;
			cf=INF;
			while(path[i]!=-1) {
				if(cf>flow[path[i]][i])
					cf=flow[path[i]][i];
				i=path[i];
			}
			return cf;
		}
		for(i=1;i<=node;i++) {
			if(flow[item][i]!=0 && path[i]==-2) {
				q.push(i);
				path[i]=item;
			}
		}
	}
	return 0;
}

int maxflow(int node) {
	int i,j,cf,totalflow=0;
	while((cf=BFS(node))!=0) {
		totalflow+=cf;
		i=dest;
		while(path[i]!=-1) {
			flow[path[i]][i]-=cf;
			flow[i][path[i]]+=cf;
			i=path[i];
		}
	}
	return totalflow;
}

void graph_initial(int node){
	int i,j;
	for(i=1;i<=node;i++){
		for(j=1;j<=node;j++) {
			cap[i][j]=0;
			flow[i][j]=0;
		}
	}

}

int main()
{
	int node,edge,a,b,c,resultedFlow;

	int n, m, u, v;

	while(scanf("%d %d",&n,&m)!=0){
		//printf("%d %d\n",n,m);
		int V[1005][2];
		for(int i=1;i<=m;i++){
			scanf(" (%d,%d)",&u,&v);
			V[i][0]=++u;
			V[i][1]=++v;
			//printf("%d,%d\n",u,v);
		}

		//printf("---\n");
		if(m==0){
			printf("0\r\n");
			continue;
		}


		int ans=INT_MAX;
		for(src=1;src<n;src++){
			for(dest=src+1;dest<=n;dest++){
				graph_initial(n);

				for(int i=1;i<=m;i++) {
					a=V[i][0];
					b=V[i][1];
					cap[a][b]+=1;
					cap[b][a]+=1;
					flow[a][b]+=1;
					flow[b][a]+=1;
				}

				ans=min(ans,maxflow(n));
			}

		}
		printf("%d\r\n",ans);
	}
	printf("\r\n");

	return 0;
}
