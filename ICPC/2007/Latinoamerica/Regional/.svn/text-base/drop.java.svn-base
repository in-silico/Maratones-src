import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class drop
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
	
	static Integer[] dp = new Integer[1594323];
	static final int[] tresA = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323}; 
	
	public static int convertirBase3(int mascara)
	{
		int acum = 0;
		for(int i = 0; i < 13; i++)
		{
			acum += (mascara & 3) * tresA[i];
			mascara >>= 2;
		}
		return acum;
	}
	
	public static int dp(int valor)
	{
		int llave = convertirBase3(valor);
		if(dp[llave] != null)
			return dp[llave];
		int masAlto = -1;
		int valorTemp = valor;
		for(int i = 0; i < 13; i++)
		{
			if((valorTemp & 3) != 0)
				masAlto = i;
			valorTemp >>= 2;
		}
		if(masAlto == -1)
			return dp[llave] = 0;
		int mejor = 0;
		int[] temp = darArreglo(valor);
		for(int j = masAlto; j >= 0; j--)
		{
			if(j + j + 2 <= masAlto + 1)
				break;
			if(j == masAlto ? temp[j] == 2 : temp[j] != 0)
			{
				for(int k = j == masAlto ? j - 1 : j; k >= 0; k--)
				{
					if(k + j + 2 <= masAlto + 1)
						break;
					if(k == j ? temp[k] == 2 : temp[k] != 0)
					{
						temp[masAlto]--;
						temp[j]--;
						temp[k]--;
						mejor = Math.max(mejor, 1 + dp(darValor(temp)));
						temp[masAlto]++;
						temp[j]++;
						temp[k]++;
					}
				}
			}
		}
		int nuevaLlave = valor;
		nuevaLlave &= ~(3 << (masAlto << 1));
		mejor = Math.max(mejor, dp(nuevaLlave));
		return dp[llave] = mejor;
	}

	private static int darValor(int[] temp)
	{
		int res = 0;
		for(int i = 12; i >= 0; i--)
		{
			res <<= 2;
			res |= temp[i];
		}
		return res;
	}

	private static int[] darArreglo(int valor)
	{
		int[] resultado = new int[13];
		for(int i = 0; i < 13; i++)
		{
			resultado[i] = valor & 3;
			valor >>= 2;
		}
		return resultado;
	}

	static int[] acumsA = new int[13];
	static int[] acumsB = new int[13];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < 13; i++)
				acumsA[i] = acumsB[i] = 0;
			boolean a = true;
			for(int i = 0; i < n; i++)
			{
				if(a)
					acumsA[sc.nextInt() - 1]++;
				else
					acumsB[sc.nextInt() - 1]++;
				a = !a;
			}
			int cuentaA = 0;
			int cuentaB = 0;
			for(int i = 0; i < 13; i++)
			{
				cuentaA += acumsA[i] / 3;
				acumsA[i] %= 3;
				cuentaB += acumsB[i] / 3;
				acumsB[i] %= 3;
			}
			if(cuentaA == cuentaB)
			{
				int numeroA = 0;
				int numeroB = 0;
				for(int i = 12; i >= 0; i--)
				{
					numeroA <<= 2;
					numeroA |= acumsA[i];
					numeroB <<= 2;
					numeroB |= acumsB[i];
				}
				int valorA = dp(numeroA);
				int valorB = dp(numeroB);
				if(valorA > valorB)
					System.out.println(1);
				else if(valorA < valorB)
					System.out.println(2);
				else
					System.out.println(0);
			}
			else if(cuentaA > cuentaB)
				System.out.println(1);
			else
				System.out.println(2);
		}
	}

}
