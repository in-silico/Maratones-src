import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
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
	
	static int m;
	static ArrayList <Integer> personas = new ArrayList <Integer> (); 
	static Integer[][] dp = new Integer[2048][2048];
	
	public static int dp(int mascara, int respuestas)
	{
		if(dp[mascara][respuestas] != null)
			return dp[mascara][respuestas];
		int cuenta = 0;
		for(int a : personas)
		{
			if((a & mascara) == respuestas)
				cuenta++;
		}
		if(cuenta <= 1)
			return dp[mascara][respuestas] = 0;
		int mejor = Integer.MAX_VALUE;
		int mascaraA = mascara;
		for(int i = 0; i < m; i++)
		{
			if((mascaraA & 1) == 0)
				mejor = Math.min(mejor, Math.max(1 + dp((mascara | (1 << i)), (respuestas | (1 << i))), 1 + dp((mascara | (1 << i)), respuestas)));
			mascaraA >>>= 1;
		}
		return dp[mascara][respuestas] = mejor;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			m = sc.nextInt();
			int n = sc.nextInt();
			if(m == 0 && n == 0)
				return;
			personas.clear();
			
			for(int i = 0; i < n; i++)
			{
				int acum = 0;
				int j = 0;
				for(char c : sc.next().toCharArray())
				{
					if(c == '1')
						acum |= 1 << j;
					j++;
				}
				personas.add(acum);
			}
			int limite = (1 << m);
			for(int i = 0; i < limite; i++)
				for(int j = 0; j < limite; j++)
					dp[i][j] = null;
			System.out.println(dp(0, 0));
		}
	}
}
