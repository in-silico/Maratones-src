import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A {
	 
	 static Integer[][] matriz = new Integer[101][101];
	 static boolean[][] matrizV = new boolean[101][101];
	 public static void main(String[] args) throws IOException
	 {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 while(true)
		 {
			 for(int i = 0; i < 101; i++)
				 for(int j = 0; j < 101; j++)
					 matriz[i][j] = null;
			 int n;
			 n = Integer.parseInt(br.readLine());
			 if(n == 0)
				 return;
			 boolean paila = false;
			 for(int i = 0; i < n - 1; i++)
			 {
				 String[] s = br.readLine().split("\\s+");
				 int cuenta = 0;
				 int a1 = 0;
				 int a2 = 0;
				 for(int j = 0; j < n; j++)
				 {
					 a1 = Integer.parseInt(s[cuenta++]);
					 a2 = Integer.parseInt(s[cuenta++]);
					 matriz[a1][a2] = i; 
				 }
				 for(int a = 0; a <= n; a++)
					 for(int b = 0; b <= n; b++)
						 matrizV[a][b] = false;
				 paila = paila || (visitar(a1, a2, i) != n);
			 }
			 int a1 = 0;
			 int a2 = 0;
			 for(int i = 1; i <= n; i++)
			 {
				 for(int j = 1; j <= n; j++)
				 {
					 if(matriz[i][j] == null)
					 {
						 matriz[i][j] = n;
						 a1 = i;
						 a2 = j;
					 }
				 }
			 }				 
			 for(int a = 0; a <= n; a++)
				 for(int b = 0; b <= n; b++)
					 matrizV[a][b] = false;
			 paila = paila || (visitar(a1, a2, n) != n);
			 if(paila)
				 System.out.println("wrong");
			 else
				 System.out.println("good");
		 }
	 }
	 
	private static int visitar(int a1, int a2, int j)
	{
		try
		{
			if(matrizV[a1][a2] == false)
			{
				matrizV[a1][a2] = true;
			}
			else
			{
				return 0;
			}
			if(matriz[a1][a2] == null)
			{
				return 0;
			}
		}
		catch(Exception e)
		{
			return 0;
		}
		if(matriz[a1][a2].intValue() == j)
		{
			int cuenta = 1;
			cuenta += visitar(a1 - 1, a2, j);
			cuenta += visitar(a1 + 1, a2, j);
			cuenta += visitar(a1, a2 - 1, j);
			cuenta += visitar(a1, a2 + 1, j);
			return cuenta;
		}
		return 0;
	}
}
