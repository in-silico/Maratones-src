import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class C 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static class Cancion
	{
		int id;
		int mejor;
		String nombre;
		Artista artista;
		int[] mejorMascaraP = new int[130];
		int[] mejorMascaraN = new int[130];
		ArrayList <String> sUnicos = new ArrayList <String> ();
		
		public Cancion(String n, int ii)
		{
			nombre = n;
			id = ii;
		}

		public void ordenar() 
		{
			class ComparadorCancion implements Comparator <String>
			{
				@Override
				public int compare(String o1, String o2) 
				{
					return o1.length() - o2.length();
				}
			}
			Collections.sort(sUnicos, new ComparadorCancion());
		}
	}
	static class Artista
	{
		String nombre;
		int nCanciones;
		int id;
		ArrayList <Integer> canciones = new ArrayList <Integer> ();
		
		public Artista(String n)
		{
			nombre = n;
		}
	}
	
	static HashMap <String, Integer> iniciales = new HashMap <String, Integer> ();
	static HashSet <String> repetidos = new HashSet <String> ();
	static TreeMap <String, Artista> artistasMapa = new TreeMap <String, Artista> ();
	static Cancion[] canciones;
	static Artista[] artistas;
	
	static int combinar(int[] este, int actual)
	{
		int mejor = Integer.MAX_VALUE;
		for(int i = 0; i <= artistas[actual].nCanciones; i++)
		{
			este[actual] = i;
			if(actual == artistas.length - 1)
				mejor = Math.min(mejor, intentar(este));
			else
				mejor = Math.min(mejor, combinar(este, actual + 1));
		}
		return mejor;
	}
	
	private static int intentar(int[] este)
	{
		int n = canciones.length;
		int mascara = 0;
		for(int i = 0; i < este.length; i++)
		{
			if(este[i] != artistas[i].nCanciones)
				mascara |= 1 << i;
		}
		ArrayList <Cancion> elegidas = new ArrayList <Cancion> ();
		for(int i = 0; i < este.length; i++)
		{
			if(este[i] != artistas[i].nCanciones)
			{
				Cancion actual = canciones[artistas[i].canciones.get(este[i])];
				elegidas.add(actual);
			}
		}
		boolean paila = false;
		int cuenta = 0;
		for(int i = 0; i < n; i++)
		{
			int cuentaAnterior = cuenta;
			if(elegidas.contains(canciones[i]))
				cuenta += canciones[i].mejorMascaraP[mascara];
			else
				cuenta += canciones[i].mejorMascaraN[mascara];
			if(cuenta == cuentaAnterior)
			{
				paila = true;
				break;
			}
		}
		if(paila)
			return Integer.MAX_VALUE;
		else
			return cuenta;
	}
	
	private static void agregarSubstrings2(Artista artista, Map <String, Integer> iniciales2, Set <String> repetidos2) 
	{
		String string = artista.nombre;
		int tamString = string.length();
		int id = artista.id;
		for(int i = 0; i < tamString; i++)
			for(int j = i + 1; j <= tamString; j++)
			{
				String subString = string.substring(i, j);
				if(repetidos.contains(subString))
					repetidos2.add(subString);
				if(!repetidos2.contains(subString))
				{
					if(iniciales.containsKey(subString))
						repetidos2.add(subString);
					else if(iniciales2.containsKey(subString) && iniciales2.get(subString).intValue() != id)
					{
						iniciales2.remove(subString);
						repetidos2.add(subString);
					}
					else
						iniciales2.put(subString, id);
				}
			}
	}
	
	private static void agregarSubstrings(String string, Cancion cancion, Map <String, Integer> iniciales, Set <String> repetidos) 
	{
		int tamString = string.length();
		int id = cancion.id;
		for(int i = 0; i < tamString; i++)
			for(int j = i + 1; j <= tamString; j++)
			{
				String subString = string.substring(i, j);
				if(!repetidos.contains(subString))
				{
					if(iniciales.containsKey(subString) && iniciales.get(subString).intValue() != id)
					{
						iniciales.remove(subString);
						repetidos.add(subString);
					}
					else
						iniciales.put(subString, id);
				}
			}
	}
	
	private static void intentarMascara(int mascara)
	{
		
		int n = canciones.length;
		HashMap <String, Integer> inicialesT = new HashMap <String, Integer> (iniciales.size() / 10);
		HashSet <String> repetidosT = new HashSet <String> (iniciales.size() / 10);
		int cuenta = 0;
		int mascaraC = mascara;
		while(mascaraC != 0)
		{
			if((mascaraC & 1) == 1)
				agregarSubstrings2(artistas[cuenta], inicialesT, repetidosT);
			cuenta++;
			mascaraC >>>= 1;
		}
		int[] mejores = new int[artistas.length];
		for(Map.Entry <String, Integer> e : inicialesT.entrySet())
		{
			int tam = e.getKey().length();
			int indice = e.getValue();
			if(mejores[indice] == 0)
				mejores[indice] = tam;
			else if(mejores[indice] > tam)
				mejores[indice] = tam;
		}
		for(int i = 0; i < n; i++)
		{
			int mejor = mejores[canciones[i].artista.id];
			if(mejores[canciones[i].artista.id] != 0)
			{
				canciones[i].mejorMascaraP[mascara] = mejor;
				int mejorS = 0;
				for(String s : canciones[i].sUnicos)
				{
					if(inicialesT.containsKey(s) || repetidosT.contains(s))
						continue;
					mejorS = s.length();
					break;
				}
				canciones[i].mejorMascaraN[mascara] = mejorS;
				canciones[i].mejorMascaraP[mascara] = Math.min(canciones[i].mejorMascaraP[mascara], mejorS == 0 ? Integer.MAX_VALUE : mejorS);
			}
			else
			{
				int mejorS = 0;
				for(String s : canciones[i].sUnicos)
				{
					if(inicialesT.containsKey(s) || repetidosT.contains(s))
						continue;
					mejorS = s.length();
					break;
				}
				canciones[i].mejorMascaraN[mascara] = mejorS;
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			artistasMapa.clear();
			canciones = new Cancion[n];
			for(int i = 0; i < n; i++)
			{
				canciones[i] = new Cancion(sc.next(), i);
				String artista = sc.next();
				if(!artistasMapa.containsKey(artista))
				{
					Artista nuevo = new Artista(artista);
					nuevo.canciones.add(i);
					artistasMapa.put(artista, nuevo);
				}
				else
					artistasMapa.get(artista).canciones.add(i);
				canciones[i].artista = artistasMapa.get(artista);
			}
			artistas = new Artista[artistasMapa.size()];
			int cuenta = 0;
			for(Map.Entry <String, Artista> e : artistasMapa.entrySet())
			{
				artistas[cuenta] = e.getValue();
				artistas[cuenta].id = cuenta;
				artistas[cuenta].nCanciones = artistas[cuenta++].canciones.size();
			}
			iniciales.clear();
			repetidos.clear();
			for(int i = 0; i < n; i++)
				agregarSubstrings(canciones[i].nombre, canciones[i], iniciales, repetidos);
			for(Map.Entry <String, Integer> e : iniciales.entrySet())
				canciones[e.getValue()].sUnicos.add(e.getKey());
			for(int i = 0; i < n; i++)
				canciones[i].ordenar();
			for(int i = 0; i < 1 << artistas.length; i++)
				intentarMascara(i);
			int[] este = new int[artistas.length];
			System.out.println(combinar(este, 0));
		}
	}
}
