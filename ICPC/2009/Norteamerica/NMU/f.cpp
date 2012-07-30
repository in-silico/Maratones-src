#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <cstring>

using namespace std;

int main()
{
    int hora, minuto, segundo, minutoM, segundoM;
    int caso = 1;
    while(scanf("%i:%i:%i %i:%i", &hora, &minuto, &segundo, &minutoM, &segundoM) == 5)
    {
        segundo += segundoM;
        if(segundo >= 60)
        {
            minuto++;
            segundo = segundo % 60;
        }
        minuto += minutoM;
        if(minuto >= 60)
        {
            hora++;
            minuto = minuto % 60;
        }
        if(hora > 12)
            hora = hora % 12;
        cout << "Case " << caso++ << ": The new time is " << hora << ":";
        if(minuto < 10)
            cout << "0";
        cout << minuto << ":";
        if(segundo < 10)
            cout << "0";
        cout << segundo << "\r\n";
        cout << "\r\n";
    }
}