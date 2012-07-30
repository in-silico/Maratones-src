import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class Majstor 
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
	
	public static int darResultado(char a, char b)
	{
		if(a == 'R')
			return b == 'S' ? 2 : b == 'R' ? 1 : 0;
		if(a == 'S')
			return b == 'P' ? 2 : b == 'S' ? 1 : 0;
		else
			return b == 'R' ? 2 : b == 'P' ? 1 : 0;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int r = sc.nextInt();
		String steve = sc.next();
		int nAmigos = sc.nextInt();
		String[] amigos = new String[nAmigos];
		for(int i = 0; i < nAmigos; i++)
			amigos[i] = sc.next();
		int score = 0;
		int mejorScore = 0;
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < nAmigos; j++)
				score += darResultado(steve.charAt(i), amigos[j].charAt(i));
			int mejorRonda = 0;
			for(char c : "PRS".toCharArray())
			{
				int scoreR = 0;
				for(int j = 0; j < nAmigos; j++)
					scoreR += darResultado(c, amigos[j].charAt(i));
				if(scoreR > mejorRonda)
					mejorRonda = scoreR;
			}
			mejorScore += mejorRonda;
		}
		System.out.println(score);
		System.out.println(mejorScore);
	}

}
