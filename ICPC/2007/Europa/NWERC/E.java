import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeMap;


@SuppressWarnings("unchecked")
public class E 
{
	
	static class Entrada implements Comparable <Entrada>
	{
		byte[] numeros = new byte[26];
		String cual;
		
		public Entrada(String s)
		{
			for(int i = 1; i < s.length() - 1; i++)
				numeros[s.charAt(i) - 'a']++;
			cual = s;
		}
		
		@Override
		public int compareTo(Entrada o) 
		{
			for(int i = 0; i < 26; i++)
			{
				if(numeros[i] != o.numeros[i])
					return Byte.valueOf(numeros[i]).compareTo(o.numeros[i]);
			}
			return 0;
		}
	}
	
	static TreeMap <Character, TreeMap <Character, TreeMap <Entrada, Entrada>>> mapa = new TreeMap <Character, TreeMap<Character,TreeMap<Entrada, Entrada>>> ();

	
	public static void iniciarMapa()
	{
		for(char i = 'a'; i <= 'z'; i++)
		{
			TreeMap < Character, TreeMap <Entrada, Entrada> > actual = new TreeMap<Character, TreeMap <Entrada, Entrada>> ();
			for(char j = 'a'; j <= 'z'; j++)
				actual.put(j, new TreeMap <Entrada, Entrada> ());
			mapa.put(i, actual);
		}
	}
	
	public static void limpiarMapa()
	{
		for(char i = 'a'; i <= 'z'; i++)
		{
			TreeMap < Character, TreeMap <Entrada, Entrada> > actual = mapa.get(i);
			for(char j = 'a'; j <= 'z'; j++)
				actual.get(j).clear();
		}
	}
	
	public static void agregarPalabra(String p)
	{
		Entrada nueva = new Entrada(p);
		Entrada posible = mapa.get(p.charAt(0)).get(p.charAt(p.length() - 1)).get(nueva);
		if(posible != null)
			posible.cual = null;
		else
			mapa.get(p.charAt(0)).get(p.charAt(p.length() - 1)).put(nueva, nueva);
	}
	
	public static String esPalabra(String s)
	{
		Entrada nueva = new Entrada(s);
		Entrada posible = mapa.get(s.charAt(0)).get(s.charAt(s.length() - 1)).get(nueva);
		if(posible != null)
			return posible.cual == null ? "" : posible.cual;
		return null;
	}
	
	static LinkedList <String> [][] dp = new LinkedList [1001][1001];
	static LinkedList <String> vacia = new LinkedList <String> ();
	static LinkedList <String> vaciaBien = new LinkedList <String> ();
	static String frase;
	
	public static LinkedList <String> sonPalabras(int a, int b)
	{
		if(dp[a][b] != null)
			return dp[a][b];
		int maximo = Math.min(b - a + 1, 101);
		for(int i = 1; i < maximo; i++)
		{
			String palabra = esPalabra(frase.substring(a, a + i));
			if(palabra == null)
				continue;
			LinkedList <String> palabras = sonPalabras(a + i, b);
			if(palabras != vacia)
			{
				dp[a][b] = new LinkedList <String> (palabras);
				dp[a][b].push(palabra);
				return dp[a][b];
			}
		}
		return a == b ? (dp[a][b] = vaciaBien) : (dp[a][b] = vacia);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		iniciarMapa();
		for(int i = 0; i < tc; i++)
		{
			frase = br.readLine();
			int tam = frase.length();
			for(int j = 0; j <= tam; j++)
				for(int k = j; k <= tam; k++)
					dp[j][k] = null;
			int n = Integer.parseInt(br.readLine());
			limpiarMapa();
			for(int j = 0; j < n; j++)
			{
				agregarPalabra(br.readLine());
			}
			LinkedList <String> respuesta = sonPalabras(0, frase.length());
			if(respuesta.isEmpty())
			{
				System.out.println("impossible");
				continue;
			}
			boolean ambiguo = false;
			for(String s : respuesta)
			{
				if(s.equals(""))
					ambiguo = true;
			}
			if(ambiguo)
				System.out.println("ambiguous");
			else
			{
				int a = 0;
				for(String s : respuesta)
					if(a++ != 0)
						System.out.print(" " + s);
					else
						System.out.print(s);
				System.out.println();
			}
				
		}
	}
}
