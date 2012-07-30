import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class G 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
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
	}
	
	static int n;
	static String[] songs = new String[30];
	
	
	static int tamano(int q)
	{
		int actual = n;
		for(int i = 1; ;)
		{
			if(q <= actual)
				return i;
			actual += Math.pow(n, ++i) * i;
		}
	}
	
	static int cuenta(int a)
	{
		int actual = 0;
		for(int i = 1; i < a; i++)
			actual += Math.pow(n, i) * i;
		return actual;
	}
	
	static int cuenta2(int a)
	{
		if(a == 1)
			return 1;
		int actual = 0;
		for(int i = 1; i < a; i++)
			actual += Math.pow(n, i);
		return actual;
	}
	
	static int query(int q)
	{
		int t = tamano(q);
		q -= cuenta(t);
		char[] s = new char[t];
		for(int i = 0; i < t; i++)
		{
			if(i == t)
				return q - 1;
			for(int j = 0; j < n; j++)
			{
				if(q <= i)
					return s[q - 1];
				int actual = ((int) Math.pow(n, t - i - 1)) * t;
				if(actual >= q)
				{
					s[i] = (char) j;
					break;
				}
				else
					q -= actual;
				if(q == 0)
					return j;
			}
		}
		return s[q - 1];
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner();
		System.setOut(new PrintStream("salida.txt"));
		while(true)
		{
			n = sc.nextInt();
			int q = sc.nextInt();
			if(n == 0 && q == 0)
				return;
			for(int i = 0; i < n; i++)
				songs[i] = sc.next();
			for(int i = 0; i < q; i++)
				System.out.println(songs[query(sc.nextInt())]);
			System.out.println();
		}
	}
}
