import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D
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
		int caso = 1;
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			long[] mejores = new long[3];
			mejores[0] = Integer.MAX_VALUE;
			mejores[1] = b;
			mejores[2] = b + c;
			for(int i = 1; i < n; i++)
			{
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				long mejorA = Math.min(mejores[0], mejores[1]) + a;
				long mejorB = Math.min(mejores[0], Math.min(mejores[1], Math.min(mejorA, mejores[2]))) + b;
				long mejorC = Math.min(mejores[1], Math.min(mejorB, mejores[2])) + c;
				mejores[0] = mejorA;
				mejores[1] = mejorB;
				mejores[2] = mejorC;
			}
			System.out.println(caso++ + ". " + mejores[1]);
		}
	}
}
