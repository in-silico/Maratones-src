import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class A 
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
	
	static class Grupo
	{
		ArrayList <Grupo> grupos = new ArrayList <Grupo> ();
		TreeSet <String> otros = new TreeSet <String> ();
		String nombre;
		String faltante;
		TreeSet <String> dp = null;
		
		public TreeSet <String> dp()
		{
			if(dp != null)
				return dp;
			TreeSet <String> tod = new TreeSet <String> ();
			for(Grupo g : grupos)
				tod.addAll(g.dp());
			tod.addAll(otros);
			return dp = tod;
		}
	}
	
	static Grupo leerGrupo()
	{
		Grupo g = new Grupo();
		String entrada = sc.next();
		String[] pedazos = entrada.split("\\:");
		g.nombre = pedazos[0];
		g.faltante = pedazos[1].substring(0, pedazos[1].length() - 1);
		return g;
	}
	
	static Scanner sc = new Scanner();
	
	public static void main(String[] args)
	{
		ArrayList <Grupo> grupos = new ArrayList <Grupo> (101);
		HashMap <String, Grupo> gruposN = new HashMap <String, Grupo> (101);
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;	
			grupos.clear();
			gruposN.clear();
			for(int i = 0; i < n; i++)
			{
				Grupo nuevo = leerGrupo();
				gruposN.put(nuevo.nombre, nuevo);
				grupos.add(nuevo);
			}
			for(int i = 0; i < n; i++)
			{
				Grupo actual = grupos.get(i);
				String[] pedazos = actual.faltante.split(",");
				for(String s : pedazos)
				{
					if(gruposN.containsKey(s))
						actual.grupos.add(gruposN.get(s));
					else
						actual.otros.add(s);
				}
			}
			System.out.println(grupos.get(0).dp().size());
		}
	}

}
