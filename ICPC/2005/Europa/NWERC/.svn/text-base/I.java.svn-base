import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class I 
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
	
	static class Entrada implements Comparable <Entrada>
	{
		int indice;
		int cuantos;
		int tiempo;
		
		public Entrada(int ii, int t, int cc)
		{
			indice = ii;
			cuantos = cc;
			tiempo = t;
		}

		@Override
		public int compareTo(Entrada o) 
		{
			return tiempo - o.tiempo;
		}
		
		@Override
		public String toString() 
		{
			return tiempo + " " + cuantos;
		}
	}
	
	static int f;
	
	public static int contar(int piso, boolean tieneCaja, int cuantos)
	{
		if(tieneCaja)
			return f - piso + contar(f, false, cuantos);
		if(cuantos == 0)
			return 0;
		if(piso != f)
			return piso + f + contar(f, tieneCaja, cuantos - 1);
		return cuantos * f * 2;
	}
	
	static int[] piso = new int[1001];
	static boolean[] caja = new boolean[1001];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int nCasos = sc.nextInt();
		for(int caso = 0; caso < nCasos; caso++)
		{
			int n = sc.nextInt();
			f = sc.nextInt();
			int b = sc.nextInt();
			PriorityQueue <Entrada> pq = new PriorityQueue <Entrada> ();
			int minimo = (b / n) - 2;
			if(minimo < 0)
				minimo = 0;
			for(int i = 0; i < n; i++)
			{
				piso[i] = sc.nextInt();
				caja[i] = sc.nextInt() == 1;
			}
			for(int i = 0; i < n; i++)
				pq.add(new Entrada(i, contar(piso[i], caja[i], minimo), minimo));
			int cuenta = minimo * n;
			while(cuenta != b)
			{
				Entrada actual = pq.poll();
				pq.add(new Entrada(actual.indice, contar(piso[actual.indice], caja[actual.indice], actual.cuantos + 1), actual.cuantos + 1));
				cuenta++;
			}
			while(pq.size() != 1)
				pq.poll();
			System.out.println(pq.poll().tiempo);
		}
	}
}