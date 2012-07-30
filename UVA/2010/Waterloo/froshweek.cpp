#include <vector>
#include <iostream>
#include <map>
#include <algorithm>
using namespace std;

// In this implementation, the tree is represented by a vector<int>.
// Elements are numbered by 0, 1, ..., n-1.
// tree[i] is sum of elements with indexes i&(i+1)..i, inclusive.
// (Note: this is a bit different from what is proposed in Fenwick's article.
// To see why it makes sense, think about the trailing 1's in binary
// representation of indexes.)

// Creates a zero-initialized Fenwick tree for n elements.
vector<int> create(int n) { return vector<int>(n, 0); }

// Returns sum of elements with indexes a..b, inclusive
int query(const vector<int> &tree, int a, int b) {
    if (a == 0) {
        int sum = 0;
        for (; b >= 0; b = (b & (b + 1)) - 1)
          sum += tree[b];
        return sum;
    } else {
        return query(tree, 0, b) - query(tree, 0, a-1);
    }
}

// Increases value of k-th element by inc.
void increase(vector<int> &tree, int k, int inc) {
    for (; k < (int)tree.size(); k |= k + 1)
        tree[k] += inc;
}


map<int, int> estudiantes;
int enOrden[1000000], normal[1000000];
int main()
{
    vector<int> a = create(1000011);
    while(true)
    {
        estudiantes.clear();
        int n;
        for(int i = 0; i < 1000011; i++)
        {
            a[i] = 0;
        }
        if(!(cin >> n))
            return 0;
        long long cuenta = 0;
        for(int i = 0; i < n; i++)
        {
            cin >> enOrden[i];
            normal[i] = enOrden[i];
        }
        sort(enOrden, enOrden + n);
        for(int i = 0; i < n; i++)
        {
            estudiantes[enOrden[i]] = i + 1;
        }
        for(int i = 0; i < n; i++)
        {
            int este = estudiantes[normal[i]];
            increase(a, este, 1);
            cuenta += query(a, este + 1, n);
        }
        cout << cuenta << endl;
    }
}
