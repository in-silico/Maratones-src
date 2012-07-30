import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class D
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static ArrayList <Integer> numeros = new ArrayList <Integer> ();
	
	static int[][] dp = new int[120][120];
	
	static double r;
	

	private static int dp(int i, int j) 
	{
		if(dp[i][j] != -1)
			return dp[i][j];
		double rp = numeros.get(j);
		rp /= numeros.get(i);
		if(rp <= r)
			return dp[i][j] = 1;
		int menor = Integer.MAX_VALUE;
		for(int ii = i; ii < j; ii++)
			menor = Math.min(menor, dp(i, ii) + dp(ii + 1, j));
		return dp[i][j] = menor;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int k = sc.nextInt();
			r = sc.nextDouble();
			if(k == 0 && r == 0)
				return;
			numeros.clear();
			for(int i = 0; i < k; i++)
				for(int j = 0; j < k; j++)
					dp[i][j] = -1;
			for(int i = 0; i < k; i++)
			{
				numeros.add(sc.nextInt());
				sc.nextInt();
			}
			Collections.sort(numeros);
			System.out.println(dp(0, k - 1));
		}
	}
}