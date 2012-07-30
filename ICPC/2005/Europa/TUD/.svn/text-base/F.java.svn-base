import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class F 
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
	
	static class Bug
	{
		boolean visitado = false;
		Boolean macho;
		TreeMap <Integer, Bug> interacciones = new TreeMap <Integer, Bug> ();
		
		public boolean visitar(boolean cual)
		{
			if(visitado)
				return cual != macho.booleanValue();
			macho = cual;
			visitado = true;
			for(Bug b : interacciones.values())
			{
				if(b.visitar(!cual))
					return true;
			}
			return false;
		}
	}
	
	static Bug[] bugs = new Bug[2001];
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("a.in"));
		System.setOut(new PrintStream("a.out"));
		for(int i = 1; i < 2001; i++)
			bugs[i] = new Bug();
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int a = 1; a <= n; a++)
		{
			if(a != 1)
				System.out.println();
			int b = sc.nextInt();
			int inte = sc.nextInt();
			for(int i = 1; i <= b; i++)
			{
				bugs[i].interacciones.clear();
				bugs[i].macho = null;
				bugs[i].visitado = false;
			}
			for(int i = 0; i < inte; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				bugs[x].interacciones.put(y, bugs[y]);
				bugs[y].interacciones.put(x, bugs[x]);
			}
			boolean si = false;
			for(int i = 1; i <= b; i++)
			{
				if(!bugs[i].visitado && bugs[i].visitar(false))
				{
					si = true;
					break;
				}		
			}
			System.out.println("Scenario #" + a + ":");
			if(si)
				System.out.println("Suspicious bugs found!");
			else
				System.out.println("No suspicious bugs found!");
		}
	}

}
