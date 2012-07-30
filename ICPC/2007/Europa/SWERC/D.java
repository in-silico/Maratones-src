import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D 
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
		
		public long nextLong()
		{
			return Long.parseLong(next());
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
	
	static int h, w;
	static Celda[][] mapa = new Celda[305][305];
	static boolean[][][][] visitados = new boolean[305][305][6][7];
	
	static class Celda
	{
		boolean libre;
		boolean poderes;
		int m;
		int n;
		
		public Celda(boolean libre, boolean poderes, int m, int n)
		{
			this.libre = libre;
			this.poderes = poderes;
			this.m = m;
			this.n = n;
		}
	}
	
	static class Entrada implements Comparable <Entrada>
	{
		int i;
		int j;
		int m;
		int n;
		int p;
		
		public Entrada(int i, int j, int m, int n, int p)
		{
			this.i = i;
			this.j = j;
			this.m = m;
			this.n = n;
			this.p = p;
		}

		@Override
		public int compareTo(Entrada o) 
		{
			return p - o.p;
		}
	}

	static PriorityQueue <Entrada> cola = new PriorityQueue <Entrada> ();
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 305; i++)
			for(int j = 0; j < 305; j++)
				mapa[i][j] = new Celda(false, false, 0, 0);
		Scanner sc = new Scanner();
		int tc = sc.nextInt();
		for(int caso = 0; caso < tc; caso++)
		{
			if(caso != 0)
				System.out.println();
			h = sc.nextInt();
			w = sc.nextInt();
			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++)
				{
					for(int k = 0; k < 6; k++)
						for(int l = 0; l < 7; l++)
							visitados[i][j][k][l] = false;
					int v = sc.nextInt();
					Celda actual = mapa[i][j];
					if(v == 0)
					{
						actual.libre = false;
						actual.poderes = false;
						actual.m = 0;
						actual.n = 0;
					}
					else if(v == 1)
					{
						actual.libre = true;
						actual.poderes = false;
						actual.m = 0;
						actual.n = 0;
					}
					else
					{
						actual.libre = true;
						actual.poderes = true;
						actual.m = v / 10;
						actual.n = v % 10;
					}
				}
			int ii = sc.nextInt();
			int ij = sc.nextInt();
			int fi = sc.nextInt();
			int fj = sc.nextInt();
			visitados[ii][ij][0][0] = true;
			cola.clear();
			cola.add(new Entrada(ii, ij, 0, 0, 0));
			boolean termino = false;
			if(mapa[ii][ij].libre)
			{
				while(!cola.isEmpty())
				{
					Entrada actual = cola.poll();
					Celda c = mapa[actual.i][actual.j];
					if(actual.i == fi && actual.j == fj)
					{
						System.out.println(actual.p);
						termino = true;
						break;
					}
					if(c.poderes)
						generarVecinos(actual.i, actual.j, c.m, c.n, actual.p);
					else
						generarVecinos(actual.i, actual.j, actual.m, actual.n, actual.p);
				}
			}
			if(!termino)
				System.out.println("IMPOSSIBLE");
		}
	}

	private static void intentar(int i, int j, int m, int n, int deltaI, int deltaJ, int p)
	{
		if(i + deltaI < h && i + deltaI >= 0 && j + deltaJ < w && j + deltaJ >= 0 &&
				mapa[i + deltaI][j + deltaJ].libre && !visitados[i + deltaI][j + deltaJ][m][n])
		{
			visitados[i + deltaI][j + deltaJ][m][n] = true;
			cola.add(new Entrada(i + deltaI, j + deltaJ, m, n, p + 1));
		}
	}
	
	private static void generarVecinos(int i, int j, int m, int n, int p) 
	{
		if(m == 0)
		{
			intentar(i, j, 0, 0, 1, 0, p);
			intentar(i, j, 0, 0, -1, 0, p);
			intentar(i, j, 0, 0, 0, 1, p);
			intentar(i, j, 0, 0, 0, -1, p);
		}
		else
		{
			int nNuevo = n;
			m--;
			int mAnt = m;
			for(m = mAnt; m >= 0; m -= 2)
			{
				if(m == 0)
					nNuevo = 0;
				intentar(i, j, m, nNuevo, n, 0, p + mAnt - m);
				intentar(i, j, m, nNuevo, -n, 0, p + mAnt - m);
				intentar(i, j, m, nNuevo, 0, n, p + mAnt - m);
				intentar(i, j, m, nNuevo, 0, -n, p + mAnt - m);
			}
		}
	}
}