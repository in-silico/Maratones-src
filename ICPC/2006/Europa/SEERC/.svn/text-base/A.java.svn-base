import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class A 
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
	
	static int visitado = 1 << 17;
	
	static void marcar(int i, int j, int n)
	{
		int mascara = 1 << n;
		sudoku[i][j] = mascara + visitado;
		mascara = ~mascara;
		int iMenor = (i / 4) * 4;
		int iMayor = iMenor + 4;
		int jMenor = (j / 4) * 4;
		int jMayor = jMenor + 4;
		for(int a = 0; a < 16; a++)
		{
			if(a != j)
				sudoku[i][a] &= mascara;
			if(a != i)
				sudoku[a][j] &= mascara;
		}
		for(int a = iMenor; a < iMayor; a++)
			for(int b = jMenor; b < jMayor; b++)
				if(a != i || b != j)
					sudoku[a][b] &= mascara;
	}
	
	static long tiempoDentro = 0;
	static int[][][] zonas = new int[48][16][2];
	static int[] actuales = new int[16];
	
	public static void limpiarZona(int[][] zona, int[] actuales, int[] grupos, int[] tamGrupos, int[][] sudoku)
	{
		while(true)
		{
			int iActual = 0;
			forExterno:
			for(int i = 0; i < 17; i++)
			{
				if(tamGrupos[i] == -1)
					break;
				for(int j = 0; j < tamGrupos[i]; j++)
				{
					int indice = grupos[iActual + j];
					int valor = sudoku[zona[indice][0]][zona[indice][1]];
					if(valor >= visitado || tamGrupos[i] == 1)
					{
						tamGrupos[i]--;
						for(int k = iActual + j; k < 15; k++)
							grupos[k] = grupos[k + 1];
						if(tamGrupos[i] == 0)
						{
							for(int k = i; k < 16; k++)
								tamGrupos[k] = tamGrupos[k + 1];
							i--;
							continue forExterno;
						}
						else
						{
							j--;
							continue;
						}
					}
				}
				iActual += tamGrupos[i];
			}
			break;
		}
		while(true)
		{
			int iActual = 0;
			forExterno:
			for(int i = 0; i < 17; i++)
			{
				int tamActual = tamGrupos[i];
				if(tamActual == -1)
					break;
				int mascaraActual = 1 << tamActual;
				mascaraActual--;
				for(int mascara = 1; mascara < mascaraActual; mascara++)
				{
					int temp = mascara;
					int m = 0;
					for(int j = 0; j < tamActual; j++)
					{
						if((temp & 1) == 1)
							m |= sudoku[zona[grupos[iActual + j]][0]][zona[grupos[iActual + j]][1]];
						temp >>= 1;
					}
					int tamCuenta = Integer.bitCount(m);
					if(tamCuenta == tamActual)
						continue;
					temp = ~m;
					int cuenta = 0;
					for(int j = 0; j < tamActual; j++)
					{
						int valor = sudoku[zona[grupos[iActual + j]][0]][zona[grupos[iActual + j]][1]];
						if((valor & temp) == 0)
							cuenta++;
					}
					if(cuenta == tamCuenta)
					{
						int posA = 0;
						for(int j = 0; j < tamActual; j++)
						{
							int valor = sudoku[zona[grupos[iActual + j]][0]][zona[grupos[iActual + j]][1]];
							if((valor & temp) == 0)
								actuales[posA++] = grupos[iActual + j];
						}
						for(int j = 0; j < tamActual; j++)
						{
							int valor = sudoku[zona[grupos[iActual + j]][0]][zona[grupos[iActual + j]][1]];
							if((valor & temp) != 0)
							{
								actuales[posA++] = grupos[iActual + j];
								sudoku[zona[grupos[iActual + j]][0]][zona[grupos[iActual + j]][1]] &= temp;
							}
						}
						for(int k = 0; k < tamActual; k++)
							grupos[iActual + k] = actuales[k];
						tamGrupos[i] = cuenta;
						for(int k = 16; k > i; k--)
							tamGrupos[k] = tamGrupos[k - 1];
						tamGrupos[i + 1]  = tamActual - cuenta;
						i--;
						continue forExterno;
					}
				}
				iActual += tamActual;
			}
			break;
		}
	}
	
	public static void limpiar(int[][] sudoku, int[][] grupos, int[][] tamGrupos)
	{
		for(int i = 0; i < 48; i++)
			limpiarZona(zonas[i], actuales, grupos[i], tamGrupos[i], sudoku);
	}
	
	static int[][] sudoku = new int[16][16];
	static int[][] grupos = new int[48][16];
	static int[][] tamGrupos = new int[48][17];
	static int[][][] backtrack = new int[256][16][16];
	static int[][][] backtrackGrupos = new int[256][48][16];
	static int[][][] backtrackTamGrupos = new int[256][48][17];
	
	static boolean backtrack(int altura, int[][] sudoku, int[][] grupos, int[][] tamGrupos)
	{
		int sumAnterior = 0;
		int sumMejor = Integer.MAX_VALUE;
		boolean termino = true;
		int iMejor = 0;
		int jMejor = 0;
		while(sumMejor > 1 && sumAnterior != sumMejor)
		{
			sumAnterior = sumMejor;
			iMejor = 0;
			jMejor = 0;
			termino = true;
			sumMejor = Integer.MAX_VALUE;
			for(int i = 0; i < 16; i++)
				for(int j = 0; j < 16; j++)
				{
					int pos = Integer.bitCount(sudoku[i][j]);
					if(sudoku[i][j] == 0)
						return false;
					if(sudoku[i][j] <= todos)
						termino = false;
					if(sudoku[i][j] <= todos && pos <= sumMejor)
					{
						sumMejor = pos;
						iMejor = i;
						jMejor = j;
					}
				}
			if(sumMejor != 1)
				limpiar(sudoku, grupos, tamGrupos);
		}
		if(termino)
		{
			for(int i = 0; i < 16; i++)
			{
				for(int j = 0; j < 16; j++)
				{
					int temp = sudoku[i][j];
					for(int k = 0; k < 16; k++)
					{
						if((temp & 1) == 1)
							System.out.print((char) ('A' + k));
						temp >>= 1;
					}
				}
				System.out.println();
			}
			return true;
		}
		if(sumMejor == 1)
		{
			int pos = 0;
			int temp = sudoku[iMejor][jMejor];
			for(int i = 0; i < 16; i++)
			{
				if((temp & 1) == 1)
					pos = i;
				temp >>= 1;
			}
			marcar(iMejor, jMejor, pos);
			return backtrack(altura + 1, sudoku, grupos, tamGrupos);			
		}
		else
		{
			for(int j = 0; j < 16; j++)
				for(int k = 0; k < 16; k++)
					backtrack[altura][j][k] = sudoku[j][k];
			for(int j = 0; j < 48; j++)
				for(int k = 0; k < 16; k++)
					backtrackGrupos[altura][j][k] = grupos[j][k];
			for(int j = 0; j < 48; j++)
				for(int k = 0; k < 17; k++)
					backtrackTamGrupos[altura][j][k] = tamGrupos[j][k];
			int temp = sudoku[iMejor][jMejor];
			for(int i = 0; i < 16; i++)
			{
				if((temp & 1) == 1)
				{
					int pos = i;
					for(int j = 0; j < 16; j++)
						for(int k = 0; k < 16; k++)
							sudoku[j][k] = backtrack[altura][j][k];
					for(int j = 0; j < 48; j++)
						for(int k = 0; k < 16; k++)
							grupos[j][k] = backtrackGrupos[altura][j][k];
					for(int j = 0; j < 48; j++)
						for(int k = 0; k < 17; k++)
							tamGrupos[j][k] = backtrackTamGrupos[altura][j][k];
					marcar(iMejor, jMejor, pos);
					if(backtrack(altura + 1, sudoku, grupos, tamGrupos))
						return true;
				}
				temp >>= 1;
			}
			return false;
		}
	}
	
	
	static void generarZonas()
	{
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				zonas[i][j][0] = i;
				zonas[i][j][1] = j;
			}
		}
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				zonas[i + 16][j][0] = j;
				zonas[i + 16][j][1] = i;
			}
		}
		int cuenta = 0;
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
			{
				int ia = i * 4;
				int ib = ia + 4;
				int ja = j * 4;
				int jb = ja + 4;
				int actual = 0;
				for(int a = ia; a < ib; a++)
					for(int b = ja; b < jb; b++)
					{
						zonas[cuenta + 32][actual][0] = a;
						zonas[cuenta + 32][actual++][1] = b;
					}
				cuenta++;
			}
	}
	
	static int todos = (1 << 16) - 1;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("a.in"));
		System.setOut(new PrintStream("a.out"));
		generarZonas();
		Scanner sc = new Scanner();
		boolean inicio = false;
		while(!sc.endLine())
		{
			for(int i = 0; i < 16; i++)
				for(int j = 0; j < 16; j++)
					sudoku[i][j] = todos;
			for(int i = 0; i < 48; i++)
			{
				for(int j = 0; j < 16; j++)
					grupos[i][j] = j;
				tamGrupos[i][0] = 16;
				tamGrupos[i][1] = -1;
			}	
			for(int i = 0; i < 16; i++)
			{
				int j = 0; 
				for(char c : sc.next().toCharArray())
				{
					if(c != '-')
						marcar(i, j, c - 'A');
					j++;
				}
			}
			limpiar(sudoku, grupos, tamGrupos);
			if(!inicio)
				inicio = true;
			else
				System.out.println();
			backtrack(0, sudoku, grupos, tamGrupos);
		}
	}
}