import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class F
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		char[][] ciudad = new char[1000][];
		int[][] arribaI = new int[1000][1000];
		int[][] arribaD = new int[1000][1000];
		int[][] abajoI = new int[1000][1000];
		int[][] abajoD = new int[1000][1000];
		while(true)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			for(int i = 0; i < r; i++)
				ciudad[i] = sc.next().toCharArray();
			long total = 0;
			for(char actual = '0'; actual <= '9'; actual++)
			{
				for(int i = 0; i < r; i++)
				{
					for(int j = 0; j < c; j++)
					{
						int mejor = 10000000;
						if(ciudad[i][j] == actual)
							mejor = 0;
						else 
						{
							if(i != 0 && arribaI[i - 1][j] + 1 < mejor)
								mejor = arribaI[i - 1][j] + 1;
							if(j != 0 && arribaI[i][j - 1] + 1 < mejor)
								mejor = arribaI[i][j - 1] + 1;
						}
						arribaI[i][j] = mejor;
					}
				}
				for(int i = 0; i < r; i++)
				{
					for(int j = c - 1; j >= 0; j--)
					{
						int mejor = 10000000;
						if(ciudad[i][j] == actual)
							mejor = 0;
						else 
						{
							if(i != 0 && arribaD[i - 1][j] + 1 < mejor)
								mejor = arribaD[i - 1][j] + 1;
							if(j != c - 1 && arribaD[i][j + 1] + 1 < mejor)
								mejor = arribaD[i][j + 1] + 1;
						}
						arribaD[i][j] = mejor;
					}
				}
				for(int i = r - 1; i >= 0; i--)
				{
					for(int j = 0; j < c; j++)
					{
						int mejor = 10000000;
						if(ciudad[i][j] == actual)
							mejor = 0;
						else 
						{
							if(i != r - 1 && abajoI[i + 1][j] + 1 < mejor)
								mejor = abajoI[i + 1][j] + 1;
							if(j != 0 && abajoI[i][j - 1] + 1 < mejor)
								mejor = abajoI[i][j - 1] + 1;
						}
						abajoI[i][j] = mejor;
					}
				}
				for(int i = r - 1; i >= 0; i--)
				{
					for(int j = c - 1; j >= 0; j--)
					{
						int mejor = 10000000;
						if(ciudad[i][j] == actual)
							mejor = 0;
						else 
						{
							if(i != r - 1 && abajoD[i + 1][j] + 1 < mejor)
								mejor = abajoD[i + 1][j] + 1;
							if(j != c - 1 && abajoD[i][j + 1] + 1 < mejor)
								mejor = abajoD[i][j + 1] + 1;
						}
						abajoD[i][j] = mejor;
					}
				}
				for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						int mejor = 10000000;
						if(j != 0)
							mejor = Math.min(mejor, arribaI[i][j - 1] + 1);
						if(i != 0)
							mejor = Math.min(mejor, arribaD[i - 1][j] + 1);
						if(j != c - 1)
							mejor = Math.min(mejor, abajoD[i][j + 1] + 1);
						if(i != r - 1)
							mejor = Math.min(mejor, abajoI[i + 1][j] + 1);
						if(mejor < 10000000)
							total += mejor << 1;
					}
			}
			System.out.println(total);
			if(sc.endLine())
				return;
		}
	}
}