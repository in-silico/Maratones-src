import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class A_jam 
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
		System.setIn(new FileInputStream("a.in"));
		System.setOut(new PrintStream("a.out"));
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 1; caso <= t; caso++)
		{
			int n = sc.nextInt();
			int posO = 1;
			int posB = 1;
			int tO = 0;
			int tB = 0;
			for(int i = 0; i < n; i++)
			{
				String r = sc.next();
				int boton = sc.nextInt();
				if(r.equals("O"))
				{
					tO += Math.abs(posO - boton);
					tO++;
					tO = Math.max(tO, tB + 1);
					posO = boton;
				}
				else
				{
					tB += Math.abs(posB - boton);
					tB++;
					tB = Math.max(tB, tO + 1);
					posB = boton;
				}
			}
			System.out.println("Case #" + caso + ": " + Math.max(tO, tB));
		}
	}

}
