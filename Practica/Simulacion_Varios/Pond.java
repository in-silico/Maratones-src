import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Pond 
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
	
	static class Tortuga
	{
		int i;
		int j;
		int id;
		
		public Tortuga(int id2, int nextInt, int nextInt2)
		{
			id = id2;
			i = nextInt;
			j = nextInt2;
			grid[i][j] = this;
		}
	}
	
	static Tortuga[] hash = new Tortuga[10001];

	static Tortuga[][] grid = new Tortuga[60][60];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int t = sc.nextInt();
			int k = sc.nextInt();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					grid[i][j] = null;
			for(int i = 0; i < 10001; i++)
				hash[i] = null;
			for(int i = 0; i < t; i++)
			{
				int id = sc.nextInt();
				hash[id] = new Tortuga(id, sc.nextInt(), sc.nextInt());
			}
			for(int i = 0; i < k; i++)
			{
				int id = sc.nextInt();
				String direccion = sc.next();
				Tortuga esta = hash[id];
				int nI = 0;
				int nJ = 0;
				if(direccion.equals("S"))
				{
					if(esta.i + 1 < n)
						nI++;
				}
				else if(direccion.equals("N"))
				{
					if(esta.i - 1 >= 0)
						nI--;
				}
				else if(direccion.equals("E"))
				{
					if(esta.j + 1 < m)
						nJ++;
				}
				else if(direccion.equals("W"))
				{
					if(esta.j - 1 >= 0)
						nJ--;
				}
				else if(direccion.equals("SE"))
				{
					if(esta.i + 1 < n && esta.j + 1 < m)
					{
						nI++;
						nJ++;
					}
				}
				else if(direccion.equals("SW"))
				{
					if(esta.i + 1 < n && esta.j - 1 >= 0)
					{
						nI++;
						nJ--;
					}
				}
				else if(direccion.equals("NE"))
				{
					if(esta.i - 1 >= 0 && esta.j + 1 < m)
					{
						nI--;
						nJ++;
					}
				}
				else if(direccion.equals("NW"))
				{
					if(esta.i - 1 >= 0 && esta.j - 1 >= 0)
					{
						nI--;
						nJ--;
					}
				}
				if(nI == 0 && nJ == 0)
					continue;
				if(grid[esta.i + nI][esta.j + nJ] != null)
					continue;
				grid[esta.i + nI][esta.j + nJ] = esta;
				grid[esta.i][esta.j] = null;
				esta.i += nI;
				esta.j += nJ;
			}
			for(int i = 0; i < n; i++)
			{
				StringBuilder sb = new StringBuilder(m);
				for(int j = 0; j < m; j++)
				{
					if(grid[i][j] != null)
						sb.append("*");
					else
						sb.append(" ");
				}
				String s = sb.toString();
				while(s.endsWith(" "))
					s = s.substring(0, s.length() - 1);
				System.out.println(s);
			}
			System.out.println();
		}
	}
}
