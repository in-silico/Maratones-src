import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class C 
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
	
	static Scanner sc = new Scanner();
	
	static int leerDocumento()
	{
		int n = sc.nextInt();
		int res = 0;
		for(int i = 0; i < n; i++)
			res |= 1 << (sc.nextInt() - 1);
		return res;
	}
	
	public static void main(String[] args)
	{
		int[] bases = new int[105];
		int[] queries = new int[105];
		int[] mejor = new int[1 << 16];
		while(true)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			if(m == 0 && n == 0)
				return;
			for(int i = 0; i < m; i++)
				bases[i] = leerDocumento();
			for(int i = 0; i < n; i++)
				queries[i] = leerDocumento();
			for(int i = 0; i < 1 << 16; i++)
				mejor[i] = 0;
			LinkedList <Integer> cola = new LinkedList <Integer> ();
			for(int i = 0; i < m; i++)
			{
				cola.add(bases[i]);
				mejor[bases[i]] = 1;
			}
			while(!cola.isEmpty())
			{
				int actual = cola.poll();
				for(int i = 0; i < m; i++)
				{
					int vecino = actual | bases[i];
					if(mejor[vecino] > 0)
						continue;
					mejor[vecino] = mejor[actual] + 1;
					cola.add(vecino);
				}
			}
			
			for(int i = 0; i < n; i++)
				if(i == 0)
					System.out.print(mejor[queries[i]]);
				else
					System.out.print(" " + mejor[queries[i]]);
			System.out.println();
		}
	}

}
