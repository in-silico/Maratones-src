import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int p = sc.nextInt();
			int s = sc.nextInt();
			if(p == 0 && s == 0)
				return;
			boolean[] parado = new boolean[p];
			int[] donde = new int[p];
			int actual = 0;
			boolean[] trampa = new boolean[s + 1];
			for(int i = 0; i < 3; i++)
				trampa[sc.nextInt()] = true;
			int n = sc.nextInt();
			for(int aa = 0; aa < n; aa++)
			{
				if(parado[actual])
				{
					parado[actual] = false;
					aa--;
				}
				else
				{
					donde[actual] += sc.nextInt() + sc.nextInt();
					if(donde[actual] > s)
						donde[actual] = s;
					if(trampa[donde[actual]])
						parado[actual] = true;
				}
				if(aa == n - 1)
					break;
				actual++;
				actual %= p;
			}
			System.out.println(actual + 1);
		}
	}
}
