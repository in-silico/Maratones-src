#include <iostream>
#include <list>

using namespace std;

	char tablero[20][20];
	int descomp[][4] = {{0, 0, 0, 0}, {1, 0, 0, 0}, {1, 2, 0, 0}, {1, 3, 0, 0}, {1, 2, 4, 0}, {1, 5, 0, 0}, {1, 2, 3, 6}, {1, 7, 0, 0}, {1, 2, 4, 8}, {1, 3, 9, 0}};
	char act;
	int TAM;
	bool poner(int, int);

	struct Lider
	{
		int i, j, peso, cuenta;

		Lider(int ii, int jj, int p, int c)
		{
			i = ii;
			j = jj;
			peso = p;
			cuenta = c;
		}
	};

	list <Lider> lista;

	bool compare(Lider a, Lider b)
	{
		return a.cuenta < b.cuenta;
	}
	
	bool posible(int I, int J, int W, int H)
	{
		if(I < 0 || J < 0 || J + W > TAM || I + H > TAM)
			return false;
		for(int i = I; i < I + H; i++)
		{
			for(int j = J; j < J + W; j++)
			{
				if(tablero[i][j] != '.')
					return false;
			}
		}
		return true;
	}
	
	void llenar(int I, int J, int W, int H, char c)
	{
		for(int i = I; i < I + H; i++)
		{
			for(int j = J; j < J + W; j++)
			{
				tablero[i][j] = c;
			}
		}
	}

	int contarFormas(int I, int J)
	{
		int cuenta = 0;
		char num = tablero[I][J];
		tablero[I][J] = '.';
		for(int ii = 0; ii < 4; ii++)
		{
			int W = descomp[num - '0'][ii];
			if(W == 0)
				continue;
			int H = (num - '0') / W;
			for(int i = 0; i < H; i++)
				for(int j = 0; j < W; j++)
					if(posible(I - i, J - j, W, H))
						cuenta++;
		}
		tablero[I][J] = num;
		return cuenta;
	}
	
	bool resolver()
	{
		if(lista.empty())
			return true;
		bool posible = true;
		for (list <Lider> ::iterator ci = lista.begin(); ci != lista.end(); ++ci)
		{
            		ci->cuenta = contarFormas(ci->i, ci->j);
			posible = posible && ci->cuenta != 0;
		}
		if(!posible)
			return false;
		lista.sort(compare);
		Lider l = lista.front();
		lista.pop_front();
		if(poner(l.i, l.j))
			return true;
		lista.push_front(l);
		return false;
	}
	
	bool poner(int I, int J)
	{
		act++;
		char num = tablero[I][J];
		tablero[I][J] = '.';
		for(int ii = 0; ii < 4; ii++)
		{
			int W = descomp[num - '0'][ii];
			if(W == 0)
				continue;
			int H = (num - '0') / W;
			for(int i = 0; i < H; i++)
				for(int j = 0; j < W; j++)
				{
					if(posible(I - i, J - j, W, H))
					{
						llenar(I - i, J - j, W, H, act);
						if(resolver())
							return true;
						llenar(I - i, J - j, W, H, '.');
					}
				}
		}
		act--;
		tablero[I][J] = num;
		return false;
	}
	
	int main()
	{
		while(true)
		{
			int k;
			cin >> TAM >> k;
			if(TAM == 0 && k == 0)
				return 0;
			act = 'A' - 1;
			for(int i = 0; i < TAM; i++)
				for(int j = 0; j < TAM; j++)
					cin >> tablero[i][j];
			for(int I = 0; I < TAM; I++)
				for(int J = 0; J < TAM; J++)
					if(tablero[I][J] >= '0' && tablero[I][J] <= '9')
					{
						lista.push_back(Lider(I, J, tablero[I][J] - '0', 0));
					}
			resolver();
			lista.clear();
			for(int i = 0; i < TAM; i++)
			{
				for(int j = 0; j < TAM; j++)
					cout << tablero[i][j];
				cout << endl;
			}
		}
		
	}
