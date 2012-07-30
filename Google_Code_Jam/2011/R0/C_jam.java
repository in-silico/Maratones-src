import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class C_jam 
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
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("c.in"));
		System.setOut(new PrintStream("c.out"));
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int j = 0; j < t; j++)
		{
			int acum = 0;
			int n = sc.nextInt();
			int suma = 0;
			int menor = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++)
			{
				int nuevo = sc.nextInt();
				suma += nuevo;
				menor = Math.min(menor, nuevo);
				acum ^= nuevo;
			}
			if(acum == 0)
				System.out.println("Case #" + (j + 1) + ": " + (suma - menor));
			else
				System.out.println("Case #" + (j + 1) + ": NO");
		}
	}
}
