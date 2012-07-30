import java.util.Scanner;


public class Okviri 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		char[][] salida = new char[5][1000];
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 1000; j++)
				salida[i][j] = '.';
		int actual = 2;
		int numero = 1;
		for(char c : word.toCharArray())
		{
			poner(salida, c, actual, numero++);
			actual += 4;
		}
		for(int i = 0; i < 5; i++)
			System.out.println(new String(salida[i], 0, actual - 1));
	}

	static void poner(char[][] salida, char c, int actual, int numero) 
	{
		salida[2][actual] = c;
		char caracter = numero % 3 == 0 ? '*' : '#';
		if(salida[2][actual - 2] != '*')
			salida[2][actual - 2] = caracter;
		salida[2][actual + 2] = caracter;
		salida[1][actual - 1] = caracter;
		salida[1][actual + 1] = caracter;
		salida[0][actual] = caracter;
		salida[3][actual - 1] = caracter;
		salida[3][actual + 1] = caracter;
		salida[4][actual] = caracter;
	}
}
