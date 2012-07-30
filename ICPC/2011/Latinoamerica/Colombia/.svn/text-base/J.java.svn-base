import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
	
	static class Viaje
	{
		int tiempo;
		int bollos;
		
		public Viaje(int tiempo, int bollos) 
		{
			this.tiempo = tiempo;
			this.bollos = bollos;
		}
	}
	
	static Viaje[] viajes = new Viaje[100];
	static Integer[][] dp = new Integer[105][105];
	static int n;
	
	public static int dp(int viaje, int bollos)
	{
		if(bollos > n)
			bollos = n;
		if(dp[viaje][bollos] != null)
			return dp[viaje][bollos];
		if(viaje == n)
			return dp[viaje][bollos] = 0;
		int mejor = Integer.MAX_VALUE;
		if(bollos > 0)
			mejor = Math.min(mejor, viajes[viaje].tiempo / 2 + dp(viaje + 1, bollos - 1 + viajes[viaje].bollos));
		mejor = Math.min(mejor, viajes[viaje].tiempo + dp(viaje + 1, bollos + viajes[viaje].bollos));
		return dp[viaje][bollos] = mejor;
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
				viajes[i] = new Viaje(sc.nextInt(), sc.nextInt());
			for(int i = 0; i <= n; i++)
				for(int j = 0; j < 105; j++)
					dp[i][j] = null;
			System.out.println(dp(0, 0));
		}
	}

}
