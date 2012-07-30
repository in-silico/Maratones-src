import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class F
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
	
	static int[][] palabras = new int[1000][26];
	static String[] sEntradas = new String[1000];
	static int m;
	
	static class Posible implements Comparable <Posible>
	{
		static class Entrada
		{
			int n;
			int l;
			
			public Entrada(int n2, int l2) 
			{
				n = n2;
				l = l2;
			}
		}
		
		Integer numeroVeces;
		String este = "";
		
		public int numeroVeces()
		{
			if(numeroVeces != null)
				return numeroVeces;
			numeroVeces = 0;
			for(int i = 0; i < m; i++)
			{
				boolean paila = false;
				for(Entrada e : entradas)
				{
					if(palabras[i][e.l] < e.n)
						paila = true;
				}
				if(!paila)
					numeroVeces++;
			}
			return numeroVeces;
		}
		
		public boolean existe()
		{
			String esta = toString();
			for(int i = 0; i < m; i++)
				if(sEntradas[i].equals(esta))
					return true;
			return false;
		}
		
		LinkedList <Entrada> entradas = new LinkedList <Entrada> ();
		
		public Posible(Posible posible)
		{
			for(Entrada e : posible.entradas)
				entradas.add(new Entrada(e.n, e.l));
		}

		public Posible()
		{
		}

		Posible siguiente(int a)
		{
			Posible siguiente = new Posible(this);
			for(Entrada e : siguiente.entradas)
				if(e.l == a)
				{
					e.n++;
					siguiente.este = este + ((char) ('A' + a));
					return siguiente;
				}
			siguiente.entradas.add(new Entrada(1, a));
			siguiente.este = este + ((char) ('A' + a));
			return siguiente;
		}

		Integer numeroLetras;
		public int numeroLetras()
		{
			if(numeroLetras != null)
				return numeroLetras;
			int total = 0;
			for(Entrada e : entradas)
				total += e.n;
			return numeroLetras = total;
		}
		
		@Override
		public int compareTo(Posible o)
		{
			if(o.numeroVeces() == numeroVeces())
				return numeroLetras() - o.numeroLetras();
			return o.numeroVeces() - numeroVeces();
		}
		
		@Override
		public String toString()
		{
			return este;
		}
		
		public static Posible leerPosible(String s)
		{
			Posible nuevo = new Posible();
			for(char c : s.toCharArray())
			{
				boolean esta = false;
				for(Entrada e : nuevo.entradas)
				{
					if(e.l == c - 'A')
					{
						e.n++;
						esta = true;
						break;
					}
				}
				if(!esta)
					nuevo.entradas.add(new Entrada(1, c - 'A'));
			}
			return nuevo;
		}
	}

	static PriorityQueue <Posible> pq = new PriorityQueue <Posible> ();
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int n = sc.nextInt();
			m = sc.nextInt();
			for(int i = 0; i < m; i++)
			{
				for(int j = 0; j < 26; j++)
					palabras[i][j] = 0;
				String entrada = sc.next();
				sEntradas[i] = entrada;
				for(char c : entrada.toCharArray())
					palabras[i][c - 'A']++;
			}
			pq.clear();
			Posible inicial = new Posible();
			for(int i = 0; i < 26; i++)
				pq.add(inicial.siguiente(i));
			int actuales = 0;
			ArrayList <String> todas = new ArrayList <String> ();
			while(actuales < n)
			{
				Posible actual = pq.poll();
				if(!actual.existe() && !todas.contains(actual.toString()))
				{
					todas.add(actual.toString());
					actuales++;
				}
				for(int i = 0; i < 26; i++)
					pq.add(actual.siguiente(i));
			}
			Collections.sort(todas);
			for(String s : todas)
				System.out.println(s);
		}
	}
}
