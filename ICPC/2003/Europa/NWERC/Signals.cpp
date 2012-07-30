#include <vector>
#include <iostream>
using namespace std;

/* Finds longest strictly increasing subsequence. O(n log k) algorithm. */
void find_lis(vector<int> &a, vector<int> &b)
{
	vector<int> p(a.size());
	int u, v;

	if (a.empty()) return;

	b.push_back(0);

	for (size_t i = 1; i < a.size(); i++) {
		if (a[b.back()] < a[i]) {
			p[i] = b.back();
			b.push_back(i);
			continue;
		}

		for (u = 0, v = b.size()-1; u < v;) {
			int c = (u + v) / 2;
			if (a[b[c]] < a[i]) u=c+1; else v=c;
		}

		if (a[i] < a[b[u]]) {
			if (u > 0) p[i] = b[u-1];
			b[u] = i;
		}
	}

	for (u = b.size(), v = b.back(); u--; v = p[v]) b[u] = v;
}

vector<int> lista;
vector<int> lis;

int main()
{
	int n;
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		int p;
		cin >> p;
		vector <int> actuales;
		for(int j = 0; j < p; j++)
		{
                    int a;
                    cin >> a;
			actuales.push_back(a);
		}
		vector <int> lis;
		find_lis(actuales, lis);
		cout << lis.size() << endl;
	}

}