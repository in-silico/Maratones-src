import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;


public class Cargo
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

	static int n;
	static int q;
	static int s;
	static int nCargas;
	@SuppressWarnings("unchecked")
	static Deque <Integer> [] queues = new Deque[100];
	
	public static int simular()
	{
		int entregadas = 0;
		int tiempo = -2;
		Stack <Integer> stack = new Stack <Integer> ();
		int actual = -1;
		while(entregadas != nCargas)
		{
			tiempo += 2;
			actual++;
			if(actual == n)
				actual = 0;
			Deque <Integer> qActual = queues[actual];
			while(!stack.isEmpty())
			{
				int siguiente = stack.pop();
				if(siguiente == actual)
				{
					entregadas++;
					tiempo++;
				}
				else if(qActual.size() != q)
				{
					tiempo++;
					qActual.addLast(siguiente);
				}
				else
				{
					stack.push(siguiente);
					break;
				}
			}
			while(stack.size() != s && qActual.size() != 0)
			{
				stack.push(qActual.pollFirst());
				tiempo++;
			}
		}
		return tiempo < 0 ? 0 : tiempo;
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 100; i++)
			queues[i] = new ArrayDeque <Integer> ();
		Scanner sc = new Scanner();
		int nCasos = sc.nextInt();
		while(nCasos-- != 0)
		{
			n = sc.nextInt();
			s = sc.nextInt();
			q = sc.nextInt();
			for(int i = 0; i < n; i++)
				queues[i].clear();
			nCargas = 0;
			for(int i = 0; i < n; i++)
			{
				int nC = sc.nextInt();
				nCargas += nC;
				for(int j = 0; j < nC; j++)
					queues[i].addLast(sc.nextInt() - 1);
			}
			System.out.println(simular());
		}
	}

}
