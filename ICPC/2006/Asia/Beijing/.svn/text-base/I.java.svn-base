import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class I
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
	
	static Integer[] grundy = new Integer[24];
	
	private static int grundy(int n)
	{
		if(grundy[n] != null)
			return grundy[n];
		if(n == 0)
			return grundy[0] = 0;
		boolean[] cuales = new boolean[1000];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				cuales[grundy(i) ^ grundy(j)] = true;
		for(int i = 0; i < 1000; i++)
			if(!cuales[i])
				return grundy[n] = i;
		return -1;
	}
	
	private static boolean solucion() 
	{
		int xor = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < piedras[i]; j++)
				xor ^= grundy(n - i - 1);
		return xor == 0;
	}
	
	static int[] piedras = new int[23];
	static int n;
	
	public static String resolver()
	{
		for(int i = 0; i < n; i++)
			for(int j = i + 1; j < n; j++)
				for(int k = j; k < n; k++)
				{
					if(piedras[i] != 0)
					{
						piedras[i]--;
						piedras[j]++;
						piedras[k]++;
						if(solucion())
							return i + " " + j + " " + k;
						piedras[j]--;
						piedras[k]--;
						piedras[i]++;
					}
				}
		return "-1 -1 -1";
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int caso = 1;
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				piedras[i] = sc.nextInt();
			System.out.println("Game " + caso++ + ": " + resolver());
		}
	}
}