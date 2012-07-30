import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class I
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
			while(true)
			{
				try
				{
					int n = sc.nextInt();
					char[][] matriz = new char[n][];
					for(int i = 0; i < n; i++)
						matriz[i] = sc.next().toCharArray();
					int m = matriz[0].length;
					StringBuilder sb = new StringBuilder(n * m);
					for(int i = 0; i < m; i++)
						for(int j = 0; j < n; j++)
						{
							sb.append(matriz[j][i]);
						}
					sb.reverse();
					String salida = sb.toString();
					System.out.println(salida.replace('_', ' ').replace('\\', '\n'));
					System.out.println();
				}
				catch(Exception e)
				{
					return;
				}
			}
		}
	}
}