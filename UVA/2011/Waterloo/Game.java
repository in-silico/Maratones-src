import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game
{
	static Boolean dp[][][][][][][][] = new Boolean[5][5][5][5][5][5][32][2];
	
	static boolean dp(int a, int b, int c, int d, int e, int f, int contador, boolean quien)
	{
		if(contador > 31)
			return quien;
		else if(dp[a][b][c][d][e][f][contador][quien ? 1 : 0] != null)
			return dp[a][b][c][d][e][f][contador][quien ? 1 : 0];
		if(a != 0 && dp(a - 1, b, c, d, e, f, contador + 1, !quien) == quien)
			return dp[a][b][c][d][e][f][contador][quien ? 1 : 0] = quien;
		if(b != 0 && dp(a, b - 1, c, d, e, f, contador + 2, !quien) == quien)
			return dp[a][b][c][d][e][f][contador][quien ? 1 : 0] = quien;
		if(c != 0 && dp(a, b, c - 1, d, e, f, contador + 3, !quien) == quien)
			return dp[a][b][c][d][e][f][contador][quien ? 1 : 0] = quien;
		if(d != 0 && dp(a, b, c, d - 1, e, f, contador + 4, !quien) == quien)
			return dp[a][b][c][d][e][f][contador][quien ? 1 : 0] = quien;
		if(e != 0 && dp(a, b, c, d, e - 1, f, contador + 5, !quien) == quien)
			return dp[a][b][c][d][e][f][contador][quien ? 1 : 0] = quien;
		if(f != 0 && dp(a, b, c, d, e, f - 1, contador + 6, !quien) == quien)
			return dp[a][b][c][d][e][f][contador][quien ? 1 : 0] = quien;
		return dp[a][b][c][d][e][f][contador][quien ? 1 : 0] = !quien;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	public static int leerNumero() throws NumberFormatException, IOException
	{
		return Integer.parseInt(br.readLine());
	}
	
	public static void main(String[] args) throws IOException
	{
		while(true)
		{
			String s = br.readLine();
			if(s == null)
				return;
			int[] cartas = new int[7];
			int contador = 0;
			for(char c : s.toCharArray())
			{
				cartas[c - '0']++;
				contador += c - '0';
			}
			for(int a = 0; a <= cartas[1]; a++)
				for(int b = 0; b <= cartas[2]; b++)
					for(int c = 0; c <= cartas[3]; c++)
						for(int d = 0; d <= cartas[4]; d++)
							for(int e = 0; e <= cartas[5]; e++)
								for(int f = 0; f <= cartas[6]; f++)
									for(int contador1 = 0; contador1 <= 31; contador1++)
										for(int quien = 0; quien < 2; quien++)
											dp[a][b][c][d][e][f][contador1][quien] = null;
			System.out.println(s + (dp(4 - cartas[1], 4 - cartas[2], 4 - cartas[3], 4 - cartas[4], 4 - cartas[5], 4 - cartas[6], contador, s.length() % 2 == 0) ? " A" : " B"));
		}
	}
}
