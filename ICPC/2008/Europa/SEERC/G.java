import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
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
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
		
		public long nextLong()
		{
			return Long.parseLong(next());
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
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static long mayor = 1000000000001L;
	static TreeMap <Long, Long> l = new TreeMap <Long, Long> ();
	static long[] luckys = new long[8190];
	static long[] superLuckysA;
	static HashMap <Long, Long> superLuckys = new HashMap <Long, Long> ();
	
	public static void generarLucky(char[] arreglo, int actual)
	{
		if(actual == -1)
		{
			l.put(Long.parseLong(new String(arreglo)), 0L);
			return;
		}
		arreglo[actual] = '4';
		generarLucky(arreglo, actual - 1);
		arreglo[actual] = '7';
		generarLucky(arreglo, actual - 1);
	}
	
	static long[] acumuladoStack = new long[8191];
	
	public static void generar(int actual)
	{
		if(acumuladoStack[actual] <= 0)
			return;
		if(actual == 8190)
			return;
		if(acumuladoStack[actual] * luckys[actual] < mayor)
		{
			acumuladoStack[actual + 1] = acumuladoStack[actual];
			generar(actual + 1);
		}
		long este = luckys[actual];
		long acum = acumuladoStack[actual] * este;
		while(acum >= este && acum > 0 && acum < mayor)
		{
			superLuckys.put(acum, 0L);
			if(actual <= 125)
			{
				acumuladoStack[actual + 1] = acum;
				generar(actual + 1);
			}
			acum *= este;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		for(int i = 1; i <= 12; i++)
			generarLucky(new char[i], i - 1);
		int ti = 0;
		for(Long a : l.keySet())
			luckys[ti++] = a;
		acumuladoStack[0] = 1;
		generar(0);
		l.clear();
		ti = 0;
		superLuckysA = new long[superLuckys.size()];
		for(long sl : superLuckys.keySet())
			superLuckysA[ti++] = sl;
		Arrays.sort(superLuckysA);
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 0; caso < t; caso++)
		{
			long l = sc.nextLong();
			long h = sc.nextLong();
			int il = Arrays.binarySearch(superLuckysA, l);
			if(il < 0)
			{
				il++;
				il = -il;
			}
			int ih = Arrays.binarySearch(superLuckysA, h);
			if(ih < 0)
			{
				ih++;
				ih = -ih;
				ih--;
			}
			System.out.println((ih + 1) - il);
		}
	}
}