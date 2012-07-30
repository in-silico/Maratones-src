import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Maraton 
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
		int n = sc.nextInt();
		char[][] tablero = new char[n][];
		for(int i = 0; i < n; i++)
			tablero[i] = sc.next().toCharArray();
		char ganador = '.';
		out:
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
			{
				if(tablero[i][j] != '.')
				{
					if(gano(tablero, i, j))
					{
						ganador = tablero[i][j];
						break out;
					}
				}
			}
		if(ganador == '.')
			System.out.println("ongoing");
		else
			System.out.println(ganador + "");
	}

	private static boolean gano(char[][] tablero, int i, int j) 
	{
		return ganoAbajo(tablero, i, j, tablero[i][j], 0) || ganoDerecha(tablero, i, j, tablero[i][j], 0) || ganoDerechaD(tablero, i, j, tablero[i][j], 0) || ganoIzquierdaD(tablero, i, j, tablero[i][j], 0);
	}
	
	public static boolean ganoAbajo(char[][] tablero, int i, int j, char quien, int cuenta)
	{
		if(cuenta == 3)
			return true;
		try
		{
			if(tablero[i][j] == quien)
				return ganoAbajo(tablero, i + 1, j, quien, cuenta + 1);
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean ganoDerecha(char[][] tablero, int i, int j, char quien, int cuenta)
	{
		if(cuenta == 3)
			return true;
		try
		{
			if(tablero[i][j] == quien)
				return ganoDerecha(tablero, i, j + 1, quien, cuenta + 1);
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean ganoDerechaD(char[][] tablero, int i, int j, char quien, int cuenta)
	{
		if(cuenta == 3)
			return true;
		try
		{
			if(tablero[i][j] == quien)
				return ganoDerechaD(tablero, i + 1, j + 1, quien, cuenta + 1);
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean ganoIzquierdaD(char[][] tablero, int i, int j, char quien, int cuenta)
	{
		if(cuenta == 3)
			return true;
		try
		{
			if(tablero[i][j] == quien)
				return ganoIzquierdaD(tablero, i + 1, j - 1, quien, cuenta + 1);
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
