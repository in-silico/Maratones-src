import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
		
		public long nextLong()
		{
			return Long.parseLong(next());
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
	
	static class Ciudad
	{
		String tipo;
		long valor;
		
		public Ciudad(String tipo, long valor) 
		{
			this.tipo = tipo;
			this.valor = valor;
		}
	}
	
	static class Respuesta
	{
		long valor = 0;
		int numero = 0;
		
		void mejorar(Respuesta otra)
		{
			if(otra.valor > valor)
			{
				valor = otra.valor;
				numero = otra.numero;
			}
			else if(otra.valor == valor)
				numero = Math.min(numero, otra.numero);
		}
	}
	
	static Ciudad[] norte = new Ciudad[1005];
	static Ciudad[] sur = new Ciudad[1005];
	static int n, s;
	static Respuesta[][] dp = new Respuesta[1005][1005];
	
	static Respuesta dp(int a, int b)
	{
		if(a == n || b == s)
			return new Respuesta();
		if(dp[a][b] != null)
			return dp[a][b];
		Respuesta r = new Respuesta();
		if(norte[a].tipo.equals(sur[b].tipo))
		{
			if(a != n - 1 && b != s - 1)
				r.mejorar(dp(a + 1, b + 1));
			if(norte[a].valor + sur[b].valor > 0)
			{
				r.valor += norte[a].valor + sur[b].valor;
				r.numero++;
			}
		}
		if(a != n - 1)
			r.mejorar(dp(a + 1, b));
		if(b != s - 1)
			r.mejorar(dp(a, b + 1));
		return dp[a][b] = r;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int tc = sc.nextInt();
		for(int i = 0; i < 1005; i++)
			norte[i] = new Ciudad("", 0);
		for(int i = 0; i < 1005; i++)
			sur[i] = new Ciudad("", 0);
		for(int caso = 0; caso < tc; caso++)
		{
			n = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				sc.next();
				norte[i].tipo = sc.next();
				norte[i].valor = sc.nextLong();
			}
			s = sc.nextInt();
			for(int i = 0; i < s; i++)
			{
				sc.next();
				sur[i].tipo = sc.next();
				sur[i].valor = sc.nextLong();
			}
			for(int i = 0; i <= n; i++)
				for(int j = 0; j <= s; j++)
					dp[i][j] = null;
			Respuesta r = dp(0, 0);
			System.out.println(r.valor + " " + r.numero);
		}
	}
}