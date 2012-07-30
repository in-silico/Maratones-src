import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			long g = sc.nextInt();
			long t = sc.nextInt();
			long a = sc.nextInt();
			long d = sc.nextInt();
			if(g == -1)
				return;
			long partidosPE = ((t * (t - 1)) / 2) * g;
			long segunda = a * g + d;
			long n = 1;
			long log = 0;
			while(n < segunda)
			{
				n *= 2;
				log++;
			}
			long faltantes = n - segunda;
			long partidosP = partidosPE + n - 1;
			System.out.println(g + "*" + a + "/" + t + "+" + d + "=" + partidosP + "+" + faltantes);
		}
	}
}
