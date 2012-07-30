import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Parking 
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
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		boolean[][] park = new boolean[101][3];
		for(int i = 0; i < 3; i++)
		{
			int ar = sc.nextInt();
			int dep = sc.nextInt();
			for(int j = ar; j < dep; j++)
				park[j][i] = true;
		}
		int total = 0;
		for(int i = 0; i < 101; i++)
		{
			int cuenta = 0;
			if(park[i][0])
				cuenta++;
			if(park[i][1])
				cuenta++;
			if(park[i][2])
				cuenta++;
			if(cuenta == 1)
				total += a;
			if(cuenta == 2)
				total += 2 * b;
			if(cuenta == 3)
				total += 3 * c;
		}
		System.out.println(total);
	}

}
