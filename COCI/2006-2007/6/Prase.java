import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Prase 
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
		TreeMap <String, Integer> todos = new TreeMap <String, Integer> ();
		int n = sc.nextInt();
		int warns = 0;
		for(int i = 0; i < n; i++)
		{
			String s = sc.next();
			if(!todos.containsKey(s))
				todos.put(s, 1);
			else
			{
				int cuenta = 0;
				for(int a : todos.values())
					cuenta += a;
				cuenta -= todos.get(s);
				if(cuenta < todos.get(s))
					warns++;
				todos.put(s, todos.get(s) + 1);
			}
		}
		System.out.println(warns);
	}
}
