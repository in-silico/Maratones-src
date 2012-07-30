import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static double epsilon = 1e-6;
	
	static class Linea implements Comparable <Linea>
	{
		double anguloInicio;
		double anguloFin;
		
		public Linea(int x1, int y1, int x2, int y2)
		{
			double anguloA = Math.atan2(y1, x1);
			double anguloB = Math.atan2(y2, x2);
			anguloInicio = Math.min(anguloA, anguloB);
			anguloFin = Math.max(anguloA, anguloB);
		}

		@Override
		public int compareTo(Linea o)
		{
			return Double.valueOf(anguloInicio).compareTo(o.anguloInicio);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		Linea[] lineas = new Linea[1005];
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				lineas[i] = new Linea(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			Arrays.sort(lineas, 0, n);
			int i = 0;
			int tiros = 0;
			while(i < n)
			{
				double anguloFin = lineas[i].anguloFin;
				while(i < n && lineas[i].anguloInicio <= anguloFin)
				{
					if(lineas[i].anguloFin < anguloFin)
						anguloFin = lineas[i].anguloFin;
					i++;
				}
				tiros++;
			}
			System.out.println(tiros);
		}
	}
}
