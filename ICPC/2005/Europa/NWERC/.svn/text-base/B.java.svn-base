import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class B 
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
	
	static class Ingrediente
	{
		String nombre;
		int producto;
		int minimo = Integer.MAX_VALUE;
		int maximo = Integer.MIN_VALUE;
		boolean determinado;
		
		public Ingrediente(String n, int pr)
		{
			nombre = n;
			producto = pr;
		}
		
		public Ingrediente(String n, int pr, int p)
		{
			nombre = n;
			producto = pr;
			maximo = minimo = p;
			determinado = true;
		}

		public boolean cumple(int i) 
		{
			return i >= minimo && i <= maximo;
		}
	}
	
	static class Producto
	{
		String nombre;
		Ingrediente[] ingredientes;
		TreeMap <String, Ingrediente> mapa = new TreeMap <String, Ingrediente> ();
		
		public Producto(String no, int n)
		{
			nombre = no;
			ingredientes = new Ingrediente[n];
		}
	}
	
	static class Menor implements Comparator <Ingrediente>
	{
		@Override
		public int compare(Ingrediente o1, Ingrediente o2) 
		{
			if(o1.minimo == o2.minimo)
				return o1.maximo - o2.maximo;
			return o1.minimo - o2.minimo;
		}	
	}
	
	static class Mayor implements Comparator <Ingrediente>
	{
		@Override
		public int compare(Ingrediente o1, Ingrediente o2) 
		{
			if(o1.maximo == o2.maximo)
				return o1.minimo - o2.minimo;
			return o1.maximo - o2.maximo;
		}	
	}
	
	static Producto actual;
	
	static Boolean[][][] dp = new Boolean[110][110][110];

	static boolean posible(int ingrediente, int anterior, int acumulado)
	{
		if(acumulado > 100)
			return false;
		if(dp[ingrediente][anterior][acumulado] != null)
			return dp[ingrediente][anterior][acumulado];
		if(ingrediente == actual.ingredientes.length)
			return dp[ingrediente][anterior][acumulado] = acumulado == 100;
		if(actual.ingredientes[ingrediente].determinado)
			if(actual.ingredientes[ingrediente].maximo > anterior)
				return dp[ingrediente][anterior][acumulado] = false;
			else
				return dp[ingrediente][anterior][acumulado] = posible(ingrediente + 1, actual.ingredientes[ingrediente].maximo, acumulado + actual.ingredientes[ingrediente].maximo);
		boolean posible = false;
		for(int i = 1; i <= anterior; i++)
		{
			boolean puede = posible(ingrediente + 1, i, acumulado + i);
			posible |= puede;
			if(puede)
			{
				actual.ingredientes[ingrediente].minimo = Math.min(actual.ingredientes[ingrediente].minimo, i);
				actual.ingredientes[ingrediente].maximo = Math.max(actual.ingredientes[ingrediente].maximo, i);
			}
		}
		return dp[ingrediente][anterior][acumulado] = posible;
	}
	
	static Producto[] productos = new Producto[20];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int p = sc.nextInt();
			if(p == 0)
				return;
			for(int i = 0; i < p; i++)
			{
				String nombre = sc.nextLine();
				int numero = sc.nextInt();
				actual = new Producto(nombre, numero);
				for(int j = 0; j < numero; j++)
				{
					String[] pedazos = sc.nextLine().split("\\s+");
					String nActual = pedazos[0];
					String posible = pedazos.length == 1 ? null : pedazos[1];
					if(posible == null)
						actual.ingredientes[j] = new Ingrediente(nActual, i);
					else
						actual.ingredientes[j] = new Ingrediente(nActual, i, Integer.parseInt(posible.substring(0, posible.length() - 1)));
				}
				productos[i] = actual;
				for(int a = 0; a < 110; a++)
					for(int j = 0; j < 110; j++)
						for(int k = 0; k < 110; k++)
							dp[a][j][k] = null;
				posible(0, 100, 0);
				for(int j = 0; j < numero; j++)
					actual.mapa.put(actual.ingredientes[j].nombre, actual.ingredientes[j]);
			}
			int q = sc.nextInt();
			TreeSet <Integer> resultado = new TreeSet <Integer> ();
			for(int query = 0; query < q; query++)
			{
				String cual = sc.next();
				boolean most = cual.equals("most");
				String ingrediente = sc.next();
				ArrayList <Ingrediente> enOrden = new ArrayList <Ingrediente> ();
				for(int i = 0; i < p; i++)
					if(productos[i].mapa.containsKey(ingrediente))
						enOrden.add(productos[i].mapa.get(ingrediente));
					else
						enOrden.add(new Ingrediente(ingrediente, i, 0));
				if(most)
				{
					Collections.sort(enOrden, new Menor());
					Ingrediente ultimo = enOrden.get(enOrden.size() - 1);
					resultado.clear();
					for(int i = ultimo.minimo; i <= ultimo.maximo; i++)
					{
						for(Ingrediente in : enOrden)
							if(in.cumple(i))
								resultado.add(in.producto);
					}
					System.out.print(productos[resultado.pollFirst()].nombre);
					while(!resultado.isEmpty())
						System.out.print(" " + productos[resultado.pollFirst()].nombre);
					System.out.println();
				}
				else
				{
					Collections.sort(enOrden, new Mayor());
					Ingrediente ultimo = enOrden.get(0);
					resultado.clear();
					for(int i = ultimo.minimo; i <= ultimo.maximo; i++)
					{
						for(Ingrediente in : enOrden)
							if(in.cumple(i))
								resultado.add(in.producto);
					}
					System.out.print(productos[resultado.pollFirst()].nombre);
					while(!resultado.isEmpty())
						System.out.print(" " + productos[resultado.pollFirst()].nombre);
					System.out.println();
				}
			}
		}
	}
}