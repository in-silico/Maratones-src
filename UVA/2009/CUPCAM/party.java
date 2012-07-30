import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


public class party 
{
	static class Scanner
	{
		static InputStreamReader isr;
		char buffer[];
		int pos = -1, desde, hasta, tam;
		
		public Scanner()
		{
			buffer = new char[250000];
			try 
			{
				isr = new InputStreamReader(System.in);
				isr.read(buffer);
			} 
			catch (IOException e) 
			{
				throw(new RuntimeException());
			}
		}
		
		public void leer()
		{
			try
			{
				while(buffer[++pos] <= ' ');
				desde = pos;
				hasta = desde - 1;
				while(buffer[++hasta] > ' ');
				pos = hasta;
				hasta--;
			}
			catch(Exception e)
			{
				if(pos == buffer.length)
					try
					{
						pos = -1;
						int leidos = isr.read(buffer);
						if(leidos < buffer.length)
							buffer[leidos] = '\0';
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
				else
					try
					{
						int hastaDesde = hasta - desde;
						System.arraycopy(buffer, desde, buffer, 0, hastaDesde);
						int leidos = isr.read(buffer, hastaDesde, buffer.length - hastaDesde);
						if(hastaDesde + leidos < buffer.length)
							buffer[hastaDesde + (leidos == -1 ? 0 : leidos)] = '\0';
						pos = -1;
						desde = 0;
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
			}
		}
		
		public void leerLinea()
		{
			try
			{
				while(buffer[++pos] <= ' ' && buffer[pos] != '\n' && buffer[pos] != '\r');
				if(buffer[pos] == '\n' || buffer[pos] == '\r')
					pos++;
				desde = pos;
				hasta = desde - 1;
				while(buffer[++hasta] != '\n' && buffer[hasta] != '\r');
				pos = hasta;
				hasta--;
			}
			catch(Exception e)
			{
				if(pos == buffer.length)
					try
					{
						pos = -1;
						int leidos = isr.read(buffer);
						if(leidos < buffer.length)
							buffer[leidos] = '\0';
						leerLinea();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
				else
					try
					{
						int hastaDesde = hasta - desde;
						System.arraycopy(buffer, desde, buffer, 0, hastaDesde);
						int leidos = isr.read(buffer, hastaDesde, buffer.length - hastaDesde);
						if(hastaDesde + leidos < buffer.length)
							buffer[hastaDesde + (leidos == -1 ? 0 : leidos)] = '\0';
						pos = -1;
						desde = 0;
						leerLinea();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
			}
		}
		
		public String next()
		{
			leer();
			return new String(buffer, desde, hasta - desde + 1);
		}
		
		public String nextLn()
		{
			leerLinea();
			return new String(buffer, desde, hasta - desde + 1);
		}
		
		public int nextInt()
		{
			leer();
			int resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public long nextLong()
		{
			leer();
			long resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public BigInteger nextBigInteger()
		{
			return new BigInteger(next());
		}
		
		public BigDecimal nextBigDecimal()
		{
			return new BigDecimal(next());
		}
	}
	static int[][] conexiones = new int[100][100];
	
	static class Nodo
	{
		int numero;
		
		public Nodo(int n, int todas)
		{
			numero = n;
			for(int i = 0; i < todas; i++)
			{
				conexiones[n][i] = -1;
				conexiones[i][n] = -1;
			}
		}
		
		public void agregarArista(Arista nueva)
		{
			Nodo otro = nueva.a == this ? nueva.b : nueva.a;
			conexiones[numero][otro.numero] = nueva.numero;
			conexiones[otro.numero][numero] = nueva.numero;
		}

		public boolean estaConectado(Nodo b) 
		{
			return conexiones[numero][b.numero] >= 0;
		}
	}
	
	static class DisjointSet
	{
		int[] p, rank;

		public DisjointSet(int size)
		{
			rank = new int[size];
			p = new int[size];
			for(int i = 0; i < size; i++)
			{
				make_set(i);
			}
		}

		public void make_set(int x)
		{
			p[x] = x;
			rank[x] = 0;
		}

		public void merge(int x, int y)
		{
			link(find_set(x), find_set(y));
		}

		public void link(int x, int y)
		{
			if(rank[x] > rank[y])
				p[y] = x;
			else
			{
				p[x] = y;
				if (rank[x] == rank[y])
					rank[y] += 1;
			}
		}

		public int find_set(int x)
		{
			if (x != p[x])
				p[x] = find_set(p[x]);
			return p[x];
		}

		public void iniciar(int m) 
		{
			for(int i = 0; i < m; i++)
			{
				make_set(i);
			}
		}
	}
	
	static class Arista
	{
		Nodo a;
		Nodo b;
		int numero;
		public Aristas set;
		
		public Arista(Nodo a1, Nodo b1, int n)
		{
			a = a1;
			b = b1;
			numero = n;
		}
	}
	
	static class ParAristas
	{
		Arista a;
		Arista b;
		
		public ParAristas(Arista a1, Arista b1)
		{
			a = a1;
			b = b1;
		}
	}
	
	static class Aristas
	{
		ArrayList <Arista> aristas = new ArrayList <Arista> ();
		ArrayList <Aristas> adjacentes = new ArrayList <Aristas> ();
		int color = 0;
	}
	
	static Nodo[] nodos = new Nodo[100];
	static Arista[] aristas = new Arista[1000];
	static DisjointSet ds = new DisjointSet(1000);
	static Aristas[] aristasProblema = new Aristas[1000];
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < n; i++)
				nodos[i] = new Nodo(i, n);
			for(int i = 0; i < m; i++)
			{
				Arista nueva = new Arista(nodos[sc.nextInt()], nodos[sc.nextInt()], i);
				nueva.a.agregarArista(nueva);
				nueva.b.agregarArista(nueva);
				aristas[i] = nueva;
				aristasProblema[i] = null;
			}
			ds.iniciar(m);
			ArrayList <ParAristas> pares = new ArrayList <ParAristas> ();
			for(int i = 0; i < n; i++)
			{
				Nodo a = nodos[i];
				for(int j = 0; j < n; j++)
				{
						if(conexiones[i][j] < 0)
							continue;
						for(int k = 0; k < n; k++)
						{
							if(conexiones[j][k] < 0)
								continue;
							Nodo c = nodos[k];
							if(c == a)
								continue;
							if(a.estaConectado(c))
								ds.merge(conexiones[i][j], conexiones[j][k]);
							else
								pares.add(new ParAristas(aristas[conexiones[i][j]], aristas[conexiones[j][k]]));
						}
				}
			}
			for(int i = 0; i < m; i++)
			{
				Arista actual = aristas[i];
				int numero = ds.find_set(i);
				if(aristasProblema[numero] != null)
				{
					aristasProblema[numero].aristas.add(actual);
				}
				else
				{
					aristasProblema[numero] = new Aristas();
					aristasProblema[numero].aristas.add(actual);
				}
			}
			for(int i = 0; i < m; i++)
			{
				if(aristasProblema[i] == null)
					continue;
				Aristas actual = aristasProblema[i];
				for(Arista a : actual.aristas)
					a.set = actual;
			}
			for(ParAristas p : pares)
			{
				p.a.set.adjacentes.add(p.b.set);
				p.b.set.adjacentes.add(p.a.set);
			}
			boolean bien = true;
			for(int i = 0; i < m; i++)
			{
				Aristas a = aristasProblema[i];
				if(a == null)
					continue;
				if(a.color == 0)
					if(!pintar(a, 1))
					{
						bien = false;
						break;
					}
			}
			if(bien)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	private static boolean pintar(Aristas a, int i) 
	{
		a.color = i;
		for(Aristas hija : a.adjacentes)
		{
			if(hija.color > 0)
			{
				if(hija.color == i)
					return false;
			}
			else
			{
				if(!pintar(hija, i == 1 ? 2 : 1))
					return false;
			}
		}
		return true;
	}
}
