import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class justice
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
	
	static class Node implements Comparable <Node>
	{
		   final int name;
		   ArrayList <Node> adjacents = new ArrayList <Node> (100);
		   int set;
		   boolean esta;
		   boolean enCola = false;
		   
		   public Node(int n)
		   {
			   name = n;
		   }

		@Override
		public int compareTo(Node o) 
		{
			return name - o.name;
		}
		
		@Override
		public int hashCode() 
		{
			return name;
		}
		
		@Override
		public boolean equals(Object obj) 
		{
			return obj == this;
		}
	}
	
	
	static Node[] nodes = new Node[50002];
	static HashMap <Node, Node> a = new HashMap <Node, Node> ();
	
	static boolean procesar(int h)
	{
		a.clear();
		for(int i = 1; i <= h; i++)
		{
			if(nodes[i].set != 0)
				continue;
			int inA = 0;
			int inB = 0;
			for(Node n : nodes[i].adjacents)
			{
				if(n.set == 1)
					inA++;
				if(n.set == 2)
					inB++;
			}
			if(inA == a.size())
			{
				nodes[i].set = 1;
				a.put(nodes[i], nodes[i]);
			}
			else if(inB == 0)
				nodes[i].set = 2;
			else if(inA == a.size() - 1)
			{
				for(Node n : a.keySet())
					n.esta = true;
				for(Node n : nodes[i].adjacents)
					n.esta = false;
				for(Node n : a.keySet())
					if(n.esta)
					{
						nodes[i].set = 1;
						a.put(nodes[i], nodes[i]);
						if(!poner(n, 2))
							return false;
						break;
					}
			}
			else if(inB == 1)
			{
				nodes[i].set = 2;
				for(Node n : nodes[i].adjacents)
					if(n.set == 2)
					{
						if(!poner(n, 1))
							return false;
						break;
					}
			}
			else
				return false;
		}
		return true;
	}
	
	private static boolean poner(Node q, int set) 
	{
		if(q.enCola)
			return false;
		q.enCola = true;
		try
		{
			if(set == 1)
			{
				int inA = 0;
				for(Node ad : q.adjacents)
				{
					if(ad.set == 1)
						inA++;
				}
				if(inA == a.size())
				{
					q.set = 1;
					a.put(q, q);
					return true;
				}
				else if(inA == a.size() - 1)
				{
					for(Node n : a.keySet())
						n.esta = true;
					for(Node n : q.adjacents)
						n.esta = false;
					for(Node n : a.keySet())
						if(n.esta)
						{
							q.set = 1;
							a.put(q, q);
							return poner(n, 2);
						}
					return false;
				}
				else
					return false;
			}
			else
			{
				int inB = 0;
				for(Node ad : q.adjacents)
				{
					if(ad.set == 2)
						inB++;
				}
				if(inB == 0)
				{
					q.set = 2;
					a.remove(q);
					return true;
				}
				else if(inB == 1)
				{
					q.set = 2;
					a.remove(q);
					for(Node n : q.adjacents)
						if(n.set == 2)
							return poner(n, 1);
					return false;
				}
				else
					return false;
			}
		}
		finally
		{
			q.enCola = false;
		}
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner();
		for(int i = 1; i <= 50000; i++)
			nodes[i] = new Node(i);
		while(true)
		{
			int h = sc.nextInt();
			int r = sc.nextInt();
			if(h == 0 && r == 0)
				return;
			for(int i = 1; i <= h; i++)
			{
				nodes[i].adjacents.clear();
				nodes[i].set = 0;
			}
			for(int i = 0; i < r; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				nodes[a].adjacents.add(nodes[b]);
				nodes[b].adjacents.add(nodes[a]);
			}
			if(procesar(h))
				System.out.println("Y");
			else
				System.out.println("N");
		}
	}
}