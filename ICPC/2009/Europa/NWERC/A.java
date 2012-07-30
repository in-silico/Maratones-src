import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
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
	
	static void criba()
	{
		primo[0] = true;
		primo[1] = true;
		primo[2] = false;
		for(int i = 2; i < 10000000; i++)
			if(!primo[i])
				for(int j = i + i; j < 10000000; j += i)
					primo[j] = true;
	}
	static boolean[] primo = new boolean[10000000];
	
	static HashSet <Integer> primos = new HashSet <Integer> ();
	
	public static void permutar(String posible, String acum)
	{
		String nuevo = acum;
		while(nuevo.length() > 0 && nuevo.charAt(0) == '0')
			nuevo = nuevo.substring(1);
		if(nuevo.length() != 0)
		{
			int pos = Integer.parseInt(nuevo);
			if(!primo[pos])
				primos.add(pos);
		}
		if(posible.length() == 0)
			return;
		for(int i = 0; i < posible.length(); i++)
			permutar(posible.substring(0, i) + posible.substring(i + 1, posible.length()), acum + posible.charAt(i));
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		criba();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			primos.clear();
			permutar(sc.nextLine(), "");
			System.out.println(primos.size());
		}
	}
}
