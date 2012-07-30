import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class C
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static int[] costos = new int[20];
	static int[][] costo = new int[20][20];
	static int[][] visitados = new int[1 << 20][20];
	static int n;
	static int mejorCantidad;
	
	static class Estado
	{
		public Estado(int i, int i2)
		{
			visitados = i;
			donde = i2;
		}
		
		int visitados;
		int donde;
	}
	
	static class Entrada implements Comparable <Entrada>
	{
		Estado e;
		int costo;
		
		public Entrada(Estado nuevo, int i) 
		{
			e = nuevo;
			costo = i;
		}
		
		@Override
		public int compareTo(Entrada o) 
		{
			return o.costo - costo;
		}
	}
	
	public static void dijsktra()
	{
		PriorityQueue <Entrada> pq = new PriorityQueue <Entrada> ();
		for(int i = 0; i < n; i++)
		{
			Estado nuevo = new Estado(1 << i, i);
			visitados[1 << i][i] = costos[i];
			Entrada nueva = new Entrada(nuevo, costos[i]);
			if(costos[i] > 420)
				continue;
			pq.add(nueva);
		}
		while(!pq.isEmpty())
		{
			Entrada actual = pq.poll();
			if(visitados[actual.e.visitados][actual.e.donde] != actual.costo)
				continue;
			mejorCantidad = Math.max(mejorCantidad, Integer.bitCount(actual.e.visitados));
			if(mejorCantidad == n)
				return;
			int visit = actual.e.visitados;
			for(int i = 0; i < n; i++)
			{
				if((visit & 1) == 0)
				{
					if(actual.costo + costo[actual.e.donde][i] + costos[i] > 420)
						continue;
					int siguiente = actual.e.visitados | 1 << i;
					if(visitados[siguiente][i] > actual.costo + costo[actual.e.donde][i] + costos[i])
					{
						visitados[siguiente][i] = actual.costo + costo[actual.e.donde][i] + costos[i];
						Entrada nueva = new Entrada(new Estado(siguiente, i), actual.costo + costo[actual.e.donde][i] + costos[i]);
						pq.add(nueva);
					}
				}
				visit >>= 1;
			}
		}
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
				costos[i] = sc.nextInt();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					costo[i][j] = sc.nextInt();
			mejorCantidad = 0;
			int max = 1 << n; 
			for(int i = 0; i < max; i++)
				for(int j = 0; j < n; j++)
					visitados[i][j] = Integer.MAX_VALUE;
			dijsktra();
			System.out.println(mejorCantidad);
		}
	}
}
