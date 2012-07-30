#include <cstdlib>
#include <iostream>
#include <cstring>

using namespace std;

char entrada[1000];

int main()
{
    while(true)
    {
        cin.getline(entrada, 1000);
        if(entrada[0] == '#')
            break;
        int n = strlen(entrada);
        int cuenta = 0;
        for(int i = 0; i < n; i++)
        {
            if(entrada[i] != ' ')
                cuenta += (i + 1) * (entrada[i] - 'A' + 1);
        }
        cout << cuenta << endl;
    }
}

