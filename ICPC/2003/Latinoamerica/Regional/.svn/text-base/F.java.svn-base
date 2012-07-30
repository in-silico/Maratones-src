import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class F
{
	static class Producto
	{
		Node t;
		Node f;
		Boolean fijo;

		public Producto(int nombre)
		{
			t = new Node(nombre);
			f = new Node(nombre);
		}
	}

	static class Node implements Comparable <Node> 
	{
		   final int name;
		   ArrayList <Node> adjacents = new ArrayList <Node> (100);
		   boolean visited = false; 
		   int lowlink = -1;  
		   int index = -1;    
		   
		   public Node(final int argName) 
		   {
		       name = argName;
		   }
		   
		   public int compareTo(final Node argNode) 
		   {
		       return argNode == this ? 0 : -1;
		   }
	}
	
	static int index = 0;
	static ArrayDeque <Node> stack = new ArrayDeque <Node> ();
	static ArrayList <ArrayList <Node> > SCC = new ArrayList <ArrayList <Node> > ();
	
	public static ArrayList < ArrayList <Node> > SCC(Producto[] productos, int size)
	{
		index = 0;
		SCC.clear();
		stack.clear();
		for(int i = 1; i < size; i++)
		{
			if(productos[i].t.index == -1)
				tarjan(productos[i].t);
		}		
		for(int i = 1; i < size; i++)
		{
			if(productos[i].f.index == -1)
				tarjan(productos[i].f);
		}
		return SCC;
	}
	
	public static void tarjan(Node v)
	{
		v.index = index;
		v.lowlink = index;
		index++;
		stack.push(v);
		for(Node n : v.adjacents)
		{
			if(n.index == -1)
			{
				tarjan(n);
				v.lowlink = Math.min(v.lowlink, n.lowlink);
			}
			else if(stack.contains(n))
				v.lowlink = Math.min(v.lowlink, n.index);
		}
		if(v.lowlink == v.index)
		{
			Node n;
			ArrayList <Node> component = new ArrayList <Node> ();
			do
			{
				n = stack.pop();
				component.add(n);
			}
			while(n != v);
			SCC.add(component);
		}
	}
	
	static Producto[] productos = new Producto[10001];
	static TreeSet <Integer> inComponent = new TreeSet <Integer> ();
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i < 10001; i++)
			productos[i] = new Producto(i);
		while(true)
		{
			int q = sc.nextInt();
			int p = sc.nextInt();
			if(q == 0 && p == 0)
				return;
			for(int i = 1; i <= p; i++)
				productos[i] = new Producto(i);
			boolean isPossible = true;
			for(int i = 0; i < q; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int d = sc.nextInt();
				if(a == 0)
					a = b;
				if(b == 0)
					b = a;
				if(c == 0)
					c = d;
				if(d == 0)
					d = c;
				if(a != 0)
				{
					productos[a].f.adjacents.add(productos[b].t);
					productos[b].f.adjacents.add(productos[a].t);
				}
				if(c != 0)
				{
					productos[c].t.adjacents.add(productos[d].f);
					productos[d].t.adjacents.add(productos[c].f);
				}
			}
			ArrayList < ArrayList <Node> > scc = SCC(productos, p + 1);
			for(ArrayList <Node> a : scc)
			{
				inComponent.clear();
				for(Node node : a)
				{
					int name = node.name;
					if(inComponent.contains(name))
					{
						isPossible = false;
						break;
					}
					inComponent.add(name);
				}
				if(!isPossible)
					break;
			}
			System.out.println(isPossible ? "yes" : "no");
		}
	}
}
