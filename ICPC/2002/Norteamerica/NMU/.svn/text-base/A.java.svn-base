import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class A
{
	
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
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
	}
	
	static class Posicion implements Comparable <Posicion>
	{
		int x, y, patron, paso;
		
		public Posicion(int xx, int yy, int patronP, int pasoP)
		{
			x = xx;
			y = yy;
			patron = patronP;
			paso = pasoP;
		}

		@Override
		public int compareTo(Posicion o) 
		{
			if(x != o.x)
				return Integer.valueOf(x).compareTo(o.x);
			if(y != o.y)
				return Integer.valueOf(y).compareTo(o.y);
			return Integer.valueOf(patron).compareTo(o.patron);
		}
		
		@Override
		public boolean equals(Object obj) 
		{
			Posicion otra = (Posicion) obj;
			return compareTo(otra) == 0;
		}
	}
	
	static ArrayList <boolean[][]> patrones = new ArrayList <boolean[][]> (); 
	static TreeSet <Posicion> visitados = new TreeSet <Posicion> ();
	static LinkedList <Posicion> actuales = new LinkedList <Posicion> ();
	static int height, width;
	
	static int bfs()
	{
		Posicion inicial = new Posicion(0, 0, 0, 0);
		actuales.add(inicial);
		while(!actuales.isEmpty())
		{
			Posicion actual = actuales.pollFirst();
			if(visitados.contains(actual))
				continue;
			visitados.add(actual);
			boolean[][] patron = patrones.get(actual.patron);
			if(patron[actual.x][actual.y])
				continue;
			if(actual.x == height - 1 && actual.y == width - 1)
				return actual.paso;
			if(actual.x != 0)
			{
				Posicion nueva = new Posicion(actual.x - 1, actual.y, (actual.patron + 1) % patrones.size(), actual.paso + 1);
				if(!visitados.contains(nueva))
					actuales.add(nueva);
			}
			if(actual.x != height - 1)
			{
				Posicion nueva = new Posicion(actual.x + 1, actual.y, (actual.patron + 1) % patrones.size(), actual.paso + 1);
				if(!visitados.contains(nueva))
					actuales.add(nueva);
			}
			if(actual.y != 0)
			{
				Posicion nueva = new Posicion(actual.x, actual.y - 1, (actual.patron + 1) % patrones.size(), actual.paso + 1);
				if(!visitados.contains(nueva))
					actuales.add(nueva);
			}
			if(actual.y != width - 1)
			{
				Posicion nueva = new Posicion(actual.x, actual.y + 1, (actual.patron + 1) % patrones.size(), actual.paso + 1);
				if(!visitados.contains(nueva))
					actuales.add(nueva);
			}
			Posicion nueva = new Posicion(actual.x, actual.y, (actual.patron + 1) % patrones.size(), actual.paso + 1);
			if(!visitados.contains(nueva))
				actuales.add(nueva);
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int cuenta = 1;
		while(true)
		{
			height = sc.nextInt();
			width = sc.nextInt();
			patrones.clear();
			int nPatrones = sc.nextInt();
			if(height == 0)
				return;
			for(int i = 0; i < nPatrones; i++)
			{
				boolean[][] nuevo = new boolean[height][width];
				for(int j = 0; j < height; j++)
				{
					char[] c = sc.next().toCharArray();
					for(int k = 0; k < width; k++)
						nuevo[j][k] = c[k] == '1';
				}
				patrones.add(nuevo);
			}
			visitados.clear();
			actuales.clear();
			int n = bfs();
			System.out.print("Case " + cuenta++ + ":");
			if(n == -1)
			{
				System.out.println("Luke and Leia cannot escape.");
			}
			else
			{
				System.out.println("Luke and Leia can escape in " + n + " steps.");
			}
		}
	}
}
