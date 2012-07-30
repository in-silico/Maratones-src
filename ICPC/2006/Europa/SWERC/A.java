import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A 
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
	
	static int[] dp = new int[400001];
	
	static int[] candidatos;
	static int nCandidatos;
	
	public static int dp(int n)
	{
		if(dp[n] != -1)
			return dp[n];
		int menor = Integer.MAX_VALUE;
		for(int i = nCandidatos - 1; i >= 0; i--)
			if(candidatos[i] > n)
				continue;
			else
				menor = Math.min(menor, dp(n - candidatos[i]) + 1);
		return dp[n] = menor;
	}
	
	public static int sumatoria(int a)
	{
		int c = a * a;
		return (2 * c * a + 3 * c + a) / 6;
	}
	
	public static void main(String[] args)
	{
		dp[0] = 0;
		for(int i = 1; i < 400001; i++)
			dp[i] = -1;
		candidatos = new int[400];
		nCandidatos = 0;
		for(int i = 1; i <= 150; i++)
		{
			candidatos[nCandidatos++] = i * i * i;
			candidatos[nCandidatos++] = sumatoria(i);
		}
		Arrays.sort(candidatos, 0, nCandidatos);
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == -1)
				return;
			System.out.println(dp(n));
		}
	}
}