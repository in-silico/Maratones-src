import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Zbrka 
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
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static long[][] dp = new long[1001][10001];
	
	static long dp(int n, int c)
	{
		if(c < 0 || n <= 0)
			return 0L;
		if(n == 1 && c == 0)
			return 1L;
		else if(n == 1)
			return 0L;
		long res = 0;
		if(c > 0)
			res += dp[n][c - 1];
		if(n > 0)
			res += dp[n - 1][c];
		res %= 1000000007;
		if(n > 0 && c >= n)
			res -= dp[n - 1][c - n];
		res += 1000000007;
		res %= 1000000007;
		return res;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int c = sc.nextInt();
		for(int i = 0; i <= n; i++)
			for(int j = 0; j <= c; j++)
				dp[i][j] = dp(i, j);
		System.out.println(dp(n, c));
	}

}
