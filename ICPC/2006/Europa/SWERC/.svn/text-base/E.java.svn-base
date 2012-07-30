import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class E 
{
	static class Scanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));

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
	
	private static int dp(int i, int j) 
	{
		if(i == a.length)
			return j == b.length ? 0 : Integer.MIN_VALUE;
		if(j == b.length)
			return (a.length - i) * -TOP;
		if(dp[i][j] != null)
			return dp[i][j];
		int mejor = Integer.MIN_VALUE;
		if(a[i] == b[j])
		{
			int res = dp(i + 1, j + 1);
			if(res != Integer.MIN_VALUE)
				mejor = Math.max(mejor, TOP + res);
		}
		else
		{
			int res = dp(i + 1, j + 1);
			if(distancias[a[i]][b[j]] != Integer.MAX_VALUE && res != Integer.MIN_VALUE)
				mejor = Math.max(mejor, TOP - distancias[a[i]][b[j]] + res);
		}
		if(a.length - (i + 1) >= b.length - j)
		{
			int res = dp(i + 1, j);
			if(res != Integer.MIN_VALUE)
				mejor = Math.max(mejor, -TOP + res);
		}
		return dp[i][j] = mejor;
	}
	
	static char[][] teclado;
	static int[][] distancias = new int[257][257];
	static Integer[][] dp = new Integer[1000][1000];
	static int TOP;
	static char[] a;
	static char[] b;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String siguiente = br.readLine();
		while(true)
		{
				int n = Integer.parseInt(siguiente);
				teclado = new char[n][];
				for(int i = 0; i < n; i++)
					teclado[i] = br.readLine().toCharArray();
				for(int i = 0; i < 257; i++)
					for(int j = 0; j < 257; j++)
						distancias[i][j] = Integer.MAX_VALUE;
				for(int i = 0; i < n; i++)
					for(int j = 0; j < teclado[0].length; j++)
					{
						int a = teclado[i][j];
						for(int k = 0; k < n; k++)
							for(int l = 0; l < teclado[0].length; l++)
							{
								int b = teclado[k][l];
								distancias[a][b] = Math.max(Math.abs(i - k), Math.abs(j - l));
							}
					}
			TOP = Math.max(n, teclado[0].length);
			a = br.readLine().toCharArray();
			b = br.readLine().toCharArray();
			for(int i = 0; i <= a.length; i++)
				for(int j = 0; j <= b.length; j++)
					dp[i][j] = null;
			System.out.println(dp(0, 0));
			siguiente = br.readLine();
			if(siguiente == null)
				return;
		}
	}
}