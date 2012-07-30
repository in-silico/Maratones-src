import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class C 
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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static final int N = 0;
	static final int D = 1;
	static final int S = 2;
	static final int I = 3;
	
	static boolean[][][] visitado = new boolean[55][55][4];
	static boolean[][] turner = new boolean[55][55];
	
	static int n;
	
	static long visitar(int x, int y, int dir)
	{
		if(x == 0 || x == n + 1 || y == 0 || y == n + 1)
			return (((long) x) | ((long) y << 32));
		if(visitado[x][y][dir])
			return 0;
		if(turner[x][y])
			dir++;
		dir %= 4;
		if(dir == N)
			y++;
		else if(dir == D)
			x++;
		else if(dir == S)
			y--;
		else
			x--;
		return visitar(x, y, dir);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int casos = sc.nextInt();
		for(int caso = 0; caso < casos; caso++)
		{
			n = sc.nextInt();
			int r = sc.nextInt();
			for(int i = 0; i <= n + 1; i++)
				for(int j = 0; j <= n + 1; j++)
					for(int k = 0; k < 4; k++)
						visitado[i][j][k] = false;
			for(int i = 0; i <= n + 1; i++)
				for(int j = 0; j <= n + 1; j++)
					turner[i][j] = false;
			for(int i = 0; i < r; i++)
				turner[sc.nextInt()][sc.nextInt()] = true;
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dir;
			if(x == n + 1)
			{
				x--;
				dir = I;
			}
			else if(x == 0)
			{
				x++;
				dir = D;
			}
			else if(y == n + 1)
			{
				y--;
				dir = S;
			}
			else 
			{
				dir = N;
				y++;
			}
			long respuesta = visitar(x, y, dir);
			System.out.println(((int) respuesta) + " " + (respuesta >>> 32));
		}
	}
}
