package UVA;

import java.io.IOException;
import java.util.Scanner;

public class mine 
{
	static boolean [][] minas;
	static int [][] resultado;
	static int n;
	static int m;
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int actual = 1;
		m = sc.nextInt();
		n = sc.nextInt();
		while(true)
		{
			 minas = new boolean[n][m];
			 resultado = new int[n][m];
			 int mActual = 0;
			 int nActual = 0;
			 sc.nextLine();
			 for(int i = 0; i < m; i++)
			 {
				 String linea = sc.nextLine();
				 for(char c : linea.toCharArray())
				 {
					 resultado[nActual][mActual] = c == '*' ? -1 : 0;
					 minas[nActual++][mActual] = c == '*';
				 }
				 nActual = 0;
				 mActual++;
			 }
			 solucionar();
			 System.out.println("Field #" + actual++ + ":");
			 for(int i = 0; i < m; i++)
			 {
				 for(int j = 0; j < n; j++)
				 {
					 System.out.print(resultado[j][i] == -1 ? '*' : (resultado[j][i] + ""));
				 }
				 System.out.println();
			 }
			 m = sc.nextInt();
			 n = sc.nextInt();
			 if(m == 0 && n == 0)
				 return;
			 else
				 System.out.println();
		}
	}
	
	static void solucionar()
	{
		for(int i = 0; i < m; i++)
		 {
			 for(int j = 0; j < n; j++)
			 {
				 if(!minas[j][i])
				 {
					 int acumulado = 0;
					 if(j > 0 && i > 0 && minas[j - 1][i - 1])
						 acumulado++;
					 if(j > 0 && minas[j - 1][i])
						 acumulado++;
					 if(i > 0 && minas[j][i - 1])
						 acumulado++;
					 if(j < n - 1 && i < m - 1 && minas[j + 1][i + 1])
						 acumulado++;
					 if(j < n - 1 && minas[j + 1][i])
						 acumulado++;
					 if(i < m - 1 && minas[j][i + 1])
						 acumulado++;
					 if(j < n - 1 && i > 0 && minas[j + 1][i - 1])
						 acumulado++;
					 if(i < m - 1 && j > 0 && minas[j - 1][i + 1])
						 acumulado++;
					 resultado[j][i] = acumulado;
				 }
			 }
		 }
	}

}
