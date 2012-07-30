import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;


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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	

	private static void bt(TreeMap <Integer, Integer> actuales, int i) 
	{
		if(actuales.size() > mejor)
			return;
		if(i == -1)
		{
			int s = 0;
			for(int j : actuales.keySet())
				s += j;
			if(actuales.size() < mejor || (actuales.size() == mejor && s < suma))
			{
				mejor = actuales.size();
				respuesta = "";
				suma = 0;
				for(int j : actuales.keySet())
				{
					respuesta += " " + j;
					suma += j;
				}
				respuesta = respuesta.substring(1);
			}
			return;
		}
		int valorActual = valores[i];
		int j = -1;
		while(true)
		{
			Integer posible = actuales.ceilingKey(j);
			if(posible == null)
				break;
			j = posible;
			if(actuales.containsKey(j - valorActual))
			{
				bt(actuales, i - 1);
				return;
			}
			j++;
		}
		actuales.put(valorActual, valorActual);
		bt(actuales, i - 1);
		actuales.remove(valorActual);
		j = -1;
		while(true)
		{
			Integer posible = actuales.ceilingKey(j);
			if(posible == null)
				break;
			j = posible;
			if(j > valorActual)
			{
				actuales.put(j - valorActual, j - valorActual);
				bt(actuales, i - 1);
				actuales.remove(j - valorActual);
			}
			j++;
		}
	}

	static int[] valores = new int[50];
	static int mejor;
	static int suma;
	static String respuesta;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int caso = 1;
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				valores[i] = sc.nextInt();
			Arrays.sort(valores, 0, n);
			TreeMap <Integer, Integer> actuales = new TreeMap <Integer, Integer> ();
			actuales.put(0, 0);
			actuales.put(valores[n - 1], valores[n - 1]);
			mejor = 7;
			suma = Integer.MAX_VALUE;
			respuesta = null;
			bt(actuales, n - 1);
			System.out.println("Case " + caso++ + ":");
			System.out.println(mejor);
			System.out.println(respuesta);
			if(respuesta == null)
				throw(new RuntimeException());
		}
	}
}
