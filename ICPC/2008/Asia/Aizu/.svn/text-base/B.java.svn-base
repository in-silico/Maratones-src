import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class B 
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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static double[][] dp = new double[27][10001];
	static int m;
	
	public static double dp(int n, int suma)
	{
		if(suma < 0)
			return 0;
		if(n == 0)
			return suma == 0 ? 1 : 0;
		if(dp[n][suma] != Double.POSITIVE_INFINITY)
			return dp[n][suma];
		double total = 0;
		for(int i = 1; i <= m; i++)
			total += dp(n - 1, suma - i);
		total /= m;
		return dp[n][suma] = total;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			m = sc.nextInt();
			int k = sc.nextInt();
			if(n == 0 && m == 0 && k == 0)
				return;
			int total = n * m;
			for(int i = 1; i <= n; i++)
				for(int j = 0; j <= total; j++)
					dp[i][j] = Double.POSITIVE_INFINITY;
			double acumulado = 0;
			for(int i = 0; i <= total; i++)
				acumulado += dp(n, i) * (i - k < 1 ? 1 : i - k);
			System.out.println(acumulado);
		}
	}
}
