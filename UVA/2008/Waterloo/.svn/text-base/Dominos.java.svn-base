import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Dominos 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			try {
				br = new BufferedReader(new FileReader("dominos.in"));
			} catch (FileNotFoundException e) {
				throw(new RuntimeException());
				
			}
		}
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw(new RuntimeException());
				}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
	
	static class SCC
	{
		static class Node implements Comparable <Node>
		{
			final int name;
			ArrayList <Node> adjacents = new ArrayList <Node> ();
			boolean visited = false;
			int lowlink = -1;
			int index = -1;
			Componente componente;
			boolean estaEnStack = false;
			
			public Node(final int argName)
			{
				name = argName;
			}

			@Override
			public int compareTo(Node argNode) {
				return argNode == this ? 0 : -1;
			}
		}
		
		static int index = 0;
		static ArrayDeque <Node> stack = new ArrayDeque <Node> ();
		static ArrayList < Componente > SCC = new ArrayList< Componente > ();
		static LinkedList < Estado > cola = new LinkedList < Estado > ();
		
		public static ArrayList < Componente > tarjanSCC(ArrayList <Node> nodes)
		{
			index = 0;
			SCC.clear();
			stack.clear();
			cola.clear();
			for(Node n : nodes)
				if(n.index == -1)
				{
					cola.addFirst(new Estado(n, 0, false));
					while(!cola.isEmpty())
					{
						Estado e = cola.pollFirst();
						tarjan(e.n, e.indice, e.inicio);
					}
				}
			return SCC;
		}

		static class Estado
		{
			Node n;
			int indice;
			boolean inicio;
			
			public Estado(Node n, int indice, boolean inicio) {
				super();
				this.n = n;
				this.indice = indice;
				this.inicio = inicio;
			}
			
		}
		
		static void tarjan(Node v, int actual, boolean inicio) 
		{
			if(inicio)
				v.lowlink = Math.min(v.lowlink, v.adjacents.get(actual - 1).lowlink);
			if(actual == 0)
			{
				v.index = index;
				v.lowlink = index;
				index++;
				stack.push(v);
				v.estaEnStack = true;
			}
			for(int i = actual; i < v.adjacents.size(); i++)
			{
				Node n = v.adjacents.get(i);
				if(n.index == -1)
				{
					cola.addFirst(new Estado(v, i + 1, true));
					cola.addFirst(new Estado(n, 0, false));
					return;
				}
				else if(n.estaEnStack)
					v.lowlink = Math.min(v.lowlink, n.index);
			}
			if(v.lowlink == v.index)
			{
				Componente nuevo = new Componente();
				Node n;
				ArrayList <Node> component = new ArrayList <Node> ();
				do
				{
					n = stack.pop();
					n.estaEnStack = false;
					n.componente = nuevo;
					component.add(n);
				}
				while(n != v);
				nuevo.nodes = component;
				SCC.add(nuevo);
			}
		}
	}	

	static ArrayList<SCC.Node> arreglo = new ArrayList<SCC.Node> ();
	
	static class Componente
	{
		boolean tienePadre = false;
		ArrayList <SCC.Node> nodes;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int caso = 0; caso < t; caso++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			arreglo.clear();
			for(int i = 1; i <= n; i++)
				arreglo.add(new SCC.Node(i));
			for(int i = 0; i < m; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				x--;
				y--;
				arreglo.get(x).adjacents.add(arreglo.get(y));
 			}
			ArrayList < Componente > resultado = SCC.tarjanSCC(arreglo);
			for(Componente c : resultado)
				for(SCC.Node nodo : c.nodes)
					for(SCC.Node otro : nodo.adjacents)
					{
						if(otro.componente != c)
							otro.componente.tienePadre = true;
					}
			int cuenta = 0;
			for(Componente c : resultado)
				if(!c.tienePadre)
					cuenta++;
			System.out.println(cuenta);
		}
	}

}
