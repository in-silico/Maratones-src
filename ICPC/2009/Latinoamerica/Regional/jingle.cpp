
#include <cstdio>
#include <cstring>

char buffer[300];
int val[60];

int solve() {
	int ans=0, sum=0, n=strlen(buffer);
	for (int i=0; i<n; i++) {
		if (buffer[i]=='/') {
			ans += (sum==64);
			sum=0;
		} else {
			sum += val[buffer[i]-'A'];
		}
	}
	return ans;
}

int main() {
	val['W'-'A']=64; val['H'-'A']=32; val['Q'-'A']=16;
	val['E'-'A']=8; val['S'-'A']=4; val['T'-'A']=2; val['X'-'A']=1;
	while (true) {
		scanf("%s",buffer);
		if (buffer[0]=='*') break;
		int x = solve();
		printf("%i\n", x);
	}
	return 0;
}

