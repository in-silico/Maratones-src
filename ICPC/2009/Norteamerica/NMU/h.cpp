#include <map>
#include <utility>
#include <iostream>
#include <list>
#include <cmath>
#include <cstdio>

using namespace std;

double interseccionCirculos(double r1, double r2, double d)
{
    if(d == 0 || d + r2 < r1 || d + r1 < r2)
        return min(M_PI * r1 * r1, M_PI * r2 * r2);
    double a = pow(r1, 2) * acos((pow(d, 2) + pow(r1, 2) - pow(r2, 2)) / (2 * d * r1));
    double b = pow(r2, 2) * acos((pow(d, 2) + pow(r2, 2) - pow(r1, 2)) / (2 * d * r2));
    double c = (sqrt((-d + r1 + r2) * (d + r1 - r2) * (d - r1 + r2) * (d + r1 + r2))) / 2;
    double respuesta = a + b - c;
    if(respuesta != respuesta)
        return 0;
    return respuesta;
}

int main()
{
    double r1, r2, d;
    int caso = 1;
    while(cin >> r1 >> r2 >> d && (r1 != 0 || r2 != 0 || d != 0))
    {
        double res = interseccionCirculos(r1, r2, d);
        res *= 100;
        res = round(res);
        cout << "Case " << caso++ << ": Green occupies an area of ";
        printf("%.2lf", res / 100);
        cout << " square meters.\r\n";
    }
}