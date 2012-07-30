import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G 
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
	
	static class Jugador implements Comparable <Jugador>
	{
		int numero;
		int apariciones;
		
		@Override
		public int compareTo(Jugador o) 
		{
			if(numero == o.numero)
				return Integer.valueOf(numero).compareTo(o.numero);
			return -Integer.valueOf(apariciones).compareTo(o.apariciones);
		}
	}
	
	static Jugador[] jugadores = new Jugador[10001];
	static ArrayList < ArrayList <Integer> > arreglos = new ArrayList < ArrayList <Integer> > ();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		for(int i = 0; i < 10001; i++)
			jugadores[i] = new Jugador();
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			int mayor = Integer.MIN_VALUE;
			arreglos.clear();
			for(int i = 0; i < n; i++)
			{
				ArrayList <Integer> actual = new ArrayList <Integer> ();
				for(int j = 0; j < m; j++)
				{
					int numero = sc.nextInt();
					actual.add(numero);
					mayor = Math.max(mayor, numero);
				}
				arreglos.add(actual);
			}
			for(int i = 0; i <= mayor; i++)
			{
				jugadores[i].numero = i;
				jugadores[i].apariciones = 0;
			}
			for(ArrayList <Integer> a : arreglos)
				for(int i : a)
					jugadores[i].apariciones++;
			Arrays.sort(jugadores, 0, mayor + 1);
			int mejor = jugadores[1].apariciones;
			for(int i = 1; i <= mayor; i++)
			{
				if(i == 10001)
					break;
				if(jugadores[i].numero == 0)
					continue;
				if(jugadores[i].apariciones != mejor)
					break;
				System.out.print(jugadores[i].numero + " ");
			}
			System.out.println();
		}
	}
}
