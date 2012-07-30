import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class F
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
	
	static class Nodo implements Comparable <Nodo>
	{
		int i, j, mejor = Integer.MAX_VALUE;
		boolean posible = true;
		boolean puerta = false;
		int id, jd, t;

		public Nodo(int i2, int j2)
		{
			i = i2;
			j = j2;
		}

		@Override
		public int compareTo(Nodo o) 
		{
			if(mejor == o.mejor)
				if(i == o.i)
					return j - o.j;
				else
					return i - o.i;
			else
				return mejor - o.mejor;
		}
	}
	
	static Nodo[][] nodos;
	static int[][] diffs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int w = sc.nextInt();
			int h = sc.nextInt();
			if(w == 0 && h == 0)
				return;
			nodos = new Nodo[h][w];
			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++)
					nodos[i][j] = new Nodo(i, j);
			int g = sc.nextInt();
			for(int i = 0; i < g; i++)
			{
				int jj = sc.nextInt();
				int ii = sc.nextInt();
				nodos[ii][jj].posible = false;
			}
			int e = sc.nextInt();
			int sumaPuertas = 0;
			for(int i = 0; i < e; i++)
			{
				int jj = sc.nextInt();
				int ii = sc.nextInt();
				Nodo actual = nodos[ii][jj];
				actual.puerta = true;
				actual.jd = sc.nextInt();
				actual.id = sc.nextInt();
				actual.t = sc.nextInt();
				if(actual.t < 0)
					sumaPuertas += actual.t;
			}
			TreeSet <Nodo> pq = new TreeSet <Nodo> ();
			boolean paila = false;
			nodos[0][0].mejor = 0;
			pq.add(nodos[0][0]);
			int mejorNum = Integer.MAX_VALUE;
			while(!pq.isEmpty())
			{
				Nodo actual = pq.pollFirst();
				if(actual.mejor < sumaPuertas)
				{
					paila = true;
					break;
				}
				if(actual.i == h - 1 && actual.j == w - 1)
					mejorNum = Math.min(mejorNum, actual.mejor);
				else if(actual.puerta)
				{
					Nodo siguiente = nodos[actual.id][actual.jd];
					if(actual.mejor + actual.t < siguiente.mejor)
					{
						pq.remove(siguiente);
						siguiente.mejor = actual.mejor + actual.t;
						pq.add(siguiente);
					}
				}
				else
				{
					for(int[] d : diffs)
					{
						int iN = actual.i + d[0];
						int jN = actual.j + d[1];
						if(iN > -1 && iN < h && jN > -1 && jN < w && nodos[iN][jN].posible)
						{
							Nodo siguiente = nodos[iN][jN];
							if(actual.mejor + 1 < siguiente.mejor)
							{
								if(siguiente.puerta)
								{
									pq.remove(siguiente);
									siguiente.mejor = actual.mejor + 1;
									pq.add(siguiente);
								}
								else
								{
									pq.remove(siguiente);
									siguiente.mejor = actual.mejor + 1;
									pq.add(siguiente);
								}
							}
						}
					}
				}
				if(paila)
					break;
			}
			if(paila)
				System.out.println("Never");
			else if(mejorNum == Integer.MAX_VALUE)
				System.out.println("Impossible");
			else
				System.out.println(mejorNum);
		}
	}
}