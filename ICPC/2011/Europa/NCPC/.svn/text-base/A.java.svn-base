import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
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
	
	static int n;
	static char[][] matriz = new char[1001][];
	static Integer [][] dp = new Integer[1001][1001];
	static boolean llego;
	
	public static int dp(int i, int j)
	{
		if(j == n || i == n || i == -1 || j == -1)
			return 0;
		if(dp[i][j] != null)
			return dp[i][j];
		if(matriz[i][j] == '#')
			return 0;
		if(i == n - 1 && j == n - 1)
		{
			llego = true;
			return dp[i][j] = 1;
		}
		long resA = dp(i + 1, j);
		resA += dp(i, j + 1);
		return dp[i][j] = (int) (resA % Integer.MAX_VALUE);
	}

	static class Entrada
	{
		int i;
		int j;
		
		public Entrada(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
	
	static int[][] diffs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			n = sc.nextInt();
			llego = false;
			for(int i = 0; i <= n; i++)
				for(int j = 0; j <= n; j++)
					dp[i][j] = null;
			for(int i = 0; i < n; i++)
				matriz[i] = sc.next().toCharArray();
			int val = dp(0, 0);
			if(!llego)
			{
				for(int i = 0; i <= n; i++)
					for(int j = 0; j <= n; j++)
						dp[i][j] = null;
				LinkedList <Entrada> lista = new LinkedList <Entrada> ();
				dp[0][0] = 1;
				lista.add(new Entrada(0, 0));
				boolean paila = true;
				while(!lista.isEmpty())
				{
					Entrada actual = lista.poll();
					if(actual.i == n - 1 && actual.j == n - 1)
					{
						paila = false;
						break;
					}
					for(int[] d : diffs)
					{
						int xNuevo = actual.i + d[0];
						int yNuevo = actual.j + d[1];
						if(xNuevo >= n || xNuevo < 0 || yNuevo >= n || yNuevo < 0 || dp[xNuevo][yNuevo] != null || matriz[xNuevo][yNuevo] == '#')
							continue;
						dp[xNuevo][yNuevo] = 1;
						lista.add(new Entrada(xNuevo, yNuevo));
					}
				}
				if(paila)
					System.out.println("INCONCEIVABLE");
				else
					System.out.println("THE GAME IS A LIE");
			}
			else
				System.out.println(val);
		}
	}

}
