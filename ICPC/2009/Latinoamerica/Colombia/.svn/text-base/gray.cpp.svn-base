
#include <cstdio>
#include <cstring>

using namespace std;

#define MAX 105
#define NOT(x) (x=='1')?'0':'1';

int min(int x, int y) {
	return (x<y) ? x : y;
}

void transform(char *src, char *trans, bool rev) {
	if (*src == '\0') {
		*trans='\0';
		return;
	}
	if (rev) {
		*trans = NOT(*src);
		transform(src+1, trans+1, *src=='0');
	} else {
		*trans = *src;
		transform(src+1, trans+1, *src=='1');
	}
}

void inv(char *src, char *trans, bool rev) {
	if (*src == '\0') {
		*trans='\0';
		return;
	}
	if (rev) {
		*trans = NOT(*src);
		inv(src+1, trans+1, *trans=='0');
	} else {
		*trans = *src;
		inv(src+1, trans+1, *trans=='1');
	}
}

void add(char *acum, char *op, int bits, char carry) {
	if (bits == -1) return;
	char ncarry = ((carry+acum[bits]+op[bits])-0x90 >= 2) ? '1' : '0';
	if (acum[bits] == op[bits])
		acum[bits] = carry;
	else 
		acum[bits] = NOT(carry);
	add(acum,op,bits-1,ncarry);
}

int main() {
	char src[MAX];
	char tmp[MAX];
	int m,l;
	while (true) {
		scanf("%i %s", &m, src);
		l = strlen(src);
		if (l==1 && m==0 && *src=='0') break;
		transform(src, tmp, false);
		if (l < 16) m &= (1<<m)-1;
		int p=0;
		for (int i=l-16; i>0; i--) src[p++]='0';
		for (int i=(1<<min(l-1,15)); i>0; i>>=1) src[p++]=(m & i) ? '1' : '0';
		add(tmp, src, l-1, '0');
		inv(tmp, src, false);
		printf("%s\n", src);
	}
}
