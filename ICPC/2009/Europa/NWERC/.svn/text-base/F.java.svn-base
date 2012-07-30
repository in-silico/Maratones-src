import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class F 
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
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	public static class Respuesta
	{
		long veces;
		long costo;
		
		public Respuesta(long vv, long cc)
		{
			veces = vv;
			costo = cc;
		}
		
		public Respuesta clonar()
		{
			return new Respuesta(veces, costo);
		}
	}
	
	public static class Arista
	{
		Nodo n;
		int donde;
		int costo;
		
		public Arista(Nodo nodo, int size, int t) 
		{
			n = nodo;
			donde = size;
			costo = t;
		}
	}
	
	public static class Nodo implements Comparable <Nodo>
	{
		int id;
		int v = 0;
		ArrayList <Arista> adjacentes = new ArrayList <Arista> ();
		ArrayList <Respuesta> dp = new ArrayList <Respuesta> ();
		Respuesta todos = new Respuesta(0, 0);
		int faltante = -1;
		
		public Nodo(int i)
		{
			id = i;
			adjacentes.add(null);
		}
		
		public void cerrar()
		{
			for(int i = 0; i <= adjacentes.size(); i++)
				dp.add(null);
		}

		@Override
		public int compareTo(Nodo arg0) 
		{
			return id - arg0.id;
		}
		
		public Respuesta dp(Nodo nA, int donde)
		{
			if(faltante == -2)
			{
				if(donde == 0)
					return todos.clonar();
				Respuesta siguiente = dp.get(donde);
				Respuesta salida = new Respuesta(todos.veces, todos.costo);
				salida.veces -= siguiente.veces;
				salida.costo -= siguiente.costo;
				return salida.clonar();
			}
			else if(faltante >= 0 && adjacentes.get(faltante).n == nA)
				return todos.clonar();
			else if(faltante != -1)
			{
				int temp = faltante;
				faltante = -2;
				Respuesta siguiente = adjacentes.get(temp).n.dp(this, adjacentes.get(temp).donde);
				siguiente.costo += siguiente.veces * adjacentes.get(temp).costo * 2;
				todos.veces += siguiente.veces;
				todos.costo += siguiente.costo;
				dp.set(temp, siguiente);
				return dp(nA, donde).clonar();
			}
			int i = -1;
			for(Arista a : adjacentes)
			{
				if(++i == 0)
					continue;
				if(nA != a.n && i != donde)
				{
					Respuesta siguiente = a.n.dp(this, a.donde);
					siguiente.costo += siguiente.veces * a.costo * 2;
					todos.veces += siguiente.veces;
					todos.costo += siguiente.costo;
					dp.set(i, siguiente);
				}
				else
					faltante = i;
			}
			if(faltante == -1)
				faltante = -2;
			todos.veces += v;
			return todos.clonar();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("F.sal"));
		System.setIn(new FileInputStream("F.in"));
		Scanner sc = new Scanner();
		int c = sc.nextInt();
		Nodo[] todos = new Nodo[50001];
		for(int a = 0; a < c; a++)
		{
			int n = sc.nextInt();
			for(int i = 0; i <= n; i++)
				todos[i] = new Nodo(i);
			for(int i = 0; i < n - 1; i++)
			{
				int aa = sc.nextInt();
				int bb = sc.nextInt();
				int t = sc.nextInt();
				todos[aa].adjacentes.add(new Arista(todos[bb], todos[bb].adjacentes.size(), t));
				todos[bb].adjacentes.add(new Arista(todos[aa], todos[aa].adjacentes.size() - 1, t));
			}
			for(int i = 0; i <= n; i++)
				todos[i].cerrar();
			int m = sc.nextInt();
			for(int i = 0; i < m; i++)
			{
				int aa = sc.nextInt();
				todos[aa].v = sc.nextInt();
			}
			long mejor = Long.MAX_VALUE;
			for(int i = 1; i <= n; i++)
				mejor = Math.min(mejor, todos[i].dp(null, 0).costo);
			boolean ini = false;
			System.out.println(mejor);
			for(int i = 1; i <= n; i++)
			{
				Respuesta r = todos[i].dp(null, 0);
				if(r.costo == mejor)
				{
					if(!ini)
					{
						System.out.print(i);
						ini = true;
					}
					else
						System.out.print(" " + i);
				}
			}
			System.out.println();
		}
		
	}

}
