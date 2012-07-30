import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class D 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner() throws FileNotFoundException
		{
			br = new BufferedReader(new FileReader("d.in"));
		}
		
		public int nextInt() throws IOException
		{

				if(st == null || !st.hasMoreElements())
					st = new StringTokenizer(br.readLine());
				return Integer.parseInt(st.nextToken());
		}
	}
	
	static class DisjointSet
	{
		int[] p, rank;
		
		public DisjointSet(int size)
		{
			rank = new int[size + 1];
			p = new int[size + 1];
			clear();
		}
		
		public void clear()
		{
			for(int i = 0; i < rank.length; i++)
				make_set(i);
		}

		private void make_set(int x) 
		{
			p[x] = x;
			rank[x] = 0;
		}
		
		public void merge(int x, int y)
		{
			link(find_set(x), find_set(y));
		}

		private void link(int x, int y) 
		{
			if(rank[x] > rank[y])
				p[y] = x;
			else
			{
				p[x] = y;
				if(rank[x] == rank[y])
					rank[y]++;
			}
		}

		private int find_set(int x)
		{
			if(x != p[x])
				p[x] = find_set(p[x]);
			return p[x];
		}
	}
	
	static class Arista implements Comparable <Arista>
	{
		int a, b, costo;

		public Arista(int a, int b, int costo) 
		{
			this.a = a;
			this.b = b;
			this.costo = costo;
		}

		@Override
		public int compareTo(Arista o) 
		{
			return costo - o.costo;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		ArrayList < ArrayList <Integer> > subredes = new ArrayList <ArrayList <Integer> > ();
		ArrayList <Integer> costos = new ArrayList <Integer> ();
		int[][] ciudades = new int[1005][2];
		ArrayList <Arista> aristas = new ArrayList <Arista> ();
		while(true)
		{
			aristas.clear();
			subredes.clear();
			costos.clear();
			int n = sc.nextInt();
			int q = sc.nextInt();
			if(n == 0 && q == 0)
				return;
			for(int i = 0; i < q; i++)
			{
				int nq = sc.nextInt();
				costos.add(sc.nextInt());
				ArrayList <Integer> actual = new ArrayList <Integer> ();
				for(int j = 0; j < nq; j++)
					actual.add(sc.nextInt());
				subredes.add(actual);
			}
			for(int i = 1; i <= n; i++)
			{
				ciudades[i][0] = sc.nextInt();
				ciudades[i][1] = sc.nextInt();
			}
			for(int i = 1; i <= n; i++)
				for(int j = i + 1; j <= n; j++)
				{
					int distancia = ciudades[i][0] - ciudades[j][0];
					distancia *= distancia;
					int distancia2 = ciudades[i][1] - ciudades[j][1];
					distancia2 *= distancia2;
					distancia += distancia2;
					aristas.add(new Arista(i, j, distancia));
				}
			Collections.sort(aristas);
			int limite = 1 << q;
			DisjointSet ds = new DisjointSet(n);
			int mejor = Integer.MAX_VALUE;
			for(int actual = 0; actual < limite; actual++)
			{
				ds.clear();
				int costo = 0;
				int temp = actual;
				for(int i = 0; i < q; i++)
				{
					if((temp & 1) == 1)
					{
						costo += costos.get(i);
						ArrayList <Integer> esta = subredes.get(i);
						if(esta.isEmpty())
							continue;
						int primero = esta.get(0);
						for(int j = 1; j < esta.size(); j++)
							ds.merge(primero, esta.get(j));
					}
					temp >>= 1;
				}
				for(Arista a : aristas)
				{
					if(ds.find_set(a.a) != ds.find_set(a.b))
					{
						costo += a.costo;
						ds.merge(a.a, a.b);
					}
				}
				mejor = Math.min(mejor, costo);
			}
			System.out.println(mejor);
		}
	}
}