import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class I 
{
	static class Scanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(Exception e)
				{
					throw new RuntimeException(e.getMessage());
				}
			}
			return st.nextToken();
		}
		
		public long nextLong()
		{
			return Long.parseLong(next());
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int a = 0;
			int b = 0;
			boolean donde = true;
			for(int i = 0; i < 32; i++)
			{
				if(((n & 1) == 1))
				{
					if(donde)
						a |= 1 << i;
					else
						b |= 1 << i;
					donde = !donde;
				}
				n >>= 1;
			}
			System.out.println(a + " " + b);
		}
	}
}
