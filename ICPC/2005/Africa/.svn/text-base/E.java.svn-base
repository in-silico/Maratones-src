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

	static int[][] matriz = new int[10][10];
	static int[] columnas = new int[10];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int d = sc.nextInt();
		for(int a = 1; a <= d; a++)
		{
			int n = sc.nextInt();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
				{
					matriz[i][j] = sc.nextInt();
				}
			for(int i = 0; i < n; i++)
				columnas[i] = matriz[i][0];
			boolean paila = false;
			for(int i = 0; i < n; i++)
			{
				int posible = -matriz[0][i] + columnas[0];
				for(int j = 0; j < n; j++)
				{
					if(columnas[j] != matriz[j][i] + posible)
					{
						paila = true;
						break;
					}
				}
			}
			System.out.print(a + ". ");
			if(paila)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
	}

}
