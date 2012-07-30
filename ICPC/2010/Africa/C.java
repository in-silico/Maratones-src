import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class C 
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
	
	static LinkedList <Character> caracteres = new LinkedList <Character> ();
	
	
	static class Nodo
	{
		static int mejorAltura = 0;
		int altura;
		ArrayList <Nodo> hijos = new ArrayList <Nodo> ();
		char c = '0';
		Boolean and = null;
		
		public Nodo(char cc)
		{
			c = cc;
		}
		
		public Nodo()
		{
		}
		
		public int calcularAltura(int anterior)
		{
			if(c != '0')
			{
				altura = anterior;
				return 0;
			}
			int mejor = 0;
			for(Nodo n : hijos)
				mejor = Math.max(mejor, 1 + n.calcularAltura(anterior + 1));
			altura = anterior;
			return mejor;
		}
		
		public Boolean encontrar()
		{
			if(and != null)
				return and;
			if(hijos.isEmpty())
				return null;
			for(Nodo n : hijos)
				if(n.encontrar() != null)
					return and = !n.encontrar();
			if(mejorAltura - 1 == altura)
				and = true;
			return and;
		}
		
		public void actualizar(boolean cual)
		{
			if(hijos.size() == 0)
				return;
			and = cual;
			for(Nodo n : hijos)
				n.actualizar(!cual);
		}
		
		public boolean evaluar()
		{
			if(c != '0')
				return c == 'T';
			boolean valor = true;
			if(and)
			{
				valor = true;
				for(Nodo n : hijos)
					valor = valor && n.evaluar();
			}
			else
			{
				valor = false;
				for(Nodo n : hijos)
					valor = valor || n.evaluar();
			}
			return valor;
		}
		
		public static Nodo leerNodo()
		{
			Nodo nuevo = new Nodo();
			caracteres.poll();
			while(caracteres.peek() != ')')
			{
				if(caracteres.peek() == '(')
					nuevo.hijos.add(leerNodo());
				else
					nuevo.hijos.add(new Nodo(caracteres.poll()));
			}
			caracteres.poll();
			return nuevo;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int caso = 1;
		while(true)
		{
			String entrada = sc.next();
			if(entrada.equals("()"))
					return;
			caracteres.clear();
			for(char c : entrada.toCharArray())
				caracteres.add(c);
			Nodo padre = Nodo.leerNodo();
			Nodo.mejorAltura = padre.calcularAltura(0);
			boolean cual = padre.encontrar();
			padre.actualizar(cual);
			System.out.println(caso++ + ". " + (padre.evaluar() ? "true" : "false"));
			
		}
	}
}
