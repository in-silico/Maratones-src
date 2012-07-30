import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G 
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[12][1000];
		while(true)
		{
			int meses = Integer.parseInt(br.readLine());
			if(meses == 0)
				return;
			String[] pedazos = br.readLine().split(" ");
			int contratar = Integer.parseInt(pedazos[0]);
			int salario = Integer.parseInt(pedazos[1]);
			int echar = Integer.parseInt(pedazos[2]);
			int[] trabajadores = new int[meses];
			int a = 0;
			int mayor = 0;
			for(String s : br.readLine().split(" "))
			{
				trabajadores[a] = Integer.parseInt(s);
				mayor = Math.max(mayor, trabajadores[a++]);
			}
			for(int i = 0; i < meses; i++)
			{
				for(int j = 0; j <= mayor; j++)
				{
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			for(int j = trabajadores[0]; j <= mayor; j++)
			{
				dp[0][j] = contratar * j + salario * j;
			}
			for(int i = 1; i < meses; i++)
			{
				for(int j = trabajadores[i]; j <= mayor; j++)
				{
					int mejor = Integer.MAX_VALUE;
					for(int k = 0; k <= j; k++)
					{
						if(dp[i - 1][k] == Integer.MAX_VALUE)
							continue;
						int posible = dp[i - 1][k] + contratar * (j - k) + salario * j;
						mejor = Math.min(mejor, posible);
					}
					for(int k = j + 1; k <= mayor; k++)
					{
						if(dp[i - 1][k] == Integer.MAX_VALUE)
							continue;
						int posible = dp[i - 1][k] + echar * (k - j) + salario * j;
						mejor = Math.min(mejor, posible);
					}
					dp[i][j] = mejor;
				}
			}
			int mejor = Integer.MAX_VALUE;
			for(int i = 0; i <= mayor; i++)
				mejor = Math.min(mejor, dp[meses - 1][i]);
			System.out.println(mejor);
		}
	}

}
