import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static Boolean[][] dp = new Boolean[1000][1000];
	static boolean[][] matriz = new boolean[1000][1000];
	static boolean[][] filas = new boolean[1000][1000];
	static boolean[][] columnas = new boolean[1000][1000];
	
	public static boolean dp(int f, int c)
	{
		if(f == -1 || c == -1)
			return false;
		if(dp[f][c] != null)
			return dp[f][c];
		boolean resultado = false;
		if(!filas[f][c])
			resultado = resultado || !dp(f - 1, c);
		if(!columnas[f][c])
			resultado = resultado || !dp(f, c - 1);
		return dp[f][c] = resultado;
	}
	

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
				{
					matriz[i][j] = (sc.nextInt() & 1) == 1;
					dp[i][j] = null;
				}
			for(int i = 0; i < n; i++)
			{
				boolean anterior = false;
				for(int j = 0; j < n; j++)
				{
					filas[i][j] = anterior ^ matriz[i][j];
					anterior = filas[i][j];
				}
			}
			for(int i = 0; i < n; i++)
			{
				boolean anterior = false;
				for(int j = 0; j < n; j++)
				{
					columnas[j][i] = anterior ^ matriz[j][i];
					anterior = columnas[j][i];
				}
			}
			System.out.println(dp(n - 1, n - 1) ? "W" : "L");
			if(sc.endLine())
				return;
		}
	}

}
