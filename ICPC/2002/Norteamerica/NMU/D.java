import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D 
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
	
	static boolean palindrome(char[] palabra)
	{
		int a = 0;
		int b = palabra.length - 1;
		while(a < b)
		{
			if(palabra[a++] != palabra[b--])
				return false;
		}
		return true;
	}
	
	static boolean near(char[] palabra)
	{
		boolean si = false;
		for(int i = 0; i < palabra.length; i++)
		{
			char actual = palabra[i];
			for(char j = 'A'; j <= 'Z'; j++)
			{
				if(j == actual)
					continue;
				palabra[i] = j;
				if(palindrome(palabra))
				{
					si = true;
					break;
				}
			}
			palabra[i] = actual;
			if(si)
				break;
		}
		return si;
	}
	
	static boolean doubleNear(String palabra)
	{
		for(int i = 1; i < palabra.length(); i++)
		{
			String a = palabra.substring(0, i);
			String b = palabra.substring(i);
			if(near(a.toCharArray()) && near(b.toCharArray()))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			String entrada = sc.next();
			if(entrada.equals("*END*"))
				return;
			if(doubleNear(entrada))
				System.out.println(entrada + " is a double near palindrome.");
			else
				System.out.println(entrada + " is not a double near palindrome.");
		}
	}
}
