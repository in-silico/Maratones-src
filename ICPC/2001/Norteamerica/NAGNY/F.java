import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class F 
{
	
	static int maximo;
	static int total;
	
	static int[][][] dp = new int[101][101][11];
	
	public static int buscar(int minimo, int maximo, int quedan)
	{
		if(dp[minimo][maximo][quedan] != -1)
			return dp[minimo][maximo][quedan];
		if(quedan == 1)
		{
			return dp[minimo][maximo][quedan] = (maximo * (maximo + 1)) / 2 - ((minimo - 1) * minimo) / 2;
		}
		int mejor = Integer.MAX_VALUE;
		if(minimo == maximo)
			return dp[minimo][maximo][quedan] = minimo;
		for(int i = minimo; i < maximo; i++)
		{
			int a = i + buscar(i + 1, maximo, quedan);
			int b = i + buscar(minimo, i - 1, quedan - 1);
			mejor = Math.min(mejor, Math.max(a, b));
		}
		return dp[minimo][maximo][quedan] = mejor;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String[] pedazos = br.readLine().split(" ");
			for(int ii = 0; ii < 101; ii++)
			{
				for(int j = 0; j < 101; j++)
				{
					for(int k = 0; k < 11; k++)
					{
						dp[ii][j][k] = -1;
					}
				}
			}
			System.out.println(buscar(1, Integer.parseInt(pedazos[1]), Integer.parseInt(pedazos[0])));
		}
	}

}
