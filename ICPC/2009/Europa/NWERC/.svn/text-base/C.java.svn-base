import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class C 
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
	
	static int[] acum = new int[1000001];
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("C.in"));
		Scanner sc = new Scanner();
		int c = sc.nextInt();
		for(int a = 0; a < c; a++)
		{
			int d = sc.nextInt();
			int n = sc.nextInt();
			for(int i = 0; i < d; i++)
				acum[i] = 0;
			acum[0]++;
			int ant = 0;
			int total = 0;
			for(int i = 0; i < n; i++)
			{
				ant += sc.nextInt();
				ant %= d;
				total += acum[ant];
				acum[ant]++;
			}
			System.out.println(total);
		}
	}
}
