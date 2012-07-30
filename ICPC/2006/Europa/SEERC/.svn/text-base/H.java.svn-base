import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class H 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
	}
	
	public static boolean[][] carreteras = new boolean[1001][1001];
	public static long[][] dp = new long[1001][1001];
	public static long[][] dp1 = new long[1001][1001];
	
	static int n, m;
	
	public static long dp(int i, int j)
	{
		if(i == 0 || j == 0 || i > n || j > m)
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
		return dp[i][j] = (carreteras[i][j] ? 1 : 0) + dp1(i, j + 1) + dp(i - 1, j);
	}
	
	public static long dp1(int i, int j)
	{
		if(i == 0 || j == 0 || i > n || j > m)
			return 0;
		if(dp1[i][j] != -1)
			return dp1[i][j];
		return dp1[i][j] = (carreteras[i][j] ? 1 : 0) + dp1(i, j + 1);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 1; caso <= t; caso++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			int k = sc.nextInt();
			for(int i = 0; i <= n; i++)
				for(int j = 0; j <= m; j++)
				{
					dp[i][j] = -1; 
					dp1[i][j] = -1;
					carreteras[i][j] = false;
				}
			for(int i = 0; i < k; i++)
				carreteras[sc.nextInt()][sc.nextInt()] = true;
			long total = 0;
			for(int i = 0; i <= n; i++)
				for(int j = 0; j <= m; j++)
					if(carreteras[i][j])
						total += dp(i - 1, j + 1);
			System.out.println("Test case " + caso + ": " + total);
		}
	}
}
