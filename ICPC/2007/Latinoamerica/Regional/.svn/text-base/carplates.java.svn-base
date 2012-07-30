import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;


public class carplates 
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
	
	public static int tipoPlaca(String p)
	{
		if((p.charAt(3) >= 'A' && p.charAt(3) <= 'Z') || (p.charAt(4) >= 'A' && p.charAt(4) <= 'Z'))
			if((p.charAt(3) >= 'A' && p.charAt(3) <= 'Z') && (p.charAt(4) >= 'A' && p.charAt(4) <= 'Z') && !p.contains("A") && !p.contains("C") && !p.contains("M") && !p.contains("I") && !p.contains("P"))
				return 1;
			else
				return 2;
		else
			return 0;
	}
	
	static final long numeroViejas = 10000 * 26 * 26 * 26;
	
	public static long valorPlaca(String s, int tipo)
	{
		if(tipo == 0)
		{
			long parteFinal = Integer.parseInt(s.charAt(6) + "") + 10 * Integer.parseInt(s.charAt(5) + "") + 100 * Integer.parseInt(s.charAt(4) + "") + 1000 * Integer.parseInt(s.charAt(3) + "");
			long parteInicial = 10000 * darValorViejo(s.substring(0, 3));
			return parteFinal + parteInicial;
		}
		else
		{
			long parteFinal = Integer.parseInt(s.charAt(6) + "") + 10 * Integer.parseInt(s.charAt(5) + "");
			long otraParte = 100 * darValorNuevo(s.substring(0, 5));
			return parteFinal + otraParte + numeroViejas;
		}
	}

	private static int darValorViejo(String s) 
	{
		int res = 0;
		for(char c : s.toCharArray())
		{
			res *= 26;
			res += c - 'A';
		}
		return res;
	}

	static StringBuilder sb = new StringBuilder();
	
	private static long darValorNuevo(String s) 
	{
		int res = 0;
		for(char c : s.toCharArray())
		{
			res *= 21;
			res += transformarLetra(c);
		}
		return res;
	}

	private static int transformarLetra(char c) 
	{
		int temp = c - 'A';
		if(c > 'A')
			temp--;
		if(c > 'C')
			temp--;
		if(c > 'M')
			temp--;
		if(c > 'I')
			temp--;
		if(c > 'P')
			temp--;
		return temp;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			String a = sc.next();
			String b = sc.next();
			long diff = (long) sc.nextDouble();
			if(a.equals("*") && b.equals("*") && diff == 0)
				return;
			int tipo = tipoPlaca(b);
			
			if(tipo != 2)
			{
				long diferencia = (valorPlaca(b, tipo) - valorPlaca(a, tipoPlaca(a)));
				if(diferencia > 0 && diferencia <= diff)
					System.out.println("Y");
				else
					System.out.println("N");
			}
			else
				System.out.println("N");
		}
	}
}