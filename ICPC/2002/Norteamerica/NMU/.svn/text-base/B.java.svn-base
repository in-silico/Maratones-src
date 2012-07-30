import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
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
	}
	
	static class Posicion implements Comparable <Posicion>
	{
		int x, y, patron, paso;
		
		public Posicion(int xx, int yy, int patronP, int pasoP)
		{
			x = xx;
			y = yy;
			patron = patronP;
			paso = pasoP;
		}

		@Override
		public int compareTo(Posicion o) 
		{
			if(x != o.x)
				return Integer.valueOf(x).compareTo(o.x);
			if(y != o.y)
				return Integer.valueOf(y).compareTo(o.y);
			return Integer.valueOf(patron).compareTo(o.patron);
		}
		
		@Override
		public boolean equals(Object obj) 
		{
			Posicion otra = (Posicion) obj;
			return compareTo(otra) == 0;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int caso = 1;
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d;
			try
			{
				d = sc.nextInt();
			}
			catch(Exception e)
			{
				return;
			}
			int e = sc.nextInt();
			int f = sc.nextInt();
			int res = (a / d) * (b / e) * (c / f);
			res = Math.max(res, (a / d) * (c / e) * (b / f));
			res = Math.max(res, (b / d) * (a / e) * (c / f));
			res = Math.max(res, (b / d) * (c / e) * (a / f));
			res = Math.max(res, (c / d) * (a / e) * (b / f));
			res = Math.max(res, (c / d) * (b / e) * (a / f));
			System.out.print("Case " + caso++ + ": ");
			System.out.println("Jar Jar can fit " + res + " bricks in the box.");
			System.out.println();
		}
	}

}
