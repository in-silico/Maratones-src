import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class H
{
	
	static double[] dp = new double[1000000];
	static double[] dpB = new double[1000000];
	
	static double factorial(int n)
	{
		if(dp[n] != Double.MAX_VALUE)
			return dp[n];
		return dp[n] = n * factorial(n - 1);
	}
	
	static double combination(int n, int r)
	{
		return factorial(n) / (factorial(r) * factorial(n - r));
	}
	
	static double bell(int n)
	{
		if(dpB[n] != Double.MAX_VALUE)
			return dpB[n];
		double acum = 0;
		for(int i = 0; i <= n - 1; i++)
		{
			acum += combination(n - 1, i) * bell(i);
		}
		return dpB[n] = acum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		for(int i = 0; i < 1000000; i++)
		{
			dp[i] = Double.MAX_VALUE;
			dpB[i] = Double.MAX_VALUE;
		}
		dp[0] = 1;
		dpB[0] = 1;
		dpB[1] = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			System.out.println(n + " " + (DecimalFormat.getNumberInstance().format(bell(n)) + "").replace(",", ""));
		}
	}

}
