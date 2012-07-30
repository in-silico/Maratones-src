#include <stdio.h>
#include <ctype.h>


int numero[5];
char letras[5];

int menor(int i, int j){
	switch(letras[i]){
	case 'H':
		switch(letras[j]){
		case 'C':
		case 'D':
		case 'S':
			return 1;
			break;
		case 'H':
			if(numero[i] < numero[j])
				return 1;
			else
				return 0;
		}
		break;

	case 'C':
		switch(letras[j]){
		case 'D':
		case 'S':
			return 1;
			break;
		case 'C':
			if(numero[i] < numero[j])
				return 1;
			else
				return 0;
		break;
		case 'H':
			return 0;
			break;
		}

		case 'D':
			switch(letras[j]){
			case 'S':
				return 1;
				break;
			case 'D':
				if(numero[i] < numero[j])
					return 1;
				else
					return 0;
				break;
			case 'H':
			case 'C':
				return 0;
				break;
			}

			case 'S':
				switch(letras[j]){
				case 'S':
					if(numero[i] < numero[j])
						return 1;
					else
						return 0;
				break;
				case 'H':
				case 'D':
				case 'C':
					return 0;
					break;
				}
	}
	return 0;
}



int main(){
	int n,i,t;
	scanf("%d", &n);
	for(t=1; t <= n; t++){
		for(i=0; i < 4; i++){
			getchar();
			scanf("%c%c", &numero[i], &letras[i]);
			if(isdigit(numero[i]))
				numero[i] -= '0';
			switch(numero[i]){
			case 'T': numero[i] = 10; break;
			case 'J': numero[i] = 11; break;
			case 'Q': numero[i] = 12; break;
			case 'K': numero[i] = 13; break;
			}
			//printf("%d%c\n", numero[i], letras[i]);
		}
		int valor = 0;
		if(menor(1, 2) && menor(2, 3)){ valor = numero[0]+1;}
		if(menor(1, 3) && menor(3, 2)){ valor = numero[0]+2;}
		if(menor(2, 1) && menor(1, 3)){ valor = numero[0]+3;}
		if(menor(3, 1) && menor(1, 2)){ valor = numero[0]+4;}
		if(menor(2, 3) && menor(3, 1)){ valor = numero[0]+5;}
		if(menor(3, 2) && menor(2, 1)){ valor = numero[0]+6;}
		valor %= 13;
		char imp;
		if(valor == 0)
			imp = 'K';
		else if(valor < 10)
			imp = valor + '0';
		else if(valor == 10)
			imp = 'T';
		else if(valor == 11)
			imp = 'J';
		else if(valor == 12)
			imp = 'Q';
		printf("%c%c\n", imp, letras[0]);
	}

	return 0;
}
