import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class C 
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
	

	static int[][] paquetes = new int[100005][3];
	static int[][] dp = new int[100005][105];
	static int n, c;
	
	public static int dp(int p, int w)
	{
		if(dp[p][w] != -1)
			return dp[p][w];
		if(p == n)
			return dp[p][w] = paquetes[n - 1][0] + paquetes[n - 1][1];
		if(p == 0)
			return dp[p][w] = paquetes[0][0] + paquetes[0][1] + dp(1, paquetes[0][2]);
		int diffS = Math.abs(paquetes[p - 1][0] - paquetes[p][0]) + Math.abs(paquetes[p - 1][1] - paquetes[p][1]);
		int mejor = 2000000000;
		if(w + paquetes[p][2] <= c)
			mejor = diffS + dp(p + 1, w + paquetes[p][2]);
		mejor = Math.min(mejor, paquetes[p - 1][0] + paquetes[p - 1][1] + paquetes[p][0] + paquetes[p][1] + dp(p + 1, paquetes[p][2]));
		return dp[p][w] = mejor;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int nt = sc.nextInt();
		for(long caso = 0; caso < nt; caso++)
		{
			if(caso != 0)
				System.out.println();
			c = sc.nextInt();
			n = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				paquetes[i][0] = sc.nextInt();
				paquetes[i][1] = sc.nextInt();
				paquetes[i][2] = sc.nextInt();
			}
			for(int i = 0; i <= n; i++)
				for(int j = 0; j <= c; j++)
					dp[i][j] = -1;
			for(int i = n; i >= 0; i--)
				for(int j = c; j >= 0; j--)
					dp(i, j);
			System.out.println(dp(0, 0));
		}
	}
}
