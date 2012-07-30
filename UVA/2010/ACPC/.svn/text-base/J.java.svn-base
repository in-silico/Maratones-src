import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J 
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
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int l = sc.nextInt();
			if(a == 0 && b == 0 && c == 0 && d == 0 && l == 0)
				return;
			int cuenta = 0;
			for(int i = 0; i <= l; i++)
			{
				int res = a * i * i + b * i + c;
				if(res % d == 0)
					cuenta++;
			}
			System.out.println(cuenta);
		}
	}

}
