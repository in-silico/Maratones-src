import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class moo
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
	
	static long[] tams = new long[29];
	
	static char solve(int n, int tam)
	{
		if(tam == 0)
			return n == 1 ? 'm' : 'o';
		if(n <= tams[tam - 1])
			return solve(n, tam - 1);
		else if(n <= tams[tam - 1] + (tam + 3))
			return n - tams[tam - 1] == 1 ? 'm' : 'o';
		else
			return solve((int) (n - (tams[tam - 1] + (tam + 3))), tam - 1);
			
	}
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("moo.out"));
		System.setIn(new FileInputStream("moo.in"));
		tams[0] = 3;
		for(int i = 1; i < tams.length; i++)
			tams[i] = (tams[i - 1] << 1) + (i + 3);
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int tamBuscado = 0;
		for(int j = 0; j < tams.length; j++)
		{
			if(n <= tams[j] && n > (j == 0 ? 0 : tams[j - 1]))
			{
				tamBuscado = j;
				break;
			}
		}
		System.out.println(solve(n, tamBuscado));
	}

}
