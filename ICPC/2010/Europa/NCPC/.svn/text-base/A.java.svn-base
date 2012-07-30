import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	public static class Persona
	{
		Persona padreA;
		Persona padreB;
		Double nivel;
		boolean fundador;
		
		public double dp()
		{
			if(padreA == null)
				return fundador ? 1 : 0;
			if(nivel != null)
				return nivel;
			else
				return nivel = padreA.dp() / 2 + padreB.dp() / 2;
		}
	}
	
	static HashMap <String, Persona> hash = new HashMap <String, Persona> ();
	
	static Persona darPersona(String s)
	{
		
		if(hash.containsKey(s))
			return hash.get(s);
		hash.put(s, new Persona());
		return hash.get(s);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		darPersona(sc.next()).fundador = true;
		for(int i = 0; i < n; i++)
		{
			Persona hijo = darPersona(sc.next());
			Persona padreA = darPersona(sc.next());
			Persona padreB = darPersona(sc.next());
			hijo.padreA = padreA;
			hijo.padreB = padreB;
		}
		double mejor = Double.MIN_VALUE;
		String mejorP = null;
		for(int i = 0; i < m; i++)
		{
			String s = sc.next();
			Persona p = darPersona(s);
			double dp = p.dp();
			if(dp > mejor)
			{
				mejor = dp;
				mejorP = s;
			}
		}
		System.out.println(mejorP);
		
	}
}
