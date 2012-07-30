import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Pattern;


public class F
{
	
	static class Nodo implements Comparable <Nodo>
	{
		int n;
		int fuel;
		int best;
		boolean visitado;
		
		public Nodo(int nn, int f)
		{
			n = nn;
			fuel = f;
		}

		@Override
		public int compareTo(Nodo o) 
		{
			if(best == o.best)
			{
				if(n == o.n)
					return Integer.valueOf(fuel).compareTo(o.fuel);
				return Integer.valueOf(n).compareTo(o.n);
			}
			return Integer.valueOf(best).compareTo(o.best);
		}
	}
	
	static class Arista
	{
		Ciudad o;
		int d;
		
		public Arista(Ciudad oo, int dd)
		{
			o = oo;
			d = dd;
		}
	}
	static class Ciudad
	{
		int n;
		int cost;
		ArrayList <Arista> adjacentes = new ArrayList <Arista> ();
		
		public Ciudad(int nn, int c)
		{
			n = nn;
			cost = c;
		}
	}
	
	static Nodo[][] nodos = new Nodo[1000][101];
	static Ciudad[] ciudades = new Ciudad[1000];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern p = Pattern.compile(" ");
		String[] pedazos = p.split(br.readLine());
		int n = Integer.parseInt(pedazos[0]);
		int m = Integer.parseInt(pedazos[1]);
		pedazos = p.split(br.readLine());
		for(int i = 0; i < n; i++)
		{
			ciudades[i] = new Ciudad(i, Integer.parseInt(pedazos[i]));
			for(int j = 0; j < 101; j++)
			{
				nodos[i][j] = new Nodo(i, j);
			}
		}
		for(int i = 0; i < m; i++)
		{
			pedazos = p.split(br.readLine());
			int u = Integer.parseInt(pedazos[0]);
			int v = Integer.parseInt(pedazos[1]);
			int d = Integer.parseInt(pedazos[2]);
			ciudades[u].adjacentes.add(new Arista(ciudades[v], d));
			ciudades[v].adjacentes.add(new Arista(ciudades[u], d));
		}
		pedazos = p.split(br.readLine());
		int q = Integer.parseInt(pedazos[0]);
		TreeMap <Nodo, Nodo> pq = new TreeMap <Nodo, Nodo> ();
		for(int i = 0; i < q; i++)
		{
			pedazos = p.split(br.readLine());
			int c = Integer.parseInt(pedazos[0]);
			int s = Integer.parseInt(pedazos[1]);
			int e = Integer.parseInt(pedazos[2]);
			for(int j = 0; j < n; j++)
				for(int k = 0; k <= c; k++)
				{
					nodos[j][k].best = Integer.MAX_VALUE;
					nodos[j][k].visitado = false;
				}
			pq.clear();
			for(int j = 0; j <= c; j++)
			{
				nodos[s][j].best = ciudades[s].cost * j;
				pq.put(nodos[s][j], nodos[s][j]);
			}
			boolean termino = false;
			while(!pq.isEmpty())
			{
				Nodo actual = pq.pollFirstEntry().getKey();
				actual.visitado = true;
				if(actual.n == e)
				{
					System.out.println(actual.best);
					termino = true;
					break;
				}
				for(Arista a : ciudades[actual.n].adjacentes)
				{
					if(a.d > actual.fuel)
						continue;
					int siguiente = actual.fuel - a.d;
					if(siguiente >= 0)
					{
						Nodo este = nodos[a.o.n][siguiente];
						if(este.visitado)
							continue;
						Nodo esta = pq.get(este);
						if(esta != null)
						{
							if(actual.best < esta.best)
							{
								pq.remove(esta);
								esta.best = actual.best;
								pq.put(esta, esta);
							}
						}
						else
						{
							este.best = actual.best;
							pq.put(este, este);
						}
					}
				}
				if(actual.fuel < c)
				{
					Nodo este = nodos[actual.n][actual.fuel + 1];
					if(este.visitado)
						continue;
					Nodo esta = pq.get(este);
					if(esta != null)
					{
						if(actual.best + ciudades[actual.n].cost < esta.best)
						{
							pq.remove(esta);
							esta.best = actual.best + ciudades[actual.n].cost;
							pq.put(esta, esta);
						}
					}
					else
					{
						este.best = actual.best + ciudades[actual.n].cost;
						pq.put(este, este);
					}
				}
			}
			if(!termino)
				System.out.println("impossible");
		}
	}

}
