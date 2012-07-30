import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class H
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
	
	static class Permutacion
	{
		int indices[];
		
		Permutacion(int tam)
		{
			indices = new int[tam];
		}
	}
	
	static class Entrada
	{
		String actual;
		
		public Entrada(int tamano)
		{
			actual = "";
			for(int i = 0; i < tamano; i++)
				actual += ((char) ('A' + i));
		}
		
		public Entrada(String s)
		{
			actual = s;
		}
		
		public static Permutacion generarInicial(int tam, int veces)
		{
			class Letra
			{
				char l;
				boolean veces = false;
				
				Letra(char ll)
				{
					l = ll;
				}
			}
			LinkedList <Letra> letras = new LinkedList <Letra> ();
			for(int i = 0; i < tam; i++)
				letras.add(new Letra(((char) ('A' + i))));
			for(int i = 0; i < veces; i++)
			{
				ListIterator <Letra> it = letras.listIterator();
				while(it.next().veces);
				Letra l = it.previous();
				it.remove();
				for(int j = 0; j < i + 1; j++)
				{
					if(!it.hasNext())
						it = letras.listIterator();
					else
						it.next();
				}
				it.add(l);
				l.veces = true;
			}
			Permutacion nueva = new Permutacion(tam);
			for(int i = 0; i < tam; i++)
			{
				Letra l = letras.get(i);
				char c = l.l;
				int le = c - 'A';
				nueva.indices[le] = i;
			}
			return nueva;
		}
		
		public Permutacion generarPermutacion()
		{
			Permutacion nueva = new Permutacion(actual.length());
			for(int i = 0; i < actual.length(); i++)
			{
				int le = actual.charAt(i) - 'A';
				nueva.indices[le] = i;
			}
			return nueva;
		}
		
		public void aplicarPermutacion(Permutacion p)
		{
			char[] salida = new char[actual.length()];
			for(int i = 0; i < salida.length; i++)
				salida[p.indices[i]] = actual.charAt(i);
			actual = new String(salida);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int numero = 1;
		while(true)
		{
			int s = sc.nextInt();
			if(s == 0)
				return;
			String entrada = sc.next();
			ArrayList <Integer> pedazos = new ArrayList <Integer> ();
			int sss = s;
			if(entrada.length() == 1)
			{
				System.out.println(numero++ + ". " + entrada);
				continue;
			}
			while(sss != 0)
			{
				pedazos.add(sss % entrada.length());
				sss /= entrada.length();
			}
			ArrayList <Permutacion> permutaciones = new ArrayList <Permutacion> ();
			permutaciones.add(null);
			permutaciones.add(Entrada.generarInicial(entrada.length(), entrada.length()));
			for(int i = 2; i < pedazos.size(); i++)
			{
				Permutacion anterior = permutaciones.get(permutaciones.size() - 1);
				Entrada p = new Entrada(entrada.length());
				for(int j = 0; j < entrada.length(); j++)
					p.aplicarPermutacion(anterior);
				permutaciones.add(p.generarPermutacion());
			}
			Entrada actual = new Entrada(entrada);
			for(int i = pedazos.size() - 1; i >= 1; i--)
			{
				for(int j = 0; j < pedazos.get(i); j++)
					actual.aplicarPermutacion(permutaciones.get(i));
			}
			Permutacion ultima = Entrada.generarInicial(entrada.length(), pedazos.get(0));
			actual.aplicarPermutacion(ultima);
			System.out.println(numero++ + ". " + actual.actual);
		}
	}
}