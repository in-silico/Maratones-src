import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class BST
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
	
	public static class Nodo
	{
		int altura = 0;
		Nodo izquierdo;
		Nodo derecho;
		int valor;
		
		public Nodo(int v)
		{
			valor = v;
		}
	}
	
	public static class Intervalo implements Comparable <Intervalo>
	{
		int inicio;
		int fin;
		
		public Intervalo(int inicio, int fin) 
		{
			this.inicio = inicio;
			this.fin = fin;
		}

		@Override
		public int compareTo(Intervalo o) 
		{
			if(inicio < o.inicio && fin < o.fin)
				return -1;
			if(inicio > o.inicio && fin > o.fin)
				return 1;
			return 0;
		}
	}
	
	static class Par
	{
		Intervalo i;
		Nodo n;
		
		public Par(Intervalo i, Nodo n) 
		{
			this.i = i;
			this.n = n;
		}
	}
	
	static TreeMap <Intervalo, Par> intervalos = new TreeMap <Intervalo, Par> ();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int nRaiz = sc.nextInt();
		Nodo raiz = new Nodo(nRaiz);
		if(nRaiz != 1)
		{
			Intervalo nuevo = new Intervalo(1, nRaiz - 1);
			intervalos.put(nuevo, new Par(nuevo, raiz));
		}
		if(nRaiz != n)
		{
			Intervalo nuevo = new Intervalo(nRaiz + 1, n);
			intervalos.put(nuevo, new Par(nuevo, raiz));
		}
		Intervalo temp = new Intervalo(0, 0);
		long cuenta = 0;
		System.out.println(cuenta);
		for(int i = 0; i < n - 1; i++)
		{
			int actual = sc.nextInt();
			temp.inicio = temp.fin = actual;
			Par buscado = intervalos.get(temp);
			Intervalo anterior = buscado.i;
			Nodo nodo = buscado.n;
			cuenta += nodo.altura + 1;
			System.out.println(cuenta);
			if(actual < nodo.valor)
			{
				nodo.izquierdo = new Nodo(actual);
				nodo.izquierdo.altura = nodo.altura + 1;
				intervalos.remove(anterior);
				if(anterior.inicio != actual)
				{
					Intervalo nuevo = new Intervalo(anterior.inicio, actual - 1);
					intervalos.put(nuevo, new Par(nuevo, nodo.izquierdo));
				}
				if(anterior.fin != actual)
				{
					Intervalo nuevo = new Intervalo(actual + 1, anterior.fin);
					intervalos.put(nuevo, new Par(nuevo, nodo.izquierdo));	
				}
			}
			else
			{
				nodo.derecho = new Nodo(actual);
				nodo.derecho.altura = nodo.altura + 1;
				intervalos.remove(anterior);
				if(anterior.inicio != actual)
				{
					Intervalo nuevo = new Intervalo(anterior.inicio, actual - 1);
					intervalos.put(nuevo, new Par(nuevo, nodo.derecho));
				}
				if(anterior.fin != actual)
				{
					Intervalo nuevo = new Intervalo(actual + 1, anterior.fin);
					intervalos.put(nuevo, new Par(nuevo, nodo.derecho));	
				}
			}
		}
	}
}