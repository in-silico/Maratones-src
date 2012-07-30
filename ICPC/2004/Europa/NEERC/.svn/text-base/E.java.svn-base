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
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		boolean empezo = false;
		while(!sc.endLine())
		{
			if(!empezo)
				empezo = true;
			else
				System.out.println();
			int m = sc.nextInt();
			int n = sc.nextInt();
			int k = sc.nextInt();
			double[] valores = new double[k];
			for(int i = 0; i < k; i++)
				valores[i] = sc.nextDouble();
			double[] integral = new double[k];
			integral[0] = valores[0];
			for(int i = 1; i < k; i++)
				integral[i] = integral[i - 1] + valores[i];
			boolean[] bullish = new boolean[k];
			for(int i = n - 1; i < k; i++)
			{
				double pn = integral[i] - (i == n - 1 ? 0 : integral[i - n]);
				double pm = integral[i] - integral[i - m];
				pn /= n;
				pm /= m;
				if(pm > pn && (i == n - 1 || (!bullish[i - 1])))
				{
					bullish[i] = true;
					System.out.println("BUY ON DAY " + (i + 1));
				}
				else if(pm < pn && (i == n - 1 || bullish[i - 1]))
				{
					bullish[i] = false;
					System.out.println("SELL ON DAY " + (i + 1));
				}
				else
					bullish[i] = bullish[i - 1];
			}
		}
	}
}
