import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class G 
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
	
	private static int cuenta(int i) 
	{
		int total = 0;
		for(int j = 0; j < n; j++)
		{
			if((i & 1) == 1)
				total += tamanos[j];
			i >>= 1;
		}
		return total;
	}
	
	private static boolean dp(int mascara)
	{
		if(dp[mascara] != 0)
			return dp[mascara] == 1;
		int actual = cuentas[mascara] + offset;
		int m = mascara;
		for(int i = 0; i < n; i++)
		{
			if((m & 1) == 0 && esta[i][actual] && dp(mascara | (1 << i)))
			{
				dp[mascara] = 1;
				return true;
			}
			m >>= 1;
		}
		dp[mascara] = 2;
		return false;
	}

	static String[] lineas = new String[12];
	static boolean[][] esta = new boolean[12][5000];
	static StringBuilder sb = new StringBuilder(5001);
	static String texto;
	static int n;
	static String[] subStrings = new String[5000];
	static int[] tamanos = new int[12];
	static int[] dp = new int[1 << 12];
	static int[] cuentas = new int[1 << 12];
	static int offset;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < n; i++)
				lineas[i] = sc.next();
			Arrays.sort(lineas, 0, n);
			int total = 0;
			for(int i = 0; i < n; i++)
			{
				tamanos[i] = lineas[i].length();
				total += tamanos[i];
			}
			sb.setLength(0);
			for(int i = 0; i < m; i++)
				sb.append(sc.next());
			texto = sb.toString();
			int tam = texto.length();
			subStrings[0] = texto;
			for(int i = 1; i < tam; i++)
				subStrings[i] = texto.substring(i);
			for(int i = 0; i < n; i++)
				for(int j = 0; j < tam; j++)
					esta[i][j] = subStrings[j].startsWith(lineas[i]);
			int maximo = 1 << n;
			for(int i = 0; i < maximo; i++)
				cuentas[i] = cuenta(i);
			int cuenta = 0;
			tam -= total;
			tam++;
			for(int i = 0; i < tam; i++)
			{
				for(int j = 0; j < maximo; j++)
					dp[j] = 0;
				dp[maximo - 1] = 1;
				offset = i;
				if(dp(0))
					cuenta++;
			}
			System.out.println(cuenta);
		}
	}
}
