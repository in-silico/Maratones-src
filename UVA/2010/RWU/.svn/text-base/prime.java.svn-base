import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class prime 
{
	static boolean[] primos = new boolean[100001];
	
	public static void iniciarPrimos()
	{
		primos[0] = false;
		primos[1] = false;
		for(int i = 2; i <= 100000; i++)
			primos[i] = true;
		for(int i = 0; i <= 100000; i++)
		{
			if(primos[i])
			{
				for(int j = 2 * i; j <= 100000; j += i)
					primos[j] = false;
			}
		}
	}
	
	public static boolean primo(int i)
	{
		if(i < 2)
			return false;
		else return primos[i];
	}
	
	static Boolean[][] dp = new Boolean[200][200];
	static int[] arreglo = new int[200];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		iniciarPrimos();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().replace(" ", ""));
		for(int i = 0; i < t; i++)
		{
			System.out.print("Case " + (i + 1) + ": ");
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			pedazos = br.readLine().split(" ");
			for(int j = 0; j < pedazos.length; j++)
			{
				arreglo[j] = Integer.parseInt(pedazos[j]);
			}
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < n; k++)
				{
					dp[j][k] = null;
				}
			}
			if(jugar(0, n - 1))
				System.out.println("Soha");
			else
				System.out.println("Tara");
		}
	}

	private static boolean jugar(int menor, int mayor) 
	{
		if(menor > mayor)
			return false;
		if(dp[menor][mayor] != null)
			return dp[menor][mayor];
		int cuenta = 0;
		boolean tiene42 = false;
		for(int i = menor; i <= mayor; i++)
		{
			cuenta += arreglo[i];
			if(arreglo[i] == 42)
				tiene42 = true;
			if(tiene42 || primo(cuenta))
			{
				if(!jugar(i + 1, mayor))
				{
					dp[menor][mayor] = true;
					return true;
				}
			}
		}
		cuenta = 0;
		tiene42 = false;
		for(int i = mayor; i >= menor; i--)
		{
			cuenta += arreglo[i];
			if(arreglo[i] == 42)
				tiene42 = true;
			if(tiene42 || primo(cuenta))
			{
				if(!jugar(menor, i - 1))
				{
					dp[menor][mayor] = true;
					return true;
				}
			}
		}
		dp[menor][mayor] = false;
		return false;
	}

}
