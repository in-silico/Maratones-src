import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class J 
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
	
	static class Media
	{
		LinkedList <Media> adjacentes = new LinkedList <Media> ();
		int numero;
		
		public Media(int nn)
		{
			numero = nn;
		}
	}
	
	static class Par implements Comparable <Par>
	{
		int a;
		int b;
		
		public Par(int numero, int numero2) 
		{
			a = Math.min(numero, numero2);
			b = Math.max(numero, numero2);
		}

		@Override
		public int compareTo(Par o)
		{
			return new Integer(a).compareTo(o.a);
		}
	}
	
	static Media[] medias = new Media[1001];

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int z = sc.nextInt();	
		ArrayList <Par> pares = new ArrayList <Par> (1000);
		for(int caso = 0; caso < z; caso++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			for(int i = 1; i <= n; i++)
				medias[i] = new Media(i);
			for(int j = 0; j < m; j++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				medias[a].adjacentes.add(medias[b]);
				medias[b].adjacentes.add(medias[a]);
			}
			pares.clear();
			for(int aa = 0; aa < n; aa++)
			{
				for(int i = 1; i <= n; i++)
				{
					Media a = medias[i];
					if(a.adjacentes.size() == 1)
					{
						Media b = medias[i].adjacentes.poll();
						Par nuevo = new Par(a.numero, b.numero);
						b.adjacentes.remove(medias[i]);
						for(Media otra : b.adjacentes)
							otra.adjacentes.remove(b);
						b.adjacentes.clear();
						pares.add(nuevo);
					}
				}
			}
			Collections.sort(pares);
			if(pares.size() == n / 2)
			{
				System.out.println("YES");
				for(Par p : pares)
					System.out.println(p.a + " " + p.b);
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
}
