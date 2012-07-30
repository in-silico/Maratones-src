import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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
	
	static Stack <String> stack = new Stack <String> ();
	static Arbol nulo = new Arbol("", null, null);
	
	static int idS = 0;
	static class Arbol
	{
		int id = idS++;
		Arbol derecho;
		Arbol izquierdo;
		String este;
		TreeMap <Integer, Boolean> iguales = new TreeMap <Integer, Boolean> ();
		
		Arbol(String e, Arbol d, Arbol i)
		{
			este = e;
			derecho = d;
			izquierdo = i;
		}
		
		boolean igual(Arbol otro)
		{
			if(this == nulo)
				return otro == nulo;
			if(iguales.containsKey(otro.id))
				return iguales.get(otro.id);
			if(!este.equals(otro.este))
			{
				iguales.put(otro.id, false);
				return false;
			}
			if(izquierdo.igual(otro.izquierdo) && derecho.igual(otro.derecho))
			{
				iguales.put(otro.id, true);
				return true;
			}
			if(derecho.igual(otro.izquierdo) && izquierdo.igual(otro.derecho))
			{
				iguales.put(otro.id, true);
				return true;
			}
			iguales.put(otro.id, false);
			return false;
		}
	}
	
	static Arbol leer()
	{
		String este = stack.pop();
		if(este.equals("nil"))
			return nulo;
		Arbol derecha = leer();
		Arbol izquierda = leer();
		return new Arbol(este, derecha, izquierda);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Scanner sc = new Scanner();
		int d = Integer.parseInt(sc.br.readLine().trim());
		for(int i = 0; i < d; i++)
		{
			while(true)
			{
				String entrada = sc.next();
				if(entrada.equals("end"))
					break;
				stack.push(entrada);
			}
			Arbol a = leer();
			stack.clear();
			while(true)
			{
				String entrada = sc.next();
				if(entrada.equals("end"))
					break;
				stack.push(entrada);
			}
			Arbol b = leer();
			if(a.igual(b))
			{
				System.out.println("true");
			}
			else
			{
				System.out.println("false");
			}
		}
	}

}
