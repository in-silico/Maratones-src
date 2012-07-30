import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;


public class C 
{
	static class Path
	{
		long d;
		Intersection o;
		
		public Path(int dis, Intersection ot)
		{
			d = dis;
			o = ot;
		}
	}
	static int actual = 0;
	static class Intersection implements Comparable <Intersection>
	{
		ArrayList <Path> adjacentes = new ArrayList <Path> ();
		long mejorDijsktra = Long.MAX_VALUE;
		long mejorFinal = Long.MAX_VALUE;
		int cuentaDP = Integer.MAX_VALUE;
		int consecutivo = actual++;
		int n;
		
		public Intersection(int nn)
		{
			n = nn;
		}
		
		@Override
		public int compareTo(Intersection o) 
		{
			if(mejorDijsktra == o.mejorDijsktra)
				return Integer.valueOf(consecutivo).compareTo(o.consecutivo);
			return Long.valueOf(mejorDijsktra).compareTo(o.mejorDijsktra);
		}
		
		
	}
	
	static ArrayList <Intersection> intersecciones = new ArrayList <Intersection> (1001);
	
	public static int buscar(Intersection actual)
	{
		if(actual.n == 2)
			return 1;
		if(actual.cuentaDP != Integer.MAX_VALUE)
			return actual.cuentaDP;
		int cuenta = 0;
		for(Path p : actual.adjacentes)
		{
			if(p.o.mejorDijsktra < actual.mejorDijsktra)
			{
				cuenta += buscar(p.o);
			}
		}
		return actual.cuentaDP = cuenta;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TreeMap <Intersection, Intersection> mapa = new TreeMap <Intersection, Intersection> ();
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			if(n == 0)
				return;
			intersecciones.clear();
			int m = Integer.parseInt(pedazos[1]);
			for(int i = 0; i <= n; i++)
				intersecciones.add(new Intersection(i));
			for(int i = 0; i < m; i++)
			{
				pedazos = br.readLine().split(" ");
				int a = Integer.parseInt(pedazos[0]);
				int b = Integer.parseInt(pedazos[1]);
				int d = Integer.parseInt(pedazos[2]);
				intersecciones.get(a).adjacentes.add(new Path(d, intersecciones.get(b)));
				intersecciones.get(b).adjacentes.add(new Path(d, intersecciones.get(a)));
			}
			Intersection destino = intersecciones.get(1);
			Intersection inicial = intersecciones.get(2);
			mapa.clear();
			inicial.mejorDijsktra = 0;
			mapa.put(inicial, inicial);
			for(int j = 1; j <= n; j++)
			{
				if(j == 2)
					continue;
				Intersection actual = intersecciones.get(j);
				actual.mejorDijsktra = Long.MAX_VALUE;
				mapa.put(actual, actual);
			}
			while(!mapa.isEmpty())
			{
				Intersection actual = mapa.pollFirstEntry().getKey();
				if(actual == destino)
				{
					break;
				}
				for(Path p : actual.adjacentes)
				{
					if(actual.mejorDijsktra == Long.MAX_VALUE)
						continue;
					long posible = actual.mejorDijsktra + p.d;
					if(posible < p.o.mejorDijsktra)
					{
						mapa.remove(p.o);
						p.o.mejorDijsktra = posible;
						mapa.put(p.o, p.o);
					}
				}
			}
			System.out.println(buscar(intersecciones.get(1)));
		}
	}

}
