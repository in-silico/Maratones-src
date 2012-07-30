import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class G 
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
	
	static char[][] dp = new char[1001][10001];
	static char[] ac, bc;
	static int[] valores = new int[10001];
	static final char NC = Character.MAX_VALUE - 1;
	static int n, m;
	
	public static int dp(int a, int b)
	{
		if(dp[a][b] != NC)
			return dp[a][b];
		if(ac[a] == '*')
		{
			int mejor = Character.MAX_VALUE;
			int r = dp[a][b + 1] + valores[b];
			if(r < mejor)
				mejor = r;
			r = dp[a + 1][b];
			if(r < mejor)
				mejor = r;
			return dp[a][b] = (char) mejor;
		}
		else if(ac[a] == '?')
		{
			int mejor = Character.MAX_VALUE;
			int r = dp[a + 1][b + 1] + valores[b];
			if(r < mejor)
				mejor = r;
			return dp[a][b] = (char) mejor;
		}
		else
		{
			if(ac[a] != bc[b])
				return dp[a][b] = Character.MAX_VALUE;
			int mejor = Character.MAX_VALUE;
			int r = dp[a + 1][b + 1] + valores[b];
			if(r < mejor)
				mejor = r;
			return dp[a][b] = (char) mejor;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			ac = sc.next().toCharArray();
			n = ac.length;
			bc = sc.next().toCharArray();
			m = bc.length;
			for(int i = 0; i <= n; i++)
				for(int j = 0; j <= m; j++)
					dp[i][j] = NC;
			for(int i = 0; i < m; i++)
				valores[i] = bc[i] - 'a' + 1;
			int mejor = Character.MAX_VALUE;
			for(int i = 0; i < m; i++)
				dp[n][i] = 0;
			for(int i = 0; i < n; i++)
				dp[i][m] = i == n - 1 && ac[i] == '*' ? 0 : Character.MAX_VALUE;
			dp[n][m] = 0;
			for(int i = n - 1; i >= 0; i--)
				for(int j = m - 1; j >= 0; j--)
					dp(i, j);
			if(ac[0] != '*' && ac[0] != '?')
			{
				for(int i = m - 1; i >= 0; i--)
					if(ac[0] == bc[i])
						mejor = Math.min(mejor, dp(0, i));
			}
			else
				for(int i = m - 1; i >= 0; i--)
					mejor = Math.min(mejor, dp(0, i));
			if(mejor == Character.MAX_VALUE)
				mejor = -1;
			System.out.println(mejor);
		}
	}
}