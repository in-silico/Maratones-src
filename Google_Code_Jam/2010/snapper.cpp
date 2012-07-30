
#include <iostream>

using namespace std;

int main() {
	int t,n,k;
	cin >> t; //test cases
	for (int i=1; i<=t; i++) {
		cin >> n >> k;
		cout << "Case #" << i << ": ";
		int mask = (1 << n) - 1;
		if ((k & mask)==mask) {
			cout << "ON\n";
		} else {
			cout << "OFF\n";
		}
	}
	return 0;
}
