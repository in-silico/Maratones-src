import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
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
			try
			{
				br = new BufferedReader(new FileReader("e.in"));
			}
			catch (FileNotFoundException e) 
			{
			}
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
	
	static final int tam = 16 * 1024 * 1024;
	static final int tam1 = tam - 1;
	
	static class HashMapa
	{
		static class Nodo
		{
			int distancia;
			int numero;
			
			public Nodo(int d, int n)
			{
				distancia = d;
				numero = n;
			}
			
			Nodo siguiente;
		}
		
		Nodo[] nodos;
		
		public HashMapa()
		{
			nodos = new Nodo[tam];
		}
		
		public int dar(int posible)
		{
			int llave = posible & tam1;
			if(nodos[llave] != null)
				for(Nodo actual = nodos[llave]; actual != null; actual = actual.siguiente)
					if(actual.distancia == posible)
						return actual.numero;
			return 0;
		}
		
		public void poner(int posible)
		{
			int llave = posible & tam1;
			if(nodos[llave] != null)
			{
				for(Nodo actual = nodos[llave]; true; actual = actual.siguiente)
					if(actual.distancia == posible)
					{
						++actual.numero;
						return;
					}
					else if(actual.siguiente == null)
					{
						actual.siguiente = new Nodo(posible, 1);
						return;
					}
			}
			else
				nodos[llave] = new Nodo(posible, 1);
		}
		
		public void limpiar()
		{
			for(int i = 0; i < tam; i++)
				nodos[i] = null;
		}
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[4001];
		int[] b = new int[4001];
		int[] c = new int[4001];
		int[] d = new int[4001];
		Scanner sc = new Scanner();
		HashMapa hash = new HashMapa();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
				c[i] = -sc.nextInt();
				d[i] = -sc.nextInt();
			}
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					hash.poner(a[i] + b[j]);
			long cuenta = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					cuenta += hash.dar(c[i] + d[j]);
			System.out.println(cuenta);
			hash.limpiar();
		}
	}
}