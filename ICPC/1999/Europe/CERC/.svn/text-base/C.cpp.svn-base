#include <complex>
#include <cmath>
#include <iostream>

#define Vector complex<double>
#define Point complex<double>
#define Complejo complex<double>

#define X real()
#define Y imag()
#define norma(X) (abs(X))
#define PI (2*acos(0))
#define PREC 1e-6
#define eq(X,Y) (fabs((X)-(Y))<PREC)
#define lt(X,Y) (!eq((X),(Y))&&((X)<(Y)))
#define gt(X,Y) (lt(Y,X))

using namespace std;

double dotp(Vector a, Vector b)
{
	return a.X * b.Y + a.Y * b.X;
}

double ang_vect(Vector a, Vector b)
{
	return acos(dotp(a, b) / (norma(a) * norma(b)));
}

double rad2grad(double rad)
{
	return rad * 180 / PI;
}

// Distancia entre dos puntos
double dist(Vector a, Vector b)
{
	return norma(a - b);
}

// Puntos
Vector rotacion(Vector a, Vector ref, double ang)
{
	Vector c = a - ref;
	Vector v1(cos(ang), -sin(ang));
	Vector v2(sin(ang), cos(ang));
	Vector res(dotp(c, v1), dotp(c, v2));
	return res;
}

int difs[9][2] = {{0,0},{-1z,0},{0,-1},{-1,-1},{1,0},{0,1},{1,1},{-1,1},{1,-1}};

int main()
{
    int t;
    cin >> t;
    while(t--)
    {
        int xr, xi, br, bi;
        cin >> xr >> xi >> br >> bi;
        Complejo x(xr, xi);
        Complejo b(br, bi);
        bool termino = false;
        int nas = 0;
        int as[1000];
        while(true)
        {
            Complejo res = x / b;
            if(eq(abs(res), 0))
                break;
            bool bien = false;
            if(eq(res.X, (int) (res.X + 0.5)))
                res.X = (int) (res.X + 0.5);
            if(eq(res.X, (int) (res.X - 0.5)))
                res.X = (int) (res.X - 0.5);
            if(eq(res.Y, (int) (res.Y + 0.5)))
                res.Y = (int) (res.Y + 0.5);
            if(eq(res.Y, (int) (res.Y - 0.5)))
                res.Y = (int) (res.Y - 0.5);
            for(int i = 0; i < 9; i++)
            {
                double decimalR = res.X - (int) (res.X + difs[i][0]);
                double decimalI = res.Y - (int) (res.Y + difs[i][1]);
                Complejo dec(decimalR, decimalI);
                dec *= b;
                double decimalRes = dec.X;
                double decimalImag = dec.Y;
                if(!eq(decimalImag, 0))
                {
                    continue;
                }
                if(!eq(decimalRes, (int) (decimalRes + 0.5)))
                {
                    continue;
                }
                as[nas++] = (int) (decimalRes + 0.5);
                x /= b;
                x.X = (int) (res.X + difs[i][0]);
                x.Y = (int) (res.Y + difs[i][1]);
                bien = true;
                break;
            }
            if(!bien)
            {
                termino = true;
                break;
            }
        }
        if(termino)
        {
            cout << "The code cannot be decrypted.";
        }
        else
        {
            cout << as[nas - 1];
            for(int i = nas - 2; i >= 0; i--)
            {
                cout << "," << as[i];
            }
        }
        cout << endl;
    }
}

