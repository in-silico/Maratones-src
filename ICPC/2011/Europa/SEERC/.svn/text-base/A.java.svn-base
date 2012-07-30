import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class A
{
	public static class Digito
	{
		int digito;
		int tam = 0;
		Digito siguiente;

		public Digito(int i)
		{
			digito = i;
		}
	}

	static String[] valores = { "ZERO SIFIR ZERO ZERO",
								 "UNU BIR JEDEN ONE",
								 "DOI IKI DWA TWO",
								 "TREI UC TRZY THREE",
							     "PATRU DORT CZTERY FOUR",
							     "CINCI BES PIEC FIVE",
								 "SASE ALTI SZESC SIX",
								 "SAPTE YEDI SIEDEM SEVEN",
								 "OPT SEKIZ OSIEM EIGHT",
								 "NOUA DOKUZ DZIEWIEC NINE" };
	
	static class Dp
	{
		static final Digito[][][] dp = new Digito[100000][40][8];
		static final char[][] lenguajes = new char[40][];	
		final char[] entrada;
		final int inicioIntervalo;
		final int finIntervalo;
		
		public Dp(int iI, int fI, char[] e)
		{
			inicioIntervalo = iI;
			finIntervalo = fI;
			entrada = e;
			final int tam = e.length;
			for(int i = 0; i < e.length; i++)
				for(int j = inicioIntervalo; j <= finIntervalo; j++)
					for(int k = 0; k < 8; k++)
						dp[i][j][k] = null;
			for(int i = tam; i >= 0; i -= 5000)
				for(int j = inicioIntervalo; j <= finIntervalo; j++)
					for(int k = 0; k < lenguajes[j].length; k++)
						dp(i, j, k);
		}
		
		static Digito NULO = new Digito(-1);
		
		public Digito dp(int posicion, int digito, int pD)
		{
			if(posicion == entrada.length)
				return NULO;
			if(dp[posicion][digito][pD] != null)
				return dp[posicion][digito][pD];
			if(entrada[posicion] == lenguajes[digito][pD])
			{
				if(pD == lenguajes[digito].length - 1)
				{
					Digito actual = new Digito(digito % 10);
					Digito mejor = null;
					for(int i = inicioIntervalo; i <= finIntervalo; i++)
					{
						Digito posible = dp(posicion + 1, i, 0);
						if(posible == NULO)
							continue;
						if(mejor == null)
							mejor = posible;
						else if(posible.tam > mejor.tam)
							mejor = posible;
						else if(posible.tam == mejor.tam)
							mejor = compararMejor(posible, mejor);
					}
					if(mejor != null)
					{
						actual.siguiente = mejor;
						actual.tam = mejor.tam + 1;
					}
					else
					{
						actual.siguiente = NULO;
						actual.tam = 1;
					}
					return dp[posicion][digito][pD] = actual;
				}
				else
					return dp[posicion][digito][pD] = dp(posicion + 1, digito, pD + 1);
			}
			return dp[posicion][digito][pD] = dp(posicion + 1, digito, pD);
		}

		private Digito compararMejor(Digito posible, Digito mejor)
		{
			Digito posibleOriginal = posible;
			Digito mejorOriginal = mejor;
			while(posible != null)
			{
				if(posible.digito > mejor.digito)
					return posibleOriginal;
				else if(posible.digito < mejor.digito)
					return mejorOriginal;
				posible = posible.siguiente;
				mejor = mejor.siguiente;
			}
			return posibleOriginal;
		}
	}
	
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException
	{
		bw = new BufferedWriter(new OutputStreamWriter(System.out), 1000000);
		int indiceNum = 0;
		for(String s : valores)
		{
			StringTokenizer st = new StringTokenizer(s);
			for(int i = 0; i < 4; i++)
				Dp.lenguajes[i * 10 + indiceNum] = st.nextToken().toCharArray();
			indiceNum++;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String next = br.readLine();
			if(next == null)
			{
				bw.flush();
				return;
			}
			final char[] este = next.toCharArray();
			Digito mejor = null;
			for(int i = 0; i < 4; i++)
			{
				Dp dp = new Dp(i * 10, (i + 1) * 10 - 1, este);
				for(int j = dp.inicioIntervalo + 1; j <= dp.finIntervalo; j++)
				{
					Digito posible = dp.dp(0, j, 0);
					if(posible == Dp.NULO)
						continue;
					if(mejor == null)
						mejor = posible;
					else if(posible.tam > mejor.tam)
						mejor = posible;
					else if(posible.tam == mejor.tam)
						mejor = dp.compararMejor(posible, mejor);
				}
			}
			imprimirNumero(mejor);
			bw.write(" ");
			mejor = null;
			Dp dp = new Dp(0, 39, este);
			for(int i = 0; i < 4; i++)
			{
				for(int j = (i * 10) + 1; j <= ((i + 1) * 10) - 1; j++)
				{
					Digito posible = dp.dp(0, j, 0);
					if(posible == Dp.NULO)
						continue;
					if(mejor == null)
						mejor = posible;
					else if(posible.tam > mejor.tam)
						mejor = posible;
					else if(posible.tam == mejor.tam)
						mejor = dp.compararMejor(posible, mejor);
				}
			}
			imprimirNumero(mejor);
			bw.write("\r\n");
		}
	}

	private static void imprimirNumero(Digito mejor) throws IOException 
	{
		while(mejor != null && mejor != Dp.NULO)
		{
			bw.write('0' + (char) mejor.digito);
			mejor = mejor.siguiente;
		}
	}
}
