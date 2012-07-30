import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class folding
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
		
		boolean endLine()
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
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("folding.out"));
		System.setIn(new FileInputStream("folding.in"));
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		sc.nextInt();
		int[] knots = new int[n];
		for(int i = 0; i < n; i++)
			knots[i] = sc.nextInt();
		Arrays.sort(knots);
		int[] distances = new int[n];
		int[] distancesB = new int[n];
		for(int i = 1; i < n; i++)
			distances[i] = knots[i] - knots[i - 1];
		for(int i = n - 2; i >= 0; i--)
			distancesB[i] = knots[i + 1] - knots[i];
		int count = 0;
		for(int i = 1; i < n; i++)
		{
			boolean posible = true;
			for(int j = i - 2, k = i + 1; j >= 0 && k < n; j--, k++)
				if(distancesB[j] != distances[k])
				{
					posible = false;
					break;
				}
			if(posible)
				count++;
		}
		for(int i = 1; i < n - 1; i++)
		{
			boolean posible = true;
			for(int j = i - 1, k = i + 1; j >= 0 && k < n; j--, k++)
				if(distancesB[j] != distances[k])
				{
					posible = false;
					break;
				}
			if(posible)
				count++;
		}
		System.out.println(count);
	}

}
