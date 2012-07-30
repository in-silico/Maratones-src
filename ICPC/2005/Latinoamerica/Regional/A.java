import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A 
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
	
	static boolean[] postes = new boolean[5010];
	static int n;
	
	public static int solucionar()
	{
		int inicio = -1;
		for(int i = 0; i < n; i++)
			if(postes[i])
			{
				inicio = i;
				break;
			}
		int cuenta = 0;
		if(inicio == -1)
		{
			cuenta++;
			postes[0] = true;
			inicio = 0;
		}
		int veces = 0;
		int i = inicio;
		int anterior = 0;
		for(;;)
		{
			if(i == inicio)
				veces++;
			if(veces == 2)
				break;
			if(postes[i])
				anterior = 0;
			else
			{
				anterior += 2;
				if(anterior == 4)
				{
					cuenta++;
					anterior = 0;
				}
			}
			i++;
			if(i == n)
				i = 0;
		}
		return cuenta;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				postes[i] = sc.nextInt() == 1;
			System.out.println(solucionar());
		}
	}
}
