import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class G 
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
	
	static boolean orden;
	
	static class Arista
	{
		boolean normal;
		Nodo otro;
		
		public Arista(Nodo otro, boolean normal)
		{
			this.normal = normal;
			this.otro = otro;
		}
	}
	
	static class Nodo
	{
		ArrayList <Arista> aristas = new ArrayList <Arista> ();
		boolean visitado = false;
		int numero;
		
		public Nodo(int n)
		{
			numero = n;
		}
	}
	
	private static void dfs(Nodo nodo) 
	{
		if(nodo.visitado)
			return;
		nodo.visitado = true;
		for(Arista a : nodo.aristas)
		{
			if(a.normal == orden)
				dfs(a.otro);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		Nodo[] nodosEnOrden = new Nodo[1001];
		Nodo[] nodosEnDesorden = new Nodo[1001];
		while(!sc.endLine())
		{
			int n = sc.nextInt();
			for(int i = 0; i <= 1000; i++)
				nodosEnOrden[i] = new Nodo(i);
			for(int i = 0; i < n; i++)
			{
				int val = sc.nextInt();
				Nodo actual = nodosEnOrden[val];
				int nVecinos = sc.nextInt();
				nodosEnDesorden[i] = actual;
				for(int j = 0; j < nVecinos; j++)
				{
					int otra = sc.nextInt();
					actual.aristas.add(new Arista(nodosEnOrden[otra], true));
					nodosEnOrden[otra].aristas.add(new Arista(actual, false));
				}
			}
			orden = false;
			int cuenta = 0;
			for(int i = 0; i <= 1000; i++)
				nodosEnOrden[i].visitado = false;
			dfs(nodosEnOrden[0]);
			for(int i = 0; i < n; i++)
				if(!nodosEnDesorden[i].visitado)
				{
					cuenta++;
					System.out.println("TRAPPED " + nodosEnDesorden[i].numero);
				}
			orden = true;
			for(int i = 0; i <= 1000; i++)
				nodosEnOrden[i].visitado = false;
			dfs(nodosEnOrden[0]);
			for(int i = 0; i < n; i++)
				if(!nodosEnDesorden[i].visitado)
				{
					cuenta++;
					System.out.println("UNREACHABLE " + nodosEnDesorden[i].numero);
				}
			if(cuenta == 0)
				System.out.println("NO PROBLEMS");
		}
	}
}