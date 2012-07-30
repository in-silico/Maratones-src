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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static boolean[] drop = new boolean[1001];
	static int[] number = new int[1001];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		boolean empezo = false;
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			if(!empezo)
				empezo = true;
			else
				System.out.println();
			for(int i = 0; i < n; i++)
			{
				String s = sc.nextLine();
				drop[i] = s.contains("DROP");
				number[i] = Integer.parseInt(s.split(" ")[1]);
			}
			int a = 0, b = 0;
			for(int i = 0; i < n; i++)
			{
				if(drop[i])
				{
					int nuevos = number[i];
					System.out.println("DROP 1 " + nuevos);
					a += nuevos;
				}
				else
				{
					if(b >= number[i])
					{
						System.out.println("TAKE 2 " + number[i]);
						b -= number[i];
					}
					else
					{
						int entregados = 0;
						if(b != 0)
						{
							System.out.println("TAKE 2 " + b);
							entregados += b;
							b = 0;
						}
						System.out.println("MOVE 1->2 " + a);
						b = a;
						a = 0;
						entregados = number[i] - entregados;
						System.out.println("TAKE 2 " + entregados);
						b -= entregados;
					}
				}
			}
		}
	}
}