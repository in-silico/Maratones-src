
#include <cstdlib>
#include <cstdio>
#include <iostream>

#define MAXN 5
#define REP(i,N) for((i)=0; (i)<(N); (i)++)
#define REPB(i,N) for((i)=(N)-1; (i)>=0; (i)--)

using namespace std;

int N;
char letter;

/*
 * 
 */
int main(int argc, char** argv) {
    int i,j, readed;
    while (true) {
        scanf("%i",&N);
        if (N==0) break;
        REP(i,N) {
            letter='0';
            REP(j,MAXN) {
                scanf("%i", &readed);
                if (readed<=127)
                    letter = (letter=='0') ? 'A'+j : '*';
            }
            if (letter=='0') letter='*';
            printf("%c\n", letter);
        }
    }
}

