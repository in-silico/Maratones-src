import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int[][] matriz = new int[1000][20];
		while(true)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					matriz[i][j] = sc.nextInt();
			BigInteger mejor = null;
			int indice = -1;
			for(int i = 0; i < m; i++)
			{
				BigInteger acum = BigInteger.ONE;
				for(int j = 0; j < n; j++)
					acum = acum.multiply(BigInteger.valueOf(matriz[j][i]));
				if(mejor == null || acum.compareTo(mejor) >= 0)
				{
					mejor = acum;
					indice = i;
				}
			}
			System.out.println(indice + 1);
			if(sc.endLine())
				return;
		}
	}

}
