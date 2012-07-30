import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A 
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
	
	static ArrayList <Integer> lotes = new ArrayList <Integer> ();
	static int[][] dp = new int[200][200];
	static int n;
	
	static int dp(int a, int b, int suma)
	{
		if(dp[a][b] != -1)
			return dp[a][b];
		if(a == b)
			return 0;
		int menor = Integer.MAX_VALUE;
		int acumulado = 0;
		for(int i = a; i != b;)
		{
			acumulado += lotes.get(i);
			int siguiente = i + 1 == n ? 0 : i + 1;
			menor = Math.min(menor, dp(a, i, acumulado) + Math.max(acumulado, suma - acumulado) + dp(siguiente, b, suma - acumulado));
			i++;
			if(i == n)
				i = 0;
		}
		return dp[a][b] = menor;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			double f = sc.nextDouble();
			if(n == 0 && ((int) f) == 0)
				return;
			lotes.clear();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					dp[i][j] = -1;
			int suma = 0;
			for(int i = 0; i < n; i++)
			{
				int a = sc.nextInt();
				lotes.add(a);
				suma += a;
			}
			int menor = dp(0, n - 1, suma);
			for(int i = 1; i < n; i++)
				menor = Math.min(menor, dp(i, i - 1, suma));
			System.out.printf("%.2f\n", menor * f);
		}
	}
}
