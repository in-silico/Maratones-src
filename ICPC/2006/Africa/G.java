import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class G 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
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
	}
	
	static LinkedList <Character> lista = new LinkedList <Character> ();
	static int[][] distancias = new int[1001][1001];
	static boolean[] visitados = new boolean[1001];
	static int costo;

	private static int leerInt() 
	{
		String acum = "";
		while(lista.peekFirst().charValue() >= '0' && lista.peekFirst().charValue() <= '9')
			acum += lista.pollFirst();
		return Integer.parseInt(acum);
	}
	
	public static int leerArbol()
	{
		while(lista.peekFirst().charValue() == ' ')
			lista.pollFirst();
		if(lista.peekFirst().charValue() == '(')
		{
			lista.pollFirst();
			int cabeza = leerInt();
			while(true)
			{
				while(lista.peekFirst().charValue() == ' ')
					lista.pollFirst();
				if(lista.peekFirst().charValue() == ')')
				{
					lista.pollFirst();
					visitados[cabeza] = true;
					return cabeza;
				}
				int siguiente = leerArbol();
				costo += distancias[cabeza][siguiente];
			}
		}
		else
		{
			int cabeza = leerInt();
			visitados[cabeza] = true;
			return cabeza;
		}
	}
	
	static class DisjointSet
	{
		int[] p, rank, siguiente;

		public DisjointSet(int size)
		{
			rank = new int[size];
			p = new int[size];
			siguiente = new int[size];
			for(int i = 0; i < size; i++)
			{
				make_set(i);
			}
		}

		public void make_set(int x)
		{
			p[x] = x;
			rank[x] = 0;
			siguiente[x] = 0;
		}

		public void merge(int x, int y)
		{
			link(find_set(x), find_set(y));
			rank[x] = (Math.abs(x - y) % 1000);
			siguiente[x] = y;
		}
		
		public int costo(int x)
		{
			if(siguiente[x] == x)
				return rank[x];
			return rank[x] + costo(siguiente[x]);
		}

		public void link(int x, int y)
		{
				p[x] = y;
		}

		public int find_set(int x)
		{
			if (x != p[x])
				p[x] = find_set(p[x]);
			return p[x];
		}
	}
	
	public static class Arista implements Comparable <Arista>
	{
		int a;
		int b; 
		int costo;
		
		public Arista(int i, int j, int k) 
		{
			a = i;
			b = j;
			costo = k;
		}

		@Override
		public int compareTo(Arista o) 
		{
			return costo - o.costo;
		}
	}
	

	static ArrayList <Arista> aristas = new ArrayList <Arista> ();
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("das.txt"));
		Scanner sc = new Scanner();
		int caso = 1;
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			aristas.clear();
			for(int i = 1; i < n; i++)
				for(int j = i + 1; j <= n; j++)
				{
					distancias[i][j] = distancias[j][i] = sc.nextInt();
					if(distancias[i][j] != 0)
						aristas.add(new Arista(i, j, distancias[i][j]));
				}
			Collections.sort(aristas);
			int q = sc.nextInt();
			for(int a = 0; a < q; a++)
			{
				System.out.print(caso + "." + (a + 1) + " ");
				lista.clear();
				for(char c : sc.nextLine().toCharArray())
					lista.add(c);
				for(int i = 0; i <= n; i++)
					visitados[i] = false;
				costo = 0;
				leerArbol();
				DisjointSet ds = new DisjointSet(n + 1);
				int cuenta = 0;
				int valor = 0;
				for(Arista ar : aristas)
				{
					if(ds.find_set(ar.a) != ds.find_set(ar.b))
					{
						ds.merge(ar.a, ar.b);
						cuenta++;
						valor += ar.costo;
					}
				}
				boolean paila = false;
				for(int i = 1; i <= n; i++)
					if(!visitados[i])
						paila = true;
				if(paila || cuenta < n - 1 || costo != valor)
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			caso++;
		}
	}
}
