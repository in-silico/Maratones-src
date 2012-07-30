/* 
 * File:   test.cpp
 * Author: santiago
 *
 * Created on October 13, 2010, 4:13 PM
 */

#include <iostream>

using namespace std;

int xis[300];

int main()
{
    int t;
    cin >> t;
    int t2 = 2 * t;
    for(int i = 1; i < t2; i += 2)
    {
        cin >> xis[i];
    }
    bool termino = false;
    for(int a = 0; a <= 10000; a++)
    {
        for(int b = 0; b <= 10000; b++)
        {
            termino = true;
            for(int i = 2; i <= t2; i++)
            {
                if(i & 1 == 1)
                {
                    if(xis[i] != (((a * xis[i - 1] + b)) % 10001))
                    {
                        termino = false;
                        break;
                    }
                }
                else
                {
                    xis[i] = (a * xis[i - 1] + b) % 10001;
                }
            }
            if(termino)
            {
                for(int i = 2; i <= t2; i += 2)
                {
                    cout << xis[i] << endl;
                }
                break;
            }
        }
        if(termino)
            break;
    }
}
