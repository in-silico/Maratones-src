//* Problem  : E. 4 Values whose Sum is 0
//* Contest  : SWERC-2005
//* Type     : Solution
//* Date     : 2008.08.06
//* Author   : alt
//* Language : C++
//* Compiler : Microsoft Visual C++ 6.0

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include <vector>
#include <queue>
#include <string>
#include <stack>
#include <set>
#include <map>
#include <algorithm>

using namespace std;

// BEGIN CUT HERE
// types
typedef long long int64;
typedef unsigned long long uint64;
typedef pair <int,int> PII;
typedef vector <int> VI;
typedef vector <int64> VI64;
typedef vector <string> VS;
typedef vector <vector<string> > VVS;
typedef vector <vector<int> > VVI;
typedef vector <pair<int,int> > VPII;
typedef vector <vector<pair<int,int> > > VVPII;
typedef map<int,int> MII;
typedef map<string,int> MSI;
typedef queue<int> QI;
//loops
#define FOR(i, n) for (int i = 0; i < (int)n; i++)
#define FORR(i, n) for (int i = (int)(n)-1; i >= 0; i--)
#define FORE(i, a, b) for (int i = (int)(a); i <= (int)(b); i++)
#define FORER(i, a, b) for (int i = (int)(a); i >= int(b); i--)
#define FORSZ(i, a) FOR(i, SZ(a))
#define FORSZR(i, a) FORR(SZ(a), i)
#define FORO(i, x) for (typeof((x).begin()) i = (x).begin(); i != (x).end(); i++)
#define FOROR(i, x) for (typeof((x).end()) i = (x).end(); i != (x).begin(); i--)
#define REP(n) for (int _foo = (int)n - 1; _foo >= 0; _foo--)

#define VAR(a, b) typeof(b) a=(b)
#define FOREACH(it, c) for(VAR(it,(c).begin()); it!=(c).end(); it++)
//sorting & c
#define ALL(a) a.begin(), a.end()
#define RALL(a) a.rbegin(), a.rend()
#define SORT(a) sort(ALL(a))
#define RSORT(a) sort(RALL(a))
#define UNIQUE(c) SORT(c),(c).resize(unique(ALL(c))-(c).begin())
#define REVERSE(a) reverse(ALL(a))
//filling
#define FILLA(a,val) memset(a, val, sizeof(a))
#define FILLO(o,val) memset(&o, val, sizeof(o))
#define CLEARA(a) FILLA(a, 0)
#define CLEARO(a) FILLO(a, 0)
//misc
//#define X first
//#define Y second
#define MP make_pair
#define PB push_back
#define SZ(a) (int)a.size()
#define POP(a) a.top(), a.pop()
#define FRONT(a) a.front(), a.pop()
//const
const int INF = 1000000000;
const int64 INFL = 1000000000000000000LL;
const double PI =	acos(-1.0);
const double EPS = 1E-6;

/*template<class T> T& operator >?= (T &x, T y) {if(y>x) x=y; return x;}
template<class T> T& operator <?= (T &x, T y) {if(y<x) x=y; return x;}
template<class T> T operator >? (T x, T y) {return x>y?x:y;}
template<class T> T operator <? (T x, T y) {return x<y?x:y;}*/

//some math
template <typename T> inline T gcd(T a, T b)				{ return b ? gcd(b, a % b) : a; }
template <typename T> inline T gcd2(T a, T b)				{ while (a && b) if (a > b) a %= b; else b %= a; return (a + b);}
template <typename T> inline T lcm(T a, T b)				{ return a / gcd(a, b) * b; }
template <typename T> inline T abs(T a)					{ return a < 0 ? -a : a; }
template <typename T> inline T sqr(T a)					{ return a * a; }
template <typename T> inline double hypot(T a, T b)		{ return sqrt(1.0 * a * a + b * b);}
//template <typename T> inline double hypot(T a, T b, T ñ)	{ return sqrt(1.0 * a * a + b * b + ñ * ñ);}
template <typename T> inline T hypot2(T a, T b)			{ return a * a + b * b;}
template <typename T> inline T hypot2(T a, T b, T c)		{ return a * a + b * b + c * c;}
template <typename T> inline void chMin(T& a, T b) { if (b < a) a = b; }
template <typename T> inline void chMax(T& a, T b) { if (b > a) a = b; }

//assertions
#ifdef _DEBUG
#define ASSERT(f) if (!(f)) printf("%s\n", "ASSERTION FAILED!");
#define ASSERTS(f, s) if (!(f)) printf("%s [%s]\n", "ASSERTION FAILED!", s);
#else
#define ASSERT(f) f
#define ASSERTS(f, s) f
#endif

//input
inline int ri(){int tt; ASSERTS(scanf("%d", &tt) == 1, "ReadInt Failed"); return tt;}
inline int ri64(){int64 tt; ASSERTS(scanf("%lld", &tt) == 1, "ReadInt64 Failed"); return tt;}
inline double rd(){double tt; ASSERTS(scanf("%lf", &tt) == 1, "ReadDouble Failed"); return tt;}
inline void rs(char *s){ASSERTS(scanf("%s", s) == 1, "ReadChar* Failed");}
//output
inline void printVI(int *a, int n){FOR(i, n) printf("%d%c", a[i], i == n - 1 ? '\n' : ' ');}
inline void printI(int n){printf("%d\n", n);}
inline void printI64(int64 n){printf("%lld\n", n);}
// END CUT HERE

int n, N;

int a[1024*4], b[1024*4], c[1024*4], d[1024*4];

int X[1024*16*1024], Y[1024*16*1024];

int64 res;

void solve()
{
    res = 0;
	int x = 0, y = 0;
	FOR(i,n) FOR(j,n) X[x++] = a[i] + b[j];
	FOR(i,n) FOR(j,n) Y[y++] = -(c[i] + d[j]);
	sort(X, X + N);
	sort(Y, Y + N);
	x = y = 0;
	while (x < N && y < N)
	{
		int v = min(X[x], Y[y]);
		if (Y[y] == v && X[x] == v)
		{
			int c1 = 0, c2 = 0;
			while (x < N && X[x] == v) c1++, x++;
			while (y < N && Y[y] == v) c2++, y++;
			res += c1 * c2;
		}
		else if (X[x] < Y[y]) x++; 
		else y++;
	}
}

void result()
{
	printf("%lld\n", res);
}

int main()
{
    int casos = ri();
    bool empezo = false;
    for(int caso = 0; caso < casos; caso++)
    {
        if(empezo)
            printf("\n");
        empezo = true;
	    n = ri(); N = n * n;
	    FOR(i,n)
		    a[i] = ri(), b[i] = ri(), c[i] = ri(), d[i] = ri();
	    solve();
	    result();
	}
	return 0;
}

