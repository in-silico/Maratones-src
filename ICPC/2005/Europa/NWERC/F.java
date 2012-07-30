import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class F 
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
	
	static int[] numeros = new int[1000];
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int caso = 0; caso < n; caso++)
		{
			int g = sc.nextInt();
			for(int i = 0; i < g; i++)
				numeros[i] = sc.nextInt();
			TreeSet <Integer> set =  new TreeSet <Integer> ();
			for(int m = 1; m <= 1000001; m++)
			{
				set.clear();
				boolean paila = false;
				for(int i = 0; i < g; i++)
				{
					int este = numeros[i] % m;
					if(set.contains(este))
					{
						paila = true;
						break;
					}
					else
						set.add(este);
				}
				if(!paila)
				{
					System.out.println(m);
					break;
				}
			}
		}
	}
}
