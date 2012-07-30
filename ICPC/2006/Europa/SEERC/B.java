import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class B 
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
	
	static int[] matriz = new int[100000];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int n = sc.nextInt();
			int s = sc.nextInt();
			for(int i = 0; i < n; i++)
				matriz[i] = sc.nextInt();
			int izquierda = 0;
			int suma = 0;
			int mejor = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++)
			{
				if(suma < s)
				{
					suma += matriz[i];
					if(suma >= s)
					{
						while(izquierda < i && suma > s)
							suma -= matriz[izquierda++];
						if(suma < s)
							suma += matriz[--izquierda];
						mejor = Math.min(i - izquierda + 1, mejor);
					}
				}
				else
				{
					suma += matriz[i];
					while(izquierda < i && suma > s)
						suma -= matriz[izquierda++];
					if(suma < s)
						suma += matriz[--izquierda];
					mejor = Math.min(i - izquierda + 1, mejor);
				}
			}
			System.out.println(mejor == Integer.MAX_VALUE ? 0 : mejor);
		}
	}
}