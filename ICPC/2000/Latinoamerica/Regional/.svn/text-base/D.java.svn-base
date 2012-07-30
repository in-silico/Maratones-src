import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;


public class D 
{
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
	
	static class Bomba
	{
		int x, y, r, borde = 0;
		Point2D punto;
		
		Bomba(int xx, int yy, int rr)
		{
			x = xx;
			y = yy;
			r = rr;
			punto = new Point2D.Double(x, y);
		}
	}
	
	static class Conjunto
	{
		ArrayList <Bomba> bombas = new ArrayList <Bomba> ();
		int borde = 0;
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] leerNumeros() throws IOException
	{
		String[] pedazos = br.readLine().trim().split("\\s+");
		int[] numeros = new int[pedazos.length];
		for(int i = 0; i < pedazos.length; i++)
			numeros[i] = Integer.parseInt(pedazos[i]);
		return numeros;
	}
	
	static ArrayList <Bomba> bombas = new ArrayList <Bomba> ();
	
	public static void main(String[] args) throws IOException
	{
		int n = leerNumeros()[0];
		for(int aa = 0; aa < n; aa++)
		{
			int[] numeros = leerNumeros();
			int w = numeros[0];
			int b = numeros[2];
			bombas.clear();
			bombas.ensureCapacity(b);
			boolean partido = false;
			for(int i = 0; i < b; i++)
			{
				numeros = leerNumeros();
				Bomba nueva = new Bomba(numeros[0], numeros[1], numeros[2]);
				if(nueva.x - nueva.r <= 0)
					nueva.borde = 1;
				if(nueva.x + nueva.r >= w)
					if(nueva.borde == 1)
						partido = true;
					else
						nueva.borde = 2;
				bombas.add(nueva);
			}
			Bomba[] bombas1 = new Bomba[b];
			bombas.toArray(bombas1);
			Bomba[] bombas = bombas1;
			if(partido)
			{
				System.out.println("Bridge already split");
			}
			else
			{
				DisjointSet ds = new DisjointSet(b);
				for(int i = 0; i < b; i++)
					for(int j = i + 1; j < b; j++)
					{
						int distancia = (int) bombas[i].punto.distance(bombas[j].punto);
						if(distancia <= bombas[i].r + bombas[j].r)
							ds.merge(i, j);
					}
				int nConjuntos = 0;
				boolean[] conjuntosA = new boolean[b];
				for(int i = 0; i < b; i++)
				{
					int cual = ds.find_set(i);
					if(conjuntosA[cual] == false)
					{
						conjuntosA[cual] = true;
						nConjuntos++;
					}
				}
				ArrayList <Integer> tConjuntos = new ArrayList <Integer> ();
				TreeMap <Integer, Integer> ids = new TreeMap <Integer, Integer> ();
				for(int i = 0; i < b; i++)
					if(conjuntosA[i])
					{
						ids.put(i, tConjuntos.size());
						tConjuntos.add(i);
					}
				ArrayList <Conjunto> conjuntos = new ArrayList <Conjunto> ();
				for(int i = 0; i < tConjuntos.size(); i++)
					conjuntos.add(new Conjunto());
				for(int i = 0; i < b; i++)
				{
					int cual = ds.find_set(i);
					conjuntos.get(ids.get(cual)).bombas.add(bombas[i]);
				}
				for(Conjunto c : conjuntos)
				{
					for(Bomba bo : c.bombas)
						c.borde |= bo.borde;
					if(c.borde == 3)
					{
						partido = true;
						break;
					}
				}
				if(partido)
				{
					System.out.println("Bridge already split");
					continue;
				}
				int menor = Integer.MAX_VALUE;
				for(Conjunto c : conjuntos)
				{
					if(c.borde != 1)
						continue;
					for(Conjunto c1 : conjuntos)
					{
						if(c1.borde != 2)
							continue;
						for(Bomba b0 : c.bombas)
						{
							for(Bomba b1 : c1.bombas)
							{
								int distancia = ((int) b0.punto.distance(b1.punto)) - b0.r - b1.r;
								distancia += 1;
								distancia /= 2;
								menor = Math.min(menor, distancia);
							}
						}
					}
				}
				for(Conjunto c : conjuntos)
				{
					if(c.borde != 1)
						continue;
					for(Bomba b0 : c.bombas)
					{
						int distancia = w - b0.x - b0.r;
						distancia += 1;
						distancia /= 2;
						menor = Math.min(menor, distancia);
					}
				}
				for(Conjunto c : conjuntos)
				{
					if(c.borde != 2)
						continue;
					for(Bomba b0 : c.bombas)
					{
						int distancia = b0.x - b0.r;
						distancia += 1;
						distancia /= 2;
						menor = Math.min(menor, distancia);
					}
				}
				menor = Math.min(menor, (w + 1) / 2);
				System.out.println(menor);
			}
		}
	}
}
