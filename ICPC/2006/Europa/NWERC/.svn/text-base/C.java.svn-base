import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C 
{
	public static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;

		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next()
		{
			try
			{
				while(st == null || !st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}
	}

	static int n;
	static int f;
	static double[] pasteles = new double[10000];


	static boolean esPosible(double p)
	{
		int cuenta = 0;
		for(int i = 0; i < n; i++)
		{
			cuenta += (int) (pasteles[i] / p);
			if(cuenta >= f)
				return true;
		}
		return false;
	}
	
	static double busquedaBinaria()
	{
		double a = 0;
		double b = 0;
		for(int i = 0; i < n; i++)
			b = Math.max(b, pasteles[i]);
		while(Math.abs(a - b) > 10e-6)
		{
			double medio = (b + a) / 2;
			if(esPosible(medio))
				a = medio;
			else
				b = medio;
		}
		return Math.PI * a;
	}
	
	public static void  main(String[] args)
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 0; caso < t; caso++)
		{
			n = sc.nextInt();
			f = sc.nextInt() + 1;
			for(int i = 0; i < n; i++)
				pasteles[i] = sc.nextInt();
			for(int i = 0; i < n; i++)
				pasteles[i] *= pasteles[i];
			System.out.println(busquedaBinaria());
		}
	}
}
