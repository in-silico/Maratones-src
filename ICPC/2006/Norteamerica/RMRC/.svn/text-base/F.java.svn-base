import java.util.Scanner;


public class F
{
	
	static class Respuesta
	{
		Respuesta siguiente;
		String esta;
		int numero;
		
		public Respuesta(Respuesta r, String e, int n)
		{
			siguiente = r;
			esta = e;
			numero = n;
		}

		public Respuesta clonar(int a, int b, int c) 
		{
			Respuesta mejor = this;
			return new Respuesta(mejor, imprimir(a, b, c), mejor.numero + 1);
		}

		private static String imprimir(int a, int b, int c)
		{
			return four(a) + four(b) + four(c);
		}

		private static String four(int a) 
		{
			String s = a + "";
			while(s.length() != 4)
				s = " " + s;
			return s;
		}
	}
	
	static Respuesta[][][] dp = new Respuesta[183][183][183];
	
	
	public static Respuesta dp(int a, int b, int c)
	{
		if(a == b && b == c)
			return dp[a][b][c] = new Respuesta(null, Respuesta.imprimir(a, b, c), 0);
		if(dp[a][b][c] != null)
			return dp[a][b][c];
		dp[a][b][c] = new Respuesta(null, null, -2);
		Respuesta mejor = new Respuesta(null, null, -2);
		if(a > b)
			mejor = minimo(mejor, dp(a - b, 2 * b, c));
		if(a > c)
			mejor = minimo(mejor, dp(a - c, b, 2 * c));
		if(b > a)
			mejor = minimo(mejor, dp(2 * a, b - a, c));
		if(b > c)
			mejor = minimo(mejor, dp(a, b - c, 2 * c));
		if(c > a)
			mejor = minimo(mejor, dp(2 * a, b, c - a));
		if(c > b)
			mejor = minimo(mejor, dp(a, 2 * b, c - b));
		return dp[a][b][c] = mejor.numero == -2 ? mejor : mejor.clonar(a, b, c);
	}
	
	private static Respuesta minimo(Respuesta a, Respuesta b)
	{
		if(b.numero < 0)
			return a;
		else if(a.numero < 0)
			return b;
		return a.numero < b.numero ? a : b;
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 183; i++)
			for(int j = 0; j < 183; j++)
				for(int k = 0; k < 183; k++)
					dp[i][j][k] = null;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			dp[a][b][c] = null;
			Respuesta siguiente = dp(a, b, c);
			if(siguiente.numero == -2 || siguiente == null)
				System.out.println(Respuesta.imprimir(a, b, c));
			else
				while(siguiente != null)
				{
					System.out.println(siguiente.esta);
					siguiente = siguiente.siguiente;
				}
			System.out.println("============");
		}
	}
}
