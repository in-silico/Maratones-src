import java.util.Scanner;

public class G 
{
	static Integer[][] dp;
	static int[] empleados = new int[24];
	static int contratar;
	static int echar;
	static int salario;
	static int maximo;
	static int nT;
	
	public static int dp(int n, int trabajadores)
	{
		if(n == nT)
			return 0;
		if(dp[n][trabajadores] != null)
			return dp[n][trabajadores];
		int siguiente = Integer.MAX_VALUE;
		if(n + 1 == nT)
			return dp[n][trabajadores] = trabajadores * salario;
		for(int i = 0; i <= trabajadores; i++)
		{
			if(i >= empleados[n + 1])
				siguiente = Math.min(siguiente, dp(n + 1, i) + echar * (trabajadores - i));
		}
		for(int i = trabajadores; i <= maximo; i++)
		{			
			if(i >= empleados[n + 1])
				siguiente = Math.min(siguiente, dp(n + 1, i) + contratar * (i - trabajadores));
		}
		return dp[n][trabajadores] = siguiente + trabajadores * salario;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caso = 1;
		while(true)
		{
			nT = sc.nextInt();
			if(nT == 0)
				return;
			contratar = sc.nextInt();
			salario = sc.nextInt();
			echar = sc.nextInt();
			maximo = 0;
			for(int i = 0; i < nT; i++)
			{
				empleados[i] = sc.nextInt();
				maximo = Math.max(maximo, empleados[i]);
			}
			dp = new Integer[nT][maximo + 1];
			int respuesta = Integer.MAX_VALUE;
			for(int i = empleados[0]; i <= maximo; i++)
				respuesta = Math.min(respuesta, dp(0, i) + contratar * i);
			System.out.println("Case " + caso++ + ", Cost = $" + respuesta);
				
		}
	}
}

