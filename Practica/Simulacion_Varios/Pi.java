import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;


public class Pi 
{
	static int[] numeros = new int[50];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				numeros[i] = Integer.parseInt(br.readLine());
			int cuenta = 0;
			int coprimos = 0;
			for(int i = 0; i < n; i++)
			{
				for(int j = i + 1; j < n; j++)
				{
					cuenta++;
					if(gcd(numeros[i], numeros[j]) == 1)
						coprimos++;
				}
			}
			if(coprimos == 0)
				System.out.println("No estimate for this data set.");
			else
			{
				double resultado = ((double) coprimos) / cuenta;
				resultado = 6.0 / resultado;
				resultado = Math.sqrt(resultado);
				System.out.println(new BigDecimal(resultado).divide(new BigDecimal(1), 6, BigDecimal.ROUND_HALF_UP));
			}
		}
	}
	private static int gcd(int i, int j) 
	{
		if(j == 0)
			return i;
		return gcd(j, i % j);
	}

}
