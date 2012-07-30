#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <algorithm>

#define MAXL 10000

using namespace std;

char text[MAXL];
int T[MAXL];
int SA[MAXL];
int LCP[MAXL];

inline bool leq(int a1, int a2, int b1, int b2) {
    return ((a1<b1) || (a1==b1 && a2<=b2));
}

inline bool leq(int a1, int a2, int a3, int b1, int b2, int b3) {
    return ( (a1<b1) || (a1==b1 && leq(a2,a3,b2,b3)) );
}

static void radixPass(int* a, int* b, int* r, int n, int K) {
    int* c = new int[K + 1];
    for (int i = 0; i <= K; i++) c[i] = 0;
    for (int i = 0; i < n; i++) c[r[a[i]]]++;
    for (int i = 0, sum = 0; i <= K; i++) { int t = c[i]; c[i] = sum; sum += t; }
    for (int i = 0; i < n; i++) b[c[r[a[i]]]++] = a[i];
    delete [] c;
}

// find the suffix array SA of T[0..n-1] in {1..K}^n
// require T[n]=T[n+1]=T[n+2]=0, n>=2
void suffixArray(int* T, int* SA, int n, int K) {
    int n0=(n+2)/3, n1=(n+1)/3, n2=n/3, n02=n0+n2;
    int* R = new int[n02 + 3]; R[n02]= R[n02+1]= R[n02+2]=0;
    int* SA12 = new int[n02 + 3]; SA12[n02]=SA12[n02+1]=SA12[n02+2]=0;
    int* R0 = new int[n0];
    int* SA0 = new int[n0];
    for (int i=0, j=0; i < n+(n0-n1); i++) if (i%3 != 0) R[j++] = i;
    radixPass(R , SA12, T+2, n02, K);
    radixPass(SA12, R , T+1, n02, K);
    radixPass(R , SA12, T , n02, K);
    int name = 0, c0 = -1, c1 = -1, c2 = -1;
    for (int i = 0; i < n02; i++) {
        if (T[SA12[i]] != c0 || T[SA12[i]+1] != c1 || T[SA12[i]+2] != c2) {
            name++; c0 = T[SA12[i]]; c1 = T[SA12[i]+1]; c2 = T[SA12[i]+2];
        }
        if (SA12[i] % 3 == 1) {
            R[SA12[i]/3] = name;
        } else {
            R[SA12[i]/3 + n0] = name;
        }
    }
    if (name < n02) {
        suffixArray(R, SA12, n02, name);
        for (int i = 0; i < n02; i++) R[SA12[i]] = i + 1;
    } else {
        for (int i = 0; i < n02; i++) SA12[R[i] - 1] = i;
    }

    for (int i=0, j=0; i < n02; i++)
        if (SA12[i] < n0) R0[j++] = 3*SA12[i];
    radixPass(R0, SA0, T, n0, K);
    for (int p=0, t=n0-n1, k=0; k < n; k++) {
        #define GetI() (SA12[t] < n0 ? SA12[t] * 3 + 1 : (SA12[t] - n0) * 3 + 2)
        int i = GetI(); // pos of current offset 12 suffix
        int j = SA0[p]; // pos of current offset 0 suffix
        if (SA12[t] < n0 ? // different compares for mod 1 and mod 2 suffixes
            leq(T[i], R[SA12[t] + n0], T[j], R[j/3]) :
            leq(T[i],T[i+1],R[SA12[t]-n0+1], T[j],T[j+1],R[j/3+n0])) {
            SA[k] = i; t++;
            if (t == n02) // done --- only SA0 suffixes left
                for (k++; p < n0; p++, k++) SA[k] = SA0[p];
        } else {
            SA[k] = j; p++;
            if (p == n0) // done --- only SA12 suffixes left
            for (k++; t < n02; t++, k++) SA[k] = GetI();
        }
    }
    delete [] R; delete [] SA12; delete [] SA0; delete [] R0;
}

int transAlphabet(const char *a1, int *a2) {
    int count[256], stlen=0, nsym=0;
    for (int i=0; i<256; i++) count[i]=0;
    for (const char *tmp=a1; *tmp!='\0'; tmp++, stlen++) count[*tmp]++;
    for (int i=0; i<256; i++) if (count[i]!=0) count[i]=++nsym;
    for (int i=0; i<stlen; i++) a2[i] = count[a1[i]];
    a2[stlen]=0; a2[stlen+1]=0; a2[stlen+2]=0;
    return nsym;
}

void lcp(char *text, int *SA, int *height, int n) {
	int rank[n];
	for (int i=0; i<n; i++) {
		rank[SA[i]] = i;
	}
	int h=0;
	for (int i=0; i<n; i++) {
		if (rank[i] > 1) {
			int k = SA[rank[i] - 1];
			while (text[i+h] == text[k+h]) h++;
			height[rank[i]] = h;
			if (h>0) h--;
		}
	}
}

void printVec(const char *texto, int *v, int n) {
	printf("%s = {%d", texto, v[0]);
	for (int i=1; i<n; i++)
		printf(",%d", v[i]);
	printf("}\n");
}

bool debug = false;

void solve(int n) {
	int maxix=0;
	for (int i=0; i<n; i++) {
		if (LCP[maxix] < LCP[i]) maxix=i;
	}
	if (LCP[maxix] == 0) {
		printf("No repetitions found!\n");
	} else {
		int len = LCP[maxix], rep=1;
		for (int i=maxix; i<n && LCP[i]==len; i++) rep++;
		char *tmp = &text[SA[maxix]];
		tmp[len]='\0';
		printf("%s %d\n", tmp, rep);
	}
}

int main() {
	int tc;
	scanf("%d",&tc);
	for (int i=0; i<tc; i++) {
		scanf("%s", text);
		int n = strlen(text);
		int k = transAlphabet(text, T);
		suffixArray(T,SA,n+1,k);
		lcp(text, SA, LCP, n+1);
		if (debug) {
			printVec("SA",SA,n+1);
			printVec("LCP",LCP,n+1);
		}
		solve(n+1);
		memset(SA, 0, (n+4)*sizeof(int)); memset(LCP, 0, (n+4)*sizeof(int));
		memset(T, 0, (n+4)*sizeof(int)); memset(text, 0, (n+4)*sizeof(char));
	}
}

