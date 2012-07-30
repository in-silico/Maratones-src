import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Cross
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
	
	static int[][] sudoku = new int[9][9];
	static boolean[][] puestos = new boolean[9][9];
	
	public static boolean poner(int i, int j, int cual)
	{
		for(int k = 0; k < 9; k++)
		{
			if(k != j)
				sudoku[i][k] &= ~(1 << cual);
			if(sudoku[i][k] == 0)
				return false;
		}
		for(int k = 0; k < 9; k++)
		{
			if(k != i)
				sudoku[k][j] &= ~(1 << cual);
			if(sudoku[k][j] == 0)
				return false;
		}
		int iMenor = (i / 3) * 3;
		int iMayor = iMenor + 3;
		int jMenor = (j / 3) * 3;
		int jMayor = jMenor + 3;
		for(int a = iMenor; a < iMayor; a++)
			for(int b = jMenor; b < jMayor; b++)
				if(a != i || b != j)
				{
					sudoku[a][b] &= ~(1 << cual);
					if(sudoku[a][b] == 0)
						return false;
				}
		sudoku[i][j] = 1 << cual;
		return true;
	}
	
	public static int buscar(int i, int j)
	{
		int iMenor = (i / 3) * 3;
		int iMayor = iMenor + 3;
		int jMenor = (j / 3) * 3;
		int jMayor = jMenor + 3;
		int posibles = sudoku[i][j];
		for(int a = iMenor; a < iMayor; a++)
			for(int b = jMenor; b < jMayor; b++)
				if(a != i || b != j)
					posibles &= ~(sudoku[a][b]);
		if(Integer.bitCount(posibles) == 1)
			return Integer.numberOfTrailingZeros(posibles);
		else
			return -1;
	}
	
	public static boolean probar(int i, int j)
	{
		int iMenor = (i / 3) * 3;
		int iMayor = iMenor + 3;
		int jMenor = (j / 3) * 3;
		int jMayor = jMenor + 3;
		int posibles = 0;
		for(int a = iMenor; a < iMayor; a++)
			for(int b = jMenor; b < jMayor; b++)
				posibles |= sudoku[a][b];
		return posibles == (1 << 9) - 1;
	}
	
	public static boolean probarF(int i)
	{
		int posibles = 0;
		for(int a = 0; a < 9; a++)
			posibles |= sudoku[i][a];
		return posibles == (1 << 9) - 1;
	}
	
	public static boolean probarC(int i)
	{
		int posibles = 0;
		for(int a = 0; a < 9; a++)
			posibles |= sudoku[a][i];
		return posibles == (1 << 9) - 1;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				sudoku[i][j] = (1 << 9) - 1;
		boolean paila = false;
		for(int i = 0; i < 9; i++)
		{
			String s = sc.nextLine();
			for(int j = 0; j < 9; j++)
			{
				if(s.charAt(j) != '.')
				{
					if(!poner(i, j, s.charAt(j) - '0' - 1))
						paila = true;
					puestos[i][j] = true;
				}
			}
		}
		while(!paila)
		{
			boolean cambio = false;
			for(int i = 0; i < 9; i++)
				for(int j = 0; j < 9; j++)
				{
					int respuesta = buscar(i, j);
					if(respuesta == -1)
						continue;
					if(!puestos[i][j])
					{
						if(!poner(i, j, respuesta))
							paila = true;
						puestos[i][j] = true;
						cambio = true;
					}
				}
			if(!cambio)
				break;
		}
		if(paila)
			System.out.println("ERROR");
		else
		{
			for(int i = 0; i < 9; i++)
			{
				if(!probarF(i) || !probarC(i))
					paila = true;
				for(int j = 0; j < 9; j++)
					if(!probar(i, j))
						paila = true;
			}
			if(paila)
				System.out.println("ERROR");
			else
			{
				for(int i = 0; i < 9; i++)
				{
					for(int j = 0; j < 9; j++)
						if(puestos[i][j])
							System.out.print(Integer.numberOfTrailingZeros(sudoku[i][j]) + 1);
						else
							System.out.print(".");
					System.out.println();
				}
			}
		}
	}

}
