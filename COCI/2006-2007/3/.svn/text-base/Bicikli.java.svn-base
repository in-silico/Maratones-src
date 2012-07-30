import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Bicikli 
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
	
	static class Respuesta
	{
		long valor;
		boolean mayorNueve;
		
		public Respuesta(long valor, boolean mayorNueve) 
		{
			this.valor = valor;
			this.mayorNueve = mayorNueve;
		}
		
	}
	
	static class Nodo
	{
		int id;
		LinkedList <Integer> siguientes = new LinkedList <Integer> ();
		LinkedList <Integer> anteriores = new LinkedList <Integer> ();
	}
	static final Respuesta repetida = new Respuesta(-1, false);
	
	static Respuesta[] dp = new Respuesta[100001];
	static Nodo[] nodos = new Nodo[100000];
	
	public static Respuesta dp(int n) throws Exception
	{
		if(dp[n] == repetida)
			return new Respuesta(0, false);
		else if(dp[n] != null)
			return dp[n];
		dp[n] = repetida;
		Respuesta esta = new Respuesta(0, false);
		for(int i : nodos[n].anteriores)
		{
			Respuesta siguiente = dp(i);
			esta.mayorNueve |= siguiente.mayorNueve;
			esta.valor += siguiente.valor;
			if(esta.valor >= 1000000000)
				esta.mayorNueve = true;
			esta.valor %= 10000000000L;
		}
		return dp[n] = esta;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 1; i <= n; i++)
			nodos[i] = new Nodo();
		for(int i = 0; i < m; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			nodos[a].siguientes.add(b);
			nodos[b].anteriores.add(a);
		}
		dp[1] = new Respuesta(1, false);
		try
		{
			Respuesta res = dp(2);
			String salida = res.valor + "";
			if(res.mayorNueve)
			{
				while(salida.length() < 9)
					salida = "0" + salida;
				while(salida.length() > 9)
					salida = salida.substring(1);
			}
			System.out.println(salida);
		} 
		catch (Exception e) 
		{
			System.out.println("inf");
		}
	}

}
