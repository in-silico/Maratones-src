import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A 
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
	
	static boolean[] unaLetra = new boolean[27];
	static boolean[][] dosLetras = new boolean[27][27];
	static boolean[][][] tresLetras = new boolean[27][27][27];
	static long[][][][] dpA = new long[21][27][27][21];

	
	static long dpA(int a, int b, int pos, int tam)
	{
		if(dpA[tam][a + 1][b + 1][pos] != -1)
			return dpA[tam][a + 1][b + 1][pos];
		if(pos == tam)
			return dpA[tam][a + 1][b + 1][pos] = 1;
		long acum = 0;
		for(int c = 0; c < 26; c++)
			if(probar(a, b, c))
				acum += dpA(b, c, pos + 1, tam);
		return dpA[tam][a + 1][b + 1][pos] = acum;
	}
	
	static boolean puede(int c)
	{
		if(c == ' ')
			return true;
		return unaLetra[c];
	}
	
	static boolean puede(int a, int b)
	{
		if(a == ' ')
			return puede(b);
		return dosLetras[a][b];
	}
	
	static boolean puede(int a, int b, int c)
	{
		if(a == ' ')
			return puede(b, c);
		return tresLetras[a][b][c];
	}
	
	static boolean probar(int a, int b, int c)
	{
		if(a == -1)
			a = ' ';
		if(b == -1)
			b = ' ';
		return puede(c) && puede(b, c) && puede(a, b, c);
	}
	
	static String devolverse(int n)
	{
		long acum = 0;
		int t = 0;
		for(int i = 1; i < 21; i++)
		{
			long siguiente = dpA[i][0][0][0];
			if(acum + siguiente >= n)
			{
				t = i;
				break;
			}
			acum += siguiente;
		}
		int a = -1;
		int b = -1;
		int[] palabra = new int[t];
		for(int i = 0; i < t; i++)
		{
			if(acum == n)
				break;
			for(int c = 0; c < 26; c++)
			{
				if(probar(a, b, c))
				{
					long siguiente = dpA[t][b + 1][c + 1][i + 1];
					if(siguiente + acum >= n)
					{
						a = b;
						b = c;
						palabra[i] = c;
						break;
					}
					else
						palabra[i] = c;
					acum += siguiente;
				}
			}
		}
		char[] palabraReal = new char[t];
		for(int i = 0; i < t; i++)
			palabraReal[i] = (char) (palabra[i] + 'a');
		return new String(palabraReal);
	}
	
	public static int ir(char[] r)
	{
		for(int i = 0; i < r.length; i++)
			r[i] -= 'a';
		int acum = 0;
		for(int i = 1; i < r.length; i++)
			acum += dpA[i][0][0][0];
		int a = -1;
		int b = -1;
		for(int i = 0; i < r.length; i++)
		{
			for(int c = 0; c < r[i]; c++)
			{
				if(probar(a, b, c))
					acum += dpA[r.length][b + 1][c + 1][i + 1];
			}
			a = b;
			b = r[i];
		}
		return acum + 1;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 0; caso < t; caso++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			for(int i = 0; i < 27; i++)
			{
				unaLetra[i] = true;
				for(int j = 0; j < 27; j++)
				{
					dosLetras[i][j] = true;
					for(int k = 0; k < 27; k++)
						tresLetras[i][j][k] = true;
				}
			}
			for(int i = 0; i < n; i++)
			{
				char[] b = sc.next().toCharArray();
				for(int j = 0; j < b.length; j++)
					b[j] -= 'a';
				if(b.length == 1)
					unaLetra[b[0]] = false;
				else if(b.length == 2)
					dosLetras[b[0]][b[1]] = false;
				else
					tresLetras[b[0]][b[1]][b[2]] = false;
			}
			for(int i = 1; i < 21; i++)
			{
				for(int j = 0; j < 27; j++)
					for(int k = 0; k < 27; k++)
						for(int l = 0; l < 21; l++)
							dpA[i][j][k][l] = -1;
				dpA(-1, -1, 0, i);
			}
			for(int i = 0; i < m; i++)
			{
				String siguiente = sc.next();
				if(siguiente.charAt(0) >= '0' && siguiente.charAt(0) <= '9')
					System.out.println(devolverse(Integer.parseInt(siguiente)));
				else
					System.out.println(ir(siguiente.toCharArray()));
			}
		}
	}
}
