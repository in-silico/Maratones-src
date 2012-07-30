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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	public static int busquedaBinaria(int a, int b, int n)
	{
		int low = 0;
		int high = n;
		while(low != high)
		{
			int mid = (low + high) / 2;
			int fMid = (a + b) * mid - b * n;
			int fMidUno = (a + b) * (mid - 1) - b * n;
			if(fMid <= 0)
				low = mid + 1;
			else if(fMidUno <= 0)
				return fMid;
			else
				high = mid;
		}
		return (a + b) * high - b * n;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < m; i++)
				min = Math.min(min, busquedaBinaria(sc.nextInt(), sc.nextInt(), n));
			System.out.println(min);
		}
	}

}
