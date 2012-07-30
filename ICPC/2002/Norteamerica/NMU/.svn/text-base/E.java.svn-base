import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;


public class E 
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
	
	public static BigDecimal suma(int n)
	{
		BigDecimal inicio = BigDecimal.ZERO;
		for(int i = 2; i <= n; i++)
		{
			inicio = inicio.add(BigDecimal.ONE.divide(BigDecimal.valueOf(i), 20, RoundingMode.HALF_EVEN));
		}
		return inicio.divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int entrada = sc.nextInt();
			if(entrada == 0)
				return;
			System.out.println("With " + entrada + " competitors, a Jedi Knight will be replaced approximately " + suma(entrada) + " times.");
			System.out.println();
		}
	}

}
