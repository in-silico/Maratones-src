import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Magija 
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
		int n = sc.nextInt();
		sc.next();
		String[] salida = new String[2 * n];
		for(int i = 0; i < n; i++)
		{
			String s = sc.next();
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			s += sb.toString();
			salida[i] = s;
		}
		for(int i = 0; i < n; i++)
			salida[i + n] = salida[n - 1 - i];
		int a = sc.nextInt();
		int b = sc.nextInt();
		String cual = salida[a - 1].charAt(b - 1) + "";
		if(cual.equals("."))
			cual = "#";
		else
			cual = ".";
		salida[a - 1] = salida[a - 1].substring(0, b - 1) + cual + salida[a - 1].substring(b, salida[a - 1].length());
		for(int i = 0; i < 2 * n; i++)
			System.out.println(salida[i]);
	}

}
