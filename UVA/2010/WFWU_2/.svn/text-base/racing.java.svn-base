import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class racing 
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
	
	static class Carro implements Comparable <Carro>
	{
		int anteriores;
		int siguientes;
		int cuantosReal;
		int cuantos = 0;
		
		public Carro(int a, int s)
		{
			anteriores = a;
			siguientes = s;
		}

		@Override
		public int compareTo(Carro o) 
		{
			if(siguientes == o.siguientes)
				return anteriores - o.anteriores;
			return siguientes - o.siguientes;
		}
	}
	
	static TreeMap <Carro, Carro> todos = new TreeMap <Carro, Carro> ();
	
	static Carro temp = new Carro(0, 0);
	
	public static Carro darCarro(int siguientes, int anteriores)
	{
		temp.anteriores = anteriores;
		temp.siguientes = siguientes;
		if(!todos.containsKey(temp))
		{
			Carro nuevo = new Carro(anteriores, siguientes);
			todos.put(nuevo, nuevo);
		}
		return todos.get(temp);
	}
	
	static int n;
	static Carro[] carros = new Carro[1000];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int caso = 1;
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			todos.clear();
			for(int i = 0; i < n; i++)
				darCarro(sc.nextInt(), sc.nextInt()).cuantos++;
			int i = 0;
			int nTemp = 0;
			int nAnterior = n;
			for(Carro c : todos.keySet())
			{
				if(c.anteriores + c.siguientes >= n)
					nTemp += c.cuantos;
				else
				{
					c.cuantosReal = n - c.anteriores - c.siguientes;
					if(c.cuantos > c.cuantosReal)
					{
						nTemp += c.cuantos - c.cuantosReal;
						c.cuantos = c.cuantosReal;
					}
					carros[i++] = c;
				}
			}
			n = i;
			for(int j = 0; j < n; j++)
				for(int k = 0; k < n; k++)
					dp[j][k] = -1;
			int resultado = dp(0, -1);
			if(resultado >= 1000000)
				System.out.println("Case " + caso++ + ": " + nAnterior);
			else
				System.out.println("Case " + caso++ + ": " + (nTemp + resultado));
		}
	}

	static int[][] dp = new int[1000][1000];
	
	private static int dp(int i, int j) 
	{
		if(i == n)
			return 0;
		if(dp[i][j + 1] != -1)
			return dp[i][j + 1];
		Carro actual = carros[i];
		if(j == -1)
		{
			int mejor = 1000000;
			mejor = Math.min(mejor, dp(i + 1, i));
			mejor = Math.min(mejor, actual.cuantos + dp(i + 1, j));
			return dp[i][j + 1] = mejor;
		}
		else
		{
			int mejor = 1000000;
			Carro anterior = carros[j];
			int cuenta1 = actual.siguientes - (anterior.siguientes + anterior.cuantosReal);
			int cuenta2 = anterior.anteriores - (actual.anteriores + actual.cuantosReal);
			if(cuenta1 >= 0 && cuenta2 >= 0 && cuenta1 == cuenta2)
				mejor = Math.min(mejor, dp(i + 1, i));
			mejor = Math.min(mejor, actual.cuantos + dp(i + 1, j));
			return dp[i][j + 1] = mejor;
		}
	}
}
