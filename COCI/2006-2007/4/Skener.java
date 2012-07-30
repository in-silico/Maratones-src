import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Skener 
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
		int r = sc.nextInt();
		int c = sc.nextInt();
		int zr = sc.nextInt();
		int zc = sc.nextInt();
		char[][] original = new char[r][];
		for(int i = 0; i < r; i++)
			original[i] = sc.next().toCharArray();
		char[][] salida = new char[r * zr][c * zc];
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				for(int k = i * zr; k < i * zr + zr; k++)
					for(int l = j * zc; l < j * zc + zc; l++)
						salida[k][l] = original[i][j];
		for(int i = 0; i < r * zr; i++)
			System.out.println(new String(salida[i]));
	}
}