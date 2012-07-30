import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;


public class e 
{
	static int acum = 0;
	
	static class Arista
	{
		int distancia;
		Nodo ciudad;
		
		public Arista(Nodo c, int d)
		{
			ciudad = c;
			distancia = d;
		}
	}
	static class Nodo implements Comparable<Nodo>
	{
		ArrayList <Arista> aristas = new ArrayList <Arista> ();
		boolean visitado = false;
		int id = acum++;
		int mejor = Integer.MAX_VALUE;
		
		@Override
		public int compareTo(Nodo o) 
		{
			if(mejor == o.mejor)
				return Integer.valueOf(id).compareTo(o.id);
			return Integer.valueOf(mejor).compareTo(o.mejor);
		}
	}
	
	static Nodo[] nodos = new Nodo[100001];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		TreeSet <Nodo> pq = new TreeSet <Nodo> ();
		for(int i = 0; i < 100001; i++)
			nodos[i] = new Nodo();
		for(int aa = 0; aa < t; aa++)
		{
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			int m = Integer.parseInt(pedazos[1]);
			int s = Integer.parseInt(pedazos[2]);
			int e = Integer.parseInt(pedazos[3]);
			for(int i = 0; i < n; i++)
			{
				nodos[i].visitado = false;
				nodos[i].aristas.clear();
				nodos[i].mejor = Integer.MAX_VALUE;
			}
			for(int i = 0; i < m; i++)
			{
				pedazos = br.readLine().split(" ");
				int a = Integer.parseInt(pedazos[0]);
				int b = Integer.parseInt(pedazos[1]);
				int c = Integer.parseInt(pedazos[2]);
				nodos[a].aristas.add(new Arista(nodos[b], c));
				nodos[b].aristas.add(new Arista(nodos[a], c));
			}
			pq.clear();
			nodos[s].mejor = 0;
			pq.add(nodos[s]);
			while(!pq.isEmpty())
			{
				Nodo actual = pq.pollFirst();
				actual.visitado = true;
				if(actual == nodos[e])
					break;
				for(Arista a : actual.aristas)
				{
					if(a.ciudad.visitado)
						continue;
					int nueva = actual.mejor + a.distancia;
					if(nueva < a.ciudad.mejor)
					{
						pq.remove(a.ciudad);
						a.ciudad.mejor = nueva;
						pq.add(a.ciudad);
					}
				}
			}
			if(!nodos[e].visitado)
				System.out.println("NONE");
			else
				System.out.println(nodos[e].mejor);
		}
	}

}
