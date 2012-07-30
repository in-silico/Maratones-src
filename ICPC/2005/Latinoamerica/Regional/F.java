import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class F
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
	
	static int[] genoma = new int[50001];
	
	static void revertir(int a, int b)
	{
		int mitad = (a + b) / 2;
//		if(((a + b) % 2) == 0)
//			mitad++;
		int j = 0;
		for(int i = a; i <= mitad; i++)
		{
			int temp = genoma[i];
			genoma[i] = genoma[b - j];
			genoma[b - j] = temp;
			j++;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		genoma[0] = -1;
		int caso = 1;
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			System.out.println("Genome " + caso++);
			for(int i = 1; i <= n; i++)
				genoma[i] = i;
			int r = sc.nextInt();
			for(int i = 0; i < r; i++)
				revertir(sc.nextInt(), sc.nextInt());
			int q = sc.nextInt();
			for(int i = 0; i < q; i++)
			{
				int numero = sc.nextInt();
				for(int j = 1; j <= n; j++)
				{
					if(genoma[j] == numero)
					{
						System.out.println(j);
						break;
					}
				}
			}
		}
	}

}
