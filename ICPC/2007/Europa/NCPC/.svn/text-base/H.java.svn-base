import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class H
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			try
			{
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
		}
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(Exception e)
				{
					throw(new RuntimeException());
				}
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		try
		{
			System.setIn(new FileInputStream("shopaholic.in"));
			Scanner sc = new Scanner();
			int t = sc.nextInt();
			int[] todos = new int[100001];
			for(int caso = 0; caso < t; caso++)
			{
				int n = sc.nextInt();
				for(int i = 0; i < n; i++)
					todos[i] = sc.nextInt();
				Arrays.sort(todos, 0, n);
				LinkedList <Integer> cola = new LinkedList <Integer> ();
				for(int i = 0; i < n; i++)
					cola.addFirst(todos[i]);
				int mejor = 0;
				while(cola.size() >= 3)
				{
					cola.poll();
					cola.poll();
					mejor += cola.poll();
				}
				System.out.println(mejor);
			}
		}
		catch(FileNotFoundException e)
		{
			return;
		}
	}
}
