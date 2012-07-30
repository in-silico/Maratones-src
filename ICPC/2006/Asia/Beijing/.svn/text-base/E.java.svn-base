import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class E 
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
	
	static int[] orden = new int[20000];
	static int[][] puntaje = new int[20000][3];
	
	public static boolean solucion(int n, int anterior, int idAnterior)
	{
		if(n == -1)
			return true;
		int numeroActual = orden[n] - 1;
		int minimo = Integer.MAX_VALUE;
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
				for(int k = 0; k < 2; k++)
				{
					int posible = 0;
					if(i == 1)
						posible += puntaje[numeroActual][0];
					if(j == 1)
						posible += puntaje[numeroActual][1];
					if(k == 1)
						posible += puntaje[numeroActual][2];
					if(posible > anterior || (posible == anterior && numeroActual < idAnterior))
						minimo = Math.min(minimo, posible);
				}
		if(minimo == Integer.MAX_VALUE)
			return false;
		else
			return solucion(n - 1, minimo, numeroActual);
	}
	
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
				for(int j = 0; j < 3; j++)
					puntaje[i][j] = (int) (sc.nextDouble() * 100 + 0.001);
			for(int i = 0; i < n; i++)
				orden[i] = sc.nextInt();
			int numeroActual = orden[n - 1] - 1;
			int maximo = Integer.MIN_VALUE;
			for(int i = 0; i < 2; i++)
				for(int j = 0; j < 2; j++)
					for(int k = 0; k < 2; k++)
					{
						int posible = 0;
						if(i == 1)
							posible += puntaje[numeroActual][0];
						if(j == 1)
							posible += puntaje[numeroActual][1];
						if(k == 1)
							posible += puntaje[numeroActual][2];
						if(solucion(n - 2, posible, numeroActual))
							maximo = Math.max(maximo, posible);
					}
			if(maximo == Integer.MIN_VALUE)
				System.out.println("Case " + caso++ + ": No solution");
			else
				System.out.println("Case " + caso++ + ": " + maximo / 100 + "." + (maximo % 100 < 10 ? "0" : "") + maximo % 100);
		}
	}
}
