import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
	
	public static class Estado
	{
		int[] grupos = new int[tamGrupos + 1];
		int fila;
		int columna;
		
		public Estado generarClon(int grupo, int nuevaFila, int nuevaColumna)
		{
			Estado nuevo = new Estado();
			for(int i = 0; i < tamGrupos + 1; i++)
				nuevo.grupos[i] = grupos[i];
			if(grupo != -1)
				nuevo.grupos[grupo]--;
			nuevo.fila = nuevaFila;
			nuevo.columna = nuevaColumna;
			return nuevo;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + columna;
			result = prime * result + fila;
			result = prime * result + Arrays.hashCode(grupos);
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Estado other = (Estado) obj;
			if (columna != other.columna)
				return false;
			if (fila != other.fila)
				return false;
			if (!Arrays.equals(grupos, other.grupos))
				return false;
			return true;
		}
	}


	static int tamGrupos;
	static int maxFila;
	
	static HashMap <Estado, Boolean> dp = new HashMap <Estado, Boolean> ();
	
	public static boolean posible(Estado e)
	{
		if(dp.containsKey(e))
			return dp.get(e);
		boolean vacio = true;
		for(int i : e.grupos)
			if(i != 0)
				vacio = false;
		if(vacio)
		{
			dp.put(e, true);
			return true;
		}
		if(e.fila > maxFila)
			return false;
		boolean posible = false;
		for(int i = 0; i <= tamGrupos; i++)
			if(e.grupos[i] > 0 && e.fila - e.columna >= i)
					posible = posible || posible(e.generarClon(i, e.fila - e.columna == i ? e.fila + 1 : e.fila, e.fila - e.columna == i ? 0 : e.columna + i + 1));
		posible = posible || posible(e.generarClon(-1, e.fila + 1, 0));
		dp.put(e, posible);
		return posible;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			tamGrupos = sc.nextInt();
			int[] grupos = new int[tamGrupos + 1];
			int tamTotal = 0;
			for(int i = 1; i <= tamGrupos; i++)
			{
				grupos[i] = sc.nextInt();
				tamTotal += grupos[i] * i;
			}
			if(tamTotal > 78)
			{
				System.out.println("impossible");
				continue;
			}
			boolean paila = true;
			for(int i = 1; paila && i <= 12; i++)
			{
				maxFila = i;
				dp.clear();
				Estado nuevo = new Estado();
				nuevo.grupos = grupos;
				nuevo.fila = 1;
				nuevo.columna = 0;
				if(posible(nuevo))
				{
					System.out.println(i);
					paila = false;
					break;
				}
			}
			if(paila)
				System.out.println("impossible");
		}
	}
}
