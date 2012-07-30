import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C 
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
	
	public static int[][][] dp = new int[1 << 8][64][11];

	public static int[][] tablero = new int[8][8];
	
	public static int[] inicialesFila = new int[8];
	public static int[] inicialesColumna = new int[8];
	
	public static int p;
	
	static boolean llenar(int peones, int caballo, int turno)
	{
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				tablero[i][j] = -1;
		int pp = peones;
		for(int i = 0; i < p; i++)
		{
			if((pp & 1) == 1)
			{
				int columna = inicialesColumna[i];
				int fila = inicialesFila[i] + turno;
				if(fila > 7)
					return false;
				tablero[fila][columna] = i;
			}
			pp >>>= 1;
		}
		int columnaCaballo = caballo % 8;
		int filaCaballo = caballo / 8;
		if(tablero[filaCaballo][columnaCaballo] != -1)
			return false;
		else
			return true;
	}

	static int intentar(int deltaX, int deltaY, int columnaCaballo, int filaCaballo, int turno, int peones)
	{
		int columnaNueva = columnaCaballo + deltaY;
		int filaNueva = filaCaballo + deltaX;
		if(columnaNueva >= 0 && columnaNueva <= 7 && filaNueva >= 0 && filaNueva <= 7)
		{
			if(tablero[filaNueva][columnaNueva] != -1)
				peones ^= 1 << tablero[filaNueva][columnaNueva];
			return dp(peones, filaNueva * 8 + columnaNueva, turno + 1);
		}
		return 1000;
	}
	
	static int dp(int peones, int caballo, int turno)
	{
		if(dp[peones][caballo][turno] != -1)
			return dp[peones][caballo][turno];
		if(peones == 0)
			return dp[peones][caballo][turno] = turno;
		if(!llenar(peones, caballo, turno))
			return dp[peones][caballo][turno] = 1000;
		int columnaCaballo = caballo % 8;
		int filaCaballo = caballo / 8;
		int mejor = 1000;
		mejor = Math.min(mejor, intentar(-1, -2, columnaCaballo, filaCaballo, turno, peones));
		llenar(peones, caballo, turno);
		mejor = Math.min(mejor, intentar(-1, 2, columnaCaballo, filaCaballo, turno, peones));
		llenar(peones, caballo, turno);
		mejor = Math.min(mejor, intentar(-2, -1, columnaCaballo, filaCaballo, turno, peones));
		llenar(peones, caballo, turno);
		mejor = Math.min(mejor, intentar(-2, 1, columnaCaballo, filaCaballo, turno, peones));
		llenar(peones, caballo, turno);
		mejor = Math.min(mejor, intentar(1, -2, columnaCaballo, filaCaballo, turno, peones));
		llenar(peones, caballo, turno);
		mejor = Math.min(mejor, intentar(1, 2, columnaCaballo, filaCaballo, turno, peones));
		llenar(peones, caballo, turno);
		mejor = Math.min(mejor, intentar(2, -1, columnaCaballo, filaCaballo, turno, peones));
		llenar(peones, caballo, turno);
		mejor = Math.min(mejor, intentar(2, 1, columnaCaballo, filaCaballo, turno, peones));
		return dp[peones][caballo][turno] = mejor;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			p = sc.nextInt();
			if(p == 0)
				return;
			for(int i = 0; i < p; i++)
			{
				int numero = sc.nextInt() - 1;
				int fila = numero / 8;
				int columna = numero % 8;
				inicialesFila[i] = fila;
				inicialesColumna[i] = columna;
			}
			int caballo = sc.nextInt() - 1;
			int uno8 = 1 << p;
			for(int i = 0; i < uno8; i++)
				for(int j = 0; j < 64; j++)
					for(int k = 0; k < 11; k++)
						dp[i][j][k] = -1;
			int salida = dp((1 << p) - 1, caballo, 0);
			if(salida > 10)
				System.out.println("impossible");
			else
				System.out.println(salida);
		}
	}
}
