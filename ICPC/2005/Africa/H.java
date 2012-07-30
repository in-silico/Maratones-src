import java.util.Scanner;


public class H 
{
	static long[][] dp = new long[26][226];
	
	static String entrada;
	
	static long dp(int posicion, int suma)
	{
		if(posicion == entrada.length())
			return 1;
		if(dp[posicion][suma] != -1)
			return dp[posicion][suma];
		long acum = 0;
		for(int i = posicion + 1; i <= entrada.length(); i++)
		{
			int sumaA = 0;
			for(int j = posicion; j < i; j++)
			{
				sumaA += entrada.charAt(j) - '0';
			}
			if(sumaA >= suma)
				acum += dp(i, sumaA);
		}
		return dp[posicion][suma] = acum;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = 1;
		while(true)
		{
			entrada = sc.nextLine().trim();
			if(entrada.equals("bye"))
				return;
			for(int i = 0; i < 26; i++)
				for(int j = 0; j < 226; j++)
					dp[i][j] = -1;
			System.out.print(a++ + ". ");
			System.out.println(dp(0, 0));
		}
	}
}
