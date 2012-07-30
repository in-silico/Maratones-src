import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out)));
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

	static class Punto implements Comparable <Punto>
	{
		String a;
		double pos;
		boolean p;
		
		public Punto(double pos, String a, boolean p) 
		{
			this.a = a;
			this.pos = pos;
			this.p = p;
		}

		@Override
		public int compareTo(Punto o)
		{
			return (int) Math.signum(pos - o.pos);
		}	
	}
	
	private static String buscar(int actual, int desde, Punto[] puntos) 
	{
		whilePrincipal:
		while(true)
		{
			if(actual == desde)
				return puntos[actual].a;
			if(actual > desde)
			{
				for(int i = desde; i <= actual; i++)
					if(puntos[i].p)
					{
						desde = actual - 1;
						actual = i;
						continue whilePrincipal;
					}
			}
			else
			{
				for(int i = desde; i >= actual; i--)
					if(!puntos[i].p)
					{
						desde = actual + 1;
						actual = i;
						continue whilePrincipal;
					}
			}
			return puntos[actual].a;
		}
	}

	public static void main(String[] args)
	{
		Punto[] puntos = new Punto[32001];
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int n = sc.nextInt();
			if(n == 0)
			{
				System.out.flush();
				return;
			}
			double l = sc.nextDouble();
			double v = sc.nextDouble();
			for(int i = 0; i < n; i++)
			{
				char pC = sc.next().charAt(0);
				boolean p = pC == 'p' || pC == 'P';
				puntos[i] = new Punto(sc.nextDouble(), sc.next(), p);
			}
			Arrays.sort(puntos, 0, n);
			int indiceI = -1;
			int indiceF = -1;
			for(int i = 0; i < n; i++)
			{
				if(puntos[i].p && indiceI == -1)
					indiceI = i;
				if(!puntos[i].p)
					indiceF = i;
			}
			double a = indiceI == -1 ? -1 : l - puntos[indiceI].pos;
			double b = indiceF == -1 ? -1 : puntos[indiceF].pos;
			String nombre = null;
			if(a > b)
				nombre = buscar(indiceI, n - 1, puntos);
			else
				nombre = buscar(indiceF, 0, puntos);
			DecimalFormat df = new DecimalFormat("0.00");
			df.setRoundingMode(RoundingMode.FLOOR);
			String salida = df.format(Math.max(a, b) / v).toString();
			int cuenta = salida.length();
			while(cuenta++ != 13)
				System.out.print(" ");
			System.out.println(salida + " " + nombre);
		}
		System.out.flush();
	}
}