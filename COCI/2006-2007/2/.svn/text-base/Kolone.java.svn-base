import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Kolone
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
	
	static class Ant
	{
		public Ant(char c, boolean b) 
		{
			a = c;
			direccion = b;
		}
		
		boolean direccion;
		char a;
	}
	
	static Ant[] resultado;
	static int t;
	
	public static void solucionar()
	{
		for(int i = 0; i < t; i++)
		{
			Ant[] actual = resultado;
			for(int j = resultado.length - 1; j >= 1; j--)
			{
				if(actual[j].direccion)
					continue;
				if(actual[j - 1].direccion)
				{
					Ant temp = actual[j];
					actual[j] = actual[j - 1];
					actual[j - 1] = temp;
					j--;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int a = sc.nextInt();
		int b = sc.nextInt();
		String aa = sc.next();
		String bb = sc.next();
		t = sc.nextInt();
		resultado = new Ant[a + b];
		StringBuilder sb = new StringBuilder(aa);
		sb.reverse();
		aa = sb.toString();
		int tam = 0;
		for(char c : aa.toCharArray())
			resultado[tam++] = new Ant(c, true);
		for(char c : bb.toCharArray())
			resultado[tam++] = new Ant(c, false);
		solucionar();
		for(Ant ant : resultado)
			System.out.print(ant.a);
		System.out.println();
	}
}
