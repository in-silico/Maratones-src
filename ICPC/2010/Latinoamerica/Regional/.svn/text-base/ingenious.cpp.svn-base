/* 
 * File:   newmain.cpp
 * Author: santiago
 *
 * Created on November 5, 2010, 5:48 PM
 */
#include<iostream>
#include<algorithm>
#include<set>

using namespace std;
int tele[100001];
set<int>diferencias;
set<int>divisores;

int gcd(int a, int b)
{
	if(b == 0)
	{
	        return a;
	}
	else
	{
		return gcd(b, a % b);
	}
}

int main()
{
    while(true)
    {
        int t, q;
        cin >> t >> q;
        if(t == 0 || q == 0)
            break;
        for(int i = 0; i < t; i++)
            cin >> tele[i];
        sort(tele, tele + t);
        diferencias.clear();
        for(int i = 1; i < t; i++)
        {
            diferencias.insert(tele[i] - tele[i - 1]);
        }
        int empezo = 0;
        for(int i = 0; i < q; i++)
        {
            int a, b;
            cin >> a >> b;
            int query = abs(a - b);
            if(query % 2 != 0)
            {
                if(empezo++)
                    cout << " ";
                cout << "N";
                continue;
            }
            else
            {
                bool si = false;
                for(int i = 0; i < t; i++)
                    if(2 * tele[i] - a == b)
                        si = true;
                if(si)
                {
                    if(empezo++)
                        cout << " ";
                    cout << "Y";
                    continue;
                }
            }
            query /= 2;
            divisores.clear();
            bool si = false;
            for(set<int>::iterator it = diferencias.begin(); it != diferencias.end(); it++)
            {
                int g = gcd(*it, query);
                if((query >= *it && query % *it == 0) || divisores.find(g) != divisores.end())
                {
                    si = true;
                    break;
                }
                else
                {
                    divisores.insert(g);
                }
            }
            if(empezo++)
                cout << " ";
            if(si)
                cout << "Y";
            else
                cout << "N";
        }
        cout << endl;
    }
}

