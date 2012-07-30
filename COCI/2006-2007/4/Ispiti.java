import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Ispiti
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
	
	static class Nodo
	{
		static Nodo[] posiciones = new Nodo[1000000];
		static int posicionActual = 0;
		Query estudiante;
		int mayor = 0;
		Nodo padre;
		Nodo izquierdo;
		Nodo derecho;
		
		public Nodo(Nodo p)
		{
			padre = p;
		}
		
		public static Nodo generar(int altura, Nodo padre)
		{
			if(altura == 0)
				return posiciones[posicionActual++] = new Nodo(padre);
			Nodo raiz = new Nodo(padre);
			raiz.izquierdo = generar(altura - 1, raiz);
			raiz.derecho = generar(altura - 1, raiz);
			return raiz;
		}

		public void actualizar(int a) 
		{
			if(a > mayor)
			{
				mayor = a;
				if(padre != null)
					padre.actualizar(mayor);
			}
		}

		public Query buscar(Nodo anterior, int valor) 
		{
			if(anterior == null || (anterior != null && anterior == derecho))
			{
				if(padre == null)
					return null;
				else
					return padre.buscar(this, valor);
			}
			else
			{
				Query posible = derecho.buscarAbajo(valor);
				if(posible != null)
					return posible;
				else
				{
					if(padre == null)
						return null;
					else
						return padre.buscar(this, valor);
				}
			}
		}
		
		public Query buscarAbajo(int valor)
		{
			if(mayor < valor)
				return null;
			if(izquierdo == null)
				return estudiante;
			else
			{
				Query posible = izquierdo.buscarAbajo(valor);
				if(posible != null)
					return posible;
				else
					return derecho.buscarAbajo(valor);
			}
		}
	}
	
	static class Query implements Comparable <Query>
	{
		boolean d;
		int a;
		int b;
		int numero;
		Nodo posicion;
		
		public Query(boolean d, int a, int b) 
		{
			this.d = d;
			this.a = a;
			this.b = b;
		}

		public int compareTo(Query o) 
		{
			if(b == o.b)
				return a - o.a;
			else
				return b - o.b;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int q = sc.nextInt();
		if(q == 0)
			return;
		Query[] queries = new Query[q];
		Query[] estudiantes = new Query[q];
		int nEstudiantes = 0;
		for(int i = 0; i < q; i++)
		{
			if(sc.next().equals("D"))
			{
				queries[i] = new Query(true, sc.nextInt(), sc.nextInt());
				queries[i].numero = nEstudiantes + 1;
				estudiantes[nEstudiantes++] = queries[i];
			}
			else
				queries[i] = new Query(false, sc.nextInt(), 0);
		}
		Query[] estudiantesP = estudiantes.clone();
		Arrays.sort(estudiantes, 0, nEstudiantes);
		Nodo.generar(Integer.numberOfTrailingZeros(Integer.highestOneBit(nEstudiantes)) + 1, null);
		for(int i = 0; i < nEstudiantes; i++)
			estudiantes[i].posicion = Nodo.posiciones[i];
		for(int i = 0; i < q; i++)
		{
			Query actual = queries[i];
			if(actual.d)
			{
				actual.posicion.estudiante = actual;
				actual.posicion.actualizar(actual.a);
			}
			else
			{
				Query respuesta = estudiantesP[actual.a - 1].posicion.buscar(null, estudiantesP[actual.a - 1].a);
				if(respuesta == null)
					System.out.println("NE");
				else
					System.out.println(respuesta.numero);
			}
		}
	}
}
