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
	
	static double[][] floyd = new double[100][100];
	static double[][] floyd2 = new double[100][100];
	
	static int n;
	
	static void floyd(double[][] m)
	{
		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					m[i][j] = Math.min(m[i][j], m[i][k] + m[k][j]);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					floyd[i][j] = floyd2[i][j] = i == j ? 0 : Double.POSITIVE_INFINITY;
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int este = Integer.parseInt(st.nextToken()) - 1;
				while(st.hasMoreTokens())
				{
					int otro = Integer.parseInt(st.nextToken()) - 1;
					floyd[este][otro] = 1; 
				}	
			}
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int este = Integer.parseInt(st.nextToken()) - 1;
				while(st.hasMoreTokens())
				{
					int otro = Integer.parseInt(st.nextToken()) - 1;
					floyd2[este][otro] = 1; 
				}	
			}
			floyd(floyd);
			floyd(floyd2);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean paila = false;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
				{
					if(A * floyd[i][j] + B < floyd2[i][j])
						paila = true;
				}
			System.out.println(paila ? "No" : "Yes");
		}
	}

}
