import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B 
{
	static class Goodie implements Comparable <Goodie>
	{
		int petra;
		int jan;

		public Goodie(String p, String j)
		{
			petra = Integer.parseInt(p);
			jan = Integer.parseInt(j);
		}
		
		public int compareTo(Goodie o) 
		{
			if(petra == o.petra)
				return Integer.valueOf(jan).compareTo(o.jan);
			return -Integer.valueOf(petra).compareTo(o.petra);
		}
	}
	
	static class Respuesta
	{
		int petra;
		int jan;
		
		public Respuesta(int p, int j)
		{
			petra = p;
			jan = j;
		}
	}
	
	static int n;
	static Goodie[] goodies = new Goodie[1001];
	static Respuesta[][] dp = new Respuesta[1001][1001];
	
	
	static Respuesta buscar(int actual, int turnos)
	{
		if(actual == n)
			return new Respuesta(0, 0);
		if(dp[actual][turnos] != null)
			return dp[actual][turnos];
		if(actual == n - 1)
		{
			return dp[actual][turnos] = new Respuesta(0, goodies[actual].jan);
		}
		if(n - actual - 1 == turnos)
		{
			Respuesta siguiente = buscar(actual + 1, turnos - 1);
			return dp[actual][turnos] = new Respuesta(siguiente.petra, siguiente.jan + goodies[actual].jan);
		}
		if(turnos > 0)
		{
			Respuesta sinCoger = buscar(actual + 1, turnos + 1);
			Respuesta cogiendo = buscar(actual + 1, turnos - 1);
			Respuesta a = new Respuesta(sinCoger.petra + goodies[actual].petra, sinCoger.jan);
			Respuesta b = new Respuesta(cogiendo.petra, cogiendo.jan + goodies[actual].jan);
			if(a.jan == b.jan)
			{
				if(a.petra < b.petra)
					return dp[actual][turnos] = b;
				return dp[actual][turnos] = a;
			}
			if(a.jan > b.jan)
				return dp[actual][turnos] = a;
			return dp[actual][turnos] = b;
		}
		else
		{
			Respuesta sinCoger = buscar(actual + 1, turnos + 1);
			Respuesta cogiendo = buscar(actual + 2, turnos);
			Respuesta a = new Respuesta(sinCoger.petra + goodies[actual].petra, sinCoger.jan);
			Respuesta b = new Respuesta(cogiendo.petra + goodies[actual + 1].petra, cogiendo.jan + goodies[actual].jan);
			if(a.jan == b.jan)
			{
				if(a.petra < b.petra)
					return dp[actual][turnos] = b;
				return dp[actual][turnos] = a;
			}
			if(a.jan > b.jan)
				return dp[actual][turnos] = a;
			return dp[actual][turnos] = b;
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int aa = 0; aa < tc; aa++)
		{
			n = Integer.parseInt(br.readLine());
			boolean jan = br.readLine().equals("Jan");
			for(int i = 0; i < n; i++)
			{
				String[] pedazos = br.readLine().split(" ");
				goodies[i] = new Goodie(pedazos[0], pedazos[1]);
			}
			Arrays.sort(goodies, 0, n);
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					dp[i][j] = null;
				}
			}
			Respuesta resultado = null;
			if(jan)
				resultado = buscar(0, 0);
			else
			{
				resultado = buscar(1, 0);
				resultado.petra += goodies[0].petra;
			}
			System.out.println(resultado.petra + " " + resultado.jan);
		}
	}

}
