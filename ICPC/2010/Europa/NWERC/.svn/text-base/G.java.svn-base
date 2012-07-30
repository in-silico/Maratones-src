import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class G
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			try 
			{
				br = new BufferedReader(new FileReader("G.in"));
			}
			catch (FileNotFoundException e) 
			{
			}
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
	
	static char[][] land = new char[1010][];
	static int[][] cols = new int[1010][1010];
	static int[][] mejor = new int[1010][1010];
	static int ultimoSwamp = 0;
	static TreeMap <Integer, Integer> mapa = new TreeMap <Integer, Integer> ();
	static TreeMap <Integer, Integer> mapaFila = new TreeMap <Integer, Integer> ();
	
	private static int solucionar(int fila, int columna)
	{
		if(land[fila][columna] == '#')
		{
			mapaFila.clear();
			ultimoSwamp = columna + 1;
			return 0;
		}
		int filaActual = cols[fila][columna];
		mapaFila.subMap(-1, filaActual).clear();
		mapaFila.put(filaActual, columna);
		if(columna == 0)
			return mejor[fila][columna] = ((fila - filaActual + 1) << 1) + 2;
		Entry <Integer, Integer> e = mapaFila.higherEntry(filaActual);
		Integer columnaAnterior = e == null ? null : e.getValue();
		if(columnaAnterior == null)
			return mejor[fila][columna] = ((fila - filaActual + 1) << 1) + ((columna - ultimoSwamp + 1) << 1);
		int posible = ((fila - filaActual + 1) << 1) + ((columna - columnaAnterior) << 1);
		int anterior = mejor[fila][columnaAnterior] + ((columna - columnaAnterior) << 1);
		return mejor[fila][columna] = Math.max(posible, anterior);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		long inicial = System.currentTimeMillis();
		System.setOut(new PrintStream(new File("G.sol")));
		Scanner sc = new Scanner();
		int ntc = sc.nextInt();
		for(int aa = 0; aa < ntc; aa++)
		{
			mapa.clear();
			int n = sc.nextInt();
			int m = sc.nextInt();
			for(int i = 0; i < n; i++)
				land[i] = sc.next().toCharArray();
			for(int i = 0; i < m; i++)
			{
				int anterior = 0;
				for(int j = 0; j < n; j++)
				{
					if(land[j][i] == '#')
					{
						anterior = j + 1;
						cols[j][i] = j;
					}
					else
						cols[j][i] = anterior;
				}
			}
			for(int i = 0; i < n; i++)
			{
				mapaFila.clear();
				ultimoSwamp = 0;
				for(int j = 0; j < m; j++)
				{
					int respuesta = solucionar(i, j);
					if(!mapa.containsKey(respuesta))
						mapa.put(respuesta, 0);
					mapa.put(respuesta, mapa.get(respuesta) + 1);
				}
			}
			for(Entry <Integer, Integer> e : mapa.entrySet())
			{
				if(e.getKey() != 0)
					System.out.println(e.getValue() + " x " + e.getKey());
			}
			if(aa == ntc - 1)
				System.out.println("Funciono en: " + (System.currentTimeMillis() - inicial) + " ms");
		}
	}
}
