import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class George 
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
	
	static class Arista
	{
		Nodo a;
		int distancia;
		int entradaGeorge = -1;
		int salidaGeorge = -1;
		
		public Arista(Nodo a, int distancia)
		{
			this.a = a;
			this.distancia = distancia;
		}
		
		
	}
	
	static int cual = 0;
	
	static class Nodo implements Comparable <Nodo>
	{
		int distancia = Integer.MAX_VALUE;
		int quien = cual++;
		ArrayList <Arista> aristas = new ArrayList <Arista> ();

		@Override
		public int compareTo(Nodo o)
		{
			if(distancia == o.distancia)
				return quien - o.quien;
			return distancia - o.distancia;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		int g = sc.nextInt();
		Nodo[] nodos = new Nodo[n + 1];
		for(int i = 1; i <= n; i++)
			nodos[i] = new Nodo();
		int[] gs = new int[g];
		for(int i = 0; i < g; i++)
			gs[i] = sc.nextInt();
		for(int i = 0; i < m; i++)
		{
			int aa = sc.nextInt();
			int bb = sc.nextInt();
			int t = sc.nextInt();
			nodos[aa].aristas.add(new Arista(nodos[bb], t));
			nodos[bb].aristas.add(new Arista(nodos[aa], t));
		}
		int actualGeorge = 0;
		for(int i = 0; i < g - 1; i++)
		{
			int actual = gs[i];
			int siguiente = gs[i + 1];
			for(Arista ar : nodos[actual].aristas)
			{
				if(ar.a == nodos[siguiente])
				{
					ar.entradaGeorge = actualGeorge;
					ar.salidaGeorge = actualGeorge + ar.distancia;
					break;
				}
			}
			for(Arista ar : nodos[siguiente].aristas)
			{
				if(ar.a == nodos[actual])
				{
					ar.entradaGeorge = actualGeorge;
					ar.salidaGeorge = actualGeorge + ar.distancia;
					actualGeorge += ar.distancia;
					break;
				}
			}
		}
		TreeSet <Nodo> t = new TreeSet <Nodo> ();
		nodos[a].distancia = k;
		t.add(nodos[a]);
		while(!t.isEmpty())
		{
			Nodo actual = t.pollFirst();
			if(actual == nodos[b])
				break;
			for(Arista ar : actual.aristas)
			{
				Nodo otro = ar.a;
				if(ar.entradaGeorge == -1 || actual.distancia > ar.salidaGeorge || actual.distancia < ar.entradaGeorge)
				{
					if(actual.distancia + ar.distancia < otro.distancia)
					{
						t.remove(otro);
						otro.distancia = actual.distancia + ar.distancia;
						t.add(otro);
					}
				}
				else
				{
					if(ar.salidaGeorge + ar.distancia < otro.distancia)
					{
						t.remove(otro);
						otro.distancia = ar.salidaGeorge + ar.distancia;
						t.add(otro);
					}
				}
			}
		}
		System.out.println(nodos[b].distancia - k);
	}

}
