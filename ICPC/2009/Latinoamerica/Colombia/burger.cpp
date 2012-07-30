
#include <iostream>

#define MAX 2000005

using namespace std;

int L;
char cad[MAX];

int minDist() {
	int m = 0x3fffffff;
	int count=0; char last='.';
	for (char *c=cad; *c != '\0'; c++) {
		count++;
		if (*c != '.') {
			if (*c == 'Z') return 0;
			if (last == '.') {
				last = *c;				
			} else if (last != *c) {
				last = *c;
				m = (count < m) ? count : m;
			}
			count = 0;
		}
	}
	return m;
}

int main() {
	while (true) {
		cin >> L;
		if (L == 0) break;
		cin >> cad;
		cout << minDist() << endl;
	}	
	return 0;
}
