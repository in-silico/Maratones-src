import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class D 
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
	
	static boolean[] visitado = new boolean[1000001];
	static int f, u, d;
	
	static class Entrada
	{	
		int n;
		int pasos;
		
		public Entrada(int n, int pasos) 
		{
			this.n = n;
			this.pasos = pasos;
		}
	}
	
	public static int bfs(int n, int g)
	{
		LinkedList <Entrada> entradas = new LinkedList <Entrada> ();
		visitado[n] = true;
		entradas.add(new Entrada(n, 0));
		while(!entradas.isEmpty())
		{
			Entrada actual = entradas.poll();
			if(actual.n == g)
				return actual.pasos;
			int arriba = actual.n + u;
			if(arriba <= f && arriba >= 0 && !visitado[arriba])
			{
				visitado[arriba] = true;
				entradas.add(new Entrada(arriba, actual.pasos + 1));
			}
			arriba = actual.n - d;
			if(arriba <= f && arriba >= 0 && !visitado[arriba])
			{
				visitado[arriba] = true;
				entradas.add(new Entrada(arriba, actual.pasos + 1));
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			f = sc.nextInt();
			int s = sc.nextInt();
			int g = sc.nextInt();
			u = sc.nextInt();
			d = sc.nextInt();
			for(int i = 0; i <= f; i++)
				visitado[i] = false;
			int res = bfs(s, g);
			if(res == Integer.MAX_VALUE)
				System.out.println("use the stairs");
			else
				System.out.println(res);
				
		}
	}

}
