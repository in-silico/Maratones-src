import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class F
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
	
	 private static long gcd(long m, long n) 
	 {
	        if (m < 0) m = -m;
	        if (n < 0) n = -n;
	        if (0 == n) return m;
	        else return gcd(n, m % n);
	 }
	 
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++)
		{
			long a = sc.nextInt();
			long arriba = a;
			arriba *= (arriba - 1);
			long abajo = 4;
			if(arriba % abajo != 0)
			{
				long gcd = gcd(arriba, abajo);
				System.out.println("Case " + i + ": " + arriba / gcd  + "/" + abajo / gcd);
				
			}
			else
				System.out.println("Case " + i + ": " + arriba / abajo);
		}
	}

}
