import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;


public class F
{
	static int[] adjacentes = new int[21];
	static TreeSet <Integer> visitados = new TreeSet <Integer> ();
	static TreeMap <Integer, LinkedList <Integer> > anteriores = new TreeMap <Integer, LinkedList <Integer> > ();
	static TreeMap <Integer, LinkedList <Integer> > nuevos = new TreeMap <Integer, LinkedList <Integer> > ();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			int m = Integer.parseInt(pedazos[1]);
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < n; i++)
				adjacentes[i] = 0;
			for(int i = 0; i < m; i++)
			{
				pedazos = br.readLine().split(" ");
				int a = Integer.parseInt(pedazos[0]);
				int b = Integer.parseInt(pedazos[1]);
				adjacentes[a] |= 1 << b;
				adjacentes[b] |= 1 << a;
			}
			int primero = (1 << n) - 1;
			visitados.add(primero);
			anteriores.put(primero, new LinkedList <Integer> ());
			while(true)
			{
				for(Entry <Integer, LinkedList <Integer> > e : anteriores.entrySet())
				{
					int original = e.getKey();
					int este = original;
					for(int i = 0; i < n; i++)
					{
						if((este & 1) == 1)
						{
							int nuevo = 0;
							int temp = original;
							for(int j = 0; j < n; j++)
							{
								if((temp & 1) == 1 && i != j)
								{
									nuevo |= adjacentes[j];
								}
								temp >>= 1;
							}
							if(!visitados.contains(nuevo))
							{
								LinkedList <Integer> listaNueva = new LinkedList <Integer> (e.getValue());
								listaNueva.add(i);
								if(nuevos.containsKey(nuevo))
								{
									LinkedList <Integer> otra = nuevos.get(nuevo);
									boolean mejor = false;
									Iterator <Integer> it = listaNueva.iterator();
									for(int a : otra)
									{
										int b = it.next();
										if(a > b)
										{
											mejor = true;
											break;
										}
										if(b > a)
											break;
									}
									if(mejor)
									{
										nuevos.put(nuevo, listaNueva);
									}
								}
								else
								{
									nuevos.put(nuevo, listaNueva);
								}
							}
						}
						este >>= 1;
					}
				}
				anteriores.clear();
				if(nuevos.isEmpty() || nuevos.containsKey(0))
					break;
				for(int i : nuevos.keySet())
				{
					visitados.add(i);
				}
				TreeMap <Integer, LinkedList <Integer> > temp = anteriores;
				anteriores = nuevos;
				nuevos = temp;
			}
			if(nuevos.containsKey(0))
			{
				System.out.print(nuevos.get(0).size() + ":");
				for(int i : nuevos.get(0))
				{
					System.out.print(" " + i);
				}
				System.out.println();
			}
			else
			{
				System.out.println("Impossible");
			}
			nuevos.clear();
			anteriores.clear();
			visitados.clear();
			br.readLine();
		}
	}

}
