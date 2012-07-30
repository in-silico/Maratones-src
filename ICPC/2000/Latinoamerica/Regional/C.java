import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class C 
{
	static class Arista implements Comparable <Arista>
	{
		int a, b, costo;
		
		Arista(int aa, int bb, int cost)
		{
			a = aa;
			b = bb;
			costo = cost;
		}

		@Override
		public int compareTo(Arista o) 
		{
			return Integer.valueOf(costo).compareTo(o.costo);
		}
	}
	
	static class DisjointSet
	{
		int[] p, rank;
		int size;
		
		public DisjointSet(int sizeI)
		{
			rank = new int[sizeI];
			p = new int[sizeI];
			size = sizeI;
			reset();
		}
		
		public void reset()
		{
			for(int i = 0; i < size; i++)
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
		
		public void link(int x, int y)
		{
			if(rank[x] > rank[y])
				p[y] = x;
			else
			{
				p[x] = y;
				if(rank[x] == rank[y])
					rank[y] += 1;
			}
		}
		
		public int find_set(int x)
		{
			if(x != p[x])
				p[x] = find_set(p[x]);
			return p[x];
		}
	}
	
	static int[][] distancias = new int[21][21];
	static boolean[] esta = new boolean[21];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList <Arista> aristas = new ArrayList <Arista> ();
	                                        
	static int[] leerNumeros() throws IOException
	{
		String[] pedazos = br.readLine().trim().split("\\s+");
		int[] numeros = new int[pedazos.length];
		for(int i = 0; i < pedazos.length; i++)
			numeros[i] = Integer.parseInt(pedazos[i]);
		return numeros;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int actual = 1;
		while(true)
		{
			int[] numeros = leerNumeros();
			int n = numeros[0];
			DisjointSet ds = new DisjointSet(n + 1);
			if(n == 0)
				return;
			int t = numeros[1];
			aristas.clear();
			for(int i = 0; i < n; i++)
			{
				numeros = leerNumeros();
				int act = 0;
				for(int j = i + 1; j <= n; j++)
				{
					distancias[i][j] = numeros[act++];
					aristas.add(new Arista(i, j, distancias[i][j]));
				}
			}
			Collections.sort(aristas);
			int todos = 1 << n;
			int menor = Integer.MAX_VALUE;
			for(int i = 0; i < todos; i++)
			{
				int cuantos = 0;
				esta[0] = true;
				int ii = i;
				for(int j = 1; j <= n; j++)
				{
					esta[j] = (ii & 1) == 1;
					if(esta[j])
						cuantos++;
					ii >>>= 1;
				}
				int tamano = 0;
				int valor = 0;
				ds.reset();
				for(Arista a : aristas)
				{
					if(!esta[a.a] || !esta[a.b])
						continue;
					if(ds.find_set(a.a) != ds.find_set(a.b))
					{
						tamano++;
						valor += a.costo;
						ds.merge(a.a, a.b);
					}
					if(tamano == n)
						break;
				}
				valor += (t * (n - cuantos));
				menor = Math.min(menor, valor);
			}
			System.out.println("Cable Net #" + actual++);
			System.out.println(n * t);
			System.out.println(menor);
			System.out.println();
		}
	}
}
