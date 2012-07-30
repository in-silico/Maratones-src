import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class F 
{
	
	static class Arista
	{
		Nodo nodo;
		int valor;
		
		public Arista(Nodo n, int v)
		{
			nodo = n;
			valor = v;
		}
	}
	static class Nodo implements Comparable <Nodo>
	{
		String nombre;
		int distancia = Integer.MAX_VALUE;
		ArrayList <Arista> adjacentes = new ArrayList <Arista> ();
		TreeMap <String, Integer> valores = new TreeMap <String, Integer> ();
		
		public Nodo(String s)
		{
			nombre = s;
		}

		@Override
		public int compareTo(Nodo o) 
		{
			if(distancia == o.distancia)
				return Integer.valueOf(hashCode()).compareTo(o.hashCode());
			return Integer.valueOf(distancia).compareTo(o.distancia);
		}
	}
	
	static TreeMap <String, Nodo> mapa = new TreeMap <String, Nodo> ();
	static TreeSet <Nodo> pq = new TreeSet <Nodo> ();
	static ArrayList <Nodo> destinos = new ArrayList <Nodo> (1001);
	
	public static Nodo darNodo(String s)
	{
		Nodo posible = mapa.get(s);
		if(posible == null)
		{
			posible = new Nodo(s);
			mapa.put(s, posible);
		}
		return posible;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nc = 1;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			mapa.clear();
			destinos.clear();
			int n = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			int r = Integer.valueOf(st.nextToken());
			if(n == 0 && c == 0 && r == 0)
				return;
			st = new StringTokenizer(br.readLine());
			Nodo inicial = darNodo(st.nextToken());
			for(int i = 0; i < c; i++)
			{
				destinos.add(darNodo(st.nextToken()));
			}
			for(int i = 0; i < r; i++)
			{
				st = new StringTokenizer(br.readLine());
				Nodo a = darNodo(st.nextToken());
				String carretera = st.nextToken();
				Nodo b = darNodo(st.nextToken());
				int valor = Integer.valueOf(carretera.substring(2, carretera.length() - 2));
				if(carretera.startsWith("<-"))
				{
					b.adjacentes.add(new Arista(a, valor));
				}
				if(carretera.endsWith("->"))
				{
					a.adjacentes.add(new Arista(b, valor));
				}
			}
			for(Nodo actual : mapa.values())
			{
				pq.clear();
				for(Nodo a : mapa.values())
				{
					a.distancia = Integer.MAX_VALUE;
					pq.add(a);
				}
				pq.remove(actual);
				actual.distancia = 0;
				pq.add(actual);
				while(!pq.isEmpty())
				{
					Nodo visitado = pq.pollFirst();
					int distancia = visitado.distancia;
					actual.valores.put(visitado.nombre, distancia);
					for(Arista adjacente : visitado.adjacentes)
					{
						int nuevoValor = distancia + adjacente.valor;
						if(nuevoValor < adjacente.nodo.distancia)
						{
							pq.remove(adjacente.nodo);
							adjacente.nodo.distancia = nuevoValor;
							pq.add(adjacente.nodo);
						}
					}
				}
			}
			int sumaTotal = 0;
			for(Nodo destino : destinos)
			{
				sumaTotal += destino.valores.get(inicial.nombre);
				sumaTotal += inicial.valores.get(destino.nombre);
			}
			System.out.println(nc++ + ". " + sumaTotal);
		}
	}
}
