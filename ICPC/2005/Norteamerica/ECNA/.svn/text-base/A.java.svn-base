import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A 
{

	static Integer[][][] dp = new Integer[1000][1000][2];
	static int[] numeros = new int[1000];
	
	static int simular(int izquierda, int derecha, boolean quien)
	{
		if(izquierda > derecha)
			return 0;
		if(dp[izquierda][derecha][quien ? 1 : 0] != null)
			return dp[izquierda][derecha][quien ? 1 : 0];
		if(quien)
		{
			int a = numeros[izquierda] + simular(izquierda + 1, derecha, !quien);
			int b = numeros[derecha] + simular(izquierda, derecha - 1, !quien);
			return dp[izquierda][derecha][1] = Math.max(a, b);
		}
		else
		{
			if(numeros[izquierda] >= numeros[derecha])
				return dp[izquierda][derecha][0] = -numeros[izquierda] + simular(izquierda + 1, derecha, !quien);
			else
				return dp[izquierda][derecha][0] = -numeros[derecha] + simular(izquierda, derecha - 1, !quien);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		while(true)
		{
			String[] pedazos = br.readLine().split("\\s+");
			int numero = Integer.parseInt(pedazos[0]);
			if(numero == 0)
				return;
			for(int i = 0; i < numero; i++)
				numeros[i] = Integer.parseInt(pedazos[i + 1]);
			for(int i = 0; i < numero; i++)
				for(int j = i; j < numero; j++)
					for(int k = 0; k < 2; k++)
						dp[i][j][k] = null;
			System.out.println("In game " + caso++ + ", the greedy strategy might lose by as many as " + simular(0, numero - 1, true) + " points.");
		}
	}
}
