import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Zima 
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
		int n = sc.nextInt();
		boolean[] winter = new boolean[n];
		int[] valores = new int[n];
		for(int i = 0; i < n; i++)
			valores[i] = sc.nextInt();
		int inicioWinter = -1;
		int mejorWinter = 0;
		LinkedList <Integer> mejores = new LinkedList <Integer> ();
		for(int i = 0; i <= n; i++)
		{
			if(i != n && valores[i] < 0)
			{
				if(inicioWinter == -1)
					inicioWinter = i;
			}
			else
			{
				if(inicioWinter != -1)
				{
					int t = i - inicioWinter;
					if(t > mejorWinter)	
					{
						mejorWinter = t;
						mejores.clear();
					}
					if(t == mejorWinter)
						mejores.add(inicioWinter);
					int limiteInferior = inicioWinter - (t << 1);
					for(int j = inicioWinter - 1; j >= 0 && j >= limiteInferior; j--)
						winter[j] = true;
				}
				inicioWinter = -1;
			}
		}
		int cuenta = 0;
		for(int i = 0; i < n; i++)
			if(winter[i])
				cuenta++;
		int mejorCuenta = 0;
		for(int inicioW : mejores)
		{
			int limiteInferior = inicioW - (mejorWinter * 3);
			int cuentaInterna = 0;
			for(int j = inicioW - 1; j >= 0 && j >= limiteInferior; j--)
				if(!winter[j])
					cuentaInterna++;
			mejorCuenta = Math.max(mejorCuenta, cuentaInterna);
		}
		System.out.println(cuenta + mejorCuenta);
	}

}
