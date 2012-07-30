#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>
#include <cstring>

using namespace std;

char entrada[20];

int main()
{
    int tam = 0;
    int caseN = 1;
    while ((cin >> entrada) && (tam = strlen(entrada)))
    {
        sort(entrada, entrada + tam);
        cout << "Case " << caseN++ << "\n";
        do
        {
            cout << entrada << "\n";
        } while(next_permutation(entrada, entrada + tam));
        cout << endl;
    }
}
