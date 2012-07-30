import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Cvjetici 
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
	
	static int n = 100100;
	static int[] fenwick = new int[n];
	
	static int query(int a, int b)
	{
		if(a == 0)
		{
			int sum = 0;
			for(; b >= 0; b = (b & (b + 1)) - 1)
				sum += fenwick[b];
			return sum;
		}
		else
			return query(0, b) - query(0, a - 1);
	}
	
	static void increase(int k, int increment)
	{
		for(; k < n + 1; k |= k + 1)
			fenwick[k] += increment;
	}
	
	static void increase(int i, int j, int increment)
	{
		increase(i, increment);
		increase(j + 1, -increment);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			int l = sc.nextInt();
			int r = sc.nextInt();
			int a1 = query(0, l);
			int a2 = query(0, r);
			System.out.println(a1 + a2);
			increase(l, l, -a1);
			increase(r, r, -a2);
			if(r - l > 1)
				increase(l + 1, r - 1, 1);
		}
	}
}