import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class emoticons 
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
	
	static int n, m;
	static int[][] menor = new int[100][80];
	static char[][] emoticons = new char[100][];
	static char[][] lineas = new char[100][];
	static int[] tamLineas = new int[100];
	static Integer[][][] dp = new Integer[100][80][16];
	
	static int dp(int mActual, int jActual, int acum)
	{
		if(mActual == m)
			return 0;
		if(jActual == tamLineas[mActual])
			return dp(mActual + 1, 0, acum);
		if(dp[mActual][jActual][acum] != null)
			return dp[mActual][jActual][acum];
		int posibleA = 1 + dp(mActual, jActual + 1, 0);
		if(menor[mActual][jActual] > acum + 1)
			posibleA = Math.min(posibleA, dp(mActual, jActual + 1, acum + 1 > 15 ? 15 : acum + 1));
		return dp[mActual][jActual][acum] = posibleA;
	}
	public static void llenarMenor()
	{
		for(int i = 0; i < m; i++)
		{
			final char[] actual = lineas[i];
			final int tam = tamLineas[i];
			for(int j = 0; j < tam; j++)
			{
				menor[i][j] = Integer.MAX_VALUE;
				for(int k = 0; k < n; k++)
				{
					final char[] emo = emoticons[k];
					final int tam2 = emo.length;
					if(j - tam2 + 1 < 0)
						continue;
					boolean paila = false;
					int indiceInterno = j - tam2 + 1;
					for(int l = 0; l < tam2; l++)
					{
						if(actual[indiceInterno++] != emo[l])
						{
							paila = true;
							break;
						}
					}
					if(!paila)
					{
						menor[i][j] = tam2;
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < n; i++)
				emoticons[i] = sc.nextLine().toCharArray();
			for(int i = 0; i < m; i++)
			{
				lineas[i] = sc.nextLine().toCharArray();
				tamLineas[i] = lineas[i].length;
			}
			Arrays.sort(emoticons, 0, n, new Comparador());
			llenarMenor();
			for(int i = 0; i < m; i++)
				for(int j = 0; j < tamLineas[i]; j++)
					for(int k = 0; k <= 15; k++)
						dp[i][j][k] = null;
			System.out.println(dp(0, 0, 0));
		}
	}
	
	static class Comparador implements Comparator<char[]> 
	{

		@Override
		public int compare(char[] o1, char[] o2) 
		{
			return o1.length - o2.length;
		}

	}
}
