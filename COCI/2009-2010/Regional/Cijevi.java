import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Cijevi 
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
	
	static char[][] mapa;
	static int[][] visitados;
	static int r;
	static int c;
	static int iInicio;
	static int jInicio;
	static int iFin;
	static int jFin;
	
	public static boolean intentar(int i, int j, boolean horizontal, boolean direccion)
	{
		for(int a = 0; a < r; a++)
			for(int b = 0; b < c; b++)
				visitados[a][b] = 0;
		visitados[iInicio][jInicio]++;
		while(true)
		{
			if(i < 0 || i >= r || j < 0 || j >= c)
				return false;
			visitados[i][j]++;
			if(visitados[i][j] > 2)
				return false;
			if(i == iFin && j == jFin)
			{
				for(int a = 0; a < r; a++)
					for(int b = 0; b < c; b++)
					{
						if(mapa[a][b] == '+')
							if(visitados[a][b] != 2)
								return false;
							else
								continue;
						if(mapa[a][b] != '.' && visitados[a][b] != 1)
							return false;
					}
				return true;
			}
			else if(mapa[i][j] == '.')
				return false;
			else if(mapa[i][j] == '+')
			{
				if(horizontal)
					j += (direccion ? 1 : -1);
				else
					i += (direccion ? 1 : -1);
			}
			else if(mapa[i][j] == '|')
			{
				if(horizontal)
					return false;
				i += (direccion ? 1 : -1);
			}
			else if(mapa[i][j] == '-')
			{
				if(!horizontal)
					return false;
				j += (direccion ? 1 : -1);
			}
			else if(mapa[i][j] == '1')
			{
				if((horizontal && direccion) || (!horizontal && direccion))
					return false;
				if(horizontal)
				{
					i++;
					horizontal = false;
					direccion = true;
				}
				else
				{
					j++;
					horizontal = true;
					direccion = true;
				}
			}
			else if(mapa[i][j] == '2')
			{
				if((horizontal && direccion) || (!horizontal && !direccion))
					return false;
				if(horizontal)
				{
					i--;
					horizontal = false;
					direccion = false;
				}
				else
				{
					j++;
					horizontal = true;
					direccion = true;
				}
			}
			else if(mapa[i][j] == '3')
			{
				if((horizontal && !direccion) || (!horizontal && !direccion))
					return false;
				if(horizontal)
				{
					i--;
					horizontal = false;
					direccion = false;
				}
				else
				{
					j--;
					horizontal = true;
					direccion = false;
				}
			}
			else if(mapa[i][j] == '4')
			{
				if((horizontal && !direccion) || (!horizontal && direccion))
					return false;
				if(horizontal)
				{
					i++;
					horizontal = false;
					direccion = true;
				}
				else
				{
					j--;
					horizontal = true;
					direccion = false;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		r = sc.nextInt();
		c = sc.nextInt();
		mapa = new char[r][];
		for(int i = 0; i < r; i++)
			mapa[i] = sc.next().toCharArray();
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				if(mapa[i][j] == 'M')
				{
					iInicio = i;
					jInicio = j;
				}
				else if(mapa[i][j] == 'Z')
				{
					iFin = i;
					jFin = j;
				}
		visitados = new int[r][c];
		int iRes = 0;
		int jRes = 0;
		char cRes = ' ';
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
			{
				if(mapa[i][j] == '.')
				{
					for(char c : "|-+1234".toCharArray())
					{
						mapa[i][j] = c;
						int cuenta = 0;
						if(intentar(iInicio - 1, jInicio, false, false))
							cuenta++;
						if(intentar(iInicio + 1, jInicio, false, true))
							cuenta++;
						if(intentar(iInicio, jInicio - 1, true, false))
							cuenta++;
						if(intentar(iInicio, jInicio + 1, true, true))
							cuenta++;
						if(cuenta == 1)
						{
							iRes = i + 1;
							jRes = j + 1;
							cRes = c;
						}
					}
					mapa[i][j] = '.';
				}
			}
		System.out.println(iRes + " " + jRes + " " + cRes);
	}
}
