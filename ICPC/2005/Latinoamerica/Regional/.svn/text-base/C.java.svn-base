import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C 
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
			int n = sc.nextInt();
			int d = sc.nextInt();
			if(n == 0 && d == 0)
				return;
			boolean[] atendio = new boolean[n];
			for(int i = 0; i < n; i++)
				atendio[i] = true;
			for(int i = 0; i < d; i++)
				for(int j = 0; j < n; j++)
					atendio[j] &= sc.nextInt() == 1;
			boolean alguno = false;
			for(int i = 0; i < n; i++)
				alguno |= atendio[i];
			System.out.println(alguno ? "yes" : "no");
		}
	}
	

}
