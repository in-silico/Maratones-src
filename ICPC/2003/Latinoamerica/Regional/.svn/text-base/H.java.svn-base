import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
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
	
	static class Tile implements Comparable <Tile>
	{
		int a, b;

		public Tile(int aa, int bb)
		{
			a = aa;
			b = bb;
		}
		
		@Override
		public int compareTo(Tile o) 
		{
			int suma = a + b;
			int sumaOtro = o.a + o.b;
			if(suma != sumaOtro)
				return Integer.valueOf(suma).compareTo(sumaOtro);
			return Integer.valueOf(Math.min(a, b)).compareTo(Math.min(o.a, o.b));
		}
	}
	
	static int sumaObjetivo, n, eliminado;
	
	static HashMap <Long, Boolean> mapa = new HashMap <Long, Boolean> ();
	
	static Tile[] tiles = new Tile[400];
	
	public static boolean dp(int tile, int suma) 
	{
		if(tile == eliminado)
			return dp(tile + 1, suma);
		long res = tile;
		res <<= 32;
		res |= suma;
		Boolean posible = mapa.get(res);
		if(posible != null)
			return posible;
		if(tile == n)
		{
			mapa.put(res, suma == sumaObjetivo);
			return suma == sumaObjetivo;
		}
		if(dp(tile + 1, suma + tiles[tile].a) || dp(tile + 1, suma + tiles[tile].b))
		{			
			mapa.put(res, true);
			return true;
		}
		else
		{
			mapa.put(res, false);
			return false;
		}
	}
	
	public static boolean intentar(int suma)
	{
		if(suma % 2 != 0)
			return false;
		mapa.clear();
		sumaObjetivo = suma / 2;
		return dp(0, 0);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				tiles[i] = new Tile(sc.nextInt(), sc.nextInt());
			int sumaTotal = 0;
			for(int i = 0; i < n; i++)
			{
				sumaTotal += tiles[i].a;
				sumaTotal += tiles[i].b;
			}
			eliminado = -1;
			Arrays.sort(tiles, 0, n);
			if(intentar(sumaTotal))
				System.out.println(sumaTotal / 2 + " discard none");
			else
			{
				if(n == 1)
				{
					System.out.println("impossible");
				}
				else
				{
					boolean termino = false;
					for(int i = 0; i < n; i++)
					{
						int estaSuma = tiles[i].a + tiles[i].b;
						eliminado = i;
						if(intentar(sumaTotal - estaSuma))
						{
							termino = true;
							System.out.println(((sumaTotal - estaSuma) / 2) + " discard " + Math.min(tiles[i].a, tiles[i].b) + " " + Math.max(tiles[i].a, tiles[i].b));
							break;
						}
					}
					if(!termino)
						System.out.println("impossible");
				}
			}
		}
	}
}