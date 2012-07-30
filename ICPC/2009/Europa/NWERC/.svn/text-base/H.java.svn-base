import java.util.Scanner;

public class H 
{
	static int[] tiles = new int[10001];
	static int[] cuantos = new int[6];
	static int actual;
	static int i;
	static boolean[] puede = new boolean[6];
	
	static void poner(int vecinos)
	{
		if(i > 10000)
			return;
		for(int j = 1; j < 6; j++)
			puede[j] = true;
		puede[tiles[i - 1]] = false;
		if(vecinos == 1)
			puede[tiles[actual]] = false;
		else if(vecinos == 2)
		{
			puede[tiles[actual]] = false;
			actual++;
			puede[tiles[actual]] = false;
		}
		int indiceMejor = 0;
		int numeroMejor = Integer.MAX_VALUE;
		for(int j = 1; j < 6; j++)
			if(puede[j])
				if(cuantos[j] < numeroMejor)
				{
					indiceMejor = j;
					numeroMejor = cuantos[j];
				}
		tiles[i] = indiceMejor;
		cuantos[indiceMejor]++;
		i++;
	}
	
	static void llenar()
	{
		tiles[0] = 1;
		cuantos[1] = 1;
		i = 1;
		actual = 0;
		int n = 0;
		while(i < 10001)
		{
			for(int j = 0; j < 5; j++)
			{
				poner(1);
				for(int k = 0; k < n; k++)
					poner(2);
			}
			poner(2);
			poner(1);
			for(int k = 0; k < n; k++)
				poner(2);
			n++;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		llenar();
		for(int j = 0; j < c; j++)
			System.out.println(tiles[sc.nextInt() - 1]);
	}
}