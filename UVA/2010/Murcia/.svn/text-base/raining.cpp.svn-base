/* 
 * File:   main.cpp
 * Author: seb
 *
 * Created on 22 de mayo de 2010, 04:43 PM
 */

#include <cstdio>

#define REP(i,n) for((i)=0; (i)<(n); (i)++)
#define REPB(i,n) for((i)=(n)-1; (i)>=0; (i)--)

#define MAX 10000
#define INC 1
#define DEC 2

char line[MAX+5];
int left[MAX+1];
int n;

void init(int *a,int n, int val) {
    int i;
    REP(i,n) {
        a[i]=val;
    }
}

void solve() {
    int altura, alt, i, area=0;
    init(left,MAX+1,-1);
    char *c=line;

    altura=MAX;
    alt=altura;
    while (*c!='\0' && *c!='\\') c++;

    i=0;
    while (*c != '\0') {
        if (left[alt] != -1) {
            area += i-left[alt]-1;
        }
        left[alt]=i;

        if (*c=='/') {
            left[alt] = -1;
            alt++;
        } else if (*c=='\\') {
            alt--;
        }

        if (alt==altura) {
            altura=MAX;
            alt=altura;
            while (*c!='\0' && *c!='\\') c++;
            i++;
            continue;
        }

        c++; i++;
    }
    if (left[alt] != -1) {
        area += i-left[alt]-1;
    }
    printf("%i\n", area);
}

int main(int argc, char** argv) {
    int i;
    scanf("%i",&n);
    REP(i,n) {
        scanf("%s",line);
        solve();
    }
}
