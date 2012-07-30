import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G 
{
	static int[][][] dp = new int[64][64][64];
	
	static final int PERDIO = -1;
	static final int GANO = 1;
	static final int ATRAPADO = 0;
	
	static final int PARED = 0;
	static final int TELEFONO = 1;
	static final int LIBRE = 2;
	
	static int x(int a)
	{
		return a / 8;
	}
	
	static int y(int a)
	{
		return a % 8;
	}
	
	static int convertir(int x, int y)
	{
		return x * 8 + y;
	}
	
	static int[][] delta = new int[][] {{0, 0}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	
	static int[][] mapa = new int[8][8];
	
	static boolean cambio = false;
	
	static int jugar(int j, int a1, int a2)
	{
		int xj = x(j);
		int yj = y(j);
		int xa1 = x(a1);
		int ya1 = y(a1);
		int xa2 = x(a2);
		int ya2 = y(a2);
		if(mapa[xj][yj] == PARED || mapa[xa1][ya1] == PARED || mapa[xa2][ya2] == PARED)
			return dp[j][a1][a2] = 3;
		if(j == a1 || j == a2)
		{
			cambio = true;
			return dp[j][a1][a2] = PERDIO;
		}
		if(mapa[xj][yj] == TELEFONO)
		{
			cambio = true;
			return dp[j][a1][a2] = GANO;
		}
		int perdio = 0;
		int intentos = 0;
		for(int[] a : delta)
		{
			int xNuevoJ = xj + a[0];
			int yNuevoJ = yj + a[1];
			try
			{
				if(mapa[xNuevoJ][yNuevoJ] == PARED)
					continue;	
			}
			catch(Exception e)
			{
				continue;
			}
			intentos++;
			boolean perdioEste = false;
			int vecesGano = 0;
			int vecesAtrapado = 0;
			if(mapa[xNuevoJ][yNuevoJ] == TELEFONO && convertir(xNuevoJ, yNuevoJ) != a1 && convertir(xNuevoJ, yNuevoJ) != a2)
			{
				cambio = true;
				return dp[j][a1][a2] = GANO;
			}
			for(int[] b : delta)
			{
				int xNuevoA1 = xa1 + b[0];
				int yNuevoA1 = ya1 + b[1];
				try
				{
					if(mapa[xNuevoA1][yNuevoA1] == PARED)
						continue;
				}
				catch(Exception e)
				{
					continue;
				}
				for(int[] c : delta)
				{
					int xNuevoA2 = xa2 + c[0];
					int yNuevoA2 = ya2 + c[1];
					try
					{
						if(mapa[xNuevoA2][yNuevoA2] == PARED)
							continue;
					}
					catch(Exception e)
					{
						continue;
					}
					int siguiente = dp[convertir(xNuevoJ, yNuevoJ)][convertir(xNuevoA1, yNuevoA1)][convertir(xNuevoA2, yNuevoA2)];
					if(siguiente == PERDIO)
					{
						perdioEste = true;
						break;
					}
					else if(siguiente == GANO)
					{
						vecesGano++;
					}
					else
					{
						vecesAtrapado++;
					}
				}
				if(perdioEste)
				{
					break;
				}
			}
			if(perdioEste)
			{
				perdio++;
			}
			else if(vecesGano > 0 && vecesAtrapado == 0)
			{	
				cambio = true;
				return dp[j][a1][a2] = GANO;
			}
		}
		dp[j][a1][a2] = perdio > 0 && perdio == intentos ? PERDIO : ATRAPADO;
		if(dp[j][a1][a2] == PERDIO)
			cambio = true;
		return dp[j][a1][a2];
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int caso = 0; caso < n; caso++)
		{
			int jugador = 0;
			int agenteA = -1;
			int agenteB = -1;
			for(int i = 0; i < 8; i++)
			{
				char[] entrada = br.readLine().toCharArray();
				for(int j = 0; j < 8; j++)
				{
					if(entrada[j] == '#')
						mapa[i][j] = PARED;
					else if(entrada[j] == 'P')
						mapa[i][j] = TELEFONO;
					else if(entrada[j] == '.')
						mapa[i][j] = LIBRE;
					else
					{
						mapa[i][j] = LIBRE;
						if(entrada[j] == 'M')
							jugador = convertir(i, j);
						else if(agenteA == -1)
							agenteA = convertir(i, j);
						else
							agenteB = convertir(i, j);
					}
				}
			}
			for(int i = 0; i < 64; i++)
			{
				for(int j = 0; j < 64; j++)
				{
					for(int k = 0; k < 64; k++)
					{
						dp[i][j][k] = 0;
					}
				}
			}
			cambio = true;
			while(cambio)
			{
				cambio = false;
				for(int i = 0; i < 64; i++)
				{
					for(int j = 0; j < 64; j++)
					{
						for(int k = 0; k < 64; k++)
						{

							if(dp[i][j][k] == 0)
							{
								jugar(i, j, k);
							}
								
						}
					}
				}
			}
			if(dp[jugador][agenteA][agenteB] == -1)
				System.out.println("You are eliminated.");
			else if(dp[jugador][agenteA][agenteB] == 0)
				System.out.println("You are trapped in the Matrix.");	
			else
				System.out.println("You can escape.");
			if(caso != n - 1)
				br.readLine();
		}
	}
}