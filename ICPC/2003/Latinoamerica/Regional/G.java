import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;


public class G 
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
	
	static class Company
	{
		BitSet bs = new BitSet(1001);
		int number;
		boolean visited;
		
		public Company(int nn)
		{
			number = nn;
		}
	}
	
	static Company[] companies = new Company[1001];
	static int k;
	static int n;
	static BitSet actuales = new BitSet(1001);
	
	
	public static int dfs(Company c)
	{
		if(c.visited)
			return 0;
		c.visited = true;
		int count = 1;
		for(int i = 1; i <= n; i++)
			if(c.bs.get(i))
				count += dfs(companies[i]);
		return count;
				
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 1001; i++)
			companies[i] = new Company(i);
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 1; i <= n; i++)
			{
				companies[i].bs.clear();
				companies[i].visited = false;
			}
			actuales.set(1, n + 1);
			int p = sc.nextInt();
			k = sc.nextInt();
			for(int i = 0; i < p; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				companies[x].bs.set(y);
				companies[y].bs.set(x);
			}
			boolean cambio = true;
			while(cambio)
			{
				cambio = false;
				for(int i = 1; i <= n; i++)
				{
					if(actuales.get(i))
					{
						if(companies[i].bs.cardinality() < k)
						{
							actuales.set(i, false);
							for(int j = 1; j <= n; j++)
								companies[j].bs.set(i, false);
							cambio = true;
							actuales.set(i, false);
						}
					}
				}
			}
			int total = 0;
			for(int i = 1; i <= n; i++)
				if(actuales.get(i))
					total = Math.max(total, dfs(companies[i]));
			System.out.println(total);
		}
	}
}
