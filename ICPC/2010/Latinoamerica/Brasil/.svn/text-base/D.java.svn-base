import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class D
{
	
	static class Arista
	{
		int costo;
		Ciudad siguiente;
		
		public Arista(int c, Ciudad s)
		{
			costo = c;
			siguiente = s;
		}
	}
	
	static class Ciudad implements Comparable <Ciudad>
	{
		int n;
		int dist = Integer.MAX_VALUE;
		ArrayList <Arista> adjacentes = new ArrayList <Arista> ();
		
		public Ciudad(int num)
		{
			n = num;
		}

		@Override
		public int compareTo(Ciudad o)
		{
			return Integer.valueOf(dist).compareTo(o.dist);
		}

		@Override
		public boolean equals(Object obj) 
		{
			return Integer.valueOf(n).equals(((Ciudad) obj).n);
		}
	}
	
	static Ciudad[] ciudades = new Ciudad[1000];
	public static void  main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] lineaUno = br.readLine().split(" ");
			int n = Integer.parseInt(lineaUno[0]);
			int m = Integer.parseInt(lineaUno[1]);
			int c = Integer.parseInt(lineaUno[2]);
			int k = Integer.parseInt(lineaUno[3]);
			if(n == 0 && m == 0 && c == 0 && k == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				ciudades[i] = new Ciudad(i);
			}
			for(int i = 0; i < m; i++)
			{
				String[] actual = br.readLine().split(" ");
				int u = Integer.parseInt(actual[0]);
				int v = Integer.parseInt(actual[1]);
				int p = Integer.parseInt(actual[2]);
				if(u < c && v < c)
				{
					int menor = Math.min(u, v);
					int mayor = Math.max(v, u);
					if(u == v - 1 || v == u - 1)
					{
						ciudades[menor].adjacentes.add(new Arista(p, ciudades[mayor]));
					}
				}
				else if(v < c || u < c)
				{
					int menor = Math.min(u, v);
					int mayor = Math.max(v, u);
					ciudades[mayor].adjacentes.add(new Arista(p, ciudades[menor]));
				}
				else
				{
					ciudades[u].adjacentes.add(new Arista(p, ciudades[v]));
					ciudades[v].adjacentes.add(new Arista(p, ciudades[u]));
				}
			}
			PriorityQueue <Ciudad> p = new PriorityQueue <Ciudad> (n);
			ciudades[k].dist = 0;
			for(int i = 0; i < n; i++)
				p.add(ciudades[i]);
			while(!p.isEmpty())
			{
				Ciudad u = p.remove();
				if(u.n == c - 1)
				{
					System.out.println(u.dist);
					break;
				}
				for(Arista a : u.adjacentes)
				{
					int alt = u.dist + a.costo;
					if(alt < a.siguiente.dist)
					{
						a.siguiente.dist = alt;
						p.remove(a.siguiente);
						p.add(a.siguiente);
					}
				}
			}
			
		}
	}

}
