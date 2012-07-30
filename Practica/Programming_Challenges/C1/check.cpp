#include <iostream>
#include <string>
#include <sstream>

using namespace std;

char matriz[8][8];

bool termino()
{
	for(int i = 0; i < 8; i++)
	{
		for(int j = 0; j < 8; j++)
		{
			if(matriz[i][j] != '.')
			{
				return false;
			}
		}
	}
	return true;
}

void buscar(int &fblanco, int &cblanco, char rey)
{
	for(int i = 0; i < 8; i++)
	{
		for(int j = 0; j < 8; j++)
		{
			if(matriz[i][j] == rey)
			{
				fblanco = i;
				cblanco = j;
				return;
			}
		}
	}
}

bool jaque(int f, int c, bool blanco)
{
	char bishop = blanco ? 'b' : 'B';
	char queen = blanco ? 'q' : 'Q';
	int i = f, j = c;
	while(++i < 8 && ++j < 8 && matriz[i][j] == '.')
	{
	}
	if(i < 8 && j < 8 && ((matriz[i][j] == bishop) || (matriz[i][j] == queen)))
	{
		return true;
	}
	i = f;
	j = c;
	while(--i > -1 && ++j < 8 && matriz[i][j] == '.')
	{
	}
	if(i > -1 && j < 8 && ((matriz[i][j] == bishop) || (matriz[i][j] == queen)))
	{
		return true;
	}
	i = f;
	j = c;
	while(--i > -1 && --j > -1 && matriz[i][j] == '.')
	{
	}
	if(i > -1 && j > -1 && ((matriz[i][j] == bishop) || (matriz[i][j] == queen)))
	{
		return true;
	}
	i = f;
	j = c;
	while(++i < 8 && --j > -1 && matriz[i][j] == '.')
	{
	}
	if(i < 8 && j > -1 && ((matriz[i][j] == bishop) || (matriz[i][j] == queen)))
	{
		return true;
	}
	char rook = blanco ? 'r' : 'R';
	i = f;
	j = c;
	while(++i < 8 && matriz[i][j] == '.')
	{
	}
	if(i < 8 && ((matriz[i][j] == rook) || (matriz[i][j] == queen)))
	{
		return true;
	}
	i = f;
	j = c;
	while(--i > -1 && matriz[i][j] == '.')
	{
	}
	if(i > -1 && ((matriz[i][j] == rook) || (matriz[i][j] == queen)))
	{
		return true;
	}
	i = f;
	j = c;
	while(++j < 8 && matriz[i][j] == '.')
	{
	}
	if(j < 8 && ((matriz[i][j] == rook) || (matriz[i][j] == queen)))
	{
		return true;
	}
	i = f;
	j = c;
	while(--j > -1 && matriz[i][j] == '.')
	{
	}
	if(j > -1 && ((matriz[i][j] == rook) || (matriz[i][j] == queen)))
	{
		return true;
	}
	char pawn = blanco ? 'p' : 'P';
	if((blanco ? f > 0 : f < 7) && c > 0 && (blanco ? matriz[f - 1][c - 1] == pawn : matriz[f + 1][c - 1] == pawn))
	{
		return true;
	}
	if((blanco ? f > 0 : f < 7) && c < 7 && (blanco ? matriz[f - 1][c + 1] == pawn : matriz[f + 1][c + 1] == pawn))
	{
		return true;
	}
	char knight = blanco ? 'n' : 'N';
	if(f > 0 && c > 1 && matriz[f - 1][c - 2] == knight)
	{
		return true;
	}
	if(f > 1 && c > 0 && matriz[f - 2][c - 1] == knight)
	{
		return true;
	}
	if(f > 1 && c < 7 && matriz[f - 2][c + 1] == knight)
	{
		return true;
	}
	if(f > 0 && c < 6 && matriz[f - 1][c + 2] == knight)
	{
		return true;
	}
	if(f < 7 && c > 1 && matriz[f + 1][c - 2] == knight)
	{
		return true;
	}
	if(f < 6 && c > 0 && matriz[f + 2][c - 1] == knight)
	{
		return true;
	}
	if(f < 6 && c < 7 && matriz[f + 2][c + 1] == knight)
	{
		return true;
	}
	if(f < 7 && c < 6 && matriz[f + 1][c + 2] == knight)
	{
		return true;
	}
	return false;
}


int main()
{
	string actual;
	int i = 1;
	while(true)
	{
		for(int j = 0; j < 8; j++)
		{
			cin >> matriz[j];
		}
		if(termino())
		{
			return 0;
		}
		bool termino = false;
		int fblanco = 0, cblanco = 0;
		buscar(fblanco, cblanco, 'K');
		if(jaque(fblanco, cblanco, true))
		{
			cout << "Game #" << (i++) << ": white king is in check." << endl;
			termino = true;
		}
		int fnegro = 0, cnegro = 0;
		buscar(fnegro, cnegro, 'k');
		if(!termino)
		{
			if(jaque(fnegro, cnegro, false))
			{
				cout << "Game #" << (i++) << ": black king is in check." << endl;
			}
			else
			{
				cout << "Game #" << (i++) << ": no king is in check." << endl;
			}
		}
		getline(cin, actual);
	}
}
