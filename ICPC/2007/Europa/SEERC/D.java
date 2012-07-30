import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
	
	static class App implements Comparable <App>
	{
		int p;
		int d;
		
		public App(int pp, int dd) 
		{
			p = pp;
			d = dd;
		}

		@Override
		public int compareTo(App o) 
		{
			return -Integer.valueOf(p).compareTo(o.p);
		}
	}
	static int [] actual = new int[10000];

	static int l;
	
	static ArrayList <App> apps = new ArrayList <App> ();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			try
			{
				int n = sc.nextInt();
				int l = sc.nextInt();
				for(int i = 0; i < 10000; i++)
					actual[i] = 0;
				apps.clear();
				for(int i = 0; i < n; i++)
					apps.add(new App(sc.nextInt(), sc.nextInt()));
				Collections.sort(apps);
				int profit = 0;
				for(App a : apps)
				{
					for(int i = a.d; i >= 0; i--)
					{
						if(actual[i] < l)
						{
							actual[i]++;
							profit += a.p;
							break;
						}
					}
				}
				System.out.println(profit);
			}
			catch(Exception e)
			{
				return;
			}
		}
	}
}