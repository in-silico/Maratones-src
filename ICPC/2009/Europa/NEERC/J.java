import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class J
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static int[][][] buenasPosibles = new int[101][][];
	
	static void llenarPosibles()
	{
		for(int porcentaje = 0; porcentaje < 101; porcentaje++)
		{
			ArrayList < int[] > a = new ArrayList < int[] > ();
			for(int numero = 1; numero < 101; numero++)
			{
				for(int buenas = 0; buenas <= numero; buenas++)
				{
					int res = new BigDecimal(buenas * 100).divide(new BigDecimal(numero), 0, BigDecimal.ROUND_HALF_EVEN).intValueExact();
					if(res == porcentaje)
					{
						a.add(new int[] {numero, buenas});
						break;
					}
				}
			}
			buenasPosibles[porcentaje] = new int[a.size()][];
			for(int i = 0; i < a.size(); i++)
				buenasPosibles[porcentaje][i] = a.get(i);
		}
	}
	
	static class Respuesta
	{
		int numero;
		int malas;
		int menor;
		Respuesta siguiente;

		public Respuesta(int nu, int ma, int me, Respuesta si)
		{
			numero = nu;
			malas = ma;
			menor = me;
			siguiente = si;
		}
	}
	
	static int[] porcentajes = new int[10];
	static Respuesta[][][] dp = new Respuesta[10][101][101];
	static Respuesta NULO = new Respuesta(0, 0, 0, null);
	static int mTotal;
	static int max;
	
	static Respuesta dp(int m, int k, int n)
	{
		if(m == mTotal)
			return n == 0 && k == 0 ? new Respuesta(0, 0, 0, null) : NULO;
		else if(n - (mTotal - m) < 0)
			return NULO;
		if(dp[m][k][n] != null)
			return dp[m][k][n];
		int maximo = n - (mTotal - m) + 1;
		Respuesta mejor = NULO;
		for(int[] a : buenasPosibles[porcentajes[m]])
		{
			if(a[0] > maximo || a[0] > max)
				break;
			if(a[1] > k)
				continue;
			Respuesta siguiente = dp(m + 1, k - a[1], n - a[0]);
			if(siguiente == NULO)
				continue;
			if(mejor == NULO || Math.min(a[0], siguiente.menor == 0 ? a[0] : siguiente.menor) > mejor.menor)
				mejor = new Respuesta(a[0], a[0] - a[1], Math.min(a[0], siguiente.menor == 0 ? a[0] : siguiente.menor), siguiente);
		}
		return dp[m][k][n] = mejor;
	}
	
	static Respuesta encontrarMejor(int k, int n)
	{
		int mejorDiferencia = n + 1;
		Respuesta mejorRespuesta = NULO;
		for(max = 1; max <= 100; max++)
		{
			if(max + (max - mejorDiferencia) * (mTotal - 1) > n)
				break;
			for(int i = 0; i < mTotal; i++)
				for(int j = 0; j <= k; j++)
					for(int l = 0; l <= n; l++)
						dp[i][j][l] = null;
			Respuesta mejor = dp(0, k, n);
			if(mejor != NULO && (mejorRespuesta == NULO || max - mejor.menor < mejorDiferencia))
			{
				mejorRespuesta = mejor;
				mejorDiferencia = max - mejor.menor;
			}
		}
		return mejorRespuesta;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		llenarPosibles();
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int k = sc.nextInt();
			int n = sc.nextInt();
			mTotal = sc.nextInt();
			for(int i = 0; i < mTotal; i++)
				porcentajes[i] = sc.nextInt();
			Respuesta encontrada = encontrarMejor(k, n);
			for(int i = 0; i < mTotal; i++)
			{
				System.out.println(encontrada.malas + " " + encontrada.numero);
				encontrada = encontrada.siguiente;
			}
		}
	}
}
