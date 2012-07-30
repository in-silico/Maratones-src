import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class tractor
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
	
	static class Entrada implements Comparable <Entrada>
	{
		int x, y, veces;

		Entrada(int x, int y, int veces) 
		{
			this.x = x;
			this.y = y;
			this.veces = veces;
		}

		@Override
		public int compareTo(Entrada o) 
		{
			return veces - o.veces;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream("tractor.out"));
		System.setIn(new FileInputStream("tractor.in"));
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		int xi = sc.nextInt();
		int yi = sc.nextInt();
		int[][] visitados = new int[1002][1002];
		for(int i = 0; i < 1002; i++)
			for(int j = 0; j < 1002; j++)
				visitados[i][j] = Integer.MAX_VALUE;
		boolean[][] bloqueados = new boolean[1002][1002];
		for(int i = 0; i < n; i++)
			bloqueados[sc.nextInt()][sc.nextInt()] = true;
		PriorityQueue <Entrada> pq = new PriorityQueue <Entrada> ();
		visitados[xi][yi] = 0;
		pq.add(new Entrada(xi, yi, 0));
		int[][] deltas = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while(!pq.isEmpty())
		{
			Entrada actual = pq.poll();
			if(actual.veces > visitados[actual.x][actual.y])
				continue;
			if(actual.x == 0 && actual.y == 0)
			{
				System.out.println(actual.veces);
				return;
			}
			for(int[] c : deltas)
			{
				int xNuevo = actual.x + c[0];
				int yNuevo = actual.y + c[1];
				if(xNuevo < 0 || xNuevo >= 1002 || yNuevo < 0 || yNuevo >= 1002)
					continue;
				int vecesNuevo = actual.veces + (bloqueados[xNuevo][yNuevo] ? 1 : 0);
				if(visitados[xNuevo][yNuevo] <= vecesNuevo)
					continue;
				visitados[xNuevo][yNuevo] = vecesNuevo;
				pq.add(new Entrada(xNuevo, yNuevo, vecesNuevo));
			}
		}
	}
}