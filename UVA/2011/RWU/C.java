import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C
{
	static class Scanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		public String next() throws IOException
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		int casos = sc.nextInt();
		char[][] grid = new char[100][100];
		for(int caso = 1; caso <= casos; caso++)
		{
			String valor = sc.next();
			int tam = valor.length();
			int mejor = Integer.MAX_VALUE;
			char[] cv = valor.toCharArray();
			for(int val = 2; val <= tam / 2; val++)
			{
				if(tam % val != 0)
					continue;
				int n = val;
				int m = tam / val;
				for(int i = 0; i < m; i++)
					for(int j = 0; j < n; j++)
						grid[i][j] = 0;
				int i = 0;
				int j = 0;
				int direccion = 0;
				for(char c : cv)
				{
					grid[i][j] = c;
					if(direccion == 0)
					{
						if(j == n - 1 || grid[i][j + 1] != 0)
							direccion = 1;
					}
					else if(direccion == 1)
					{
						if(i == m - 1 || grid[i + 1][j] != 0)
							direccion = 2;
					}
					else if(direccion == 2)
					{
						if(j == 0 || grid[i][j - 1] != 0)
							direccion = 3;
					}
					else if(direccion == 3)
					{
						if(i == 0 || grid[i - 1][j] != 0)
							direccion = 0;
					}
					if(direccion == 0)
						j++;
					if(direccion == 1)
						i++;
					if(direccion == 2)
						j--;
					if(direccion == 3)
						i--;
				}
				boolean paila = false;
				for(i = 0; i < n && !paila; i++)
				{
					char inicial = grid[0][i];
					for(j = 1; !paila && j < m; j++)
						if(grid[j][i] != inicial)
							paila = true;
				}
				if(!paila)
					mejor = Math.min(mejor, n + m);
			}
			System.out.println("Case " + caso + ": " + (mejor == Integer.MAX_VALUE ? -1 : mejor));
		}
	}

}
