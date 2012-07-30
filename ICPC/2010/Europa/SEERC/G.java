import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
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
	
	public static class Entry implements Comparable <Entry>
	{
		int llave;
		int valor;
		
		public Entry(int llave, int valor) 
		{
			this.llave = llave;
			this.valor = valor;
		}

		@Override
		public int compareTo(Entry o) 
		{
			return valor - o.valor;
		}
	}
	
	public static class Modulo
	{
		boolean enArbol = false;
		Entry[] distancias = new Entry[n];
		int[] distanciasI = new int[n];
	}
	
	static Modulo[] modulos = new Modulo[1024];
	static int n;
	
	static class Nodo
	{
		Integer modulo;
		LinkedList <Nodo> siguientes = new LinkedList <Nodo> ();
		
		public void crearHijo(int valor, int altura) 
		{
			if(altura == 0)
				modulo = valor;
			else	
			{
				Nodo p = new Nodo();
				p.crearHijo(valor, altura - 1);
				siguientes.add(p);
			}
		}

		public Nodo buscar(Nodo anterior, int destino, int altura) 
		{
			if(modulo != null && modulo != 0)
				return modulo == destino ? this : null;
			for(Nodo n : siguientes)
			{
				if(n == anterior)
					continue;
				Nodo posible = n.buscar(this, destino, altura - 1);
				if(posible != null)
				{
					if(altura == 0)
						return this;
					else
						return posible;
				}
			}
			return null;
		}
		
		public int tamano(Nodo anterior)
		{
			int acum = 1;
			for(Nodo n : siguientes)
				acum += n.tamano(this);
			return acum;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 0; caso < t; caso++)
		{
			n = sc.nextInt();
			for(int i = 0; i < n; i++)
				modulos[i] = new Modulo();
			for(int i = 0; i < n; i++)
			{
				modulos[i].distancias[i] = new Entry(0, 1000000000);
				for(int j = i + 1; j < n; j++)
				{
					int dis = sc.nextInt();
					modulos[i].distancias[j] = new Entry(j, dis);
					modulos[i].distanciasI[j] = dis;
					modulos[j].distancias[i] = new Entry(i, dis);
					modulos[j].distanciasI[i] = dis;
				}
			}
			Arrays.sort(modulos[0].distancias);
			Nodo inicial = new Nodo();
			inicial.modulo = 0;
			int puestos = 1;
			for(Entry e : modulos[0].distancias)
			{
				if(e.llave == 0)
					continue;
				if(puestos == 1)
				{
					inicial.crearHijo(e.llave, e.valor);
					modulos[e.llave].enArbol = true;
					puestos++;
				}
				else
				{
					int aPoner = e.llave;
					int mejorComun = -1;
					int llaveMejor = 0;
					for(Entry e1 : modulos[aPoner].distancias)
					{
						if(modulos[e1.llave].enArbol)
						{
							int comun = modulos[0].distanciasI[e1.llave] + modulos[0].distanciasI[aPoner] - modulos[e1.llave].distanciasI[aPoner];
							if(comun > mejorComun)
							{
								llaveMejor = e1.llave;
								mejorComun = comun;
							}	
						}
					}
					int altura = modulos[0].distanciasI[aPoner] + modulos[llaveMejor].distanciasI[aPoner] - modulos[0].distanciasI[llaveMejor];
					altura >>= 1;
					int comun = modulos[0].distanciasI[llaveMejor] + modulos[0].distanciasI[aPoner] - modulos[llaveMejor].distanciasI[aPoner];
					comun >>= 1;
					Nodo d = inicial.buscar(null, llaveMejor, comun);
					d.crearHijo(aPoner, altura);
					modulos[aPoner].enArbol = true;
					puestos++;
				}
			}
			System.out.println(inicial.tamano(null) - n);
		}
	}
}
