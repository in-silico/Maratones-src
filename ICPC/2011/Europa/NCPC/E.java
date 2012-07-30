import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class E 
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
	
	static String regex;
	static String match;
	
	static Boolean[][] dp = new Boolean[101][101];
	
	public static boolean dp(int i, int j)
	{
		if(j >= regex.length() - 1 && i == match.length())
			return dp[i][j] = true;
		if(j == regex.length())
			return false;
		if(i == match.length())
			return false;
		if(dp[i][j] != null)
			return dp[i][j];
		if(regex.charAt(j) == '*')
		{
			boolean posible = false;
			posible = dp(i, j + 1);
			if(j != match.length())
				posible |= dp(i + 1, j);
			return dp[i][j] = posible;
		}
		else
		{
			if(regex.charAt(j) == match.charAt(i))
				return dp[i][j] = dp(i + 1, j + 1);
			else
				return false;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			regex = sc.next();
			int n = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				match = sc.next();
				for(int k = 0; k < match.length(); k++)
					for(int j = 0; j < regex.length(); j++)
						dp[k][j] = null;
				if(dp(0, 0))
					System.out.println(match);
			}
		}

	}

}
