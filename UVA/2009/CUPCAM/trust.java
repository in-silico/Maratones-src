import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
	
public class trust 
{
	
	static class Scanner
	{
		static InputStreamReader isr;
		char buffer[];
		int pos = -1, desde, hasta, tam;
		
		public Scanner()
		{
			buffer = new char[250000];
			try 
			{
				isr = new InputStreamReader(System.in);
				isr.read(buffer);
			} 
			catch (IOException e) 
			{
				throw(new RuntimeException());
			}
		}
		
		public void leer()
		{
			try
			{
				while(buffer[++pos] <= ' ');
				desde = pos;
				hasta = desde - 1;
				while(buffer[++hasta] > ' ');
				pos = hasta;
				hasta--;
			}
			catch(Exception e)
			{
				if(pos == buffer.length)
					try
					{
						pos = -1;
						int leidos = isr.read(buffer);
						if(leidos < buffer.length)
							buffer[leidos] = '\0';
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
				else
					try
					{
						int hastaDesde = hasta - desde;
						System.arraycopy(buffer, desde, buffer, 0, hastaDesde);
						int leidos = isr.read(buffer, hastaDesde, buffer.length - hastaDesde);
						if(hastaDesde + leidos < buffer.length)
							buffer[hastaDesde + (leidos == -1 ? 0 : leidos)] = '\0';
						pos = -1;
						desde = 0;
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
			}
		}
		
		public void leerLinea()
		{
			try
			{
				while(buffer[++pos] <= ' ' && buffer[pos] != '\n' && buffer[pos] != '\r');
				if(buffer[pos] == '\n' || buffer[pos] == '\r')
					pos++;
				desde = pos;
				hasta = desde - 1;
				while(buffer[++hasta] != '\n' && buffer[hasta] != '\r');
				pos = hasta;
				hasta--;
			}
			catch(Exception e)
			{
				if(pos == buffer.length)
					try
					{
						pos = -1;
						int leidos = isr.read(buffer);
						if(leidos < buffer.length)
							buffer[leidos] = '\0';
						leerLinea();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
				else
					try
					{
						int hastaDesde = hasta - desde;
						System.arraycopy(buffer, desde, buffer, 0, hastaDesde);
						int leidos = isr.read(buffer, hastaDesde, buffer.length - hastaDesde);
						if(hastaDesde + leidos < buffer.length)
							buffer[hastaDesde + (leidos == -1 ? 0 : leidos)] = '\0';
						pos = -1;
						desde = 0;
						leerLinea();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
			}
		}
		
		public String next()
		{
			leer();
			return new String(buffer, desde, hasta - desde + 1);
		}
		
		public String nextLn()
		{
			leerLinea();
			return new String(buffer, desde, hasta - desde + 1);
		}
		
		public int nextInt()
		{
			leer();
			int resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public long nextLong()
		{
			leer();
			long resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public BigInteger nextBigInteger()
		{
			return new BigInteger(next());
		}
		
		public BigDecimal nextBigDecimal()
		{
			return new BigDecimal(next());
		}
	}
	
	static class Node implements Comparable<Node> {
		   
		   final int name;
		   String nombre;
		   boolean visited = false;   // used for Kosaraju's algorithm and Edmonds's algorithm
		   int lowlink = -1;          // used for Tarjan's algorithm
		   int index = -1;            // used for Tarjan's algorithm
		   
		   public Node(final int argName, String n) {
		       name = argName;
		       nombre = n;
		   }
		   
		   public int compareTo(final Node argNode) {
		       return argNode == this ? 0 : -1;
		   }
		}
	
	static class Edge implements Comparable<Edge> {
		   
		   final Node from, to;
		   final int weight;
		   
		   public Edge(final Node argFrom, final Node argTo, final int argWeight){
		       from = argFrom;
		       to = argTo;
		       weight = argWeight;
		   }
		   
		   public int compareTo(final Edge argEdge){
		       return weight - argEdge.weight;
		   }
		}

	static class AdjacencyList {

	   private Map<Node, ArrayList<Edge>> adjacencies = new HashMap<Node, ArrayList<Edge>>();

	   public void addEdge(Node source, Node target, int weight){
	       ArrayList<Edge> list;
	       if(!adjacencies.containsKey(source)){
	           list = new ArrayList<Edge>();
	           adjacencies.put(source, list);
	       }else{
	           list = adjacencies.get(source);
	       }
	       list.add(new Edge(source, target, weight));
	   }

	   public ArrayList<Edge> getAdjacent(Node source){
	       return adjacencies.get(source) == null ? new ArrayList<Edge>() : adjacencies.get(source);
	   }

	   public void reverseEdge(Edge e){
	       adjacencies.get(e.from).remove(e);
	       addEdge(e.to, e.from, e.weight);
	   }

	   public void reverseGraph(){
	       adjacencies = getReversedList().adjacencies;
	   }

	   public AdjacencyList getReversedList(){
	       AdjacencyList newlist = new AdjacencyList();
	       for(ArrayList<Edge> edges : adjacencies.values()){
	           for(Edge e : edges){
	               newlist.addEdge(e.to, e.from, e.weight);
	           }
	       }
	       return newlist;
	   }

	   public Set<Node> getSourceNodeSet(){
	       return adjacencies.keySet();
	   }

	   public Collection<Edge> getAllEdges(){
	       ArrayList<Edge> edges = new ArrayList<Edge>();
	       for(List<Edge> e : adjacencies.values()){
	           edges.addAll(e);
	       }
	       return edges;
	   }
	}
	


	static int index = 0;
	static ArrayList<Node> stack = new ArrayList<Node>();
	static ArrayList<ArrayList<Node>> SCC = new ArrayList<ArrayList<Node>>();
	public static  ArrayList<ArrayList<Node>> tarjan(Node v, AdjacencyList list){

		v.index = index;
		v.lowlink = index;
		index++;
		stack.add(0, v);
		for(Edge e : list.getAdjacent(v)){
			Node n = e.to;
			if(n.index == -1){
				tarjan(n, list);
				v.lowlink = Math.min(v.lowlink, n.lowlink);
			}else if(stack.contains(n)){
				v.lowlink = Math.min(v.lowlink, n.index);
			}
		}
		if(v.lowlink == v.index){
			Node n;
			ArrayList<Node> component = new ArrayList<Node>();
			do{
				n = stack.remove(0);
				component.add(n);
			}while(n != v);
			SCC.add(component);
		}
		return SCC;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{	
		Scanner sc = new Scanner();
		while(true)
		{
			index = 0;
			stack = new ArrayList<Node>();
			SCC = new ArrayList<ArrayList<Node>>();
			int p = sc.nextInt();
			int t = sc.nextInt();
			if(p == t && p == 0)
				return;
			Node[] nodos = new Node[p];
			Hashtable <String, Node> hash = new Hashtable <String, Node> (p);
			for(int i = 0; i < p; i++)
			{
				nodos[i] = new Node(i, sc.nextLn());
				hash.put(nodos[i].nombre, nodos[i]);
			}
			AdjacencyList al = new AdjacencyList();
			for(int i = 0; i < t; i++)
			{
				al.addEdge(hash.get(sc.nextLn()), hash.get(sc.nextLn()), 1);
			}
			for(int i = 0; i < p; i++)
			{
				if(nodos[i].index == -1)
					tarjan(nodos[i], al);
			}
			System.out.println(SCC.size());
		}
		
	}
}
