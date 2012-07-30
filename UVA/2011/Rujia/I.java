import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out, 5000000)));
			br = new BufferedReader(new InputStreamReader(System.in), 5000000);
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
	
	static class Integer2 implements Comparable<Integer2>
	{
		int num;

		public Integer2(int n)
		{
			num = n;
		}
		
		@Override
		public int compareTo(Integer2 o) 
		{
			return o.num - num;
		}
		
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		PriorityQueue <Integer2> pq = new PriorityQueue <Integer2> ();
		Stack <Integer> st = new Stack <Integer> ();
		Queue <Integer> q = new LinkedList<Integer>();
		while(true)
		{
			pq.clear();
			st.clear();
			q.clear();
			int n;
			try
			{
				n = sc.nextInt();
			}
			catch(Exception e)
			{
				System.out.flush();
				return;
			}
			boolean priority = true;
			boolean stack = true;
			boolean queue = true;
			for(int i = 0; i < n; i++)
			{
				int com = sc.nextInt();
				int res = sc.nextInt();
				if(com == 1)
				{
					pq.add(new Integer2(res));
					st.push(res);
					q.add(res);
				}
				else
				{
					if(!pq.isEmpty())
					{
						if(pq.poll().num != res)
							priority = false;
					}
					else
						priority = false;
					if(!st.isEmpty())
					{
						if(st.pop() != res)
							stack = false;
					}
					else
						stack = false;
					if(!q.isEmpty())
					{
						if(q.poll() != res)
							queue = false;
					}
					else
						queue = false;		
				}
			}
			int cuenta = 0;
			if(queue)
				cuenta++;
			if(stack)
				cuenta++;
			if(priority)
				cuenta++;
			if(cuenta == 0)
				System.out.println("impossible");
			else if(cuenta == 1)
			{
				if(queue)
					System.out.println("queue");
				if(priority)
					System.out.println("priority queue");
				if(stack)
					System.out.println("stack");
					
			}
			else if(cuenta > 1)
				System.out.println("not sure");
		}
	}

}
