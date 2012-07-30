import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C 
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
		System.setIn(new FileInputStream("parking.in"));
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 0; caso < t; caso++)
		{
			int n = sc.nextInt();
			int[] todos = new int[n];
			for(int i = 0; i < n; i++)
				todos[i] = sc.nextInt();
			int menor = Integer.MAX_VALUE;
			Arrays.sort(todos, 0, n);
			for(int i = 0; i <= 100; i++)
			{
				int cuenta = (Math.abs(todos[0] - i) + Math.abs(todos[n - 1] - i)) * 2;
				if(cuenta < menor)
					menor = cuenta;
			}
			System.out.println(menor);
		}
	}
}
