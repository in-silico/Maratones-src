import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class E 
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
		
		public long nextLong()
		{
			return Long.parseLong(next());
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

	static class Nodo
	{
		int id;
		int distancia = Integer.MAX_VALUE;
		
		public Nodo(int i)
		{
			id = i;
		}
	}
	
	static class Arista
	{
		Nodo a;
		Nodo b;
		int peso;
		
		public Arista(Nodo a, Nodo b, int peso)
		{
			this.a = a;
			this.b = b;
			this.peso = peso;
		}	
	}
	
	static Nodo[] nodos = new Nodo[305];
	static ArrayList <Arista> aristas = new ArrayList <Arista> ();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		for(int i = 0; i < 305; i++)
			nodos[i] = new Nodo(i);
		int tc = sc.nextInt();
		for(int caso = 0; caso < tc; caso++)
		{
			if(caso != 0)
				System.out.println();
			int n = sc.nextInt();
			for(int i = 0; i < 305; i++)
				nodos[i].distancia = Integer.MAX_VALUE;
			int inicial = sc.nextInt();
			int ultimo = sc.nextInt();
			int m = sc.nextInt();
			aristas.clear();
			for(int i = 0; i < m; i++)
				aristas.add(new Arista(nodos[sc.nextInt()], nodos[sc.nextInt()], sc.nextInt()));
			nodos[inicial].distancia = 0;
			for(int i = 0; i < n - 1; i++)
			{
				for(Arista a : aristas)
				{
					Nodo u = a.a;
					if(u.distancia == Integer.MAX_VALUE)
						continue;
					int nuevo = u.distancia + a.peso;
					if(nuevo < a.b.distancia)
						a.b.distancia = nuevo;
				}
			}
			boolean paila = false;
			for(Arista a : aristas)
			{
				Nodo u = a.a;
				if(u.distancia == Integer.MAX_VALUE)
					continue;
				int nuevo = u.distancia + a.peso;
				if(nuevo < a.b.distancia)
				{
					paila = true;
					break;
				}
			}
			if(paila || nodos[ultimo].distancia == Integer.MAX_VALUE)
				System.out.println("infinity");
			else
				System.out.println(nodos[ultimo].distancia);
		}
	}
}
