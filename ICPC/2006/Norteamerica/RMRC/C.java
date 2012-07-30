import java.util.Scanner;

public class C 
{	
	public static class RespuestaM
	{
		public int factor;
		public int numero;
		RespuestaM siguiente;
		
		public RespuestaM(int ff, int nn, RespuestaM r)
		{
			factor = ff;
			numero = nn;
			siguiente = r;
		}

		public RespuestaM duplicar(int i)
		{
			return new RespuestaM(i, numero + 2 + i, this);
		}

		public String toString() 
		{
			if(siguiente != null)
				return imprimir(factor) + "x" + siguiente;
			return imprimir(factor) + "";
		}
		
		public static String imprimir(int n)
		{
			StringBuilder sb = new StringBuilder(n);
			for(int i = 0; i < n; i++)
				sb.append('|');
			return sb.toString();
		}
	}
	
	static RespuestaM [] dpMultiplicacion = new RespuestaM[5001];
	
	static RespuestaM dpM(int n)
	{
		if(dpMultiplicacion[n] !=  null)
			return dpMultiplicacion[n];
		RespuestaM r = new RespuestaM(n, n, null);
		for(int i = 2; i < n; i++)
			if(n % i == 0)
			{
				RespuestaM posible = dpM(n / i);
				if(posible.numero + 2 + i < r.numero)
					r = posible.duplicar(i);
			}
		return dpMultiplicacion[n] = r;
	}
	
	public static class Respuesta
	{
		int numero;
		RespuestaM factor;
		Respuesta siguiente;
		
		public Respuesta(int n, RespuestaM f, Respuesta s)
		{
			numero = n;
			factor = f;
			siguiente = s;
		}

		public Respuesta duplicar(RespuestaM esta) 
		{
			return new Respuesta(esta.numero + numero + 2, esta, this);
		}

		public String toString() 
		{
			if(siguiente != null)
				return factor + "+" + siguiente;
			else
				return factor + "";
		}
	}

	static Respuesta [] dp = new Respuesta[5001];
	
	static Respuesta dp(int n)
	{
		if(dp[n] != null)
			return dp[n];
		RespuestaM solo = dpM(n);
		Respuesta r = new Respuesta(solo.numero, solo, null);
		for(int i = 1; i < n; i++)
		{
				Respuesta posible = dp(n - i);
				RespuestaM esta = dpM(i);
				if(posible.numero + 2 + esta.numero < r.numero)
					r = posible.duplicar(esta);
		}
		return dp[n] = r;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int n = sc.nextInt();
			Respuesta r = dp(n);
			System.out.println(r.numero + " toothpicks: " + r + "=" + n);
		}
	}
}