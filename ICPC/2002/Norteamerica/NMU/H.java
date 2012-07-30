import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class H
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
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int cuenta = 1;
		while(true)
		{
			int[] tiempo = new int[3];
			int[] intentos = new int[3];
			for(int i = 0; i < 3; i++)
			{
				try
				{
					tiempo[i] = sc.nextInt();
				}
				catch(Exception e)
				{
					return;
				}
			}
			for(int i = 0; i < 3; i++)
			{
				intentos[i] = sc.nextInt();
			}
			int resueltos = 0;
			int tomo = 0;
			for(int i = 0; i < 3; i++)
			{
				if(tiempo[i] > 0)
				{
					resueltos++;
					tomo += tiempo[i] + (intentos[i] - 1) * 20 * 60;
				}
			}
			System.out.println("team " + cuenta++ + ": " + resueltos + ", " + tomo);
		}
	}
}
