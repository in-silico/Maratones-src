import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B 
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
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public long nextLong()
		{
			return Long.parseLong(next());
		}
	}
	
	static int[] numeros = new int[1000001];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < 1000001; i++)
				numeros[i] = 0;
			boolean paila = false;
			for(int i = 0; i < n; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j = a; !paila && j < b; j++)
				{
					numeros[j]++;
					if(numeros[j] > 1)
						paila = true;
				}
			}
			for(int i = 0; i < m; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				out: for(int j = 0; !paila; j++)
				{
					for(int k = a + (c * j); !paila && k < b + (c * j); k++)
					{
						if(k > 1000000)
							break out;
						numeros[k]++;
						if(numeros[k] > 1)
							paila = true;
					}
				}
			}
			for(int i = 0; !paila && i < 1000001; i++)
				paila = paila || numeros[i] > 1;
			System.out.println(paila ? "CONFLICT" : "NO CONFLICT");
		}
	}

}
