import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map.Entry;


public class F 
{
	
	static class Solucion
	{
		String solucion;
		int maximo;
		
		public Solucion(String s, int m)
		{
			solucion = s;
			maximo = m;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int m = Integer.parseInt(br.readLine());
			String[] pedazos = br.readLine().split(" ");
			TreeMap <Integer, Solucion> distancias = new TreeMap <Integer, Solucion> ();
			distancias.put(Integer.parseInt(pedazos[0]), new Solucion("U", Integer.parseInt(pedazos[0])));
			for(int j = 1; j < m; j++)
			{
				int d = Integer.parseInt(pedazos[j]);
				TreeMap <Integer, Solucion> nuevas = new TreeMap <Integer, Solucion> ();
				for(Entry <Integer, Solucion> e : distancias.entrySet())
				{
					if(e.getKey() - d >= 0)
					{
						int kNueva = e.getKey() - d;
						Solucion nueva = new Solucion(e.getValue().solucion + "D", e.getValue().maximo);
						if(nuevas.containsKey(kNueva))
						{
							if(nuevas.get(kNueva).maximo > nueva.maximo)
							{
								nuevas.put(kNueva, nueva);
							}
						}
						else
						{
							nuevas.put(kNueva, nueva);
						}
					}
					int kNueva = e.getKey() + d;
					Solucion nueva = new Solucion(e.getValue().solucion + "U", Math.max(e.getValue().maximo, kNueva));
					if(nuevas.containsKey(kNueva))
					{
						if(nuevas.get(kNueva).maximo > nueva.maximo)
						{
							nuevas.put(kNueva, nueva);
						}
					}
					else
					{
						nuevas.put(kNueva, nueva);
					}
				}
				distancias = nuevas;
			}
			if(distancias.containsKey(0))
			{
				System.out.println(distancias.get(0).solucion);
			}
			else
			{
				System.out.println("IMPOSSIBLE");
			}
		}
	}

}
