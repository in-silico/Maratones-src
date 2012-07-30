import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class H 
{
	static HashMap <String, ArrayList <Integer>> prefijos = new HashMap <String, ArrayList <Integer>> ();
	static ArrayList <String> palabras = new ArrayList <String> (50001);
	static TreeSet <String> palabrasM = new TreeSet <String> ();
	
	static class Nodo implements Comparable <Nodo>
	{
		String palabra;
		int distancia;
		String ruta;
		
		public Nodo(String p, int d)
		{
			palabra = p;
			distancia = d;
			ruta = p;
		}

		@Override
		public int compareTo(Nodo o) 
		{
			if(distancia == o.distancia)
				return palabra.compareTo(o.palabra);
			return Integer.valueOf(distancia).compareTo(o.distancia);
		}
	}

	static Nodo[] nodos = new Nodo[50001];
	static String[][] q = new String[27][27];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			palabras.clear();
			prefijos.clear();
			palabrasM.clear();
			for(int i = 0; i < n; i++)
			{
				String a = br.readLine().trim();
				if(palabrasM.contains(a))
					continue;
				palabras.add(a);
				palabrasM.add(a);
			}
			int pos = 0;
			for(int i = 0; i < 27; i++)
				for(int j = 0; j < 27; j++)
					q[i][j] = null;
			int d = Integer.parseInt(br.readLine());
			for(int i = 0; i < d; i++)
			{
				prefijos.clear();
				pos = 0;
				for(String s : palabras)
				{
					for(int j = 1; j <= s.length(); j++)
					{
						String este = s.substring(0, j);
						if(prefijos.containsKey(este))
							prefijos.get(este).add(pos);
						else
						{
							ArrayList <Integer> nuevo = new ArrayList <Integer> ();
							nuevo.add(pos);
							prefijos.put(este, nuevo);
						}
					}
					pos++;
				}
				System.out.print(caso + "." + (i + 1) + " ");
				String linea = br.readLine();
				char a = linea.charAt(0);
				char z = linea.charAt(2);
				if(q[a - 'a'][z - 'a'] != null)
				{
					System.out.println(q[a - 'a'][z - 'a']);
					continue;
				}
				TreeMap <Nodo, Nodo> pq = new TreeMap <Nodo, Nodo> ();
				pos = 0;
				for(String s : palabras)
				{
					Nodo nuevo = new Nodo(s, 50000000);
					if(s.charAt(0) == a)
					{
						nuevo.distancia = s.length();
						pq.put(nuevo, nuevo);
					}
					nodos[pos] = nuevo;
					pos++;
				}
				Nodo actual = null;
				while(!pq.isEmpty())
				{
					actual = pq.pollFirstEntry().getKey();
					if(actual.distancia >= 50000000)
						break;
					if(actual.palabra.charAt(actual.palabra.length() - 1) == z)
						break;
					for(int j = 1; j <= actual.palabra.length(); j++)
					{
						String este = actual.palabra.substring(0, j);
						ArrayList <Integer> num = prefijos.get(este);
						for(int ff : num)
						{
							if(nodos[ff].palabra.equals(actual.palabra))
							{
								num.remove(new Integer(ff));
								break;
							}
						}
					}
					String s = actual.palabra;
					for(int j = 1; j < s.length() - 1; j++)
					{
						String vecino = s.substring(j, s.length());
						if(prefijos.containsKey(vecino))
						{
							for(int p : prefijos.get(vecino))
							{
								if(pq.containsKey(nodos[p]) && nodos[p].distancia > actual.distancia + nodos[p].palabra.length() - (s.length() - j))
								{
									pq.remove(nodos[p]);
									nodos[p].distancia = actual.distancia + nodos[p].palabra.length() - (s.length() - j);
									nodos[p].ruta = actual.ruta + " " + nodos[p].palabra;
									pq.put(nodos[p], nodos[p]);
								}
								else if(!pq.containsKey(nodos[p]))
								{
									nodos[p].distancia = actual.distancia + nodos[p].palabra.length() - (s.length() - j);
									nodos[p].ruta = actual.ruta + " " + nodos[p].palabra;
									pq.put(nodos[p], nodos[p]);
								}
							}
						}
					}
				}
				if(actual != null && actual.palabra.charAt(actual.palabra.length() - 1) == z)
					q[a - 'a'][z - 'a'] = actual.distancia + " " + actual.ruta;
				else
					q[a - 'a'][z - 'a'] = "0";
				System.out.println(q[a - 'a'][z - 'a']);
			}
			caso++;
		}
	}

}
