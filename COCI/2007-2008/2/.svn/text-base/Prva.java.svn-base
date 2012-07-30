import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Prva 
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
	
	static String menor = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
	
	public static void intentarMenor(String s)
	{
		for(String s1 : s.split("#"))
		{
			if(s1.length() < 2)
				continue;
			s1 = s1.toLowerCase();
			if(s1.compareTo(menor) < 0)
				menor = s1;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int r = sc.nextInt();
		int c = sc.nextInt();
		String[] filas = new String[r];
		for(int i = 0; i < r; i++)
			filas[i] = sc.next();
		String[] columnas = new String[c];
		for(int i = 0; i < c; i++)
		{
			columnas[i] = "";
			for(int j = 0; j < r; j++)
				columnas[i] += filas[j].charAt(i);
		}
		for(String s : columnas)
			intentarMenor(s);
		for(String s : filas)
			intentarMenor(s);
		System.out.println(menor);
	}
}
