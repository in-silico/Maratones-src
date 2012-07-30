import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}

	static int n;
	
	static class Respuesta
	{
		int o = Integer.MAX_VALUE;
		int e = Integer.MAX_VALUE;
		int i = Integer.MAX_VALUE;
		
		Respuesta clonar()
		{
			Respuesta nueva = new Respuesta();
			nueva.o = o;
			nueva.i = i;
			nueva.e = e;
			return nueva;
		}
	}
	
	static final int ODD = 0;
	static final int EVEN = 1;
	static final int IMAGINARY = 2;
	
	static Respuesta[][] dp = new Respuesta[10100][3];
	@SuppressWarnings("unchecked")
	static ArrayList <Integer>[] factores = new ArrayList[10100];
	
	public static Respuesta dp(int numero, int anterior)
	{
		if(dp[numero][anterior] != null)
			return dp[numero][anterior];
		if(numero == 1)
		{
			Respuesta r = new Respuesta();
			if(anterior == ODD)
				r.o = 1;
			else if(anterior == EVEN)
				r.e = 1;
			else if(anterior == IMAGINARY)
				r.i = 1;
			return dp[numero][anterior] = r.clonar();
		}
		Respuesta mejor = null;
		for(int i : factores[numero])
		{
			Respuesta r = dp(numero / i, (anterior + 1) % 3);
			if(anterior == ODD)
			{
				if(mejor == null || r.e <= mejor.e)
					mejor = r.clonar();
			}
			else if(anterior == EVEN)
			{
				if(mejor == null || r.i <= mejor.i)
					mejor = r.clonar();
			}
			else if(anterior == IMAGINARY)
			{
				if(mejor == null || r.o <= mejor.o)
					mejor = r.clonar();
			}
		}
		if(primos[numero])
		{
			Respuesta r = dp(numero + 1, (anterior + 1) % 3);
			if(anterior == ODD)
			{
				if(mejor == null || r.e < mejor.e)
					mejor = r.clonar();
			}
			else if(anterior == EVEN)
			{
				if(mejor == null || r.i < mejor.i)
					mejor = r.clonar();
			}
			else if(anterior == IMAGINARY)
			{
				if(mejor == null || r.o < mejor.o)
					mejor = r.clonar();
			}
		}
		if(anterior == ODD)
			mejor.o = Math.min(numero, mejor.o);
		else if(anterior == EVEN)
			mejor.e = Math.min(numero, mejor.e);
		else if(anterior == IMAGINARY)
			mejor.i = Math.min(numero, mejor.i);
		return dp[numero][anterior] = mejor.clonar();
	}
	

	static boolean[] primos = new boolean[10100];
	
	public static void main(String[] args)
	{
		for(int i = 2; i < 10100; i++)
		{
			for(int j = 2; j < i; j++)
				if((i % j) == 0)
					primos[i] = true;
		}
		for(int i = 2; i < 10100; i++)
		{
			ArrayList <Integer> fact = new ArrayList <Integer> ();
			for(int j = 2; j <= i; j++)
			{
				if((!primos[j]) && ((i % j) == 0))
					fact.add(j);
			}
			factores[i] = fact;
		}
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int nn = sc.nextInt();
			int resO = 0;
			int resE = 0;
			int resI = 0;
			for(int i = 0; i < nn; i++)
			{
				char c = sc.next().charAt(0);
				int val = 0;
				if(c == 'O')
					val = IMAGINARY;
				else if(c == 'E')
					val = ODD;
				else
					val = EVEN;
				n = sc.nextInt();
				for(int j = 0; j < 10100; j++)
					for(int k = 0; k < 3; k++)
						dp[j][k] = null;
				Respuesta r = dp(n, val);
				if(r.o == Integer.MAX_VALUE)
					resO += n;
				else
					resO += r.o;
				if(r.e == Integer.MAX_VALUE)
					resE += n;
				else
					resE += r.e;
				if(r.i == Integer.MAX_VALUE)
					resI += n;
				else
					resI += r.i;
			}
			System.out.println(resO + " " + resE + " " + resI);
		}
	}
}
