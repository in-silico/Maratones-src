import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class A
{
	
	static int[] solucion = new int[10000001];
	static int[] solucionb = new int[10000001];

	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("salida"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		simular();
		solucion[1] = 1;
		for(int caso = 1; caso <= n; caso++)
		{
			int buscado = sc.nextInt();
			int mejor = buscado + 1;
			if(buscado == 1)
				mejor = 2;
			for(int i = 1; i < buscado; i++)
				if(i == 1 || buscado % i == 0)
						mejor = Math.min(mejor, Math.min(solucion[i], i) + Math.min(solucion[buscado / i], (buscado / i) + 1));
			System.out.println("Case #" + caso + ": " + mejor);
		}
	}

	
	static long[][] matriz = new long[20000][20000];
	
	private static void simular()
	{
		for(int i = 0; i <= 10000000; i++)
		{
			solucion[i] = Integer.MAX_VALUE;
			solucionb[i] = Integer.MAX_VALUE;
		}
		matriz[0][0] = 1;
		for(int i = 0; i < 20000; i++)
			for(int j = 0; j < 20000; j++)
			{
				if(i != 0)
				{
					if(matriz[i - 1][j] >= Integer.MAX_VALUE)
					{
						matriz[i][j] = Integer.MAX_VALUE;
						continue;
					}
					else
						matriz[i][j] = matriz[i - 1][j];
				}
				if(j != 0)
				{
					if(matriz[i][j - 1] >= Integer.MAX_VALUE || matriz[i][j] + matriz[i][j - 1] >= Integer.MAX_VALUE)
					{
						matriz[i][j] = Integer.MAX_VALUE;
						continue;
					}
					else
						matriz[i][j] += matriz[i][j - 1];
				}
			}
		for(int i = 0; i < 20000; i++)
			for(int j = 0; j < 20000; j++)
			{
				if(matriz[i][j] <= 10000000)
				{
					if(matriz[i][j] == 6)
						System.out.println(i + " " + j);
					solucion[(int) matriz[i][j]] = (int) Math.min(solucion[(int) matriz[i][j]], i + j);
				}
			}
	}	
}
