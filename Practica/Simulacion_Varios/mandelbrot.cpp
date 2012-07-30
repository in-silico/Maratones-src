#include <iostream>
#include <complex>
using namespace std;

char salida[15];


void simular(complex <double> c)
{
	complex <double> z;
	bool termino = false;
	for(int i = 1; i <= 12; i++)
	{
		z = z * z + c;
		if(2 + 1e-6 < abs(z))
		{
			cout << salida[i];
			termino = true;
			break;
		}
	}
	if(!termino)
	{
		cout << ' ';
	}
}


int main()
{
	int n;
	cin >> n;
	while(n--)
	{
		double mini, minr, maxi, maxr, preci, precr;
		cin >> salida >> mini >> maxi >> preci >> minr >> maxr >> precr;
		for(double i = mini; i - maxi < 1e-6; i += preci)
		{
			for(double r = minr; r - maxr < 1e-6; r += precr)
			{
				complex <double> punto(r, i);
				simular(punto);
			}
			cout << endl;
		}
		if(n)
			cout << endl;
	}
}
