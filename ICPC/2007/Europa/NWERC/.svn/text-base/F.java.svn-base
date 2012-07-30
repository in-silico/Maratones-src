import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class F 
{
	static int consecutivo = 0;
	static class WareHouse implements Comparable <WareHouse>
	{
		int numero = consecutivo++;
		int costo;
		LinkedList <WareHouse> adjacentes = new LinkedList <WareHouse> ();
		
		@Override
		public int compareTo(WareHouse o) {
			if(costo == o.costo)
				return Integer.valueOf(numero).compareTo(o.numero);
			return Integer.valueOf(costo).compareTo(o.costo);
		}
	}
	
	static TreeMap <String, WareHouse> todos = new TreeMap <String, WareHouse> ();
	

	static TreeSet <WareHouse> pq = new TreeSet <WareHouse> ();
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ds = Integer.parseInt(br.readLine());
		System.out.println("SHIPPING ROUTES OUTPUT");
		for(int caso = 1; caso <= ds; caso++)
		{
			System.out.println();
			System.out.println("DATA SET  " + caso);
			todos.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(p != 0)
				System.out.println();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++)
			{
				todos.put(st.nextToken(), new WareHouse());
			}
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(br.readLine());
				WareHouse a = todos.get(st.nextToken());
				WareHouse b = todos.get(st.nextToken());
				a.adjacentes.add(b);
				b.adjacentes.add(a);
			}
			for(int i = 0; i < p; i++)
			{
				pq.clear();
				st = new StringTokenizer(br.readLine());
				int peso = Integer.parseInt(st.nextToken());
				WareHouse origen = todos.get(st.nextToken());
				WareHouse destino = todos.get(st.nextToken());
				for(WareHouse w : todos.values())
				{
					if(w != origen)
						w.costo = Integer.MAX_VALUE;
					else
						w.costo = 0;
					pq.add(w);
				}
				while(!pq.isEmpty())
				{
					WareHouse actual = pq.pollFirst();
					if(actual == destino || actual.costo == Integer.MAX_VALUE)
						break;
					for(WareHouse w : actual.adjacentes)
					{
						int nuevoCosto = actual.costo + 1;
						if(nuevoCosto < w.costo)
						{
							pq.remove(w);
							w.costo = nuevoCosto;
							pq.add(w);
						}
					}
				}
				if(destino.costo == Integer.MAX_VALUE || destino.costo < 0)
					System.out.println("NO SHIPMENT POSSIBLE");
				else
					System.out.println("$" + peso * destino.costo * 100);
			}
		}
		System.out.println();
		System.out.println("END OF OUTPUT");
	}

}
