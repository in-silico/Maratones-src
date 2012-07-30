import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Pravokutni  
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
	
	static boolean collinear(long x1, long y1, long x2, long y2, long x3, long y3) 
	{
		  return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		final int[][] puntos = new int[n][2];
		for(int i = 0; i < n; i++)
		{
			puntos[i][0] = sc.nextInt();
			puntos[i][1] = sc.nextInt();
		}
		int cuenta = 0;
		for(int i = 0; i < n; i++)
		{
			final int[] a = puntos[i];
			for(int j = i + 1; j < n; j++)
			{
				final int[] b = puntos[j];
				long side11 = (a[0] - b[0]);
				side11 *= side11;
				long side12 = (a[1] - b[1]);
				side12 *= side12;
				long side1 = side11 + side12;
				for(int k = j + 1; k < n; k++) 
				{
					final int[] c = puntos[k];
					long side21 = (a[0] - c[0]);
					side21 *= side21;
					long side22 = (a[1] - c[1]);
					side22 *= side22;
					long side2 = side21 + side22;
					long side31 = (b[0] - c[0]);
					side31 *= side31;
					long side32 = (b[1] - c[1]);
					side32 *= side32;
					long side3 = side31 + side32;
					if(((side1) == ((side2) + (side3))) || ((side2) == ((side1) + (side3))) || ((side3) == ((side1) + (side2))))
						 cuenta++;
				}
			}
		}
		System.out.println(cuenta);
	}
}
