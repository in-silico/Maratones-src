import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class D 
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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static class Entrada
	{
		int menor = Integer.MAX_VALUE;
		int mayor = Integer.MIN_VALUE;
	}
	
	static int[][] v = new int[101][2];
	static int n;
	

	static Entrada darEntrada(HashMap <Integer, Entrada> siguiente, int i) 
	{
		if(!siguiente.containsKey(i))
			siguiente.put(i, new Entrada());
		return siguiente.get(i);
	}
	

	static double distancia(long i, long j) 
	{
		return Math.sqrt(i * i + j * j);
	}
	
	static double simular()
	{
		HashMap <Integer, Entrada> mapa = new HashMap <Integer, Entrada> ();
		HashMap <Integer, Entrada> siguiente = new HashMap <Integer, Entrada> ();
		double maximo = 0;
		Entrada nueva = new Entrada();
		nueva.mayor = nueva.menor = 0;
		mapa.put(0, nueva);
		for(int i = 0; i < n; i++)
		{
			int[] actual = v[i];
			siguiente.clear();
			for(Map.Entry <Integer, Entrada> e : mapa.entrySet())
			{
				Entrada s = darEntrada(siguiente, e.getKey() + actual[0]);
				int menor = e.getValue().menor;
				int mayor = e.getValue().mayor;
				s.mayor = Math.max(s.mayor, mayor + actual[1]);
				s.mayor = Math.max(s.mayor, menor + actual[1]);
				s.menor = Math.min(s.menor, mayor + actual[1]);
				s.menor = Math.min(s.menor, menor + actual[1]);
				maximo = Math.max(maximo, distancia(e.getKey() + actual[0], s.mayor));
				maximo = Math.max(maximo, distancia(e.getKey() + actual[0], s.menor));
				s = darEntrada(siguiente, e.getKey() - actual[0]);
				s.mayor = Math.max(s.mayor, mayor - actual[1]);
				s.mayor = Math.max(s.mayor, menor - actual[1]);
				s.menor = Math.min(s.menor, mayor - actual[1]);
				s.menor = Math.min(s.menor, menor - actual[1]);
				maximo = Math.max(maximo, distancia(e.getKey() - actual[0], s.mayor));
				maximo = Math.max(maximo, distancia(e.getKey() - actual[0], s.menor));
			}
			HashMap <Integer, Entrada> temp = siguiente;
			siguiente = mapa;
			mapa = temp;
		}
		return maximo;
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
			{
				v[i][0] = sc.nextInt();
				v[i][1] = sc.nextInt();
			}
			double respuesta = simular();
			System.out.printf("Maximum distance = %.3f meters.\n", respuesta);
		}	
	}
}