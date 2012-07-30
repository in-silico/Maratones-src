import java.util.Scanner;


public class E
{
	static boolean[][] matriz = new boolean[10][10];
	static int total;
	static int mejor;
	
	public static void visitar(int i, int j, int cuenta)
	{
		if(!matriz[i][j])
			return;
		mejor = Math.max(mejor, cuenta);
		matriz[i][j] = false;
		if(i - 2 > -1 && j - 1 > -1 && matriz[i - 2][j - 1])
			visitar(i - 2, j - 1, cuenta + 1);
		if(i - 2 > -1 && j + 1 < 10 && matriz[i - 2][j + 1])
			visitar(i - 2, j + 1, cuenta + 1);
		if(i + 2 < 10 && j - 1 > -1 && matriz[i + 2][j - 1])
			visitar(i + 2, j - 1, cuenta + 1);
		if(i + 2 < 10 && j + 1 < 10 && matriz[i + 2][j + 1])
			visitar(i + 2, j + 1, cuenta + 1);
		if(i - 1 > -1 && j - 2 > -1 && matriz[i - 1][j - 2])
			visitar(i - 1, j - 2, cuenta + 1);
		if(i - 1 > -1 && j + 2 < 10 && matriz[i - 1][j + 2])
			visitar(i - 1, j + 2, cuenta + 1);
		if(i + 1 < 10 && j - 2 > -1 && matriz[i + 1][j - 2])
			visitar(i + 1, j - 2, cuenta + 1);
		if(i + 1 < 10 && j + 2 < 10 && matriz[i + 1][j + 2])
			visitar(i + 1, j + 2, cuenta + 1);
		matriz[i][j] = true;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caso = 1;
		while(true)
		{
			for(int i = 0; i < 10; i++)
				for(int j = 0; j < 10; j++)
					matriz[i][j] = false;
			int n = sc.nextInt();
			if(n == 0)
				return;
			int inicial = 0;
			total = 0;
			mejor = 0;
			for(int i = 0; i < n; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				total += b;
				b += a;
				if(i == 0)
					inicial = a;
				for(int j = a; j < b; j++)
					matriz[i][j] = true;
			}
			visitar(0, inicial, 1);
			if(total - mejor == 1)
				System.out.println("Case " + caso++ + ", " + (total - mejor) + " square can not be reached.");
			else
				System.out.println("Case " + caso++ + ", " + (total - mejor) + " squares can not be reached.");
		}
	}

}
