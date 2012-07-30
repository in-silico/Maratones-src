import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


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
	
	static class Estacion implements Comparable <Estacion>
	{
		int inicio, fin;
		int posicion;
		Integer mejor;
		
		public Estacion(int x, int r)
		{
			inicio = x - r;
			fin = x + r;
		}

		@Override
		public int compareTo(Estacion o) 
		{
			return inicio - o.inicio;
		}
	}

	static Estacion[] estaciones = new Estacion[10005];
	static int L, G;
	
	public static int bfs()
	{
		Estacion inicial = null;
		for(int i = 0; i < G; i++)
			if(estaciones[i].inicio <= 0)
			{
				if(inicial == null)
					inicial = estaciones[i];
				else if(estaciones[i].fin > inicial.fin)
					inicial = estaciones[i];
			}
			else
				break;
		if(inicial == null)
			return -1;
		LinkedList <Estacion> cola = new LinkedList <Estacion> ();
		cola.add(inicial);
		inicial.mejor = 1;
		while(!cola.isEmpty())
		{
			Estacion actual = cola.poll();
			if(actual.fin >= L)
				return actual.mejor;
			for(int i = actual.posicion + 1; i < G; i++)
				if(estaciones[i].inicio > actual.fin)
					break;
				else if(estaciones[i].mejor == null)
				{
					estaciones[i].mejor = actual.mejor + 1;
					cola.add(estaciones[i]);
				}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			L = sc.nextInt();
			G = sc.nextInt();
			if(L == 0 && G == 0)
				return;
			for(int i = 0; i < G; i++)
				estaciones[i] = new Estacion(sc.nextInt(), sc.nextInt());
			Arrays.sort(estaciones, 0, G);
			for(int i = 0; i < G; i++)
				estaciones[i].posicion = i;
			int res = bfs();
			System.out.println(res == -1 ? res : G - res);
		}
	}

}
