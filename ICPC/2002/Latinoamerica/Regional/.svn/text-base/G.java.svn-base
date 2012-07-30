import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class G 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
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
	}
	
	static int[][] original = new int[500][500];
	static int[][] referencia = new int[500][500];
	static int[][] referenciaO = new int[500][500];
	static int n;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					original[i][j] = sc.nextInt();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referencia[i][j] = sc.nextInt();
			int maximo = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[i][j] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referencia[i][j] = referenciaO[i][j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[j][n - 1 - i] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referencia[i][j] = referenciaO[i][j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[j][n - 1 - i] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referencia[i][j] = referenciaO[i][j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[j][n - 1 - i] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[i][n - 1 - j] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referencia[i][j] = referenciaO[i][j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[j][n - 1 - i] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referencia[i][j] = referenciaO[i][j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[j][n - 1 - i] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referencia[i][j] = referenciaO[i][j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					referenciaO[j][n - 1 - i] = referencia[i][j];
			maximo = Math.max(maximo, intentar());
			System.out.printf("%.2f\n", (((double) maximo) / ((double) n * n)) * 100.0);
		}
	}
	
	static int intentar()
	{
		int cuenta = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(Math.abs(original[i][j] - referenciaO[i][j]) <= 100)
					cuenta++;
		return cuenta;
	}

}
