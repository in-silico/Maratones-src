import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class landscape 
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
	
	static Long[][][] dp = new Long[101][11][2010];
	static int n, x, y, z;
	
	static int[] as = new int[101];
	static int[] bs = new int[101];
	
	static long dp(int e, int numeroX, int disponibles)
	{
		if(dp[e][numeroX][disponibles + 1001] != null)
			return dp[e][numeroX][disponibles + 1001];
		if(e == n)
			return dp[e][numeroX][disponibles + 1001] = (long) (Math.abs(disponibles) * (disponibles < 0 ? x : y));
		if(numeroX == bs[e])
			return dp[e][numeroX][disponibles + 1001] = z * Math.abs(disponibles) + dp(e + 1, as[e + 1], disponibles);
		else if(numeroX < bs[e])
		{
			long mejor = x + dp(e, numeroX + 1, disponibles);
			mejor = Math.min(mejor, dp(e, numeroX + 1, disponibles - 1));
			return dp[e][numeroX][disponibles + 1001] = mejor;
		}
		else
		{
			long mejor = y + dp(e, numeroX - 1, disponibles);
			mejor = Math.min(mejor, dp(e, numeroX - 1, disponibles + 1));
			return dp[e][numeroX][disponibles + 1001] = mejor;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("landscape.out"));
		System.setIn(new FileInputStream("landscape.in"));
		Scanner sc = new Scanner();
		n = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			as[i] = sc.nextInt();
			bs[i] = sc.nextInt();
		}
		System.out.println(dp(0, as[0], 0));
	}
}