#include <algorithm>
#include <iostream>
#include <math.h>
#include <string>

using namespace std;

struct CombinationGenerator
                {
                int a[52];
                int n;
                int r;
                long numLeft;
                long total;

                void reset (int nn, int rr)
				{
                        n = nn;
                        r = rr;
                        if(n == 47)
                        {
                            switch(r)
                            {
                                case 0: total = 0; break;
                                case 1: total = 47; break;
                                case 2: total = 1081; break;
                                case 3: total = 16215; break;
                                case 4: total = 178365; break;
                                case 5: total = 1533939; break;
                            }
                        }
                        if(n == 5)
                        {
                            switch(r)
                            {
                                case 0: total = 0; break;
                                case 1: total = 5; break;
                                case 2: total = 10; break;
                                case 3: total = 10; break;
                                case 4: total = 5; break;
                                case 5: total = 1; break;
                            }
                        }
                        for (int i = 0; i < r; i++) {
                                a[i] = i;
                        }
                        numLeft = total;
                }

                bool hasMore () {
                        return numLeft != 0;
                }

                void getNext() {

                        if (numLeft == total) {
                                numLeft--;
                                return;
                        }
                        int i = r - 1;
                        while (a[i] == n - r + i) {
                                i--;
                        }
                        a[i] = a[i] + 1;
                        for (int j = i + 1; j < r; j++) {
                                a[j] = a[i] + j - i;
                        }
                        numLeft--;
                        return;
                }
        };

		struct Carta
        {
            int valor;
            int pinta;

                Carta(char numero, char suit)
                {
                    switch(numero)
                    {
                            case 'T': valor = 10; break;
                            case 'J': valor = 11; break;
                            case 'Q': valor = 12; break;
                            case 'K': valor = 13; break;
                            case 'A': valor = 14; break;
                            default: valor = numero - '0'; break;
                    }
                    switch(suit)
                    {
                            case 'h': pinta = 1; break;
                            case 'd': pinta = 2; break;
                            case 's': pinta = 3; break;
                            default: pinta = 4; break;
                    }
            }

                Carta(){}

            bool operator<(const Carta otra) const
            {
                    return valor > otra.valor;
            }

        };

		bool contains(int arreglo[5], int numero)
		{
			for(int i = 0; i < 5; i++)
				if(arreglo[i] == numero)
					return true;
			return false;
		}

		int indexOf(int arreglo[5], int numero)
		{
			for(int i = 0; i < 5; i++)
				if(arreglo[i] == numero)
					return i;
			return 0;
		}

		int lastIndexOf(int arreglo[5], int numero)
		{
			for(int i = 4; i >= 0; i--)
				if(arreglo[i] == numero)
					return i;
			return 0;
		}

        struct Mano
        {
                Carta mano[5];
                int tipo;

                void calcularValor()
            	{
                    Carta mano[5];
                    for(int i = 0; i < 5; i++)
                        mano[i] = this->mano[i];
                        sort(mano, mano + 5);
                        int repetidas[5];
                        tipo = 0;
                        for(int i = 0; i < 5; i++)
                                repetidas[i] = 1;
                        for(int i = 0; i < 5; i++)
                        {
                                for(int j = 0; j < 5; j++)
                                {
                                        if(j != i)
                                        {
                                                if (mano[i].valor == mano[j].valor)
                                                {
                                                        repetidas[i] += 1;
                                                }
                                        }
                                }
                        }
                        if(contains(repetidas, 4))
                        {
                                tipo = 7;
                        }
                        else if(contains(repetidas, 3) && contains(repetidas, 2))
                        {
                                tipo = 6;
                        }
                        else if(contains(repetidas, 3))
                        {
                                tipo = 3;
                        }
                        else if(contains(repetidas, 2))
                        {
                                if(indexOf(repetidas, 2) + 1 != lastIndexOf(repetidas, 2))
                                {
                                        tipo = 2;
                                }
                                else
                                {
                                        tipo = 1;
                                }
                        }
                        else
                        {
                                bool color = true;
                                int pinta = mano[0].pinta;
                                for(int i = 0; i < 5; i++)
                                {
                                        if(mano[i].pinta != pinta)
                                                color = false;
                                }
                                bool escalera = true;
                                int valor = mano[1].valor;
                                for(int i = 1; i < 5; i++)
                                {
                                        if(mano[i].valor != valor)
                                                escalera = false;
                                        else
                                                valor--;
                                }
                                if(escalera == true)
                                {
                                        if(mano[0].valor - 1 != mano[1].valor)
                                        {
                                                if(!(mano[0].valor == 14 && mano[1].valor == 5))
                                                {
                                                        escalera = false;
                                                }
                                        }
                                }
                                if(escalera && color)
                                {
                                    if(mano[0].valor == 14 && mano[1].valor == 13 && mano[2].valor == 12 && mano[3].valor == 11 && mano[4].valor == 10)
                                    {
                                        tipo = 9;
                                    }
                                    else
                                    {
                                        tipo = 8;
                                    }
                                }
                                else if(color)
                                        tipo = 5;
                                else if(escalera)
                                         tipo = 4;}

                        }
            };

            int payOut[10];
            int main()
            {
                int ntc;
                cin >> ntc;
                cout.precision(10);
                CombinationGenerator externo;
                CombinationGenerator interno;
                while(ntc--)
                {
                    for(int i = 1; i < 10; i++)
                    {
                        cin >> payOut[i];
                    }
                    payOut[0] = 0;
                    int nManos;
                    cin >> nManos;
                    for(int i = 0; i < nManos; i++)
                    {
                        Mano inicial;
                        for(int i = 0; i < 5; i++)
                        {
                            char entrada[10];
                            cin >> entrada;
                            inicial.mano[i] = Carta(entrada[0], entrada[1]);
                        }
                        Carta todas[52];
                        int numAct = 0;
                        for(int valor = 2; valor < 15; valor++)
                        {
                            for(int pinta = 1; pinta < 5; pinta++)
                            {
                                bool esta = false;
                                for(int i = 0; i < 5; i++)
                                {
                                    if(inicial.mano[i].valor == valor && inicial.mano[i].pinta == pinta)
                                    {
                                        esta = true;
                                    }
                                }
                                if(!esta)
                                {
                                    todas[numAct] = Carta();
                                    todas[numAct].valor = valor;
                                    todas[numAct++].pinta = pinta;
                                }
                            }
                        }
                        double mejor = 0;
                        for(int i = 1; i <= 5; i++)
                        {
                            externo.reset(5, i);
                            Mano manoActual;
                            while(externo.hasMore())
                            {
                                int cuenta = 0;
                                externo.getNext();
                                for(int j = 0; j < i; j++)
                                {
                                    manoActual.mano[cuenta++] = inicial.mano[externo.a[j]];
                                }
                                interno.reset(47, 5 - i);
                                double cuentaA = 0;
                                double numero = 0;
                                int cuentaG = cuenta;
                                while(interno.hasMore())
                                {
                                    cuenta = cuentaG;
                                    numero++;
                                    interno.getNext();
                                    for(int j = 0; j < 5 - i; j++)
                                    {
                                        manoActual.mano[cuenta++] = todas[interno.a[j]];
                                    }
                                    manoActual.calcularValor();
                                    cuentaA += payOut[manoActual.tipo];
                                }
                                mejor = max(mejor, cuentaA / numero);
                            }
                        }
                        inicial.calcularValor();
                        mejor = max(mejor, payOut[inicial.tipo] + 0.0);
                        cout << mejor << endl;
                    }
                }
            }
