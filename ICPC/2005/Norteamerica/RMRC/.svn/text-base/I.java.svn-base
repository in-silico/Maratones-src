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
	
	static int x, y;
	
	static double calcular(int a, int b, int restantes)
	{
		if(a == x && b == y)
			return 1;
		double resultado = 0;
		if(a < x)
			resultado += ((13.0 - a) / restantes) * calcular(a + 1, b, restantes - 1);
		if(b < y)
			resultado += ((13.0 - b) / restantes) * calcular(a, b + 1, restantes - 1);
		return resultado;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			x = sc.nextInt();
			y = sc.nextInt();
			if(x == -1 && y == -1)
				return;
			System.out.printf("%d-%d split: %.8f\n", x, y, x == y ? calcular(0, 0, 26) : calcular(0, 0, 26) * 2);
		}
	}
}
