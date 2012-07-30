
#include <fstream>
#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n;
    while (true) {
        cin >> n;
        if (n==0) break;
        float f = ceil(log(n+1)/log(2)-1);
        cout << (int)f << endl;
    }
}
