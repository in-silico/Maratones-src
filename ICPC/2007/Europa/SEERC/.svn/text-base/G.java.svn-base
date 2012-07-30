import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class G 
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
		
		public long nextLong()
		{
			return Long.parseLong(next());
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
	
	static long[][] m;
	static Long[][] dp;
	static long c;

	
	public static long dp(int a, int b)
	{
		if(dp[a][b] != null)
			return dp[a][b];
		long mejor = m[a][b];
		for(int i = a; i < b; i++)
		{
			mejor = Math.min(mejor, m[a][i] + c + dp(i + 1, b));
		}
		return dp[a][b] = mejor;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			try
			{
				c = sc.nextLong();
			}
			catch(Exception e)
			{
				return;
			}
			int n = sc.nextInt();
			m = new long[n + 1][n + 1];
			dp = new Long[n + 1][n + 1];
			for(int i = 1; i <= n; i++)
				for(int j = i; j <= n; j++)
					m[i][j] = sc.nextLong();
			System.out.println(dp(1, n) + c);
		}
	}
}