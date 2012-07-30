import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Turbo
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
	
	public static class Fenwick
	{
		int[] fenwickTree = new int[100002];
		int tam;
		
		public Fenwick(int tam)
		{
			this.tam = tam;
		}
		
		int query(int a, int b) 
		{
		    if (a == 0)
		    {
		        int sum = 0;
		        for (; b >= 0; b = (b & (b + 1)) - 1)
		          sum += fenwickTree[b];
		        return sum;
		    } 
		    else 
		    {
		        return (query(0, b) - query(0, a - 1));
		    }
		}
	
		void increase(int k, int inc)
		{
		    for (; k < tam + 1; k |= k + 1)
		    {
		        fenwickTree[k] += inc;
		    }
		}
	}

	static int[] numeros = new int[100001];
	static int[] posiciones = new int[100001];
	static int[] salidas = new int[100001];
	static int[][] bandas = new int[100001][2];
	static int[] resultados = new int[100001];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			numeros[i] = sc.nextInt();
			posiciones[numeros[i]] = i;
		}
		int actualA = 1;
		int actualB = n;
		boolean actual = false;
		{
			int i = 0;
			while(actualA <= actualB)
			{
				if(!actual)
				{
					bandas[actualA][0] = 0;
					bandas[actualA][1] = actualB;
					salidas[i++] = actualA++;
				}
				else
				{
					bandas[actualB][0] = 1;
					bandas[actualB][1] = actualA;
					salidas[i++] = actualB--;
				}
				actual = !actual;
			}
		}
		Fenwick fenwickA = new Fenwick(n);
		for(int i = 0; i < n; i++)
		{
			int este = numeros[i];
			if(bandas[este][0] == 0)
				resultados[este] = fenwickA.query(este + 1, bandas[este][1]);
			fenwickA.increase(este, 1);
		}
		Fenwick fenwickB = new Fenwick(n);
		for(int i = n - 1; i >= 0; i--)
		{
			int este = numeros[i];
			if(bandas[este][0] == 1)
				resultados[este] = fenwickB.query(bandas[este][1], este - 1);
			fenwickB.increase(este, 1);
		}
		for(int i = 0; i < n; i++)
			System.out.println(resultados[salidas[i]]);
	}
}
