import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
	
	static int[][] grid = new int[250][800];
	static int[][] imagen = new int[250][800];
	
    static void crearImagen()
    {
    	for(int i = 0; i < 250; i++)
    	{
    		int acumFila = 0;
    		for(int j = 0; j < 800; j++)
    		{
    			acumFila += grid[i][j];
    			if(i == 0)
    				imagen[i][j] = acumFila;
    			else
    				imagen[i][j] = imagen[i - 1][j] + acumFila;
    		}
    	}
    }
    
    static int mejorSuma(int R, int A)
    {
    	R--;
    	int mejor = 0;
    	for(int i = 0; i < RF; i++)
    		for(int j = 0; j < 360; j++)
    		{
    			int actual = 0;
    			if(i > 0 && j > 0)
    				actual += imagen[i - 1][j - 1];
    			if(j > 0)
    				actual -= imagen[i + R][j - 1];
    			if(i > 0)
    				actual -= imagen[i - 1][j + A];
    			actual += imagen[i + R][j + A];
    			if(actual > mejor)
    				mejor = actual;
    		}
    	return mejor;
    }
    
    static int RF;
    
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			for(int i = 0; i < 100; i++)
				for(int j = 0; j < 800; j++)
					grid[i][j] = 0;
			int n = sc.nextInt();
			RF = sc.nextInt();
			if(n == 0 && RF == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				int alto = sc.nextInt();
				int angulo = sc.nextInt();
				grid[alto][angulo]++;
				grid[alto][angulo + 360]++;
			}
			crearImagen();
			int e = sc.nextInt();
			for(int i = 0; i < e; i++)
				System.out.println(mejorSuma(sc.nextInt(), sc.nextInt()));
		}
	}

}
