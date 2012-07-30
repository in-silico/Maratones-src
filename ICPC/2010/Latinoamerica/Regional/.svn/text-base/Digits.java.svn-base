import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Digits 
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
	
	static class SuperWriter
	{
		char[] buffer;
		OutputStreamWriter os;
		int pos;
		
		public SuperWriter()
		{
			buffer = new char[6000001];
			os = new OutputStreamWriter(System.out);
			pos = 0;
		}
		
		public void println(String s)
		{
			print(s);
			print("\n");
		}
		
		public void print(String s)
		{
			int tam = s.length();
			if(pos + tam > buffer.length)
				tam = buffer.length - pos;
			s.getChars(0, tam, buffer, pos);
			pos += tam;
			if(pos == buffer.length)
			{
				try
				{
					os.write(buffer);
					pos = 0;
					print(s.substring(tam));
				}
				catch(Exception e)
				{
					throw(new RuntimeException());
				}
			}
		}

		public void flush() 
		{
			try 
			{
				os.write(buffer, 0, pos);
				pos = 0;
				os.flush();
			}
			catch (IOException e) 
			{
				throw(new RuntimeException());
			}
		}
	}
	
	public static void sumar(int[] a, int [] b)
	{
		for(int i = 0; i < 10; i++)
			a[i] += b[i];
	}
	
	public static void restar(int[] a, int [] b)
	{
		for(int i = 0; i < 10; i++)
			a[i] -= b[i];
	}
	
	static int[] diezA = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
	static int[][][] dp = new int[10][10][];
	static int[][][] dpCero = new int[10][10][];
	static int[][][] dpCeroPor = new int[10][10][];
	
	
	public static int[] solucion(String entrada)
	{
		int actual = entrada.length() - 1;
		int[] solucion = new int[10];
		char[] todos = entrada.toCharArray();
		for(int i = 0; i < todos.length; i++)
		{
			if(actual == 0)
				for(int j = 0; j < (todos[i] - '0'); j++)
					solucion[j]++;
			else if(i == 0)
				sumar(solucion, dp(todos[i] - '0', actual));
			else
				sumar(solucion, dpCeroPor(todos[i] - '0', actual));
			for(int j = 0; j < i; j++)
				solucion[todos[j] - '0'] += diezA[entrada.length() - 1 - i] * (todos[i] - '0');
			actual--;
		}
		return solucion;
	}
	
	private static int[] dpCeroPor(int n, int m)
	{
		if(dpCeroPor[n][m] != null)
			return dpCeroPor[n][m];
		int[] respuesta = new int[10];
		if(n == 0)
			return dpCeroPor[n][m] = respuesta;
		sumar(respuesta, dpCero(m, 1));
		for(int i = 1; i < n; i++)
		{
			respuesta[i] += diezA[m];
			sumar(respuesta, dpCero(m, 0));
		}
		return dpCeroPor[n][m] = respuesta;
	}
	
	public static int[] dp(int n, int m)
	{
		if(dp[n][m] != null)
			return dp[n][m];
		if(n == 1 && m == 1)
			return dp[n][m] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] respuesta = new int[10];
		if(n == 1)
		{
			sumar(respuesta, dp(1, m - 1));
			for(int i = 1; i < 10; i++)
			{
				respuesta[i] += diezA[m - 1];
				sumar(respuesta, dpCero(m - 1, 0));
			}
		}
		else
		{
			sumar(respuesta, dp(n - 1, m));
			sumar(respuesta, dpCero(m, 0));
			respuesta[n - 1] += diezA[m];
		}
		return dp[n][m] = respuesta;
	}
	
	public static int[] dpCero(int m, int ceros)
	{
		if(dpCero[m][ceros] != null)
			return dpCero[m][ceros];
		if(m == 1)
			return dpCero[m][ceros] = new int[]{ceros * 10 + 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] respuesta = new int[10];
		if(m == 0)
			return dpCero[m][ceros] = respuesta;
		sumar(respuesta, dpCero(m - 1, ceros + 1));
		for(int i = 1; i < 10; i++)
		{
			respuesta[i] += diezA[m - 1];
			sumar(respuesta, dpCero(m - 1, ceros));
		}
		return dpCero[m][ceros] = respuesta;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		SuperWriter sw = new SuperWriter();
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0)
			{
				sw.flush();
				return;
			}
			b++;
			int[] respuesta = solucion(b + "");
			restar(respuesta, solucion(a + ""));
			boolean empezo = false;
			for(int i : respuesta)
			{
				if(!empezo)
				{
					empezo = true;
					sw.print(Integer.toString(i));
				}
				else
					sw.print(" " + i);
			}
			sw.println("");
		}
	}
}
