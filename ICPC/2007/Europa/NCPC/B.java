import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bipartite_Matching
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
	
	static class Edge 
	{
		int from, to, cap, flow, index;

		Edge(int fromi, int toi, int capi, int flowi, int indexi)
		{
			from = fromi;
			to = toi;
			cap = capi;
			flow = flowi;
			index = indexi;
		}
	}

	static class PushRelabel 
	{
		int N;
		ArrayList < ArrayList <Edge> > G;
		long[] excess;
		int[] dist, count;
		boolean[] active;
		LinkedList <Integer> Q = new LinkedList <Integer> ();

		PushRelabel(int N1)
		{
			N = N1;
			G = new ArrayList < ArrayList <Edge> > (N);
			for(int i = 0; i < N; i++)
				G.add(new ArrayList <Edge> ());
			excess = new long[N];
			dist = new int[N];
			active = new boolean[N];
			count = new int[2 * N];
		}
		
		void clear(int n)
		{
			N = n;
			for(int i = 0; i < N; i++)
				G.get(i).clear();
			for(int i = 0; i < N; i++)
			{
				excess[i] = 0;
				dist[i] = 0;
				active[i] = false;
			}
			int dosN = 2 * N;
			for(int i = 0; i < dosN; i++)
				count[i] = 0;
		}

		void AddEdge(int from, int to, int cap) 
		{
			int cambio = from == to ? 1 : 0;
			G.get(from).add(new Edge(from, to, cap, 0, G.get(to).size() + cambio));
			G.get(to).add(new Edge(to, from, 0, 0, G.get(from).size() - 1));
		}

		void Enqueue(int v) 
		{ 
			if (!active[v] && excess[v] > 0)
			{ 
				active[v] = true;
				Q.add(v); 
			} 
		}

		void Push(Edge e) 
		{
			long amt = Math.min(excess[e.from], e.cap - e.flow);
			if(dist[e.from] <= dist[e.to] || amt == 0) 
				return;
			e.flow += amt;
			G.get(e.to).get(e.index).flow -= amt;
			excess[e.to] += amt; 
			excess[e.from] -= amt;
			Enqueue(e.to);
		}

		void Gap(int k) 
		{
			for(int v = 0; v < N; v++) 
			{
				if(dist[v] < k) 
					continue;
				count[dist[v]]--;
				dist[v] = Math.max(dist[v], N + 1);
				count[dist[v]]++;
				Enqueue(v);
			}
		}

		void Relabel(int v) 
		{
			count[dist[v]]--;
			dist[v] = 2 * N;
			for (Edge e : G.get(v)) 
				if (e.cap - e.flow > 0)
					dist[v] = Math.min(dist[v], dist[e.to] + 1);
			count[dist[v]]++;
			Enqueue(v);
		}

		void Discharge(int v) 
		{
			for(Edge e : G.get(v))
			{
				if(excess[v] <= 0)
					break;
				Push(e);
			}
			if(excess[v] > 0) 
			{
				if(count[dist[v]] == 1) 
					Gap(dist[v]); 
				else
					Relabel(v);
			}
		}

		long GetMaxFlow(int s, int t)
		{
			count[0] = N - 1;
			count[N] = 1;
			dist[s] = N;
			active[s] = active[t] = true;
			for (Edge e : G.get(s)) 
			{
				excess[s] += e.cap;
				Push(e);
			}
			while (!Q.isEmpty()) 
			{
				int v = Q.poll();
				active[v] = false;
				Discharge(v);
			}
			long totflow = 0;
			for (Edge e : G.get(s)) 
				totflow += e.flow;
			return totflow;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("cuckoo.in"));
		Scanner sc = new Scanner();
		int l = sc.nextInt();
		PushRelabel solucion = new PushRelabel(20001);
		for(int caso = 0; caso < l; caso++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			solucion.clear(n + m + 2);
			for(int i = 0; i < n; i++)
			{
				int nuevo = sc.nextInt();
				solucion.AddEdge(i, n + nuevo, 1);
				nuevo = sc.nextInt();
				solucion.AddEdge(i, n + nuevo, 1);
				solucion.AddEdge(n + m, i, 1);
			}
			for(int i = 0; i < m; i++)
				solucion.AddEdge(n + i, n + m + 1, 1);
			int res = (int) solucion.GetMaxFlow(n + m, n + m + 1);
			System.out.println(res == n ? "successful hashing" : "rehash necessary");
		}
	}
}
