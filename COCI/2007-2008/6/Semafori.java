import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Semafori
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
	
	
 
	static class Semaforo
	{
		int donde;
		int rojo;
		int verde;
		boolean actual = true;
		int actualN = 0;
		
		public Semaforo(int d, int r, int v)
		{
			donde = d;
			rojo = r;
			verde = v;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int l = sc.nextInt();
		Semaforo[] semaforos = new Semaforo[n];
		for(int i = 0; i < n; i++)
			semaforos[i] = new Semaforo(sc.nextInt(), sc.nextInt(), sc.nextInt());
		int cuenta = 0;
		for(int i = 1; i < l; i++)
		{
			for(int j = 0; j < n; j++)
				if(semaforos[j].donde == i && semaforos[j].actual)
				{
					i--;
				}
			for(int j = 0; j < n; j++)
			{
				semaforos[j].actualN++;
				if(semaforos[j].actual && semaforos[j].actualN == semaforos[j].rojo)
				{
					semaforos[j].actual = false;
					semaforos[j].actualN = 0;
				}
				else if(!semaforos[j].actual && semaforos[j].actualN == semaforos[j].verde)
				{
					semaforos[j].actual = true;
					semaforos[j].actualN = 0;
				}	
			}
			cuenta++;
		}
		System.out.println(cuenta);
	}

}
