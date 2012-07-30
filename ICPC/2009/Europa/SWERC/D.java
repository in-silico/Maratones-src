import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class D 
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
	
	static class Respuesta
	{
		double p;
		double r;
		
		public Respuesta(double pp, double rr)
		{
			p = pp;
			r = rr;
		}
	}
	static int[] tablero = new int[]{5, 20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5, 20};
	
	static double[][] pb = new double[502][502];
	
	public static double pb(int a, int b)
	{
		if(b == 0)
			return 1;
		if(pb[a][b] != Double.POSITIVE_INFINITY)
			return pb[a][b];
		double mejor = 0;
		for(int i = 1; i <= 20; i++)
		{
			double izquierda = 1;
			double prob = 0;
			for(int j = -1; j < 2; j++)
			{
				if(tablero[i + j] > b)
				{
					Respuesta siguiente = pas(a, b);
					prob += (1 / 3.0) * (1 - siguiente.p);
					izquierda += (1 / 3.0) * siguiente.r;
				}
				else if(tablero[i + j] == b)
					prob += (1 / 3.0);
				else
					prob += (1 / 3.0) * (1 - pa(a, b - tablero[i + j]));
			}
			prob /= izquierda;
			mejor = Math.max(mejor, prob);
		}
		return pb[a][b] = mejor;
	}

	static double[][] pa = new double[502][502];
	
	private static double pa(int a, int b) 
	{
		if(a == 0)
			return 1;
		if(pa[a][b] != Double.POSITIVE_INFINITY)
			return pa[a][b];
		double prob = 0;
		for(int i = 1; i < 21; i++)
		{
			if(i > a)
				prob += (1 / 20.0) * (1 - pb(a, b));
			else if(i == a)
				prob += 1 / 20.0;
			else
				prob += (1 / 20.0) * (1 - pb(a - i, b));
		}
		return pa[a][b] = prob;
	}

	static Respuesta[][] pas = new Respuesta[502][502];

	private static Respuesta pas(int a, int b)
	{
		if(a == 0)
			return new Respuesta(1, 0);
		if(pas[a][b] != null)
			return pas[a][b];
		double prob = 0;
		double r = 0;
		for(int i = 1; i < 21; i++)
		{
			if(i > a)
			{
				prob += (1 / 20.0);
				r -= (1 / 20.0);
			}
			else if(i == a)
				prob += 1 / 20.0;
			else
				prob += (1 / 20.0) * (1 - pb(a - i, b));
		}
		return pas[a][b] = new Respuesta(prob, r);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		for(int i = 0; i <= 501; i++)
			for(int j = 0; j <= 501; j++)
			{
				pa[i][j] = pb[i][j] = Double.POSITIVE_INFINITY;
				pas[i][j] = null;
			}
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			System.out.println(pa(n, n) + " " + pb(n, n));
		}
	}
}
