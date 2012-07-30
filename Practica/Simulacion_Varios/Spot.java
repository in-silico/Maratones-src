import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;


public class Spot 
{

	public static boolean[][] tablero = new boolean[50][50];
	public static HashSet <BigInteger> posiciones = new HashSet <BigInteger> (4000);
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					tablero[i][j] = false;
			posiciones.clear();
			boolean termino = false;
			for(int i = 1; i <= 2 * n + 1; i++)
			{
				String[] pedazos = null;
				if(i != 2 * n + 1)
					pedazos = br.readLine().split(" ");
				int a = 0;
				int b = 0;
				if(i != 2 * n + 1)
					a = Integer.parseInt(pedazos[0]);
				if(i != 2 * n + 1)
					b = Integer.parseInt(pedazos[1]);
				if(termino)
					continue;
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < n; j++)
				{
					for(int k = 0; k < n; k++)
					{
						sb.append(tablero[j][k] ? '1' : '0');
					}
				}
				BigInteger primero = new BigInteger(sb.toString());
				sb = new StringBuilder();
				for(int j = 0; j < n; j++)
				{
					for(int k = 0; k < n; k++)
					{
						sb.append(tablero[k][n - 1 - j] ? '1' : '0');
					}
				}
				BigInteger segundo = new BigInteger(sb.toString());
				sb = new StringBuilder();
				for(int j = 0; j < n; j++)
				{
					for(int k = 0; k < n; k++)
					{
						sb.append(tablero[n - 1 - k][j] ? '1' : '0');
					}
				}
				BigInteger tercero = new BigInteger(sb.toString());
				sb = new StringBuilder();
				for(int j = 0; j < n; j++)
				{
					for(int k = 0; k < n; k++)
					{
						sb.append(tablero[n - 1 - j][n - 1 - k] ? '1' : '0');
					}
				}
				BigInteger cuarto = new BigInteger(sb.toString());
				if(posiciones.contains(primero) || posiciones.contains(segundo) || posiciones.contains(tercero) || posiciones.contains(cuarto))
				{
					termino = true;
					System.out.println("Player " + (((i - 1) % 2) + 1) + " wins on move " + (i - 1));
					continue;
				}
				if(i == 2 * n + 1)
					break;
				posiciones.add(primero);
				posiciones.add(segundo);
				posiciones.add(tercero);
				posiciones.add(cuarto);
				tablero[a - 1][b - 1] = !tablero[a - 1][b - 1];
			}
			if(!termino)
			{
				System.out.println("Draw");
			}
		}
	}
	
}
