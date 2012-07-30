import java.util.Scanner;


public class Bond 
{
	static double[][] probabilidades = new double[20][20];
	static Double[][] dp = new Double[20][1 << 20];
	static int n;
	
	static double dp(int actual, int mascara)
	{
		if(actual == n)
			return 1;
		if(dp[actual][mascara] != null)
			return dp[actual][mascara];
		double mejorProb = -1;
		for(int i = 0; i < n; i++)
			if(((mascara >> i) & 1) == 0)
			{
				double posible = probabilidades[actual][i];
				posible *= dp(actual + 1, mascara | 1 << i);
				if(posible > mejorProb)
					mejorProb = posible;
			}
		return dp[actual][mascara] = mejorProb;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				probabilidades[i][j] = sc.nextDouble() / 100.0;
		double mejor = dp(0, 0);
		System.out.printf("%.8f", mejor * 100);
		System.out.println();
	}
}
